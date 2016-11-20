-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 20-11-2016 a las 22:29:28
-- Versión del servidor: 10.1.9-MariaDB
-- Versión de PHP: 5.6.15

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `almacenbd`
--

DELIMITER $$
--
-- Procedimientos
--
CREATE DEFINER=`root`@`localhost` PROCEDURE `spAddArticulo` (`_id` INT, `_codigo` VARCHAR(20), `_valor` NUMERIC)  update producto set cantidad = cantidad +_valor where id = _id and codigo =_codigo$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `spAlmacenBuscarNombre` (`_valor` NVARCHAR(50))  SELECT * FROM almacen WHERE descripcion LIKE concat('%',_valor,'%') and estado =1 order by id desc$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `spAlmacenEditar` (`_id` INT, `_codigo` NVARCHAR(20), `_descripcion` NVARCHAR(50))  UPDATE almacen SET codigo=_codigo,descripcion=_descripcion WHERE id=_id$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `spAlmacenEliminar` (`_id` INT)  UPDATE almacen SET estado=0 WHERE id=_id$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `spAlmacenId` (`_id` INT)  select * from almacen where id = _id$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `spAlmacenInsertar` (`_codigo` NVARCHAR(20), `_descripcion` NVARCHAR(50), `_estado` TINYINT(1))  INSERT INTO almacen(codigo,descripcion,estado) VALUES (_codigo,_descripcion,_estado)$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `spAlmacenListado` ()  select *  from almacen where estado =1$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `spAlmacenNombre` (`_id` INT)  select * from almacen where id = _id$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `spAreaBuscarNombre` (`_valor` NVARCHAR(100))  SELECT * FROM area WHERE descripcion LIKE concat('%',_valor,'%') and estado =1 order by id desc$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `spAreaEditar` (`_id` INT, `_codigo` NVARCHAR(20), `_descripcion` NVARCHAR(100))  UPDATE area SET codigo=_codigo,descripcion=_descripcion WHERE id=_id$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `spAreaEliminar` (`_id` INT)  UPDATE area SET estado=0 WHERE id=_id$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `spAreaId` (IN `_id` INT, OUT `_descripcion` NVARCHAR(100), OUT `_estado` TINYINT(1))  select id,descripcion,estado from area where id = _id$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `spAreaInsertar` (`_codigo` NVARCHAR(20), `_descripcion` NVARCHAR(50), `_estado` TINYINT(1))  INSERT INTO area(codigo,descripcion,estado) VALUES (_codigo,_descripcion,_estado)$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `spAreaListado` ()  select *  from area where estado =1 order by id desc$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `spAreaNombre` (`_id` INT)  select * from area where id = _id$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `spAutorizanteBuscarNombre` (`_valor` VARCHAR(200))  select * from autorizante where  nombre LIKE concat('%',_valor,'%') and estado=1$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `spAutorizanteEditar` (`_id` INT, `_nombre` VARCHAR(225), `_especialidad` VARCHAR(50), `_cargo` VARCHAR(200))  UPDATE autorizante SET  nombre=_nombre,especialidad=_especialidad,cargo=_cargo
WHERE id=_id$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `spAutorizanteEliminar` (`_id` INT)  UPDATE autorizante SET  estado=0 
WHERE id=_id$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `spAutorizanteInsertar` (`_nombre` VARCHAR(225), `_especialidad` VARCHAR(50), `_cargo` VARCHAR(200))  insert into autorizante(nombre,especialidad,cargo)
values(_nombre,_especialidad,_cargo)$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `spAutorizanteListado` ()  select * from autorizante where estado =1$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `spBuscarArticuloLocationCodigo` (`_valor` NVARCHAR(100), `_location` VARCHAR(100))  select * from producto as p  
where p.codigo LIKE concat('%',_valor,'%') and p.almacen_id = _location and p.estado=1$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `spBuscarArticuloLocationNombre` (`_valor` NVARCHAR(100), `_location` VARCHAR(100))  select * from producto as p  
where p.articulo LIKE concat('%',_valor,'%') and p.almacen_id = _location and p.estado=1$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `spCategoriaBuscarNombre` (`_valor` NVARCHAR(50))  SELECT * FROM categoria WHERE descripcion LIKE concat('%',_valor,'%') and estado =1 order by id desc$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `spCategoriaEditar` (`_id` INT, `_codigo` NVARCHAR(20), `_descripcion` NVARCHAR(50))  UPDATE categoria SET codigo=_codigo, descripcion=_descripcion WHERE id=_id$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `spCategoriaEliminar` (`_id` INT)  UPDATE categoria SET estado=0 WHERE id=_id$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `spCategoriaId` (`_id` INT)  select * from categoria where id = _id$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `spCategoriaInsertar` (`_codigo` NVARCHAR(20), `_descripcion` NVARCHAR(50), `_estado` TINYINT(1))  INSERT INTO categoria(codigo,descripcion,estado) VALUES (_codigo,_descripcion,_estado)$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `spCategoriaListado` ()  select *  from categoria where estado =1$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `spCategoriaNombre` (`_id` INT)  select * from categoria where id = _id$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `spConsultaProductoMovimiento` (`_value` VARCHAR(200))  select  
p.codigo, 
p.articulo,
m.operacion,
m.cantidad,
m.fechaRegistro,
m.solicitante
 from movimiento m inner join
 producto p  on m.producto_id= p.id
 where p.codigo = _value
 order by m.fechaRegistro desc$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `spConsutaArea` (`_value` VARCHAR(100))  select distinct m.numSalida as numMemo ,m.solicitante 
from movimiento as m inner join 
area as are on m.area_id = are.id 
where m.operacion = 'salida' and  are.descripcion = _value$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `spIngresoArticulo` (`_operacion` VARCHAR(100), `_fechaRegistro` DATETIME, `_numIngreso` VARCHAR(100), `_cantidad` NUMERIC, `_personal_id` INT, `_producto_id` INT)  insert into movimiento (operacion,fechaRegistro,numIngreso,cantidad,personal_id,producto_id)
value(_operacion,_fechaRegistro,_numIngreso,_cantidad,_personal_id,_producto_id)$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `spLoginUser` (IN `_user` NVARCHAR(50), IN `_pass` NVARCHAR(50))  SELECT *  FROM personal as p 
 wHERE  p.usuario = _user AND p.password=_pass and p.estado='1'$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `spMarcaBuscarNombre` (`_valor` NVARCHAR(50))  SELECT * FROM marca WHERE descripcion LIKE concat('%',_valor,'%') and estado =1 order by id desc$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `spMarcaEditar` (`_id` INT, `_codigo` NVARCHAR(50), `_descripcion` NVARCHAR(50))  UPDATE marca SET codigo=_codigo, descripcion=_descripcion WHERE id=_id$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `spMarcaEliminar` (`_id` INT)  UPDATE marca SET estado=0 WHERE id=_id$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `spMarcaId` (`_id` INT)  select * from marca where id = _id$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `spMarcaInsertar` (`_codigo` NVARCHAR(20), `_descripcion` NVARCHAR(50), `_estado` TINYINT(1))  INSERT INTO marca(codigo,descripcion,estado) VALUES (_codigo,_descripcion,_estado)$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `spMarcaListado` ()  select *  from marca where estado =1$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `spMarcaNombre` (`_id` INT)  select * from marca where id = _id$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `spPersonalBuscarNombre` (`_valor` NVARCHAR(50))  select distinct  * from personal as p 
where (p.nombre LIKE concat('%',_valor,'%') or p.apellidoPaterno LIKE concat('%',_valor,'%') or p.apellidoMaterno LIKE concat('%',_valor,'%')) and p.estado =1 order by p.id desc$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `spPersonalEditar` (`_id` INT, `_nombre` NVARCHAR(50), `_apellidoPaterno` NVARCHAR(50), `_apellidoMaterno` NVARCHAR(50), `_tipoDocumento` NVARCHAR(50), `_numDocumento` NVARCHAR(50), `_usuario` NVARCHAR(50), `_estado` NVARCHAR(50), `_tipo_personal_id` INT)  UPDATE personal SET nombre = _nombre,apellidoPaterno = _apellidoPaterno,apellidoMaterno =_apellidoMaterno,tipoDocumento=_tipoDocumento
,numDocumento=_numDocumento,usuario=_usuario,estado=estado,tipo_personal_id=_tipo_personal_id 
WHERE id=_id$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `spPersonalEditarPass` (`_id` INT, `_nombre` NVARCHAR(50), `_apellidoPaterno` NVARCHAR(50), `_apellidoMaterno` NVARCHAR(50), `_tipoDocumento` NVARCHAR(50), `_numDocumento` NVARCHAR(50), `_usuario` NVARCHAR(50), `_password` NVARCHAR(50), `_estado` NVARCHAR(50), `_tipo_personal_id` INT)  UPDATE personal SET nombre = _nombre,apellidoPaterno = _apellidoPaterno,apellidoMaterno =_apellidoMaterno,tipoDocumento=_tipoDocumento
,numDocumento=_numDocumento,usuario=_usuario,password=_password,estado=estado,tipo_personal_id=_tipo_personal_id 
WHERE id=_id$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `spPersonalEliminar` (`_id` INT)  UPDATE personal SET estado=0 WHERE id=_id$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `spPersonalId` (IN `_id` INT)  select  p.id,concat(p.nombre,' ',p.apellidoPaterno,' ',p.apellidoMaterno) as personal ,p.tipoDocumento as dni ,p.usuario ,tp.descripcion as cargo
from personal as p
inner join tipo_personal as tp
where p.id =_id order by p.id desc$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `spPersonalInsertar` (`_nombre` NVARCHAR(50), `_apellidoPaterno` NVARCHAR(50), `_apellidoMaterno` NVARCHAR(50), `_tipoDocumento` NVARCHAR(50), `_numDocumento` NVARCHAR(50), `_usuario` NVARCHAR(50), `_password` NVARCHAR(50), `_estado` NVARCHAR(50), `_tipo_personal_id` INT)  INSERT INTO personal(nombre,apellidoPaterno,apellidoMaterno,tipoDocumento,numDocumento,usuario,password,estado,tipo_personal_id) 
VALUES (_nombre,_apellidoPaterno,_apellidoMaterno,_tipoDocumento,_numDocumento,_usuario,_password,_estado,_tipo_personal_id)$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `spPersonalListado` ()  select * from Personal as p 
where p.estado =1 order by p.id desc$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `spPersonalNombre` (`_nombre` NVARCHAR(50))  select  p.id,concat(p.nombre,' ',p.apellidoPaterno,' ',p.apellidoMaterno) as personal ,p.tipoDocumento as dni ,p.usuario ,tp.descripcion as cargo
from personal as p
inner join tipo_personal as tp
where (p.nombre =_nombre or p.apellidoPaterno=_nombre or p.apellidoMaterno=_nombre) and p.estado =1 order by p.id desc$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `spProductoBuscarNombre` (`_valor` NVARCHAR(50))  SELECT * FROM producto WHERE (articulo LIKE concat('%',_valor,'%')) and estado =1 order by id desc$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `spProductoEditar` (`_id` INT, `_codigo` VARCHAR(20), `_producto` VARCHAR(255), `_fechaRegistro` DATETIME, `_categoria_id` INT, `_tipo_producto_id` INT, `_marca_id` INT, `_almacen_id` INT, `_unidad_id` INT)  UPDATE producto SET codigo=_codigo,articulo=_producto,fechaRegistro=_fechaRegistro,
					 categoria_id=_categoria_id,tipo_producto_id=_tipo_producto_id,
                    marca_id=_marca_id,almacen_id=_almacen_id,unidad_id=_unidad_id  
WHERE id=_id$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `spProductoEliminar` (`_id` INT)  UPDATE producto SET estado=0 WHERE id=_id$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `spProductoId` (`_id` INT)  select * from producto where id = _id$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `spProductoInsertar` (`_codigo` VARCHAR(20), `_articulo` VARCHAR(255), `_fechaRegistro` DATETIME, `_categoria_id` INT, `_tipo_producto_id` INT, `_marca_id` INT, `_almacen_id` INT, `_unidad_id` INT)  INSERT INTO producto(codigo,articulo,fechaRegistro,categoria_id,tipo_producto_id,marca_id,almacen_id,unidad_id)
 VALUES (_codigo,_articulo,_fechaRegistro,_categoria_id,_tipo_producto_id,_marca_id,_almacen_id,_unidad_id)$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `spProductoListado` ()  select *  from producto where estado =1 order by id desc$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `spProductosCantidad` ()  select 
p.codigo,
p.articulo,
p.cantidad,
a.descripcion as almacen 
 from producto p
inner join 
almacen a on p.almacen_id = a.id
 where p.estado = '1'
order by p.cantidad asc$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `spRemoveArticulo` (`_id` INT, `_codigo` VARCHAR(20), `_valor` NUMERIC)  update producto set cantidad = cantidad -_valor where id = _id and codigo =_codigo$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `spReporteIngresoArticulo` (`_numIngreso` VARCHAR(100), `_operacion` VARCHAR(100))  select fechaRegistro,referencia,cantidad,unidad,medida,color,observacion,personal_id,producto_id 
from movimiento
where 
numIngreso = _numIngreso and operacion = _operacion$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `spSalidaProducto` (`_operacion` VARCHAR(100), `_fechaRegistro` DATETIME, `_numSalida` VARCHAR(100), `_numExpediente` VARCHAR(100), `_numDocumento` VARCHAR(100), `_asunto` VARCHAR(225), `_solicitante` VARCHAR(100), `_referencia` VARCHAR(225), `_cantidad` DECIMAL, `_modelo` VARCHAR(50), `_color` VARCHAR(50), `_numSerie` VARCHAR(50), `_codigoUnt` VARCHAR(50), `_codigoSaneamiento` VARCHAR(50), `_cabecera` LONGTEXT, `_observacion` VARCHAR(225), `_autorizante_id` INT, `_personal_id` INT, `_producto_id` INT, `_area_id` INT)  insert into movimiento(operacion,fechaRegistro,numSalida,numExpediente,numDocumento,asunto,solicitante,area_id,referencia,cantidad,modelo,color,numSerie,codigoUnt,codigoSaneamiento,cabecera,observacion,autorizante_id,personal_id,producto_id)
values(_operacion,_fechaRegistro,_numSalida,_numExpediente,_numDocumento,_asunto,_solicitante,_area_id,referencia,_cantidad,_modelo,_color,_numSerie,_codigoUnt,_codigoSaneamiento,_cabecera,_observacion,_autorizante_id,_personal_id,_producto_id)$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `spSolicitanteBuscarNombre` (`_valor` NVARCHAR(50))  SELECT * FROM solicitante WHERE (nombre LIKE concat('%',_valor,'%') or apellidoPaterno LIKE concat('%',_valor,'%') or apellidoMaterno LIKE concat('%',_valor,'%')) and estado =1 order by id desc$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `spSolicitanteEditar` (`_id` INT, `_nombre` NVARCHAR(50), `_paterno` NVARCHAR(50), `_materno` NVARCHAR(50), `_estado` TINYINT(1))  UPDATE solicitante SET nombre=_nombre,apellidoPaterno=_paterno,apellidoMaterno=_materno,estado=_estado  WHERE id=_id$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `spSolicitanteEliminar` (`_id` INT)  UPDATE solicitante SET estado=0 WHERE id=_id$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `spSolicitanteId` (`_id` INT)  select * from solicitante where id = _id$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `spSolicitanteInsertar` (`_nombre` NVARCHAR(50), `_paterno` NVARCHAR(50), `_materno` NVARCHAR(50), `_estado` TINYINT(1))  INSERT INTO solicitante(nombre,apellidoPaterno,apellidoMaterno,estado) VALUES (_nombre,_paterno,_materno,_estado)$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `spSolicitanteListado` ()  select *  from solicitante where estado =1 order by id desc$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `spTipo_PersonalEditar` (`_id` INT, `_descripcion` NVARCHAR(50))  UPDATE tipo_personal SET descripcion=_descripcion WHERE id=_id$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `spTipo_PersonalEliminar` (`_id` INT)  UPDATE tipo_personal SET estado=0 WHERE id=_id$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `spTipo_PersonalId` (`_id` INT)  select * from tipo_personal where id = _id$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `spTipo_PersonalInsertar` (`_descripcion` NVARCHAR(50), `_estado` TINYINT(1))  INSERT INTO tipo_personal(descripcion,estado) VALUES (_descripcion,_estado)$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `spTipo_PersonalListado` ()  select *  from tipo_personal where estado =1 order by id desc$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `spTipo_PersonalNombre` (`_id` INT)  select * from tipo_personal where id = _id$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `spTipo_ProductoEditar` (`_id` INT, `_codigo` NVARCHAR(20), `_descripcion` NVARCHAR(50))  UPDATE tipo_producto SET codigo=_codigo, descripcion=_descripcion WHERE id=_id$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `spTipo_ProductoEliminar` (`_id` INT)  UPDATE tipo_producto SET estado=0 WHERE id=_id$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `spTipo_ProductoId` (`_id` INT)  select * from tipo_producto where id = _id$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `spTipo_ProductoInsertar` (`_codigo` NVARCHAR(20), `_descripcion` NVARCHAR(50), `_estado` TINYINT(1))  INSERT INTO tipo_producto(codigo,descripcion,estado) VALUES (_codigo,_descripcion,_estado)$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `spTipo_ProductoListado` ()  select *  from tipo_producto where estado =1$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `spUnidadBuscarNombre` (`_valor` NVARCHAR(50))  SELECT * FROM unidad WHERE descripcion LIKE concat('%',_valor,'%') and estado =1 order by id desc$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `spUnidadEditar` (`_id` INT, `_codigo` NVARCHAR(20), `_descripcion` NVARCHAR(50))  UPDATE unidad SET codigo=_codigo, descripcion=_descripcion WHERE id=_id$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `spUnidadEliminar` (`_id` INT)  UPDATE unidad SET estado=0 WHERE id=_id$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `spUnidadId` (`_id` INT)  select * from unidad where id = _id$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `spUnidadInsertar` (`_codigo` NVARCHAR(20), `_descripcion` NVARCHAR(50), `_estado` TINYINT(1))  INSERT INTO unidad(codigo,descripcion,estado) VALUES (_codigo,_descripcion,_estado)$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `spUnidadListado` ()  select *  from unidad where estado =1$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `spUnidadNombre` (`_id` INT)  select * from unidad where id = _id$$

DELIMITER ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `almacen`
--

CREATE TABLE `almacen` (
  `id` int(11) NOT NULL,
  `codigo` varchar(20) NOT NULL,
  `descripcion` varchar(50) NOT NULL,
  `estado` tinyint(1) NOT NULL DEFAULT '1'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `almacen`
--

INSERT INTO `almacen` (`id`, `codigo`, `descripcion`, `estado`) VALUES
(1, 'ALM01', 'principal', 1),
(2, 'ALM02', 'sotano', 1),
(3, 'ALM03', 'otro almacen dsf', 0);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `area`
--

CREATE TABLE `area` (
  `id` int(11) NOT NULL,
  `codigo` varchar(20) NOT NULL,
  `descripcion` varchar(100) NOT NULL,
  `estado` tinyint(1) NOT NULL DEFAULT '1'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `area`
--

INSERT INTO `area` (`id`, `codigo`, `descripcion`, `estado`) VALUES
(1, 'AR-01', 'Sin', 1),
(2, 'VENT', 'ventas', 1),
(3, 'NUEVO', 'nuevo', 1),
(4, 'DEN', 'demo', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `autorizante`
--

CREATE TABLE `autorizante` (
  `id` int(11) NOT NULL,
  `nombre` varchar(225) NOT NULL,
  `especialidad` varchar(50) NOT NULL,
  `cargo` varchar(200) NOT NULL,
  `estado` tinyint(1) NOT NULL DEFAULT '1'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `autorizante`
--

INSERT INTO `autorizante` (`id`, `nombre`, `especialidad`, `cargo`, `estado`) VALUES
(1, 'jorge Enrique Flores Franco', 'Dr.', 'Decano de la Facultad de Ingenieria Quimica', 1),
(2, 'alfa', 'alfa', 'alfa', 1),
(3, 'dfgdf', 'sdf', 'sdf', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `categoria`
--

CREATE TABLE `categoria` (
  `id` int(11) NOT NULL,
  `codigo` varchar(20) NOT NULL,
  `descripcion` varchar(50) NOT NULL,
  `estado` tinyint(1) NOT NULL DEFAULT '1'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `categoria`
--

INSERT INTO `categoria` (`id`, `codigo`, `descripcion`, `estado`) VALUES
(1, 'CAT01', 'sin', 1),
(2, 'CAT02', 'oficina', 1),
(3, 'CAT03', 'laboratorio', 1),
(4, 'CAT04', 'otros', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `marca`
--

CREATE TABLE `marca` (
  `id` int(11) NOT NULL,
  `codigo` varchar(20) NOT NULL,
  `descripcion` varchar(50) NOT NULL,
  `estado` tinyint(1) NOT NULL DEFAULT '1'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `marca`
--

INSERT INTO `marca` (`id`, `codigo`, `descripcion`, `estado`) VALUES
(1, 'MAR01', 'sin', 1),
(2, 'MAR02', 'cybertel', 1),
(3, 'MAR03', 'nueva marca', 1),
(4, 'MArc04', 'samsung', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `movimiento`
--

CREATE TABLE `movimiento` (
  `id` int(11) NOT NULL,
  `codigo` varchar(20) DEFAULT NULL,
  `operacion` varchar(100) NOT NULL DEFAULT 'ingreso',
  `fechaRegistro` datetime DEFAULT NULL,
  `numIngreso` varchar(100) DEFAULT NULL,
  `numSalida` varchar(100) DEFAULT NULL,
  `numExpediente` varchar(100) DEFAULT NULL,
  `numDocumento` varchar(100) DEFAULT NULL,
  `asunto` varchar(255) DEFAULT 'sin',
  `solicitante` varchar(100) DEFAULT 'sin',
  `referencia` varchar(255) DEFAULT 'nulo',
  `cantidad` decimal(10,0) DEFAULT '0',
  `modelo` varchar(50) DEFAULT 'sin categoria',
  `unidad` varchar(50) DEFAULT 'sin unidad',
  `medida` varchar(45) DEFAULT 'sin medida',
  `color` varchar(50) DEFAULT 'sin color',
  `numSerie` varchar(50) DEFAULT NULL,
  `codigoUnt` varchar(50) DEFAULT NULL,
  `codigoSaneamiento` varchar(50) DEFAULT NULL,
  `cabecera` longtext,
  `observacion` varchar(255) DEFAULT NULL,
  `estado` tinyint(1) NOT NULL DEFAULT '1',
  `personal_id` int(11) NOT NULL,
  `producto_id` int(11) NOT NULL,
  `autorizante_id` int(11) NOT NULL,
  `area_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `movimiento`
--

INSERT INTO `movimiento` (`id`, `codigo`, `operacion`, `fechaRegistro`, `numIngreso`, `numSalida`, `numExpediente`, `numDocumento`, `asunto`, `solicitante`, `referencia`, `cantidad`, `modelo`, `unidad`, `medida`, `color`, `numSerie`, `codigoUnt`, `codigoSaneamiento`, `cabecera`, `observacion`, `estado`, `personal_id`, `producto_id`, `autorizante_id`, `area_id`) VALUES
(1, NULL, 'ingreso', '2016-10-12 21:13:31', '000234', NULL, NULL, NULL, 'nulo', 'sin', 'en una entrada libre de impuesto', '6', 'sin categoria', 'caja', 'kilos', 'negro', NULL, NULL, NULL, NULL, NULL, 1, 1, 6, 1, 0),
(2, NULL, 'ingreso', '2016-10-12 21:13:52', '000234', NULL, NULL, NULL, 'nulo', 'sin', 'en una entrada libre de impuesto', '6', 'sin categoria', 'galones', 'litros', 'balnco', NULL, NULL, NULL, NULL, NULL, 1, 1, 9, 1, 0),
(3, NULL, 'ingreso', '2016-10-12 21:14:19', '000234', NULL, NULL, NULL, 'nulo', 'sin', 'en una entrada libre de impuesto', '4', 'sin categoria', 'unidad', 'metros', 'negro', NULL, NULL, NULL, NULL, NULL, 1, 1, 6, 1, 0),
(4, NULL, 'ingreso', '2016-10-12 21:14:58', '000234', NULL, NULL, NULL, 'nulo', 'sin', 'en una entrada libre de impuesto', '20', 'sin categoria', 'otros', 'otros', 'rojp', NULL, NULL, NULL, NULL, NULL, 1, 1, 6, 1, 0),
(5, NULL, 'salida', '2016-10-12 21:16:42', NULL, '000067', '7834', '2334', 'entrega de productow', 'franz gupioc', 'es una salida de productos 79798', '4', 'negro', 'negro', 'medalla', 'oro', '242', '234', '234', '', NULL, 1, 1, 8, 1, 1),
(6, NULL, 'ingreso', '2016-10-12 21:17:34', '000021', NULL, NULL, NULL, 'nulo', 'sin', 'otra entrada', '21', 'sin categoria', 'unidad', 'medida', 'azul', NULL, NULL, NULL, '', NULL, 1, 1, 8, 1, 0),
(7, NULL, 'ingreso', '2016-10-18 21:02:29', '000879', NULL, NULL, NULL, 'nulo', 'sin', 'informer 56 nitads', '6', 'sin categoria', 'kilos', 'lotes', 'rojo', NULL, NULL, NULL, NULL, NULL, 1, 1, 6, 1, 0),
(8, NULL, 'ingreso', '2016-10-18 21:03:02', '000879', NULL, NULL, NULL, 'nulo', 'sin', 'informer 56 nitads', '10', 'sin categoria', 'galones', 'lotros', 'negro', NULL, NULL, NULL, NULL, NULL, 1, 1, 6, 1, 0),
(9, NULL, 'ingreso', '2016-10-18 21:26:58', '', NULL, NULL, NULL, 'nulo', 'sin', '', '3', 'sin categoria', '', '', '', NULL, NULL, NULL, '', NULL, 1, 1, 5, 1, 0),
(10, NULL, 'salida', '2016-10-18 22:08:07', NULL, '003443', '456', '234', 'rtert', 'bfcvc', 'nulo', '100', 'dgd', 'dfgdfg', 'sfsdf', 'w', 'wer', 'wer', 'wer', '', NULL, 1, 1, 5, 1, 1),
(11, NULL, 'ingreso', '2016-10-26 15:26:07', '000234', NULL, NULL, NULL, 'nulo', 'sin', 'nulo', '2', 'sin categoria', 'sin unidad', 'sin medida', 'sin color', NULL, NULL, NULL, '', NULL, 1, 1, 6, 1, 0),
(12, NULL, 'ingreso', '2016-10-26 15:26:19', '000234', NULL, NULL, NULL, 'nulo', 'sin', 'nulo', '9', 'sin categoria', 'sin unidad', 'sin medida', 'sin color', NULL, NULL, NULL, '', NULL, 1, 1, 4, 1, 0),
(13, NULL, 'ingreso', '2016-10-26 20:30:12', '', NULL, NULL, NULL, 'nulo', 'sin', 'nulo', '5', 'sin categoria', 'sin unidad', 'sin medida', 'sin color', NULL, NULL, NULL, '', NULL, 1, 1, 12, 1, 0),
(14, NULL, 'salida', '2016-10-26 21:59:04', NULL, '000067', '5657', '876', 'demosd', 'franz gupioc', 'nulo', '2', 'ninguno', 'sin unidad', 'sin medida', 'negro', '111', '2222', '333', '', NULL, 1, 1, 6, 1, 1),
(16, NULL, 'salida', '2016-11-16 20:12:59', NULL, '003247', '345456456804564', '456456456456456', 'prestamo', 'milagos', 'nulo', '10', 'sfsd', 'sin unidad', 'sin medida', 'sdfsdf', '56789', '5678', '678', '', NULL, 1, 1, 6, 2, 3),
(17, NULL, 'salida', '2016-11-16 20:13:26', NULL, '003247', '345456456804564', '456456456456456', 'prestamo', 'milagos', 'nulo', '2', 'w''¡0e', 'sin unidad', 'sin medida', '9''0', '9''0', '8980', '79879', '', NULL, 1, 1, 8, 2, 3),
(18, NULL, 'ingreso', '2016-11-17 14:03:06', '', NULL, NULL, NULL, 'nulo', 'sin', 'nulo', '10', 'sin categoria', 'sin unidad', 'sin medida', 'sin color', NULL, NULL, NULL, '', NULL, 1, 1, 7, 0, 0),
(19, NULL, 'ingreso', '2016-11-17 14:04:12', '', NULL, NULL, NULL, 'nulo', 'sin', 'nulo', '1000', 'sin categoria', 'sin unidad', 'sin medida', 'sin color', NULL, NULL, NULL, '', NULL, 1, 1, 9, 0, 0),
(20, NULL, 'salida', '2016-11-17 14:05:55', NULL, '007678', '567567686786786', '678678678678678', 'salid', 'demo demo demodemo', 'nulo', '250', 'nuevo', 'sin unidad', 'sin medida', 'negro', '888888', '99999999', '000998', '', NULL, 1, 1, 9, 1, 3),
(21, NULL, 'salida', '2016-11-17 15:23:49', NULL, '009876', '784375837457384', '253465725432733', 'test', 'test tes', 'nulo', '3', '6786757', 'sin unidad', 'sin medida', '789789', '789789', '789789', '789789', 'gfhgfhgf fghgjhkjilio,po', 'gdfggfhfg', 1, 1, 9, 1, 3),
(22, NULL, 'salida', '2016-11-17 15:27:42', NULL, '007684', '090890980907909', '345803985834085', 'tyu', 'dfgh', 'nulo', '12', '34567', 'sin unidad', 'sin medida', '5678', '5678', '678t', '678', 'pppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppp', 'uyuyuiuu yuiyiuy yiu', 1, 1, 9, 1, 3),
(23, NULL, 'salida', '2016-11-17 15:27:58', NULL, '007684', '090890980907909', '345803985834085', 'tyu', 'dfgh', 'nulo', '5', 'rtret', 'sin unidad', 'sin medida', 'rty', 'kjhk', 'xcvxcv', 'rtetr', 'pppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppp', '', 1, 1, 6, 1, 3);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `personal`
--

CREATE TABLE `personal` (
  `id` int(11) NOT NULL,
  `codigo` varchar(20) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `apellidoPaterno` varchar(50) NOT NULL,
  `apellidoMaterno` varchar(50) NOT NULL,
  `tipoDocumento` varchar(45) NOT NULL,
  `numDocumento` varchar(45) NOT NULL,
  `usuario` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `estado` tinyint(1) NOT NULL DEFAULT '1',
  `tipo_personal_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `personal`
--

INSERT INTO `personal` (`id`, `codigo`, `nombre`, `apellidoPaterno`, `apellidoMaterno`, `tipoDocumento`, `numDocumento`, `usuario`, `password`, `estado`, `tipo_personal_id`) VALUES
(1, 'PER01', 'franz', 'gupioc', 'ventura', 'dni', '46588976', 'fgupioc', '81dc9bdb52d04dc20036dbd8313ed055', 1, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `producto`
--

CREATE TABLE `producto` (
  `id` int(11) NOT NULL,
  `codigo` varchar(20) NOT NULL,
  `articulo` varchar(225) NOT NULL,
  `descripcion` varchar(225) DEFAULT NULL,
  `fechaRegistro` datetime NOT NULL,
  `cantidad` decimal(10,0) NOT NULL DEFAULT '0',
  `estado` tinyint(1) NOT NULL DEFAULT '1',
  `categoria_id` int(11) NOT NULL DEFAULT '1',
  `tipo_producto_id` int(11) NOT NULL DEFAULT '1',
  `marca_id` int(11) NOT NULL DEFAULT '1',
  `almacen_id` int(11) NOT NULL DEFAULT '1',
  `unidad_id` int(11) NOT NULL DEFAULT '1'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `producto`
--

INSERT INTO `producto` (`id`, `codigo`, `articulo`, `descripcion`, `fechaRegistro`, `cantidad`, `estado`, `categoria_id`, `tipo_producto_id`, `marca_id`, `almacen_id`, `unidad_id`) VALUES
(2, 'B-0123', 'televisor 14"', 'un televisor para ver television', '2016-10-01 04:21:58', '24', 1, 2, 2, 2, 2, 1),
(3, 'PROD02', 'cable utp', 'para las computadoras', '2016-10-22 04:18:04', '21', 1, 2, 4, 2, 1, 1),
(4, 'PROD04', 'boligrafo plastico tinta seca', NULL, '2016-10-15 04:17:52', '2', 1, 2, 2, 2, 2, 3),
(5, 'COD12', 'nuevo', 'descricp', '2019-04-02 14:39:37', '1', 1, 4, 2, 2, 1, 2),
(6, 'PROD03', 'demas', 'xcvsd', '2019-05-08 02:40:53', '90', 1, 3, 3, 2, 1, 4),
(7, 'PEROD21', 'otros', 'xcvxcv', '2019-09-16 02:44:09', '10', 1, 3, 3, 2, 2, 2),
(8, 'COD03', 'blomas', 'sdfsdf', '2016-10-02 15:45:57', '19', 1, 3, 3, 3, 1, 7),
(9, 'PRODUCTO', 'nuevo2', 'descripciond e producro', '2016-11-23 15:47:20', '728', 1, 3, 3, 2, 1, 1),
(10, 'COD23', 'laptop', 'descripcion', '2016-10-29 15:50:39', '1', 1, 3, 3, 2, 2, 7),
(11, 'COD01', 'mause', NULL, '2012-03-28 02:44:09', '4', 1, 1, 1, 1, 1, 1),
(12, '132', 'dfkldlskf', NULL, '2012-12-12 00:00:00', '2', 1, 1, 1, 1, 1, 3),
(13, '9809', 'kdjkf sdkdskfhk', NULL, '2016-10-09 05:29:01', '0', 1, 3, 3, 2, 2, 4);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `solicitante`
--

CREATE TABLE `solicitante` (
  `id` int(11) NOT NULL,
  `codigo` varchar(20) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `apellidoPaterno` varchar(50) NOT NULL,
  `apellidoMaterno` varchar(50) NOT NULL,
  `estado` tinyint(1) NOT NULL DEFAULT '1'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `solicitante`
--

INSERT INTO `solicitante` (`id`, `codigo`, `nombre`, `apellidoPaterno`, `apellidoMaterno`, `estado`) VALUES
(1, 'SOL-01', 'sin solicitante', 'solicitante', 'solicitante', 1),
(2, 'SOL02', 'horacio', 'gupioc', 'chuquizuta', 1),
(3, 'SOL03', 'maria ', 'ventura', 'alvis', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipo_personal`
--

CREATE TABLE `tipo_personal` (
  `id` int(11) NOT NULL,
  `codigo` varchar(20) NOT NULL,
  `descripcion` varchar(50) NOT NULL,
  `estado` tinyint(1) NOT NULL DEFAULT '1'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `tipo_personal`
--

INSERT INTO `tipo_personal` (`id`, `codigo`, `descripcion`, `estado`) VALUES
(1, 'AMDIN', 'administrador', 1),
(2, 'ENCAR', 'encargado', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipo_producto`
--

CREATE TABLE `tipo_producto` (
  `id` int(11) NOT NULL,
  `codigo` varchar(20) NOT NULL,
  `descripcion` varchar(50) NOT NULL,
  `estado` tinyint(1) NOT NULL DEFAULT '1'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `tipo_producto`
--

INSERT INTO `tipo_producto` (`id`, `codigo`, `descripcion`, `estado`) VALUES
(1, 'TPRO01', 'sin', 1),
(2, 'TPRO02', 'tuberia', 1),
(3, 'TPRO03', 'reactivo controlado', 1),
(4, 'TPRO04', 'reactivo no controlado', 1),
(5, 'TPRO05', 'electrico', 1),
(6, 'RPRO05', 'otros', 0);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `unidad`
--

CREATE TABLE `unidad` (
  `id` int(11) NOT NULL,
  `codigo` varchar(20) NOT NULL,
  `descripcion` varchar(50) NOT NULL,
  `estado` tinyint(1) NOT NULL DEFAULT '1'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `unidad`
--

INSERT INTO `unidad` (`id`, `codigo`, `descripcion`, `estado`) VALUES
(1, 'UNI01', 'sin', 1),
(2, 'UNI02', 'pliego', 1),
(3, 'UNI03', 'metro', 1),
(4, 'UNI04', 'caja', 1),
(5, 'UNI05', 'galon', 1),
(6, 'UNI06', 'demos', 1),
(7, 'UNI07', 'unidad', 1);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `almacen`
--
ALTER TABLE `almacen`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `codigo_UNIQUE` (`codigo`);

--
-- Indices de la tabla `area`
--
ALTER TABLE `area`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `codigo_UNIQUE` (`codigo`);

--
-- Indices de la tabla `autorizante`
--
ALTER TABLE `autorizante`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `categoria`
--
ALTER TABLE `categoria`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `codigo_UNIQUE` (`codigo`);

--
-- Indices de la tabla `marca`
--
ALTER TABLE `marca`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `codigo_UNIQUE` (`codigo`);

--
-- Indices de la tabla `movimiento`
--
ALTER TABLE `movimiento`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `codigo_UNIQUE` (`codigo`),
  ADD KEY `fk_pecosa_personal1_idx` (`personal_id`),
  ADD KEY `fk_movimiento_producto1_idx` (`producto_id`),
  ADD KEY `fk_movimiento_area_idx` (`area_id`);

--
-- Indices de la tabla `personal`
--
ALTER TABLE `personal`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `numDocumento_UNIQUE` (`numDocumento`),
  ADD UNIQUE KEY `usuario_UNIQUE` (`usuario`),
  ADD UNIQUE KEY `codigo_UNIQUE` (`codigo`),
  ADD KEY `fk_personal_tipo_personal1_idx` (`tipo_personal_id`);

--
-- Indices de la tabla `producto`
--
ALTER TABLE `producto`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `codigo_UNIQUE` (`codigo`),
  ADD UNIQUE KEY `producto_UNIQUE` (`articulo`),
  ADD KEY `fk_producto_categoria1_idx` (`categoria_id`),
  ADD KEY `fk_producto_tipo_producto1_idx` (`tipo_producto_id`),
  ADD KEY `fk_producto_marca1_idx` (`marca_id`),
  ADD KEY `fk_producto_almacen1_idx` (`almacen_id`),
  ADD KEY `fk_producto_unidad2_idx` (`unidad_id`);

--
-- Indices de la tabla `solicitante`
--
ALTER TABLE `solicitante`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `codigo_UNIQUE` (`codigo`);

--
-- Indices de la tabla `tipo_personal`
--
ALTER TABLE `tipo_personal`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `codigo_UNIQUE` (`codigo`);

--
-- Indices de la tabla `tipo_producto`
--
ALTER TABLE `tipo_producto`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `codigo_UNIQUE` (`codigo`);

--
-- Indices de la tabla `unidad`
--
ALTER TABLE `unidad`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `codigo_UNIQUE` (`codigo`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `almacen`
--
ALTER TABLE `almacen`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT de la tabla `area`
--
ALTER TABLE `area`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT de la tabla `autorizante`
--
ALTER TABLE `autorizante`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT de la tabla `categoria`
--
ALTER TABLE `categoria`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT de la tabla `marca`
--
ALTER TABLE `marca`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT de la tabla `movimiento`
--
ALTER TABLE `movimiento`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=24;
--
-- AUTO_INCREMENT de la tabla `personal`
--
ALTER TABLE `personal`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT de la tabla `producto`
--
ALTER TABLE `producto`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;
--
-- AUTO_INCREMENT de la tabla `solicitante`
--
ALTER TABLE `solicitante`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT de la tabla `tipo_personal`
--
ALTER TABLE `tipo_personal`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT de la tabla `tipo_producto`
--
ALTER TABLE `tipo_producto`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
--
-- AUTO_INCREMENT de la tabla `unidad`
--
ALTER TABLE `unidad`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;
--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `movimiento`
--
ALTER TABLE `movimiento`
  ADD CONSTRAINT `fk_movimiento_producto1` FOREIGN KEY (`producto_id`) REFERENCES `producto` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_pecosa_personal1` FOREIGN KEY (`personal_id`) REFERENCES `personal` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `personal`
--
ALTER TABLE `personal`
  ADD CONSTRAINT `fk_personal_tipo_personal1` FOREIGN KEY (`tipo_personal_id`) REFERENCES `tipo_personal` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `producto`
--
ALTER TABLE `producto`
  ADD CONSTRAINT `fk_producto_almacen1` FOREIGN KEY (`almacen_id`) REFERENCES `almacen` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
