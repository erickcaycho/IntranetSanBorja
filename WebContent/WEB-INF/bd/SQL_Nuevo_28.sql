-- MySQL Script generated by MySQL Workbench
-- Thu Sep 28 12:08:03 2017
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema educacionculturaturismosb
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `educacionculturaturismosb` ;

-- -----------------------------------------------------
-- Schema educacionculturaturismosb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `educacionculturaturismosb` DEFAULT CHARACTER SET utf8 ;
USE `educacionculturaturismosb` ;

-- -----------------------------------------------------
-- Table `educacionculturaturismosb`.`tipoactividad`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `educacionculturaturismosb`.`tipoactividad` ;

CREATE TABLE IF NOT EXISTS `educacionculturaturismosb`.`tipoactividad` (
  `idtipoactividad` INT NOT NULL AUTO_INCREMENT,
  `nomtipoactividad` VARCHAR(250) NULL,
  `descripcion` VARCHAR(300) NULL,
  PRIMARY KEY (`idtipoactividad`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `educacionculturaturismosb`.`actividad`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `educacionculturaturismosb`.`actividad` ;

CREATE TABLE IF NOT EXISTS `educacionculturaturismosb`.`actividad` (
  `idactividad` INT NOT NULL AUTO_INCREMENT,
  `nomactividad` VARCHAR(200) NULL,
  `descripcion` VARCHAR(300) NULL,
  `imagen` VARCHAR(70) NULL,
  `objetivo` VARCHAR(250) NULL,
  `idtipoactividad` INT NOT NULL,
  PRIMARY KEY (`idactividad`),
  INDEX `fk_actividad_tipoactividad_idx` (`idtipoactividad` ASC),
  CONSTRAINT `fk_actividad_tipoactividad`
    FOREIGN KEY (`idtipoactividad`)
    REFERENCES `educacionculturaturismosb`.`tipoactividad` (`idtipoactividad`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `educacionculturaturismosb`.`periodo`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `educacionculturaturismosb`.`periodo` ;

CREATE TABLE IF NOT EXISTS `educacionculturaturismosb`.`periodo` (
  `idperiodo` INT NOT NULL AUTO_INCREMENT,
  `nomperiodo` VARCHAR(60) NULL,
  PRIMARY KEY (`idperiodo`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `educacionculturaturismosb`.`planificacion`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `educacionculturaturismosb`.`planificacion` ;

CREATE TABLE IF NOT EXISTS `educacionculturaturismosb`.`planificacion` (
  `idplanificacion` INT NOT NULL AUTO_INCREMENT,
  `fechacreacion` DATE NULL,
  `fechaplanificacion` DATE NULL,
  `fecharechazo` DATE NULL,
  `fechaaprobacion` DATE NULL,
  `idperiodo` INT NOT NULL,
  `idactividad` INT NOT NULL,
  `fechaanulacion` DATE NULL,
  `estado` INT NULL,
  `fechaejecucion` DATE NULL,
  PRIMARY KEY (`idplanificacion`),
  INDEX `fk_planificacion_periodo1_idx` (`idperiodo` ASC),
  INDEX `fk_planificacion_actividad1_idx` (`idactividad` ASC),
  CONSTRAINT `fk_planificacion_periodo1`
    FOREIGN KEY (`idperiodo`)
    REFERENCES `educacionculturaturismosb`.`periodo` (`idperiodo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_planificacion_actividad1`
    FOREIGN KEY (`idactividad`)
    REFERENCES `educacionculturaturismosb`.`actividad` (`idactividad`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `educacionculturaturismosb`.`sede`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `educacionculturaturismosb`.`sede` ;

CREATE TABLE IF NOT EXISTS `educacionculturaturismosb`.`sede` (
  `idsede` INT NOT NULL AUTO_INCREMENT,
  `nombresede` VARCHAR(100) NULL,
  `direccion` VARCHAR(200) NULL,
  PRIMARY KEY (`idsede`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `educacionculturaturismosb`.`ambiente`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `educacionculturaturismosb`.`ambiente` ;

CREATE TABLE IF NOT EXISTS `educacionculturaturismosb`.`ambiente` (
  `idambiente` INT NOT NULL AUTO_INCREMENT,
  `idsede` INT NOT NULL,
  `capacidad` INT NULL,
  `nombreambiente` VARCHAR(300) NULL,
  PRIMARY KEY (`idambiente`),
  INDEX `fk_ambiente_sede1_idx` (`idsede` ASC),
  CONSTRAINT `fk_ambiente_sede1`
    FOREIGN KEY (`idsede`)
    REFERENCES `educacionculturaturismosb`.`sede` (`idsede`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `educacionculturaturismosb`.`horario`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `educacionculturaturismosb`.`horario` ;

CREATE TABLE IF NOT EXISTS `educacionculturaturismosb`.`horario` (
  `idhorario` INT NOT NULL AUTO_INCREMENT,
  `idambiente` INT NOT NULL,
  `fechainicio` DATE NULL,
  `fechafin` DATE NULL,
  `edadmin` INT NULL,
  `edadmax` INT NULL,
  `cantsesion` INT NULL,
  `horassesion` INT NULL,
  `vacantemin` INT NULL,
  `vacantemax` INT NULL,
  `precio` DOUBLE NULL,
  `idplanificacion` INT NOT NULL,
  PRIMARY KEY (`idhorario`),
  INDEX `fk_horario_ambiente1_idx` (`idambiente` ASC),
  INDEX `fk_horario_planificacion1_idx` (`idplanificacion` ASC),
  CONSTRAINT `fk_horario_ambiente1`
    FOREIGN KEY (`idambiente`)
    REFERENCES `educacionculturaturismosb`.`ambiente` (`idambiente`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_horario_planificacion1`
    FOREIGN KEY (`idplanificacion`)
    REFERENCES `educacionculturaturismosb`.`planificacion` (`idplanificacion`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `educacionculturaturismosb`.`planpublicitario`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `educacionculturaturismosb`.`planpublicitario` ;

CREATE TABLE IF NOT EXISTS `educacionculturaturismosb`.`planpublicitario` (
  `idplanpublicitario` INT NOT NULL AUTO_INCREMENT,
  `archivoruta` VARCHAR(60) NULL,
  `descripcion` VARCHAR(60) NULL,
  `idplanificacion` INT NOT NULL,
  PRIMARY KEY (`idplanpublicitario`),
  INDEX `fk_planpublicitario_planificacion1_idx` (`idplanificacion` ASC),
  CONSTRAINT `fk_planpublicitario_planificacion1`
    FOREIGN KEY (`idplanificacion`)
    REFERENCES `educacionculturaturismosb`.`planificacion` (`idplanificacion`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `educacionculturaturismosb`.`material`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `educacionculturaturismosb`.`material` ;

CREATE TABLE IF NOT EXISTS `educacionculturaturismosb`.`material` (
  `idmaterial` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NULL,
  `cantidad_disponible` INT NULL,
  PRIMARY KEY (`idmaterial`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `educacionculturaturismosb`.`empleado`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `educacionculturaturismosb`.`empleado` ;

CREATE TABLE IF NOT EXISTS `educacionculturaturismosb`.`empleado` (
  `idempleado` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(100) NULL,
  `apellipaterno` VARCHAR(100) NULL,
  `apellimaterno` VARCHAR(100) NULL,
  `dni` INT NULL,
  `telefono` INT NULL,
  `celular` INT NULL,
  `direccion` VARCHAR(100) NULL,
  `correo` VARCHAR(100) NULL,
  PRIMARY KEY (`idempleado`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `educacionculturaturismosb`.`cronograma`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `educacionculturaturismosb`.`cronograma` ;

CREATE TABLE IF NOT EXISTS `educacionculturaturismosb`.`cronograma` (
  `idcronograma` INT NOT NULL AUTO_INCREMENT,
  `idhorario` INT NOT NULL,
  `tarea` VARCHAR(45) NULL,
  `descripcion` VARCHAR(300) NULL,
  `fechainicio` DATE NULL,
  `fechafin` DATE NULL,
  `fechaejecucion` DATE NULL,
  `idempleado` INT NOT NULL,
  PRIMARY KEY (`idcronograma`),
  INDEX `fk_cronograma_horario1_idx` (`idhorario` ASC),
  INDEX `fk_cronograma_empleado1_idx` (`idempleado` ASC),
  CONSTRAINT `fk_cronograma_horario1`
    FOREIGN KEY (`idhorario`)
    REFERENCES `educacionculturaturismosb`.`horario` (`idhorario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_cronograma_empleado1`
    FOREIGN KEY (`idempleado`)
    REFERENCES `educacionculturaturismosb`.`empleado` (`idempleado`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `educacionculturaturismosb`.`detalle_horario_material`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `educacionculturaturismosb`.`detalle_horario_material` ;

CREATE TABLE IF NOT EXISTS `educacionculturaturismosb`.`detalle_horario_material` (
  `idhorario` INT NOT NULL,
  `idmaterial` INT NOT NULL,
  `cantidad_usar` INT NULL,
  PRIMARY KEY (`idhorario`, `idmaterial`),
  INDEX `fk_horario_has_material_material1_idx` (`idmaterial` ASC),
  INDEX `fk_horario_has_material_horario1_idx` (`idhorario` ASC),
  CONSTRAINT `fk_horario_has_material_horario1`
    FOREIGN KEY (`idhorario`)
    REFERENCES `educacionculturaturismosb`.`horario` (`idhorario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_horario_has_material_material1`
    FOREIGN KEY (`idmaterial`)
    REFERENCES `educacionculturaturismosb`.`material` (`idmaterial`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `educacionculturaturismosb`.`rol`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `educacionculturaturismosb`.`rol` ;

CREATE TABLE IF NOT EXISTS `educacionculturaturismosb`.`rol` (
  `idrol` INT NOT NULL AUTO_INCREMENT,
  `nombrerol` VARCHAR(100) NULL,
  PRIMARY KEY (`idrol`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `educacionculturaturismosb`.`detalle_empleado_rol`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `educacionculturaturismosb`.`detalle_empleado_rol` ;

CREATE TABLE IF NOT EXISTS `educacionculturaturismosb`.`detalle_empleado_rol` (
  `idempleado` INT NOT NULL,
  `rol_idrol` INT NOT NULL,
  PRIMARY KEY (`idempleado`, `rol_idrol`),
  INDEX `fk_empleado_has_rol_rol1_idx` (`rol_idrol` ASC),
  INDEX `fk_empleado_has_rol_empleado1_idx` (`idempleado` ASC),
  CONSTRAINT `fk_empleado_has_rol_empleado1`
    FOREIGN KEY (`idempleado`)
    REFERENCES `educacionculturaturismosb`.`empleado` (`idempleado`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_empleado_has_rol_rol1`
    FOREIGN KEY (`rol_idrol`)
    REFERENCES `educacionculturaturismosb`.`rol` (`idrol`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `educacionculturaturismosb`.`detalle_horario_empleado`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `educacionculturaturismosb`.`detalle_horario_empleado` ;

CREATE TABLE IF NOT EXISTS `educacionculturaturismosb`.`detalle_horario_empleado` (
  `idhorario` INT NOT NULL,
  `idempleado` INT NOT NULL,
  PRIMARY KEY (`idhorario`, `idempleado`),
  INDEX `fk_horario_has_empleado_empleado1_idx` (`idempleado` ASC),
  INDEX `fk_horario_has_empleado_horario1_idx` (`idhorario` ASC),
  CONSTRAINT `fk_horario_has_empleado_horario1`
    FOREIGN KEY (`idhorario`)
    REFERENCES `educacionculturaturismosb`.`horario` (`idhorario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_horario_has_empleado_empleado1`
    FOREIGN KEY (`idempleado`)
    REFERENCES `educacionculturaturismosb`.`empleado` (`idempleado`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `educacionculturaturismosb`.`motivoRechazo`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `educacionculturaturismosb`.`motivoRechazo` ;

CREATE TABLE IF NOT EXISTS `educacionculturaturismosb`.`motivoRechazo` (
  `idmotivo` INT NOT NULL,
  `descMotivo` VARCHAR(45) NULL,
  PRIMARY KEY (`idmotivo`))
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `educacionculturaturismosb`.`detalle_rechazo_plan`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `educacionculturaturismosb`.`detalle_rechazo_plan` ;

CREATE TABLE IF NOT EXISTS `educacionculturaturismosb`.`detalle_rechazo_plan` (
  `idrechazoplan` INT NOT NULL,
  `idmotivo` INT NOT NULL,
  `idplanificacion` INT NOT NULL,
  `fecharechazo` DATE NULL,
  `observacion` VARCHAR(45) NULL, 
  `cantidad_usar` INT NULL,
  PRIMARY KEY (`idrechazoplan`),
  INDEX `fk_planificacion_has_motivo_motivo1_idx` (`idmotivo` ASC),
  INDEX `fk_planificacion_has_motivo_planificacion1_idx` (`idplanificacion` ASC),
  CONSTRAINT `fk_planificacion_has_motivo_planificacion1`
    FOREIGN KEY (`idplanificacion`)
    REFERENCES `educacionculturaturismosb`.`planificacion` (`idplanificacion`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_planificacion_has_motivo_motivo1`
    FOREIGN KEY (`idmotivo`)
    REFERENCES `educacionculturaturismosb`.`motivoRechazo` (`idmotivo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;



SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
