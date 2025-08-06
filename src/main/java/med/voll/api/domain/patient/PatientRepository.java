package med.voll.api.domain.patient;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;

public interface PatientRepository extends JpaRepository<Patient, Long> {
    Page<Patient> findAllByActiveTrue(Pageable pagination);

    Boolean findActiveById(Long id);

    boolean existsByIdAndDateBetween(Long id, LocalDateTime startDate, LocalDateTime endDate);
}
