insert into Marca (nombre, descripcion, estado) values ('Marvel', 'Marvel','ACT');
insert into Marca (nombre, descripcion, estado) values ('DC comics', 'DC comics','ACT');
insert into Marca (nombre, descripcion, estado) values ('Otros', 'alternativos creados por la comunidad','ACT');


insert into Grupo(nombre, descripcion, estado) values ('Camisetas', 'Camisetas','ACT');
insert into Grupo(nombre, descripcion, estado) values ('Vasos', 'Vasos','ACT');
insert into Grupo(nombre, descripcion, estado) values ('Comics', 'Comics','ACT');
insert into Grupo(nombre, descripcion, estado) values ('Juguetes', 'Juguetes','ACT');
insert into Grupo(nombre, descripcion, estado) values ('Accesorios', 'Accesorios','ACT');

insert into cliente (tipo_identificacion,numero_identificacion,nombre,apellido,direccion_envio,usuario,contrasenia) values ('PASS', 'MARVEL-123D','VIUDA', 'NEGRA', 'METAVERSO','VIUDANEGRA', 'VIUDANEGRA');
insert into cliente (tipo_identificacion,numero_identificacion,nombre,apellido,direccion_envio,usuario,contrasenia) values ('PASS', 'MARVEL-777D','IRON', 'MAN', 'METAVERSO','IRONMAN', 'IRONMAN');
insert into cliente (tipo_identificacion,numero_identificacion,nombre,apellido,direccion_envio,usuario,contrasenia) values ('DNI', '1804192837','VIRGINIA', 'FLORES', 'UIO','VIRGINIAFLORES', 'VIRGINIAFLORES');

insert into forma_Pago (nombre, descripcion, estado) values ('EFECTIVO', 'EFECTIVO','ACT');
insert into forma_Pago (nombre, descripcion, estado) values ('TARJETA', 'TARJETA','ACT');
insert into forma_Pago (nombre, descripcion, estado) values ('PAYPAL', 'PAYPAL','ACT');
insert into forma_Pago (nombre, descripcion, estado) values ('BITCOIN', 'BITCOIN','ACT');
