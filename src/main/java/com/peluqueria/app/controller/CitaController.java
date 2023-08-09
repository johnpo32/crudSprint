package com.peluqueria.app.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.peluqueria.app.model.Cita;
import com.peluqueria.app.repository.CitaRepository;

@Controller
@RequestMapping(path="/citas")
public class CitaController {

	@Autowired
	private CitaRepository citaRepository;
	
	@GetMapping(path="/all")
	public @ResponseBody Iterable<Cita> getAllCitas() {
	    return citaRepository.findAll();
	  }
	
	@GetMapping(path="/") // Trae una cita
	public ResponseEntity<Cita> getCitas (@RequestParam(value = "id") Integer id) {
		Optional<Cita> cita = citaRepository.findById(id);
        return new ResponseEntity(cita, HttpStatus.OK);
	}
	
	@PostMapping(path="/add") // Crea un nueva cita
	public ResponseEntity<Cita> addCita (@RequestBody Cita cita) {
		Cita citaCreada = citaRepository.save(cita);
		return new ResponseEntity<Cita>(citaCreada, HttpStatus.CREATED);	
	}
	
	@DeleteMapping(path="/") // Borro una cita
	public ResponseEntity<Cita> deleteCita (@RequestParam(value = "id") Integer id) {
		citaRepository.deleteById(id);
        return new ResponseEntity("Borrado", HttpStatus.OK);
	}
}
