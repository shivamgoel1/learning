	package com.model.product;

public class Product {
 
String category,name,description,brand;
float rating,price;
public Product(String category, String name, String description, String brand, float rating, float price, int id ) {
	super();
	this.category = category;
	this.name = name;
	this.description = description;
	this.brand = brand;
	this.rating = rating;
	this.price = price;
	this.id = id;
}
public Product(String category, String name, String description, String brand, float rating, float price) {
	super();
	this.category = category;
	this.name = name;
	this.description = description;
	this.brand = brand;
	this.rating = rating;
	this.price = price;
}
public Product(String category, String name, String brand, float rating) {
	super();
	this.category = category;
	this.name = name;
	this.brand = brand;
	this.rating = rating;
}



public Product(String category, String name, String brand, float rating, int id) {
	super();
	this.category = category;
	this.name = name;
	this.brand = brand;
	this.rating = rating;
	this.id = id;
}



public Product(String description, float price) {
	super();
	this.description = description;
	this.price = price;
}



int id;
public String getCategory() {
	return category;
}
public void setCategory(String category) {
	this.category = category;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
public String getBrand() {
	return brand;
}
public void setBrand(String brand) {
	this.brand = brand;
}
public float getRating() {
	return rating;
}
public void setRating(float rating) {
	this.rating = rating;
}
public float getPrice() {
	return price;
}
public void setPrice(float price) {
	this.price = price;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
	
}
