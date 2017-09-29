package com.muni.sanborja.educacionculturaturismo.service;

import com.muni.sanborja.educacionculturaturismo.modelo.PlanPublicitario;

public interface PlanPublicitarioService {

	public boolean createPlanPublicitario(PlanPublicitario planPublicitario);
	public PlanPublicitario obtener(int idPlanificacion);
	
}
