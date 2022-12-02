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
		
		int op = 0, n = 0, x = 0, y = 0, ans = 0, i = 0, j = 0;
		int[] arr = new int[0];
		Boolean flag = false;
		
		Exception E = new Exception();
		
		do {
			System.out.println("\n\nChoose the desired option : ");
			System.out.println("1. Take input for division");
			System.out.println("2. Perform division");
			System.out.println("3. Create an array");
			System.out.println("4. Input array element");
			System.out.println("5. Access array element");
			System.out.println("*. Press any other numeric key to exit");
			
			op = E.takeInput();
			
			switch(op) {
			case 1:
				System.out.println("Enter the value of x : ");
				x = E.takeInput();
				System.out.println("Enter the value of y : ");
				y = E.takeInput();
				break;
			case 2:
				try {
					ans = x/y;
					System.out.print("x/y = "+ ans);
				}
				catch(ArithmeticException e) {
					System.out.println(e);
					System.out.println("Cannot divide by 0");
				}
				break;
			case 3:
				flag = true;
				System.out.println("Enter the size of the array : ");
				n = E.takeInput();
				arr = new int[n];
				break;
			case 4:
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
			case 5:
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
			default:
				op = 0;
			}
			
		}while(op!=0);
	}

}
