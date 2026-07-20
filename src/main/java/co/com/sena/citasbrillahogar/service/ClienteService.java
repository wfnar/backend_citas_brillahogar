package co.com.sena.citasbrillahogar.service;

import co.com.sena.citasbrillahogar.entity.Cliente;
import co.com.sena.citasbrillahogar.repository.ClienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public Cliente crearCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public List<Cliente> obtenerClientes() {
        return clienteRepository.findAll();
    }

    public Cliente obtenerCliente(Long id) {
        return clienteRepository.findById(id).orElse(null);
    }

    public Cliente actualizarCliente(Long id, Cliente cliente) {

        Cliente existente = obtenerCliente(id);

        if (existente == null) {
            return null;
        }

        existente.setNombre(cliente.getNombre());
        existente.setApellido(cliente.getApellido());
        existente.setCorreo(cliente.getCorreo());
        existente.setTelefono(cliente.getTelefono());

        return clienteRepository.save(existente);
    }

    public void eliminarCliente(Long id) {
        clienteRepository.deleteById(id);
    }
}
