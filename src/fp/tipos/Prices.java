package fp.tipos;

import fp.utiles.Checkers;

public record Prices(Double highPrice, Double lowPrice) {
	
	public Prices {
		Checkers.check("El precio más alto debe ser igual o mayor al precio más bajo: " + highPrice+ " < " + lowPrice, highPrice>=lowPrice);
	}
	
	public Double getVariability() {
		return highPrice-lowPrice;
	}
	
}
