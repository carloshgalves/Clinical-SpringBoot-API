package med.voll.api.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.voll.api.domain.patient.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/patients")
public class PatientController {

    @Autowired
    private PatientRepository patientRepository;

    @PostMapping
    @Transactional
    public ResponseEntity registerPatient(@RequestBody @Valid RegisteredPatientDTO patientDTO, UriComponentsBuilder uriBuilder) {
        var patient = new Patient(patientDTO);
        patientRepository.save(patient);

        var uri = uriBuilder.path("patients/{id}").buildAndExpand(patient.getId()).toUri();

        return ResponseEntity.created(uri).body(new detailedPatientData(patient));
    }

    @GetMapping
    public ResponseEntity<Page<PatientSumaryDTO>> listOfPatients(@PageableDefault (size = 10, sort = {"name"}) Pageable pagination) {
        var page = patientRepository.findAllByActiveTrue(pagination).map(PatientSumaryDTO::new);

        return ResponseEntity.ok(page);
    }

    @PutMapping
    @Transactional
    public ResponseEntity updatePatient(@RequestBody @Valid UpdatedPatientDTO updatedPatientDTO) {
        var patient = patientRepository.getReferenceById(updatedPatientDTO.id());
        patient.updateData(updatedPatientDTO);

        return ResponseEntity.ok(new detailedPatientData((patient)));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity deletePatient(@PathVariable Long id) {
        //patientRepository.deleteById(id);
        var patient = patientRepository.getReferenceById(id);
        patient.deletePatient();

        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity detailPatientData(@PathVariable Long id) {
        var patient = patientRepository.getReferenceById(id);

        return ResponseEntity.ok(new detailedPatientData(patient));
    }

}
