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
import com.peluqueria.app.model.*;
import com.peluqueria.app.repository.EmpleadoRepository;

@Controller
@RequestMapping(path="/empleados")
public class EmpleadoController {
	
	@Autowired
	private EmpleadoRepository empleadoRepository;
	
	@GetMapping(path="/all")
	public @ResponseBody Iterable<Empleado> getAllEmpleados() {
	    return empleadoRepository.findAll();
	  }
	
	@GetMapping(path="/") // Trae un empleado
	public ResponseEntity<Empleado> getEmpleado (@RequestParam(value = "id") Integer id) {
		Optional<Empleado> usuario = empleadoRepository.findById(id);
        return new ResponseEntity(usuario, HttpStatus.OK);
	}
	
	@PostMapping(path="/add") // Crea un nuevo empleado
	public ResponseEntity<Empleado> addEmpleado (@RequestBody Empleado empleado) {
		Empleado empleadocreado = empleadoRepository.save(empleado);
		return new ResponseEntity<Empleado>(empleadocreado, HttpStatus.CREATED);	
	}
	
	@DeleteMapping(path="/") // Borro un usuario
	public ResponseEntity<Empleado> deleteEmpleado (@RequestParam(value = "id") Integer id) {
		empleadoRepository.deleteById(id);
        return new ResponseEntity("Borrado", HttpStatus.OK);
	}

}
