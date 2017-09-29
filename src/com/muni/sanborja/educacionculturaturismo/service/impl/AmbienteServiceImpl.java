package com.muni.sanborja.educacionculturaturismo.service.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.model.SelectItem;

import org.apache.log4j.Logger;

import com.muni.sanborja.educacionculturaturismo.dao.AmbienteDao;
import com.muni.sanborja.educacionculturaturismo.dao.impl.AmbienteDaoImpl;
import com.muni.sanborja.educacionculturaturismo.modelo.Ambiente;
import com.muni.sanborja.educacionculturaturismo.service.AmbienteService;

public class AmbienteServiceImpl implements Serializable,AmbienteService {

	public static Logger log = Logger.getLogger(AmbienteServiceImpl.class);
	private static final long serialVersionUID = 3558653004795076773L;
	private AmbienteDao ambienteDao =  new AmbienteDaoImpl();

	@Override
	public List<SelectItem> listarAmbiente(int idSede) {
		List<SelectItem> listaAmbiente = new ArrayList<SelectItem>();		
		log.info("Codigo capturado = " + idSede);		
		List<Ambiente> a = ambienteDao.listarAmbiente(idSede);
		
		for(Ambiente ambiente : a){
			SelectItem actividadItem = new SelectItem(ambiente.getIdAmbiente(), ambiente.getNomAmbiente());
			listaAmbiente.add(actividadItem);
		}
		return listaAmbiente;
	}
	
	@Override
	public Ambiente buscar(int idAmbiente) {
	      return ambienteDao.buscar(idAmbiente); 
	 }
}
