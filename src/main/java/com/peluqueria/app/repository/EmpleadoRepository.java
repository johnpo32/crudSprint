package com.peluqueria.app.repository;

import org.springframework.data.repository.CrudRepository;
import com.peluqueria.app.model.Empleado;

public interface EmpleadoRepository extends CrudRepository<Empleado, Integer> {

}
