package com.muni.sanborja.educacionculturaturismo.dao;

import com.muni.sanborja.educacionculturaturismo.modelo.PlanPublicitario;

public interface PlanPublicitarioDao {

	public boolean createPlanPublicitario(PlanPublicitario planPublicitario);
	public PlanPublicitario obtener(int idPlanificacion);
	
}
