package fp.tipos;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

import fp.utiles.Checkers;

public class Producto   implements Comparable<Producto>{
	
	//Atributos basicos
	private Integer id;
	private LocalDate date;
	private Double openPrice;
	private Prices prices;
	private Integer volume;
	private Boolean stock;
	private String country;
	private List<Category> category;
	
	public String getProductTitle() {
		return "El prodcucto con id: [" + id + "] tiene un precio de salida de " + openPrice + " € y solo se vende en " + country;
	}
	
	//Contstuctor C1 (todos los atributos)
	public Producto  (Integer id, LocalDate date, Double openPrice, Double highPrice, Double lowPrice, Integer volume, Boolean stock, String country, List<Category> category) {
		this.id = id;
		this.date = date;
		this.openPrice = openPrice;
		this.prices = new Prices(highPrice,lowPrice);
		this.volume = volume;
		this.stock = stock;
		this.country = country;
		this.category = category;
		Checkers.check("El precio de salida no puede ser menor a 0: " + openPrice, openPrice>=0.0);
		Checkers.check("El volumen de venta no puedes ser negativo: " + volume, volume>=0);
		
	}
	
	//contructor C2 
	public Producto (Integer id, Double openPrice, String country){
		
	}
	
	
	//Getters and Setters generados automaticamente mediante eclipse
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public Double getOpenPrice() {
		return openPrice;
	}

	public Prices getPrices() {
		return prices;
	}

	public void setPrices(Prices prices) {
		this.prices = prices;
	}

	public void setOpenPrice(Double openPrice) {
		this.openPrice = openPrice;
		Checkers.check("El precio de salida no puede ser menor a 0: " + openPrice, openPrice>0);
	}

	public Integer getVolume() {
		return volume;
	}

	public void setVolume(Integer volume) {
		this.volume = volume;
		Checkers.check("El volumen de venta no puedes ser negativo: " + volume, volume>=0);
	}

	public Boolean getStock() {
		return stock;
	}

	public void setStock(Boolean stock) {
		this.stock = stock;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public List<Category> getCategory() {
		return category;
	}

	public void setCategory(List<Category> category) {
		this.category = category;
	}

	//toString generado automaticamente por eclipse
	public String toString() {
		return "Producto [id=" + id + ", date=" + date + ", openPrice=" + openPrice + ", prices=" + prices + ", volume="
				+ volume + ", stock=" + stock + ", country=" + country + ", category=" + category + "]";
	}

	public int hashCode() {
		return Objects.hash(category, country, date, id, openPrice, prices, stock, volume);
	}

	//Equals generado automaticamente mediante eclipse
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Producto other = (Producto) obj;
		return Objects.equals(category, other.category) && Objects.equals(country, other.country)
				&& Objects.equals(date, other.date) && Objects.equals(id, other.id)
				&& Objects.equals(openPrice, other.openPrice) && Objects.equals(prices, other.prices)
				&& Objects.equals(stock, other.stock) && Objects.equals(volume, other.volume);
	}	


	//Criterio de orden natural generado automaticamente
	public int compareTo(Producto  p) {
		int v;
		if (p == null) {
			throw new NullPointerException();
		}
		v = getId().compareTo(p.getId());
		if (v==0) {
			v = getOpenPrice().compareTo(p.getOpenPrice());
		}
		else if (v==0) {
			v=getCountry().compareTo(p.getCountry());
			}
		return v;
	}

	
}
	

	


