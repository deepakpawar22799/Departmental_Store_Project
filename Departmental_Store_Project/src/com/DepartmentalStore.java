package com;

import java.util.LinkedHashMap;
import java.util.Scanner;
import java.util.Set;

public class DepartmentalStore {

	//key -> product id -> Integer & value -> Product Instance ->product
	LinkedHashMap<Integer, Product> db=new LinkedHashMap<Integer, Product>();
	Scanner scan = new Scanner(System.in);
	int totalBill=0;

	void addProduct() {
		db.put(1, new Product("Chocolates", 10, 5));
		db.put(2, new Product("Biscuits", 20, 10));
		db.put(3, new Product("IceCream", 30, 20));
	}

	void displayProduct() {
		Set<Integer> keys = db.keySet();//1  2  3 
         for(int key: keys) {
        	 Product p = db.get(key);
        	 System.out.println("Enter "+key+" to order "+p.getName());
        	 System.out.println("Available Quantity:"+p.getQuantity());
        	 System.out.println("Product Cost: Rs."+p.getCost());
        	 System.out.println("-------------------------------");
         }
	}

	void buyProduct() {
		System.out.println("Enter Choice:");
		int choice = scan.nextInt();//1  2  3  -> choice -> key
		
		//getting the product based on choice &returns null when key is not present
		Product p =db.get(choice);
		
		if(p!=null) {
			System.out.println("Enter Quantity");
			int quantity=scan.nextInt();
			
			if(quantity <= p.getQuantity()) {
				//calculating current product cost
				int productCost = quantity *p.getCost();
				
				//add current product cost to Total Bill
				totalBill = totalBill + productCost;//totalBill += productCost;
				
				//update the new Quantity
				p.setQuantity(p.getQuantity() - quantity);
				
				System.out.println("Order "+quantity+" "+p.getName());
				System.out.println("Product Cost: "+productCost);
				System.out.println("Total Bill as of now : "+totalBill);
			
			}	
			else {
				System.out.println("Invalid Quantity"); // InvalidQuantityException
			}
			
			
		}
		else {
			System.out.println("Invalid Choice"); // InvalidChoiceException
		}

	}

	void checkout() {
		System.out.println("Total Bill: Rs."+totalBill);
		System.out.println("Thank you for shopping");

	}

}
