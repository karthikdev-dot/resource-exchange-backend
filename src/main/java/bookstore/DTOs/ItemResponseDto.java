package bookstore.DTOs;

public class ItemResponseDto {

	private String thing;
	private String user;
	private Double price;
	private Double latitude;
	private Double longitude;
	private double distance;
	
	public ItemResponseDto(String thing, Double price, String user, Double latitude, Double longitude,double distance) {
	    this.thing = thing;
	    this.price = price;
	    this.user = user;
	    this.latitude = latitude;
	    this.longitude = longitude;
	    this.distance=distance;
	}

	public String getThing() {
		return thing;
	}
	public void setThing(String thing) {
		this.thing = thing;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Double getLatitude() {
		return latitude;
	}
	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}
	public Double getLongitude() {
		return longitude;
	}
	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	public double getDistance() {
		return distance;
	}

	public void setDistance(double distance) {
		this.distance = distance;
	}
	
}
