package fp.tipos.test;

import fp.tipos.FactoriaProductos;
import fp.tipos.Productos;

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

}
