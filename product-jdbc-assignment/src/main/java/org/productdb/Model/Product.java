package org.productdb.Model;

public class Product {
    private int productId;
    private String productName;
    private float productQty;

    public Product() {
    }

    public Product(int productId, String productName, float productQty) {
        this.productId = productId;
        this.productName = productName;
        this.productQty = productQty;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public float getProductQty() {
        return productQty;
    }

    public void setProductQty(float productQty) {
        this.productQty = productQty;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", productName='" + productName + '\'' +
                ", productQty=" + productQty +
                '}';
    }
}
