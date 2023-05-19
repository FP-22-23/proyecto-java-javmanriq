package fp.tipos.test;

import java.time.LocalDate;
import java.util.List;

import fp.tipos.*;

public class TestProducto {
	
	public static void mostrarProducto(Producto p) {
		System.out.println(p);
		System.out.println("getVariability: " + p.getPrices().getVariability());
		System.out.println("getProductTitle: " + p.getProductTitle());
	}
	
	public static void testConstructor1(Integer id, LocalDate date, Double openPrice, Double highPrice, Double lowPrice, Integer volume, Boolean stock, String country, List<Category> category) {
		try {
			Producto p = new Producto(id,date,openPrice,highPrice,lowPrice,volume,stock,country,category);
			mostrarProducto(p);
		}catch(IllegalArgumentException e) {
			System.out.println("Excepcion capturada:\n" + e);
		}catch(Exception e) {
			System.out.println("Excepcion capturada:\n" + e);
		}
	}
	
	public static void testConstructor2(Integer id, Double openPrice, String country) {
		try {
			Producto p = new Producto(id,openPrice,country);
			mostrarProducto(p);
		}catch(IllegalArgumentException e) {
			System.out.println("Excepcion capturada:\n" + e);
		}catch(Exception e) {
			System.out.println("Excepcion capturada:\n" + e);
		}
	}

	public static void main(String[] args) {
		List<Category> category = List.of(Category.Books);
		LocalDate date=LocalDate.of(2010, 5, 7);
		
		Integer i = 1;
		System.out.println("=======================");
		System.out.println("Constructor 1 - Caso de prueba " + i);
		testConstructor1(2, date, 20.35, 25.80, 18.50, 35000, true, "Portugal", category);
		
		i++;
		System.out.println("=======================");
		System.out.println("Constructor 1 - Caso de prueba " + i);
		testConstructor1(3, date, -8.6, -7.50, -10.50, 35000, true, "Portugal", category);
	
	
		i++;
		System.out.println("=======================");
		System.out.println("Constructor 1 - Caso de prueba " + i);
		testConstructor1(2, date, 20.35, 19.80, 22.50, 35000, true, "Portugal", category);
	
		
		i++;
		System.out.println("=======================");
		System.out.println("Constructor 1 - Caso de prueba " + i);
		testConstructor1(2, date, 20.35, 25.80, 18.50, -200, true, "Portugal", category);
		
		i++;
		System.out.println("==========================================");
		System.out.println("Constructor 2 - Caso de prueba " + i);
		testConstructor2(2,20.35, "Portugal");
		}
}


	


