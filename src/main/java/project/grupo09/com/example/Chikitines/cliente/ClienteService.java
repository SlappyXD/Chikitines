package project.grupo09.com.example.Chikitines.cliente;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class ClienteService {
	private final ClienteRepository clienteRepository;
	
	public ClienteService(ClienteRepository clienteRepository) {
		this.clienteRepository = clienteRepository;
	}
	
	public List<Cliente> getCliente() {
		return clienteRepository.findAll();
	}

	public ResponseEntity<Object> saveOrUpdateCliente(Cliente cliente) {
		Cliente savedCliente = clienteRepository.save(cliente);
		return new ResponseEntity<>(savedCliente, cliente.getId() == null ? HttpStatus.CREATED : HttpStatus.OK);
	}
	
	public ResponseEntity<Object> deleteCliente(Long id) {
		if (!clienteRepository.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente not found");
		}
		
		clienteRepository.deleteById(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
