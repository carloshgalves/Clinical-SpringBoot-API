package med.voll.api.domain.doctor;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {

    Page<Doctor> findAllByActiveTrue(Pageable pagination);

    @Query("SELECT d FROM Doctor d " +
            "WHERE d.specialty = :specialty " +
            "AND d.id NOT IN (" +
            "SELECT a.doctor.id FROM Appointment a WHERE a.dateTime = :dateTime" +
            ") " +
            "ORDER BY function('RAND')" +
            "limit 1")
    Doctor selectRandomDoctorOnGivenDate(@Param("specialty") Specialty specialty, @Param("dateTime") @NotNull @Future LocalDateTime dateTime);

    @Query("SELECT d.active FROM Doctor d WHERE d.id = :id")
    Boolean findActiveById(Long id);
}
