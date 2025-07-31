package med.voll.api.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.voll.api.domain.doctor.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/doctors")
public class DoctorController {

    @Autowired
    private DoctorRepository doctorRepository;

    @PostMapping
    @Transactional
    public ResponseEntity registerDoctor(@RequestBody @Valid RegisteredDoctorDTO data, UriComponentsBuilder uriBuilder) {
        var doctor = new Doctor(data);
        doctorRepository.save(doctor);

        var uri = uriBuilder.path("doctors/{id}").buildAndExpand(doctor.getId()).toUri();


        return ResponseEntity.created(uri).body(new detailedDoctorData(doctor));
    }

    @GetMapping
    public ResponseEntity<Page<DoctorSumaryDTO>> listOfDoctors(@PageableDefault(size = 10, sort = {"name"}) Pageable pagination) {
        var page = doctorRepository.findAllByActiveTrue(pagination).map(DoctorSumaryDTO::new);
        return ResponseEntity.ok(page);
    }

    @PutMapping
    @Transactional
    public ResponseEntity updateDoctor(@RequestBody @Valid UpdatedDoctorDTO data) {
        var doctor = doctorRepository.getReferenceById(data.id());
        doctor.updateData(data);
        return ResponseEntity.ok(new detailedDoctorData(doctor));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity deleteDoctor(@PathVariable Long id) {
        //doctorRepository.deleteById(id);
        var doctor = doctorRepository.getReferenceById(id);
        doctor.deleteDoctor();

        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity detailDoctorData(@PathVariable Long id) {
        var doctor = doctorRepository.getReferenceById(id);
        return ResponseEntity.ok(new detailedDoctorData(doctor));
    }

}
