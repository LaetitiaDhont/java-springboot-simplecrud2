package co.simplon.springboot.simplecrud2.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import co.simplon.springboot.simplecrud2.model.Acteur;

public interface ActeurRepository extends JpaRepository<Acteur, Long> {

}
