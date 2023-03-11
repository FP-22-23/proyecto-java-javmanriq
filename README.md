# Proyecto del Segundo Cuatrimestre Fundamentos de Programación (Curso  2022/2023)
Autor/a: Javier Manrique Riquelme   uvus: javmanriq

## Estructura de las carpetas del proyecto

* **src**: Contiene los diferentes archivos que forman parte del proyecto. Debe estar estructurado en los siguentes paquetes
  * **fp.Producto**: Paquete que contiene los tipos del proyecto.
    * **Producto**: Clase princpipal del proyecto. 
    * **Category**: Enumerado con las categorías de los productos.
  * **fp.Producto.test**: Paquete que contiene las clases de test del proyecto.
  * **fp.common**: Paquete que contiene los tipos auxiliares del proyecto
  * **fp.utiles**:  Paquete que contiene las clases de utilidad. 
* **data**: Contiene el dataset o datasets del proyecto
    * **Amazon_stocks1.csv**: Datos acerca de una serie de productos registrados en Amazon.

    
## Estructura del *dataset*

El dataset original "Amazon Stock Data(Oct 2019 - July 2020)[LATEST]" se puede obtener del enlace "http://kaggle.com/aayushmishra1512/amazon". Originalmente contaba con 8 columnas y cada fila contiene datos acerca de productos que se han ido añadiendo a la base de datos de Amazon. 
Actualmente el dataset está compuesto por 9 columnas. Se ha encontrado la necesidad de añadir una columna mas para poder trabajar con datos de tipo boolean, tipo String, y poder trabajar con un enumerado, los cuales han sido generados aleatoriamente con la herramienta Moockaroo. Otras se han eliminado ya que no eran de gran aporte y repetían tipos ya usados.
Las columnas son las siguientes:

* **Id**: de tipo Integer, representa el id con el que se identifica al producto.
* **Date**: de tipo LocalDate, representa el día en el que el producto se registró en la base de datos de Amazon.
* **Open**: de tipo Double, representa el precio de salida del producto.
* **High**: de tipo Double, representa el precio más alto al que ha llegado a estar el producto.
* **Low**: de tipo Double, representa el precio más bajo al que ha llegado a estar el producto.
* **Volume**: de tipo Integer, representa el volumen de venta que tiene el producto.
* **Stock**: de tipo Boolean, representa si hay existencias del producto o no.
* **Country**: de tipo String, representa en qué país se vende el producto.
* **Category**: de tipo enum, representa la categoría a la que pertenece el producto.


## Tipos implementados

Los tipos que se han implementado en el proyecto son los siguientes:

### Tipo Base
Representa un producto concreto.

**Propiedades**:

- _id_, de tipo Integer, consultable y modificable. Representa el id con el que se identifica el producto.
- _date_, de tipo LocalDate, consultable y modificable. Representa el día en el que el producto se registró en la base de datos de Amazon.
- _openPrice_, de tipo Double, consultable y modificable. Representa el precio de salida del producto.
- _highPrice_, de tipo Double, consultable y modificable. Representa el precio más alto al que ha llegado a estar el producto.
- _lowPrice_, de tipo Double, consultable y modificable. Representa el precio más bajo al que ha llegado a estar el producto.
- _volume_, de tipo Integer, consultable y modificable. Representa el volumen de venta que tiene el producto.
- _stock_, de tipo Boolean, consultable y modificable. Representa si hay existencias del producto o no.
- _country_, de tipo String, consultable y modificable. Representa en qué país se vende el producto.
- _category_, de tipo enum, consultable y modificable. Representa la categoría a la que pertenece el producto.

**Constructores**: 

- C1: Construye un objeto de tipo Producto con los atributos: (id, date, openPrice, highPrice,lowPrice, volume,  stock, country, category).
- C2: Construye un objeto de tipo Producto con los atributos: (id, openPrice, country)

**Restricciones**:
 
- R1: Consulta que el precio de salida no sea menor que 0.
- R2: Consulta que el precio más alto sea mayor o igual que el precio de salida.
- R3: Consulta que el precio más bajo sea menor o igual que el precio de salida.

**Criterio de igualdad**: Se comparan todos los atributos simples mediante el metodo equals.

**Criterio de ordenación**: Se ordena primero por id, luego por precio de salida y por último por país donde se vende.

**Otras operaciones**:
 
-	_getVariability_: Devuelve la diferencia entre el precio más alto y el más bajo que ha estado el producto.
-	_getProductTitle_: Devuelve una cadena que sirve de titulo cuando se habla de un producto. La cadena genera "El producto con id: [x] tiene un precio de salida de x € y solo se vende en x.


#### Tipos auxiliares
- _Category_: enumerado. Puede tomar los valores: Movies, Tools, Shoes, Games, Industrial, Music, Garden, Sports, Home, Health, Computers, Electronics, Grocery, Toys, Books, Outdoors, Kids, Clothing, Beauty, Baby, Automotive o Jewelery.

 