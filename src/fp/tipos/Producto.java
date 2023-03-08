package fp.tipos;

import java.time.LocalDate;
import java.util.Objects;

public class Producto  implements Comparable<Producto>{
	
	//Atributos basicos
	private Integer id;
	private LocalDate date;
	private Double openPrice, highPrice, lowPrice; 
	private Integer volume;
	private Boolean stock;
	private String country;
	private Category category;
	
	//Atributos compuestos
	public Double getVariability() {
		return highPrice-lowPrice;
	}
	public String getProductTitle() {
		return "El prodcucto con id: [" + id + "] tiene un precio de salida de " + openPrice + " € y solo se vende en " + country;
	}
	
	//Contstuctor C1 (todos los atributos)
	public Producto (Integer id, LocalDate date, Double openPrice, Double highPrice, Double lowPrice, Integer volume, Boolean stock, String country, Category category) {
		this.id = id;
		this.date = date;
		this.openPrice = openPrice;
		this.highPrice = highPrice;
		this.lowPrice = lowPrice;
		this.volume = volume;
		this.stock = stock;
		this.country = country;
		this.category = category;
	}

	//Constructor 2 (vacío)
	public Producto () {
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

	public void setOpenPrice(Double openPrice) {
		this.openPrice = openPrice;
	}

	public Double getHighPrice() {
		return highPrice;
	}

	public void setHighPrice(Double highPrice) {
		this.highPrice = highPrice;
	}

	public Double getLowPrice() {
		return lowPrice;
	}

	public void setLowPrice(Double lowPrice) {
		this.lowPrice = lowPrice;
	}

	public Integer getVolume() {
		return volume;
	}

	public void setVolume(Integer volume) {
		this.volume = volume;
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

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	//toString generado automaticamente por eclipse
	public String toString() {
		return "Producto [id=" + id + ", date=" + date + ", openPrice=" + openPrice + ", highPrice=" + highPrice
				+ ", lowPrice=" + lowPrice + ", volume=" + volume + ", stock=" + stock + ", country=" + country
				+ ", category=" + category + "]";
	}

	//hashCode generado automaticamente por eclipse
	public int hashCode() {
		return Objects.hash(id,openPrice,country);
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
		return category == other.category && Objects.equals(country, other.country) && Objects.equals(date, other.date)
				&& Objects.equals(highPrice, other.highPrice) && Objects.equals(id, other.id)
				&& Objects.equals(lowPrice, other.lowPrice) && Objects.equals(openPrice, other.openPrice)
				&& Objects.equals(stock, other.stock) && Objects.equals(volume, other.volume);
	}


	//Criterio de orden natural generado automaticamente
	public int compareTo(Producto p) {
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
	
// Solo quedan las restricciones (estan definidas en el README falta implementar)
	


