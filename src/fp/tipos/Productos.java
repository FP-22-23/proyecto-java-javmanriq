package fp.tipos;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Productos {

	private List<Producto> productos;
	
	public Productos(List<Producto> productos) {
		this.productos = productos;
	}
	
	public Productos() {
		this.productos = new ArrayList<>();
	}
	
	public Productos(Stream<Producto> productos) {
		this.productos = productos.collect(Collectors.toList());
	}
	
	public List<Producto> getProductos() {
		return productos;
	}
//a. obtener el número de elementos
	public Integer getNumeroProductos() {
		/*
		 Calcula la longitud de la lista productos.
		 */
		return productos.size();
	}
	
//b. agregar un elemento
	public void agregarProducto(Producto p) {
		/*
		 Añade un producto al objeto.
		 */
		productos.add(p);
	}
	
//c. agregar una coleccion de elementos
	public void agregarConjuntoProductos(List<Producto> conj) {
		/*
		 Añade un conjunto de productos que toma por el parámetro conj y lo añade a productos.
		 */
		productos.addAll(conj);
	}
	
//d. eliminar un elemento por id
	public void eliminarPorId(Integer numId) {
		/*
		 Se elimina el producto con id equivalente al pasado como parámetro.
		 */
		for(Producto p: productos) {
			if(p.getId().equals(numId)) {
				productos.remove(p);
			}
		}
	}
	
//1. existe
	public boolean productoValeMenosx(Integer x) {
		/*
		 Se devuelve cierto o falso dependiendo si se encuentra algun producto con un valor de salida inferior 
		 al pasado como parámetro.
		 */
		for(Producto p: productos) {
			if(p.getOpenPrice()<x) {
				return true;
			}
		}
		return false;
	}
	
//1.2 existe por Streams
	public boolean productoValeMenosxStream(Integer x) {
		/*
		 Tiene la misma funcionalidad que el metodo anterior pero obtenido mediante streams. 
		 */
		return getProductos().stream()
				.anyMatch(p->p.getOpenPrice()<x);
	}
	
//2. contador
	public Integer productosFueraStock() {
		/*
		 Se devuelve un Integer con el numero de productos que se encuentran fuera de stock.
		 */
		Integer contador = 0;
		for(Producto p: productos) {
			if(p.getStock() == false) {
				contador++;
			}
			else {
			}
		}
		return contador;
	}
	
//2.2 contador por Streams
	public Long productosFueraStockStream() {
		/*
		 Tiene la misma funcionalidad que el metodo anterior pero obtenido mediante streams. 
		 */
		return getProductos().stream()
					.filter(p->p.getStock().equals(false))
					.count();
	}
	
//3. una selección con filtrado
	public List<Producto> filtrarPorPais(String pais) {
		/*
		 Se devuelve una lista con los productos que se venden en el país pasado como parametro.
		 */
		List<Producto> res = new ArrayList<>();
		for(Producto p: productos) {
			if(p.getCountry().contains(pais)) {
				res.add(p);
			}
		}
		return res;
	}
	
//3.2 una selección con filtrado por Streams
		/*
		 Tiene la misma funcionalidad que el metodo anterior pero obtenido mediante streams. 
		 */
	public List<Producto> filtrarPorPaisStream(String pais) {
		return getProductos().stream()
					.filter(p->p.getCountry().equals(pais))
					.collect(Collectors.toList());
		}
	
//4. método de agrupacion mediante map (claves:categoria, valores: SortedSet de tipo base)
	public Map<String, SortedSet<Producto>> productosPorPais(){
		/*
		 Se devuelve un map con los paises como clave y los productos que se venden en el país clave como valores.
		 */
	Map<String, SortedSet<Producto>> res = new HashMap<String, SortedSet<Producto>>();
	
	for(Producto p: productos) {
		String pais = p.getCountry();
		
		if(res.containsKey(pais)) {
			res.get(pais).add(p);
		}
		else {
			SortedSet<Producto> nuevoSet = new TreeSet<>();
			nuevoSet.add(p);
			res.put(pais, nuevoSet);
		}
	}	
	return res;
	}
	
//5. método de acumulacion que devuelve un map (claves:propiedad tipo base, valores: conteo o suma de los objetos)
	public Map<String, Integer> stockDeProductos(){
		/*
		 Se devuelve un map con clave "en stock" o "fuera de stock" y como valor la cantidad de productos cuyo stock 
		 coincide con la clave.
		 */
		Map<String, Integer> res = new HashMap<>();
		for(Producto p: productos) {
			Boolean n = p.getStock();
			String clave;
			if(n==true) {
				clave = "En Stock";
			}
			else { 
				clave = "Fuera de Stock";
			}
			if(res.containsKey(clave)) {
				res.put(clave, res.get(clave)+1);
			}
			else {
				res.put(clave, 1);
			}
		}
		
		return res;
	}
	
//4.2 mínimo con filtrado
	public Producto minimoVolumenVentasPortugal() {
		/*
		 Se devuelve el producto que ha obtenido un volumen de ventas más pequeño en Portugal.
		 */
		return getProductos().stream()
					.filter(p->p.getCountry().equals("Portugal"))
					.min(Comparator.comparing(Producto::getVolume))
					.get();
		}
	
//5.2 selección, con filtrado y ordenacion
		/*
		 Se devuelve una lista con los id de los productos de japon ordenados por el volumen de ventas registrados.
		 */
	public List<Integer> idPorVolumenVentasJapon() {
		return getProductos().stream()
				.filter(p->p.getCountry().equals("Japan"))
				.sorted(Comparator.comparing(Producto::getVolume))
				.map(Producto::getId)
				.collect(Collectors.toList());			
	}
	
//6 metodo 4 mediante Streams
	public Map<String, List<Producto>> productosPorPaisStream() {
		/*
		 Método similar al que realiza la funcion productosPorPais pero obtenido mediante streams.
		 */
		return getProductos().stream()
				.collect(Collectors.groupingBy(Producto::getCountry));
	}
	
//7 método implementando collectingAndThen
	public Map<List<Category>, Object> precioMaximoPorCategoria() {
		/*
		 Se devuelve un map con una categoria como clave y el precio maximo registrado dentro de la categoria como valor.
		 */
		return getProductos().stream()
				.collect(Collectors.groupingBy(Producto::getCategory,
						Collectors.collectingAndThen(Collectors.maxBy(Comparator.comparing(Producto::getOpenPrice)),p->p.get().getOpenPrice())));
	}
	
//8 método de agrupacion mediante map (claves: atributo, valores: minimo)
	public Map<String, Object> precioMinimoPorPais() {
		/*
		 Se devuelve un map con un país como clave y el mínimo precio registrado en cada país como valor.
		 */
		return getProductos().stream()
				.collect(Collectors.groupingBy(Producto::getCountry,
						Collectors.collectingAndThen(Collectors.minBy(Comparator.comparing(Producto::getOpenPrice)),p->p.get().getOpenPrice())));
	}
	
//9 método de agrupacion mediante map (claves: atributo, valores: n mejores elementos)
	public SortedMap<String, List<Producto>> nPreciosMasBajosPorPais(Integer n) {
		/*
		 Se devuelve un map con un país como clave y una lista con los n precios más bajos como valor.
		 */
		return getProductos().stream()
				.collect(Collectors.groupingBy(Producto::getCountry,
						TreeMap::new,
						Collectors.collectingAndThen(Collectors.toList(), 
						lista -> nPreciosMasBajos(n,lista))));
	}

	
//metodo auxiliar 
	private List<Producto> nPreciosMasBajos(Integer n, List<Producto> lista){
		/*
		 Función auxiliar de nPreciosMasBajosPorPais, la cual devuelve una lista con los precios ordenados y 
		 limitados al parametro n.
		 */
		return lista.stream()
				.sorted(Comparator.comparing(Producto::getOpenPrice))
				.limit(n)
				.collect(Collectors.toList());
	}
	
//10 metodo que calcule un map y devuelva la clave con el valor asociado (mayor o menor) de todo el map
	public String paisMasProductos() {
		/*
		 Se devuelve un string que indica cual es el país con una cantidad de productos almacenados mayor.
		 */
		Map<String,Long> f = numProductosPorPais();
		String res = f.entrySet().stream().max(Map.Entry.comparingByValue()).get().getKey();
		return res;
	}
	
	private Map<String, Long> numProductosPorPais(){
		/*
		 Función auxiliar de paisMasProductos, la cual devuelve un map con el nombre de un país como clave y la 
		 cantidad de veces que aparece como valor.
		 */
		return getProductos().stream()
				.collect(Collectors.groupingBy(Producto::getCountry,Collectors.counting()));
	}

//Criterio de igualdad generado automaticamente mediante eclipse
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Productos other = (Productos) obj;
		return Objects.equals(productos, other.productos);
	}

	
//Representación como cadena generada automaticamente mediante eclipse
	public String toString() {
		return "Productos [productos=" + productos + "]";
	}
	
	
}

