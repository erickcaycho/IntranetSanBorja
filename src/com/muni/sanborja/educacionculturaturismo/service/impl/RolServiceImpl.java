package com.muni.sanborja.educacionculturaturismo.service.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.model.SelectItem;

import org.apache.log4j.Logger;

import com.muni.sanborja.educacionculturaturismo.dao.RolDao;
import com.muni.sanborja.educacionculturaturismo.dao.impl.RolDaoImpl;
import com.muni.sanborja.educacionculturaturismo.modelo.Rol;
import com.muni.sanborja.educacionculturaturismo.service.RolService;

public class RolServiceImpl implements Serializable,RolService{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static Logger log = Logger.getLogger(RolServiceImpl.class);
	
	private RolDao rolDao = new RolDaoImpl();

	@Override
	public List<SelectItem> listarRoles() {
		
		List<SelectItem>  listaRoles = new ArrayList<SelectItem>();
		List<Rol> r = rolDao.listarRoles();
		
		for (Rol rol : r) {
			SelectItem rolItem = new SelectItem(rol.getIdrol(),
					rol.getNombrerol());
			listaRoles.add(rolItem);
		}
		return listaRoles;
	}

}
