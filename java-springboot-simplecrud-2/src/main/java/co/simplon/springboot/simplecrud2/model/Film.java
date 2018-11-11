package co.simplon.springboot.simplecrud2.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name = "film")
public class Film {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)

	private long id_film;

	@NotBlank

	private String name;

	@NotBlank // Pour les strings

	private String year;

	@NotNull // Pour les int

	private int rate;
	
	// Déclaration de foreign key
	@ManyToOne
	@JoinColumn(name="REF_ACTEUR", table="film") // Créer une clé étrangère sur notre BDD, elles sont générées automatiquement !
	
	private Acteur refActeur;

	public long getId_film() {
		return id_film;
	}

	public void setId_film(long id_film) {
		this.id_film = id_film;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public int getRate() {
		return rate;
	}

	public void setRate(int rate) {
		this.rate = rate;
	}

	public Acteur getRefActeur() {
		return refActeur;
	}

	public void setRefActeur(Acteur refActeur) {
		this.refActeur = refActeur;
	}
	
	
}