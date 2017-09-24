-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: educacionculturaturismosb
-- ------------------------------------------------------
-- Server version	5.7.19-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `actividad`
--

DROP TABLE IF EXISTS `actividad`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `actividad` (
  `idactividad` int(11) NOT NULL AUTO_INCREMENT,
  `nomactividad` varchar(200) DEFAULT NULL,
  `descripcion` varchar(500) DEFAULT NULL,
  `imagen` varchar(200) DEFAULT NULL,
  `objetivo` varchar(200) DEFAULT NULL,
  `idtipoactividad` int(11) NOT NULL,
  PRIMARY KEY (`idactividad`),
  KEY `fk_actividad_tipoactividad_idx` (`idtipoactividad`),
  CONSTRAINT `fk_actividad_tipoactividad` FOREIGN KEY (`idtipoactividad`) REFERENCES `tipoactividad` (`idtipoactividad`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=67 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `actividad`
--

LOCK TABLES `actividad` WRITE;
/*!40000 ALTER TABLE `actividad` DISABLE KEYS */;
INSERT INTO `actividad` VALUES (1,'Arte country','Elaboraci�n de mu�ecos, pintura en madera, en tela u otros materiales con acabados campestres','  ','  ',1),(2,'Ballet','El ballet es una composici�n de danzas que expresa una idea po�tica, cuyos elementos est�n relacionados por medio de la pantomima; con vestuarios, escenograf�a y m�sica de acompa�amiento.','  ','  ',1),(3,'Guitarra','Instrumento m�s utilizado en g�neros como blues, rock y flamenco, y bastante frecuente en cantautores. Tambi�n es utilizada en g�neros tales como el tango, rancheras y gruperas, adem�s del folclore de varios pa�ses.','  ','  ',1),(4,'Joyer�a artesanal','Elaboraci�n de joyas con material de alpaca, plata, cobre, pitas, cueros u otro material.','  ','  ',1),(5,'Marinera norte�a','La marinera es un baile de pareja suelto, el m�s conocido de la costa del Per�. Se caracteriza por el uso de pa�uelos. Es un baile muestra del mestizaje hispano-amerindio-africano, entre otros.','  ','  ',1),(6,'Pintura en tela ','  ','  ','  ',1),(7,'Reciclado y manualidades','Nada es basura hasta que la botas, te invitamos a nuestro taller de reciclado donde no solo aprender�s a convertir todo lo que piensas que ya no sirve en cosas decorativas, �tiles; y lo m�s importante contribuimos con el MEDIO AMBIENTE! C�mo? Reciclando.. te esperamos!','  ','  ',1),(8,'Teatro','Teatro es una rama del arte esc�nico relacionada con la actuaci�n, donde se representan historias frente a la audiencia. Este arte combina discurso, gestos, sonidos, m�sica y escenograf�a.','  ','  ',1),(9,'Yoga','Se refiere a una tradicional disciplina f�sica y mental que se origin� en la India. La palabra se asocia con pr�cticas de meditaci�n en el hinduismo y el budismo.','  ','  ',1),(10,'Aprestamiento y psicomotricidad','Las actividades de aprestamiento tienen como objetivo estimular, incrementar y desarrollar las habilidades cognitivas, perceptivas y psicomotoras de ni�os y ni�as en edad pre – escolar.','  ','  ',1),(11,'Arte franc�s (manualidades) ','  ','  ','  ',1),(12,'Atenci�n y concentraci�n ','  ','  ','  ',1),(13,'Baile moderno','La combinaci�n de los diferentes ritmos salsa, danza �rabe, samba, axe, merengue, hip-hop, coreograf�as de moda.','  ','  ',1),(14,'Bailes de sal�n ','  ','  ','  ',1),(15,'Bomberitos ','  ','  ','  ',1),(16,'Caj�n','  ','  ','  ',1),(17,'Canto','Desarrollar, reforzar mantener y mejorar tu voz cantada utilizando una t�cnica de f�cil asimilaci�n y resultados sorprendentes.','  ','  ',1),(18,'Cer�mica al frio','La cer�mica en fr�o es una masa d�cil, limpia y de una suave textura. Las piezas tienen un acabado similar a la porcelana horneada pero no necesitan cocci�n ya que se endurece con el s�lo contacto con el aire.','  ','  ',1),(19,'Comunicaci�n efectiva ','  ','  ','  ',1),(20,'Danza �rabe','Mucho m�s que un movimiento de caderas, esta danza es la uni�n entre el cuerpo y el alma. Bajo este concepto muchas mujeres est�n optando por este baile para reencontrarse con s� mismas.','  ','  ',1),(21,'Danzas afroperuanas ','  ','  ','  ',1),(22,'Danzas andinas y afro ','  ','  ','  ',1),(23,'Danzas espa�olas y flamenco ','  ','  ','  ',1),(24,'Danzas folkloricas ','  ','  ','  ',1),(25,'Decoraci�n de tortas ','  ','  ','  ',1),(26,'Dibujo y pintura','El dibujo es una forma de expresi�n gr�fica, plasmando im�genes sobre un espacio plano, por lo que forma parte de la bella arte conocida como pintura.','  ','  ',1),(27,'El arte de crecer ','  ','  ','  ',1),(28,'Estimulaci�n del aprendizaje ','  ','  ','  ',1),(29,'Estimulaci�n musical ','  ','  ','  ',1),(30,'Expresi�n oral y oratoria','La expresi�n oral es �til para comunicarse mejor. Usted tendr� ventaja sobre los dem�s al desarrollar esta destreza. Con mayor claridad y precisi�n se abrir� camino en la vida con mayor rapidez, porque el arte de hablar es el arte de persuadir.','  ','  ',1),(31,'Filigrana en papel (manualidades) ','  ','  ','  ',1),(32,'Tango','El tango es un g�nero musical tradicional de Argentina y Uruguay, nacido de la fusi�n cultural entre emigrantes europeos, descendientes de esclavos africanos y de los nativos de la regi�n del R�o de la Plata.','  ','  ',1),(33,'Salsa','Es una m�sica y concepto popular, una reconciliaci�n musical de nuestra naturaleza como latinoamericanos, un poquito de todo reunirse y sentir una masa latina. Era como romper caderas.','  ','  ',1),(34,'Bijuoter�a','Se denomina bijuoter�a a la industria que produce objetos o materiales de adorno que imitan a la joyer�a pero que est�n hechos de materiales no preciosos.','  ','  ',1),(35,'Minichef','Divertidas clases de cocina 100% pr�cticas para el engre�do de la casa. Les permitir� a los chicos que loguen satisfacer una necesidad b�sica como la alimentaci�n jugando y aprendiendo comidas nutritivas y as� puedan demostrar el amor a sus seres queridos mediante su obra.','  ','  ',1),(36,'Milonga','El baile de milonga se basa en movimientos similares a los del tango, pero es bailado m�s r�pido y con movimientos m�s relajados. Por lo tanto, el tango y la milonga est�n fuertemente relacionados el uno con el otro.','  ','  ',1),(37,'Teatro Mimo Clown','Teatro es una rama del arte esc�nico relacionada con la actuaci�n, donde se representan historias frente a la audiencia. Este arte combina discurso, gestos, sonidos, m�sica y escenograf�a.','  ','  ',1),(38,'Cuadro texturado','Desarrollo de diversas t�cnicas de pintado b�sico, texturas, t�cnicas mixtas (oleo y acr�lico), t�cnicas de espacios acabados; tratando de obtener combinaciones rusticas con lo moderno.','  ','  ',1),(39,'Pintura en madera','Se desarrollan diversas t�cnicas para pintar aplicaciones de resina, flotado, decoupaje, aplicaciones; decorando salas, dormitorios u oficinas.','  ','  ',1),(40,'Mam� chef','Es una idea fant�stica para ayudar a mama este verano para que se entretenga y aprenda nuevos platos que hagan disfrutar a su familia.','  ','  ',1),(41,'Hip hop','Sin reglas. Fusiones musicales. Se reincorpora sonidos el�ctricos, et�reos, densos, y a la vez que se une con la fuerza, la explosividad y las distorsiones de un rock m�s duro, evolucionando tanto l�rica como musicalmente.','  ','  ',1),(42,'Caritas pintadas','Caracterizaci�n, maquillaje art�stico, maquillaje infantil y maquillaje de fantas�a.','  ','  ',1),(43,'Magia','Talleres de magia para ni�os con el objetivo de introducirles en el maravilloso arte de la magia, los ni�os aprender�n diversos trucos explicados por un mago profesional que har� que todos los ni�os disfruten, se diviertan y aprender�n.','  ','  ',1),(44,'Manicure y Dise�o de U�as','Aprende a realizar Manicure Profesional, u�as Acrilicas, Gel y con estas clases aprender�s a dejarlas preciosas y muy duraderas, y unas manos lindas y muy femeninas','  ',' ',1),(45,'Mini Pasteleritos','Los ni�os aprender�n a elaborar diferentes tipos de pasteles, tortas que los motivaran a su sensibilidad y curiosidad hacia la cocina en general para su propio desarrollo.','  ','  ',1),(46,'Matem�ticas','Utilizar sus conocimientos matem�ticos y su capacidad de razonamiento en un ambiente pr�ximo a la vida cotidiana, para resolver situaciones y problemas reales y/o l�dicos.','  ','  ',1),(47,'Baile de sal�n','El ballroom dance (o bailes de sal�n) es un conjunto bailes en parejas que se realizan de manera coordinada y al ritmo de m�scas seleccionadas practicados social y competitivamente por todo el mundo.','  ','  ',1),(48,'Scrapbooking','El scrapbook o scrapbooking consiste en multitud de procesos creativos como el recorte, pegado o collage para crear una composicion de memorias y recuerdos mediante tus fotografias.','  ','  ',1),(49,'Arte y Juego Samikay','Esta basado en el arte en todas sus expresiones, acompa�ado de actividades ludicas recreativas que se sostienen fundamentalmente en la corriente holistica, destacando la importancia y necesidad de la musicoterapia, cromoterapia, aromaterapia y danza terapia por excelencia.','  ','  ',1),(50,'Circuito Nro. 1: Casa Kallpa Wasi (Casa de energ�a) - Planta biof�sica de tratamiento de agua - Huaca San Borja	 ','  ','  ','  ',2),(51,'Circuito Nro. 2: Huaca San Borja - Museo de la Naci�n - Biblioteca Nacional del Per�	 ','  ','  ','  ',2),(52,'Circuito Nro. 3: Gran Teatro Nacional - Museo de la Naci�n - Huaca San Borja	 ','  ','  ','  ',2),(53,'Circuito Nro. 4: Museo de la Naci�n - Gran Teatro Nacional - Biblioteca Nacional del Per�	 ','  ','  ','  ',2),(54,'Circuito Nro. 5: Huaca San Borja - Museo de la Naci�n - Gran Teatro Nacional - Biblioteca Nacional del Per�	 ','  ','  ','  ',2),(55,'Clases de Ingl�s ',' ',' ',' ',4),(56,'Programa de Ciegos con Visi�n, Computaci�n Adaptada ',' ',' ',' ',4),(57,'Clases de Computaci�n ',' ',' ',' ',4),(58,'Programa Lee, San Borja Lee ',' ',' ',' ',4),(59,'Cine Club para Invidentes ',' ',' ',' ',4),(60,'	\"Bridge en el Tambo\"	 ','  ','  ','  ',5),(61,'	Cine en el Tambo \"Semana Santa\"	 ','  ','  ','  ',5),(62,'	Cine en el Tambo \"Invictus\"	 ','  ','  ','  ',5),(63,'	Teatro para Ni�os \"La gallina sembradora\"	 ','  ','  ','  ',5),(64,'	Cine en el Tambo \"Los tuyos, los m�os, los nuestros\"	 ','  ','  ','  ',5),(65,'	Cine en el Tambo \"Conversaciones con mam�\"	 ','  ','  ','  ',5),(66,'	\"Actualizaci�n Pedag�gicas sobre el Sistema de Gesti�n de la Calidad rumbo a la Acreditaci�n\" dirigida a Instituciones Educativas del Distrito	 ','  ','  ','  ',3);
/*!40000 ALTER TABLE `actividad` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `periodo`
--

DROP TABLE IF EXISTS `periodo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `periodo` (
  `idperiodo` int(11) NOT NULL AUTO_INCREMENT,
  `nomperiodo` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`idperiodo`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `periodo`
--

LOCK TABLES `periodo` WRITE;
/*!40000 ALTER TABLE `periodo` DISABLE KEYS */;
INSERT INTO `periodo` VALUES (1,'2017-1'),(2,'2017-2'),(3,'2017-3'),(4,'2017-4');
/*!40000 ALTER TABLE `periodo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `planificacion`
--

DROP TABLE IF EXISTS `planificacion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `planificacion` (
  `idplanificacion` int(11) NOT NULL AUTO_INCREMENT,
  `fechacreacion` date DEFAULT NULL,
  `fechaplanificacion` date DEFAULT NULL,
  `fecharechazo` date DEFAULT NULL,
  `fechaaprobacion` date DEFAULT NULL,
  `idperiodo` int(11) NOT NULL,
  `idactividad` int(11) NOT NULL,
  `fechaanulacion` date DEFAULT NULL,
  `estado` int(11) DEFAULT NULL,
  `fechaejecucion` date DEFAULT NULL,
  PRIMARY KEY (`idplanificacion`),
  KEY `fk_planificacion_periodo1_idx` (`idperiodo`),
  KEY `fk_planificacion_actividad1_idx` (`idactividad`),
  CONSTRAINT `fk_planificacion_actividad1` FOREIGN KEY (`idactividad`) REFERENCES `actividad` (`idactividad`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_planificacion_periodo1` FOREIGN KEY (`idperiodo`) REFERENCES `periodo` (`idperiodo`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=141 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `planificacion`
--

LOCK TABLES `planificacion` WRITE;
/*!40000 ALTER TABLE `planificacion` DISABLE KEYS */;
INSERT INTO `planificacion` VALUES (1,'2017-09-19',NULL,NULL,NULL,1,4,NULL,1,NULL),(2,'2017-09-19',NULL,NULL,NULL,2,6,NULL,1,NULL),(3,'2017-09-19',NULL,NULL,NULL,1,66,NULL,1,NULL),(4,'2017-09-19',NULL,NULL,NULL,1,66,NULL,1,NULL),(5,'2017-09-19',NULL,NULL,NULL,2,51,NULL,1,NULL),(6,'2017-09-19',NULL,NULL,NULL,4,53,NULL,1,NULL),(7,'2017-09-19',NULL,NULL,NULL,2,66,NULL,1,NULL),(8,'2017-09-19',NULL,NULL,NULL,3,2,NULL,1,NULL),(9,'2017-09-19',NULL,NULL,NULL,4,45,NULL,1,NULL),(10,'2017-09-19',NULL,NULL,NULL,4,43,NULL,1,NULL),(11,'2017-09-19',NULL,NULL,NULL,4,43,NULL,1,NULL),(12,'2017-09-19',NULL,NULL,NULL,4,43,NULL,1,NULL),(13,'2017-09-20',NULL,NULL,NULL,2,3,NULL,1,NULL),(14,'2017-09-20',NULL,NULL,NULL,2,3,NULL,1,NULL),(15,'2017-09-20',NULL,NULL,NULL,2,3,NULL,1,NULL),(16,'2017-09-20',NULL,NULL,NULL,2,3,NULL,1,NULL),(17,'2017-09-20',NULL,NULL,NULL,2,3,NULL,1,NULL),(18,'2017-09-20',NULL,NULL,NULL,2,3,NULL,1,NULL),(19,'2017-09-20',NULL,NULL,NULL,2,3,NULL,1,NULL),(20,'2017-09-20',NULL,NULL,NULL,2,3,NULL,1,NULL),(21,'2017-09-20',NULL,NULL,NULL,2,3,NULL,1,NULL),(22,'2017-09-20',NULL,NULL,NULL,2,3,NULL,1,NULL),(23,'2017-09-20',NULL,NULL,NULL,2,3,NULL,1,NULL),(24,'2017-09-20',NULL,NULL,NULL,2,3,NULL,1,NULL),(25,'2017-09-20',NULL,NULL,NULL,2,3,NULL,1,NULL),(26,'2017-09-20',NULL,NULL,NULL,2,3,NULL,1,NULL),(27,'2017-09-20',NULL,NULL,NULL,2,3,NULL,1,NULL),(28,'2017-09-20',NULL,NULL,NULL,2,3,NULL,1,NULL),(29,'2017-09-20',NULL,NULL,NULL,2,3,NULL,1,NULL),(30,'2017-09-20',NULL,NULL,NULL,2,3,NULL,1,NULL),(31,'2017-09-20',NULL,NULL,NULL,2,3,NULL,1,NULL),(32,'2017-09-20',NULL,NULL,NULL,2,3,NULL,1,NULL),(33,'2017-09-20',NULL,NULL,NULL,2,3,NULL,1,NULL),(34,'2017-09-20',NULL,NULL,NULL,2,3,NULL,1,NULL),(35,'2017-09-21',NULL,NULL,NULL,1,50,NULL,1,NULL),(36,'2017-09-22',NULL,NULL,NULL,2,1,NULL,1,NULL),(37,'2017-09-22',NULL,NULL,NULL,2,1,NULL,1,NULL),(38,'2017-09-22',NULL,NULL,NULL,2,1,NULL,1,NULL),(39,'2017-09-22',NULL,NULL,NULL,2,1,NULL,1,NULL),(40,'2017-09-22',NULL,NULL,NULL,2,1,NULL,1,NULL),(41,'2017-09-22',NULL,NULL,NULL,2,1,NULL,1,NULL),(42,'2017-09-22',NULL,NULL,NULL,2,1,NULL,1,NULL),(43,'2017-09-22',NULL,NULL,NULL,2,1,NULL,1,NULL),(44,'2017-09-22',NULL,NULL,NULL,2,1,NULL,1,NULL),(45,'2017-09-22',NULL,NULL,NULL,2,1,NULL,1,NULL),(46,'2017-09-22',NULL,NULL,NULL,2,1,NULL,1,NULL),(47,'2017-09-22',NULL,NULL,NULL,2,1,NULL,1,NULL),(48,'2017-09-22',NULL,NULL,NULL,2,1,NULL,1,NULL),(49,'2017-09-22',NULL,NULL,NULL,2,4,NULL,1,NULL),(50,'2017-09-22',NULL,NULL,NULL,2,56,NULL,1,NULL),(51,'2017-09-22',NULL,NULL,NULL,2,1,NULL,1,NULL),(52,'2017-09-22',NULL,NULL,NULL,2,1,NULL,1,NULL),(53,'2017-09-22',NULL,NULL,NULL,2,33,NULL,1,NULL),(54,'2017-09-22',NULL,NULL,NULL,2,50,NULL,1,NULL),(55,'2017-09-22',NULL,NULL,NULL,2,50,NULL,1,NULL),(56,'2017-09-22',NULL,NULL,NULL,2,50,NULL,1,NULL),(57,'2017-09-22',NULL,NULL,NULL,2,50,NULL,1,NULL),(58,'2017-09-22',NULL,NULL,NULL,2,50,NULL,1,NULL),(59,'2017-09-22',NULL,NULL,NULL,2,50,NULL,1,NULL),(60,'2017-09-22',NULL,NULL,NULL,2,50,NULL,1,NULL),(61,'2017-09-22',NULL,NULL,NULL,2,50,NULL,1,NULL),(62,'2017-09-22',NULL,NULL,NULL,2,50,NULL,1,NULL),(63,'2017-09-22',NULL,NULL,NULL,2,50,NULL,1,NULL),(64,'2017-09-22',NULL,NULL,NULL,2,50,NULL,1,NULL),(65,'2017-09-22',NULL,NULL,NULL,2,50,NULL,1,NULL),(66,'2017-09-22',NULL,NULL,NULL,2,50,NULL,1,NULL),(67,'2017-09-22',NULL,NULL,NULL,2,50,NULL,1,NULL),(68,'2017-09-22',NULL,NULL,NULL,2,50,NULL,1,NULL),(69,'2017-09-22',NULL,NULL,NULL,2,50,NULL,1,NULL),(70,'2017-09-22',NULL,NULL,NULL,2,50,NULL,1,NULL),(71,'2017-09-22',NULL,NULL,NULL,2,50,NULL,1,NULL),(72,'2017-09-22',NULL,NULL,NULL,2,50,NULL,1,NULL),(73,'2017-09-22',NULL,NULL,NULL,2,50,NULL,1,NULL),(74,'2017-09-22',NULL,NULL,NULL,2,50,NULL,1,NULL),(75,'2017-09-22',NULL,NULL,NULL,2,50,NULL,1,NULL),(76,'2017-09-22',NULL,NULL,NULL,2,50,NULL,1,NULL),(77,'2017-09-22',NULL,NULL,NULL,2,50,NULL,1,NULL),(78,'2017-09-22',NULL,NULL,NULL,2,50,NULL,1,NULL),(79,'2017-09-22',NULL,NULL,NULL,2,50,NULL,1,NULL),(80,'2017-09-22',NULL,NULL,NULL,2,50,NULL,1,NULL),(81,'2017-09-22',NULL,NULL,NULL,2,50,NULL,1,NULL),(82,'2017-09-22',NULL,NULL,NULL,2,50,NULL,1,NULL),(83,'2017-09-22',NULL,NULL,NULL,2,50,NULL,1,NULL),(84,'2017-09-22',NULL,NULL,NULL,2,50,NULL,1,NULL),(85,'2017-09-22',NULL,NULL,NULL,2,50,NULL,1,NULL),(86,'2017-09-22',NULL,NULL,NULL,2,50,NULL,1,NULL),(87,'2017-09-22',NULL,NULL,NULL,2,51,NULL,1,NULL),(88,'2017-09-22',NULL,NULL,NULL,2,54,NULL,1,NULL),(89,'2017-09-22',NULL,NULL,NULL,1,1,NULL,1,NULL),(90,'2017-09-22',NULL,NULL,NULL,1,2,NULL,1,NULL),(91,'2017-09-22',NULL,NULL,NULL,1,2,NULL,1,NULL),(92,'2017-09-22',NULL,NULL,NULL,1,2,NULL,1,NULL),(93,'2017-09-22',NULL,NULL,NULL,1,2,NULL,1,NULL),(94,'2017-09-22',NULL,NULL,NULL,1,2,NULL,1,NULL),(95,'2017-09-22',NULL,NULL,NULL,1,2,NULL,1,NULL),(96,'2017-09-22',NULL,NULL,NULL,1,2,NULL,1,NULL),(97,'2017-09-22',NULL,NULL,NULL,1,2,NULL,1,NULL),(98,'2017-09-22',NULL,NULL,NULL,1,2,NULL,1,NULL),(99,'2017-09-22',NULL,NULL,NULL,1,2,NULL,1,NULL),(100,'2017-09-22',NULL,NULL,NULL,1,2,NULL,1,NULL),(101,'2017-09-22',NULL,NULL,NULL,1,2,NULL,1,NULL),(102,'2017-09-22',NULL,NULL,NULL,1,2,NULL,1,NULL),(103,'2017-09-22',NULL,NULL,NULL,1,2,NULL,1,NULL),(104,'2017-09-22',NULL,NULL,NULL,1,2,NULL,1,NULL),(105,'2017-09-22',NULL,NULL,NULL,1,2,NULL,1,NULL),(106,'2017-09-22',NULL,NULL,NULL,1,2,NULL,1,NULL),(107,'2017-09-22',NULL,NULL,NULL,1,2,NULL,1,NULL),(108,'2017-09-22',NULL,NULL,NULL,1,2,NULL,1,NULL),(109,'2017-09-22',NULL,NULL,NULL,1,2,NULL,1,NULL),(110,'2017-09-22',NULL,NULL,NULL,1,2,NULL,1,NULL),(111,'2017-09-22',NULL,NULL,NULL,1,2,NULL,1,NULL),(112,'2017-09-22',NULL,NULL,NULL,1,2,NULL,1,NULL),(113,'2017-09-22',NULL,NULL,NULL,1,2,NULL,1,NULL),(114,'2017-09-22',NULL,NULL,NULL,1,2,NULL,1,NULL),(115,'2017-09-22',NULL,NULL,NULL,1,2,NULL,1,NULL),(116,'2017-09-22',NULL,NULL,NULL,1,2,NULL,1,NULL),(117,'2017-09-22',NULL,NULL,NULL,1,2,NULL,1,NULL),(118,'2017-09-22',NULL,NULL,NULL,1,2,NULL,1,NULL),(119,'2017-09-22',NULL,NULL,NULL,1,2,NULL,1,NULL),(120,'2017-09-22',NULL,NULL,NULL,1,2,NULL,1,NULL),(121,'2017-09-22',NULL,NULL,NULL,1,2,NULL,1,NULL),(122,'2017-09-22',NULL,NULL,NULL,1,2,NULL,1,NULL),(123,'2017-09-22',NULL,NULL,NULL,1,2,NULL,1,NULL),(124,'2017-09-22',NULL,NULL,NULL,1,2,NULL,1,NULL),(125,'2017-09-22',NULL,NULL,NULL,1,2,NULL,1,NULL),(126,'2017-09-22',NULL,NULL,NULL,1,2,NULL,1,NULL),(127,'2017-09-22',NULL,NULL,NULL,1,2,NULL,1,NULL),(128,'2017-09-22',NULL,NULL,NULL,1,2,NULL,1,NULL),(129,'2017-09-22',NULL,NULL,NULL,1,2,NULL,1,NULL),(130,'2017-09-22',NULL,NULL,NULL,1,59,NULL,1,NULL),(131,'2017-09-22',NULL,NULL,NULL,1,59,NULL,1,NULL),(132,'2017-09-22',NULL,NULL,NULL,1,59,NULL,1,NULL),(133,'2017-09-22',NULL,NULL,NULL,1,66,NULL,1,NULL),(134,'2017-09-22',NULL,NULL,NULL,1,66,NULL,1,NULL),(135,'2017-09-22',NULL,NULL,NULL,1,66,NULL,1,NULL),(136,'2017-09-22',NULL,NULL,NULL,1,26,NULL,1,NULL),(137,'2017-09-22',NULL,NULL,NULL,1,24,NULL,1,NULL),(138,'2017-09-22',NULL,NULL,NULL,1,27,NULL,1,NULL),(139,'2017-09-22',NULL,NULL,NULL,1,51,NULL,1,NULL),(140,'2017-09-22',NULL,NULL,NULL,1,53,NULL,1,NULL);
/*!40000 ALTER TABLE `planificacion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipoactividad`
--

DROP TABLE IF EXISTS `tipoactividad`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tipoactividad` (
  `idtipoactividad` int(11) NOT NULL AUTO_INCREMENT,
  `nomtipoactividad` varchar(200) DEFAULT NULL,
  `descripcion` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`idtipoactividad`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipoactividad`
--

LOCK TABLES `tipoactividad` WRITE;
/*!40000 ALTER TABLE `tipoactividad` DISABLE KEYS */;
INSERT INTO `tipoactividad` VALUES (1,'Taller','Posicionarnos en la comunidad como la mejor opci�n de talleres art�sticos y culturales, obteniendo un crecimiento sostenido con el tiempo'),(2,'Visita Tur�stica','El objetivo de los circuitos es promocionar los atractivos tur�sticos con los que cuenta el distrito de San Borja, lograr que el distrito no solo sea conocido por sus parques verdes sino tambi�n porque tiene turismo para ofrecer y apoyar.'),(3,'Charla','Fomentar la cultura a los vecinos de San Borja'),(4,'Programa Extensi�n Bibliotecaria','Fomentar la educaci�n, arte y cultura a los vecinos de San Borja'),(5,'Evento cultural','Fomentar la educaci�n, arte y cultura a los vecinos de San Borja');
/*!40000 ALTER TABLE `tipoactividad` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'educacionculturaturismosb'
--
/*!50003 DROP PROCEDURE IF EXISTS `obtenerPlanificacionXPeriodoXActividad` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
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
        END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `validarActividadPorPeriodo` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `validarActividadPorPeriodo`(IN Val_idperiodo INT, IN Val_idtipoactividad INT, IN Val_idactividad INT)
    DETERMINISTIC
BEGIN
			Select count(pl.idplanificacion) as flagactividadperiodo
			from planificacion pl inner join periodo p on pl.idperiodo=p.idperiodo and p.idperiodo=Val_idperiodo
			inner join actividad a on pl.idactividad=a.idactividad and a.idactividad=Val_idactividad
			inner join tipoactividad ta on a.idtipoactividad = ta.idtipoactividad and ta.idtipoactividad=Val_idtipoactividad;
			 
        END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-09-22 11:43:46
