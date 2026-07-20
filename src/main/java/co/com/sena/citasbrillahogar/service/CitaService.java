package co.com.sena.citasbrillahogar.service;

import co.com.sena.citasbrillahogar.entity.Cita;
import co.com.sena.citasbrillahogar.repository.CitaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CitaService {

    private final CitaRepository citaRepository;

    public CitaService(CitaRepository citaRepository) {
        this.citaRepository = citaRepository;
    }

    public Cita crearCita(Cita cita) {
        return citaRepository.save(cita);
    }

    public List<Cita> listarCitas() {
        return citaRepository.findAll();
    }

    public Cita obtenerCita(Long id) {
        return citaRepository.findById(id).orElse(null);
    }

    public Cita actualizarCita(Long id, Cita cita) {

        Cita existente = obtenerCita(id);

        if (existente == null) {
            return null;
        }

        existente.setFecha(cita.getFecha());
        existente.setHora(cita.getHora());
        existente.setServicio(cita.getServicio());
        existente.setEstado(cita.getEstado());
        existente.setCliente(cita.getCliente());

        return citaRepository.save(existente);
    }

    public void eliminarCita(Long id) {
        citaRepository.deleteById(id);
    }
}
