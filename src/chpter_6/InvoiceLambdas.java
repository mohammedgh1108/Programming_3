/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chpter_6;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 *
 * @author WH1108
 */
public class InvoiceLambdas {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Invoice[] arrayOfInvoice={
            new Invoice(83, "Electric sander", 7, 57.98),
            new Invoice(24, "Power saw", 18, 99.99),
            new Invoice(7, "Sledge hammer", 11, 21.50),
            new Invoice(77, "Hummer", 76, 11.99),
            new Invoice(39, "Lwwn mower", 3, 79.50),
            new Invoice(68, "Screwdriver", 106, 6.99),
            new Invoice(56, "Jig saw", 21, 11.00),
            new Invoice(3, "Wrench", 34, 7.50)
        };
        
        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/javadb",
                "root", "secret");
        
        PreparedStatement ps = connection.prepareStatement("delete from invoice");
        ps.executeUpdate();
        
        ps = connection.prepareStatement("insert into invoice values(?,?,?,?)");
        for (int i = 0; i < arrayOfInvoice.length; i++) {
            ps.setInt(1, arrayOfInvoice[i].getPartNumber());
            ps.setString(2, arrayOfInvoice[i].getPartDescription());
            ps.setInt(3, arrayOfInvoice[i].getQuantity());
            ps.setDouble(4, arrayOfInvoice[i].getPrice());
            ps.addBatch();
        }
        ps.executeBatch();
        
        ArrayList<Invoice> invoiceObjects = new ArrayList<>();
        ps = connection.prepareStatement("select * from invoice");
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            invoiceObjects.add(new Invoice(rs.getInt("partnumber"), rs.getString("partdescription"),
                    rs.getInt("quantity"), rs.getDouble("price")));
        }
        
        
        System.out.println("Sorting Invoice objects by PartDescription\n"); 
        System.out.printf("%-18s %-24s %-10s %10s","Part Number","Part Description","Quantity","Price\n");
        invoiceObjects.stream().sorted(Comparator.comparing(Invoice::getPartDescription)).forEach(System.out::println);
        
        
        System.out.println("======================================");
        System.out.println("\nSorting Invoice objects by Price\n");
        System.out.printf("%-18s %-24s %-10s %10s","Part Number","Part Description","Quantity","Price\n");
        invoiceObjects.stream().sorted(Comparator.comparing(Invoice::getPrice)).forEach(System.out::println);
        
        
        System.out.println("======================================");
        System.out.println("\nInvoice Maped to PartDescription and Quantity and sorted by Quantity,\n");
        invoiceObjects.stream().sorted(Comparator.comparing(Invoice::getQuantity))
                .map(invoice -> String.format("Description: %-15s  Quantity: %-4d", invoice.getPartDescription(),invoice.getQuantity())).forEach(System.out::println);
        
        
        System.out.println("======================================");
        System.out.println("\nInvoice Maped to PartDescription and Value and sorted by Value,\n");
        invoiceObjects.stream().sorted(Comparator.comparing(i->i.getQuantity()*i.getPrice()))
                .map(i->String.format("Description: %-15s  Value: %-4f",i.getPartDescription(),(i.getPrice()*i.getQuantity()))).forEach(s->System.out.println(s));
        
        
        System.out.println("======================================");
        System.out.println("\nInvoice Maped to PartDescription and Value and sorted by Value in the range $200 to $500.,\n");
        invoiceObjects.stream().filter(i->((i.getPrice()*i.getQuantity())>200)&&((i.getPrice()*i.getQuantity())<500)).sorted(Comparator.comparing(i->i.getQuantity()*i.getPrice()))
                .map(i->String.format("Description: %-15s  Value: %-4f",i.getPartDescription(),(i.getPrice()*i.getQuantity()))).forEach(s->System.out.println(s));
    }
}
