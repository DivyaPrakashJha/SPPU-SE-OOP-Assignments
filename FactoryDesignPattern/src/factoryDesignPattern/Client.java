package factoryDesignPattern;
import java.util.*;

public class Client {
	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		CarFactory cf = new CarFactory();
		System.out.println("Enter the car type you want to make : ");
		System.out.println("1. Hatchback\n2. SUV\n3. Sedan\n");
		
		String carType = sc.next();
		
		Car finalProduct = cf.makeCar(carType);
		
		if (finalProduct != null) {
			finalProduct.carType();
		}
		else {
			System.out.println("The factory cannot make " + carType);
		}
			
	}
}
