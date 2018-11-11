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

import co.simplon.springboot.simplecrud2.model.Film;
import co.simplon.springboot.simplecrud2.repository.FilmRepository;

@RestController
@RequestMapping("/api")
public class FilmController {

	@Autowired
	FilmRepository repository;
	
	@CrossOrigin
	@GetMapping("/film")
	List<Film> getAllFilm(){
		return repository.findAll();
	}
	
	@CrossOrigin
	@GetMapping("/film/{id}")
	ResponseEntity<Film> getFilmById(@PathVariable(value="id_film") long id) {
	    Film film = repository.findOne(id);
	    if(film == null) {
	        return ResponseEntity.notFound().build();
	    }
	    return ResponseEntity.ok().body(film);
	}
	
	@CrossOrigin
	@PostMapping("/film")
	Film addFilm(@Valid @RequestBody Film film){
		return repository.save(film);
	}
	
	@CrossOrigin
	@PutMapping("/film/{id}")
	ResponseEntity<Film> updateFilm(@PathVariable(value="id_film") long id, @Valid @RequestBody Film film){
		Film filmToUpdate = repository.findOne(id);
		if(filmToUpdate == null)
			return ResponseEntity.notFound().build();
		
		// Update the mandatory attributes
		filmToUpdate.setName(film.getName());
		filmToUpdate.setRate(film.getRate());
		filmToUpdate.setYear(film.getYear());
		
		// Update all other not null attributes
		if(film.getName() != null)
			filmToUpdate.setName(film.getName());
		
		if(film.getRate() != 0)
			filmToUpdate.setRate(film.getRate());
		
		if(film.getYear() != null)
			filmToUpdate.setYear(film.getYear());
		
		Film updatedFilm = repository.save(filmToUpdate);
		return ResponseEntity.ok(updatedFilm);
	}
	
	@CrossOrigin
	@DeleteMapping("/film/{id}")
	ResponseEntity<Film> deleteFilm(@PathVariable(value="id_film") long id){
		Film film = repository.findOne(id);
		if(film == null)
			return ResponseEntity.notFound().build();
		
		repository.delete(film);
		return ResponseEntity.ok().build();
	}
}


