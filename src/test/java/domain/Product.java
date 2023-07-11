package domain;

public class Product {

    private Object title;
    private Object description;
    private Object price;
    private Object discountPercentage;
    private Object rating;
    private Object stock;
    private Object brand;
    private Object category;
    private Object thumbnail;

    public Product() {
        title = "";
        description = "";
        price = 0;
        discountPercentage = 0.0;
        rating = 0.00;
        stock = 00;
        brand = "0";
        category = "0";
        thumbnail = "";
    }

    public Product(Object title, Object description, Object price, Object discountPercentage, Object rating, Object stock, Object brand, Object category, Object thumbnail) {
        this.title = title;
        this.description = description;
        this.price = price;
        this.discountPercentage = discountPercentage;
        this.rating = rating;
        this.stock = stock;
        this.brand = brand;
        this.category = category;
        this.thumbnail = thumbnail;
    }



    public Object getTitle() {
        return title;
    }

    public void setTitle(Object title) {
        this.title = title;
    }

    public Object getDescription() {
        return description;
    }

    public void setDescription(Object description) {
        this.description = description;
    }

    public Object getPrice() {
        return price;
    }

    public void setPrice(Object price) {
        this.price = price;
    }

    public Object getDiscountPercentage() {
        return discountPercentage;
    }

    public void setDiscountPercentage(Object discountPercentage) {
        this.discountPercentage = discountPercentage;
    }

    public Object getRating() {
        return rating;
    }

    public void setRating(Object rating) {
        this.rating = rating;
    }

    public Object getStock() {
        return stock;
    }

    public void setStock(Object stock) {
        this.stock = stock;
    }

    public Object getBrand() {
        return brand;
    }

    public void setBrand(Object brand) {
        this.brand = brand;
    }

    public Object getCategory() {
        return category;
    }

    public void setCategory(Object category) {
        this.category = category;
    }

    public Object getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(Object thumbnail) {
        this.thumbnail = thumbnail;
    }

}
