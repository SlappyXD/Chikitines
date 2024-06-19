package project.grupo09.com.example.Chikitines.product;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/v1/products")
public class ProductController {
	
	private final ProductService productService;
	
	public ProductController(ProductService productService) {
		this.productService = productService;
	}
	
	@GetMapping
	public List<Product> getProducts() {
		return productService.getProducts();
	}
	
	@PostMapping
	public ResponseEntity<Object> createProduct(@RequestBody Product product) {
		return productService.saveOrUpdateProduct(product);
	}
	
	@PutMapping
	public ResponseEntity<Object> updateProduct(@RequestBody Product product) {
		return productService.saveOrUpdateProduct(product);
	}
	
	@DeleteMapping(path = "{productId}")
	public ResponseEntity<Object> deleteProduct(@PathVariable("productId") Long id) {
		return productService.deleteProduct(id);
	}
}

