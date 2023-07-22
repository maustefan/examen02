package com.regalado.sisincidencias.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.regalado.sisincidencias.entity.Incidencia;
import com.regalado.sisincidencias.repository.IncidenciaRepository;
import com.regalado.sisincidencias.service.IncidenciaService;

@Service
public class IncidenciaServiceImpl implements IncidenciaService {
	@Autowired
	private IncidenciaRepository repository;

	@Override
	@Transactional(readOnly = true)
	public List<Incidencia> findAll() {
		try {
			return repository.findAll();
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	@Transactional(readOnly = true)
	public Incidencia findById(int id) {
		try {
			return repository.findById(id).orElse(null);
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	@Transactional(readOnly = true)
	public Incidencia findByReferencia(String nombre) {
		try {
			return repository.findByReferencia(nombre);
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	@Transactional(readOnly = true)
	public List<Incidencia> findByReferenciaContaining(String nombre) {
		try {
			return repository.findByReferenciaContaining(nombre);
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	@Transactional
	public Incidencia create(Incidencia obj) {
		try {
			return repository.save(obj);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

	@Override
	@Transactional
	public Incidencia update(Incidencia obj) {
		try {
			Incidencia IncidenciaDb=repository.findById(obj.getId()).orElse(null);
			if(IncidenciaDb==null) {
				return null;
			}
			IncidenciaDb.setReferencia(obj.getReferencia());
			return repository.save(IncidenciaDb);
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	@Transactional
	public int delete(int id) {
		try {
			Incidencia IncidenciaDb=repository.findById(id).orElse(null);
			if(IncidenciaDb==null) {
				return 0;
			}else {
				repository.delete(IncidenciaDb);
				return 1;
			}
		} catch (Exception e) {
			return 0;
		}
	}

}
