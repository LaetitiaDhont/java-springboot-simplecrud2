package co.simplon.springboot.simplecrud2.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.simplon.springboot.simplecrud2.model.Acteur;
import co.simplon.springboot.simplecrud2.repository.ActeurRepository;

@RestController // On doit indiquer que c'est un controller grâce à l'annonation RestController
@RequestMapping("/api")
public class ActeurController {

	@Autowired
	ActeurRepository repository;

	@CrossOrigin
	@GetMapping("/acteur")
	List<Acteur> getAllActeur() {
		return repository.findAll();
	}

	@CrossOrigin
	@GetMapping("/acteur/{id}")
	ResponseEntity<Acteur> getActeurById(@PathVariable(value = "id_acteur") long id) {
		Acteur acteur = repository.findOne(id);
		if (acteur == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(acteur);
	}

	@CrossOrigin
	@PostMapping("/acteur")
	Acteur addActeur(@Valid @RequestBody Acteur acteur) {
		return repository.save(acteur);
	}

	@CrossOrigin
	@PutMapping("/acteur/{id}")
	ResponseEntity<Acteur> updateActeur(@PathVariable(value = "id_acteur") long id, @Valid @RequestBody Acteur acteur) {
		Acteur acteurToUpdate = repository.findOne(id);
		if (acteurToUpdate == null)
			return ResponseEntity.notFound().build();

		// Update the mandatory attributes
		acteurToUpdate.setFirstname(acteur.getFirstname());
		acteurToUpdate.setName(acteur.getName());
		acteurToUpdate.setAddress(acteur.getAddress());
		acteurToUpdate.setEmail(acteur.getEmail());
		acteurToUpdate.setPhone(acteur.getPhone());

		// Update all other not null attributes
		if (acteur.getFirstname() != null)
			acteurToUpdate.setFirstname(acteur.getFirstname());

		if (acteur.getName() != null)
			acteurToUpdate.setName(acteur.getName());

		if (acteur.getAddress() != null)
			acteurToUpdate.setAddress(acteur.getAddress());

		if (acteur.getEmail() != null)
			acteurToUpdate.setEmail(acteur.getEmail());

		if (acteur.getPhone() != null)
			acteurToUpdate.setPhone(acteur.getPhone());

		Acteur updatedActeur = repository.save(acteurToUpdate);
		return ResponseEntity.ok(updatedActeur);
	}

	@CrossOrigin
	@DeleteMapping("/acteur/{id}")
	ResponseEntity<Acteur> deleteActeur(@PathVariable(value = "id_acteur") long id) {
		Acteur acteur = repository.findOne(id);
		if (acteur == null)
			return ResponseEntity.notFound().build();

		repository.delete(acteur);
		return ResponseEntity.ok().build();
	}

}
