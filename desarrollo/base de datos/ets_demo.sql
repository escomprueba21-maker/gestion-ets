-- =========================================================
-- ets_demo.sql
-- Datos de ejemplo: docentes, aulas y ETS simulados
-- =========================================================

-- =========================================
-- DOCENTES (tomados del catálogo oficial ESCOM)
-- =========================================

INSERT INTO esc05_docente (tx_nombre, tx_apellido_paterno, tx_apellido_materno, tx_correo) VALUES
('Rafael', 'Aguilar', 'García', 'raguilarg@ipn.mx'),
('Fernando', 'Aguilar', 'Sánchez', 'faguilars@ipn.mx'),
('Daniel', 'Aguilar', 'Velázquez', 'daguilarv@ipn.mx'),
('Verónica', 'Agustín', 'Domínguez', 'vagustind@ipn.mx'),
('Cecilia', 'Albortante', 'Morato', 'calbortantem@ipn.mx'),
('Alberto Jesús', 'Alcántara', 'Méndez', 'aalcantaram@ipn.mx'),
('Juan Jesús', 'Alcaraz', 'Torres', 'jalcarazt@ipn.mx'),
('Rocío', 'Almazán', 'Farfán', 'ralmazanf@ipn.mx'),
('Maribel', 'Aragón', 'García', 'maragong@ipn.mx'),
('David', 'Araujo', 'Díaz', 'daraujod@ipn.mx'),
('Jacqueline', 'Arzate', 'Gordillo', 'jarzateg@ipn.mx'),
('Cristhian Alejandro', 'Ávila', 'Sánchez', 'cavilas@ipn.mx'),
('Josue Emanuel', 'Barrón', 'Vera', 'jbarronv@ipn.mx'),
('Sandra Ivette', 'Bautista', 'Rosales', 'sbautistar@ipn.mx'),
('Ivan Eduardo', 'Blanco', 'Almazán', 'iblancoa@ipn.mx'),
('Alejandro', 'Botello', 'Castillo', 'abotelloc@ipn.mx'),
('Israel', 'Buitrón', 'Damaso', 'ibuitrond@ipn.mx'),
('Gloria Lourdes', 'Cabrera', 'Chávez', 'gcabrerac@ipn.mx'),
('Sergio', 'Cancino', 'Calderón', 'scancinoc@ipn.mx'),
('Odette Berenice', 'Cancino', 'Mosqueda', 'ocancinom@ipn.mx'),
('Leticia', 'Cañedo', 'Suárez', 'lcanedos@ipn.mx'),
('José Juan', 'Carbajal', 'Hernández', 'jcarbajalh@ipn.mx'),
('Juan Manuel', 'Carballo', 'Jiménez', 'jcarballoj@ipn.mx'),
('Oscar', 'Carranza', 'Castillo', 'ocarranzac@ipn.mx'),
('Chadwick', 'Carreto', 'Arellano', 'ccarretoa@ipn.mx'),
('Gelacio', 'Castillo', 'Cabrera', 'gcastilloc@ipn.mx'),
('Juan Antonio', 'Castillo', 'Marrufo', 'jcastillom@ipn.mx'),
('Edgar Armando', 'Catalán', 'Salgado', 'ecatalans@ipn.mx'),
('Ricardo', 'Ceballos', 'Sebastián', 'rceballoss@ipn.mx'),
('Adriana Berenice', 'Celis', 'Domínguez', 'acelisd@ipn.mx'),
('Maria Soledad', 'Centeno', 'Arrazola', 'mcentenoa@ipn.mx'),
('Ismael', 'Cervantes', 'De Anda', 'icervantesd@ipn.mx'),
('Luis Moctezuma', 'Cervantes', 'Espinosa', 'lcervantese@ipn.mx'),
('Lorena', 'Chavarría', 'Báez', 'lchavarriab@ipn.mx'),
('Eduardo', 'Chávez', 'Lima', 'echavezl@ipn.mx'),
('Alejandro Sigfrido', 'Cifuentes', 'Álvarez', 'acifuentesa@ipn.mx'),
('Nestor', 'Colin', 'Hernández', 'ncolinh@ipn.mx'),
('Martha Rosa', 'Cordero', 'López', 'mcorderol@ipn.mx'),
('Uriel', 'Corona', 'Bermúdez', 'ucoronab@ipn.mx'),
('Ukranio', 'Coronilla', 'Contreras', 'ucoronillac@ipn.mx'),
('Jorge', 'Cortés', 'Galicia', 'jcortesg@ipn.mx'),
('Nidia Asunción', 'Cortez', 'Duarte', 'ncortezd@ipn.mx'),
('Daniel', 'Cruz', 'García', 'dcruzg@ipn.mx'),
('Apolinar Francisco', 'Cruz', 'Lázaro', 'acruzl@ipn.mx'),
('María Elena', 'Cruz', 'Meza', 'mcruzm@ipn.mx'),
('Jorge Alberto', 'Cruz', 'Rojas', 'jcruzr@ipn.mx'),
('Benjamín', 'Cruz', 'Torres', 'bcruzt@ipn.mx'),
('José Carlos', 'Dávalos', 'López', 'jdavalosl@ipn.mx'),
('Saúl', 'De la O', 'Torres', 'sdelaot@ipn.mx'),
('Roberto', 'De Luna', 'Caballero', 'rdelunac@ipn.mx'),
('Claudia Celia', 'Díaz', 'Huerta', 'cdiazh@ipn.mx'),
('Ricardo Felipe', 'Díaz', 'Santiago', 'rdiazs@ipn.mx'),
('Sandra', 'Díaz', 'Santiago', 'sdiazs@ipn.mx'),
('Iván', 'Díaz', 'Toalá', 'idiazt@ipn.mx'),
('Marco Antonio', 'Dorantes', 'González', 'mdorantesg@ipn.mx'),
('Claudia Jisela', 'Dorantes', 'Villa', 'cdorantesv@ipn.mx'),
('Edmundo René', 'Durán', 'Camarillo', 'eduranc@ipn.mx'),
('Ángel Adalberto', 'Durán', 'Ledezma', 'aduranl@ipn.mx'),
('José Asunción', 'Enríquez', 'Zárate', 'jenriquezz@ipn.mx'),
('Patricia', 'Escamilla', 'Miranda', 'pescamillam@ipn.mx'),
('José Armando', 'Esquivel', 'Centeno', 'jesquivelc@ipn.mx'),
('Serafín', 'Estrada', 'Elizalde', 'sestradae@ipn.mx'),
('Alfonso', 'Fernández', 'Vázquez', 'afernandezv@ipn.mx'),
('Jorge', 'Ferrer', 'Tenorio', 'jferrert@ipn.mx'),
('Felipe de Jesús', 'Figueroa', 'Del Prado', 'ffigueroad@ipn.mx'),
('Raquel', 'Flores', 'Delgado', 'rfloresd@ipn.mx'),
('José Antonio', 'Flores', 'Escobar', 'jflorese@ipn.mx'),
('Ituriel Enrique', 'Flores', 'Estrada', 'ifloreses@ipn.mx'),
('Naria Adriana', 'Flores', 'Fuentes', 'nfloresf@ipn.mx'),
('Yaxkin', 'Flores', 'Mendoza', 'yfloresm@ipn.mx'),
('Yesica Sonia', 'Flores', 'Meraz', 'yfloresme@ipn.mx'),
('Edgardo Adrián', 'Franco', 'Martínez', 'efrancom@ipn.mx'),
('María del Rosario', 'Galeana', 'Chávez', 'mgaleanac@ipn.mx'),
('Rubén', 'Galicia', 'Mejía', 'rgaliciam@ipn.mx'),
('Cristal Karina', 'Galindo', 'Durán', 'cgalindod@ipn.mx'),
('María Gabriela', 'Galiñanes', 'Rodríguez', 'mgalinanesr@ipn.mx'),
('Consuelo Varinia', 'García', 'Mendoza', 'cgarciam@ipn.mx'),
('Victor Hugo', 'García', 'Ortega', 'vgarciao@ipn.mx'),
('Juan Vicente', 'García', 'Sales', 'jgarcias@ipn.mx'),
('Fabián', 'Gaspar', 'Medina', 'fgasparm@ipn.mx'),
('Mariana', 'Gómez', 'Tress', 'mgomezt@ipn.mx'),
('Gisela', 'González', 'Albarrán', 'ggonzaleza@ipn.mx'),
('Alejandro', 'González', 'Cisneros', 'agonzalezc@ipn.mx'),
('Gustavo', 'González', 'García', 'ggonzalezg@ipn.mx'),
('Marko Alfonso', 'González', 'Ramírez', 'mgonzalezr@ipn.mx'),
('Miguel Ángel', 'González', 'Trujillo', 'mgonzalezt@ipn.mx'),
('Eduardo', 'Gutiérrez', 'Aldana', 'egutierreza@ipn.mx'),
('Juan Jesús', 'Gutiérrez', 'García', 'jgutierrezg@ipn.mx'),
('Darwin', 'Gutiérrez', 'Mejía', 'dgutierrezm@ipn.mx'),
('Florencio', 'Guzmán', 'Aguilar', 'fguzmana@ipn.mx'),
('Jessie Paulina', 'Guzmán', 'Flores', 'jguzmanf@ipn.mx'),
('Leticia', 'Henestrosa', 'Carrasco', 'lhenestrosac@ipn.mx'),
('José Luis', 'Hernández', 'Aguilar', 'jhernandeza@ipn.mx'),
('Macario', 'Hernández', 'Cruz', 'mhernandezc@ipn.mx'),
('Rosa Alba', 'Hernández', 'García', 'rhernandezg@ipn.mx'),
('Josefína', 'Hernández', 'Jaime', 'jhernandezj@ipn.mx'),
('Luis Enrique', 'Hernández', 'Olvera', 'lhernandezo@ipn.mx'),
('Erika', 'Hernández', 'Rubio', 'ehernandezr@ipn.mx'),
('José Celestino Elías', 'Hernández', 'Secundino', 'jhernandezs@ipn.mx'),
('César', 'Hernández', 'Vásquez', 'chernandezv@ipn.mx'),
('Crispin', 'Herrera', 'Yañez', 'cherreray@ipn.mx'),
('José Alfredo', 'Jiménez', 'Benítez', 'jjimenezb@ipn.mx'),
('Edith Adriana', 'Jiménez', 'Contreras', 'ejimenezc@ipn.mx'),
('Yasmín Ivette', 'Jiménez', 'Galán', 'yjimenezg@ipn.mx'),
('René Baltazar', 'Jiménez', 'Ruíz', 'rjimenezr@ipn.mx'),
('Martha Patricia', 'Jiménez', 'Villanueva', 'mjimenezv@ipn.mx'),
('Joel Omar', 'Juárez', 'Gambino', 'jjuarezg@ipn.mx'),
('Carlos', 'Juárez', 'León', 'cjuarezl@ipn.mx'),
('Genaro', 'Juárez', 'Martínez', 'gjuarezm@ipn.mx'),
('Ana Belem', 'Juarez', 'Mendez', 'ajuarezm@ipn.mx'),
('Jazmín Adriana', 'Juárez', 'Ramírez', 'jjuarezr@ipn.mx'),
('Roberto', 'Jurado', 'Jiménez', 'rjuradoj@ipn.mx'),
('Laura', 'Lazcano', 'Xoxotla', 'llazcanox@ipn.mx'),
('Christian René', 'Leal', 'Pacheco', 'clealp@ipn.mx'),
('Miguel Abel', 'León', 'Hernández', 'mleonh@ipn.mx'),
('Sergio', 'Levario', 'Medina', 'slevariom@ipn.mx'),
('Erick Eugenio', 'Linares', 'Vallejo', 'elinaresv@ipn.mx'),
('Ariel', 'López', 'Rojas', 'alopezr@ipn.mx'),
('Benjamín', 'López', 'Carrera', 'blopezc@ipn.mx'),
('Luis Octavio', 'López', 'Leyva', 'llopezl@ipn.mx'),
('Claudia Alejandra', 'López', 'Rodríguez', 'clopezr@ipn.mx'),
('Gabriela de Jesús', 'López', 'Ruíz', 'glopezru@ipn.mx'),
('José Manuel', 'López', 'Sánchez', 'jlopezs@ipn.mx'),
('Araceli', 'Loyola', 'Espinosa', 'aloyolae@ipn.mx'),
('Benjamín', 'Luna', 'Benoso', 'blunab@ipn.mx'),
('Francisco Javier', 'Macías', 'Pérez', 'fmaciasp@ipn.mx'),
('Idalia', 'Maldonado', 'Castillo', 'imaldonadoc@ipn.mx'),
('Miguel Ángel', 'Maldonado', 'Muñoz', 'mmaldonadom@ipn.mx'),
('Héctor Manuel', 'Manzanilla', 'Granados', 'hmanzanillag@ipn.mx'),
('Guillermo', 'Márquez', 'Arreguín', 'gmarqueza@ipn.mx'),
('Lilian', 'Martínez', 'Acosta', 'lmartineza@ipn.mx'),
('Juan Carlos', 'Martínez', 'Díaz', 'jmartinezd@ipn.mx'),
('César Román', 'Martínez', 'García', 'cmartinezg@ipn.mx'),
('José Alfredo', 'Martínez', 'Guerrero', 'jmartinezgu@ipn.mx'),
('Jesús Alfredo', 'Martínez', 'Nuño', 'jmartinezn@ipn.mx'),
('José Cruz', 'Martínez', 'Perales', 'jmartinezp@ipn.mx'),
('Ricardo', 'Martínez', 'Rosales', 'rmartinezr@ipn.mx'),
('Patricia', 'Mata', 'Gil', 'pmatag@ipn.mx'),
('Virginia', 'Medina', 'Mejía', 'vmedinam@ipn.mx'),
('Reyna Elia', 'Melara', 'Abarca', 'rmelaraa@ipn.mx'),
('Laura', 'Méndez', 'Segundo', 'lmendezs@ipn.mx'),
('Elba', 'Mendoza', 'Macías', 'emendozam@ipn.mx'),
('Zelin', 'Miguel', 'Pilar', 'zmiguelp@ipn.mx'),
('Adbel Anahí', 'Montes', 'Meza', 'amontesm@ipn.mx'),
('Ángel Salvador', 'Montiel', 'Sánchez', 'amontiels@ipn.mx'),
('Juan Carlos', 'Morales', 'Cruz', 'jmoralesc@ipn.mx'),
('Ángel', 'Morales', 'González', 'amoralesg@ipn.mx'),
('Sandra Luz', 'Morales', 'Güitrón', 'smoralesgui@ipn.mx'),
('Úrsula Samantha', 'Morales', 'Rodríguez', 'umoralesr@ipn.mx'),
('Marco Antonio', 'Moreno', 'Armendáriz', 'mmorenoa@ipn.mx'),
('Axel Ernesto', 'Moreno', 'Cervantes', 'amorenoc@ipn.mx'),
('Elizabeth', 'Moreno', 'Galván', 'emorenog@ipn.mx'),
('Yosafat', 'Moscoso', 'Malagón', 'ymoscoso@ipn.mx'),
('Iván Giovanny', 'Mosso', 'García', 'imossog@ipn.mx'),
('César', 'Mújica', 'Ascencio', 'cmujicaa@ipn.mx'),
('Laura', 'Muñoz', 'Salazar', 'lmunozs@ipn.mx'),
('Joel', 'Nava', 'Lara', 'jnaval@ipn.mx'),
('Fabiola', 'Ocampo', 'Botello', 'focampob@ipn.mx'),
('Nancy', 'Ocotitla', 'Rojas', 'nocotitlar@ipn.mx'),
('Didier', 'Ojeda', 'Guillén', 'dojedag@ipn.mx'),
('Rubén', 'Ortega', 'González', 'rortegag@ipn.mx'),
('Andrés', 'Ortigoza', 'Campos', 'aortigozac@ipn.mx'),
('José Antonio', 'Ortíz', 'Ramírez', 'jortizr@ipn.mx'),
('Jesús', 'Ortuño', 'Araujo', 'jortunoa@ipn.mx'),
('Yanira', 'Pachuca', 'Herrera', 'ypachucah@ipn.mx'),
('Rocío', 'Palacios', 'Solano', 'rpalacioss@ipn.mx'),
('Rosaura', 'Palma', 'Orozco', 'rpalmao@ipn.mx'),
('Myriam Noemí', 'Paredes', 'Cadena', 'mparedesc@ipn.mx'),
('Carlos Jesús', 'Pastrana', 'Fernández', 'cpastranaf@ipn.mx'),
('Rubén', 'Peredo', 'Valderrama', 'rperedov@ipn.mx'),
('Tanibet', 'Pérez de los Santos', 'Mondragón', 'tperezdelosm@ipn.mx'),
('José Juan', 'Pérez', 'Pérez', 'jperezp@ipn.mx'),
('Sandra Mercedes', 'Pérez', 'Vera', 'sperezv@ipn.mx'),
('Miriam', 'Pescador', 'Rojas', 'mpescadorr@ipn.mx'),
('Carlos', 'Pineda', 'Guerrero', 'cpinedag@ipn.mx'),
('Jaime Hugo', 'Puebla', 'Lomas', 'jpueblal@ipn.mx'),
('Elia Tzindejhé', 'Ramírez', 'Martínez', 'eramirezm@ipn.mx'),
('Tonáhtiu Arturo', 'Ramírez', 'Romero', 'tramirezr@ipn.mx'),
('Rafael', 'Ramírez', 'Tenorio', 'rramirezt@ipn.mx'),
('Josué', 'Rangel', 'González', 'jrangelg@ipn.mx'),
('Rocío', 'Reséndiz', 'Muñoz', 'rresendizm@ipn.mx'),
('Tlatoani de Jesús', 'Reyes', 'Bermejo', 'treyesb@ipn.mx'),
('Ignacio', 'Ríos de la Torre', NULL, 'iriosdelat@ipn.mx'),
('Mónica', 'Rivera', 'De la Rosa', 'mriverad@ipn.mx'),
('María del Rosario', 'Rocha', 'Bernabé', 'mrochab@ipn.mx'),
('Miguel Ángel', 'Rodríguez', 'Castillo', 'mrodriguezc@ipn.mx'),
('Eduardo', 'Rodríguez', 'Flores', 'erodriguezf@ipn.mx'),
('Gabriel de Jesús', 'Rodríguez', 'Jordán', 'grodriguezj@ipn.mx'),
('Marisol', 'Rodríguez', 'Ordaz', 'mrodriguezo@ipn.mx'),
('Tania', 'Rodríguez', 'Sarabia', 'trodriguezs@ipn.mx'),
('José Gregorio', 'Rodríguez', 'Villarreal', 'jrodriguezv@ipn.mx'),
('Ismael', 'Rojas', 'Mexicano', 'irojasm@ipn.mx'),
('Rodolfo', 'Romero', 'Herrera', 'rromeroh@ipn.mx'),
('Jorge Luís', 'Rosas', 'Trigueros', 'jrosast@ipn.mx'),
('José Marco Antonio', 'Rueda', 'Meléndez', 'jruedam@ipn.mx'),
('Elena Fabiola', 'Ruíz', 'Ledesma', 'eruizl@ipn.mx'),
('Israel', 'Salas', 'Ramirez', 'isalasr@ipn.mx'),
('Manuel', 'Salazar', 'Ramírez', 'msalazarr@ipn.mx'),
('Encarnación', 'Salinas', 'Hernández', 'esalinash@ipn.mx'),
('Sergio', 'Salinas', 'Lugo', 'ssalinasl@ipn.mx'),
('Gilberto', 'Sánchez', 'Quintanilla', 'gsanchezq@ipn.mx'),
('Alfonso', 'Sánchez', 'Aguilar', 'asanchezag@ipn.mx'),
('José Emilio', 'Sánchez', 'Arroyo', 'jsancheza@ipn.mx'),
('Miguel', 'Sánchez', 'Brito', 'msanchezb@ipn.mx'),
('Virginia', 'Sánchez', 'Cruz', 'vsanchezc@ipn.mx'),
('Luz María', 'Sánchez', 'García', 'lsanchezg@ipn.mx'),
('Octavio', 'Sánchez', 'García', 'osanchezg@ipn.mx'),
('José', 'Sánchez', 'Juárez', 'jsanchezj@ipn.mx'),
('Israel', 'Sánchez', 'Mendoza', 'isanchezm@ipn.mx'),
('Adriana de la Paz', 'Sánchez', 'Moreno', 'asanchezmo@ipn.mx'),
('María Susana', 'Sánchez', 'Palacios', 'msanchezp@ipn.mx'),
('Perla Rebeca', 'Sánchez', 'Vargas', 'psanchezv@ipn.mx'),
('Raúl', 'Santillán', 'Luna', 'rsantillanl@ipn.mx'),
('Rafael Norman', 'Saucedo', 'Delgado', 'rsaucedod@ipn.mx'),
('José Felix', 'Serrano', 'Talamantes', 'jserranot@ipn.mx'),
('Victor Manuel', 'Silva', 'García', 'vsilvag@ipn.mx'),
('Jorge Javier', 'Silva', 'Martínez', 'jsilvam@ipn.mx'),
('Misael', 'Solorza', 'Guzmán', 'msolorzag@ipn.mx'),
('Fanny', 'Sosa', 'Adán', 'fsosaa@ipn.mx'),
('Manuel Alejandro', 'Soto', 'Ramos', 'msotor@ipn.mx'),
('Miguel Santiago', 'Suárez', 'Castañón', 'msuarezc@ipn.mx'),
('Roberto', 'Tecla', 'Parra', 'rteclap@ipn.mx'),
('Juan Carlos', 'Téllez', 'Barrera', 'jtellezb@ipn.mx'),
('Ma. Socorro', 'Téllez', 'Reyes', 'mtellezr@ipn.mx'),
('Marco Antonio', 'Tenorio', 'Marrón', 'mtenoriom@ipn.mx'),
('Alexis', 'Testa', 'Nava', 'atestan@ipn.mx'),
('Judith Margarita', 'Tirado', 'Lule', 'jtiradol@ipn.mx'),
('Enrique', 'Torres', 'González', 'etorresg@ipn.mx'),
('Roberto', 'Vázquez', 'Arreguín', 'rvazqueza@ipn.mx'),
('Leonor', 'Vázquez', 'González', 'lvazquezg@ipn.mx'),
('Mijaíl', 'Vázquez', 'Ortiz', 'mvazquezo@ipn.mx'),
('Nayeli', 'Vega', 'García', 'nvegag@ipn.mx'),
('Ulises', 'Vélez', 'Saldaña', 'uvelezs@ipn.mx'),
('Gumersindo', 'Vera', 'Hernández', 'gverah@ipn.mx'),
('Sonia', 'Villegas', 'Navarrete', 'svillegasn@ipn.mx'),
('Karina', 'Viveros', 'Vela', 'kviverosv@ipn.mx'),
('Ana María', 'Winfield', 'Reyes', 'awinfieldr@ipn.mx'),
('Roberto Eswart', 'Zagal', 'Flores', 'rzagalf@ipn.mx'),
('Alejandro', 'Zárate', 'Cárdenas', 'azaratec@ipn.mx');

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
INSERT INTO esc07_ets (fk_id_materia, fk_id_docente, fk_id_aula, fk_id_turno, fh_aplicacion)
SELECT
    (SELECT id_materia FROM cat02_materia WHERE tx_nombre='Cálculo'),
    (SELECT id_docente FROM esc05_docente WHERE tx_apellido_paterno='Chávez' AND tx_apellido_materno='Lima'),
    (SELECT id_aula FROM esc06_aula WHERE tx_clave='3101'),
    (SELECT id_turno FROM cat05_turno WHERE tx_nombre='Matutino'),
    '2026-06-02 08:00:00';

-- Álgebra Lineal - Leticia Cañedo Suárez
INSERT INTO esc07_ets (fk_id_materia, fk_id_docente, fk_id_aula, fk_id_turno, fh_aplicacion)
SELECT
    (SELECT id_materia FROM cat02_materia WHERE tx_nombre='Álgebra Lineal'),
    (SELECT id_docente FROM esc05_docente WHERE tx_apellido_paterno='Cañedo' AND tx_apellido_materno='Suárez'),
    (SELECT id_aula FROM esc06_aula WHERE tx_clave='3102'),
    (SELECT id_turno FROM cat05_turno WHERE tx_nombre='Matutino'),
    '2026-06-03 10:00:00';

-- Matemáticas Discretas - Israel Buitrón Damaso
INSERT INTO esc07_ets (fk_id_materia, fk_id_docente, fk_id_aula, fk_id_turno, fh_aplicacion)
SELECT
    (SELECT id_materia FROM cat02_materia WHERE tx_nombre='Matemáticas Discretas'),
    (SELECT id_docente FROM esc05_docente WHERE tx_apellido_paterno='Buitrón' AND tx_apellido_materno='Damaso'),
    (SELECT id_aula FROM esc06_aula WHERE tx_clave='3201'),
    (SELECT id_turno FROM cat05_turno WHERE tx_nombre='Matutino'),
    '2026-06-04 12:00:00';

-- Fundamentos de Programación - Cecilia Albortante Morato
INSERT INTO esc07_ets (fk_id_materia, fk_id_docente, fk_id_aula, fk_id_turno, fh_aplicacion)
SELECT
    (SELECT id_materia FROM cat02_materia WHERE tx_nombre='Fundamentos de Programación'),
    (SELECT id_docente FROM esc05_docente WHERE tx_apellido_paterno='Albortante' AND tx_apellido_materno='Morato'),
    (SELECT id_aula FROM esc06_aula WHERE tx_clave='LAB-1'),
    (SELECT id_turno FROM cat05_turno WHERE tx_nombre='Matutino'),
    '2026-06-05 08:00:00';

-- Algoritmos y Estructuras de Datos - Edgardo Adrián Franco Martínez
INSERT INTO esc07_ets (fk_id_materia, fk_id_docente, fk_id_aula, fk_id_turno, fh_aplicacion)
SELECT
    (SELECT id_materia FROM cat02_materia WHERE tx_nombre='Algoritmos y Estructuras de Datos'),
    (SELECT id_docente FROM esc05_docente WHERE tx_apellido_paterno='Franco' AND tx_apellido_materno='Martínez'),
    (SELECT id_aula FROM esc06_aula WHERE tx_clave='LAB-2'),
    (SELECT id_turno FROM cat05_turno WHERE tx_nombre='Matutino'),
    '2026-06-06 10:00:00';

-- Bases de Datos - Alejandro Botello Castillo
INSERT INTO esc07_ets (fk_id_materia, fk_id_docente, fk_id_aula, fk_id_turno, fh_aplicacion)
SELECT
    (SELECT id_materia FROM cat02_materia WHERE tx_nombre='Bases de Datos'),
    (SELECT id_docente FROM esc05_docente WHERE tx_apellido_paterno='Botello' AND tx_apellido_materno='Castillo'),
    (SELECT id_aula FROM esc06_aula WHERE tx_clave='LAB-3'),
    (SELECT id_turno FROM cat05_turno WHERE tx_nombre='Matutino'),
    '2026-06-09 12:00:00';

-- Paradigmas de Programación - Rafael Aguilar García
INSERT INTO esc07_ets (fk_id_materia, fk_id_docente, fk_id_aula, fk_id_turno, fh_aplicacion)
SELECT
    (SELECT id_materia FROM cat02_materia WHERE tx_nombre='Paradigmas de Programación'),
    (SELECT id_docente FROM esc05_docente WHERE tx_apellido_paterno='Aguilar' AND tx_apellido_materno='García'),
    (SELECT id_aula FROM esc06_aula WHERE tx_clave='3202'),
    (SELECT id_turno FROM cat05_turno WHERE tx_nombre='Vespertino'),
    '2026-06-10 14:00:00';

-- Análisis y Diseño de Algoritmos - Cristhian Alejandro Ávila Sánchez
INSERT INTO esc07_ets (fk_id_materia, fk_id_docente, fk_id_aula, fk_id_turno, fh_aplicacion)
SELECT
    (SELECT id_materia FROM cat02_materia WHERE tx_nombre='Análisis y Diseño de Algoritmos'),
    (SELECT id_docente FROM esc05_docente WHERE tx_apellido_paterno='Ávila' AND tx_apellido_materno='Sánchez'),
    (SELECT id_aula FROM esc06_aula WHERE tx_clave='3301'),
    (SELECT id_turno FROM cat05_turno WHERE tx_nombre='Matutino'),
    '2026-06-11 08:00:00';

-- Ecuaciones Diferenciales - Juan Manuel Carballo Jiménez
INSERT INTO esc07_ets (fk_id_materia, fk_id_docente, fk_id_aula, fk_id_turno, fh_aplicacion)
SELECT
    (SELECT id_materia FROM cat02_materia WHERE tx_nombre='Ecuaciones Diferenciales'),
    (SELECT id_docente FROM esc05_docente WHERE tx_apellido_paterno='Carballo' AND tx_apellido_materno='Jiménez'),
    (SELECT id_aula FROM esc06_aula WHERE tx_clave='3302'),
    (SELECT id_turno FROM cat05_turno WHERE tx_nombre='Matutino'),
    '2026-06-12 10:00:00';

-- Probabilidad y Estadística - Jorge Alberto Cruz Rojas
INSERT INTO esc07_ets (fk_id_materia, fk_id_docente, fk_id_aula, fk_id_turno, fh_aplicacion)
SELECT
    (SELECT id_materia FROM cat02_materia WHERE tx_nombre='Probabilidad y Estadística'),
    (SELECT id_docente FROM esc05_docente WHERE tx_apellido_paterno='Cruz' AND tx_apellido_materno='Rojas'),
    (SELECT id_aula FROM esc06_aula WHERE tx_clave='4101'),
    (SELECT id_turno FROM cat05_turno WHERE tx_nombre='Matutino'),
    '2026-06-13 12:00:00';

-- Sistemas Operativos - David Araujo Díaz
INSERT INTO esc07_ets (fk_id_materia, fk_id_docente, fk_id_aula, fk_id_turno, fh_aplicacion)
SELECT
    (SELECT id_materia FROM cat02_materia WHERE tx_nombre='Sistemas Operativos'),
    (SELECT id_docente FROM esc05_docente WHERE tx_apellido_paterno='Araujo' AND tx_apellido_materno='Díaz'),
    (SELECT id_aula FROM esc06_aula WHERE tx_clave='LAB-4'),
    (SELECT id_turno FROM cat05_turno WHERE tx_nombre='Matutino'),
    '2026-06-16 08:00:00';

-- Redes de Computadoras - Juan Jesús Alcaraz Torres
INSERT INTO esc07_ets (fk_id_materia, fk_id_docente, fk_id_aula, fk_id_turno, fh_aplicacion)
SELECT
    (SELECT id_materia FROM cat02_materia WHERE tx_nombre='Redes de Computadoras'),
    (SELECT id_docente FROM esc05_docente WHERE tx_apellido_paterno='Alcaraz' AND tx_apellido_materno='Torres'),
    (SELECT id_aula FROM esc06_aula WHERE tx_clave='LAB-1'),
    (SELECT id_turno FROM cat05_turno WHERE tx_nombre='Matutino'),
    '2026-06-17 10:00:00';

-- Compiladores - Alberto Jesús Alcántara Méndez
INSERT INTO esc07_ets (fk_id_materia, fk_id_docente, fk_id_aula, fk_id_turno, fh_aplicacion)
SELECT
    (SELECT id_materia FROM cat02_materia WHERE tx_nombre='Compiladores'),
    (SELECT id_docente FROM esc05_docente WHERE tx_apellido_paterno='Alcántara' AND tx_apellido_materno='Méndez'),
    (SELECT id_aula FROM esc06_aula WHERE tx_clave='4102'),
    (SELECT id_turno FROM cat05_turno WHERE tx_nombre='Matutino'),
    '2026-06-18 12:00:00';

-- Ingeniería de Software - Martha Rosa Cordero López
INSERT INTO esc07_ets (fk_id_materia, fk_id_docente, fk_id_aula, fk_id_turno, fh_aplicacion)
SELECT
    (SELECT id_materia FROM cat02_materia WHERE tx_nombre='Ingeniería de Software'),
    (SELECT id_docente FROM esc05_docente WHERE tx_apellido_paterno='Cordero' AND tx_apellido_materno='López'),
    (SELECT id_aula FROM esc06_aula WHERE tx_clave='4201'),
    (SELECT id_turno FROM cat05_turno WHERE tx_nombre='Vespertino'),
    '2026-06-19 14:00:00';

-- Inteligencia Artificial - Daniel Aguilar Velázquez
INSERT INTO esc07_ets (fk_id_materia, fk_id_docente, fk_id_aula, fk_id_turno, fh_aplicacion)
SELECT
    (SELECT id_materia FROM cat02_materia WHERE tx_nombre='Inteligencia Artificial'),
    (SELECT id_docente FROM esc05_docente WHERE tx_apellido_paterno='Aguilar' AND tx_apellido_materno='Velázquez'),
    (SELECT id_aula FROM esc06_aula WHERE tx_clave='LAB-2'),
    (SELECT id_turno FROM cat05_turno WHERE tx_nombre='Matutino'),
    '2026-06-20 08:00:00';

-- Finanzas Empresariales - Verónica Agustín Domínguez
INSERT INTO esc07_ets (fk_id_materia, fk_id_docente, fk_id_aula, fk_id_turno, fh_aplicacion)
SELECT
    (SELECT id_materia FROM cat02_materia WHERE tx_nombre='Finanzas Empresariales'),
    (SELECT id_docente FROM esc05_docente WHERE tx_apellido_paterno='Agustín' AND tx_apellido_materno='Domínguez'),
    (SELECT id_aula FROM esc06_aula WHERE tx_clave='3101'),
    (SELECT id_turno FROM cat05_turno WHERE tx_nombre='Matutino'),
    '2026-06-23 10:00:00';

-- Comunicación Oral y Escrita - Maribel Aragón García
INSERT INTO esc07_ets (fk_id_materia, fk_id_docente, fk_id_aula, fk_id_turno, fh_aplicacion)
SELECT
    (SELECT id_materia FROM cat02_materia WHERE tx_nombre='Comunicación Oral y Escrita'),
    (SELECT id_docente FROM esc05_docente WHERE tx_apellido_paterno='Aragón' AND tx_apellido_materno='García'),
    (SELECT id_aula FROM esc06_aula WHERE tx_clave='3102'),
    (SELECT id_turno FROM cat05_turno WHERE tx_nombre='Matutino'),
    '2026-06-24 12:00:00';

-- Teoría de la Computación - Luis Enrique Hernández Olvera
INSERT INTO esc07_ets (fk_id_materia, fk_id_docente, fk_id_aula, fk_id_turno, fh_aplicacion)
SELECT
    (SELECT id_materia FROM cat02_materia WHERE tx_nombre='Teoría de la Computación'),
    (SELECT id_docente FROM esc05_docente WHERE tx_apellido_paterno='Hernández' AND tx_apellido_materno='Olvera'),
    (SELECT id_aula FROM esc06_aula WHERE tx_clave='3201'),
    (SELECT id_turno FROM cat05_turno WHERE tx_nombre='Vespertino'),
    '2026-06-25 14:00:00';

-- Bases de Datos (segundo ETS con docente distinto) - Erika Hernández Rubio
INSERT INTO esc07_ets (fk_id_materia, fk_id_docente, fk_id_aula, fk_id_turno, fh_aplicacion)
SELECT
    (SELECT id_materia FROM cat02_materia WHERE tx_nombre='Bases de Datos'),
    (SELECT id_docente FROM esc05_docente WHERE tx_apellido_paterno='Hernández' AND tx_apellido_materno='Rubio'),
    (SELECT id_aula FROM esc06_aula WHERE tx_clave='LAB-3'),
    (SELECT id_turno FROM cat05_turno WHERE tx_nombre='Matutino'),
    '2026-06-26 08:00:00';

-- =========================================
-- ETS ADICIONALES - MATEMÁTICAS Y BÁSICAS
-- =========================================

-- Cálculo Aplicado - Claudia Celia Díaz Huerta
INSERT INTO esc07_ets (fk_id_materia, fk_id_docente, fk_id_aula, fk_id_turno, fh_aplicacion)
SELECT
    (SELECT id_materia FROM cat02_materia WHERE tx_nombre='Cálculo Aplicado'),
    (SELECT id_docente FROM esc05_docente WHERE tx_apellido_paterno='Díaz' AND tx_apellido_materno='Huerta'),
    (SELECT id_aula FROM esc06_aula WHERE tx_clave='3101'),
    (SELECT id_turno FROM cat05_turno WHERE tx_nombre='Matutino'),
    '2026-06-02 10:00:00';

-- Análisis Vectorial - Benjamín López Carrera
INSERT INTO esc07_ets (fk_id_materia, fk_id_docente, fk_id_aula, fk_id_turno, fh_aplicacion)
SELECT
    (SELECT id_materia FROM cat02_materia WHERE tx_nombre='Análisis Vectorial'),
    (SELECT id_docente FROM esc05_docente WHERE tx_apellido_paterno='López' AND tx_apellido_materno='Carrera'),
    (SELECT id_aula FROM esc06_aula WHERE tx_clave='3102'),
    (SELECT id_turno FROM cat05_turno WHERE tx_nombre='Vespertino'),
    '2026-06-03 14:00:00';

-- Cálculo Multivariable - Christian René Leal Pacheco
INSERT INTO esc07_ets (fk_id_materia, fk_id_docente, fk_id_aula, fk_id_turno, fh_aplicacion)
SELECT
    (SELECT id_materia FROM cat02_materia WHERE tx_nombre='Cálculo Multivariable'),
    (SELECT id_docente FROM esc05_docente WHERE tx_apellido_paterno='Leal' AND tx_apellido_materno='Pacheco'),
    (SELECT id_aula FROM esc06_aula WHERE tx_clave='3201'),
    (SELECT id_turno FROM cat05_turno WHERE tx_nombre='Matutino'),
    '2026-06-04 08:00:00';

-- Mecánica y Electromagnetismo - Florencio Guzmán Aguilar
INSERT INTO esc07_ets (fk_id_materia, fk_id_docente, fk_id_aula, fk_id_turno, fh_aplicacion)
SELECT
    (SELECT id_materia FROM cat02_materia WHERE tx_nombre='Mecánica y Electromagnetismo'),
    (SELECT id_docente FROM esc05_docente WHERE tx_apellido_paterno='Guzmán' AND tx_apellido_materno='Aguilar'),
    (SELECT id_aula FROM esc06_aula WHERE tx_clave='3202'),
    (SELECT id_turno FROM cat05_turno WHERE tx_nombre='Vespertino'),
    '2026-06-05 14:00:00';

-- Matemáticas Avanzadas para la Ingeniería - Ignacio Ríos de la Torre
INSERT INTO esc07_ets (fk_id_materia, fk_id_docente, fk_id_aula, fk_id_turno, fh_aplicacion)
SELECT
    (SELECT id_materia FROM cat02_materia WHERE tx_nombre='Matemáticas Avanzadas para la Ingeniería'),
    (SELECT id_docente FROM esc05_docente WHERE tx_apellido_paterno='Ríos de la Torre'),
    (SELECT id_aula FROM esc06_aula WHERE tx_clave='3301'),
    (SELECT id_turno FROM cat05_turno WHERE tx_nombre='Matutino'),
    '2026-06-08 10:00:00';

-- Probabilidad - Leonor Vázquez González
INSERT INTO esc07_ets (fk_id_materia, fk_id_docente, fk_id_aula, fk_id_turno, fh_aplicacion)
SELECT
    (SELECT id_materia FROM cat02_materia WHERE tx_nombre='Probabilidad'),
    (SELECT id_docente FROM esc05_docente WHERE tx_apellido_paterno='Vázquez' AND tx_apellido_materno='González'),
    (SELECT id_aula FROM esc06_aula WHERE tx_clave='3302'),
    (SELECT id_turno FROM cat05_turno WHERE tx_nombre='Vespertino'),
    '2026-06-09 14:00:00';

-- Estadística - Jorge Alberto Cruz Rojas
INSERT INTO esc07_ets (fk_id_materia, fk_id_docente, fk_id_aula, fk_id_turno, fh_aplicacion)
SELECT
    (SELECT id_materia FROM cat02_materia WHERE tx_nombre='Estadística'),
    (SELECT id_docente FROM esc05_docente WHERE tx_apellido_paterno='Cruz' AND tx_apellido_materno='Rojas'),
    (SELECT id_aula FROM esc06_aula WHERE tx_clave='4101'),
    (SELECT id_turno FROM cat05_turno WHERE tx_nombre='Matutino'),
    '2026-06-10 10:00:00';

-- Métodos Numéricos - Alfonso Sánchez Aguilar
INSERT INTO esc07_ets (fk_id_materia, fk_id_docente, fk_id_aula, fk_id_turno, fh_aplicacion)
SELECT
    (SELECT id_materia FROM cat02_materia WHERE tx_nombre='Métodos Numéricos'),
    (SELECT id_docente FROM esc05_docente WHERE tx_apellido_paterno='Sánchez' AND tx_apellido_materno='Aguilar'),
    (SELECT id_aula FROM esc06_aula WHERE tx_clave='4102'),
    (SELECT id_turno FROM cat05_turno WHERE tx_nombre='Vespertino'),
    '2026-06-11 14:00:00';

-- Procesos Estocásticos - Alfonso Sánchez Aguilar
INSERT INTO esc07_ets (fk_id_materia, fk_id_docente, fk_id_aula, fk_id_turno, fh_aplicacion)
SELECT
    (SELECT id_materia FROM cat02_materia WHERE tx_nombre='Procesos Estocásticos'),
    (SELECT id_docente FROM esc05_docente WHERE tx_apellido_paterno='Sánchez' AND tx_apellido_materno='Aguilar'),
    (SELECT id_aula FROM esc06_aula WHERE tx_clave='4201'),
    (SELECT id_turno FROM cat05_turno WHERE tx_nombre='Matutino'),
    '2026-06-15 08:00:00';

-- =========================================
-- ETS ADICIONALES - HARDWARE Y SEÑALES
-- =========================================

-- Fundamentos de Diseño Digital - Rubén Galicia Mejía
INSERT INTO esc07_ets (fk_id_materia, fk_id_docente, fk_id_aula, fk_id_turno, fh_aplicacion)
SELECT
    (SELECT id_materia FROM cat02_materia WHERE tx_nombre='Fundamentos de Diseño Digital'),
    (SELECT id_docente FROM esc05_docente WHERE tx_apellido_paterno='Galicia' AND tx_apellido_materno='Mejía'),
    (SELECT id_aula FROM esc06_aula WHERE tx_clave='LAB-1'),
    (SELECT id_turno FROM cat05_turno WHERE tx_nombre='Vespertino'),
    '2026-06-02 14:00:00';

-- Diseño de Sistemas Digitales - Erick Eugenio Linares Vallejo
INSERT INTO esc07_ets (fk_id_materia, fk_id_docente, fk_id_aula, fk_id_turno, fh_aplicacion)
SELECT
    (SELECT id_materia FROM cat02_materia WHERE tx_nombre='Diseño de Sistemas Digitales'),
    (SELECT id_docente FROM esc05_docente WHERE tx_apellido_paterno='Linares' AND tx_apellido_materno='Vallejo'),
    (SELECT id_aula FROM esc06_aula WHERE tx_clave='LAB-2'),
    (SELECT id_turno FROM cat05_turno WHERE tx_nombre='Matutino'),
    '2026-06-03 08:00:00';

-- Arquitectura de Computadoras - Victor Hugo García Ortega
INSERT INTO esc07_ets (fk_id_materia, fk_id_docente, fk_id_aula, fk_id_turno, fh_aplicacion)
SELECT
    (SELECT id_materia FROM cat02_materia WHERE tx_nombre='Arquitectura de Computadoras'),
    (SELECT id_docente FROM esc05_docente WHERE tx_apellido_paterno='García' AND tx_apellido_materno='Ortega'),
    (SELECT id_aula FROM esc06_aula WHERE tx_clave='LAB-3'),
    (SELECT id_turno FROM cat05_turno WHERE tx_nombre='Matutino'),
    '2026-06-04 10:00:00';

-- Circuitos Eléctricos - Rocío Almazán Farfán
INSERT INTO esc07_ets (fk_id_materia, fk_id_docente, fk_id_aula, fk_id_turno, fh_aplicacion)
SELECT
    (SELECT id_materia FROM cat02_materia WHERE tx_nombre='Circuitos Eléctricos'),
    (SELECT id_docente FROM esc05_docente WHERE tx_apellido_paterno='Almazán' AND tx_apellido_materno='Farfán'),
    (SELECT id_aula FROM esc06_aula WHERE tx_clave='3101'),
    (SELECT id_turno FROM cat05_turno WHERE tx_nombre='Matutino'),
    '2026-06-05 10:00:00';

-- Electrónica Analógica - Sergio Cancino Calderón
INSERT INTO esc07_ets (fk_id_materia, fk_id_docente, fk_id_aula, fk_id_turno, fh_aplicacion)
SELECT
    (SELECT id_materia FROM cat02_materia WHERE tx_nombre='Electrónica Analógica'),
    (SELECT id_docente FROM esc05_docente WHERE tx_apellido_paterno='Cancino' AND tx_apellido_materno='Calderón'),
    (SELECT id_aula FROM esc06_aula WHERE tx_clave='3102'),
    (SELECT id_turno FROM cat05_turno WHERE tx_nombre='Matutino'),
    '2026-06-08 12:00:00';

-- Procesamiento Digital de Señales - Gelacio Castillo Cabrera
INSERT INTO esc07_ets (fk_id_materia, fk_id_docente, fk_id_aula, fk_id_turno, fh_aplicacion)
SELECT
    (SELECT id_materia FROM cat02_materia WHERE tx_nombre='Procesamiento Digital de Señales'),
    (SELECT id_docente FROM esc05_docente WHERE tx_apellido_paterno='Castillo' AND tx_apellido_materno='Cabrera'),
    (SELECT id_aula FROM esc06_aula WHERE tx_clave='LAB-4'),
    (SELECT id_turno FROM cat05_turno WHERE tx_nombre='Matutino'),
    '2026-06-09 08:00:00';

-- Instrumentación y Control - José Luis Hernández Aguilar
INSERT INTO esc07_ets (fk_id_materia, fk_id_docente, fk_id_aula, fk_id_turno, fh_aplicacion)
SELECT
    (SELECT id_materia FROM cat02_materia WHERE tx_nombre='Instrumentación y Control'),
    (SELECT id_docente FROM esc05_docente WHERE tx_apellido_paterno='Hernández' AND tx_apellido_materno='Aguilar'),
    (SELECT id_aula FROM esc06_aula WHERE tx_clave='3201'),
    (SELECT id_turno FROM cat05_turno WHERE tx_nombre='Matutino'),
    '2026-06-10 12:00:00';

-- =========================================
-- ETS ADICIONALES - IA / CIENCIA DE DATOS
-- =========================================

-- Fundamentos de Inteligencia Artificial - Cristal Karina Galindo Durán
INSERT INTO esc07_ets (fk_id_materia, fk_id_docente, fk_id_aula, fk_id_turno, fh_aplicacion)
SELECT
    (SELECT id_materia FROM cat02_materia WHERE tx_nombre='Fundamentos de Inteligencia Artificial'),
    (SELECT id_docente FROM esc05_docente WHERE tx_apellido_paterno='Galindo' AND tx_apellido_materno='Durán'),
    (SELECT id_aula FROM esc06_aula WHERE tx_clave='LAB-1'),
    (SELECT id_turno FROM cat05_turno WHERE tx_nombre='Matutino'),
    '2026-06-11 10:00:00';

-- Aprendizaje de Máquina - Consuelo Varinia García Mendoza
INSERT INTO esc07_ets (fk_id_materia, fk_id_docente, fk_id_aula, fk_id_turno, fh_aplicacion)
SELECT
    (SELECT id_materia FROM cat02_materia WHERE tx_nombre='Aprendizaje de Máquina'),
    (SELECT id_docente FROM esc05_docente WHERE tx_apellido_paterno='García' AND tx_apellido_materno='Mendoza'),
    (SELECT id_aula FROM esc06_aula WHERE tx_clave='LAB-2'),
    (SELECT id_turno FROM cat05_turno WHERE tx_nombre='Matutino'),
    '2026-06-12 12:00:00';

-- Visión Artificial - Octavio Sánchez García
INSERT INTO esc07_ets (fk_id_materia, fk_id_docente, fk_id_aula, fk_id_turno, fh_aplicacion)
SELECT
    (SELECT id_materia FROM cat02_materia WHERE tx_nombre='Visión Artificial'),
    (SELECT id_docente FROM esc05_docente WHERE tx_apellido_paterno='Sánchez' AND tx_apellido_materno='García' AND tx_nombre='Octavio'),
    (SELECT id_aula FROM esc06_aula WHERE tx_clave='LAB-3'),
    (SELECT id_turno FROM cat05_turno WHERE tx_nombre='Matutino'),
    '2026-06-15 10:00:00';

-- Algoritmos Bioinspirados - Jorge Luís Rosas Trigueros
INSERT INTO esc07_ets (fk_id_materia, fk_id_docente, fk_id_aula, fk_id_turno, fh_aplicacion)
SELECT
    (SELECT id_materia FROM cat02_materia WHERE tx_nombre='Algoritmos Bioinspirados'),
    (SELECT id_docente FROM esc05_docente WHERE tx_apellido_paterno='Rosas' AND tx_apellido_materno='Trigueros'),
    (SELECT id_aula FROM esc06_aula WHERE tx_clave='3202'),
    (SELECT id_turno FROM cat05_turno WHERE tx_nombre='Matutino'),
    '2026-06-16 12:00:00';

-- Tecnologías de Lenguaje Natural - Joel Omar Juárez Gambino
INSERT INTO esc07_ets (fk_id_materia, fk_id_docente, fk_id_aula, fk_id_turno, fh_aplicacion)
SELECT
    (SELECT id_materia FROM cat02_materia WHERE tx_nombre='Tecnologías de Lenguaje Natural'),
    (SELECT id_docente FROM esc05_docente WHERE tx_apellido_paterno='Juárez' AND tx_apellido_materno='Gambino'),
    (SELECT id_aula FROM esc06_aula WHERE tx_clave='LAB-4'),
    (SELECT id_turno FROM cat05_turno WHERE tx_nombre='Vespertino'),
    '2026-06-17 14:00:00';

-- Cómputo Paralelo - Sandra Luz Morales Güitrón
INSERT INTO esc07_ets (fk_id_materia, fk_id_docente, fk_id_aula, fk_id_turno, fh_aplicacion)
SELECT
    (SELECT id_materia FROM cat02_materia WHERE tx_nombre='Cómputo Paralelo'),
    (SELECT id_docente FROM esc05_docente WHERE tx_apellido_paterno='Morales' AND tx_apellido_materno='Güitrón'),
    (SELECT id_aula FROM esc06_aula WHERE tx_clave='LAB-1'),
    (SELECT id_turno FROM cat05_turno WHERE tx_nombre='Matutino'),
    '2026-06-18 08:00:00';

-- Introducción a la Ciencia de Datos - Fabiola Ocampo Botello
INSERT INTO esc07_ets (fk_id_materia, fk_id_docente, fk_id_aula, fk_id_turno, fh_aplicacion)
SELECT
    (SELECT id_materia FROM cat02_materia WHERE tx_nombre='Introducción a la Ciencia de Datos'),
    (SELECT id_docente FROM esc05_docente WHERE tx_apellido_paterno='Ocampo' AND tx_apellido_materno='Botello'),
    (SELECT id_aula FROM esc06_aula WHERE tx_clave='3301'),
    (SELECT id_turno FROM cat05_turno WHERE tx_nombre='Matutino'),
    '2026-06-19 10:00:00';

-- Programación para Ciencia de Datos - Daniel Aguilar Velázquez
INSERT INTO esc07_ets (fk_id_materia, fk_id_docente, fk_id_aula, fk_id_turno, fh_aplicacion)
SELECT
    (SELECT id_materia FROM cat02_materia WHERE tx_nombre='Programación para Ciencia de Datos'),
    (SELECT id_docente FROM esc05_docente WHERE tx_apellido_paterno='Aguilar' AND tx_apellido_materno='Velázquez'),
    (SELECT id_aula FROM esc06_aula WHERE tx_clave='LAB-2'),
    (SELECT id_turno FROM cat05_turno WHERE tx_nombre='Matutino'),
    '2026-06-22 08:00:00';

-- Minería de Datos - Roberto Eswart Zagal Flores
INSERT INTO esc07_ets (fk_id_materia, fk_id_docente, fk_id_aula, fk_id_turno, fh_aplicacion)
SELECT
    (SELECT id_materia FROM cat02_materia WHERE tx_nombre='Minería de Datos'),
    (SELECT id_docente FROM esc05_docente WHERE tx_apellido_paterno='Zagal' AND tx_apellido_materno='Flores'),
    (SELECT id_aula FROM esc06_aula WHERE tx_clave='LAB-3'),
    (SELECT id_turno FROM cat05_turno WHERE tx_nombre='Matutino'),
    '2026-06-23 12:00:00';

-- Análisis de Series de Tiempo - Uriel Corona Bermúdez
INSERT INTO esc07_ets (fk_id_materia, fk_id_docente, fk_id_aula, fk_id_turno, fh_aplicacion)
SELECT
    (SELECT id_materia FROM cat02_materia WHERE tx_nombre='Análisis de Series de Tiempo'),
    (SELECT id_docente FROM esc05_docente WHERE tx_apellido_paterno='Corona' AND tx_apellido_materno='Bermúdez'),
    (SELECT id_aula FROM esc06_aula WHERE tx_clave='3302'),
    (SELECT id_turno FROM cat05_turno WHERE tx_nombre='Matutino'),
    '2026-06-24 10:00:00';

-- Modelado Predictivo - Uriel Corona Bermúdez
INSERT INTO esc07_ets (fk_id_materia, fk_id_docente, fk_id_aula, fk_id_turno, fh_aplicacion)
SELECT
    (SELECT id_materia FROM cat02_materia WHERE tx_nombre='Modelado Predictivo'),
    (SELECT id_docente FROM esc05_docente WHERE tx_apellido_paterno='Corona' AND tx_apellido_materno='Bermúdez'),
    (SELECT id_aula FROM esc06_aula WHERE tx_clave='4101'),
    (SELECT id_turno FROM cat05_turno WHERE tx_nombre='Matutino'),
    '2026-06-25 12:00:00';

-- =========================================
-- ETS ADICIONALES - SISTEMAS Y REDES
-- =========================================

-- Análisis y Diseño de Sistemas - Marco Antonio Dorantes González
INSERT INTO esc07_ets (fk_id_materia, fk_id_docente, fk_id_aula, fk_id_turno, fh_aplicacion)
SELECT
    (SELECT id_materia FROM cat02_materia WHERE tx_nombre='Análisis y Diseño de Sistemas'),
    (SELECT id_docente FROM esc05_docente WHERE tx_apellido_paterno='Dorantes' AND tx_apellido_materno='González'),
    (SELECT id_aula FROM esc06_aula WHERE tx_clave='4102'),
    (SELECT id_turno FROM cat05_turno WHERE tx_nombre='Matutino'),
    '2026-06-02 12:00:00';

-- Tecnologías para el Desarrollo de Aplicaciones Web - José Asunción Enríquez Zárate
INSERT INTO esc07_ets (fk_id_materia, fk_id_docente, fk_id_aula, fk_id_turno, fh_aplicacion)
SELECT
    (SELECT id_materia FROM cat02_materia WHERE tx_nombre='Tecnologías para el Desarrollo de Aplicaciones Web'),
    (SELECT id_docente FROM esc05_docente WHERE tx_apellido_paterno='Enríquez' AND tx_apellido_materno='Zárate'),
    (SELECT id_aula FROM esc06_aula WHERE tx_clave='LAB-1'),
    (SELECT id_turno FROM cat05_turno WHERE tx_nombre='Matutino'),
    '2026-06-03 12:00:00';

-- Sistemas Distribuidos - Ukranio Coronilla Contreras
INSERT INTO esc07_ets (fk_id_materia, fk_id_docente, fk_id_aula, fk_id_turno, fh_aplicacion)
SELECT
    (SELECT id_materia FROM cat02_materia WHERE tx_nombre='Sistemas Distribuidos'),
    (SELECT id_docente FROM esc05_docente WHERE tx_apellido_paterno='Coronilla' AND tx_apellido_materno='Contreras'),
    (SELECT id_aula FROM esc06_aula WHERE tx_clave='LAB-4'),
    (SELECT id_turno FROM cat05_turno WHERE tx_nombre='Matutino'),
    '2026-06-04 12:00:00';

-- Aplicaciones para Comunicaciones en Red - Sandra Ivette Bautista Rosales
INSERT INTO esc07_ets (fk_id_materia, fk_id_docente, fk_id_aula, fk_id_turno, fh_aplicacion)
SELECT
    (SELECT id_materia FROM cat02_materia WHERE tx_nombre='Aplicaciones para Comunicaciones en Red'),
    (SELECT id_docente FROM esc05_docente WHERE tx_apellido_paterno='Bautista' AND tx_apellido_materno='Rosales'),
    (SELECT id_aula FROM esc06_aula WHERE tx_clave='LAB-2'),
    (SELECT id_turno FROM cat05_turno WHERE tx_nombre='Matutino'),
    '2026-06-05 12:00:00';

-- Administración de Servicios en Red - Leticia Henestrosa Carrasco
INSERT INTO esc07_ets (fk_id_materia, fk_id_docente, fk_id_aula, fk_id_turno, fh_aplicacion)
SELECT
    (SELECT id_materia FROM cat02_materia WHERE tx_nombre='Administración de Servicios en Red'),
    (SELECT id_docente FROM esc05_docente WHERE tx_apellido_paterno='Henestrosa' AND tx_apellido_materno='Carrasco'),
    (SELECT id_aula FROM esc06_aula WHERE tx_clave='LAB-3'),
    (SELECT id_turno FROM cat05_turno WHERE tx_nombre='Vespertino'),
    '2026-06-08 14:00:00';

-- =========================================
-- ETS ADICIONALES - ÁREA SOCIAL / ECONÓMICA
-- =========================================

-- Fundamentos Económicos - Gloria Lourdes Cabrera Chávez
INSERT INTO esc07_ets (fk_id_materia, fk_id_docente, fk_id_aula, fk_id_turno, fh_aplicacion)
SELECT
    (SELECT id_materia FROM cat02_materia WHERE tx_nombre='Fundamentos Económicos'),
    (SELECT id_docente FROM esc05_docente WHERE tx_apellido_paterno='Cabrera' AND tx_apellido_materno='Chávez'),
    (SELECT id_aula FROM esc06_aula WHERE tx_clave='3101'),
    (SELECT id_turno FROM cat05_turno WHERE tx_nombre='Matutino'),
    '2026-06-09 12:00:00';

-- Gestión Empresarial - Odette Berenice Cancino Mosqueda
INSERT INTO esc07_ets (fk_id_materia, fk_id_docente, fk_id_aula, fk_id_turno, fh_aplicacion)
SELECT
    (SELECT id_materia FROM cat02_materia WHERE tx_nombre='Gestión Empresarial'),
    (SELECT id_docente FROM esc05_docente WHERE tx_apellido_paterno='Cancino' AND tx_apellido_materno='Mosqueda'),
    (SELECT id_aula FROM esc06_aula WHERE tx_clave='3102'),
    (SELECT id_turno FROM cat05_turno WHERE tx_nombre='Vespertino'),
    '2026-06-10 14:00:00';

-- Ingeniería, Ética y Sociedad - Mariana Gómez Tress
INSERT INTO esc07_ets (fk_id_materia, fk_id_docente, fk_id_aula, fk_id_turno, fh_aplicacion)
SELECT
    (SELECT id_materia FROM cat02_materia WHERE tx_nombre='Ingeniería, Ética y Sociedad'),
    (SELECT id_docente FROM esc05_docente WHERE tx_apellido_paterno='Gómez' AND tx_apellido_materno='Tress'),
    (SELECT id_aula FROM esc06_aula WHERE tx_clave='3201'),
    (SELECT id_turno FROM cat05_turno WHERE tx_nombre='Matutino'),
    '2026-06-11 12:00:00';

-- Ética y Legalidad - Lilian Martínez Acosta
INSERT INTO esc07_ets (fk_id_materia, fk_id_docente, fk_id_aula, fk_id_turno, fh_aplicacion)
SELECT
    (SELECT id_materia FROM cat02_materia WHERE tx_nombre='Ética y Legalidad'),
    (SELECT id_docente FROM esc05_docente WHERE tx_apellido_paterno='Martínez' AND tx_apellido_materno='Acosta'),
    (SELECT id_aula FROM esc06_aula WHERE tx_clave='3202'),
    (SELECT id_turno FROM cat05_turno WHERE tx_nombre='Vespertino'),
    '2026-06-12 14:00:00';

-- Liderazgo Personal - Jorge Ferrer Tenorio
INSERT INTO esc07_ets (fk_id_materia, fk_id_docente, fk_id_aula, fk_id_turno, fh_aplicacion)
SELECT
    (SELECT id_materia FROM cat02_materia WHERE tx_nombre='Liderazgo Personal'),
    (SELECT id_docente FROM esc05_docente WHERE tx_apellido_paterno='Ferrer' AND tx_apellido_materno='Tenorio'),
    (SELECT id_aula FROM esc06_aula WHERE tx_clave='3301'),
    (SELECT id_turno FROM cat05_turno WHERE tx_nombre='Matutino'),
    '2026-06-15 12:00:00';

-- Metodología de la Investigación y Divulgación Científica - Adriana Berenice Celis Domínguez
INSERT INTO esc07_ets (fk_id_materia, fk_id_docente, fk_id_aula, fk_id_turno, fh_aplicacion)
SELECT
    (SELECT id_materia FROM cat02_materia WHERE tx_nombre='Metodología de la Investigación y Divulgación Científica'),
    (SELECT id_docente FROM esc05_docente WHERE tx_apellido_paterno='Celis' AND tx_apellido_materno='Domínguez'),
    (SELECT id_aula FROM esc06_aula WHERE tx_clave='3302'),
    (SELECT id_turno FROM cat05_turno WHERE tx_nombre='Vespertino'),
    '2026-06-16 14:00:00';

-- Formulación y Evaluación de Proyectos Informáticos - Rocío Palacios Solano
INSERT INTO esc07_ets (fk_id_materia, fk_id_docente, fk_id_aula, fk_id_turno, fh_aplicacion)
SELECT
    (SELECT id_materia FROM cat02_materia WHERE tx_nombre='Formulación y Evaluación de Proyectos Informáticos'),
    (SELECT id_docente FROM esc05_docente WHERE tx_apellido_paterno='Palacios' AND tx_apellido_materno='Solano'),
    (SELECT id_aula FROM esc06_aula WHERE tx_clave='4201'),
    (SELECT id_turno FROM cat05_turno WHERE tx_nombre='Matutino'),
    '2026-06-17 10:00:00';

-- Métodos Cuantitativos para la Toma de Decisiones - Guillermo Márquez Arreguín
INSERT INTO esc07_ets (fk_id_materia, fk_id_docente, fk_id_aula, fk_id_turno, fh_aplicacion)
SELECT
    (SELECT id_materia FROM cat02_materia WHERE tx_nombre='Métodos Cuantitativos para la Toma de Decisiones'),
    (SELECT id_docente FROM esc05_docente WHERE tx_apellido_paterno='Márquez' AND tx_apellido_materno='Arreguín'),
    (SELECT id_aula FROM esc06_aula WHERE tx_clave='4202'),
    (SELECT id_turno FROM cat05_turno WHERE tx_nombre='Matutino'),
    '2026-06-18 10:00:00';

-- =========================================
-- ETS ADICIONALES - OPTATIVAS (algunas)
-- =========================================

-- Computer Security - Alejandro Sigfrido Cifuentes Álvarez
INSERT INTO esc07_ets (fk_id_materia, fk_id_docente, fk_id_aula, fk_id_turno, fh_aplicacion)
SELECT
    (SELECT id_materia FROM cat02_materia WHERE tx_nombre='Computer Security'),
    (SELECT id_docente FROM esc05_docente WHERE tx_apellido_paterno='Cifuentes' AND tx_apellido_materno='Álvarez'),
    (SELECT id_aula FROM esc06_aula WHERE tx_clave='LAB-1'),
    (SELECT id_turno FROM cat05_turno WHERE tx_nombre='Vespertino'),
    '2026-06-19 14:00:00';

-- Introduction to Cryptography - Nidia Asunción Cortez Duarte
INSERT INTO esc07_ets (fk_id_materia, fk_id_docente, fk_id_aula, fk_id_turno, fh_aplicacion)
SELECT
    (SELECT id_materia FROM cat02_materia WHERE tx_nombre='Introduction to Cryptography'),
    (SELECT id_docente FROM esc05_docente WHERE tx_apellido_paterno='Cortez' AND tx_apellido_materno='Duarte'),
    (SELECT id_aula FROM esc06_aula WHERE tx_clave='LAB-2'),
    (SELECT id_turno FROM cat05_turno WHERE tx_nombre='Matutino'),
    '2026-06-22 10:00:00';

-- Machine Learning - Joel Omar Juárez Gambino
INSERT INTO esc07_ets (fk_id_materia, fk_id_docente, fk_id_aula, fk_id_turno, fh_aplicacion)
SELECT
    (SELECT id_materia FROM cat02_materia WHERE tx_nombre='Machine Learning'),
    (SELECT id_docente FROM esc05_docente WHERE tx_apellido_paterno='Juárez' AND tx_apellido_materno='Gambino'),
    (SELECT id_aula FROM esc06_aula WHERE tx_clave='LAB-3'),
    (SELECT id_turno FROM cat05_turno WHERE tx_nombre='Vespertino'),
    '2026-06-23 14:00:00';

-- Genetic Algorithms - María Elena Cruz Meza
INSERT INTO esc07_ets (fk_id_materia, fk_id_docente, fk_id_aula, fk_id_turno, fh_aplicacion)
SELECT
    (SELECT id_materia FROM cat02_materia WHERE tx_nombre='Genetic Algorithms'),
    (SELECT id_docente FROM esc05_docente WHERE tx_apellido_paterno='Cruz' AND tx_apellido_materno='Meza'),
    (SELECT id_aula FROM esc06_aula WHERE tx_clave='LAB-4'),
    (SELECT id_turno FROM cat05_turno WHERE tx_nombre='Vespertino'),
    '2026-06-24 14:00:00';

-- Image Analysis - María Elena Cruz Meza
INSERT INTO esc07_ets (fk_id_materia, fk_id_docente, fk_id_aula, fk_id_turno, fh_aplicacion)
SELECT
    (SELECT id_materia FROM cat02_materia WHERE tx_nombre='Image Analysis'),
    (SELECT id_docente FROM esc05_docente WHERE tx_apellido_paterno='Cruz' AND tx_apellido_materno='Meza'),
    (SELECT id_aula FROM esc06_aula WHERE tx_clave='3101'),
    (SELECT id_turno FROM cat05_turno WHERE tx_nombre='Matutino'),
    '2026-06-25 10:00:00';

-- Computer Graphics - Rafael Norman Saucedo Delgado
INSERT INTO esc07_ets (fk_id_materia, fk_id_docente, fk_id_aula, fk_id_turno, fh_aplicacion)
SELECT
    (SELECT id_materia FROM cat02_materia WHERE tx_nombre='Computer Graphics'),
    (SELECT id_docente FROM esc05_docente WHERE tx_apellido_paterno='Saucedo' AND tx_apellido_materno='Delgado'),
    (SELECT id_aula FROM esc06_aula WHERE tx_clave='3102'),
    (SELECT id_turno FROM cat05_turno WHERE tx_nombre='Matutino'),
    '2026-06-26 10:00:00';

-- Data Mining - Fabiola Ocampo Botello
INSERT INTO esc07_ets (fk_id_materia, fk_id_docente, fk_id_aula, fk_id_turno, fh_aplicacion)
SELECT
    (SELECT id_materia FROM cat02_materia WHERE tx_nombre='Data Mining'),
    (SELECT id_docente FROM esc05_docente WHERE tx_apellido_paterno='Ocampo' AND tx_apellido_materno='Botello'),
    (SELECT id_aula FROM esc06_aula WHERE tx_clave='3201'),
    (SELECT id_turno FROM cat05_turno WHERE tx_nombre='Matutino'),
    '2026-06-29 08:00:00';

-- High Technology Enterprise Management - Ariel López Rojas
INSERT INTO esc07_ets (fk_id_materia, fk_id_docente, fk_id_aula, fk_id_turno, fh_aplicacion)
SELECT
    (SELECT id_materia FROM cat02_materia WHERE tx_nombre='High Technology Enterprise Management'),
    (SELECT id_docente FROM esc05_docente WHERE tx_apellido_paterno='López' AND tx_apellido_materno='Rojas'),
    (SELECT id_aula FROM esc06_aula WHERE tx_clave='3202'),
    (SELECT id_turno FROM cat05_turno WHERE tx_nombre='Matutino'),
    '2026-06-30 10:00:00';

-- IT Governance - Jessie Paulina Guzmán Flores
INSERT INTO esc07_ets (fk_id_materia, fk_id_docente, fk_id_aula, fk_id_turno, fh_aplicacion)
SELECT
    (SELECT id_materia FROM cat02_materia WHERE tx_nombre='IT Governance'),
    (SELECT id_docente FROM esc05_docente WHERE tx_apellido_paterno='Guzmán' AND tx_apellido_materno='Flores'),
    (SELECT id_aula FROM esc06_aula WHERE tx_clave='3301'),
    (SELECT id_turno FROM cat05_turno WHERE tx_nombre='Matutino'),
    '2026-07-01 08:00:00';

-- Economic Engineering - Ángel Morales González
INSERT INTO esc07_ets (fk_id_materia, fk_id_docente, fk_id_aula, fk_id_turno, fh_aplicacion)
SELECT
    (SELECT id_materia FROM cat02_materia WHERE tx_nombre='Economic Engineering'),
    (SELECT id_docente FROM esc05_docente WHERE tx_apellido_paterno='Morales' AND tx_apellido_materno='González'),
    (SELECT id_aula FROM esc06_aula WHERE tx_clave='3302'),
    (SELECT id_turno FROM cat05_turno WHERE tx_nombre='Matutino'),
    '2026-07-02 10:00:00';

-- =========================================
-- ETS ADICIONALES - SEGUNDA VUELTA (AGOSTO) 
-- Mismas materias, segunda oportunidad
-- =========================================

-- Cálculo (2da vuelta) - Nestor Colin Hernández
INSERT INTO esc07_ets (fk_id_materia, fk_id_docente, fk_id_aula, fk_id_turno, fh_aplicacion)
SELECT
    (SELECT id_materia FROM cat02_materia WHERE tx_nombre='Cálculo'),
    (SELECT id_docente FROM esc05_docente WHERE tx_apellido_paterno='Colin' AND tx_apellido_materno='Hernández'),
    (SELECT id_aula FROM esc06_aula WHERE tx_clave='3101'),
    (SELECT id_turno FROM cat05_turno WHERE tx_nombre='Matutino'),
    '2026-08-04 08:00:00';

-- Fundamentos de Programación (2da vuelta) - Yaxkin Flores Mendoza
INSERT INTO esc07_ets (fk_id_materia, fk_id_docente, fk_id_aula, fk_id_turno, fh_aplicacion)
SELECT
    (SELECT id_materia FROM cat02_materia WHERE tx_nombre='Fundamentos de Programación'),
    (SELECT id_docente FROM esc05_docente WHERE tx_apellido_paterno='Flores' AND tx_apellido_materno='Mendoza'),
    (SELECT id_aula FROM esc06_aula WHERE tx_clave='LAB-1'),
    (SELECT id_turno FROM cat05_turno WHERE tx_nombre='Matutino'),
    '2026-08-05 10:00:00';

-- Algoritmos y Estructuras de Datos (2da vuelta) - Daniel Cruz García
INSERT INTO esc07_ets (fk_id_materia, fk_id_docente, fk_id_aula, fk_id_turno, fh_aplicacion)
SELECT
    (SELECT id_materia FROM cat02_materia WHERE tx_nombre='Algoritmos y Estructuras de Datos'),
    (SELECT id_docente FROM esc05_docente WHERE tx_apellido_paterno='Cruz' AND tx_apellido_materno='García'),
    (SELECT id_aula FROM esc06_aula WHERE tx_clave='LAB-2'),
    (SELECT id_turno FROM cat05_turno WHERE tx_nombre='Matutino'),
    '2026-08-06 12:00:00';

-- Bases de Datos (2da vuelta) - Lorena Chavarría Báez
INSERT INTO esc07_ets (fk_id_materia, fk_id_docente, fk_id_aula, fk_id_turno, fh_aplicacion)
SELECT
    (SELECT id_materia FROM cat02_materia WHERE tx_nombre='Bases de Datos'),
    (SELECT id_docente FROM esc05_docente WHERE tx_apellido_paterno='Chavarría' AND tx_apellido_materno='Báez'),
    (SELECT id_aula FROM esc06_aula WHERE tx_clave='LAB-3'),
    (SELECT id_turno FROM cat05_turno WHERE tx_nombre='Vespertino'),
    '2026-08-07 14:00:00';

-- Paradigmas de Programación (2da vuelta) - Saúl De la O Torres
INSERT INTO esc07_ets (fk_id_materia, fk_id_docente, fk_id_aula, fk_id_turno, fh_aplicacion)
SELECT
    (SELECT id_materia FROM cat02_materia WHERE tx_nombre='Paradigmas de Programación'),
    (SELECT id_docente FROM esc05_docente WHERE tx_apellido_paterno='De la O' AND tx_apellido_materno='Torres'),
    (SELECT id_aula FROM esc06_aula WHERE tx_clave='3201'),
    (SELECT id_turno FROM cat05_turno WHERE tx_nombre='Matutino'),
    '2026-08-10 08:00:00';

-- Análisis y Diseño de Algoritmos (2da vuelta) - Ricardo Felipe Díaz Santiago
INSERT INTO esc07_ets (fk_id_materia, fk_id_docente, fk_id_aula, fk_id_turno, fh_aplicacion)
SELECT
    (SELECT id_materia FROM cat02_materia WHERE tx_nombre='Análisis y Diseño de Algoritmos'),
    (SELECT id_docente FROM esc05_docente WHERE tx_apellido_paterno='Díaz' AND tx_apellido_materno='Santiago' AND tx_nombre='Ricardo Felipe'),
    (SELECT id_aula FROM esc06_aula WHERE tx_clave='3202'),
    (SELECT id_turno FROM cat05_turno WHERE tx_nombre='Matutino'),
    '2026-08-11 10:00:00';

-- Sistemas Operativos (2da vuelta) - Jorge Cortés Galicia
INSERT INTO esc07_ets (fk_id_materia, fk_id_docente, fk_id_aula, fk_id_turno, fh_aplicacion)
SELECT
    (SELECT id_materia FROM cat02_materia WHERE tx_nombre='Sistemas Operativos'),
    (SELECT id_docente FROM esc05_docente WHERE tx_apellido_paterno='Cortés' AND tx_apellido_materno='Galicia'),
    (SELECT id_aula FROM esc06_aula WHERE tx_clave='LAB-4'),
    (SELECT id_turno FROM cat05_turno WHERE tx_nombre='Matutino'),
    '2026-08-12 12:00:00';

-- Compiladores (2da vuelta) - Miriam Pescador Rojas
INSERT INTO esc07_ets (fk_id_materia, fk_id_docente, fk_id_aula, fk_id_turno, fh_aplicacion)
SELECT
    (SELECT id_materia FROM cat02_materia WHERE tx_nombre='Compiladores'),
    (SELECT id_docente FROM esc05_docente WHERE tx_apellido_paterno='Pescador' AND tx_apellido_materno='Rojas'),
    (SELECT id_aula FROM esc06_aula WHERE tx_clave='3301'),
    (SELECT id_turno FROM cat05_turno WHERE tx_nombre='Vespertino'),
    '2026-08-13 14:00:00';

-- Ingeniería de Software (2da vuelta) - Reyna Elia Melara Abarca
INSERT INTO esc07_ets (fk_id_materia, fk_id_docente, fk_id_aula, fk_id_turno, fh_aplicacion)
SELECT
    (SELECT id_materia FROM cat02_materia WHERE tx_nombre='Ingeniería de Software'),
    (SELECT id_docente FROM esc05_docente WHERE tx_apellido_paterno='Melara' AND tx_apellido_materno='Abarca'),
    (SELECT id_aula FROM esc06_aula WHERE tx_clave='3302'),
    (SELECT id_turno FROM cat05_turno WHERE tx_nombre='Matutino'),
    '2026-08-14 08:00:00';

-- Redes de Computadoras (2da vuelta) - Gilberto Sánchez Quintanilla
INSERT INTO esc07_ets (fk_id_materia, fk_id_docente, fk_id_aula, fk_id_turno, fh_aplicacion)
SELECT
    (SELECT id_materia FROM cat02_materia WHERE tx_nombre='Redes de Computadoras'),
    (SELECT id_docente FROM esc05_docente WHERE tx_apellido_paterno='Sánchez' AND tx_apellido_materno='Quintanilla'),
    (SELECT id_aula FROM esc06_aula WHERE tx_clave='LAB-1'),
    (SELECT id_turno FROM cat05_turno WHERE tx_nombre='Matutino'),
    '2026-08-17 10:00:00';
