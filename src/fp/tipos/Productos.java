package fp.tipos;

import java.util.ArrayList;
import java.util.List;

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
	
}
