DROP DATABASE IF EXISTS MUN_SANBORJA;
CREATE DATABASE IF NOT EXISTS MUN_SANBORJA;

USE MUN_SANBORJA;

CREATE TABLE MUN_TIPOSOLICITUD(
IN_IDTIPOLICENCIA INT NOT NULL PRIMARY KEY auto_increment,
VC_NAME varchar (50) NOT NULL,
VC_DETAIL VARCHAR (50) NULL,
DT_REGISTRY DATE NOT NULL);

INSERT INTO mun_tiposolicitud (VC_NAME,VC_DETAIL,DT_REGISTRY) VALUES ('LICENCIA FUNCIONAMIENTO','LICENCIA FUNCIONAMIENTO',current_date());
INSERT INTO mun_tiposolicitud (VC_NAME,VC_DETAIL,DT_REGISTRY) VALUES ('LICENCIA EDIFICACION','LICENCIA EDIFICACION',current_date());

CREATE TABLE MUN_REQUISITO(
IN_IDREQUISITO INT NOT NULL PRIMARY KEY auto_increment,
VC_DESCRIPCION varchar (100) NOT NULL,
DT_REGISTRY DATE NOT NULL,
IN_IDTIPOLICENCIAR INT NOT NULL,
FOREIGN KEY(IN_IDTIPOLICENCIAR) REFERENCES MUN_TIPOSOLICITUD(IN_IDTIPOLICENCIA));

INSERT INTO MUN_REQUISITO (VC_DESCRIPCION,DT_REGISTRY,IN_IDTIPOLICENCIAR) VALUES ('Planos a la vista del inspector',current_date(),1);
INSERT INTO MUN_REQUISITO (VC_DESCRIPCION,DT_REGISTRY,IN_IDTIPOLICENCIAR) VALUES ('Letreros de señalizacion',current_date(),1);
INSERT INTO MUN_REQUISITO (VC_DESCRIPCION,DT_REGISTRY,IN_IDTIPOLICENCIAR) VALUES ('Copia simple del sector correspondiente',current_date(),1);
INSERT INTO MUN_REQUISITO (VC_DESCRIPCION,DT_REGISTRY,IN_IDTIPOLICENCIAR) VALUES ('Copia simple si la actividad economica es relacionado a la salud',current_date(),1);
INSERT INTO MUN_REQUISITO (VC_DESCRIPCION,DT_REGISTRY,IN_IDTIPOLICENCIAR) VALUES ('Buenos materiales',current_date(),2);
INSERT INTO MUN_REQUISITO (VC_DESCRIPCION,DT_REGISTRY,IN_IDTIPOLICENCIAR) VALUES ('Presentar autorizacion del ministerio de transporte y minas',current_date(),2);

CREATE TABLE MUN_TIPODOCUMENTO(
IN_IDTIPODOCUMENTO INT NOT NULL PRIMARY KEY auto_increment,
VC_NAME VARCHAR (30) NOT NULL,
DT_REGISTRY DATE NOT NULL);

INSERT INTO MUN_TIPODOCUMENTO (VC_NAME,DT_REGISTRY) VALUES ('DNI',current_date());
INSERT INTO MUN_TIPODOCUMENTO (VC_NAME,DT_REGISTRY) VALUES ('CE',current_date());
INSERT INTO MUN_TIPODOCUMENTO (VC_NAME,DT_REGISTRY) VALUES ('RUC',current_date());


CREATE TABLE MUN_TIPOPERSONA(
IN_IDTIPOPERSONA INT NOT NULL PRIMARY KEY auto_increment,
VC_NAME VARCHAR (30) NOT NULL,
DT_REGISTRY DATE NOT NULL);

INSERT INTO MUN_TIPOPERSONA (VC_NAME,DT_REGISTRY) VALUES ('PERSONA JURIDICA',current_date());
INSERT INTO MUN_TIPOPERSONA (VC_NAME,DT_REGISTRY) VALUES ('PERSONA NATURAL',current_date());

CREATE TABLE MUN_SOLICITANTE(
IN_IDSOLICITANTE INT NOT NULL PRIMARY KEY auto_increment,
VC_NAME varchar (100) NOT NULL,
VC_LASTNAME varchar (100) NOT NULL,
VC_LASTNAME1 varchar (100) NOT NULL,
VC_MAIL varchar (50) NOT NULL,
VC_PHONE VARCHAR (20) NOT NULL,
VC_NUMBERDOC VARCHAR (15) NOT NULL,
VC_ADDRESS VARCHAR (50) NOT NULL,
DT_REGISTRY DATE NOT NULL,
IN_IDTIPODOCUMENTO INT NOT NULL,
IN_IDTIPOPERSONA INT NOT NULL,
FOREIGN KEY(IN_IDTIPODOCUMENTO) REFERENCES MUN_TIPODOCUMENTO(IN_IDTIPODOCUMENTO),
FOREIGN KEY(IN_IDTIPOPERSONA) REFERENCES MUN_TIPOPERSONA(IN_IDTIPOPERSONA));

INSERT INTO MUN_SOLICITANTE (VC_NAME,VC_LASTNAME,VC_LASTNAME1,VC_MAIL,VC_PHONE,VC_NUMBERDOC,VC_ADDRESS,DT_REGISTRY,IN_IDTIPODOCUMENTO,IN_IDTIPOPERSONA) VALUES ('JOSE IGNACIO','LOPEZ','VALENCIA','joselv772@gmail.com','943946637','46265898','LIMA',current_date(),1,1);
INSERT INTO MUN_SOLICITANTE (VC_NAME,VC_LASTNAME,VC_LASTNAME1,VC_MAIL,VC_PHONE,VC_NUMBERDOC,VC_ADDRESS,DT_REGISTRY,IN_IDTIPODOCUMENTO,IN_IDTIPOPERSONA) VALUES ('JESUS RONAL','GOMEZ','HERRERA','jesu.ronal@gmail.com','959595632','10109311','LIMA',current_date(),1,1);

CREATE TABLE MUN_ESTABLECIMIENTO(
IN_IDESTABLECIMIENTO INT NOT NULL PRIMARY KEY auto_increment,
VC_TRADENAME varchar (100) NOT NULL,
VC_ADDRESS VARCHAR (100) NOT NULL,
DE_SCHEDULE INT NOT NULL,
UNTIL_SCHEDULE INT NOT NULL,
VC_ACTIVITY VARCHAR (50) NOT NULL,
IN_AREA INT NOT NULL,
IN_IDSOLICITANTEE INT NOT NULL,
FOREIGN KEY(IN_IDSOLICITANTEE) REFERENCES MUN_SOLICITANTE(IN_IDSOLICITANTE));

INSERT INTO MUN_ESTABLECIMIENTO (VC_TRADENAME,VC_ADDRESS,DE_SCHEDULE,UNTIL_SCHEDULE,VC_ACTIVITY,IN_AREA,IN_IDSOLICITANTEE) VALUES 
('LA CASA DE PEPITA','LIMA',7,16,'Venta de Comida Rapida',200,1);

INSERT INTO MUN_ESTABLECIMIENTO (VC_TRADENAME,VC_ADDRESS,DE_SCHEDULE,UNTIL_SCHEDULE,VC_ACTIVITY,IN_AREA,IN_IDSOLICITANTEE) VALUES 
('LA TIENDA DE DON PEPE','SAN BORJA SUR, CERCA AL RIO',7,16,'Venta de ABARROTES',200,2);
INSERT INTO MUN_ESTABLECIMIENTO (VC_TRADENAME,VC_ADDRESS,DE_SCHEDULE,UNTIL_SCHEDULE,VC_ACTIVITY,IN_AREA,IN_IDSOLICITANTEE) VALUES 
('SI ENTRAS NO SALES','SAN BORJA NORTE',7,16,'BAR',200,2);
INSERT INTO MUN_ESTABLECIMIENTO (VC_TRADENAME,VC_ADDRESS,DE_SCHEDULE,UNTIL_SCHEDULE,VC_ACTIVITY,IN_AREA,IN_IDSOLICITANTEE) VALUES 
('EL ENCANTO AMAZONICO','SAN BORJA SUR',7,16,'RESTAURANTE',200,1);
INSERT INTO MUN_ESTABLECIMIENTO (VC_TRADENAME,VC_ADDRESS,DE_SCHEDULE,UNTIL_SCHEDULE,VC_ACTIVITY,IN_AREA,IN_IDSOLICITANTEE) VALUES 
('LA LUCHA','SAN BORJA SUR',7,16,'Venta de Comida Rapida',200,1);


CREATE TABLE MUN_SOLICITUD(
IN_IDSOLICITUD INT NOT NULL PRIMARY KEY auto_increment,
DT_REGISTRY DATE NOT NULL,
DT_UPDATE DATE NOT NULL,
CH_STATE VARCHAR(1) NOT NULL,
IN_IDTIPOLICENCIAS INT NOT NULL,
IN_IDSOLICITANTE INT NOT NULL,
IN_IDESTABLECIMIENTO INT NOT NULL,
IN_IDREQUISITO INT NOT NULL,
FOREIGN KEY(IN_IDTIPOLICENCIAS) REFERENCES MUN_TIPOSOLICITUD(IN_IDTIPOLICENCIA),
FOREIGN KEY(IN_IDSOLICITANTE) REFERENCES MUN_SOLICITANTE(IN_IDSOLICITANTE),
FOREIGN KEY(IN_IDESTABLECIMIENTO) REFERENCES MUN_ESTABLECIMIENTO(IN_IDESTABLECIMIENTO),
FOREIGN KEY(IN_IDREQUISITO) REFERENCES MUN_REQUISITO(IN_IDREQUISITO));

INSERT INTO MUN_SOLICITUD (DT_REGISTRY,DT_UPDATE,CH_STATE,IN_IDTIPOLICENCIAS,IN_IDSOLICITANTE,IN_IDESTABLECIMIENTO,IN_IDREQUISITO) VALUES 
(current_date(),current_date(),'4',1,1,1,1);
INSERT INTO MUN_SOLICITUD (DT_REGISTRY,DT_UPDATE,CH_STATE,IN_IDTIPOLICENCIAS,IN_IDSOLICITANTE,IN_IDESTABLECIMIENTO,IN_IDREQUISITO) VALUES 
(current_date(),current_date(),'4',2,2,1,1);
INSERT INTO MUN_SOLICITUD (DT_REGISTRY,DT_UPDATE,CH_STATE,IN_IDTIPOLICENCIAS,IN_IDSOLICITANTE,IN_IDESTABLECIMIENTO,IN_IDREQUISITO) VALUES 
(current_date(),current_date(),'3',2,2,1,1);
INSERT INTO MUN_SOLICITUD (DT_REGISTRY,DT_UPDATE,CH_STATE,IN_IDTIPOLICENCIAS,IN_IDSOLICITANTE,IN_IDESTABLECIMIENTO,IN_IDREQUISITO) VALUES 
(current_date(),current_date(),'2',1,2,1,1);

INSERT INTO MUN_SOLICITUD 
(DT_REGISTRY,DT_UPDATE,CH_STATE,IN_IDTIPOLICENCIAS,IN_IDSOLICITANTE,IN_IDESTABLECIMIENTO,IN_IDREQUISITO) VALUES 
(current_date(),current_date(),'5',1,1,2,1);

INSERT INTO MUN_SOLICITUD 
(DT_REGISTRY,DT_UPDATE,CH_STATE,IN_IDTIPOLICENCIAS,IN_IDSOLICITANTE,IN_IDESTABLECIMIENTO,IN_IDREQUISITO) VALUES 
(current_date(),current_date(),'2',1,1,3,1);

INSERT INTO MUN_SOLICITUD 
(DT_REGISTRY,DT_UPDATE,CH_STATE,IN_IDTIPOLICENCIAS,IN_IDSOLICITANTE,IN_IDESTABLECIMIENTO,IN_IDREQUISITO) VALUES 
(current_date(),current_date(),'2',1,2,1,1);

INSERT INTO MUN_SOLICITUD 
(DT_REGISTRY,DT_UPDATE,CH_STATE,IN_IDTIPOLICENCIAS,IN_IDSOLICITANTE,IN_IDESTABLECIMIENTO,IN_IDREQUISITO) VALUES 
(current_date(),current_date(),'2',1,2,2,1);

INSERT INTO MUN_SOLICITUD 
(DT_REGISTRY,DT_UPDATE,CH_STATE,IN_IDTIPOLICENCIAS,IN_IDSOLICITANTE,IN_IDESTABLECIMIENTO,IN_IDREQUISITO) VALUES 
(current_date(),current_date(),'2',1,1,3,1);

INSERT INTO MUN_SOLICITUD 
(DT_REGISTRY,DT_UPDATE,CH_STATE,IN_IDTIPOLICENCIAS,IN_IDSOLICITANTE,IN_IDESTABLECIMIENTO,IN_IDREQUISITO) VALUES 
(current_date(),current_date(),'2',1,1,4,1);

INSERT INTO MUN_SOLICITUD 
(DT_REGISTRY,DT_UPDATE,CH_STATE,IN_IDTIPOLICENCIAS,IN_IDSOLICITANTE,IN_IDESTABLECIMIENTO,IN_IDREQUISITO) VALUES 
(current_date(),current_date(),'2',1,1,2,1);

INSERT INTO MUN_SOLICITUD 
(DT_REGISTRY,DT_UPDATE,CH_STATE,IN_IDTIPOLICENCIAS,IN_IDSOLICITANTE,IN_IDESTABLECIMIENTO,IN_IDREQUISITO) VALUES 
(current_date(),current_date(),'2',1,2,3,1);

INSERT INTO MUN_SOLICITUD 
(DT_REGISTRY,DT_UPDATE,CH_STATE,IN_IDTIPOLICENCIAS,IN_IDSOLICITANTE,IN_IDESTABLECIMIENTO,IN_IDREQUISITO) VALUES 
(current_date(),current_date(),'2',1,2,3,1);


CREATE VIEW
VISTA_SOLICITUDES (CODIGO,NOMBRE,APELLIDO,APELLIDO1,FECHA,ESTADO) AS SELECT s.IN_IDSOLICITUD,so.VC_NAME, so.VC_LASTNAME,so.VC_LASTNAME1,s.DT_REGISTRY,s.CH_STATE 
FROM mun_solicitud s inner join mun_solicitante so on s.IN_IDSOLICITANTE = so.IN_IDSOLICITANTE;

SELECT * FROM vista_solicitudes;

select * from mun_solicitud order by IN_IDSOLICITUD desc
