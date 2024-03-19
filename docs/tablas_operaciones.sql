CREATE TABLE operaciones (
    id INT PRIMARY KEY,
    tipo VARCHAR(100) NOT NULL,
    id_usuario INT NOT NULL,
    producto VARCHAR(100) NOT NULL,
    valor INT NOT NULL,
    fecha_hora DATE NOT NULL
);


CREATE TABLE operaciones_prestamos (
    id INT PRIMARY KEY,
    detalle_pago VARCHAR(150) NOT NULL,
    id_prestamo INT NOT NULL,
    FOREIGN KEY (id) REFERENCES operaciones(id) ON DELETE CASCADE
);


CREATE TABLE operaciones_cuentas (
    id INT PRIMARY KEY,
    num_cuenta INT NOT NULL,
    detalle VARCHAR(150) NOT NULL,
    FOREIGN KEY (id) REFERENCES operaciones(id) ON DELETE CASCADE
);

CREATE SEQUENCE operaciones_seq
  START WITH 1
  INCREMENT BY 50
  CACHE 20
  NOCYCLE;

SELECT * FROM operaciones;

SELECT * FROM prestamos;

INSERT INTO operaciones (id, tipo, id_usuario, producto, valor, fecha_hora) VALUES(operaciones_seq.nextval, 'Prestamo', 55, 'Abono prestamo', 100000, TO_DATE('2024-03-18 16:00:00', 'YYYY-MM-DD HH24:MI:SS'));

INSERT INTO operaciones_cuentas (id, num_cuenta, detalle) VALUES(101, 100056, 'Retiro cuenta');

INSERT INTO operaciones_prestamos (id, detalle_pago, id_prestamo) VALUES(151, 'Amortizacion intereses', 50)



