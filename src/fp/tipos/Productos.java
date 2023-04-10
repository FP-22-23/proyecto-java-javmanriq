package fp.tipos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;

public class Productos {

	private List<Producto> productos;
	
	public Productos(List<Producto> productos) {
		this.productos = productos;
	}
	
	public Productos() {
		this.productos = new ArrayList();
	}
	
	public List<Producto> getProductos() {
		return productos;
	}
//a. obtener el número de elementos
	public Integer getNumeroProductos() {
		return productos.size();
	}
	
//b. agregar un elemento
	public void agregarProducto(Producto p) {
		productos.add(p);
	}
	
//c. agregar una coleccion de elementos
	public void agregarConjuntoProductos(List<Producto> conj) {
		productos.addAll(conj);
	}
	
//d. eliminar un elemento por id
	public void eliminarPorId(Integer numId) {
		for(Producto p: productos) {
			if(p.getId()==numId) {
				productos.remove(p);
			}
		}
	}
	
//1. existe
	public boolean productoValeMenos15() {
		for(Producto p: productos) {
			if(p.getOpenPrice()<15) {
				return true;
			}
		}
		return false;
	}
	
//2. contador
	public Integer productosFueraStock() {
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
		List<Producto> res = new ArrayList();
		for(Producto p: productos) {
			if(p.getCountry().contains(pais)) {
				res.add(p);
			}
		}
		return res;
	}
	
//4. método de agrupacion mediante map (claves:categoria, valores: SortedSet de tipo base)
	public Map<Category, SortedSet<Producto>> productosPorCategoría(){
	Map<Category, SortedSet<Producto>> res = new HashMap<Category, SortedSet<Producto>>();
	
	for(Producto p: productos) {
		Category categoria = p.getCategory();
		
		if(res.containsKey(categoria)) {
			res.get(categoria).add(p);
		}
		else {
			SortedSet<Producto> nuevoSet = new TreeSet<>();
			nuevoSet.add(p);
			res.put(categoria, nuevoSet);
		}
	}	
	return res;
	}
	
//5. método de acumulacion que devuelve un map (claves:propiedad tipo base, valores: conteo o suma de los objetos)
	public Map<String, Integer> stockDeProductos(){
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
}
