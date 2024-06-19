package project.grupo09.com.example.Chikitines.vendedor;

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
@RequestMapping(path = "api/v1/vendedor")
public class VendedorController {
	
private final VendedorService vendedorService;
	
	public VendedorController(VendedorService vendedorService) {
		this.vendedorService = vendedorService;
	}
	
	@GetMapping
	public List<Vendedor> getVendedor() {
		return vendedorService.getVendedor();
	}
	
	@PostMapping
	public ResponseEntity<Object> createVendedor(@RequestBody Vendedor vendedor) {
		return vendedorService.saveOrUpdateVendedor(vendedor);
	}
	
	@PutMapping
	public ResponseEntity<Object> updateVendedor(@RequestBody Vendedor vendedor) {
		return vendedorService.saveOrUpdateVendedor(vendedor);
	}
	
	@DeleteMapping(path = "{vendedorId}")
	public ResponseEntity<Object> deleteVendedor(@PathVariable("vendedorId") Long id) {
		return vendedorService.deleteVendedor(id);
	}

}
