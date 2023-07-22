package com.regalado.sisincidencias.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.regalado.sisincidencias.entity.Incidencia;
import com.regalado.sisincidencias.service.impl.IncidenciaServiceImpl;

@RestController
@RequestMapping("/api/incidencias")
public class IncidenciaController {
	@Autowired
	private IncidenciaServiceImpl service;

	//localhost:8091/api/incidencias (GET)
	@GetMapping()
	public ResponseEntity<List<Incidencia>> getAll(){
		List<Incidencia> Incidencias= service.findAll();
		return ResponseEntity.status(HttpStatus.OK).body(Incidencias);
	}

	//localhost:8091/api/incidencias/1 (GET)
	@GetMapping(value="/{id}")
	public ResponseEntity<Incidencia> getById(@PathVariable("id") int id) {
		Incidencia Incidencia = service.findById(id);
		return ResponseEntity.status(HttpStatus.OK).body(Incidencia);
	}

	//localhost:8091/api/incidencias (POST)
	@PostMapping
	public ResponseEntity<Incidencia> create(@RequestBody Incidencia Incidencia) {
		Incidencia IncidenciaDb=service.create(Incidencia);
		return ResponseEntity.status(HttpStatus.CREATED).body(IncidenciaDb);
	}

	//localhost:8091/api/incidencias/1 (PUT)
	@PutMapping
	public ResponseEntity<Incidencia> update(@RequestBody Incidencia Incidencia) {
		Incidencia IncidenciaDb=service.update(Incidencia);
		return ResponseEntity.status(HttpStatus.OK).body(IncidenciaDb);
	}

	//localhost:8091/api/incidencias/1 (DELETE)
	@DeleteMapping(value="/{id}")
	public int delete(@PathVariable("id") int id){
		return service.delete(id);
	}
}
