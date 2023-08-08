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

import com.peluqueria.app.model.Usuario;
import com.peluqueria.app.repository.UsuarioRepository;

@Controller
@RequestMapping(path="/usuarios")
public class UsuarioController {
	
	@Autowired
	UsuarioRepository usuarioRepository;
	
	@GetMapping(path="/all") // Trae todos los usuarios
	public @ResponseBody Iterable<Usuario> getAllEmpleados() {
		return usuarioRepository.findAll();
	}
	
	@GetMapping(path="/") // Trae un usuario
	public ResponseEntity<Usuario> getUser (@RequestParam(value = "id") Integer id) {
		Optional<Usuario> usuario = usuarioRepository.findById(id);
        return new ResponseEntity(usuario, HttpStatus.OK);
	}
	
	@PostMapping(path="/add") // Crea un nuevo usuario
	public ResponseEntity<Usuario> addUser (@RequestBody Usuario usuario) {
		Usuario userCreated = usuarioRepository.save(usuario);
		return new ResponseEntity<Usuario>(userCreated, HttpStatus.CREATED);	
	}
	
	@DeleteMapping(path="/") // Borro un usuario
	public ResponseEntity<Usuario> deleteUser (@RequestParam(value = "id") Integer id) {
		 usuarioRepository.deleteById(id);
        return new ResponseEntity("Borrado", HttpStatus.OK);
	}

}
