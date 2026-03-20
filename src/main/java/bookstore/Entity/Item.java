package bookstore.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import jakarta.persistence.GenerationType;
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name ="items")
public class Item {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;

private String itemName;
private Double price;
private Double itemlatitude;
private Double itemlongitude;
private Boolean available;
public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
public String getItemName() {
	return itemName;
}
public void setItemName(String itemName) {
	this.itemName = itemName;
}

public Double getItemlatitude() {
	return itemlatitude;
}
public void setItemlatitude(Double itemlatitude) {
	this.itemlatitude = itemlatitude;
}
public Double getItemlongitude() {
	return itemlongitude;
}
public void setItemlongitude(Double itemlongitude) {
	this.itemlongitude = itemlongitude;
}
public Registerentity getUser() {
	return user;
}
public void setUser(Registerentity user) {
	this.user = user;
}
public Boolean getAvailable() {
	return available;
}
public void setAvailable(Boolean available) {
	this.available = available;
}
public Double getPrice() {
	return price;
}
public void setPrice(Double price) {
	this.price = price;
}
@ManyToOne(fetch = FetchType.LAZY)
@JoinColumn(name="user_id")
private Registerentity user;
}
