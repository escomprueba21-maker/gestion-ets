-- =========================================================
-- ets_demo.sql
-- Datos de ejemplo: docentes, aulas y ETS simulados
-- =========================================================

-- =========================================
-- DOCENTES (tomados del catálogo oficial ESCOM)
-- =========================================

INSERT INTO esc05_docente (tx_nombre, tx_apellido_p, tx_apellido_m) VALUES
('Rafael', 'Aguilar', 'García'),
('Fernando', 'Aguilar', 'Sánchez'),
('Daniel', 'Aguilar', 'Velázquez'),
('Verónica', 'Agustín', 'Domínguez'),
('Cecilia', 'Albortante', 'Morato'),
('Alberto Jesús', 'Alcántara', 'Méndez'),
('Juan Jesús', 'Alcaraz', 'Torres'),
('Rocío', 'Almazán', 'Farfán'),
('Maribel', 'Aragón', 'García'),
('David', 'Araujo', 'Díaz'),
('Jacqueline', 'Arzate', 'Gordillo'),
('Cristhian Alejandro', 'Ávila', 'Sánchez'),
('Josue Emanuel', 'Barrón', 'Vera'),
('Sandra Ivette', 'Bautista', 'Rosales'),
('Ivan Eduardo', 'Blanco', 'Almazán'),
('Alejandro', 'Botello', 'Castillo'),
('Israel', 'Buitrón', 'Damaso'),
('Gloria Lourdes', 'Cabrera', 'Chávez'),
('Sergio', 'Cancino', 'Calderón'),
('Odette Berenice', 'Cancino', 'Mosqueda'),
('Leticia', 'Cañedo', 'Suárez'),
('José Juan', 'Carbajal', 'Hernández'),
('Juan Manuel', 'Carballo', 'Jiménez'),
('Oscar', 'Carranza', 'Castillo'),
('Chadwick', 'Carreto', 'Arellano'),
('Gelacio', 'Castillo', 'Cabrera'),
('Juan Antonio', 'Castillo', 'Marrufo'),
('Edgar Armando', 'Catalán', 'Salgado'),
('Ricardo', 'Ceballos', 'Sebastián'),
('Adriana Berenice', 'Celis', 'Domínguez'),
('Maria Soledad', 'Centeno', 'Arrazola'),
('Ismael', 'Cervantes', 'De Anda'),
('Luis Moctezuma', 'Cervantes', 'Espinosa'),
('Lorena', 'Chavarría', 'Báez'),
('Eduardo', 'Chávez', 'Lima'),
('Alejandro Sigfrido', 'Cifuentes', 'Álvarez'),
('Nestor', 'Colin', 'Hernández'),
('Martha Rosa', 'Cordero', 'López'),
('Uriel', 'Corona', 'Bermúdez'),
('Ukranio', 'Coronilla', 'Contreras'),
('Jorge', 'Cortés', 'Galicia'),
('Nidia Asunción', 'Cortez', 'Duarte'),
('Daniel', 'Cruz', 'García'),
('Apolinar Francisco', 'Cruz', 'Lázaro'),
('María Elena', 'Cruz', 'Meza'),
('Jorge Alberto', 'Cruz', 'Rojas'),
('Benjamín', 'Cruz', 'Torres'),
('José Carlos', 'Dávalos', 'López'),
('Saúl', 'De la O', 'Torres'),
('Roberto', 'De Luna', 'Caballero'),
('Claudia Celia', 'Díaz', 'Huerta'),
('Ricardo Felipe', 'Díaz', 'Santiago'),
('Sandra', 'Díaz', 'Santiago'),
('Iván', 'Díaz', 'Toalá'),
('Marco Antonio', 'Dorantes', 'González'),
('Claudia Jisela', 'Dorantes', 'Villa'),
('Edmundo René', 'Durán', 'Camarillo'),
('Ángel Adalberto', 'Durán', 'Ledezma'),
('José Asunción', 'Enríquez', 'Zárate'),
('Patricia', 'Escamilla', 'Miranda'),
('José Armando', 'Esquivel', 'Centeno'),
('Serafín', 'Estrada', 'Elizalde'),
('Alfonso', 'Fernández', 'Vázquez'),
('Jorge', 'Ferrer', 'Tenorio'),
('Felipe de Jesús', 'Figueroa', 'Del Prado'),
('Raquel', 'Flores', 'Delgado'),
('José Antonio', 'Flores', 'Escobar'),
('Ituriel Enrique', 'Flores', 'Estrada'),
('Naria Adriana', 'Flores', 'Fuentes'),
('Yaxkin', 'Flores', 'Mendoza'),
('Yesica Sonia', 'Flores', 'Meraz'),
('Edgardo Adrián', 'Franco', 'Martínez'),
('María del Rosario', 'Galeana', 'Chávez'),
('Rubén', 'Galicia', 'Mejía'),
('Cristal Karina', 'Galindo', 'Durán'),
('María Gabriela', 'Galiñanes', 'Rodríguez'),
('Consuelo Varinia', 'García', 'Mendoza'),
('Victor Hugo', 'García', 'Ortega'),
('Juan Vicente', 'García', 'Sales'),
('Fabián', 'Gaspar', 'Medina'),
('Mariana', 'Gómez', 'Tress'),
('Gisela', 'González', 'Albarrán'),
('Alejandro', 'González', 'Cisneros'),
('Gustavo', 'González', 'García'),
('Marko Alfonso', 'González', 'Ramírez'),
('Miguel Ángel', 'González', 'Trujillo'),
('Eduardo', 'Gutiérrez', 'Aldana'),
('Juan Jesús', 'Gutiérrez', 'García'),
('Darwin', 'Gutiérrez', 'Mejía'),
('Florencio', 'Guzmán', 'Aguilar'),
('Jessie Paulina', 'Guzmán', 'Flores'),
('Leticia', 'Henestrosa', 'Carrasco'),
('José Luis', 'Hernández', 'Aguilar'),
('Macario', 'Hernández', 'Cruz'),
('Rosa Alba', 'Hernández', 'García'),
('Josefína', 'Hernández', 'Jaime'),
('Luis Enrique', 'Hernández', 'Olvera'),
('Erika', 'Hernández', 'Rubio'),
('José Celestino Elías', 'Hernández', 'Secundino'),
('César', 'Hernández', 'Vásquez'),
('Crispin', 'Herrera', 'Yañez'),
('José Alfredo', 'Jiménez', 'Benítez'),
('Edith Adriana', 'Jiménez', 'Contreras'),
('Yasmín Ivette', 'Jiménez', 'Galán'),
('René Baltazar', 'Jiménez', 'Ruíz'),
('Martha Patricia', 'Jiménez', 'Villanueva'),
('Joel Omar', 'Juárez', 'Gambino'),
('Carlos', 'Juárez', 'León'),
('Genaro', 'Juárez', 'Martínez'),
('Ana Belem', 'Juarez', 'Mendez'),
('Jazmín Adriana', 'Juárez', 'Ramírez'),
('Roberto', 'Jurado', 'Jiménez'),
('Laura', 'Lazcano', 'Xoxotla'),
('Christian René', 'Leal', 'Pacheco'),
('Miguel Abel', 'León', 'Hernández'),
('Sergio', 'Levario', 'Medina'),
('Erick Eugenio', 'Linares', 'Vallejo'),
('Ariel', 'López', 'Rojas'),
('Benjamín', 'López', 'Carrera'),
('Luis Octavio', 'López', 'Leyva'),
('Claudia Alejandra', 'López', 'Rodríguez'),
('Gabriela de Jesús', 'López', 'Ruíz'),
('José Manuel', 'López', 'Sánchez'),
('Araceli', 'Loyola', 'Espinosa'),
('Benjamín', 'Luna', 'Benoso'),
('Francisco Javier', 'Macías', 'Pérez'),
('Idalia', 'Maldonado', 'Castillo'),
('Miguel Ángel', 'Maldonado', 'Muñoz'),
('Héctor Manuel', 'Manzanilla', 'Granados'),
('Guillermo', 'Márquez', 'Arreguín'),
('Lilian', 'Martínez', 'Acosta'),
('Juan Carlos', 'Martínez', 'Díaz'),
('César Román', 'Martínez', 'García'),
('José Alfredo', 'Martínez', 'Guerrero'),
('Jesús Alfredo', 'Martínez', 'Nuño'),
('José Cruz', 'Martínez', 'Perales'),
('Ricardo', 'Martínez', 'Rosales'),
('Patricia', 'Mata', 'Gil'),
('Virginia', 'Medina', 'Mejía'),
('Reyna Elia', 'Melara', 'Abarca'),
('Laura', 'Méndez', 'Segundo'),
('Elba', 'Mendoza', 'Macías'),
('Zelin', 'Miguel', 'Pilar'),
('Adbel Anahí', 'Montes', 'Meza'),
('Ángel Salvador', 'Montiel', 'Sánchez'),
('Juan Carlos', 'Morales', 'Cruz'),
('Ángel', 'Morales', 'González'),
('Sandra Luz', 'Morales', 'Güitrón'),
('Úrsula Samantha', 'Morales', 'Rodríguez'),
('Marco Antonio', 'Moreno', 'Armendáriz'),
('Axel Ernesto', 'Moreno', 'Cervantes'),
('Elizabeth', 'Moreno', 'Galván'),
('Yosafat', 'Moscoso', 'Malagón'),
('Iván Giovanny', 'Mosso', 'García'),
('César', 'Mújica', 'Ascencio'),
('Laura', 'Muñoz', 'Salazar'),
('Joel', 'Nava', 'Lara'),
('Fabiola', 'Ocampo', 'Botello'),
('Nancy', 'Ocotitla', 'Rojas'),
('Didier', 'Ojeda', 'Guillén'),
('Rubén', 'Ortega', 'González'),
('Andrés', 'Ortigoza', 'Campos'),
('José Antonio', 'Ortíz', 'Ramírez'),
('Jesús', 'Ortuño', 'Araujo'),
('Yanira', 'Pachuca', 'Herrera'),
('Rocío', 'Palacios', 'Solano'),
('Rosaura', 'Palma', 'Orozco'),
('Myriam Noemí', 'Paredes', 'Cadena'),
('Carlos Jesús', 'Pastrana', 'Fernández'),
('Rubén', 'Peredo', 'Valderrama'),
('Tanibet', 'Pérez de los Santos', 'Mondragón'),
('José Juan', 'Pérez', 'Pérez'),
('Sandra Mercedes', 'Pérez', 'Vera'),
('Miriam', 'Pescador', 'Rojas'),
('Carlos', 'Pineda', 'Guerrero'),
('Jaime Hugo', 'Puebla', 'Lomas'),
('Elia Tzindejhé', 'Ramírez', 'Martínez'),
('Tonáhtiu Arturo', 'Ramírez', 'Romero'),
('Rafael', 'Ramírez', 'Tenorio'),
('Josué', 'Rangel', 'González'),
('Rocío', 'Reséndiz', 'Muñoz'),
('Tlatoani de Jesús', 'Reyes', 'Bermejo'),
('Ignacio', 'Ríos de la Torre', NULL),
('Mónica', 'Rivera', 'De la Rosa'),
('María del Rosario', 'Rocha', 'Bernabé'),
('Miguel Ángel', 'Rodríguez', 'Castillo'),
('Eduardo', 'Rodríguez', 'Flores'),
('Gabriel de Jesús', 'Rodríguez', 'Jordán'),
('Marisol', 'Rodríguez', 'Ordaz'),
('Tania', 'Rodríguez', 'Sarabia'),
('José Gregorio', 'Rodríguez', 'Villarreal'),
('Ismael', 'Rojas', 'Mexicano'),
('Rodolfo', 'Romero', 'Herrera'),
('Jorge Luís', 'Rosas', 'Trigueros'),
('José Marco Antonio', 'Rueda', 'Meléndez'),
('Elena Fabiola', 'Ruíz', 'Ledesma'),
('Israel', 'Salas', 'Ramirez'),
('Manuel', 'Salazar', 'Ramírez'),
('Encarnación', 'Salinas', 'Hernández'),
('Sergio', 'Salinas', 'Lugo'),
('Gilberto', 'Sánchez', 'Quintanilla'),
('Alfonso', 'Sánchez', 'Aguilar'),
('José Emilio', 'Sánchez', 'Arroyo'),
('Miguel', 'Sánchez', 'Brito'),
('Virginia', 'Sánchez', 'Cruz'),
('Luz María', 'Sánchez', 'García'),
('Octavio', 'Sánchez', 'García'),
('José', 'Sánchez', 'Juárez'),
('Israel', 'Sánchez', 'Mendoza'),
('Adriana de la Paz', 'Sánchez', 'Moreno'),
('María Susana', 'Sánchez', 'Palacios'),
('Perla Rebeca', 'Sánchez', 'Vargas'),
('Raúl', 'Santillán', 'Luna'),
('Rafael Norman', 'Saucedo', 'Delgado'),
('José Felix', 'Serrano', 'Talamantes'),
('Victor Manuel', 'Silva', 'García'),
('Jorge Javier', 'Silva', 'Martínez'),
('Misael', 'Solorza', 'Guzmán'),
('Fanny', 'Sosa', 'Adán'),
('Manuel Alejandro', 'Soto', 'Ramos'),
('Miguel Santiago', 'Suárez', 'Castañón'),
('Roberto', 'Tecla', 'Parra'),
('Juan Carlos', 'Téllez', 'Barrera'),
('Ma. Socorro', 'Téllez', 'Reyes'),
('Marco Antonio', 'Tenorio', 'Marrón'),
('Alexis', 'Testa', 'Nava'),
('Judith Margarita', 'Tirado', 'Lule'),
('Enrique', 'Torres', 'González'),
('Roberto', 'Vázquez', 'Arreguín'),
('Leonor', 'Vázquez', 'González'),
('Mijaíl', 'Vázquez', 'Ortiz'),
('Nayeli', 'Vega', 'García'),
('Ulises', 'Vélez', 'Saldaña'),
('Gumersindo', 'Vera', 'Hernández'),
('Sonia', 'Villegas', 'Navarrete'),
('Karina', 'Viveros', 'Vela'),
('Ana María', 'Winfield', 'Reyes'),
('Roberto Eswart', 'Zagal', 'Flores'),
('Alejandro', 'Zárate', 'Cárdenas');

-- =========================================
-- AULAS
-- =========================================

INSERT INTO esc06_aula (tx_clave, tx_edificio) VALUES
('3101', 'Edificio 3'),
('3102', 'Edificio 3'),
('3201', 'Edificio 3'),
('3202', 'Edificio 3'),
('3301', 'Edificio 3'),
('3302', 'Edificio 3'),
('4101', 'Edificio 4'),
('4102', 'Edificio 4'),
('4201', 'Edificio 4'),
('4202', 'Edificio 4'),
('LAB-1', 'Laboratorios'),
('LAB-2', 'Laboratorios'),
('LAB-3', 'Laboratorios'),
('LAB-4', 'Laboratorios');

-- =========================================
-- ETS SIMULADOS
-- (docente asignado coincide con materias que sí imparte según PDF oficial)
-- =========================================

-- Cálculo - Eduardo Chávez Lima
INSERT INTO esc07_ets (fk_id_materia, fk_id_docente, fk_id_aula, fh_aplicacion)
SELECT
    (SELECT id_materia FROM cat02_materia WHERE tx_nombre='Cálculo'),
    (SELECT id_docente FROM esc05_docente WHERE tx_apellido_p='Chávez' AND tx_apellido_m='Lima'),
    (SELECT id_aula FROM esc06_aula WHERE tx_clave='3101'),
    '2026-06-02 08:00:00';

-- Álgebra Lineal - Leticia Cañedo Suárez
INSERT INTO esc07_ets (fk_id_materia, fk_id_docente, fk_id_aula, fh_aplicacion)
SELECT
    (SELECT id_materia FROM cat02_materia WHERE tx_nombre='Álgebra Lineal'),
    (SELECT id_docente FROM esc05_docente WHERE tx_apellido_p='Cañedo' AND tx_apellido_m='Suárez'),
    (SELECT id_aula FROM esc06_aula WHERE tx_clave='3102'),
    '2026-06-03 10:00:00';

-- Matemáticas Discretas - Israel Buitrón Damaso
INSERT INTO esc07_ets (fk_id_materia, fk_id_docente, fk_id_aula, fh_aplicacion)
SELECT
    (SELECT id_materia FROM cat02_materia WHERE tx_nombre='Matemáticas Discretas'),
    (SELECT id_docente FROM esc05_docente WHERE tx_apellido_p='Buitrón' AND tx_apellido_m='Damaso'),
    (SELECT id_aula FROM esc06_aula WHERE tx_clave='3201'),
    '2026-06-04 12:00:00';

-- Fundamentos de Programación - Cecilia Albortante Morato
INSERT INTO esc07_ets (fk_id_materia, fk_id_docente, fk_id_aula, fh_aplicacion)
SELECT
    (SELECT id_materia FROM cat02_materia WHERE tx_nombre='Fundamentos de Programación'),
    (SELECT id_docente FROM esc05_docente WHERE tx_apellido_p='Albortante' AND tx_apellido_m='Morato'),
    (SELECT id_aula FROM esc06_aula WHERE tx_clave='LAB-1'),
    '2026-06-05 08:00:00';

-- Algoritmos y Estructuras de Datos - Edgardo Adrián Franco Martínez
INSERT INTO esc07_ets (fk_id_materia, fk_id_docente, fk_id_aula, fh_aplicacion)
SELECT
    (SELECT id_materia FROM cat02_materia WHERE tx_nombre='Algoritmos y Estructuras de Datos'),
    (SELECT id_docente FROM esc05_docente WHERE tx_apellido_p='Franco' AND tx_apellido_m='Martínez'),
    (SELECT id_aula FROM esc06_aula WHERE tx_clave='LAB-2'),
    '2026-06-06 10:00:00';

-- Bases de Datos - Alejandro Botello Castillo
INSERT INTO esc07_ets (fk_id_materia, fk_id_docente, fk_id_aula, fh_aplicacion)
SELECT
    (SELECT id_materia FROM cat02_materia WHERE tx_nombre='Bases de Datos'),
    (SELECT id_docente FROM esc05_docente WHERE tx_apellido_p='Botello' AND tx_apellido_m='Castillo'),
    (SELECT id_aula FROM esc06_aula WHERE tx_clave='LAB-3'),
    '2026-06-09 12:00:00';

-- Paradigmas de Programación - Rafael Aguilar García
INSERT INTO esc07_ets (fk_id_materia, fk_id_docente, fk_id_aula, fh_aplicacion)
SELECT
    (SELECT id_materia FROM cat02_materia WHERE tx_nombre='Paradigmas de Programación'),
    (SELECT id_docente FROM esc05_docente WHERE tx_apellido_p='Aguilar' AND tx_apellido_m='García'),
    (SELECT id_aula FROM esc06_aula WHERE tx_clave='3202'),
    '2026-06-10 14:00:00';

-- Análisis y Diseño de Algoritmos - Cristhian Alejandro Ávila Sánchez
INSERT INTO esc07_ets (fk_id_materia, fk_id_docente, fk_id_aula, fh_aplicacion)
SELECT
    (SELECT id_materia FROM cat02_materia WHERE tx_nombre='Análisis y Diseño de Algoritmos'),
    (SELECT id_docente FROM esc05_docente WHERE tx_apellido_p='Ávila' AND tx_apellido_m='Sánchez'),
    (SELECT id_aula FROM esc06_aula WHERE tx_clave='3301'),
    '2026-06-11 08:00:00';

-- Ecuaciones Diferenciales - Juan Manuel Carballo Jiménez
INSERT INTO esc07_ets (fk_id_materia, fk_id_docente, fk_id_aula, fh_aplicacion)
SELECT
    (SELECT id_materia FROM cat02_materia WHERE tx_nombre='Ecuaciones Diferenciales'),
    (SELECT id_docente FROM esc05_docente WHERE tx_apellido_p='Carballo' AND tx_apellido_m='Jiménez'),
    (SELECT id_aula FROM esc06_aula WHERE tx_clave='3302'),
    '2026-06-12 10:00:00';

-- Probabilidad y Estadística - Jorge Alberto Cruz Rojas
INSERT INTO esc07_ets (fk_id_materia, fk_id_docente, fk_id_aula, fh_aplicacion)
SELECT
    (SELECT id_materia FROM cat02_materia WHERE tx_nombre='Probabilidad y Estadística'),
    (SELECT id_docente FROM esc05_docente WHERE tx_apellido_p='Cruz' AND tx_apellido_m='Rojas'),
    (SELECT id_aula FROM esc06_aula WHERE tx_clave='4101'),
    '2026-06-13 12:00:00';

-- Sistemas Operativos - David Araujo Díaz
INSERT INTO esc07_ets (fk_id_materia, fk_id_docente, fk_id_aula, fh_aplicacion)
SELECT
    (SELECT id_materia FROM cat02_materia WHERE tx_nombre='Sistemas Operativos'),
    (SELECT id_docente FROM esc05_docente WHERE tx_apellido_p='Araujo' AND tx_apellido_m='Díaz'),
    (SELECT id_aula FROM esc06_aula WHERE tx_clave='LAB-4'),
    '2026-06-16 08:00:00';

-- Redes de Computadoras - Juan Jesús Alcaraz Torres
INSERT INTO esc07_ets (fk_id_materia, fk_id_docente, fk_id_aula, fh_aplicacion)
SELECT
    (SELECT id_materia FROM cat02_materia WHERE tx_nombre='Redes de Computadoras'),
    (SELECT id_docente FROM esc05_docente WHERE tx_apellido_p='Alcaraz' AND tx_apellido_m='Torres'),
    (SELECT id_aula FROM esc06_aula WHERE tx_clave='LAB-1'),
    '2026-06-17 10:00:00';

-- Compiladores - Alberto Jesús Alcántara Méndez
INSERT INTO esc07_ets (fk_id_materia, fk_id_docente, fk_id_aula, fh_aplicacion)
SELECT
    (SELECT id_materia FROM cat02_materia WHERE tx_nombre='Compiladores'),
    (SELECT id_docente FROM esc05_docente WHERE tx_apellido_p='Alcántara' AND tx_apellido_m='Méndez'),
    (SELECT id_aula FROM esc06_aula WHERE tx_clave='4102'),
    '2026-06-18 12:00:00';

-- Ingeniería de Software - Martha Rosa Cordero López
INSERT INTO esc07_ets (fk_id_materia, fk_id_docente, fk_id_aula, fh_aplicacion)
SELECT
    (SELECT id_materia FROM cat02_materia WHERE tx_nombre='Ingeniería de Software'),
    (SELECT id_docente FROM esc05_docente WHERE tx_apellido_p='Cordero' AND tx_apellido_m='López'),
    (SELECT id_aula FROM esc06_aula WHERE tx_clave='4201'),
    '2026-06-19 14:00:00';

-- Inteligencia Artificial - Daniel Aguilar Velázquez
INSERT INTO esc07_ets (fk_id_materia, fk_id_docente, fk_id_aula, fh_aplicacion)
SELECT
    (SELECT id_materia FROM cat02_materia WHERE tx_nombre='Inteligencia Artificial'),
    (SELECT id_docente FROM esc05_docente WHERE tx_apellido_p='Aguilar' AND tx_apellido_m='Velázquez'),
    (SELECT id_aula FROM esc06_aula WHERE tx_clave='LAB-2'),
    '2026-06-20 08:00:00';

-- Finanzas Empresariales - Verónica Agustín Domínguez
INSERT INTO esc07_ets (fk_id_materia, fk_id_docente, fk_id_aula, fh_aplicacion)
SELECT
    (SELECT id_materia FROM cat02_materia WHERE tx_nombre='Finanzas Empresariales'),
    (SELECT id_docente FROM esc05_docente WHERE tx_apellido_p='Agustín' AND tx_apellido_m='Domínguez'),
    (SELECT id_aula FROM esc06_aula WHERE tx_clave='3101'),
    '2026-06-23 10:00:00';

-- Comunicación Oral y Escrita - Maribel Aragón García
INSERT INTO esc07_ets (fk_id_materia, fk_id_docente, fk_id_aula, fh_aplicacion)
SELECT
    (SELECT id_materia FROM cat02_materia WHERE tx_nombre='Comunicación Oral y Escrita'),
    (SELECT id_docente FROM esc05_docente WHERE tx_apellido_p='Aragón' AND tx_apellido_m='García'),
    (SELECT id_aula FROM esc06_aula WHERE tx_clave='3102'),
    '2026-06-24 12:00:00';

-- Teoría de la Computación - Luis Enrique Hernández Olvera
INSERT INTO esc07_ets (fk_id_materia, fk_id_docente, fk_id_aula, fh_aplicacion)
SELECT
    (SELECT id_materia FROM cat02_materia WHERE tx_nombre='Teoría de la Computación'),
    (SELECT id_docente FROM esc05_docente WHERE tx_apellido_p='Hernández' AND tx_apellido_m='Olvera'),
    (SELECT id_aula FROM esc06_aula WHERE tx_clave='3201'),
    '2026-06-25 14:00:00';

-- Bases de Datos (segundo ETS con docente distinto) - Erika Hernández Rubio
INSERT INTO esc07_ets (fk_id_materia, fk_id_docente, fk_id_aula, fh_aplicacion)
SELECT
    (SELECT id_materia FROM cat02_materia WHERE tx_nombre='Bases de Datos'),
    (SELECT id_docente FROM esc05_docente WHERE tx_apellido_p='Hernández' AND tx_apellido_m='Rubio'),
    (SELECT id_aula FROM esc06_aula WHERE tx_clave='LAB-3'),
    '2026-06-26 08:00:00';

-- =========================================
-- ETS ADICIONALES - MATEMÁTICAS Y BÁSICAS
-- =========================================

-- Cálculo Aplicado - Claudia Celia Díaz Huerta
INSERT INTO esc07_ets (fk_id_materia, fk_id_docente, fk_id_aula, fh_aplicacion)
SELECT
    (SELECT id_materia FROM cat02_materia WHERE tx_nombre='Cálculo Aplicado'),
    (SELECT id_docente FROM esc05_docente WHERE tx_apellido_p='Díaz' AND tx_apellido_m='Huerta'),
    (SELECT id_aula FROM esc06_aula WHERE tx_clave='3101'),
    '2026-06-02 10:00:00';

-- Análisis Vectorial - Benjamín López Carrera
INSERT INTO esc07_ets (fk_id_materia, fk_id_docente, fk_id_aula, fh_aplicacion)
SELECT
    (SELECT id_materia FROM cat02_materia WHERE tx_nombre='Análisis Vectorial'),
    (SELECT id_docente FROM esc05_docente WHERE tx_apellido_p='López' AND tx_apellido_m='Carrera'),
    (SELECT id_aula FROM esc06_aula WHERE tx_clave='3102'),
    '2026-06-03 14:00:00';

-- Cálculo Multivariable - Christian René Leal Pacheco
INSERT INTO esc07_ets (fk_id_materia, fk_id_docente, fk_id_aula, fh_aplicacion)
SELECT
    (SELECT id_materia FROM cat02_materia WHERE tx_nombre='Cálculo Multivariable'),
    (SELECT id_docente FROM esc05_docente WHERE tx_apellido_p='Leal' AND tx_apellido_m='Pacheco'),
    (SELECT id_aula FROM esc06_aula WHERE tx_clave='3201'),
    '2026-06-04 08:00:00';

-- Mecánica y Electromagnetismo - Florencio Guzmán Aguilar
INSERT INTO esc07_ets (fk_id_materia, fk_id_docente, fk_id_aula, fh_aplicacion)
SELECT
    (SELECT id_materia FROM cat02_materia WHERE tx_nombre='Mecánica y Electromagnetismo'),
    (SELECT id_docente FROM esc05_docente WHERE tx_apellido_p='Guzmán' AND tx_apellido_m='Aguilar'),
    (SELECT id_aula FROM esc06_aula WHERE tx_clave='3202'),
    '2026-06-05 14:00:00';

-- Matemáticas Avanzadas para la Ingeniería - Ignacio Ríos de la Torre
INSERT INTO esc07_ets (fk_id_materia, fk_id_docente, fk_id_aula, fh_aplicacion)
SELECT
    (SELECT id_materia FROM cat02_materia WHERE tx_nombre='Matemáticas Avanzadas para la Ingeniería'),
    (SELECT id_docente FROM esc05_docente WHERE tx_apellido_p='Ríos de la Torre'),
    (SELECT id_aula FROM esc06_aula WHERE tx_clave='3301'),
    '2026-06-08 10:00:00';

-- Probabilidad - Leonor Vázquez González
INSERT INTO esc07_ets (fk_id_materia, fk_id_docente, fk_id_aula, fh_aplicacion)
SELECT
    (SELECT id_materia FROM cat02_materia WHERE tx_nombre='Probabilidad'),
    (SELECT id_docente FROM esc05_docente WHERE tx_apellido_p='Vázquez' AND tx_apellido_m='González'),
    (SELECT id_aula FROM esc06_aula WHERE tx_clave='3302'),
    '2026-06-09 14:00:00';

-- Estadística - Jorge Alberto Cruz Rojas
INSERT INTO esc07_ets (fk_id_materia, fk_id_docente, fk_id_aula, fh_aplicacion)
SELECT
    (SELECT id_materia FROM cat02_materia WHERE tx_nombre='Estadística'),
    (SELECT id_docente FROM esc05_docente WHERE tx_apellido_p='Cruz' AND tx_apellido_m='Rojas'),
    (SELECT id_aula FROM esc06_aula WHERE tx_clave='4101'),
    '2026-06-10 10:00:00';

-- Métodos Numéricos - Alfonso Sánchez Aguilar
INSERT INTO esc07_ets (fk_id_materia, fk_id_docente, fk_id_aula, fh_aplicacion)
SELECT
    (SELECT id_materia FROM cat02_materia WHERE tx_nombre='Métodos Numéricos'),
    (SELECT id_docente FROM esc05_docente WHERE tx_apellido_p='Sánchez' AND tx_apellido_m='Aguilar'),
    (SELECT id_aula FROM esc06_aula WHERE tx_clave='4102'),
    '2026-06-11 14:00:00';

-- Procesos Estocásticos - Alfonso Sánchez Aguilar
INSERT INTO esc07_ets (fk_id_materia, fk_id_docente, fk_id_aula, fh_aplicacion)
SELECT
    (SELECT id_materia FROM cat02_materia WHERE tx_nombre='Procesos Estocásticos'),
    (SELECT id_docente FROM esc05_docente WHERE tx_apellido_p='Sánchez' AND tx_apellido_m='Aguilar'),
    (SELECT id_aula FROM esc06_aula WHERE tx_clave='4201'),
    '2026-06-15 08:00:00';

-- =========================================
-- ETS ADICIONALES - HARDWARE Y SEÑALES
-- =========================================

-- Fundamentos de Diseño Digital - Rubén Galicia Mejía
INSERT INTO esc07_ets (fk_id_materia, fk_id_docente, fk_id_aula, fh_aplicacion)
SELECT
    (SELECT id_materia FROM cat02_materia WHERE tx_nombre='Fundamentos de Diseño Digital'),
    (SELECT id_docente FROM esc05_docente WHERE tx_apellido_p='Galicia' AND tx_apellido_m='Mejía'),
    (SELECT id_aula FROM esc06_aula WHERE tx_clave='LAB-1'),
    '2026-06-02 14:00:00';

-- Diseño de Sistemas Digitales - Erick Eugenio Linares Vallejo
INSERT INTO esc07_ets (fk_id_materia, fk_id_docente, fk_id_aula, fh_aplicacion)
SELECT
    (SELECT id_materia FROM cat02_materia WHERE tx_nombre='Diseño de Sistemas Digitales'),
    (SELECT id_docente FROM esc05_docente WHERE tx_apellido_p='Linares' AND tx_apellido_m='Vallejo'),
    (SELECT id_aula FROM esc06_aula WHERE tx_clave='LAB-2'),
    '2026-06-03 08:00:00';

-- Arquitectura de Computadoras - Victor Hugo García Ortega
INSERT INTO esc07_ets (fk_id_materia, fk_id_docente, fk_id_aula, fh_aplicacion)
SELECT
    (SELECT id_materia FROM cat02_materia WHERE tx_nombre='Arquitectura de Computadoras'),
    (SELECT id_docente FROM esc05_docente WHERE tx_apellido_p='García' AND tx_apellido_m='Ortega'),
    (SELECT id_aula FROM esc06_aula WHERE tx_clave='LAB-3'),
    '2026-06-04 10:00:00';

-- Circuitos Eléctricos - Rocío Almazán Farfán
INSERT INTO esc07_ets (fk_id_materia, fk_id_docente, fk_id_aula, fh_aplicacion)
SELECT
    (SELECT id_materia FROM cat02_materia WHERE tx_nombre='Circuitos Eléctricos'),
    (SELECT id_docente FROM esc05_docente WHERE tx_apellido_p='Almazán' AND tx_apellido_m='Farfán'),
    (SELECT id_aula FROM esc06_aula WHERE tx_clave='3101'),
    '2026-06-05 10:00:00';

-- Electrónica Analógica - Sergio Cancino Calderón
INSERT INTO esc07_ets (fk_id_materia, fk_id_docente, fk_id_aula, fh_aplicacion)
SELECT
    (SELECT id_materia FROM cat02_materia WHERE tx_nombre='Electrónica Analógica'),
    (SELECT id_docente FROM esc05_docente WHERE tx_apellido_p='Cancino' AND tx_apellido_m='Calderón'),
    (SELECT id_aula FROM esc06_aula WHERE tx_clave='3102'),
    '2026-06-08 12:00:00';

-- Procesamiento Digital de Señales - Gelacio Castillo Cabrera
INSERT INTO esc07_ets (fk_id_materia, fk_id_docente, fk_id_aula, fh_aplicacion)
SELECT
    (SELECT id_materia FROM cat02_materia WHERE tx_nombre='Procesamiento Digital de Señales'),
    (SELECT id_docente FROM esc05_docente WHERE tx_apellido_p='Castillo' AND tx_apellido_m='Cabrera'),
    (SELECT id_aula FROM esc06_aula WHERE tx_clave='LAB-4'),
    '2026-06-09 08:00:00';

-- Instrumentación y Control - José Luis Hernández Aguilar
INSERT INTO esc07_ets (fk_id_materia, fk_id_docente, fk_id_aula, fh_aplicacion)
SELECT
    (SELECT id_materia FROM cat02_materia WHERE tx_nombre='Instrumentación y Control'),
    (SELECT id_docente FROM esc05_docente WHERE tx_apellido_p='Hernández' AND tx_apellido_m='Aguilar'),
    (SELECT id_aula FROM esc06_aula WHERE tx_clave='3201'),
    '2026-06-10 12:00:00';

-- =========================================
-- ETS ADICIONALES - IA / CIENCIA DE DATOS
-- =========================================

-- Fundamentos de Inteligencia Artificial - Cristal Karina Galindo Durán
INSERT INTO esc07_ets (fk_id_materia, fk_id_docente, fk_id_aula, fh_aplicacion)
SELECT
    (SELECT id_materia FROM cat02_materia WHERE tx_nombre='Fundamentos de Inteligencia Artificial'),
    (SELECT id_docente FROM esc05_docente WHERE tx_apellido_p='Galindo' AND tx_apellido_m='Durán'),
    (SELECT id_aula FROM esc06_aula WHERE tx_clave='LAB-1'),
    '2026-06-11 10:00:00';

-- Aprendizaje de Máquina - Consuelo Varinia García Mendoza
INSERT INTO esc07_ets (fk_id_materia, fk_id_docente, fk_id_aula, fh_aplicacion)
SELECT
    (SELECT id_materia FROM cat02_materia WHERE tx_nombre='Aprendizaje de Máquina'),
    (SELECT id_docente FROM esc05_docente WHERE tx_apellido_p='García' AND tx_apellido_m='Mendoza'),
    (SELECT id_aula FROM esc06_aula WHERE tx_clave='LAB-2'),
    '2026-06-12 12:00:00';

-- Visión Artificial - Octavio Sánchez García
INSERT INTO esc07_ets (fk_id_materia, fk_id_docente, fk_id_aula, fh_aplicacion)
SELECT
    (SELECT id_materia FROM cat02_materia WHERE tx_nombre='Visión Artificial'),
    (SELECT id_docente FROM esc05_docente WHERE tx_apellido_p='Sánchez' AND tx_apellido_m='García' AND tx_nombre='Octavio'),
    (SELECT id_aula FROM esc06_aula WHERE tx_clave='LAB-3'),
    '2026-06-15 10:00:00';

-- Algoritmos Bioinspirados - Jorge Luís Rosas Trigueros
INSERT INTO esc07_ets (fk_id_materia, fk_id_docente, fk_id_aula, fh_aplicacion)
SELECT
    (SELECT id_materia FROM cat02_materia WHERE tx_nombre='Algoritmos Bioinspirados'),
    (SELECT id_docente FROM esc05_docente WHERE tx_apellido_p='Rosas' AND tx_apellido_m='Trigueros'),
    (SELECT id_aula FROM esc06_aula WHERE tx_clave='3202'),
    '2026-06-16 12:00:00';

-- Tecnologías de Lenguaje Natural - Joel Omar Juárez Gambino
INSERT INTO esc07_ets (fk_id_materia, fk_id_docente, fk_id_aula, fh_aplicacion)
SELECT
    (SELECT id_materia FROM cat02_materia WHERE tx_nombre='Tecnologías de Lenguaje Natural'),
    (SELECT id_docente FROM esc05_docente WHERE tx_apellido_p='Juárez' AND tx_apellido_m='Gambino'),
    (SELECT id_aula FROM esc06_aula WHERE tx_clave='LAB-4'),
    '2026-06-17 14:00:00';

-- Cómputo Paralelo - Sandra Luz Morales Güitrón
INSERT INTO esc07_ets (fk_id_materia, fk_id_docente, fk_id_aula, fh_aplicacion)
SELECT
    (SELECT id_materia FROM cat02_materia WHERE tx_nombre='Cómputo Paralelo'),
    (SELECT id_docente FROM esc05_docente WHERE tx_apellido_p='Morales' AND tx_apellido_m='Güitrón'),
    (SELECT id_aula FROM esc06_aula WHERE tx_clave='LAB-1'),
    '2026-06-18 08:00:00';

-- Introducción a la Ciencia de Datos - Fabiola Ocampo Botello
INSERT INTO esc07_ets (fk_id_materia, fk_id_docente, fk_id_aula, fh_aplicacion)
SELECT
    (SELECT id_materia FROM cat02_materia WHERE tx_nombre='Introducción a la Ciencia de Datos'),
    (SELECT id_docente FROM esc05_docente WHERE tx_apellido_p='Ocampo' AND tx_apellido_m='Botello'),
    (SELECT id_aula FROM esc06_aula WHERE tx_clave='3301'),
    '2026-06-19 10:00:00';

-- Programación para Ciencia de Datos - Daniel Aguilar Velázquez
INSERT INTO esc07_ets (fk_id_materia, fk_id_docente, fk_id_aula, fh_aplicacion)
SELECT
    (SELECT id_materia FROM cat02_materia WHERE tx_nombre='Programación para Ciencia de Datos'),
    (SELECT id_docente FROM esc05_docente WHERE tx_apellido_p='Aguilar' AND tx_apellido_m='Velázquez'),
    (SELECT id_aula FROM esc06_aula WHERE tx_clave='LAB-2'),
    '2026-06-22 08:00:00';

-- Minería de Datos - Roberto Eswart Zagal Flores
INSERT INTO esc07_ets (fk_id_materia, fk_id_docente, fk_id_aula, fh_aplicacion)
SELECT
    (SELECT id_materia FROM cat02_materia WHERE tx_nombre='Minería de Datos'),
    (SELECT id_docente FROM esc05_docente WHERE tx_apellido_p='Zagal' AND tx_apellido_m='Flores'),
    (SELECT id_aula FROM esc06_aula WHERE tx_clave='LAB-3'),
    '2026-06-23 12:00:00';

-- Análisis de Series de Tiempo - Uriel Corona Bermúdez
INSERT INTO esc07_ets (fk_id_materia, fk_id_docente, fk_id_aula, fh_aplicacion)
SELECT
    (SELECT id_materia FROM cat02_materia WHERE tx_nombre='Análisis de Series de Tiempo'),
    (SELECT id_docente FROM esc05_docente WHERE tx_apellido_p='Corona' AND tx_apellido_m='Bermúdez'),
    (SELECT id_aula FROM esc06_aula WHERE tx_clave='3302'),
    '2026-06-24 10:00:00';

-- Modelado Predictivo - Uriel Corona Bermúdez
INSERT INTO esc07_ets (fk_id_materia, fk_id_docente, fk_id_aula, fh_aplicacion)
SELECT
    (SELECT id_materia FROM cat02_materia WHERE tx_nombre='Modelado Predictivo'),
    (SELECT id_docente FROM esc05_docente WHERE tx_apellido_p='Corona' AND tx_apellido_m='Bermúdez'),
    (SELECT id_aula FROM esc06_aula WHERE tx_clave='4101'),
    '2026-06-25 12:00:00';

-- =========================================
-- ETS ADICIONALES - SISTEMAS Y REDES
-- =========================================

-- Análisis y Diseño de Sistemas - Marco Antonio Dorantes González
INSERT INTO esc07_ets (fk_id_materia, fk_id_docente, fk_id_aula, fh_aplicacion)
SELECT
    (SELECT id_materia FROM cat02_materia WHERE tx_nombre='Análisis y Diseño de Sistemas'),
    (SELECT id_docente FROM esc05_docente WHERE tx_apellido_p='Dorantes' AND tx_apellido_m='González'),
    (SELECT id_aula FROM esc06_aula WHERE tx_clave='4102'),
    '2026-06-02 12:00:00';

-- Tecnologías para el Desarrollo de Aplicaciones Web - José Asunción Enríquez Zárate
INSERT INTO esc07_ets (fk_id_materia, fk_id_docente, fk_id_aula, fh_aplicacion)
SELECT
    (SELECT id_materia FROM cat02_materia WHERE tx_nombre='Tecnologías para el Desarrollo de Aplicaciones Web'),
    (SELECT id_docente FROM esc05_docente WHERE tx_apellido_p='Enríquez' AND tx_apellido_m='Zárate'),
    (SELECT id_aula FROM esc06_aula WHERE tx_clave='LAB-1'),
    '2026-06-03 12:00:00';

-- Sistemas Distribuidos - Ukranio Coronilla Contreras
INSERT INTO esc07_ets (fk_id_materia, fk_id_docente, fk_id_aula, fh_aplicacion)
SELECT
    (SELECT id_materia FROM cat02_materia WHERE tx_nombre='Sistemas Distribuidos'),
    (SELECT id_docente FROM esc05_docente WHERE tx_apellido_p='Coronilla' AND tx_apellido_m='Contreras'),
    (SELECT id_aula FROM esc06_aula WHERE tx_clave='LAB-4'),
    '2026-06-04 12:00:00';

-- Aplicaciones para Comunicaciones en Red - Sandra Ivette Bautista Rosales
INSERT INTO esc07_ets (fk_id_materia, fk_id_docente, fk_id_aula, fh_aplicacion)
SELECT
    (SELECT id_materia FROM cat02_materia WHERE tx_nombre='Aplicaciones para Comunicaciones en Red'),
    (SELECT id_docente FROM esc05_docente WHERE tx_apellido_p='Bautista' AND tx_apellido_m='Rosales'),
    (SELECT id_aula FROM esc06_aula WHERE tx_clave='LAB-2'),
    '2026-06-05 12:00:00';

-- Administración de Servicios en Red - Leticia Henestrosa Carrasco
INSERT INTO esc07_ets (fk_id_materia, fk_id_docente, fk_id_aula, fh_aplicacion)
SELECT
    (SELECT id_materia FROM cat02_materia WHERE tx_nombre='Administración de Servicios en Red'),
    (SELECT id_docente FROM esc05_docente WHERE tx_apellido_p='Henestrosa' AND tx_apellido_m='Carrasco'),
    (SELECT id_aula FROM esc06_aula WHERE tx_clave='LAB-3'),
    '2026-06-08 14:00:00';

-- =========================================
-- ETS ADICIONALES - ÁREA SOCIAL / ECONÓMICA
-- =========================================

-- Fundamentos Económicos - Gloria Lourdes Cabrera Chávez
INSERT INTO esc07_ets (fk_id_materia, fk_id_docente, fk_id_aula, fh_aplicacion)
SELECT
    (SELECT id_materia FROM cat02_materia WHERE tx_nombre='Fundamentos Económicos'),
    (SELECT id_docente FROM esc05_docente WHERE tx_apellido_p='Cabrera' AND tx_apellido_m='Chávez'),
    (SELECT id_aula FROM esc06_aula WHERE tx_clave='3101'),
    '2026-06-09 12:00:00';

-- Gestión Empresarial - Odette Berenice Cancino Mosqueda
INSERT INTO esc07_ets (fk_id_materia, fk_id_docente, fk_id_aula, fh_aplicacion)
SELECT
    (SELECT id_materia FROM cat02_materia WHERE tx_nombre='Gestión Empresarial'),
    (SELECT id_docente FROM esc05_docente WHERE tx_apellido_p='Cancino' AND tx_apellido_m='Mosqueda'),
    (SELECT id_aula FROM esc06_aula WHERE tx_clave='3102'),
    '2026-06-10 14:00:00';

-- Ingeniería, Ética y Sociedad - Mariana Gómez Tress
INSERT INTO esc07_ets (fk_id_materia, fk_id_docente, fk_id_aula, fh_aplicacion)
SELECT
    (SELECT id_materia FROM cat02_materia WHERE tx_nombre='Ingeniería, Ética y Sociedad'),
    (SELECT id_docente FROM esc05_docente WHERE tx_apellido_p='Gómez' AND tx_apellido_m='Tress'),
    (SELECT id_aula FROM esc06_aula WHERE tx_clave='3201'),
    '2026-06-11 12:00:00';

-- Ética y Legalidad - Lilian Martínez Acosta
INSERT INTO esc07_ets (fk_id_materia, fk_id_docente, fk_id_aula, fh_aplicacion)
SELECT
    (SELECT id_materia FROM cat02_materia WHERE tx_nombre='Ética y Legalidad'),
    (SELECT id_docente FROM esc05_docente WHERE tx_apellido_p='Martínez' AND tx_apellido_m='Acosta'),
    (SELECT id_aula FROM esc06_aula WHERE tx_clave='3202'),
    '2026-06-12 14:00:00';

-- Liderazgo Personal - Jorge Ferrer Tenorio
INSERT INTO esc07_ets (fk_id_materia, fk_id_docente, fk_id_aula, fh_aplicacion)
SELECT
    (SELECT id_materia FROM cat02_materia WHERE tx_nombre='Liderazgo Personal'),
    (SELECT id_docente FROM esc05_docente WHERE tx_apellido_p='Ferrer' AND tx_apellido_m='Tenorio'),
    (SELECT id_aula FROM esc06_aula WHERE tx_clave='3301'),
    '2026-06-15 12:00:00';

-- Metodología de la Investigación y Divulgación Científica - Adriana Berenice Celis Domínguez
INSERT INTO esc07_ets (fk_id_materia, fk_id_docente, fk_id_aula, fh_aplicacion)
SELECT
    (SELECT id_materia FROM cat02_materia WHERE tx_nombre='Metodología de la Investigación y Divulgación Científica'),
    (SELECT id_docente FROM esc05_docente WHERE tx_apellido_p='Celis' AND tx_apellido_m='Domínguez'),
    (SELECT id_aula FROM esc06_aula WHERE tx_clave='3302'),
    '2026-06-16 14:00:00';

-- Formulación y Evaluación de Proyectos Informáticos - Rocío Palacios Solano
INSERT INTO esc07_ets (fk_id_materia, fk_id_docente, fk_id_aula, fh_aplicacion)
SELECT
    (SELECT id_materia FROM cat02_materia WHERE tx_nombre='Formulación y Evaluación de Proyectos Informáticos'),
    (SELECT id_docente FROM esc05_docente WHERE tx_apellido_p='Palacios' AND tx_apellido_m='Solano'),
    (SELECT id_aula FROM esc06_aula WHERE tx_clave='4201'),
    '2026-06-17 10:00:00';

-- Métodos Cuantitativos para la Toma de Decisiones - Guillermo Márquez Arreguín
INSERT INTO esc07_ets (fk_id_materia, fk_id_docente, fk_id_aula, fh_aplicacion)
SELECT
    (SELECT id_materia FROM cat02_materia WHERE tx_nombre='Métodos Cuantitativos para la Toma de Decisiones'),
    (SELECT id_docente FROM esc05_docente WHERE tx_apellido_p='Márquez' AND tx_apellido_m='Arreguín'),
    (SELECT id_aula FROM esc06_aula WHERE tx_clave='4202'),
    '2026-06-18 10:00:00';

-- =========================================
-- ETS ADICIONALES - OPTATIVAS (algunas)
-- =========================================

-- Computer Security - Alejandro Sigfrido Cifuentes Álvarez
INSERT INTO esc07_ets (fk_id_materia, fk_id_docente, fk_id_aula, fh_aplicacion)
SELECT
    (SELECT id_materia FROM cat02_materia WHERE tx_nombre='Computer Security'),
    (SELECT id_docente FROM esc05_docente WHERE tx_apellido_p='Cifuentes' AND tx_apellido_m='Álvarez'),
    (SELECT id_aula FROM esc06_aula WHERE tx_clave='LAB-1'),
    '2026-06-19 14:00:00';

-- Introduction to Cryptography - Nidia Asunción Cortez Duarte
INSERT INTO esc07_ets (fk_id_materia, fk_id_docente, fk_id_aula, fh_aplicacion)
SELECT
    (SELECT id_materia FROM cat02_materia WHERE tx_nombre='Introduction to Cryptography'),
    (SELECT id_docente FROM esc05_docente WHERE tx_apellido_p='Cortez' AND tx_apellido_m='Duarte'),
    (SELECT id_aula FROM esc06_aula WHERE tx_clave='LAB-2'),
    '2026-06-22 10:00:00';

-- Machine Learning - Joel Omar Juárez Gambino
INSERT INTO esc07_ets (fk_id_materia, fk_id_docente, fk_id_aula, fh_aplicacion)
SELECT
    (SELECT id_materia FROM cat02_materia WHERE tx_nombre='Machine Learning'),
    (SELECT id_docente FROM esc05_docente WHERE tx_apellido_p='Juárez' AND tx_apellido_m='Gambino'),
    (SELECT id_aula FROM esc06_aula WHERE tx_clave='LAB-3'),
    '2026-06-23 14:00:00';

-- Genetic Algorithms - María Elena Cruz Meza
INSERT INTO esc07_ets (fk_id_materia, fk_id_docente, fk_id_aula, fh_aplicacion)
SELECT
    (SELECT id_materia FROM cat02_materia WHERE tx_nombre='Genetic Algorithms'),
    (SELECT id_docente FROM esc05_docente WHERE tx_apellido_p='Cruz' AND tx_apellido_m='Meza'),
    (SELECT id_aula FROM esc06_aula WHERE tx_clave='LAB-4'),
    '2026-06-24 14:00:00';

-- Image Analysis - María Elena Cruz Meza
INSERT INTO esc07_ets (fk_id_materia, fk_id_docente, fk_id_aula, fh_aplicacion)
SELECT
    (SELECT id_materia FROM cat02_materia WHERE tx_nombre='Image Analysis'),
    (SELECT id_docente FROM esc05_docente WHERE tx_apellido_p='Cruz' AND tx_apellido_m='Meza'),
    (SELECT id_aula FROM esc06_aula WHERE tx_clave='3101'),
    '2026-06-25 10:00:00';

-- Computer Graphics - Rafael Norman Saucedo Delgado
INSERT INTO esc07_ets (fk_id_materia, fk_id_docente, fk_id_aula, fh_aplicacion)
SELECT
    (SELECT id_materia FROM cat02_materia WHERE tx_nombre='Computer Graphics'),
    (SELECT id_docente FROM esc05_docente WHERE tx_apellido_p='Saucedo' AND tx_apellido_m='Delgado'),
    (SELECT id_aula FROM esc06_aula WHERE tx_clave='3102'),
    '2026-06-26 10:00:00';

-- Data Mining - Fabiola Ocampo Botello
INSERT INTO esc07_ets (fk_id_materia, fk_id_docente, fk_id_aula, fh_aplicacion)
SELECT
    (SELECT id_materia FROM cat02_materia WHERE tx_nombre='Data Mining'),
    (SELECT id_docente FROM esc05_docente WHERE tx_apellido_p='Ocampo' AND tx_apellido_m='Botello'),
    (SELECT id_aula FROM esc06_aula WHERE tx_clave='3201'),
    '2026-06-29 08:00:00';

-- High Technology Enterprise Management - Ariel López Rojas
INSERT INTO esc07_ets (fk_id_materia, fk_id_docente, fk_id_aula, fh_aplicacion)
SELECT
    (SELECT id_materia FROM cat02_materia WHERE tx_nombre='High Technology Enterprise Management'),
    (SELECT id_docente FROM esc05_docente WHERE tx_apellido_p='López' AND tx_apellido_m='Rojas'),
    (SELECT id_aula FROM esc06_aula WHERE tx_clave='3202'),
    '2026-06-30 10:00:00';

-- IT Governance - Jessie Paulina Guzmán Flores
INSERT INTO esc07_ets (fk_id_materia, fk_id_docente, fk_id_aula, fh_aplicacion)
SELECT
    (SELECT id_materia FROM cat02_materia WHERE tx_nombre='IT Governance'),
    (SELECT id_docente FROM esc05_docente WHERE tx_apellido_p='Guzmán' AND tx_apellido_m='Flores'),
    (SELECT id_aula FROM esc06_aula WHERE tx_clave='3301'),
    '2026-07-01 08:00:00';

-- Economic Engineering - Ángel Morales González
INSERT INTO esc07_ets (fk_id_materia, fk_id_docente, fk_id_aula, fh_aplicacion)
SELECT
    (SELECT id_materia FROM cat02_materia WHERE tx_nombre='Economic Engineering'),
    (SELECT id_docente FROM esc05_docente WHERE tx_apellido_p='Morales' AND tx_apellido_m='González'),
    (SELECT id_aula FROM esc06_aula WHERE tx_clave='3302'),
    '2026-07-02 10:00:00';

-- =========================================
-- ETS ADICIONALES - SEGUNDA VUELTA (AGOSTO) 
-- Mismas materias, segunda oportunidad
-- =========================================

-- Cálculo (2da vuelta) - Nestor Colin Hernández
INSERT INTO esc07_ets (fk_id_materia, fk_id_docente, fk_id_aula, fh_aplicacion)
SELECT
    (SELECT id_materia FROM cat02_materia WHERE tx_nombre='Cálculo'),
    (SELECT id_docente FROM esc05_docente WHERE tx_apellido_p='Colin' AND tx_apellido_m='Hernández'),
    (SELECT id_aula FROM esc06_aula WHERE tx_clave='3101'),
    '2026-08-04 08:00:00';

-- Fundamentos de Programación (2da vuelta) - Yaxkin Flores Mendoza
INSERT INTO esc07_ets (fk_id_materia, fk_id_docente, fk_id_aula, fh_aplicacion)
SELECT
    (SELECT id_materia FROM cat02_materia WHERE tx_nombre='Fundamentos de Programación'),
    (SELECT id_docente FROM esc05_docente WHERE tx_apellido_p='Flores' AND tx_apellido_m='Mendoza'),
    (SELECT id_aula FROM esc06_aula WHERE tx_clave='LAB-1'),
    '2026-08-05 10:00:00';

-- Algoritmos y Estructuras de Datos (2da vuelta) - Daniel Cruz García
INSERT INTO esc07_ets (fk_id_materia, fk_id_docente, fk_id_aula, fh_aplicacion)
SELECT
    (SELECT id_materia FROM cat02_materia WHERE tx_nombre='Algoritmos y Estructuras de Datos'),
    (SELECT id_docente FROM esc05_docente WHERE tx_apellido_p='Cruz' AND tx_apellido_m='García'),
    (SELECT id_aula FROM esc06_aula WHERE tx_clave='LAB-2'),
    '2026-08-06 12:00:00';

-- Bases de Datos (2da vuelta) - Lorena Chavarría Báez
INSERT INTO esc07_ets (fk_id_materia, fk_id_docente, fk_id_aula, fh_aplicacion)
SELECT
    (SELECT id_materia FROM cat02_materia WHERE tx_nombre='Bases de Datos'),
    (SELECT id_docente FROM esc05_docente WHERE tx_apellido_p='Chavarría' AND tx_apellido_m='Báez'),
    (SELECT id_aula FROM esc06_aula WHERE tx_clave='LAB-3'),
    '2026-08-07 14:00:00';

-- Paradigmas de Programación (2da vuelta) - Saúl De la O Torres
INSERT INTO esc07_ets (fk_id_materia, fk_id_docente, fk_id_aula, fh_aplicacion)
SELECT
    (SELECT id_materia FROM cat02_materia WHERE tx_nombre='Paradigmas de Programación'),
    (SELECT id_docente FROM esc05_docente WHERE tx_apellido_p='De la O' AND tx_apellido_m='Torres'),
    (SELECT id_aula FROM esc06_aula WHERE tx_clave='3201'),
    '2026-08-10 08:00:00';

-- Análisis y Diseño de Algoritmos (2da vuelta) - Ricardo Felipe Díaz Santiago
INSERT INTO esc07_ets (fk_id_materia, fk_id_docente, fk_id_aula, fh_aplicacion)
SELECT
    (SELECT id_materia FROM cat02_materia WHERE tx_nombre='Análisis y Diseño de Algoritmos'),
    (SELECT id_docente FROM esc05_docente WHERE tx_apellido_p='Díaz' AND tx_apellido_m='Santiago' AND tx_nombre='Ricardo Felipe'),
    (SELECT id_aula FROM esc06_aula WHERE tx_clave='3202'),
    '2026-08-11 10:00:00';

-- Sistemas Operativos (2da vuelta) - Jorge Cortés Galicia
INSERT INTO esc07_ets (fk_id_materia, fk_id_docente, fk_id_aula, fh_aplicacion)
SELECT
    (SELECT id_materia FROM cat02_materia WHERE tx_nombre='Sistemas Operativos'),
    (SELECT id_docente FROM esc05_docente WHERE tx_apellido_p='Cortés' AND tx_apellido_m='Galicia'),
    (SELECT id_aula FROM esc06_aula WHERE tx_clave='LAB-4'),
    '2026-08-12 12:00:00';

-- Compiladores (2da vuelta) - Miriam Pescador Rojas
INSERT INTO esc07_ets (fk_id_materia, fk_id_docente, fk_id_aula, fh_aplicacion)
SELECT
    (SELECT id_materia FROM cat02_materia WHERE tx_nombre='Compiladores'),
    (SELECT id_docente FROM esc05_docente WHERE tx_apellido_p='Pescador' AND tx_apellido_m='Rojas'),
    (SELECT id_aula FROM esc06_aula WHERE tx_clave='3301'),
    '2026-08-13 14:00:00';

-- Ingeniería de Software (2da vuelta) - Reyna Elia Melara Abarca
INSERT INTO esc07_ets (fk_id_materia, fk_id_docente, fk_id_aula, fh_aplicacion)
SELECT
    (SELECT id_materia FROM cat02_materia WHERE tx_nombre='Ingeniería de Software'),
    (SELECT id_docente FROM esc05_docente WHERE tx_apellido_p='Melara' AND tx_apellido_m='Abarca'),
    (SELECT id_aula FROM esc06_aula WHERE tx_clave='3302'),
    '2026-08-14 08:00:00';

-- Redes de Computadoras (2da vuelta) - Gilberto Sánchez Quintanilla
INSERT INTO esc07_ets (fk_id_materia, fk_id_docente, fk_id_aula, fh_aplicacion)
SELECT
    (SELECT id_materia FROM cat02_materia WHERE tx_nombre='Redes de Computadoras'),
    (SELECT id_docente FROM esc05_docente WHERE tx_apellido_p='Sánchez' AND tx_apellido_m='Quintanilla'),
    (SELECT id_aula FROM esc06_aula WHERE tx_clave='LAB-1'),
    '2026-08-17 10:00:00';
