El documento de informe se encuentra dentro de la carpeta docs, junto con las sentencias SQL y el ejercicio de aislamiento

Instalacion Usuarios

1. Primero cree la tabla de usuarios
2. cree la secuencia usuarios_seq
3. Agregue los trigger y restricciones pertinentes
4. Inserte los datos correspondientes
5. Agregue la tabla Cliente, y agregue los index con las alteraciones correspondientes
6. Agregue datos a cliente
7. Agregue la tabla Empleados, y cree los index con las alteraciones correspondientes
8. Agregue datos a empleados

Instalacion Puntos de Atencion

1. Primero agregue la tabla de puntos de atencion
2. agregue la secuencia puntos_atencion_seq
3. Agregue el Trigger puntos_atencion_bi
4. Inserte los datos correspondientes
5. Cree la tabla Cajeros, y agregue los index con las alteraciones correspondientes
6. Agregue datos a cajeros
7. Cree la tabla Presenciales, y cree los index con las alteraciones correspondientes
8. Agregue datos a presenciales
9. Cree la tabla Virtuales, y cree los index con las alteraciones correspondientes
10. Agregue datos a virtuales
11. Cree la tabla puntos_atencion_operaciones, y cree los index con las alteraciones correspondientes
10. Agregue datos a puntos_atencion_operaciones


Instalacion Operaciones
1. Crear la secuencia 'operaciones_seq':
Esta secuencia se utiliza para generar valores únicos de ID para las tres tablas de operaciones. 
2. Se define una columna 'id' como clave primaria para identificar de manera única cada operación.
3. Se definen columnas para el tipo de operación, el ID del usuario, el producto involucrado, el valor de la operación y la fecha y hora en que ocurrió.

Instalacion Operaciones Prestamo
Esta tabla almacenará detalles específicos de las operaciones relacionadas con préstamos.
1. Define una columna 'id' como clave primaria para identificar de manera única cada operación de préstamo.
2. Agrega una columna 'detalle_pago' para describir cómo se realizó el pago.
3. Agrega una columna 'id_prestamo' para almacenar el ID del préstamo relacionado.
4. Establece una relación con la tabla 'operaciones' haciendo que la columna 'id' sea una clave foránea que referencia la columna 'id' en la tabla 'operaciones'. 
Esto garantiza que cada operación de préstamo esté vinculada a una operación principal y que se mantenga la integridad referencial. 

Instalacion Operaciones Cuenta
Esta tabla almacenará detalles específicos de las operaciones relacionadas con cuentas.
1. Define una columna 'id' como clave primaria para identificar de manera única cada operación relacionada con cuentas.
2. Agrega una columna 'num_cuenta' para almacenar el número de cuenta involucrado en la operación.
3. Agrega una columna 'detalle' para proporcionar información adicional sobre la operación.
4. Al igual que en la tabla 'operaciones_prestamos', establece una relación con la tabla 'operaciones' haciendo que la columna 'id' 
sea una clave foránea que referencia la columna 'id' en la tabla 'operaciones', con la opción ON DELETE CASCADE para mantener la integridad referencial.

