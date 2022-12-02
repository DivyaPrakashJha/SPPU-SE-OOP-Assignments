import java.util.*;

class Exception{
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

public class ExceptionHandling {	

	public static void main(String[] args) {
		
		int op = 0, n = 0, x = 0, y = 0, ans = 0, i = 0, j = 0, num = 0, den = 0;
		int[] arr = new int[0];
		Boolean flag = false;
		
		Exception E = new Exception();
		
		do {
			System.out.println("\n\nChoose the desired option : ");
			System.out.println("1. Create an Array");
			System.out.println("2. Input Array element"); // For number format exception
			System.out.println("3. Access Array element"); // For array index out of bound exception
			System.out.println("4. Enter the Index of Array for Division"); // For number format and array index out of bound exception 
			System.out.println("5. Perform Division"); // For arithmetic exception
			System.out.println("*. Press any other numeric key to exit");
			
			op = E.takeInput();
			
			switch(op) {
			case 1:
				flag = true;
				System.out.println("Enter the size of the array : ");
				n = E.takeInput();
				arr = new int[n];
				break;
			case 2:
				if (!flag) {
					System.out.println("Please create an array first!!");
				}
				else {
					System.out.println("Enter the index at which you want to input data : ");
					i = E.takeInput();
					System.out.println("Enter the value you want to insert : ");
					j = E.takeInput();
					
					try {
						arr[i] = j;
					}
					catch(ArrayIndexOutOfBoundsException e) {
						System.out.println(e);
					}
				}
				break;
			case 3:
				if (!flag) {
					System.out.println("Please create an array first!!");
				}
				else {
					System.out.println("Enter the array index you want to access : ");
					i = E.takeInput();
					
					try {
						System.out.println(arr[i]);
					}
					catch(ArrayIndexOutOfBoundsException e) {
						System.out.println(e);
					}
				}
				break;
			case 4:
				if (!flag) {
					System.out.println("Please create an array first!!");
				}
				else {
					System.out.println("Enter the index of numerator : ");
					x = E.takeInput();
					try {
						num = arr[x];
					}
					catch(ArrayIndexOutOfBoundsException e) {
						System.out.println(e);
					}
					
					System.out.println("Enter the index of denomenator : ");
					y = E.takeInput();
					try {
						den = arr[y];
					}
					catch(ArrayIndexOutOfBoundsException e) {
						System.out.println(e);
					}	
				}
				break;
			case 5:
				try {
					ans = num/den;
					System.out.print("division = "+ ans);
				}
				catch(ArithmeticException e) {
					System.out.println(e);
					System.out.println("Cannot divide by 0");
				}
				break;
			default:
				op = 0;
				break;
			}
			
		}while(op!=0);
	}

}
