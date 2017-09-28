 DELIMITER $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `ConsultarCronograma`(IN idHorario int(11), IN idCronograma int(11))
BEGIN

	DECLARE V_WHERE VARCHAR(50) default '';

	IF(idCronograma>0) THEN
		SET V_WHERE = CONCAT(' AND idCronograma=', idCronograma);
    END IF;
    
    
	/*SET @sql = CONCAT('SELECT COUNT(*) FROM ', tab_name);*/
    SET @sql = CONCAT('SELECT TB1.idCronograma,TB1.tarea,TB1.descripcion,TB2.nombre,TB2.apellidoPat,
					   TB1.fechaInicio,TB1.fechaFin
                       FROM educacionculturaturismosb.cronograma TB1
					   LEFT JOIN educacionculturaturismosb.empleado TB2
                       ON TB1.codEmpleado = TB2.codEmpleado
					   WHERE idHorario =',idHorario,V_WHERE);
	PREPARE stmt FROM @sql;
	EXECUTE stmt;
	DEALLOCATE PREPARE stmt;
END$$
DELIMITER ;


DELIMITER $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `obtenerPlanificacionXPeriodoXActividad`(IN Val_idperiodo INT, IN Val_estado INT)
    DETERMINISTIC
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
        END$$
DELIMITER ;
 
 
DELIMITER $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `validarActividadPorPeriodo`(IN Val_idperiodo INT, IN Val_idtipoactividad INT, IN Val_idactividad INT)
    DETERMINISTIC
BEGIN
			Select count(pl.idplanificacion) as flagactividadperiodo
			from planificacion pl inner join periodo p on pl.idperiodo=p.idperiodo and p.idperiodo=Val_idperiodo
			inner join actividad a on pl.idactividad=a.idactividad and a.idactividad=Val_idactividad
			inner join tipoactividad ta on a.idtipoactividad = ta.idtipoactividad and ta.idtipoactividad=Val_idtipoactividad;
			 
        END$$
DELIMITER ;

DELIMITER $$
  CREATE PROCEDURE `ConsultarHorario`()
  	BEGIN
  
  		SELECT h.idhorario as idhorario,
  		s.nombresede as nombresede,
  		a.nombreambiente as nombreambiente,
  		concat(h.edadmin," año(s) a ",h.edadmax, " año(s)") as dirigido,
  		h.cantsesion as cantsesion,
  		h.horassesion as horassesion,
  		h.vacantemin as vacantemin,
  		h.vacantemax as vacantemax,
  		h.fechainicio as fechainicio,
  		h.fechafin as  fechafin,
  		h.precio as precio
  
  
  		from
  		horario h inner join ambiente a on h.idambiente=a.idambiente
  		 inner join sede s on a.idsede = s.idsede
  		;
  	END ;