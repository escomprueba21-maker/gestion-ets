INSERT INTO cat03_rol (tx_nombre) VALUES
('Alumno'),
('Administrador');

INSERT INTO cat04_tipo_materia (tx_nombre) VALUES
('Obligatoria'),
('Optativa');

INSERT INTO cat05_turno (tx_nombre) VALUES
('Matutino'),
('Vespertino');

INSERT INTO cat01_carrera (tx_clave, tx_nombre) VALUES
('ISC', 'Ingeniería en Sistemas Computacionales'),
('IIA', 'Ingeniería en Inteligencia Artificial'),
('LCD', 'Licenciatura en Ciencia de Datos');

INSERT INTO cat02_materia (tx_nombre) VALUES
('Cálculo'),
('Matemáticas Discretas'),
('Comunicación Oral y Escrita'),
('Fundamentos de Programación'),
('Álgebra Lineal'),
('Algoritmos y Estructuras de Datos'),
('Fundamentos Económicos'),
('Bases de Datos'),
('Análisis y Diseño de Algoritmos'),
('Probabilidad y Estadística'),
('Finanzas Empresariales'),
('Gestión Empresarial'),
('Trabajo Terminal I'),
('Trabajo Terminal II'),
('Estancia Profesional'),
('Desarrollo de Habilidades Sociales para la Alta Dirección'),
('Liderazgo Personal'),
-- Compartidas ISC / IIA (y algunas con LCD)
('Cálculo Aplicado'),
('Cálculo Multivariable'),
('Análisis Vectorial'),
('Mecánica y Electromagnetismo'),
('Ecuaciones Diferenciales'),
('Fundamentos de Diseño Digital'),
('Ingeniería, Ética y Sociedad'),
('Ética y Legalidad'),
('Paradigmas de Programación'),
('Diseño de Sistemas Digitales'),
('Matemáticas Avanzadas para la Ingeniería'),
('Tecnologías para el Desarrollo de Aplicaciones Web'),
('Análisis y Diseño de Sistemas'),
('Teoría de la Computación'),
('Formulación y Evaluación de Proyectos Informáticos'),
('Metodología de la Investigación y Divulgación Científica'),
-- Exclusivas ISC
('Circuitos Eléctricos'),
('Electrónica Analógica'),
('Procesamiento Digital de Señales'),
('Instrumentación y Control'),
('Arquitectura de Computadoras'),
('Sistemas Operativos'),
('Redes de Computadoras'),
('Compiladores'),
('Métodos Cuantitativos para la Toma de Decisiones'),
('Ingeniería de Software'),
('Sistemas en Chip'),
('Inteligencia Artificial'),
('Aplicaciones para Comunicaciones en Red'),
('Desarrollo de Aplicaciones Móviles Nativas'),
('Sistemas Distribuidos'),
('Administración de Servicios en Red'),
-- Exclusivas IIA
('Fundamentos de Inteligencia Artificial'),
('Procesamiento Digital de Imágenes'),
('Aprendizaje de Máquina'),
('Visión Artificial'),
('Procesamiento de Señales'),
('Algoritmos Bioinspirados'),
('Tecnologías de Lenguaje Natural'),
('Cómputo Paralelo'),
('Redes Neuronales y Aprendizaje Profundo'),
('Ingeniería de Software para Sistemas Inteligentes'),
('Reconocimiento de Voz'),
-- Exclusivas LCD
('Introducción a la Ciencia de Datos'),
('Programación para Ciencia de Datos'),
('Probabilidad'),
('Métodos Numéricos'),
('Cómputo de Alto Desempeño'),
('Estadística'),
('Base de Datos Avanzadas'),
('Desarrollo de Aplicaciones Web'),
('Desarrollo de Aplicaciones para Análisis de Datos'),
('Minería de Datos'),
('Procesos Estocásticos'),
('Aprendizaje de Máquina e Inteligencia Artificial'),
('Analítica y Visualización de Datos'),
('Modelado Predictivo'),
('Procesamiento de Lenguaje Natural'),
('Análisis de Series de Tiempo'),
('Analítica Avanzada de Datos'),
('Big Data'),
('Modelos Econométricos'),
('Administración de Proyectos de TI'),
-- Optativas ISC
('Computer Graphics'),
('Genetic Algorithms'),
('Machine Learning'),
('Bioinformatics'),
('Natural Language Processing'),
('Virtual and Augmented Reality'),
('Computing Selected Topics I'),
('Data Mining'),
('Image Analysis'),
('Virtual Instrumentation'),
('Cellula Automata'),
('High Technology Enterprise Management'),
('Statistical Tools For Data Analytics'),
('Computer Security'),
('Introduction to Cryptography'),
('Software Quality Assurance and Design Patterns'),
('IT Governance'),
('Selected Topics of Cryptography'),
('Web Client and Backend Development Frameworks'),
('Complex Systems'),
('Computing Selected Topics II'),
('Economic Engineering'),
('Internet of Things'),
('Virtual Instrumentation Applications'),
('Embedded Systems'),
('Non Relational Databases'),
-- Optativas IIA
('Innovación y emprendimiento tecnológico'),
('Propiedad Intelectual'),
('Aplicaciones de lenguaje natural'),
('Sistemas multiagentes'),
('Aplicaciones de sistemas multiagentes'),
('Minería de datos'),
('Big data'),
('Temas selectos de inteligencia artificial'),
('Cómputo en la nube'),
('Técnicas de programación para robots móviles'),
('Interacción humano-máquina'),
('Programación de dispositivos móviles'),
('Aplicaciones de inteligencia artificial en sistemas embebidos'),
('Tópicos selectos de algoritmos bioinspirados'),
-- Optativas LCD (solo las no repetidas con IIA)
('Estadística avanzada'),
('Temas selectos de aprendizaje profundo'),
('Temas selectos de procesamiento de lenguaje natural'),
('Bioinformática básica'),
('Bioinformática avanzada'),
('Sistemas de información geográfica'),
('Ciberseguridad'),
('Protección de datos'),
('Innovación y emprendimientos tecnológicos'),
('Propiedad intelectual'),
('Simulación básica'),
('Simulación avanzada');

-- =========================================================
-- RELACIÓN CARRERA - MATERIA — ISC
-- =========================================================

-- ISC Sem 1 (obligatorias)
INSERT INTO esc01_carrera_materia (fk_id_carrera, fk_id_materia, fk_id_tipo, nu_semestre)
SELECT
    (SELECT id_carrera FROM cat01_carrera WHERE tx_clave='ISC'),
    id_materia,
    (SELECT id_tipo FROM cat04_tipo_materia WHERE tx_nombre='Obligatoria'),
    1
FROM cat02_materia WHERE tx_nombre IN (
    'Cálculo',
    'Análisis Vectorial',
    'Matemáticas Discretas',
    'Comunicación Oral y Escrita',
    'Fundamentos de Programación'
);

-- ISC Sem 2 (obligatorias)
INSERT INTO esc01_carrera_materia (fk_id_carrera, fk_id_materia, fk_id_tipo, nu_semestre)
SELECT
    (SELECT id_carrera FROM cat01_carrera WHERE tx_clave='ISC'),
    id_materia,
    (SELECT id_tipo FROM cat04_tipo_materia WHERE tx_nombre='Obligatoria'),
    2
FROM cat02_materia WHERE tx_nombre IN (
    'Álgebra Lineal',
    'Cálculo Aplicado',
    'Mecánica y Electromagnetismo',
    'Ingeniería, Ética y Sociedad',
    'Fundamentos Económicos',
    'Algoritmos y Estructuras de Datos'
);

-- ISC Sem 3 (obligatorias)
INSERT INTO esc01_carrera_materia (fk_id_carrera, fk_id_materia, fk_id_tipo, nu_semestre)
SELECT
    (SELECT id_carrera FROM cat01_carrera WHERE tx_clave='ISC'),
    id_materia,
    (SELECT id_tipo FROM cat04_tipo_materia WHERE tx_nombre='Obligatoria'),
    3
FROM cat02_materia WHERE tx_nombre IN (
    'Ecuaciones Diferenciales',
    'Circuitos Eléctricos',
    'Fundamentos de Diseño Digital',
    'Bases de Datos',
    'Finanzas Empresariales',
    'Paradigmas de Programación',
    'Análisis y Diseño de Algoritmos'
);

-- ISC Sem 4 (obligatorias)
INSERT INTO esc01_carrera_materia (fk_id_carrera, fk_id_materia, fk_id_tipo, nu_semestre)
SELECT
    (SELECT id_carrera FROM cat01_carrera WHERE tx_clave='ISC'),
    id_materia,
    (SELECT id_tipo FROM cat04_tipo_materia WHERE tx_nombre='Obligatoria'),
    4
FROM cat02_materia WHERE tx_nombre IN (
    'Probabilidad y Estadística',
    'Matemáticas Avanzadas para la Ingeniería',
    'Electrónica Analógica',
    'Diseño de Sistemas Digitales',
    'Tecnologías para el Desarrollo de Aplicaciones Web',
    'Sistemas Operativos',
    'Teoría de la Computación'
);

-- ISC Sem 5 (obligatorias)
INSERT INTO esc01_carrera_materia (fk_id_carrera, fk_id_materia, fk_id_tipo, nu_semestre)
SELECT
    (SELECT id_carrera FROM cat01_carrera WHERE tx_clave='ISC'),
    id_materia,
    (SELECT id_tipo FROM cat04_tipo_materia WHERE tx_nombre='Obligatoria'),
    5
FROM cat02_materia WHERE tx_nombre IN (
    'Procesamiento Digital de Señales',
    'Instrumentación y Control',
    'Arquitectura de Computadoras',
    'Análisis y Diseño de Sistemas',
    'Formulación y Evaluación de Proyectos Informáticos',
    'Compiladores',
    'Redes de Computadoras'
);

-- ISC Sem 6 (obligatorias)
INSERT INTO esc01_carrera_materia (fk_id_carrera, fk_id_materia, fk_id_tipo, nu_semestre)
SELECT
    (SELECT id_carrera FROM cat01_carrera WHERE tx_clave='ISC'),
    id_materia,
    (SELECT id_tipo FROM cat04_tipo_materia WHERE tx_nombre='Obligatoria'),
    6
FROM cat02_materia WHERE tx_nombre IN (
    'Sistemas en Chip',
    'Métodos Cuantitativos para la Toma de Decisiones',
    'Ingeniería de Software',
    'Inteligencia Artificial'
);

-- ISC Sem 6 (optativas A1/B1)
INSERT INTO esc01_carrera_materia (fk_id_carrera, fk_id_materia, fk_id_tipo, nu_semestre)
SELECT
    (SELECT id_carrera FROM cat01_carrera WHERE tx_clave='ISC'),
    id_materia,
    (SELECT id_tipo FROM cat04_tipo_materia WHERE tx_nombre='Optativa'),
    6
FROM cat02_materia WHERE tx_nombre IN (
    'Computer Graphics',
    'Genetic Algorithms',
    'Machine Learning',
    'Bioinformatics',
    'Natural Language Processing',
    'Virtual and Augmented Reality',
    'Big Data',
    'Computing Selected Topics I',
    'Data Mining',
    'Image Analysis',
    'Virtual Instrumentation',
    'Cellula Automata',
    'High Technology Enterprise Management',
    'Statistical Tools For Data Analytics',
    'Computer Security',
    'Introduction to Cryptography',
    'Software Quality Assurance and Design Patterns',
    'IT Governance'
);

-- ISC Sem 7 (obligatorias)
INSERT INTO esc01_carrera_materia (fk_id_carrera, fk_id_materia, fk_id_tipo, nu_semestre)
SELECT
    (SELECT id_carrera FROM cat01_carrera WHERE tx_clave='ISC'),
    id_materia,
    (SELECT id_tipo FROM cat04_tipo_materia WHERE tx_nombre='Obligatoria'),
    7
FROM cat02_materia WHERE tx_nombre IN (
    'Desarrollo de Aplicaciones Móviles Nativas',
    'Trabajo Terminal I',
    'Sistemas Distribuidos',
    'Administración de Servicios en Red',
    'Aplicaciones para Comunicaciones en Red'
);

-- ISC Sem 7 (optativas A2/B2)
INSERT INTO esc01_carrera_materia (fk_id_carrera, fk_id_materia, fk_id_tipo, nu_semestre)
SELECT
    (SELECT id_carrera FROM cat01_carrera WHERE tx_clave='ISC'),
    id_materia,
    (SELECT id_tipo FROM cat04_tipo_materia WHERE tx_nombre='Optativa'),
    7
FROM cat02_materia WHERE tx_nombre IN (
    'Selected Topics of Cryptography',
    'Web Client and Backend Development Frameworks',
    'Complex Systems',
    'Computing Selected Topics II',
    'Economic Engineering',
    'Internet of Things',
    'Virtual Instrumentation Applications',
    'Embedded Systems',
    'Non Relational Databases'
);

-- ISC Sem 8 (obligatorias)
INSERT INTO esc01_carrera_materia (fk_id_carrera, fk_id_materia, fk_id_tipo, nu_semestre)
SELECT
    (SELECT id_carrera FROM cat01_carrera WHERE tx_clave='ISC'),
    id_materia,
    (SELECT id_tipo FROM cat04_tipo_materia WHERE tx_nombre='Obligatoria'),
    8
FROM cat02_materia WHERE tx_nombre IN (
    'Estancia Profesional',
    'Desarrollo de Habilidades Sociales para la Alta Dirección',
    'Trabajo Terminal II',
    'Gestión Empresarial',
    'Liderazgo Personal'
);

-- =========================================================
-- RELACIÓN CARRERA - MATERIA — IIA
-- =========================================================

-- IIA Sem 1 (obligatorias)
INSERT INTO esc01_carrera_materia (fk_id_carrera, fk_id_materia, fk_id_tipo, nu_semestre)
SELECT
    (SELECT id_carrera FROM cat01_carrera WHERE tx_clave='IIA'),
    id_materia,
    (SELECT id_tipo FROM cat04_tipo_materia WHERE tx_nombre='Obligatoria'),
    1
FROM cat02_materia WHERE tx_nombre IN (
    'Fundamentos de Programación',
    'Matemáticas Discretas',
    'Cálculo',
    'Comunicación Oral y Escrita',
    'Mecánica y Electromagnetismo',
    'Fundamentos Económicos'
);

-- IIA Sem 2 (obligatorias)
INSERT INTO esc01_carrera_materia (fk_id_carrera, fk_id_materia, fk_id_tipo, nu_semestre)
SELECT
    (SELECT id_carrera FROM cat01_carrera WHERE tx_clave='IIA'),
    id_materia,
    (SELECT id_tipo FROM cat04_tipo_materia WHERE tx_nombre='Obligatoria'),
    2
FROM cat02_materia WHERE tx_nombre IN (
    'Algoritmos y Estructuras de Datos',
    'Fundamentos de Diseño Digital',
    'Cálculo Multivariable',
    'Ingeniería, Ética y Sociedad',
    'Álgebra Lineal',
    'Finanzas Empresariales'
);

-- IIA Sem 3 (obligatorias)
INSERT INTO esc01_carrera_materia (fk_id_carrera, fk_id_materia, fk_id_tipo, nu_semestre)
SELECT
    (SELECT id_carrera FROM cat01_carrera WHERE tx_clave='IIA'),
    id_materia,
    (SELECT id_tipo FROM cat04_tipo_materia WHERE tx_nombre='Obligatoria'),
    3
FROM cat02_materia WHERE tx_nombre IN (
    'Análisis y Diseño de Algoritmos',
    'Paradigmas de Programación',
    'Ecuaciones Diferenciales',
    'Bases de Datos',
    'Diseño de Sistemas Digitales',
    'Liderazgo Personal'
);

-- IIA Sem 4 (obligatorias)
INSERT INTO esc01_carrera_materia (fk_id_carrera, fk_id_materia, fk_id_tipo, nu_semestre)
SELECT
    (SELECT id_carrera FROM cat01_carrera WHERE tx_clave='IIA'),
    id_materia,
    (SELECT id_tipo FROM cat04_tipo_materia WHERE tx_nombre='Obligatoria'),
    4
FROM cat02_materia WHERE tx_nombre IN (
    'Fundamentos de Inteligencia Artificial',
    'Probabilidad y Estadística',
    'Matemáticas Avanzadas para la Ingeniería',
    'Tecnologías para el Desarrollo de Aplicaciones Web',
    'Análisis y Diseño de Sistemas',
    'Procesamiento Digital de Imágenes'
);

-- IIA Sem 5 (obligatorias)
INSERT INTO esc01_carrera_materia (fk_id_carrera, fk_id_materia, fk_id_tipo, nu_semestre)
SELECT
    (SELECT id_carrera FROM cat01_carrera WHERE tx_clave='IIA'),
    id_materia,
    (SELECT id_tipo FROM cat04_tipo_materia WHERE tx_nombre='Obligatoria'),
    5
FROM cat02_materia WHERE tx_nombre IN (
    'Aprendizaje de Máquina',
    'Visión Artificial',
    'Teoría de la Computación',
    'Procesamiento de Señales',
    'Algoritmos Bioinspirados',
    'Tecnologías de Lenguaje Natural'
);

-- IIA Sem 6 (obligatorias)
INSERT INTO esc01_carrera_materia (fk_id_carrera, fk_id_materia, fk_id_tipo, nu_semestre)
SELECT
    (SELECT id_carrera FROM cat01_carrera WHERE tx_clave='IIA'),
    id_materia,
    (SELECT id_tipo FROM cat04_tipo_materia WHERE tx_nombre='Obligatoria'),
    6
FROM cat02_materia WHERE tx_nombre IN (
    'Cómputo Paralelo',
    'Redes Neuronales y Aprendizaje Profundo',
    'Ingeniería de Software para Sistemas Inteligentes',
    'Metodología de la Investigación y Divulgación Científica'
);

-- IIA Sem 6 (optativas A/B)
INSERT INTO esc01_carrera_materia (fk_id_carrera, fk_id_materia, fk_id_tipo, nu_semestre)
SELECT
    (SELECT id_carrera FROM cat01_carrera WHERE tx_clave='IIA'),
    id_materia,
    (SELECT id_tipo FROM cat04_tipo_materia WHERE tx_nombre='Optativa'),
    6
FROM cat02_materia WHERE tx_nombre IN (
    'Innovación y emprendimiento tecnológico',
    'Propiedad Intelectual',
    'Aplicaciones de lenguaje natural',
    'Sistemas multiagentes',
    'Aplicaciones de sistemas multiagentes',
    'Minería de datos',
    'Big data'
);

-- IIA Sem 7 (obligatorias)
INSERT INTO esc01_carrera_materia (fk_id_carrera, fk_id_materia, fk_id_tipo, nu_semestre)
SELECT
    (SELECT id_carrera FROM cat01_carrera WHERE tx_clave='IIA'),
    id_materia,
    (SELECT id_tipo FROM cat04_tipo_materia WHERE tx_nombre='Obligatoria'),
    7
FROM cat02_materia WHERE tx_nombre IN (
    'Reconocimiento de Voz',
    'Trabajo Terminal I',
    'Formulación y Evaluación de Proyectos Informáticos'
);

-- IIA Sem 7 (optativas C/D)
INSERT INTO esc01_carrera_materia (fk_id_carrera, fk_id_materia, fk_id_tipo, nu_semestre)
SELECT
    (SELECT id_carrera FROM cat01_carrera WHERE tx_clave='IIA'),
    id_materia,
    (SELECT id_tipo FROM cat04_tipo_materia WHERE tx_nombre='Optativa'),
    7
FROM cat02_materia WHERE tx_nombre IN (
    'Temas selectos de inteligencia artificial',
    'Cómputo en la nube',
    'Técnicas de programación para robots móviles',
    'Interacción humano-máquina',
    'Programación de dispositivos móviles',
    'Aplicaciones de inteligencia artificial en sistemas embebidos',
    'Tópicos selectos de algoritmos bioinspirados'
);

-- IIA Sem 8 (obligatorias)
INSERT INTO esc01_carrera_materia (fk_id_carrera, fk_id_materia, fk_id_tipo, nu_semestre)
SELECT
    (SELECT id_carrera FROM cat01_carrera WHERE tx_clave='IIA'),
    id_materia,
    (SELECT id_tipo FROM cat04_tipo_materia WHERE tx_nombre='Obligatoria'),
    8
FROM cat02_materia WHERE tx_nombre IN (
    'Gestión Empresarial',
    'Trabajo Terminal II',
    'Estancia Profesional',
    'Desarrollo de Habilidades Sociales para la Alta Dirección'
);

-- =========================================================
-- RELACIÓN CARRERA - MATERIA — LCD
-- =========================================================

-- LCD Sem 1 (obligatorias)
INSERT INTO esc01_carrera_materia (fk_id_carrera, fk_id_materia, fk_id_tipo, nu_semestre)
SELECT
    (SELECT id_carrera FROM cat01_carrera WHERE tx_clave='LCD'),
    id_materia,
    (SELECT id_tipo FROM cat04_tipo_materia WHERE tx_nombre='Obligatoria'),
    1
FROM cat02_materia WHERE tx_nombre IN (
    'Fundamentos de Programación',
    'Matemáticas Discretas',
    'Cálculo',
    'Comunicación Oral y Escrita',
    'Introducción a la Ciencia de Datos'
);

-- LCD Sem 2 (obligatorias)
INSERT INTO esc01_carrera_materia (fk_id_carrera, fk_id_materia, fk_id_tipo, nu_semestre)
SELECT
    (SELECT id_carrera FROM cat01_carrera WHERE tx_clave='LCD'),
    id_materia,
    (SELECT id_tipo FROM cat04_tipo_materia WHERE tx_nombre='Obligatoria'),
    2
FROM cat02_materia WHERE tx_nombre IN (
    'Algoritmos y Estructuras de Datos',
    'Álgebra Lineal',
    'Cálculo Multivariable',
    'Ética y Legalidad',
    'Fundamentos Económicos'
);

-- LCD Sem 3 (obligatorias)
INSERT INTO esc01_carrera_materia (fk_id_carrera, fk_id_materia, fk_id_tipo, nu_semestre)
SELECT
    (SELECT id_carrera FROM cat01_carrera WHERE tx_clave='LCD'),
    id_materia,
    (SELECT id_tipo FROM cat04_tipo_materia WHERE tx_nombre='Obligatoria'),
    3
FROM cat02_materia WHERE tx_nombre IN (
    'Análisis y Diseño de Algoritmos',
    'Programación para Ciencia de Datos',
    'Probabilidad',
    'Bases de Datos',
    'Métodos Numéricos',
    'Finanzas Empresariales'
);

-- LCD Sem 4 (obligatorias)
INSERT INTO esc01_carrera_materia (fk_id_carrera, fk_id_materia, fk_id_tipo, nu_semestre)
SELECT
    (SELECT id_carrera FROM cat01_carrera WHERE tx_clave='LCD'),
    id_materia,
    (SELECT id_tipo FROM cat04_tipo_materia WHERE tx_nombre='Obligatoria'),
    4
FROM cat02_materia WHERE tx_nombre IN (
    'Desarrollo de Aplicaciones Web',
    'Cómputo de Alto Desempeño',
    'Estadística',
    'Base de Datos Avanzadas',
    'Desarrollo de Aplicaciones para Análisis de Datos',
    'Liderazgo Personal'
);

-- LCD Sem 5 (obligatorias)
INSERT INTO esc01_carrera_materia (fk_id_carrera, fk_id_materia, fk_id_tipo, nu_semestre)
SELECT
    (SELECT id_carrera FROM cat01_carrera WHERE tx_clave='LCD'),
    id_materia,
    (SELECT id_tipo FROM cat04_tipo_materia WHERE tx_nombre='Obligatoria'),
    5
FROM cat02_materia WHERE tx_nombre IN (
    'Minería de Datos',
    'Matemáticas Avanzadas para la Ingeniería',
    'Procesos Estocásticos',
    'Aprendizaje de Máquina e Inteligencia Artificial',
    'Analítica y Visualización de Datos',
    'Metodología de la Investigación y Divulgación Científica'
);

-- LCD Sem 6 (obligatorias)
INSERT INTO esc01_carrera_materia (fk_id_carrera, fk_id_materia, fk_id_tipo, nu_semestre)
SELECT
    (SELECT id_carrera FROM cat01_carrera WHERE tx_clave='LCD'),
    id_materia,
    (SELECT id_tipo FROM cat04_tipo_materia WHERE tx_nombre='Obligatoria'),
    6
FROM cat02_materia WHERE tx_nombre IN (
    'Modelado Predictivo',
    'Procesamiento de Lenguaje Natural',
    'Análisis de Series de Tiempo',
    'Analítica Avanzada de Datos'
);

-- LCD Sem 6 (optativas A/B)
INSERT INTO esc01_carrera_materia (fk_id_carrera, fk_id_materia, fk_id_tipo, nu_semestre)
SELECT
    (SELECT id_carrera FROM cat01_carrera WHERE tx_clave='LCD'),
    id_materia,
    (SELECT id_tipo FROM cat04_tipo_materia WHERE tx_nombre='Optativa'),
    6
FROM cat02_materia WHERE tx_nombre IN (
    'Estadística avanzada',
    'Temas selectos de inteligencia artificial',
    'Temas selectos de aprendizaje profundo',
    'Temas selectos de procesamiento de lenguaje natural',
    'Bioinformática básica',
    'Bioinformática avanzada',
    'Sistemas de información geográfica'
);

-- LCD Sem 7 (obligatorias)
INSERT INTO esc01_carrera_materia (fk_id_carrera, fk_id_materia, fk_id_tipo, nu_semestre)
SELECT
    (SELECT id_carrera FROM cat01_carrera WHERE tx_clave='LCD'),
    id_materia,
    (SELECT id_tipo FROM cat04_tipo_materia WHERE tx_nombre='Obligatoria'),
    7
FROM cat02_materia WHERE tx_nombre IN (
    'Big Data',
    'Modelos Econométricos',
    'Trabajo Terminal I',
    'Administración de Proyectos de TI'
);

-- LCD Sem 7 (optativas C/D)
INSERT INTO esc01_carrera_materia (fk_id_carrera, fk_id_materia, fk_id_tipo, nu_semestre)
SELECT
    (SELECT id_carrera FROM cat01_carrera WHERE tx_clave='LCD'),
    id_materia,
    (SELECT id_tipo FROM cat04_tipo_materia WHERE tx_nombre='Optativa'),
    7
FROM cat02_materia WHERE tx_nombre IN (
    'Ciberseguridad',
    'Protección de datos',
    'Innovación y emprendimientos tecnológicos',
    'Propiedad intelectual',
    'Simulación básica',
    'Simulación avanzada'
);

-- LCD Sem 8 (obligatorias)
INSERT INTO esc01_carrera_materia (fk_id_carrera, fk_id_materia, fk_id_tipo, nu_semestre)
SELECT
    (SELECT id_carrera FROM cat01_carrera WHERE tx_clave='LCD'),
    id_materia,
    (SELECT id_tipo FROM cat04_tipo_materia WHERE tx_nombre='Obligatoria'),
    8
FROM cat02_materia WHERE tx_nombre IN (
    'Desarrollo de Habilidades Sociales para la Alta Dirección',
    'Gestión Empresarial',
    'Trabajo Terminal II',
    'Estancia Profesional'
);
