import java.util.Scanner;

public class Complex {
	float real;
	float img;
	
	Complex(){
		real = 0;
		img = 0;
	}
	Complex(float a, float b){
		real = a;
		img = b;
	}
	
	Scanner s = new Scanner(System.in);
	void getData(){
		System.out.println("Enter real part : ");
		real = s.nextFloat();
		System.out.println("Enter imaginary part : ");
		img = s.nextFloat();
	}
	void putData(){
		System.out.print("(" + real + " + " + img + "i" + ")");
	}
	
	void sum(Complex c1, Complex c2) {
		Complex c3 = new Complex();
		c3.real = c1.real + c2.real;
		c3.img = c1.img + c2.img;
		c1.putData();
		System.out.print(" + ");
		c2.putData();
		System.out.print(" = ");
		c3.putData();
	}
	void diff(Complex c1, Complex c2) {
		Complex c3 = new Complex();
		c3.real = c1.real - c2.real;
		c3.img = c1.img - c2.img;
		c1.putData();
		System.out.print(" - ");
		c2.putData();
		System.out.print(" = ");
		c3.putData();
	}
	void mul(Complex c1, Complex c2) {
		Complex c3 = new Complex();
		c3.real = (c1.real*c2.real) - (c1.img*c2.img);
		c3.img = (c1.real*c2.img) + (c2.real*c1.img);
		c1.putData();
		System.out.print(" x ");
		c2.putData();
		System.out.print(" = ");
		c3.putData();
	}
	void div(Complex c1, Complex c2) {
		if (c2.real == 0 && c2.img == 0) {
			System.out.println("Denominator cannot be zero!!");
		}
		else {
			Complex c3 = new Complex();
			c3.real = ( (c1.real*c2.real) - (c1.img*c2.img) )/( (c2.real*c2.real) + (c2.img*c2.img) );
			c3.img = ( (c1.img*c2.real) + (c1.real*c2.img) )/( (c2.real*c2.real) + (c2.img*c2.img) );
			c1.putData();
			System.out.print(" / ");
			c2.putData();
			System.out.print(" = ");
			c3.putData();
		}
	}
	
    // Main Function Starts
	public static void main(String[] args) {
		System.out.print("**Assignment-1(Operations on Complex Numbers)**");
		Scanner sc = new Scanner(System.in);
		Complex c1 = new Complex();
		Complex c2 = new Complex();
		Complex dummy = new Complex();
		int op = 0;
		
		do {
				System.out.println("\n\nSelect the operation you want to perform : ");
				System.out.println("1. Addition");
				System.out.println("2. Substraction");
				System.out.println("3. Multiplication");
				System.out.println("4. Division");
				System.out.println("0. Exit");
				System.out.print("-->");
				
				
				op = sc.nextInt();
				
				switch(op) {
				case 0:
					break;
					
				case 1:
					System.out.println("C1");
					c1.getData();
					System.out.println("C2");
					c2.getData();
					dummy.sum(c1, c2);
					break;
		
				case 2:
					System.out.println("C1");
					c1.getData();
					System.out.println("C2");
					c2.getData();
					dummy.diff(c1, c2);
					break;
				
				case 3:
					System.out.println("C1");
					c1.getData();
					System.out.println("C2");
					c2.getData();
					dummy.mul(c1, c2);
					break;
					
				case 4:
					System.out.println("C1");
					c1.getData();
					System.out.println("C2");
					c2.getData();
					dummy.div(c1, c2);
					break;
				}				
				
		}while(op!=0);
		sc.close();
	}

}

