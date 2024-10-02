package studentcrud;

public class Product {
private int id;
private String brand;
private double price;
private double discount;


public Product(int id, String brand, double price, double discount) {
	super();
	this.id = id;
	this.brand = brand;
	this.price = price;
	this.discount = discount;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getBrand() {
	return brand;
}
public void setBrand(String brand) {
	this.brand = brand;
}
public double getPrice() {
	return price;
}
public void setPrice(double price) {
	this.price = price;
}
public double getDiscount() {
	return discount;
}
public void setDiscount(double discount) {
	this.discount = discount;
}
@Override
public String toString() {
	return "Product [id=" + id + ", brand=" + brand + ", price=" + price + ", discount=" + discount + "]";
}

}
