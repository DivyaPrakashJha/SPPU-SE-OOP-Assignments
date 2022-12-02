import java.util.*;

class Publication{
	String title;
	double price;
	int copies;
	
	static int totalBooksSold, totalMagSold, BooksWorth, MagWorth;
	
	Publication(){
		totalBooksSold = 0;
		totalMagSold = 0;
		BooksWorth = 0;
		MagWorth = 0;
	}
	
	void sellCopy() {
		 System.out.println("Number of Publications Sold : " + (totalBooksSold + totalMagSold) );
		 System.out.println("Total Cost of sold Publications : Rs" + (BooksWorth + MagWorth));
		 System.out.println("Number of Books Sold : " + totalBooksSold);
		 System.out.println("Total Cost of sold Books : Rs" + BooksWorth);
		 System.out.println("Number of Magazines Sold : " + totalMagSold);
		 System.out.println("Total Cost of sold Magazines : Rs" + MagWorth);
	}
};

class Book extends Publication{
	String author;
	int totalSold = 0;
	
	Book(){}
	Book(String a, double b, int c){
		title = a;
		price = b;
		copies = c;
	}
	
	void getAuthor(String a) {
		author = a;
	}

	
	void OrderCopies(int n) {
		if (n > copies) {
			System.out.println("Only " + copies + " copies left!");
		}
		else {
			copies -= n;
			totalSold += n;
			totalBooksSold += n;
			BooksWorth += n*price;
			System.out.println("Total Price : " + n * price);
			System.out.println("Order Placed Successfully");
		}
	}
	void RestockCopies(int n) {
		copies += n;
		System.out.println(n + " copies added to the stock");
		System.out.println("No. of Copies in stock : " + copies);
	}
	
	
	void sellCopy() {
		System.out.println("Total Books Sold : " + totalSold);
		System.out.println("Books Sold Worth : Rs" + totalSold*price);
	}
};

class Magazine extends Publication{
	int curIssue;
	int totalSold = 0;
	
	Magazine(){}
	Magazine(String a, double b, int c){
		title = a;
		price = b;
		copies = c;
	}
	
	void getCurIssue(int b) {
		curIssue = b;
	}
	
	void OrderCopies(int n) {
		if (n > copies) {
			System.out.println("Only " + copies + " copies left");
		}
		else {
			copies -= n;
			totalSold += n;
			totalMagSold += n;
			MagWorth += n*price;
			System.out.println("Total Price : " + n * price);
			System.out.println("Order Placed Successfully");
		}
	}
	
	void RestockCopies(int n) {
		copies += n;
		System.out.println(n + " copies added to the stock");
		System.out.println("No. of Copies in stock : " + copies);
	}
	
	void sellCopy() {
		System.out.println("Total Magazines Sold : " + totalSold);
		System.out.println("Magazines Sold Worth : Rs" + totalSold*price);
	}
};

public class Polymorphism {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		
		Publication p = new Publication();
		Book b = new Book();
		Magazine m = new Magazine();
		
		String title;
		double price;
		int copies;
		
		String author;
		int curIssue;
		
		int ord, res;
		
		
		boolean run = true;
		int op = 0;
		while(run) {
			System.out.println("\n1. Add Book");
			System.out.println("2. Add Magazine");
			System.out.println("3. Order Books");
			System.out.println("4. Order Magazine");
			System.out.println("5. Restock Books");
			System.out.println("6. Restock Magazines");
			System.out.println("7. Sale of Books");
			System.out.println("8. Sale of Magazines");
			System.out.println("9. Sale of Publication");
			System.out.println("0. Exit\n");
			
			op = sc.nextInt();
			
			switch(op) {
			case 0:
				run = false;
				break;
			case 1:
				System.out.println("Enter the title of the book : ");
				title = sc.next();
				System.out.println("Enter the price of the book : ");
				price = sc.nextDouble();
				System.out.println("Enter the number of books : ");
				copies = sc.nextInt();
				System.out.println("Enter the author of the book : ");
				author = sc.next();
				b = new Book(title, price, copies);
				b.getAuthor(author);
				
				break;
				
			case 2:
				System.out.println("Enter the title of the magazine : ");
				title = sc.next();
				System.out.println("Enter the price of the magazine : ");
				price = sc.nextDouble();
				System.out.println("Enter the number of magazines : ");
				copies = sc.nextInt();
				System.out.println("Enter the current Issue of magazines : ");
				curIssue = sc.nextInt();
				m = new Magazine(title, price, copies);
				m.getCurIssue(curIssue);
				
				break;
				
			case 3:
				System.out.println("Enter the number of books you want to order: ");
				ord = sc.nextInt();
				b.OrderCopies(ord);
				break;
				
			case 4:
				System.out.println("Enter the number of magazines you want to order: ");
				ord = sc.nextInt();
				m.OrderCopies(ord);
				break;
				
			case 5:
				System.out.println("Enter the number of books you want to add to stock: ");
				res = sc.nextInt();
				b.RestockCopies(res);
				break;
				
			case 6:
				System.out.println("Enter the number of magazines you want to add to stock: ");
				res = sc.nextInt();
				m.RestockCopies(res);
				break;
				
			case 7:
				b.sellCopy();
				break;
			
			case 8:
				m.sellCopy();
				break;
			
			case 9:
				p.sellCopy();
				break;
				
			default:
				System.out.println("Invalid Input\n");
			}
		}
		
		sc.close();
	}
}
