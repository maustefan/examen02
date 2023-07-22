package com.regalado.sisincidencias.service;
import java.util.List;

import com.regalado.sisincidencias.entity.Incidencia;

public interface IncidenciaService {
	public List<Incidencia> findAll();
	public Incidencia findById(int id);
	public Incidencia findByReferencia(String nombre);
	public List<Incidencia> findByReferenciaContaining(String nombre);
	public Incidencia create(Incidencia obj);
	public Incidencia update(Incidencia obj);
	public int delete(int id);
}
