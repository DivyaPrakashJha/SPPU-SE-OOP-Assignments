import java.util.*;

abstract class Shape{
	double d1, d2;
	
	Shape(){
		d1 = 0;
		d2 = 0;
	}
	
	Scanner sc = new Scanner(System.in);
	
	void getData() {
		System.out.println("Enter the first dimension : ");
		d1 = sc.nextDouble();
		System.out.println("Enter the second dimension : ");
		d2 = sc.nextDouble();
	}
	
	abstract void computeArea();
		
}

class Rectangle extends Shape{
	public void computeArea() {
		System.out.println("Area of Rectangle : " + d1*d2 );
	}
}

class Triangle extends Shape{
	public void computeArea() {
		System.out.println("Area of Triangle : " + d1*d2/2 );
	}
}

class Ellipse extends Shape{
	public void computeArea() {
		System.out.println("Area of Ellipse : " + 3.142*d1*d2 );
	}
}

class Parallelogram extends Shape{
	public void computeArea() {
		System.out.println("Area of Parallelogram : " + d1*d2 );
	}
}


public class DynamicBinding {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Rectangle r = new Rectangle();
		Triangle t =  new Triangle();
		Ellipse e = new Ellipse();
		Parallelogram p = new Parallelogram();
		
		boolean run = true;
		int op = 0;
		while(run) {
			System.out.println("\nChoose the desired option : ");
			System.out.println("1. Input Rectangle's Dimensions");
			System.out.println("2. Input Triangle's Dimensions");
			System.out.println("3. Input Ellipse's Dimensions");
			System.out.println("4. Input Parallelogram's Dimensions");
			System.out.println("5. Calculate Rectangle's Area");
			System.out.println("6. Calculate Triangle's Area");
			System.out.println("7. Calculate Elipse's Area");
			System.out.println("8. Calculate Parallelogram's Area");
			System.out.println("0. Exit");
			
			
			op = sc.nextInt();
			
			switch(op) {
			case 0:
				run = false;
				break;
			case 1:
				r.getData();
				break;
			case 2:
				t.getData();
				break;
			case 3:
				e.getData();
				break;
			case 4:
				p.getData();
				break;
			case 5:
				r.computeArea();
				break;
			case 6:
				t.computeArea();
				break;
			case 7:
				e.computeArea();
				break;
			case 8:
				p.computeArea();
				break;
			}
		}
		sc.close();
	}
	
}
