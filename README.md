# BIENVENIDOS A HULK STORE - KARDEX

La empresa Todo1 ha decido realizar un emprendimiento, el cual consiste en la creación de una tienda
de productos para sus empleados, aquí podrás encontrar camisetas, vasos, comics, juguetes y accesorios
basados en los superhéroes de Marvel y DC comics, incluso algunos alternativos creados por la
comunidad.


## Construir el proyecto

El proyecto es contruido con MAVEN.

```console
$ mvn clean install
```

### Levantar el proyecto

```console
$ ./mvnw spring-boot:run

```

#API KARDEX

La tarjeta kardex permite llevar el inventario de los productos, se puede usar el método promedio ponderado y FIFO
Todos los productos tendrán un inventario inicial.

## Nuevo producto e inventario Inicial

Al registrar un producto automáticamente se creará un inventario inicial en la kardex.

Endpoint

```text
POST /api/productos/guardar
```

Ejemplo del cuerpo

```json
{
		"marca": {
					"id":1
				},
		"grupo": {
			"id":3
		},
		"metodoValoracionInventario":"PP",
		"nombre":"COMIC HULK AÑO 2000",
		"cantidadMinima":1,
		"cantidadMaxima":5,
		"fechaIngreso": "2021-01-07T10:01:47.060Z",
		"utilidad_porcentaje":25,
		"existencia":2,
		"precioMetodoValoracion":150,
		"estado":"ACT"		 
	}
	
```
Parameters

| Parameter      				| Description                                           |
| ----------------------------	| ----------------------------------------------------- |
| `marca` 				| Marca del producto           									|
| `grupo` 			 	| Grupo del producto 											|
| `nombre`     	 	| Nombre del producto  											|
| `cantidadMinima`  	| Cantidad mínima del producto en bodega  						|
| `cantidadMaxima`  	| Cantidad máxima del producto en bodega  						|
| `fechaIngreso`    	| Fecha de ingreso a bodega 									|
| `utilidad_porcentaje`| Porcentaje de utilidad 									|
| `existencia`		| Cantidad de producto existente en bodega  					|
| `precioMetodoValoracion`| Precio del producto según el método de valoración del inventario  |
| `Estado`				| Estado del producto 											 |


La siguiente solicitud POST, es un ejemplo de solicitud que utiliza CURL, envía a guardar el producto .



```console
curl --location --request POST 'http://localhost:8080/api/productos/guardar' \
--header 'Content-Type: application/json' \
--data-raw '{
		"marca": {
					"id":1
				},
		"grupo": {
			"id":3
		},		"metodoValoracionInventario":"PP","nombre":"COMIC HULK AÑO 2000",	"cantidadMinima":1,
		"cantidadMaxima":5,	"fechaIngreso": "2021-01-07T10:01:47.060Z","utilidad_porcentaje":25,
		"existencia":2,	"precioMetodoValoracion":150,	"estado":"ACT"		 
	}'
```


## Ventas

Las ventas afectan a la trajeta kardex, disminuyendo la cantidad de productos se puede usar en este API el método de valoración de inventario promedio ponderado.

Endpoint

```text
POST /api/venta/guardar
```

Ejemplo del cuerpo

```json
{
		"cliente": {
					"id":1
				},
		"formaPago": {
			"id":1
		},
		"numeroDocumento":"2022-000001",		
		"direccion":"UIO",
		"subtotalPago":213.95,
		"impuestoValorAgregado": 48.95,
		"totalPago":262.9,
		"detalle":[
			{"documento":{"id":1},"producto":{"id":1}, "cantidad":2, "precioUnitario": 17.25, "estado":"ACT"},
			{"documento":{"id":1},"producto":{"id":2}, "cantidad":5, "precioUnitario": 9.20, "estado":"ACT"},
			{"documento":{"id":1},"producto":{"id":3}, "cantidad":1, "precioUnitario": 187.5, "estado":"ACT"}
		]
	}
	
```

La siguiente solicitud POST, es un ejemplo de solicitud que utiliza CURL, envía a guardar la venta del producto .

```console
curl --location --request POST 'http://localhost:8080/api/venta/guardar' \
--header 'Content-Type: application/json' \
--data-raw '	{
		"cliente": {
					"id":1
				},	"formaPago": {"id":1},
		"numeroDocumento":"2022-000001", "direccion":"UIO","subtotalPago":213.95, "impuestoValorAgregado": 48.95,
		"totalPago":262.9,"detalle":[	{"documento":{"id":1},"producto":{"id":1}, "cantidad":2, "precioUnitario": 17.25, "estado":"ACT"}
		]
	}'
```



## Compras

Las compras afectan a la trajeta kardex, aumentando la cantidad de productos se puede usar en este API el método de valoración de inventario promedio ponderado.

Endpoint

```text
POST /api/compras/guardar
```

Ejemplo del cuerpo

```json
{
	"producto":{"id":1},
	"concepto":"Compra según factura: 45454",
	"tipoMovimiento":"ENT",
	"tipoOperacion":"ECOM",
	"cantidad":20,
	"precioUnitario":20
}
	
```

La siguiente solicitud POST, es un ejemplo de solicitud que utiliza CURL, envía a guardar la venta del producto .

```console
curl --location --request POST 'http://localhost:8080/api/compras/guardar' \
--header 'Content-Type: application/json' \
--data-raw '{
	"producto":{"id":1},"concepto":"Compra según factura: 45454",
	"tipoMovimiento":"ENT","tipoOperacion":"ECOM","cantidad":20,"precioUnitario":20
}'
```
## Test

El test de la clase Marca es un ejemplo de @SpringBootTest.




