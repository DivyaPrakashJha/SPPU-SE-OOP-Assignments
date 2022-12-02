import java.util.*;

class EmployeeData { // Base Class
	String name, email, address;
	long id, mobile;
	double da, hra, pf, cf;
	
	void getData() {
		System.out.println("Name : " + name);
		System.out.println("ID : " +  id);
		System.out.println("Email : " +  email);
		System.out.println("Mobile : " +  mobile);
	}
	
	Scanner sc = new Scanner(System.in);
	void takeDetails() {
		System.out.print("Enter the name of the Employee : ");
		name = sc.next();
		System.out.print("Enter the id of the Employee : ");
		id = sc.nextInt();
		
		boolean flag = true;
		while(flag) {
			System.out.print("Enter the email of the Employee : ");
			email = sc.next();
			if (email.contains("@") && email.contains(".")) {
				flag = false;
			} 
			else {
				System.out.println("Email must contain . and @. Please try again!!");
			}
		}

		flag = true;
		while(flag) {
			System.out.print("Enter the mobile no. of the Employee : ");
			mobile = sc.nextLong();
			if (mobile >= 1000000000l && mobile <= 9999999999l) {
				flag = false;
			}
			else {
				System.out.println("Mobile number should be of 10 digits. Please try again!!");
			}
		}
		
	}
	
	public void calculate(double basicPay) {
		da = 0.97 * basicPay;
		hra = 0.1 * basicPay;
		pf = 0.12 * basicPay;
		cf = 0.01 * basicPay;
		
		getData();
		System.out.println("Basic Pay : Rs " + basicPay);
		System.out.println("D.A. : Rs " + da);
		System.out.println("H.R.A. : Rs " + hra);
		System.out.println("P.F. : Rs " + pf);
		System.out.println("C.F. : Rs " + cf);
		System.out.println("Gross Salary  = Rs " +  (basicPay + da + hra + pf));
		System.out.println("Net Salary  = Rs " +  (basicPay + da + hra - pf - cf) + "\n\n");
	}

}

class Programmer extends EmployeeData{
	double basicPay;
	
	void setData(double a) {
		basicPay = a;
		calculate(basicPay);
	}
}

class TeamLead extends EmployeeData{
	double basicPay, da, hra, pf, cf;
	
	void setData(double a) {
		basicPay = a;
		calculate(basicPay);
	}
}

class AssProjManager extends EmployeeData{
	double basicPay, da, hra, pf, cf;
	
	void setData(double a) {
		basicPay = a;
		calculate(basicPay);
	}

}

class ProjManager extends EmployeeData{
	double basicPay, da, hra, pf, cf;
	
	void setData(double a) {
		basicPay = a;
		calculate(basicPay);
	}
}

public class Employee {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int inp = 0;
		double basicPay = 0.0;
		do {
			System.out.println("Whose salary do you want to calculate?");
			System.out.println("1. Programmer \n2. Team Lead\n3. Assistant Project Manager\n4. Project Manager\n*. Press any other numeric key to exit!");
			inp = sc.nextInt();

			switch(inp) {
			case 1:
				Programmer a = new Programmer();
				a.takeDetails();
				System.out.print("Enter the basic pay of the Programmer: ");
				basicPay = sc.nextFloat();
				a.setData(basicPay);
				break;
			case 2:
				TeamLead b = new TeamLead();
				b.takeDetails();
				System.out.print("Enter the basic pay of the Team Lead: ");
				basicPay = sc.nextFloat();
				b.setData(basicPay);
				break;
			case 3:
				AssProjManager c = new AssProjManager();
				c.takeDetails();
				System.out.print("Enter the basic pay of the Assistant Project Manager: ");
				basicPay = sc.nextFloat();
				c.setData(basicPay);
				break;
			case 4:
				ProjManager d = new ProjManager();
				d.takeDetails();
				System.out.print("Enter the basic pay of the Project Manager: ");
				basicPay = sc.nextFloat();
				d.setData(basicPay);
				break;
			default:
				inp = 0;
				break;
			}
	
		}while(inp!=0);
				
		sc.close();
		
	}
}
