import java.io.*;
import java.util.*;


class ExceptionHandling{
	Scanner sc = new Scanner(System.in);
	
	int takeInput() {
		int ans = 0;
		while(true) {
			try {
				ans = Integer.parseInt(sc.next());
				break;
			}
			catch(NumberFormatException e) {
				System.out.println(e);
				System.out.println("Invalid Input!!\nEnter valid  input : ");
			}
		}
		return ans;
	}
}


class Products{
	String productName;
	double costPrice, sellPrice;
	int StockAvailable, TotalSold;
	
	Products(String productName, double costPrice, double sellPrice, int StockAvailable){
		this.productName = productName;
		this.costPrice = costPrice;
		this.sellPrice = sellPrice;
		this.StockAvailable = StockAvailable;
	}
}


public class Inventory {
	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		int op = 1, op1 = 1, op2 = 1;
		String pName;
		double costPrice, sellPrice, sp = 0, cp = 0;
		int n = 0;
		
		ExceptionHandling eh = new ExceptionHandling();
		ArrayList<Products>arr = new ArrayList<>();
		
		while(op!=0) {
			System.out.println("\nINVENTORY MANAGEMENT SYSTEM");
			System.out.println("1. For Seller");
			System.out.println("2. For Customer");
			System.out.println("*. Press any other key to exit");
			
			op = eh.takeInput();
			
			switch(op) {
			case 1:
				op1 = 1;
				while(op1!=0) {
					System.out.println("\nSELLER");
					System.out.println("1. Add Product");
					System.out.println("2. Balance Stock");
					System.out.println("3. Loss and Profit Calculation");
					System.out.println("*. Press any other key to go to the main menu");
					
					op1 = eh.takeInput();
					
					switch(op1) {
					case 1:
						pName = "";
						System.out.println("Enter Product Name : ");
						while(pName.isEmpty()) {
							pName = sc.nextLine();
						}
						System.out.println("Enter the cost price : ");
						costPrice = sc.nextDouble();
						System.out.println("Enter the selling price : ");
						sellPrice = sc.nextDouble();
						System.out.println("Enter the number of items you want to add : ");
						n = eh.takeInput();
						
						Products p = new Products(pName, costPrice, sellPrice, n); 
						arr.add(p);
						break;
					case 2:
						System.out.println("Product\tStock\n");
						for(Products it : arr) {
							System.out.println(it.productName + "\t" + it.StockAvailable);
						}
						break;
					case 3:
						if (sp == cp) {
							System.out.println("No Profit or Loss");
						}
						else if (sp < cp) {
							System.out.println("Loss : " + (cp-sp));
							System.out.println("Loss% : " + 100*(cp-sp)/cp);
						}
						else {
							System.out.println("Profit : " + (sp-cp));
							System.out.println("Profit% : " + 100*(sp-cp)/cp);
						}
						break;
					default:
						op1 = 0;
						break;
					}
				}
				break;
			case 2:
				op2 = 1;
				while(op2!=0) {
					System.out.println("\nCUSTOMER");
					System.out.println("1. List of all Products");
					System.out.println("2. Display Individual Product Information");
					System.out.println("3. Purchase");
					System.out.println("*. Press any other key to go to the main menu");
					
					op2 = eh.takeInput();
					
					switch(op2) {
					case 1:
						int ind = 1;
						System.out.println("S.No\tProduct\tPrice\n");
						for(Products it : arr) {
							System.out.println(ind + ".\t" + it.productName + "\t" + it.costPrice);
							ind++;
						}
						break;
						
					case 2:
						System.out.println("Enter the serial number of the product you want to see : ");
						n = eh.takeInput();
						
						Products p = null;
						
						try {
							p = arr.get(n-1);
						}
						catch(Exception e) {
							System.out.println("Invalid Index!!\n");
							break;
						}
						
						System.out.println("Product Name : " + p.productName + "\nSelling Price : " + p.sellPrice + "\nStock Available : " + p.StockAvailable);
						break;
						
					case 3:
						System.out.println("Enter the serial number of the product you want to purchase : ");
						n = eh.takeInput();
						
						Products q = null;
						try {
							q = arr.get(n-1);
						}
						catch(Exception e) {
							System.out.println("Invalid Index!!\n");
							break;
						}
						
						System.out.println("Product Name : " + q.productName + "\nSell Price : " + q.sellPrice);
						
						System.out.println("Enter the number of items you want to purchase : ");
						n = eh.takeInput();
					
						if (n > q.StockAvailable) {
							System.out.println("Only " + q.StockAvailable + " items left!!");
						}
						else {
							sp += n*q.sellPrice;
							cp += n*q.costPrice;
							System.out.println("Order placed successfully!!\n BILL : Rs " + n*q.sellPrice + "\nReceipt Generated : Bill.txt");
							q.StockAvailable-=n;
							
							String file = "Bill.txt";
							String s = "Item Name : " + q.productName + "  Quantity : " + n + "  Cost of 1 item : " + q.sellPrice + "  Total Cost : " + n*q.sellPrice; 
							try {
								FileWriter writer = new FileWriter(file);
								writer.write(s + "\n");
								writer.close();
							} catch (IOException e) {
								System.out.println(e);
							}
						}
						break;

					default:
						op2 = 0;
						break;
					}
				}
				break;
			default:
				op = 0;
				break;
			}
		}
	}

}
