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
INSERT INTO `actividad` VALUES (1,'Arte country','Elaboración de muñecos, pintura en madera, en tela u otros materiales con acabados campestres','  ','  ',1),(2,'Ballet','El ballet es una composición de danzas que expresa una idea poética, cuyos elementos están relacionados por medio de la pantomima; con vestuarios, escenografía y música de acompañamiento.','  ','  ',1),(3,'Guitarra','Instrumento más utilizado en géneros como blues, rock y flamenco, y bastante frecuente en cantautores. También es utilizada en géneros tales como el tango, rancheras y gruperas, además del folclore de varios países.','  ','  ',1),(4,'Joyería artesanal','Elaboración de joyas con material de alpaca, plata, cobre, pitas, cueros u otro material.','  ','  ',1),(5,'Marinera norteña','La marinera es un baile de pareja suelto, el más conocido de la costa del Perú. Se caracteriza por el uso de pañuelos. Es un baile muestra del mestizaje hispano-amerindio-africano, entre otros.','  ','  ',1),(6,'Pintura en tela ','  ','  ','  ',1),(7,'Reciclado y manualidades','Nada es basura hasta que la botas, te invitamos a nuestro taller de reciclado donde no solo aprenderás a convertir todo lo que piensas que ya no sirve en cosas decorativas, útiles; y lo más importante contribuimos con el MEDIO AMBIENTE! Cómo? Reciclando.. te esperamos!','  ','  ',1),(8,'Teatro','Teatro es una rama del arte escénico relacionada con la actuación, donde se representan historias frente a la audiencia. Este arte combina discurso, gestos, sonidos, música y escenografía.','  ','  ',1),(9,'Yoga','Se refiere a una tradicional disciplina física y mental que se originó en la India. La palabra se asocia con prácticas de meditación en el hinduismo y el budismo.','  ','  ',1),(10,'Aprestamiento y psicomotricidad','Las actividades de aprestamiento tienen como objetivo estimular, incrementar y desarrollar las habilidades cognitivas, perceptivas y psicomotoras de niños y niñas en edad pre – escolar.','  ','  ',1),(11,'Arte francés (manualidades) ','  ','  ','  ',1),(12,'Atención y concentración ','  ','  ','  ',1),(13,'Baile moderno','La combinación de los diferentes ritmos salsa, danza árabe, samba, axe, merengue, hip-hop, coreografías de moda.','  ','  ',1),(14,'Bailes de salón ','  ','  ','  ',1),(15,'Bomberitos ','  ','  ','  ',1),(16,'Cajón','  ','  ','  ',1),(17,'Canto','Desarrollar, reforzar mantener y mejorar tu voz cantada utilizando una técnica de fácil asimilación y resultados sorprendentes.','  ','  ',1),(18,'Cerámica al frio','La cerámica en frío es una masa dócil, limpia y de una suave textura. Las piezas tienen un acabado similar a la porcelana horneada pero no necesitan cocción ya que se endurece con el sólo contacto con el aire.','  ','  ',1),(19,'Comunicación efectiva ','  ','  ','  ',1),(20,'Danza árabe','Mucho más que un movimiento de caderas, esta danza es la unión entre el cuerpo y el alma. Bajo este concepto muchas mujeres están optando por este baile para reencontrarse con sí mismas.','  ','  ',1),(21,'Danzas afroperuanas ','  ','  ','  ',1),(22,'Danzas andinas y afro ','  ','  ','  ',1),(23,'Danzas españolas y flamenco ','  ','  ','  ',1),(24,'Danzas folkloricas ','  ','  ','  ',1),(25,'Decoración de tortas ','  ','  ','  ',1),(26,'Dibujo y pintura','El dibujo es una forma de expresión gráfica, plasmando imágenes sobre un espacio plano, por lo que forma parte de la bella arte conocida como pintura.','  ','  ',1),(27,'El arte de crecer ','  ','  ','  ',1),(28,'Estimulación del aprendizaje ','  ','  ','  ',1),(29,'Estimulación musical ','  ','  ','  ',1),(30,'Expresión oral y oratoria','La expresión oral es útil para comunicarse mejor. Usted tendrá ventaja sobre los demás al desarrollar esta destreza. Con mayor claridad y precisión se abrirá camino en la vida con mayor rapidez, porque el arte de hablar es el arte de persuadir.','  ','  ',1),(31,'Filigrana en papel (manualidades) ','  ','  ','  ',1),(32,'Tango','El tango es un género musical tradicional de Argentina y Uruguay, nacido de la fusión cultural entre emigrantes europeos, descendientes de esclavos africanos y de los nativos de la región del Río de la Plata.','  ','  ',1),(33,'Salsa','Es una música y concepto popular, una reconciliación musical de nuestra naturaleza como latinoamericanos, un poquito de todo reunirse y sentir una masa latina. Era como romper caderas.','  ','  ',1),(34,'Bijuotería','Se denomina bijuotería a la industria que produce objetos o materiales de adorno que imitan a la joyería pero que están hechos de materiales no preciosos.','  ','  ',1),(35,'Minichef','Divertidas clases de cocina 100% prácticas para el engreído de la casa. Les permitirá a los chicos que loguen satisfacer una necesidad básica como la alimentación jugando y aprendiendo comidas nutritivas y así puedan demostrar el amor a sus seres queridos mediante su obra.','  ','  ',1),(36,'Milonga','El baile de milonga se basa en movimientos similares a los del tango, pero es bailado más rápido y con movimientos más relajados. Por lo tanto, el tango y la milonga están fuertemente relacionados el uno con el otro.','  ','  ',1),(37,'Teatro Mimo Clown','Teatro es una rama del arte escénico relacionada con la actuación, donde se representan historias frente a la audiencia. Este arte combina discurso, gestos, sonidos, música y escenografía.','  ','  ',1),(38,'Cuadro texturado','Desarrollo de diversas técnicas de pintado básico, texturas, técnicas mixtas (oleo y acrílico), técnicas de espacios acabados; tratando de obtener combinaciones rusticas con lo moderno.','  ','  ',1),(39,'Pintura en madera','Se desarrollan diversas técnicas para pintar aplicaciones de resina, flotado, decoupaje, aplicaciones; decorando salas, dormitorios u oficinas.','  ','  ',1),(40,'Mamá chef','Es una idea fantástica para ayudar a mama este verano para que se entretenga y aprenda nuevos platos que hagan disfrutar a su familia.','  ','  ',1),(41,'Hip hop','Sin reglas. Fusiones musicales. Se reincorpora sonidos eléctricos, etéreos, densos, y a la vez que se une con la fuerza, la explosividad y las distorsiones de un rock más duro, evolucionando tanto lírica como musicalmente.','  ','  ',1),(42,'Caritas pintadas','Caracterización, maquillaje artístico, maquillaje infantil y maquillaje de fantasía.','  ','  ',1),(43,'Magia','Talleres de magia para niños con el objetivo de introducirles en el maravilloso arte de la magia, los niños aprenderán diversos trucos explicados por un mago profesional que hará que todos los niños disfruten, se diviertan y aprenderán.','  ','  ',1),(44,'Manicure y Diseño de Uñas','Aprende a realizar Manicure Profesional, uñas Acrilicas, Gel y con estas clases aprenderás a dejarlas preciosas y muy duraderas, y unas manos lindas y muy femeninas','  ',' ',1),(45,'Mini Pasteleritos','Los niños aprenderán a elaborar diferentes tipos de pasteles, tortas que los motivaran a su sensibilidad y curiosidad hacia la cocina en general para su propio desarrollo.','  ','  ',1),(46,'Matemáticas','Utilizar sus conocimientos matemáticos y su capacidad de razonamiento en un ambiente próximo a la vida cotidiana, para resolver situaciones y problemas reales y/o lúdicos.','  ','  ',1),(47,'Baile de salón','El ballroom dance (o bailes de salón) es un conjunto bailes en parejas que se realizan de manera coordinada y al ritmo de múscas seleccionadas practicados social y competitivamente por todo el mundo.','  ','  ',1),(48,'Scrapbooking','El scrapbook o scrapbooking consiste en multitud de procesos creativos como el recorte, pegado o collage para crear una composicion de memorias y recuerdos mediante tus fotografias.','  ','  ',1),(49,'Arte y Juego Samikay','Esta basado en el arte en todas sus expresiones, acompañado de actividades ludicas recreativas que se sostienen fundamentalmente en la corriente holistica, destacando la importancia y necesidad de la musicoterapia, cromoterapia, aromaterapia y danza terapia por excelencia.','  ','  ',1),(50,'Circuito Nro. 1: Casa Kallpa Wasi (Casa de energía) - Planta biofísica de tratamiento de agua - Huaca San Borja	 ','  ','  ','  ',2),(51,'Circuito Nro. 2: Huaca San Borja - Museo de la Nación - Biblioteca Nacional del Perú	 ','  ','  ','  ',2),(52,'Circuito Nro. 3: Gran Teatro Nacional - Museo de la Nación - Huaca San Borja	 ','  ','  ','  ',2),(53,'Circuito Nro. 4: Museo de la Nación - Gran Teatro Nacional - Biblioteca Nacional del Perú	 ','  ','  ','  ',2),(54,'Circuito Nro. 5: Huaca San Borja - Museo de la Nación - Gran Teatro Nacional - Biblioteca Nacional del Perú	 ','  ','  ','  ',2),(55,'Clases de Inglés ',' ',' ',' ',4),(56,'Programa de Ciegos con Visión, Computación Adaptada ',' ',' ',' ',4),(57,'Clases de Computación ',' ',' ',' ',4),(58,'Programa Lee, San Borja Lee ',' ',' ',' ',4),(59,'Cine Club para Invidentes ',' ',' ',' ',4),(60,'	\"Bridge en el Tambo\"	 ','  ','  ','  ',5),(61,'	Cine en el Tambo \"Semana Santa\"	 ','  ','  ','  ',5),(62,'	Cine en el Tambo \"Invictus\"	 ','  ','  ','  ',5),(63,'	Teatro para Niños \"La gallina sembradora\"	 ','  ','  ','  ',5),(64,'	Cine en el Tambo \"Los tuyos, los míos, los nuestros\"	 ','  ','  ','  ',5),(65,'	Cine en el Tambo \"Conversaciones con mamá\"	 ','  ','  ','  ',5),(66,'	\"Actualización Pedagógicas sobre el Sistema de Gestión de la Calidad rumbo a la Acreditación\" dirigida a Instituciones Educativas del Distrito	 ','  ','  ','  ',3);
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
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `planificacion`
--

LOCK TABLES `planificacion` WRITE;
/*!40000 ALTER TABLE `planificacion` DISABLE KEYS */;
INSERT INTO `planificacion` VALUES (1,'2017-09-19',NULL,NULL,NULL,1,4,NULL,1,NULL),(2,'2017-09-19',NULL,NULL,NULL,2,6,NULL,1,NULL),(3,'2017-09-19',NULL,NULL,NULL,1,66,NULL,1,NULL),(4,'2017-09-19',NULL,NULL,NULL,1,66,NULL,1,NULL),(5,'2017-09-19',NULL,NULL,NULL,2,51,NULL,1,NULL);
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
INSERT INTO `tipoactividad` VALUES (1,'Taller','Posicionarnos en la comunidad como la mejor opción de talleres artísticos y culturales, obteniendo un crecimiento sostenido con el tiempo'),(2,'Visita Turística','El objetivo de los circuitos es promocionar los atractivos turísticos con los que cuenta el distrito de San Borja, lograr que el distrito no solo sea conocido por sus parques verdes sino también porque tiene turismo para ofrecer y apoyar.'),(3,'Charla','Fomentar la cultura a los vecinos de San Borja'),(4,'Programa Extensión Bibliotecaria','Fomentar la educación, arte y cultura a los vecinos de San Borja'),(5,'Evento cultural','Fomentar la educación, arte y cultura a los vecinos de San Borja');
/*!40000 ALTER TABLE `tipoactividad` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-09-19 13:18:10
