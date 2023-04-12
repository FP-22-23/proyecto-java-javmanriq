package fp.tipos;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FactoriaProductos {
	
	public static Productos leeProductos(String nomfich) {
		Productos res=null;
		try {
			List<Producto> productos=Files.lines(Paths.get(nomfich))
									.skip(1)
									.map(FactoriaProductos::parsearProducto)
									.collect(Collectors.toList());
			
			res = new Productos(productos);
		} catch(IOException e) {
			System.out.println("Fichero no encontrado: " + nomfich);
			e.printStackTrace();
		}
		return res;							
	}
	
	private static Producto parsearProducto(String linea) {
		String[] trozos=linea.split(";");
		try {
			Integer id = Integer.valueOf(trozos[0].trim());
			LocalDate date = LocalDate.parse(trozos[1].trim(), DateTimeFormatter.ofPattern("MM dd YYYY"));
			Double openPrice = Double.valueOf(trozos[2].trim());
			Double highPrice = Double.valueOf(trozos[3].trim());
			Double lowPrice = Double.valueOf(trozos[4].trim());
			Integer volume = Integer.valueOf(trozos[5].trim());
			Boolean stock = parseaBoolean(trozos[6].trim());
			String country = trozos[7].trim();
			List<Category> category = parseaCategory(trozos[8].trim());
			
			return new Producto(id ,date ,openPrice ,highPrice, lowPrice ,volume ,stock ,country ,category);
		}
		catch(Exception ex) {
			System.out.println("Problema: " + ex.getMessage());
			return null;
		}
	}
	
	private static Boolean parseaBoolean(String cadena) {
		Boolean res = null;
		cadena=cadena.toUpperCase();
		if(cadena.equals("true")) {
			res = true;
		}
		else {
			res = false;
		}
		return res;
	}
	
	private static List<Category> parseaCategory(String s) {
		String[] trozos=s.split(" ");
		List<Category> res = new ArrayList<>();
		
		for(String t :trozos) {
			if(t.equals("Tools")) {
				t = "Tools";
			}
			Category c = Category.valueOf(t);
			res.add(c);
		}
		return res;
	}
	
	
}
