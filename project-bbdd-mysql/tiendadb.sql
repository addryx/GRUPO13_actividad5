create database tiendadb;
use tiendadb;

-- Tabla "roles"
CREATE TABLE roles (
  id_rol INT AUTO_INCREMENT PRIMARY KEY,
  nombre_rol ENUM('ROLE_CLIENTE', 'ROLE_ADMON') NOT NULL
);

-- Tabla "usuarios"
CREATE TABLE usuarios (
  id_usuario INT AUTO_INCREMENT PRIMARY KEY,
  nombre VARCHAR(100) NOT NULL,
  apellidos VARCHAR(100) NOT NULL,
  fecha_nacimiento DATE NOT NULL,
  email VARCHAR(100) NOT NULL UNIQUE,
  contrasena VARCHAR(100) NOT NULL,
  ENABLED INT NOT NULL DEFAULT 1
);

-- Tabla "direcciones"
CREATE TABLE direcciones (
  id_direccion INT AUTO_INCREMENT PRIMARY KEY,
  codigo_postal VARCHAR(10) NOT NULL,
  localidad VARCHAR(100) NOT NULL,
  calle VARCHAR(100) NOT NULL,
  numero INT NOT NULL,
  piso INT DEFAULT NULL,
  letra CHAR(1) DEFAULT NULL
);

-- Tabla "tarjetas"
CREATE TABLE tarjetas (
  id_tarjeta INT AUTO_INCREMENT PRIMARY KEY,
  numero_tarjeta VARCHAR(20) NOT NULL UNIQUE,
  nombre_titular VARCHAR(100) NOT NULL,
  fecha_caducidad DATE NOT NULL,
  cvv INT NOT NULL
);

-- Tabla "productos"
CREATE TABLE productos (
  id_producto INT AUTO_INCREMENT PRIMARY KEY,
  nombre VARCHAR(100) NOT NULL UNIQUE,
  descripcion VARCHAR(255) NOT NULL,
  precio DECIMAL(10,2) NOT NULL,
  stock INT NOT NULL
);

-- Tabla "compras"
CREATE TABLE Compras (
    id_compra INT AUTO_INCREMENT PRIMARY KEY,
    fecha DATETIME,
    estado ENUM('carrito', 'completado') NOT NULL,
    id_usuario INT NOT NULL,
    id_direccion INT,
    id_tarjeta INT,
    CHECK (estado IN ('carrito', 'completado')),
    FOREIGN KEY (id_usuario) REFERENCES Usuarios(id_usuario),
    FOREIGN KEY (id_direccion) REFERENCES Direcciones(id_direccion),
    FOREIGN KEY (id_tarjeta) REFERENCES Tarjetas(id_tarjeta)
);

-- Tabla intermedia "usuarios_direcciones"
CREATE TABLE usuarios_direcciones (
  id_direccion INT,
  id_usuario INT,
  PRIMARY KEY (id_direccion, id_usuario),
  FOREIGN KEY (id_direccion) REFERENCES direcciones (id_direccion),
  FOREIGN KEY (id_usuario) REFERENCES usuarios (id_usuario)
);

-- Tabla intermedia "usuarios_tarjetas"
CREATE TABLE usuarios_tarjetas (
  id_tarjeta INT,
  id_usuario INT,
  PRIMARY KEY (id_tarjeta, id_usuario),
  FOREIGN KEY (id_tarjeta) REFERENCES tarjetas (id_tarjeta),
  FOREIGN KEY (id_usuario) REFERENCES usuarios (id_usuario)
  );

-- Tabla intermedia "usuario_roles"
CREATE TABLE usuario_roles
(id_usuario INT NOT NULL,
id_rol INT NOT NULL,
PRIMARY KEY(id_usuario, id_rol),
FOREIGN KEY(id_usuario) REFERENCES usuarios(id_usuario),
FOREIGN KEY(id_rol) REFERENCES roles(id_rol)
);

-- Tabla intermedia "productos_compra"
CREATE TABLE productos_compra (
    id_compra INT,
    id_producto INT,
    unidades INT,
    precio FLOAT,
    PRIMARY KEY (id_compra, id_producto),
    FOREIGN KEY (id_compra) REFERENCES Compras(id_compra),
    FOREIGN KEY (id_producto) REFERENCES Productos(id_producto)
);

create user 'utienda' identified by 'utienda';
grant all privileges on tiendadb.* to  'utienda';
-- drop user 'utienda'@'%';

-- -----------------------
-- INSERTS --
-- -----------------------

-- Tabla roles
INSERT INTO Roles (nombre_rol) VALUES ('ROLE_CLIENTE'), ('ROLE_ADMON');

-- Tabla usuarios
INSERT INTO usuarios (nombre, apellidos, fecha_nacimiento, email, contrasena)
VALUES ('Juan', 'Pérez', '1995-01-01', 'juan.perez@email.com', 'contrasena1'),
       ('María', 'González', '1996-02-02', 'maria.gonzalez@email.com', 'contrasena2'),
       ('Pedro', 'Rodríguez', '1997-03-03', 'pedro.rodriguez@email.com', 'contrasena3'),
       ('Ana', 'Martínez', '1998-04-04', 'ana.martinez@email.com', 'contrasena4'),
       ('Luis', 'Sánchez', '1999-05-05', 'luis.sanchez@email.com', 'contrasena5');
       
-- Tabla direcciones
INSERT INTO direcciones (codigo_postal, localidad, calle, numero, piso, letra)
VALUES ('08001', 'Barcelona', 'Calle de las Flores', 5, 4, 'A'),
		('08005', 'Barcelona', 'Avenida de los Pájaros', 25, 4, 'B'),
		('08008', 'Barcelona', 'Calle del Mar', 8, 6, 'C'),
		('08003', 'Barcelona', 'Calle de la Luna', 12, 2, 'D'),
		('08006', 'Barcelona', 'Calle del Sol', 3, 5, 'A');

-- Tabla tarjetas bancarias
INSERT INTO tarjetas (numero_tarjeta, nombre_titular, fecha_caducidad, cvv)
VALUES ('1234567812345678', 'Juan Pérez', '2024-01-01', 123),
       ('2345678223456782', 'María González', '2025-02-02', 234),
       ('3456783234567833', 'Pedro Rodríguez', '2026-03-03', 345),
       ('4567864445678644', 'Ana Martínez', '2027-04-04', 456),
		('5678775656787556', 'Luis Sánchez', '2028-05-05', 567);

-- Tabla productos
INSERT INTO productos (nombre, descripcion, precio, stock)
VALUES ('iPhone X', 'Smartphone de Apple con pantalla OLED de 5.8 pulgadas', 799.99, 200), 
		('MacBook Pro', 'Ordenador portátil de Apple con pantalla Retina de 13 pulgadas', 1299.99, 50),
        ('Apple Watch Series 6', 'Reloj inteligente de Apple con GPS y monitor de salud', 399.99, 100),
        ('Sony PlayStation 5', 'Consola de videojuegos de Sony con hardware de última generación', 499.99, 25),
        ('LG OLED CX', 'Televisión inteligente de LG con pantalla OLED de 55 pulgadas', 1499.99, 40);

-- Tabla compras
INSERT INTO Compras (fecha, estado, id_usuario, id_direccion, id_tarjeta)
VALUES ('2022-12-25 12:30:00', 'completado', 1, 1, 1),
		('2022-12-25 13:30:00', 'carrito', 2, 2, 2);

-- Tabla intermedia 'usuarios_direcciones'
INSERT INTO usuarios_direcciones (id_direccion, id_usuario)
VALUES (1, 1), (2, 2), (3, 3), (4, 4), (5, 5), 
		(1, 2), (2, 3), (3, 4), (4, 5), (5, 1);

-- Tabla intermedia "usuarios_tarjetas"
INSERT INTO usuarios_tarjetas (id_usuario, id_tarjeta)
VALUES (1, 1), (2, 2), (3, 3), (4, 4), (5, 5), 
		(1, 2), (2, 3), (3, 4), (4, 5), (5, 1);
        
-- Tabla intermedia "usuario_roles"
INSERT INTO usuario_roles (id_usuario, id_rol)
VALUES (1, 1), (2, 1), (3, 1), (4, 1), (5, 1), 
		(1, 2), (2, 2);
        
-- Tabla intermedia "productos_compra"
INSERT INTO productos_compra (id_compra, id_producto, unidades, precio)
VALUES (1, 1, 2, 20.5),
       (1, 2, 3, 15.3),
       (2, 3, 1, 50.0);
