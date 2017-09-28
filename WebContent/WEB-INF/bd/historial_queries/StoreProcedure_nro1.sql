



DELIMITER  
 
    CREATE PROCEDURE obtenerPlanificacionXPeriodoXActividad(IN Val_idperiodo INT, IN Val_estado INT)
        LANGUAGE SQL
        DETERMINISTIC
        SQL SECURITY DEFINER
        BEGIN
			IF (Val_idperiodo !=0) AND (Val_estado !=0)  THEN
			
				Select pl.idplanificacion as idplanificacion,
					p.nomperiodo as nomperiodo,
					pl.fechacreacion as fechacreacion,
					pl.fechaplanificacion as fechaplanificacion,
					pl.fechaaprobacion as fechaaprobacion,
					pl.fecharechazo as fecharechazo,
					pl.fechaanulacion as fechaanulacion,
					pl.fechaejecucion as fechaejecucion,
					a.nomactividad as nomactividad,
					ta.nomtipoactividad as nomtipoactividad, 
					case pl.estado 
					when 1 then "Pendiente" 
					when 2 then "Planificado"
					when 3 then "Aprobado"
					when 4 then "Rechazado"
					when 5 then "Ejecutado"
					when 6 then "Anulado"
					end  as estado
					
					from planificacion pl inner join periodo p on pl.idperiodo=p.idperiodo
					inner join actividad a on pl.idactividad=a.idactividad
					inner join tipoactividad ta on a.idtipoactividad = ta.idtipoactividad
					
					 WHERE p.idperiodo=Val_idperiodo and pl.estado=Val_estado;
			ELSE 
				  
					Select pl.idplanificacion as idplanificacion,
					p.nomperiodo as nomperiodo,
					pl.fechacreacion as fechacreacion,
					pl.fechaplanificacion as fechaplanificacion,
					pl.fechaaprobacion as fechaaprobacion,
					pl.fecharechazo as fecharechazo,
					pl.fechaanulacion as fechaanulacion,
					pl.fechaejecucion as fechaejecucion,
					a.nomactividad as nomactividad,
					ta.nomtipoactividad as nomtipoactividad, 
					case pl.estado 
					when 1 then "Pendiente" 
					when 2 then "Planificado"
					when 3 then "Aprobado"
					when 4 then "Rechazado"
					when 5 then "Ejecutado"
					when 6 then "Anulado"
					end  as estado
					
					from planificacion pl inner join periodo p on pl.idperiodo=p.idperiodo
					inner join actividad a on pl.idactividad=a.idactividad
					inner join tipoactividad ta on a.idtipoactividad = ta.idtipoactividad;
					
			END IF;
        END;


