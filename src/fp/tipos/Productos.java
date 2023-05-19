package fp.tipos;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class Productos {

	private List<Producto> productos;
	
//
	public Productos(List<Producto> productos) {
		this.productos = productos;
	}
	
	public Productos() {
		this.productos = new ArrayList<>();
	}
	
	public List<Producto> getProductos() {
		return productos;
	}
//a. obtener el número de elementos
	public Integer getNumeroProductos() {
		/*
		 Explicar funcion
		 */
		return productos.size();
	}
	
//b. agregar un elemento
	public void agregarProducto(Producto p) {
		/*
		 Explicar funcion
		 */
		productos.add(p);
	}
	
//c. agregar una coleccion de elementos
	public void agregarConjuntoProductos(List<Producto> conj) {
		/*
		 Explicar funcion
		 */
		productos.addAll(conj);
	}
	
//d. eliminar un elemento por id
	public void eliminarPorId(Integer numId) {
		/*
		 Explicar funcion
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
		 Explicar funcion
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
		 Explicar funcion
		 */
		return getProductos().stream()
				.anyMatch(p->p.getOpenPrice()<x);
	}
	
//2. contador
	public Integer productosFueraStock() {
		/*
		 Explicar funcion
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
		 Explicar funcion
		 */
		return getProductos().stream()
					.filter(p->p.getStock().equals(false))
					.count();
	}
	
//3. una selección con filtrado
	public List<Producto> filtrarPorPais(String pais) {
		/*
		 Explicar funcion
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
	public List<Producto> filtrarPorPaisStream(String pais) {
		return getProductos().stream()
					.filter(p->p.getCountry().equals(pais))
					.collect(Collectors.toList());
		}
	
//4. método de agrupacion mediante map (claves:categoria, valores: SortedSet de tipo base)
	public Map<String, SortedSet<Producto>> productosPorPais(){
		/*
		 Explicar funcion
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
		 Explicar funcion
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
		 Explicar funcion
		 */
		return getProductos().stream()
					.filter(p->p.getCountry().equals("Portugal"))
					.min(Comparator.comparing(Producto::getVolume))
					.get();
		}
	
//5.2 selección, con filtrado y ordenacion
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
		 Explicar funcion
		 */
		return getProductos().stream()
				.collect(Collectors.groupingBy(Producto::getCountry));
	}
	
//7 método implementando collectingAndThen
	public Map<List<Category>, Object> precioMaximoPorCategoria() {
		/*
		 Explicar funcion
		 */
		return getProductos().stream()
				.collect(Collectors.groupingBy(Producto::getCategory,
						Collectors.collectingAndThen(Collectors.maxBy(Comparator.comparing(Producto::getOpenPrice)),p->p.get().getOpenPrice())));
	}
	
//8 método de agrupacion mediante map (claves: atributo, valores: minimo)
	public Map<String, Object> precioMinimoPorPais() {
		/*
		 Explicar funcion
		 */
		return getProductos().stream()
				.collect(Collectors.groupingBy(Producto::getCountry,
						Collectors.collectingAndThen(Collectors.minBy(Comparator.comparing(Producto::getOpenPrice)),p->p.get().getOpenPrice())));
	}
	
//9 método de agrupacion mediante map (claves: atributo, valores: n mejores elementos)
	public SortedMap<String, List<Producto>> nPreciosMasBajosPorPais(Integer n) {
		/*
		 Explicar funcion
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
		 Explicar funcion
		 */
		return lista.stream()
				.sorted(Comparator.comparing(Producto::getOpenPrice))
				.limit(n)
				.collect(Collectors.toList());
	}
	
//10 metodo que calcule un map y devuelva la clave con el valor asociado (mayor o menor) de todo el map
	public String paisMasProductos() {
		/*
		 Explicar funcion
		 */
		Map<String,Long> f = numProductosPorPais();
		String res = f.entrySet().stream().max(Map.Entry.comparingByValue()).get().getKey();
		return res;
	}
	
	private Map<String, Long> numProductosPorPais(){
		/*
		 Explicar funcion
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

