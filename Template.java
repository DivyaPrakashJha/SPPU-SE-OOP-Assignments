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

public class Template {
	
	static Boolean parityCheck(int n) {
		if (n%2 == 0) {
			return true;
		}
		else return false;
	}
	
	static Boolean primeCheck(int n) {
		for(int i = 2; i*i <= n; i++) {
			if (n%i==0) {
				return false;
			}
		}
		return true;
	}
	
	static Boolean pallindromeCheck(int n) {
		int temp = n;
		int rev = 0;

		while(temp!=0) {
			rev = rev*10 + temp%10;
			temp /= 10;
		}
		
		if (rev == n) {
			return true;
		}
		else return false;
		
	}
	
	public static void main(String[] args) {
		Exception e = new Exception();
		Scanner sc = new Scanner(System.in);
		int op = 0, a, ind = -1;
		
		ArrayList<Integer> coll = new ArrayList<>();
		ArrayList<Integer> even  = new ArrayList<>();
		ArrayList<Integer> odd = new ArrayList<>();
		ArrayList<Integer> prime = new ArrayList<>();
		ArrayList<Integer> pallindrome = new ArrayList<>();
		do {
			System.out.println("Choose the desired option : ");
			System.out.println("1. Add elements to the collection");
			System.out.println("2. Track of even numbers");
			System.out.println("3. Track of odd numbers");
			System.out.println("4. Track of prime numbers");
			System.out.println("5. Track of pallindrome numbers");
			
			op = e.takeInput();
			
			switch(op) {
			case 1:
				while(true) {
					System.out.println("Enter the integer you want to add : ");
					a = e.takeInput();
					coll.add(a);
					ind++;
					
					if(parityCheck(a) == true) {
						even.add(ind);
					}
					else {
						odd.add(ind);
					}
					if(primeCheck(a) == true) {
						prime.add(ind);
					}
					if(pallindromeCheck(a) == true) {
						pallindrome.add(ind);
					}
					
					System.out.println("Do you want to add more?\n Press 1 - Yes\n Press 0 - No\n");
					a = e.takeInput();
					if (a == 0) {
						break;
					}
				}
				break;
			case 2:
				for(Integer it : even) {
					System.out.println("Index : " + it + " Element : " + coll.get(it));
				}
				break;
			case 3:
				for(Integer it : odd) {
					System.out.println("Index : " + it + " Element : " + coll.get(it));
				}
				break;
			case 4:
				for(Integer it : prime) {
					System.out.println("Index : " + it + " Element : " + coll.get(it));
				}
				break;
			case 5:
				for(Integer it : pallindrome) {
					System.out.println("Index : " + it + " Element : " + coll.get(it));
				}
				break;
			default:
				op = 0;
				break;
			}
		}while(op!=0);
		
		sc.close();
		
	}

}
