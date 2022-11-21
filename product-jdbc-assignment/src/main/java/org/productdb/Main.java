package org.productdb;

import org.productdb.Model.Product;
import org.productdb.Repo.ProductRepo;
import org.productdb.Repo.ProductRepoImp;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ProductRepo productRepo = new ProductRepoImp();
        int choice;
        Scanner scan = new Scanner(System.in);
        Product product;
        int productId;

        do {
            System.out.println("1->Add 2->Modify 3->Delete 4->Display 6->Exit");
            choice = scan.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Enter details : ");
                    product = new Product(scan.nextInt(), scan.next(), scan.nextFloat());
                    if (productRepo.addProduct(product)) {
                        System.out.println("Record inserted successfully");
                    } else {
                        System.out.println("Record not saved");
                    }
                    break;

                case 2:
                    System.out.println("Enter product ID to modify : ");
                    productId = scan.nextInt();
                    product = productRepo.findById(productId);
                    if (product == null) {
                        System.out.println("Record not found");
                    } else {
                        System.out.println("Existing data : " + product);
                        System.out.println("Enter name and quantity for modification :");
                        product.setProductName(scan.next());
                        product.setProductQty(scan.nextFloat());

                        if (productRepo.updateProduct(product)) {
                            System.out.println("Record modified successfully");
                        } else {
                            System.out.println("Record not modified");
                        }
                    }
                    break;

                case 3:
                    System.out.println("Enter product ID to delete : ");
                    productId = scan.nextInt();
                    product = productRepo.findById(productId);
                    if (product == null) {
                        System.out.println("Record not found");
                    } else {
                        System.out.println("Delete record : " + product);

                        if (productRepo.deleteById(productId)) {
                            System.out.println("Record deleted successfully");
                        } else {
                            System.out.println("Record not deleted");
                        }
                    }
                    break;

                case 4:
                    List<Product> list = productRepo.findAll();
                    for (Product p : list) {
                        System.out.println(p);
                    }
                    break;

                case 6:
                    break;
            }

        } while (choice != 6);
        productRepo.closeConnection();
    }
}
