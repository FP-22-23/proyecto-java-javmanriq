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
* **Prices**: tipo Auxiliar conformado por la columna High (highPrice) y la columna Low (lowPrice).
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

- _id_ , de tipo Integer, consultable y modificable. Representa el id con el que se identifica el producto.
- _date_ , de tipo LocalDate, consultable y modificable. Representa el día en el que el producto se registró en la base de datos de Amazon.
- _prices_ , de tipo Prices (tipo auxiliar), consultable y modificable.
- _lowPrice_ , de tipo Double, consultable y modificable. Representa el precio más bajo al que ha llegado a estar el producto.
- _volume_ , de tipo Integer, consultable y modificable. Representa el volumen de venta que tiene el producto.
- _stock_ , de tipo Boolean, consultable y modificable. Representa si hay existencias del producto o no.
- _country_ , de tipo String, consultable y modificable. Representa en qué país se vende el producto.
- _category_ , de tipo enum, consultable y modificable. Representa la categoría a la que pertenece el producto.

**Constructores**: 

- C1: Construye un objeto de tipo Producto con los atributos: (id, date, openPrice, prices(highPrice,lowPrice), volume,  stock, country, category).
- C2: Construye un objeto de tipo Producto con los atributos: (id, openPrice, country)

**Restricciones**:
 
- R1: Consulta que el precio de salida no sea menor que 0.
- R2: Consulta que el precio mas alto sea mayor que el precio mas bajo. (tipo auxiliar)
- R3: Consulta que el volumen de venta no sea menor que 0.

**Criterio de igualdad**: Se comparan todos los atributos simples mediante el metodo equals.

**Criterio de ordenación**: Se ordena primero por id, luego por precio de salida y por último por país donde se vende.

**Otras operaciones**:
-	_getVariability_ : Devuelve la diferencia entre el precio más alto y el más bajo que ha estado el producto. (tipo auxiliar)
-	_getProductTitle_ : Devuelve una cadena que sirve de titulo cuando se habla de un producto. La cadena genera "El producto con id: [x] tiene un precio de salida de x € y solo se vende en x.


#### Tipos auxiliares

- _Category_ : enumerado. Puede tomar los valores: Movies, Tools, Shoes, Games, Industrial, Music, Garden, Sports, Home, Health, Computers, Electronics, Grocery, Toys, Books, Outdoors, Kids, Clothing, Beauty, Baby, Automotive o Jewelery.

- _Prices_ : Record conformado por las propiedades highPrice (Double) y lowPrice (Double). En este record también se han definido las restricciones y funciones referidas a estas dos propiedades.

### Factoría - FactoriaProductos

Clase utilizada para realizar la lectura del fichero csv que contiene la información para poder trabajar con ella.

- _leeProductos_ : Crea un objeto de tipo Productos a partir de la información recogida en el archivo csv, cuya ruta se da como parámetro.

- _parsearProducto_ : Función que se usa para trocear cada línea del csv en sus correspondientes propiedades.

- _parseaBoolean_ : Función que transforma el String que se recoge del csv en un boolean para poder trabajar con la propiedad "stock" como es debido.

- _parseaCategory_ : Funcion que transforma el String que se recoge del csv en una lista para poder trabajar con la propiedad "category" como es debido.

### Tipo Contenedor - Productos

**Propiedades**:
- productos, de tipo List<Producto>, consultable. Lista de productos de Amazon.

**Constructores**:
- C1: Constructor por defecto. Crea un objeto de tipo Productos sin ningun productos almacenado.
- C2: Constructor con un parametro de tipo List<Producto>. Crea un objeto de tipo Productos con los productos incluidos en la lista dada como parámetro.

**Criterio de igualdad**: Dos productos son iguales si lo son sus propiedades de producto.

**Otras operaciones**:
- _getNumeroProductos_ : Calcula la longitud de la lista productos.
- _agregarProducto_ : Añade un producto al objeto.
- _agregarConjunto_ : Añade un conjunto de productos que toma por el parámetro conj y lo añade a productos.
- _eliminarPorId_ : Se elimina el producto con id equivalente al pasado como parámetro.

- _productoValeMenosx: Se devuelve cierto o falso dependiendo si se encuentra algun producto con un valor de salida inferior al pasado como parámetro
- _productoFueraStock: Se devuelve un Integer con el numero de productos que se encuentran fuera de stock.
- _filtrarPorPais_ : Se devuelve una lista con los productos que se venden en el país pasado como parametro.
- _productosPorPais_ : Se devuelve un map con los paises como clave y los productos que se venden en el país clave como valores.
- _stockDeProductos_ : Se devuelve un map con clave "en stock" o "fuera de stock" y como valor la cantidad de productos cuyo stock coincide con la clave..

 