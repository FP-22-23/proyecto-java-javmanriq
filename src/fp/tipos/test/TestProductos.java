package fp.tipos.test;

import fp.tipos.FactoriaProductos;
import fp.tipos.Producto;
import fp.tipos.Productos;
import java.util.List;
import java.util.Map;
import java.util.SortedSet;


public class TestProductos {

	public static void main(String[] args) {
		Productos productos = FactoriaProductos.leeProductos("data/Amazon_stocks1.csv");
		
		System.out.println("\ntestProductoValeMenosx");
		System.out.println("===================================");
		testProductoValeMenosx(productos, 30);
		testProductoValeMenosx(productos, 40);
		System.out.println("===================================");
		System.out.println();
		System.out.println("\ntestProductoValeMenosx");
		System.out.println("===================================");
		testProductosFueraStock(productos);
		System.out.println("===================================");
		System.out.println();
		System.out.println("\ntestFiltrarPorPais");
		System.out.println("===================================");
		testFiltrarPorPais(productos,"Spain");
		System.out.println("===================================");
		System.out.println();
		System.out.println("\ntestProductosPorPais");
		System.out.println("===================================");
		testProductosPorPais(productos);
		System.out.println("===================================");
		System.out.println();
		System.out.println("\ntestStockDeProductos");
		System.out.println("===================================");
		testStockDeProductos(productos);
		System.out.println("===================================");
		System.out.println();
		

	}
	
	private static void testProductoValeMenosx (Productos productos, Integer x) {
		try {
				boolean res = productos.productoValeMenosx(x);
				System.out.println("Menos de " + x + ": " + res);
		} catch (Exception e) {
			System.err.println("Excepcion capturada: " + e.getMessage());
		}
		
	}
	
	private static void testProductosFueraStock(Productos productos) {
		try {
				Integer res = productos.productosFueraStock();
				System.out.println("Existen " + res + " productos fuera de Stock");
		} catch (Exception e) {
			System.err.println("Excepcion capturada: " + e.getMessage());
		}
			
	}
	
	private static void testFiltrarPorPais(Productos productos, String pais) {
		try {
			List<Producto> p = productos.filtrarPorPais(pais);
			for (Producto a : p) {
				System.out.println(a);
			}
		} catch (Exception e) {
			System.err.println("Excepcion capturada: " + e.getLocalizedMessage());
		}
	}
	
	private static void testProductosPorPais(Productos productos) {
		try {
			Map<String, SortedSet<Producto>> m = productos.productosPorPais();
			for (String s : m.keySet()) {
				System.out.println(s + ":" + m.get(s));
			}
		} catch (Exception e) {
			System.err.println("Excepcion capturada: " + e.getLocalizedMessage());
		}
	}
	
	private static void testStockDeProductos(Productos productos) {
		try {
			Map<String, Integer> m = productos.stockDeProductos();
			System.out.println(m);
		} catch (Exception e) {
			System.err.println("Excepcion capturada: " + e.getLocalizedMessage());
			
		}
	}

}
