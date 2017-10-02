package com.muni.sanborja.educacionculturaturismo.service.impl;

import java.io.Serializable;
import java.util.List;

import org.apache.log4j.Logger;

import com.muni.sanborja.educacionculturaturismo.dao.RecursoDao;
import com.muni.sanborja.educacionculturaturismo.dao.impl.RecursoDaoImpl;
import com.muni.sanborja.educacionculturaturismo.modelo.Material;
import com.muni.sanborja.educacionculturaturismo.modelo.Recurso;
import com.muni.sanborja.educacionculturaturismo.service.RecursoService;

public class RecursoServiceImpl implements Serializable, RecursoService{

	public static Logger log = Logger.getLogger(RecursoServiceImpl.class);
	private static final long serialVersionUID = 1L;
	private RecursoDao recursoDao = new RecursoDaoImpl();


	@Override
	public List<Material> listarMateriales(String nombre) {
		return recursoDao.listarMateriales(nombre);
	}

	@Override
	public boolean guardarRecurso(Recurso recurso) {
		return recursoDao.guardarRecurso(recurso);
		
	}

}