package project.grupo09.com.example.Chikitines.cliente;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/v1/clientes")
public class ClienteController {

	private final ClienteService clienteService;
	
	public ClienteController(ClienteService clienteService) {
		this.clienteService = clienteService;
	}
	
	@GetMapping
	public List<Cliente> getCliente() {
		return clienteService.getCliente();
	}
	
	@PostMapping
	public ResponseEntity<Object> createCliente(@RequestBody Cliente cliente) {
		return clienteService.saveOrUpdateCliente(cliente);
	}
	
	@PutMapping
	public ResponseEntity<Object> updateCliente(@RequestBody Cliente cliente) {
		return clienteService.saveOrUpdateCliente(cliente);
	}
	
	@DeleteMapping(path = "{clienteId}")
	public ResponseEntity<Object> deleteCliente(@PathVariable("clienteId") Long id) {
		return clienteService.deleteCliente(id);
	}
}
