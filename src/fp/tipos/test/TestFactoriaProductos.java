package fp.tipos.test;

import fp.tipos.FactoriaProductos;
import fp.tipos.Productos;

public class TestFactoriaProductos {
	public static void main(String[] args) {
		testLeeProductos("data/Amazon_stocks1.csv");
	}
	
	private static void testLeeProductos(String fichero) {
		System.out.println("\nTestLeeProductos ==============");
		Productos productos = FactoriaProductos.leeProductos(fichero);
		System.out.println(" Productos: " + productos);
	}

}
