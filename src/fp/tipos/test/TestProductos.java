package fp.tipos.test;

import fp.tipos.Category;
import fp.tipos.FactoriaProductos;
import fp.tipos.Producto;
import fp.tipos.Productos;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.SortedSet;


public class TestProductos {

	public static void main(String[] args) {
		Productos productos = FactoriaProductos.leeProductos("data/Amazon_Stocks.csv");
		
		System.out.println("\ntestProductoValeMenosx");
		System.out.println("===================================");
		testProductoValeMenosx(productos, 30);
		testProductoValeMenosx(productos, 40);
		System.out.println("===================================");
		System.out.println("\ntestProductoValeMenosxStream");
		System.out.println("===================================");
		testProductoValeMenosxStream(productos, 30);
		testProductoValeMenosxStream(productos, 40);
		System.out.println("===================================");
		System.out.println("\ntestProductosFueraStock");
		testProductosFueraStock(productos);
		System.out.println("===================================");
		System.out.println();
		System.out.println("\ntestProductosFueraStockStream");
		testProductosFueraStockStream(productos);
		System.out.println("===================================");
		System.out.println();
		System.out.println("\ntestFiltrarPorPais");
		System.out.println("===================================");
		testFiltrarPorPais(productos,"Spain");
		System.out.println();
		System.out.println("\ntestFiltrarPorPaisStream");
		System.out.println("===================================");
		testFiltrarPorPaisStream(productos,"Spain");
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
		System.out.println("\ntestMinimoVolumenVentasPortugal");
		System.out.println("===================================");
		testMinimoVolumenVentasPortugal(productos);
		System.out.println("===================================");
		System.out.println();
		System.out.println("\ntestIdPorVolumenVentasJapon");
		System.out.println("===================================");
		testIdPorVolumenVentasJapon(productos);
		System.out.println("===================================");
		System.out.println();
		System.out.println("\ntestProductosPorPaisStream");
		System.out.println("===================================");
		testProductosPorPaisStream(productos);
		System.out.println("===================================");
		System.out.println();
		System.out.println("\ntestPrecioMaximoPorCategoria");
		System.out.println("===================================");
		testPrecioMaximoPorCategoria(productos);
		System.out.println("===================================");
		System.out.println();
		System.out.println("\ntestPrecioMinimoPorPais");
		System.out.println("===================================");
		testPrecioMinimoPorPais(productos);
		System.out.println("===================================");
		System.out.println();
		System.out.println("\ntestnPreciosMasBajosPorPais");
		System.out.println("===================================");
		testnPreciosMasBajosPorPais(productos,2);
		System.out.println("===================================");
		System.out.println();
		System.out.println("\ntestPaisMasProductos");
		System.out.println("===================================");
		testPaisMasProductos(productos);
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
	
	private static void testProductoValeMenosxStream (Productos productos, Integer x) {
		try {
				boolean res = productos.productoValeMenosxStream(x);
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
	
	private static void testProductosFueraStockStream(Productos productos) {
		try {
				Long res = productos.productosFueraStockStream();
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
	
	private static void testFiltrarPorPaisStream(Productos productos, String pais) {
		try {
			List<Producto> res = productos.filtrarPorPais(pais);
			System.out.println(res);
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
	
	private static void testMinimoVolumenVentasPortugal(Productos productos) {
		try {
				Producto res = productos.minimoVolumenVentasPortugal();
				System.out.println("El minimo volumen de ventas de un producto en Portugal es: " + res );
		} catch (Exception e) {
			System.err.println("Excepcion capturada: " + e.getMessage());
		}
			
	}
	
	private static void testIdPorVolumenVentasJapon(Productos productos) {
		try {
				List<Integer> res = productos.idPorVolumenVentasJapon();
				System.out.println(res);
		} catch (Exception e) {
			System.err.println("Excepcion capturada: " + e.getMessage());
		}
			
	}
	
	private static void testProductosPorPaisStream(Productos productos) {
		try {
			Map<String, List<Producto>> m = productos.productosPorPaisStream();
			for (String s : m.keySet()) {
				System.out.println(s + ":" + m.get(s));
			}
		} catch (Exception e) {
			System.err.println("Excepcion capturada: " + e.getLocalizedMessage());
		}
	}
	
	private static void testPrecioMaximoPorCategoria(Productos productos) {
		try {
			Map<List<Category>, Object> m = productos.precioMaximoPorCategoria();
				System.out.println(m);
		} catch (Exception e) {
			System.err.println("Excepcion capturada: " + e.getLocalizedMessage());
		}
	}
	
	private static void testPrecioMinimoPorPais(Productos productos) {
		try {
			Map<String, Object> m = productos.precioMinimoPorPais();
				System.out.println(m);
		} catch (Exception e) {
			System.err.println("Excepcion capturada: " + e.getLocalizedMessage());
		}
	}
	
	private static void testnPreciosMasBajosPorPais(Productos productos, Integer n) {
		try {
			SortedMap<String, List<Producto>> res = productos.nPreciosMasBajosPorPais(n);
				System.out.println(res);
		} catch (Exception e) {
			System.err.println("Excepcion capturada: " + e.getLocalizedMessage());
		}
	}
	
	private static void testPaisMasProductos(Productos productos) {
		try {
			String res = productos.paisMasProductos();
				System.out.println(res);
		} catch (Exception e) {
			System.err.println("Excepcion capturada: " + e.getLocalizedMessage());
		}
	}


}
