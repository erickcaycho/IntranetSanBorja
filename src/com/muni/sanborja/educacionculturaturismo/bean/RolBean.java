package com.muni.sanborja.educacionculturaturismo.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.SelectItem;

import org.apache.log4j.Logger;

import com.muni.sanborja.educacionculturaturismo.modelo.Empleado;
import com.muni.sanborja.educacionculturaturismo.modelo.Rol;
import com.muni.sanborja.educacionculturaturismo.service.RolService;
import com.muni.sanborja.educacionculturaturismo.service.impl.RolServiceImpl;

@ManagedBean(name="rolBean")
@SessionScoped
public class RolBean implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static Logger log = Logger.getLogger(RolBean.class);
	
	private List<SelectItem> listaRoles;
	private Rol rol;
	
	RolService rolService = new RolServiceImpl();


	@PostConstruct
	public void init() {
		rol = new Rol();
		
	}
	
	
	
	public List<SelectItem> getListaRoles() {
		listaRoles = rolService.listarRoles();
		return listaRoles;
	}

	public void setListaRoles(List<SelectItem> listaRoles) {
		listaRoles = rolService.listarRoles();
		this.listaRoles = listaRoles;
	}

	public Rol getRol() {
		return rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}
	
	
}
