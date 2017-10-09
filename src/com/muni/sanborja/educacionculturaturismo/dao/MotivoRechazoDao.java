package com.muni.sanborja.educacionculturaturismo.dao;

import java.util.List;

import com.muni.sanborja.educacionculturaturismo.modelo.MotivoRechazo;

public interface MotivoRechazoDao {

	public List<MotivoRechazo>listarMotivoRechazo();
	public MotivoRechazo buscarMotivoRechazo(int idMotivoRechazo);
}
