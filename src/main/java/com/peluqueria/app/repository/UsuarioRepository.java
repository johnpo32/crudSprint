package com.peluqueria.app.repository;

import org.springframework.data.repository.CrudRepository;

import com.peluqueria.app.model.Usuario;

public interface UsuarioRepository extends CrudRepository<Usuario, Integer> {

}
