package com.muni.sanborja.educacionculturaturismo.dao;

import java.util.List;

import com.muni.sanborja.educacionculturaturismo.modelo.Material;

public interface MaterialDao {
	
	public List<Material> listarMateriales(String material);

}
