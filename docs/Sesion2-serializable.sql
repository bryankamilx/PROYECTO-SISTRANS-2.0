-- Iniciar sesión S2 con nivel de aislamiento serializable en T4
commit;
SET autocommit 0;
SET TRANSACTION ISOLATION LEVEL SERIALIZABLE;

-- Operación 1: Descontar 30.000 pesos de CUENTA_1 por cuota de manejo en T6
UPDATE cuentas
SET saldo = saldo - 30000
WHERE ID = 101;

-- Registro de la operación en el log para CUENTA_1 en T8
INSERT INTO operaciones_cuentas (id, cuenta, detalle)
VALUES (operaciones_seq.NEXTVAL, 101, 'Cuota de manejo de $30.000');

-- Operación 2: Consignar 5.000 pesos de intereses en CUENTA_2 en T9
UPDATE cuentas
SET saldo = saldo + 5000
WHERE ID = 201;

-- Registro de la operación en el log para CUENTA_2 en T10
INSERT INTO operaciones_cuentas (id, cuenta, detalle)
VALUES (operaciones_seq.NEXTVAL, 201, 'Consignación de intereses de $5.000');

-- Confirmar las operaciones de la sesión 2 en T12
COMMIT;

-- Consulta el saldo actual de CUENTA_1 y CUENTA_2 en T13
SELECT * FROM cuentas WHERE ID IN (101, 201);


