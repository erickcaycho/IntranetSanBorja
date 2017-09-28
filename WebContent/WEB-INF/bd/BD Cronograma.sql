
CREATE TABLE `empleado` (
  `codEmpleado` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  `apellidoPat` varchar(45) NOT NULL,
  `apellidoMat` varchar(45) NOT NULL,
  PRIMARY KEY (`codEmpleado`)
) ;

INSERT INTO `educacionculturaturismosb`.`empleado`  (`nombre`,`apellidoPat`,`apellidoMat`)VALUES ('Juan','Pech','Bellido');
INSERT INTO `educacionculturaturismosb`.`empleado`  (`nombre`,`apellidoPat`,`apellidoMat`)VALUES ('Vanessa','Vargas','Ayala');
INSERT INTO `educacionculturaturismosb`.`empleado`  (`nombre`,`apellidoPat`,`apellidoMat`)VALUES ('Pepe','Quintana','Ayala');

CREATE TABLE `cronograma` (
  `idCronograma` int(11) NOT NULL AUTO_INCREMENT,
  `idHorario` int(11) NOT NULL,
  `tarea` varchar(40) NOT NULL,
  `descripcion` varchar(60) NOT NULL,
  `fechaInicio` date NOT NULL,
  `fechaFin` date NOT NULL,
  `fechaEjecucion` date DEFAULT NULL,
  `codEmpleado` int(11) NOT NULL,
  PRIMARY KEY (`idCronograma`),
  FOREIGN KEY `FKcodEmpleado_id`  (codEmpleado) REFERENCES empleado(codEmpleado)
) ;

INSERT INTO `educacionculturaturismosb`.`cronograma` 
(`idHorario`,`tarea`,`descripcion`,`fechaInicio`,`fechaFin`,codEmpleado)
VALUES (2,'tarea1','recolectar nose que cosas','2017-09-19','2017-09-20',1);


/*SELECT CONCAT("SQL ", "Tutorial ", "is ", "fun!") AS ConcatenatedString;*/	
SELECT * FROM educacionculturaturismosb.cronograma where idHorario = 0;

DELIMITER $$
CREATE PROCEDURE `ConsultarCronograma`(IN idHorario int(11), IN idCronograma int(11))
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
END$$;

CALL `educacionculturaturismosb`.`ConsultarCronograma`(2,1);