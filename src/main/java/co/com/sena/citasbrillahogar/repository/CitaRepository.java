package co.com.sena.citasbrillahogar.repository;

import co.com.sena.citasbrillahogar.entity.Cita;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface CitaRepository extends JpaRepository<Cita, Long> {

    List<Cita> findByFecha(LocalDate fecha);
}
