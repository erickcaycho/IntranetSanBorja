DELIMITER  
 
    CREATE PROCEDURE validarActividadPorPeriodo(IN Val_idperiodo INT, IN Val_idtipoactividad INT, IN Val_idactividad INT)
        LANGUAGE SQL
        DETERMINISTIC
        SQL SECURITY DEFINER
        BEGIN
			Select count(pl.idplanificacion) as flagactividadperiodo
			from planificacion pl inner join periodo p on pl.idperiodo=p.idperiodo and p.idperiodo=Val_idperiodo
			inner join actividad a on pl.idactividad=a.idactividad and a.idactividad=Val_idactividad
			inner join tipoactividad ta on a.idtipoactividad = ta.idtipoactividad and ta.idtipoactividad=Val_idtipoactividad;
			 
        END;
