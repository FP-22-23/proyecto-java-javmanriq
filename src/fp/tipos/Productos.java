package fp.tipos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.SortedSet;
import java.util.TreeSet;

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
	
//3. una selección con filtrado
	public List<Producto> filtrarPorPaís(String pais) {
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

