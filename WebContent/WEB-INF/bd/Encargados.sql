DELIMITER $$

USE `educacionculturaturismosb` ;
 
DROP TABLE IF EXISTS  educacionculturaturismosb.detalle_empleado_rol;
DROP TABLE IF EXISTS  educacionculturaturismosb.rol;

CREATE TABLE educacionculturaturismosb.rol (
  idrol INT NOT NULL AUTO_INCREMENT,
  nombrerol VARCHAR(100) NOT NULL,
  PRIMARY KEY (idrol)
);


CREATE TABLE  educacionculturaturismosb.detalle_empleado_rol (
  idempleado INT NOT NULL ,
  idrol INT NOT NULL,
  PRIMARY KEY (idempleado,idrol),
  CONSTRAINT `FK_deta_idempleado` FOREIGN KEY  (idempleado) REFERENCES empleado(idempleado),
  CONSTRAINT `FK_deta_idrol`      FOREIGN KEY  (idrol) REFERENCES rol(idrol)
);

INSERT INTO `empleado` VALUES (24,'Elma','Canon','Suarez',60786835,6783456,658794123,'Mz L San Pedro, Lima','ecanon@gmail.com'),
(25,'Elver','Santana','Ayala',65457824,5678903,998403895,'San Miguel, Lima','esantana@gmail.com'),
(26,'Fernando','Santos','Diaz',12345678,098765,994567012,'Pard cuadra 7 Miraflores, Lima','fsantos@gmail.com');
 
INSERT INTO educacionculturaturismosb.rol (nombrerol) VALUES('Profesor de Baile');
INSERT INTO educacionculturaturismosb.rol (nombrerol) VALUES('Profesor de Ballet');
INSERT INTO educacionculturaturismosb.rol (nombrerol) VALUES('Expositor de Pintura');

INSERT INTO educacionculturaturismosb.detalle_empleado_rol (idempleado,idrol) VALUES(1,1);
INSERT INTO educacionculturaturismosb.detalle_empleado_rol (idempleado,idrol) VALUES(2,1);
INSERT INTO educacionculturaturismosb.detalle_empleado_rol (idempleado,idrol) VALUES(3,2);
INSERT INTO educacionculturaturismosb.detalle_empleado_rol (idempleado,idrol) VALUES(24,2);
INSERT INTO educacionculturaturismosb.detalle_empleado_rol (idempleado,idrol) VALUES(25,3);
INSERT INTO educacionculturaturismosb.detalle_empleado_rol (idempleado,idrol) VALUES(26,3);


DELIMITER $$