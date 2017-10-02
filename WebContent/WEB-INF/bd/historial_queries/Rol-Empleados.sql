DELIMITER $$

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

INSERT INTO educacionculturaturismosb.rol (nombrerol) VALUES('Profesor de Baile');
INSERT INTO educacionculturaturismosb.rol (nombrerol) VALUES('Profesor de Ballet');
INSERT INTO educacionculturaturismosb.rol (nombrerol) VALUES('Expositor de Pintura');

INSERT INTO educacionculturaturismosb.detalle_empleado_rol (idempleado,idrol) VALUES(1,1);
INSERT INTO educacionculturaturismosb.detalle_empleado_rol (idempleado,idrol) VALUES(2,1);
INSERT INTO educacionculturaturismosb.detalle_empleado_rol (idempleado,idrol) VALUES(3,2);



DELIMITER $$