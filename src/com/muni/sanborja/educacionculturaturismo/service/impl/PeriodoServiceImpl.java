package com.muni.sanborja.educacionculturaturismo.service.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.model.SelectItem;

import org.apache.log4j.Logger;

import com.muni.sanborja.educacionculturaturismo.dao.PeriodoDao;
import com.muni.sanborja.educacionculturaturismo.dao.impl.PeriodoDaoImpl;
import com.muni.sanborja.educacionculturaturismo.modelo.Periodo;
import com.muni.sanborja.educacionculturaturismo.service.PeriodoService;
//import org.hibernate.Query;

public class PeriodoServiceImpl implements Serializable,PeriodoService{

	public static Logger log = Logger.getLogger(PeriodoServiceImpl.class);
	private static final long serialVersionUID = 3558653004795076773L;
	private PeriodoDao periodoDao = new PeriodoDaoImpl();
	
	@Override
	public List<SelectItem> listarPeriodo() {
		
		List<SelectItem> listaPeriodos = new ArrayList<SelectItem>();
			List<Periodo> p = periodoDao.listarPeriodo();
		for(Periodo periodo : p){
			SelectItem periodoItem = new SelectItem(periodo.getIdPeriodo(), periodo.getNomPeriodo());
			listaPeriodos.add(periodoItem);
		}
		return listaPeriodos;	
	}

}
