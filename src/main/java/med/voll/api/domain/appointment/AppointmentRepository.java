package med.voll.api.domain.appointment;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
    boolean existsByDoctorIdAndDateTime(@NotNull Long idDoctor, @NotNull @Future LocalDateTime localDateTime);
}
