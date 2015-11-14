-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema bancoweb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema bancoweb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `bancoweb` DEFAULT CHARACTER SET utf8 ;
USE `bancoweb` ;

-- -----------------------------------------------------
-- Table `bancoweb`.`curriculo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bancoweb`.`curriculo` (
  `id_curriculo` INT(11) NOT NULL AUTO_INCREMENT COMMENT '',
  `resumo` TEXT NULL DEFAULT NULL COMMENT '',
  `exprofissional` TEXT NULL DEFAULT NULL COMMENT '',
  `forbasica` VARCHAR(45) NULL DEFAULT NULL COMMENT '',
  `formedia` VARCHAR(45) NULL DEFAULT NULL COMMENT '',
  `id_pessoa` INT(11) NULL DEFAULT NULL COMMENT '',
  PRIMARY KEY (`id_curriculo`)  COMMENT '')
ENGINE = InnoDB
AUTO_INCREMENT = 11
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `bancoweb`.`estado`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bancoweb`.`estado` (
  `id_estado` INT(11) NOT NULL AUTO_INCREMENT COMMENT '',
  `descricao` VARCHAR(60) NULL DEFAULT NULL COMMENT '',
  `UF` VARCHAR(60) NULL DEFAULT NULL COMMENT '',
  PRIMARY KEY (`id_estado`)  COMMENT '')
ENGINE = InnoDB
AUTO_INCREMENT = 28
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `bancoweb`.`endereco`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bancoweb`.`endereco` (
  `id_endereco` INT(11) NOT NULL AUTO_INCREMENT COMMENT '',
  `rua` VARCHAR(60) NULL DEFAULT NULL COMMENT '',
  `numero` INT(11) NULL DEFAULT NULL COMMENT '',
  `complemento` VARCHAR(45) NULL DEFAULT NULL COMMENT '',
  `cidade` VARCHAR(45) NULL DEFAULT NULL COMMENT '',
  `cep` VARCHAR(10) NULL DEFAULT NULL COMMENT '',
  `id_estado` INT(11) NULL DEFAULT NULL COMMENT '',
  `id_pessoa` INT(11) NULL DEFAULT NULL COMMENT '',
  PRIMARY KEY (`id_endereco`)  COMMENT '',
  INDEX `idestado_idx` (`id_estado` ASC)  COMMENT '',
  CONSTRAINT `idestado`
    FOREIGN KEY (`id_estado`)
    REFERENCES `bancoweb`.`estado` (`id_estado`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 10
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `bancoweb`.`tipoforma`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bancoweb`.`tipoforma` (
  `id_tipoforma` INT(11) NOT NULL AUTO_INCREMENT COMMENT '',
  `descricao` VARCHAR(45) NULL DEFAULT NULL COMMENT '',
  PRIMARY KEY (`id_tipoforma`)  COMMENT '')
ENGINE = InnoDB
AUTO_INCREMENT = 8
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `bancoweb`.`formacao`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bancoweb`.`formacao` (
  `id_formacao` INT(11) NOT NULL AUTO_INCREMENT COMMENT '',
  `nomeinstitui` VARCHAR(45) NULL DEFAULT NULL COMMENT '',
  `datainicio` DATE NULL DEFAULT NULL COMMENT '',
  `datatermino` DATE NULL DEFAULT NULL COMMENT '',
  `id_tipoforma` INT(11) NULL DEFAULT NULL COMMENT '',
  `id_cur` INT(11) NULL DEFAULT NULL COMMENT '',
  PRIMARY KEY (`id_formacao`)  COMMENT '',
  INDEX `idtipo_idx` (`id_tipoforma` ASC)  COMMENT '',
  CONSTRAINT `idtipo`
    FOREIGN KEY (`id_tipoforma`)
    REFERENCES `bancoweb`.`tipoforma` (`id_tipoforma`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 10
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `bancoweb`.`login`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bancoweb`.`login` (
  `id_login` INT(11) NOT NULL AUTO_INCREMENT COMMENT '',
  `nome` VARCHAR(30) NULL DEFAULT NULL COMMENT '',
  `senha` VARCHAR(30) NULL DEFAULT NULL COMMENT '',
  PRIMARY KEY (`id_login`)  COMMENT '')
ENGINE = InnoDB
AUTO_INCREMENT = 11
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `bancoweb`.`paises`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bancoweb`.`paises` (
  `iso` CHAR(2) NOT NULL COMMENT '',
  `iso3` CHAR(3) NOT NULL COMMENT '',
  `numcode` SMALLINT(6) NULL DEFAULT NULL COMMENT '',
  `nome` VARCHAR(255) NOT NULL COMMENT '',
  PRIMARY KEY (`iso`)  COMMENT '')
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `bancoweb`.`trabalhopublicados`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bancoweb`.`trabalhopublicados` (
  `id_trabalhopublicados` INT(11) NOT NULL AUTO_INCREMENT COMMENT '',
  `nome` VARCHAR(45) NULL DEFAULT NULL COMMENT '',
  `ano` DATE NULL DEFAULT NULL COMMENT '',
  `pais` VARCHAR(45) NULL DEFAULT NULL COMMENT '',
  `id_curriculo` INT(11) NULL DEFAULT NULL COMMENT '',
  `tipotraba` VARCHAR(45) NULL DEFAULT NULL COMMENT '',
  PRIMARY KEY (`id_trabalhopublicados`)  COMMENT '',
  INDEX `idcurriculo_idx` (`id_curriculo` ASC)  COMMENT '',
  CONSTRAINT `idcuri`
    FOREIGN KEY (`id_curriculo`)
    REFERENCES `bancoweb`.`curriculo` (`id_curriculo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 6
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `bancoweb`.`usuario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bancoweb`.`usuario` (
  `id_usuario` INT(11) NOT NULL AUTO_INCREMENT COMMENT '',
  `nome` VARCHAR(20) NULL DEFAULT NULL COMMENT '',
  `sobrenome` VARCHAR(30) NULL DEFAULT NULL COMMENT '',
  `idade` INT(11) NULL DEFAULT NULL COMMENT '',
  `sexo` VARCHAR(10) NULL DEFAULT NULL COMMENT '',
  `CPF` VARCHAR(17) NULL DEFAULT NULL COMMENT '',
  `id_login` INT(11) NULL DEFAULT NULL COMMENT '',
  PRIMARY KEY (`id_usuario`)  COMMENT '')
ENGINE = InnoDB
AUTO_INCREMENT = 11
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
