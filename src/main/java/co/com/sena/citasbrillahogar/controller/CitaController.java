package co.com.sena.citasbrillahogar.controller;


import co.com.sena.citasbrillahogar.entity.Cita;
import co.com.sena.citasbrillahogar.service.CitaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/citas")
public class CitaController {

    private final CitaService citaService;

    public CitaController(CitaService citaService) {
        this.citaService = citaService;
    }

    @PostMapping
    public Cita crear(@RequestBody Cita cita) {
        return citaService.crearCita(cita);
    }

    @GetMapping
    public List<Cita> listar() {
        return citaService.listarCitas();
    }

    @GetMapping("/{id}")
    public Cita buscar(@PathVariable Long id) {
        return citaService.obtenerCita(id);
    }

    @PutMapping("/{id}")
    public Cita actualizar(@PathVariable Long id,
                           @RequestBody Cita cita) {
        return citaService.actualizarCita(id, cita);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        citaService.eliminarCita(id);
    }

}
