package project.grupo09.com.example.Chikitines.vendedor;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "vendedor")
public class Vendedor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String Nombre;
	
	@Column(nullable = false)
	private String ApPaterno;
	
	@Column(nullable = false)
	private String ApMaterno;
	
	@Column(nullable = false)
	private String Email;
	
	@Column(nullable = false)
	private String Telefono;

	public Vendedor() {
	}

	public Vendedor(Long id, String nombre, String apPaterno, String apMaterno, String email, String telefono) {
		this.id = id;
		this.Nombre = nombre;
		this.ApPaterno = apPaterno;
		this.ApMaterno = apMaterno;
		this.Email = email;
		this.Telefono = telefono;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	public String getApPaterno() {
		return ApPaterno;
	}

	public void setApPaterno(String apPaterno) {
		ApPaterno = apPaterno;
	}

	public String getApMaterno() {
		return ApMaterno;
	}

	public void setApMaterno(String apMaterno) {
		ApMaterno = apMaterno;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getTelefono() {
		return Telefono;
	}

	public void setTelefono(String telefono) {
		Telefono = telefono;
	}
}
