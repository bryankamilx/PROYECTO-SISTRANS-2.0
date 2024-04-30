select * from cuentas;
select * from operaciones_cuentas;

-- Iniciar sesión S1 con nivel de aislamiento serializable en T1
commit;

Set autocommit 0;

SET TRANSACTION ISOLATION
LEVEL SERIALIZABLE;

-- Operación 1: modificar el saldo a 1.000.000 de pesos de la CUENTA_1 en T2
UPDATE cuentas
SET saldo = saldo + 1000000
WHERE ID = 101;

-- Registro de la operación en el log para CUENTA_1 en T3
INSERT INTO operaciones_cuentas (id, cuenta, detalle)
VALUES (2102,101, 'Consignación de $1.000.000');


-- Operación 2: Retirar 50.000 pesos de CUENTA_2 en T4
UPDATE cuentas
SET saldo = saldo - 50000
WHERE ID = 201;  

-- Registro de la operación en el log para CUENTA_2 en T5
INSERT INTO operaciones_cuentas (id, cuenta, detalle)
VALUES (operaciones_seq.NEXTVAL, 201, 'Retiro de $50.000');

-- Confirmar las operaciones de la sesión 1 en T7
COMMIT;

-- Consulta el saldo actual de CUENTA_1 y CUENTA_2 en T11
SELECT * FROM cuentas WHERE ID IN (101, 201);

-- Segunda consulta del saldo actual de CUENTA_1 y CUENTA_2 en T13
SELECT * FROM cuentas WHERE ID IN (101, 201);