/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chpter_6;

/**
 *
 * @author WH1108
 */
public class Invoice {
    private int partNumber ;
    private String partDescription;
    private int quantity;
    private double price;
    public Invoice(int partNumber, String partDescription, int quantity, double price) {
        this.partNumber = partNumber;
        this.partDescription = partDescription;
        this.quantity = quantity;
        this.price = price;
    }

    public void setPartNumber(int partNumber) {
        this.partNumber = partNumber;
    }

    public void setPartDescription(String partDescription) {
        this.partDescription = partDescription;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getPartNumber() {
        return partNumber;
    }

    public String getPartDescription() {
        return partDescription;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
//        return "Invoice{" + "partNumber=" + partNumber + ", partDescription=" + partDescription + ", quantity=" + quantity + ", price=" + price + '}';
        return String.format("%-18d %-24s %-11d %8.2f", getPartNumber(),getPartDescription(),getQuantity(),getPrice());
    }
    
    
    
}
