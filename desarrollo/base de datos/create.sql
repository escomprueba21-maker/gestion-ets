
CREATE TABLE cat01_carrera (
    id_carrera  INT4 GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    tx_clave    VARCHAR(10)  NOT NULL UNIQUE,
    tx_nombre   VARCHAR(200) NOT NULL
);

CREATE TABLE cat02_materia (
    id_materia  INT4 GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    tx_nombre   VARCHAR(200) NOT NULL
);

CREATE TABLE cat03_rol (
    id_rol     INT4 GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    tx_nombre  VARCHAR(100) NOT NULL
);

CREATE TABLE cat04_tipo_materia (
    id_tipo    INT4 GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    tx_nombre  VARCHAR(50) NOT NULL
);

CREATE TABLE esc01_carrera_materia (
    fk_id_carrera  INT4 NOT NULL REFERENCES cat01_carrera(id_carrera),
    fk_id_materia  INT4 NOT NULL REFERENCES cat02_materia(id_materia),
    fk_id_tipo     INT4 NOT NULL REFERENCES cat04_tipo_materia(id_tipo),
    nu_semestre    INT4 NOT NULL,
    PRIMARY KEY (fk_id_carrera, fk_id_materia)
);

CREATE INDEX idx_esc01_carrera_semestre
    ON esc01_carrera_materia (fk_id_carrera, nu_semestre);

CREATE TABLE esc02_persona (
    id_persona     INT4 GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    tx_nombre      VARCHAR(100) NOT NULL,
    tx_apellido_paterno  VARCHAR(100) NOT NULL,
    tx_apellido_materno  VARCHAR(100),
    tx_correo      VARCHAR(200) NOT NULL UNIQUE,
    tx_password    VARCHAR(255) NOT NULL,
    st_verificado  BOOLEAN      NOT NULL DEFAULT FALSE,
    fh_registro    TIMESTAMP    NOT NULL DEFAULT NOW()
);

CREATE TABLE esc03_persona_rol (
    fk_id_persona  INT4 NOT NULL REFERENCES esc02_persona(id_persona),
    fk_id_rol      INT4 NOT NULL REFERENCES cat03_rol(id_rol)
    PRIMARY KEY (fk_id_persona, fk_id_rol)
);

CREATE TABLE esc04_token_confirmacion (
    token         VARCHAR(200),
    fk_id_persona  INT4      NOT NULL REFERENCES esc02_persona(id_persona),
    fh_expiracion  TIMESTAMP NOT NULL,
    st_usado       BOOLEAN   NOT NULL DEFAULT FALSE,
    fh_creacion    TIMESTAMP NOT NULL DEFAULT NOW()
);

CREATE TABLE esc05_docente (
    id_docente     INT4 GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    tx_nombre      VARCHAR(100) NOT NULL,
    tx_apellido_paterno  VARCHAR(100) NOT NULL,
    tx_apellido_materno  VARCHAR(100),
    tx_correo      VARCHAR(200) UNIQUE
);

CREATE TABLE esc06_aula (
    id_aula      INT4 GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    tx_clave     VARCHAR(20) NOT NULL UNIQUE,
    tx_edificio  VARCHAR(50)
);

CREATE TABLE esc07_ets (
    id_ets         INT4 GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    fk_id_materia  INT4      NOT NULL REFERENCES cat02_materia(id_materia),
    fk_id_docente  INT4      REFERENCES esc05_docente(id_docente),
    fk_id_aula     INT4      REFERENCES esc06_aula(id_aula),
    fh_aplicacion  TIMESTAMP NOT NULL,
    fh_registro    TIMESTAMP NOT NULL DEFAULT NOW()
);

CREATE INDEX idx_esc07_ets_materia_fecha
    ON esc07_ets (fk_id_materia, fh_aplicacion);


CREATE TABLE esc08_agenda_ets (
    id_agenda_ets    INT4 GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    fk_id_persona    INT4          NOT NULL REFERENCES esc02_persona(id_persona),
    fk_id_ets        INT4          NOT NULL REFERENCES esc07_ets(id_ets),
    nu_calificacion  NUMERIC(4,2),
    tx_notas         TEXT,
    fh_registro      TIMESTAMP     NOT NULL DEFAULT NOW(),
    UNIQUE (fk_id_persona, fk_id_ets)
);

CREATE INDEX idx_esc08_agenda_persona
    ON esc08_agenda_ets (fk_id_persona);
