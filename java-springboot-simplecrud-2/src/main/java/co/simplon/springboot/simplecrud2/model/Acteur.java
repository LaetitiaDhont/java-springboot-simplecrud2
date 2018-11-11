package co.simplon.springboot.simplecrud2.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

// On indique qu'il s'agit d'une entité avec l'at Entity 
@Entity
@Table(name = "acteur") // Cela créer la table directement dans notre BDD 
public class Acteur {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) // Auto increment l'id
	
	@NotBlank // Ne fonctionne pas avec les int
	
	private long id_acteur;
	
	@NotBlank
	
	private String firstname;
	
	@NotBlank
	
	private String name;
	
	@NotBlank
	
	private String address;
	
	@Email // Pour respecter le format du mail
	
	private String email;
	
	@Pattern(regexp = "^\\+?\\d+$") // Pattern pour le numéro de téléphone, pour le format
	private String phone;

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public long getId_acteur() {
		return id_acteur;
	}

	public void setId_acteur(long id_acteur) {
		this.id_acteur = id_acteur;
	}
	
	

}
