package project.grupo09.com.example.Chikitines.vendedor;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;


@Service
public class VendedorService {
	private final VendedorRepository vendedorRepository;
	
	public VendedorService(VendedorRepository vendedorRepository) {
		this.vendedorRepository = vendedorRepository;
	}
	
	public List<Vendedor> getVendedor() {
		return vendedorRepository.findAll();
	}

	public ResponseEntity<Object> saveOrUpdateVendedor(Vendedor vendedor) {
		Vendedor savedVendedor = vendedorRepository.save(vendedor);
		return new ResponseEntity<>(savedVendedor, vendedor.getId() == null ? HttpStatus.CREATED : HttpStatus.OK);
	}
	
	public ResponseEntity<Object> deleteVendedor(Long id) {
		if (!vendedorRepository.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Vendedor not found");
		}
		
		vendedorRepository.deleteById(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
