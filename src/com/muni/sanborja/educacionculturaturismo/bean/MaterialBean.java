package com.muni.sanborja.educacionculturaturismo.bean;

import java.io.Serializable;
import java.util.List;

import org.apache.log4j.Logger;

import com.muni.sanborja.educacionculturaturismo.modelo.Material;

public class MaterialBean implements Serializable{

	public static Logger log = Logger.getLogger(MaterialBean.class);
	private static final long serialVersionUID = 1L;
	
	private List<Material> listaMaterial;

	public List<Material> getListaMaterial() {
		return listaMaterial;
	}

	public void setListaMaterial(List<Material> listaMaterial) {
		this.listaMaterial = listaMaterial;
	}

}
