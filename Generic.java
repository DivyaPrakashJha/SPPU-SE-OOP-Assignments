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



public class Generic {
	
	static Boolean parityCheck(int n) {
		return n%2==0;
	}
	
	static Boolean primeCheck(int n) {
		if (n<2) {
			return false;
		}
		for(int i = 2; i*i <= n; i++) {
			if (n%i==0) {
				return false;
			}
		}
		return true;
	}
	
	static Boolean pallindromeCheck(String s) { // For strings
		int len = s.length();
		
		for(int i = 0; i < len/2; i++) {
			if (s.charAt(i) != s.charAt(len-1-i)) {
				return false;
			}
		}
		return true;
	}
	
	static Boolean pallindromeCheck(int n) { // For Integers
		int rev = 0;
		int temp = n;
		
		while(temp>0) {
			rev*=10;
			rev+=temp%10;
			temp/=10;
		}
		if (rev == n) {
			return true;
		}
		else return false;
	}
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		ExceptionHandling e = new ExceptionHandling();
		int op = 1, op1 = 0, count = 0, num = 0, ind1 = 0, ind2 = 0;
		String str = "";
		
		ArrayList<String> strCollection = new ArrayList<>();
		ArrayList<Integer> intCollection = new ArrayList<>();

		ArrayList<Integer> even = new ArrayList<>(); // Stores the index
		ArrayList<Integer> odd = new ArrayList<>();
		ArrayList<Integer> prime = new ArrayList<>();
		ArrayList<Integer> strPallindromes = new ArrayList<>();
		ArrayList<Integer> intPallindromes = new ArrayList<>();
		
		while(op!=0) {
			System.out.println("\nChoose the desired option : ");
			System.out.println("1. Add elements to the collection");
			System.out.println("2. Track of collection");
			System.out.println("3. Track of even numbers");
			System.out.println("4. Track of odd numbers");
			System.out.println("5. Track of prime numbers");
			System.out.println("6. Track of pallindromes");			
			System.out.println("*. Press any other numeric key to exit");
			
			op = e.takeInput();
			
			switch(op) {
			case 1:
				System.out.println("Do you want to enter a String or an Integer\n1. String\n2. Integer");
				op1 = e.takeInput();
				
				switch(op1) {
				case 1:
					System.out.println("Enter the string : ");
					str = sc.next();
					
					strCollection.add(str);
					
					if (pallindromeCheck(str) == true) {
						strPallindromes.add(ind1);
					}
					
					ind1++;
					break;
				
				case 2:
					System.out.println("Enter the number : ");
					num = e.takeInput();
					intCollection.add(num);
					
					if (num != 0 && parityCheck(num) == true) {
						even.add(ind2);
					}
					else if (num != 0) {
						odd.add(ind2);
					}
					if (primeCheck(num) == true) {
						prime.add(ind2);
					}
					if (pallindromeCheck(num) == true) {
						intPallindromes.add(ind2);
					}
					
					ind2++;
					break;
				}
				break;
				
			case 2:
				System.out.println("**String Collection**");
				for(int i = 0; i < ind1; i++) {
					System.out.println("Index : " + i + " Element : " + strCollection.get(i));
				}
				System.out.println("**Integer Collection**");
				for(int i = 0; i < ind2; i++) {
					System.out.println("Index : " + i + " Element : " + intCollection.get(i));
				}
				break;
				
			case 3:
				count = 0;
				for(Integer it : even) {
					System.out.println("Index : "+it + " Element : " + intCollection.get(it));
					count++;
				}
				System.out.println("Even Number Count : " + count);
				break;
				
			case 4:
				count = 0;
				for(Integer it : odd) {
					System.out.println("Index : "+it + " Element : " + intCollection.get(it));
					count++;
				}
				System.out.println("Odd Number Count : " + count);
				break;
				
			case 5:
				count = 0;
				for(Integer it : prime) {
					System.out.println("Index : "+it + " Element : " + intCollection.get(it));
					count++;
				}
				System.out.println("Prime Number Count : " + count);
				break;
				
			case 6:
				count = 0;
				System.out.println("**String Collection**");
				for(Integer it : strPallindromes) {
					System.out.println("Index : " + it + " Element : " + strCollection.get(it));
					count++;
				}
				System.out.println("**Integer Collection**");
				for(Integer it : intPallindromes) {
					System.out.println("Index : "+it + " Element : " + intCollection.get(it));
					count++;
				}
				System.out.println("Pallindrome Count : " + count);
				break;
				
			default:
				op = 0;
				break;
			}	
		}
		sc.close();
	}

}