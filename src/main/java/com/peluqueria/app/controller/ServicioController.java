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

import com.peluqueria.app.model.Servicio;
import com.peluqueria.app.repository.ServicioRepository;

@Controller
@RequestMapping(path="/servicios")
public class ServicioController {
	
	@Autowired
	private ServicioRepository servicioRepository;
	
	@GetMapping(path="/all")
	public @ResponseBody Iterable<Servicio> getAllServicios() {
	    return servicioRepository.findAll();
	  }
	
	@GetMapping(path="/") // Trae un servicio
	public ResponseEntity<Servicio> getServicio (@RequestParam(value = "id") Integer id) {
		Optional<Servicio> servicio = servicioRepository.findById(id);
        return new ResponseEntity(servicio, HttpStatus.OK);
	}
	
	@PostMapping(path="/add") // Crea un nuevo servicio
	public ResponseEntity<Servicio> addServicio (@RequestBody Servicio servicio) {
		Servicio servicioCreado = servicioRepository.save(servicio);
		return new ResponseEntity<Servicio>(servicioCreado, HttpStatus.CREATED);	
	}
	
	@DeleteMapping(path="/") // Borro un servicio
	public ResponseEntity<Servicio> deleteServicio (@RequestParam(value = "id") Integer id) {
		servicioRepository.deleteById(id);
        return new ResponseEntity("Borrado", HttpStatus.OK);
	}

}
