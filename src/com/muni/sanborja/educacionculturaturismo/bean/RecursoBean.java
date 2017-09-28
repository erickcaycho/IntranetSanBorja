package com.muni.sanborja.educacionculturaturismo.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.apache.log4j.Logger;

import com.muni.sanborja.educacionculturaturismo.dao.MaterialDao;
import com.muni.sanborja.educacionculturaturismo.dao.impl.MaterialDaoImpl;
import com.muni.sanborja.educacionculturaturismo.modelo.Material;

@ManagedBean(name = "materialBean")
@SessionScoped
public class MaterialBean implements Serializable{

	public static Logger log = Logger.getLogger(MaterialBean.class);
	private static final long serialVersionUID = 1L;
	
	private List<Material> listaMaterial, selectedMaterial;
	private Material material;

	@PostConstruct
	public void init() {
		material = new Material();
	    
	}
	
	public Material getMaterial() {
		return material;
	}

	public void setMaterial(Material material) {
		this.material = material;
	}


	public List<Material> getSelectedMaterial() {
		return selectedMaterial;
	}

	public void setSelectedMaterial(List<Material> selectedMaterial) {
		this.selectedMaterial = selectedMaterial;
	}

	public List<Material> getListaMaterial() {
		MaterialDao materialDao = new MaterialDaoImpl();
		
		//listaMaterial = materialDao.listarMateriales(material.getNombre);
		listaMaterial = materialDao.listarMateriales("ves");
		
		return listaMaterial;
	}
	
	public void consultarMaterial() {
		MaterialDao materialDao = new MaterialDaoImpl();
		
		listaMaterial = materialDao.listarMateriales(material.getNombre());
		//listaMaterial = materialDao.listarMateriales("ves");
	}

	public void setListaMaterial(List<Material> listaMaterial) {
		this.listaMaterial = listaMaterial;
	}

}
