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

	@Override
	public List<Recurso> listaRecursos(int idHorario) {
		return recursoDao.listarRecursos(idHorario);
	}

	@Override
	public boolean actualizarCantidadMaterial(Material material, int cantidad) {
		return recursoDao.actualizarCantidadMaterial(material, cantidad);
	}

	@Override
	public boolean actualizarCantidadMaterial(Recurso recurso) {
		return recursoDao.actualizarCantidadMaterial(recurso);
	}

	@Override
	public boolean eliminarRecurso(Recurso recurso) {
		return recursoDao.eliminarRecurso(recurso);
	}

}
