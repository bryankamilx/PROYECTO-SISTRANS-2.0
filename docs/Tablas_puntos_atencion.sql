DROP TABLE puntos_atencion CASCADE CONSTRAINTS;

CREATE TABLE puntos_atencion (
    id NUMBER,
    tipo_punto VARCHAR2(50) NOT NULL,
    direccion VARCHAR2(255) NOT NULL,
    CONSTRAINT pk_puntos_atencion PRIMARY KEY (id),
    CONSTRAINT tipo_punto_chk CHECK (tipo_punto IN ('Presencial', 'Cajero', 'Virtual'))
);



DROP SEQUENCE puntos_atencion_seq;

CREATE SEQUENCE puntos_atencion_seq
INCREMENT BY 50
    START WITH 5
    CACHE 20
    NOCYCLE
    NOORDER;
ALTER TABLE puntos_atencion ADD (dtype VARCHAR2(255));
ALTER TABLE puntos_atencion DROP COLUMN dtype;




CREATE OR REPLACE TRIGGER puntos_atencion_bi
BEFORE INSERT ON PUNTOS_ATENCION
FOR EACH ROW
BEGIN
  SELECT puntos_atencion_seq.NEXTVAL
  INTO   :new.ID
  FROM   dual;
END;
/




CREATE INDEX idx_tipo_punto ON puntos_atencion(tipo_punto);





INSERT INTO puntos_atencion (tipo_punto, direccion) VALUES ('Presencial', '123 Avenida Central');
INSERT INTO puntos_atencion (tipo_punto, direccion) VALUES ('Presencial', '456 Calle del Mercado');
INSERT INTO puntos_atencion (tipo_punto, direccion) VALUES ('Presencial', '789 Bulevar del Parque');
INSERT INTO puntos_atencion (tipo_punto, direccion) VALUES ('Cajero', 'Estaci�n de Metro Ciudad Vieja');
INSERT INTO puntos_atencion (tipo_punto, direccion) VALUES ('Cajero', 'Centro Comercial Los Olivos');
INSERT INTO puntos_atencion (tipo_punto, direccion) VALUES ('Cajero', 'Aeropuerto Internacional');
INSERT INTO puntos_atencion (tipo_punto, direccion) VALUES ('Virtual', 'plataforma.bancoonline.com');
INSERT INTO puntos_atencion (tipo_punto, direccion) VALUES ('Virtual', 'app.bancoseguro.com');
INSERT INTO puntos_atencion (tipo_punto, direccion) VALUES ('Virtual', 'bancoenlinea24h.com');
INSERT INTO puntos_atencion (tipo_punto, direccion) VALUES ('Cajero', 'Universidad Central Campus Sur');


-- Cajeros
DROP TABLE cajeros CASCADE CONSTRAINTS;
CREATE TABLE cajeros (
    ID NUMBER PRIMARY KEY,
    MONTO_DISPONIBLE NUMBER NOT NULL,
    LIMITE_RETIRO NUMBER NOT NULL,
    NUMEROOFICINA NUMBER(38, 0) not null,
    CONSTRAINT fk_cajero_punto FOREIGN KEY (ID) REFERENCES PUNTOS_ATENCION(ID) ON DELETE CASCADE,
    CONSTRAINT fk_cajero_oficina FOREIGN KEY (NUMEROOFICINA) REFERENCES OFICINAS(NUMEROOFICINA)
);




CREATE INDEX idx_monto_disponible ON cajeros(MONTO_DISPONIBLE);
CREATE INDEX idx_limite_retiro ON cajeros(LIMITE_RETIRO);
ALTER TABLE CAJEROS ADD CONSTRAINT chk_limite_retiro CHECK (LIMITE_RETIRO >= 0);
ALTER TABLE CAJEROS ADD CONSTRAINT NUMEROOFICINA NOT NULL;
---Agrego datos en cajeros
INSERT INTO cajeros (ID, MONTO_DISPONIBLE, LIMITE_RETIRO, NUMEROOFICINA) VALUES (155, 20000, 1000, 1);
INSERT INTO cajeros (ID, MONTO_DISPONIBLE, LIMITE_RETIRO, NUMEROOFICINA) VALUES (205, 15000, 1500, 2);
INSERT INTO cajeros (ID, MONTO_DISPONIBLE, LIMITE_RETIRO, NUMEROOFICINA) VALUES (255, 25000, 2000, 3);
INSERT INTO cajeros (ID, MONTO_DISPONIBLE, LIMITE_RETIRO, NUMEROOFICINA) VALUES (455, 30000, 2500, 4);

SELECT *
FROM OFICINAS;


-- Presenciales

DROP TABLE presenciales CASCADE CONSTRAINTS;
CREATE TABLE presenciales (
    ID NUMBER PRIMARY KEY,
    NUMEROOFICINA NUMBER(38, 0) not null,
    CAJEROS_DISPONIBLES NUMBER NOT NULL,
    HORARIO_ATENCION_INICIO TIMESTAMP,
    HORARIO_ATENCION_FIN TIMESTAMP,
    CONSTRAINT fk_precencial_punto FOREIGN KEY (ID) REFERENCES PUNTOS_ATENCION(ID) ON DELETE CASCADE,
    CONSTRAINT fk_precencial_oficina FOREIGN KEY (NUMEROOFICINA) REFERENCES OFICINAS(NUMEROOFICINA) 
);



CREATE INDEX idx_cajeros_disponibles ON presenciales(CAJEROS_DISPONIBLES);




--Agrego datos en presenciales
INSERT INTO presenciales (ID, CAJEROS_DISPONIBLES, HORARIO_ATENCION_INICIO, HORARIO_ATENCION_FIN, NUMEROOFICINA) VALUES (5, 4, TO_TIMESTAMP('08:00:00', 'HH24:MI:SS'), TO_TIMESTAMP('10:00:00', 'HH24:MI:SS'), 1);
INSERT INTO presenciales (ID, CAJEROS_DISPONIBLES, HORARIO_ATENCION_INICIO, HORARIO_ATENCION_FIN, NUMEROOFICINA) VALUES (55, 6, TO_TIMESTAMP('08:00:00', 'HH24:MI:SS'), TO_TIMESTAMP('13:00:00', 'HH24:MI:SS'), 2);
INSERT INTO presenciales (ID, CAJEROS_DISPONIBLES, HORARIO_ATENCION_INICIO, HORARIO_ATENCION_FIN, NUMEROOFICINA) VALUES (105, 8, TO_TIMESTAMP('08:00:00', 'HH24:MI:SS'), TO_TIMESTAMP('14:00:00', 'HH24:MI:SS'), 3);


-- Virtuales
DROP TABLE virtuales CASCADE CONSTRAINTS;

CREATE TABLE virtuales
(
    plataforma varchar2(255),
    ID NUMBER,
    CONSTRAINT fk_virtual_punto FOREIGN KEY (ID) REFERENCES PUNTOS_ATENCION(ID) ON DELETE CASCADE,
    CONSTRAINT VIRTUAL_PK PRIMARY KEY(ID)
);









ALTER TABLE VIRTUALES ADD CONSTRAINT check_plataforma CHECK (PLATAFORMA IN ('Web', 'App', 'Chatbot', 'Whatsapp', 'Redes'));
CREATE INDEX idx_plataforma ON virtuales(PLATAFORMA);



--Agrego datos en virtuales
INSERT INTO virtuales (ID, PLATAFORMA) VALUES (305, 'Web');
INSERT INTO virtuales (ID,PLATAFORMA) VALUES (355, 'App');
INSERT INTO virtuales (ID, PLATAFORMA) VALUES (405, 'Chatbot');

commit;


--Agrego relaciones entre puntos_atencion y operaciones
CREATE TABLE puntos_atencion_operaciones (
    punto_id NUMBER,
    operacion_id NUMBER,
    CONSTRAINT fk_punto FOREIGN KEY (punto_id) REFERENCES puntos_atencion(id),
    CONSTRAINT fk_operacion FOREIGN KEY (operacion_id) REFERENCES operaciones(id),
    CONSTRAINT pk_puntos_operaciones PRIMARY KEY (punto_id, operacion_id)
);

INSERT INTO puntos_atencion_operaciones (punto_id, operacion_id) VALUES (5, 101);
INSERT INTO puntos_atencion_operaciones (punto_id, operacion_id) VALUES (305, 151);
