package project.grupo09.com.example.Chikitines.cliente;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "clientes")
public class Cliente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	
	@Column(nullable = false)
	private String Nombre;
	
	@Column(nullable = false)
	private String Email;
	
	@Column(nullable = false)
	private String Telefono;
	
	@Column(nullable = false)
	private String TipoCliente;

	public Cliente() {
	}

	public Cliente(Long id, String nombre, String email, String telefono, String tipoCliente) {
		this.Id = id;
		this.Nombre = nombre;
		this.Email = email;
		this.Telefono = telefono;
		this.TipoCliente = tipoCliente;
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		this.Id = id;
	}

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		this.Nombre = nombre;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		this.Email = email;
	}

	public String getTelefono() {
		return Telefono;
	}

	public void setTelefono(String telefono) {
		this.Telefono = telefono;
	}

	public String getTipoCliente() {
		return TipoCliente;
	}

	public void setTipoCliente(String tipoCliente) {
		this.TipoCliente = tipoCliente;
	}
	
	

	
}
