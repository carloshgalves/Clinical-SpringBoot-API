package med.voll.api.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.voll.api.domain.appointment.detailedAppointmentData;
import med.voll.api.domain.appointment.scheduleAppointmenetData;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/appointments")
public class Appointment {

    @PostMapping
    @Transactional
    public ResponseEntity scheduleAppointment(@RequestBody @Valid scheduleAppointmenetData data) {
        return ResponseEntity.ok(new detailedAppointmentData(null, null, null, null));
    }

}
