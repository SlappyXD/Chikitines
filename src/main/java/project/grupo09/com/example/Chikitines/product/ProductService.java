package project.grupo09.com.example.Chikitines.product;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class ProductService {
	
	private final ProductRepository productRepository;
	
	public ProductService(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}
	
	public List<Product> getProducts() {
		return productRepository.findAll();
	}

	public ResponseEntity<Object> saveOrUpdateProduct(Product product) {
		Optional<Product> existingProduct = productRepository.findByNombre(product.getNombre());
		
		if (existingProduct.isPresent() && (product.getId() == null || !existingProduct.get().getId().equals(product.getId()))) {
			throw new ResponseStatusException(HttpStatus.CONFLICT, "Product with this name already exists");
		}
		
		Product savedProduct = productRepository.save(product);
		return new ResponseEntity<>(savedProduct, product.getId() == null ? HttpStatus.CREATED : HttpStatus.OK);
	}
	
	public ResponseEntity<Object> deleteProduct(Long id) {
		if (!productRepository.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Product not found");
		}
		
		productRepository.deleteById(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}

