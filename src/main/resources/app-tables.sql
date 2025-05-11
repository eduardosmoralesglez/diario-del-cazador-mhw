-- Eliminar tablas 
DROP TABLE IF EXISTS cazador_tarjeta;
DROP TABLE IF EXISTS cazador;
DROP TABLE IF EXISTS tarjeta_visita;
DROP TABLE IF EXISTS monstruo;

-- Crear tabla cazador
CREATE TABLE cazador (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    usuario TEXT NOT NULL,
    nombre TEXT NOT NULL,
    contrasenia TEXT NOT NULL,
    email TEXT UNIQUE NOT NULL 
);

-- Crear tabla tarjeta_visita
CREATE TABLE tarjeta_visita (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    titulo TEXT NOT NULL, 
    rango INTEGER NOT NULL,    
    arma TEXT NOT NULL,      
    gremio TEXT NOT NULL  
);

-- Crear tabla intermedia
CREATE TABLE cazador_tarjeta (
    usuario_id INTEGER,
    tarjeta_id INTEGER,  
    PRIMARY KEY (usuario_id, tarjeta_id),
    FOREIGN KEY (usuario_id) REFERENCES cazador(id) ON DELETE CASCADE,
    FOREIGN KEY (tarjeta_id) REFERENCES tarjeta_visita(id) ON DELETE CASCADE
);

-- Crear tabla monstruo
CREATE TABLE monstruo (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    nombre TEXT UNIQUE NOT NULL, 
    tipo TEXT NOT NULL,
    clase TEXT NOT NULL,
    descripcion TEXT NOT NULL,  
    imagen TEXT NOT NULL 
);

-- Insertar datos 
INSERT INTO monstruo (nombre, tipo, clase, descripcion, imagen) VALUES
    ('Rathalos', 'Wyvern Volador', 'Grande', 'El monstruo alfa de el Bosque Antiguo. Un wyvern feroz que desciende sobre los invasores, atacando con garras venenosas y aliento ardiente', 'src/main/resources/Rathalos.png'),
    ('Kelbi', 'Herbivoro', 'Pequeño', 'Pequeña ciervo carente de impacto significativo en el ecosistema, presa menor de los wyverns', 'src/main/resources/Kelbi.png'),
    ('Nergigante', 'Wyvern Depredador', 'Anciano', 'Un terrible dragón anciano que aparece cuando otros ancianos están cerca. Su inclinación por la destrucción está bien documentada.', 'src/main/resources/Nergigante.png');

INSERT INTO tarjeta_visita (titulo, rango, arma, gremio) VALUES
    ('Cazador Experimentado', 7, 'Catana', 'Comisión de Investigación'),
    ('Cazador Novato', 3, 'Espada y Escudo', 'Legión de Putrefacción'),
    ('Cazador Legendario', 18, 'Hacha Cargada', 'Investigadores de lo Desconocido');

INSERT INTO cazador (usuario, nombre, contrasenia, email) VALUES
    ('vegeta777', 'Samuel de Luque', 'pass123', 'juan@example.com'),
    ('Anita856', 'Ana López', 'securePass', 'ana@example.com'),
    ('SuperCar951', 'Carlos Gómez', 'claveSegura', 'carlos@example.com');

INSERT INTO cazador_tarjeta (usuario_id, tarjeta_id) VALUES
    (1, 1),
    (2, 2),
    (3, 3);
