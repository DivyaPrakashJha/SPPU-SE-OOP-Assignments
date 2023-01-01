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

class Student{
	String name, studentId, roll, marks, class_, address;
	
	Student(String studentId, String name, String class_, String roll, String marks, String address){
		this.studentId = studentId;
		this.name = name;
		this.class_ = class_;
		this.roll = roll;
		this.marks = marks;
		this.address = address;
	}
	
	String getData() {
		String s = name + "\t" + studentId + "\t" + class_ + "\t" + roll + "\t" + marks + "\t" + address;
		
		return s;
	}
}

public class FileHandling {
	
	static Scanner sc = new Scanner(System.in);
	
	static void addRecords(String filename) {
		String id, name, class_, roll, marks, address;
		
		while(true) {// Since the student id cannot be same
			System.out.print("Enter student ID : ");
			id = sc.nextLine();
			
			if(SearchRecord(filename, id) == false) {
				break;
			}
			System.out.println("Student already exists");
		}
		
		System.out.print("Enter name : ");
		name = sc.nextLine();
		System.out.print("Enter class : ");
		class_ = sc.nextLine();
		
		while(true) {// Since the roll number cannot be same
			System.out.print("Enter roll number : ");
			roll = sc.nextLine();
			
			if(SearchRecord(filename, roll) == false) {
				break;
			}
			System.out.println("Student already exists");
		}
		
		System.out.print("Enter marks: ");
		marks = sc.nextLine();
		System.out.print("Enter address : ");
		address = sc.nextLine();
		
		Student s = new Student(id, name, class_, roll, marks, address);
		
		try {
			FileWriter writer = new FileWriter(filename, true);
			writer.append(s.getData());
			writer.append("\n");
			writer.close();
			System.out.println("Student record added succefully!");
		} catch (IOException e) {
			System.out.println(e);
		}
		
		
	}
	
	static void displayRecords(String filename) {
		try {
			FileReader fr = new FileReader(filename);
			BufferedReader br = new BufferedReader(fr);
			String line;
			while ((line = br.readLine()) != null) {
				System.out.println(line);
			}			
			
			br.close();
			fr.close();
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
	
	static void updateRecord(String filename, String key, int op) {
		ArrayList<String>details = new ArrayList<>();
		
		try {
			FileReader fr = new FileReader(filename);
			BufferedReader br = new BufferedReader(fr);
			String line;
			while ((line = br.readLine()) != null) {
				if (line.contains(key)) {
					System.out.println(line);
					if (op==2) {
						System.out.println("Enter the value you want to replace : ");
						String repl = sc.nextLine();
						System.out.println("Enter the value you want to replace with : ");
						String replwith = sc.nextLine();
						
						details.add(line.replace(repl, replwith));
					}
				}
				else {
					details.add(line);
				}
			}			
			
			br.close();
			fr.close();
		}
		catch(Exception e) {
			System.out.println(e);
		}
		
		// Overwriting the existing file
		try {
			FileWriter writer = new FileWriter(filename);

			for(int i = 0; i < details.size(); i++) {
				writer.append(details.get(i));
				writer.append("\n");
			}
			writer.close();
			System.out.println("Student record updated succefully!");
		} catch (IOException e) {
			System.out.println(e);
		}
		
	}
	
	static boolean SearchRecord(String filename, String key) {
		boolean flag = false;
		try {
			FileReader fr = new FileReader(filename);
			BufferedReader br = new BufferedReader(fr);
			
			String line;
			while ((line = br.readLine()) != null) {
				if (line.contains(key)) {
					System.out.println(line);
					flag = true;
				}
			}			
			
			br.close();
			fr.close();
		}
		catch(Exception e) {
			System.out.println(e);
		}
		
		return flag;
	}
	
	public static void main(String[] args) {
		ExceptionHandling e = new ExceptionHandling();
		int op = 1, op1 = 0;
		String key = "";
		String file = "Database.txt";
		File Obj = new File(file);
	
		
		while(op!=0) {
			System.out.println("\n\nChoose the desired option : ");
			System.out.println("1. Create Database");
			System.out.println("2. Add Record");
			System.out.println("3. Display Database");
			System.out.println("4. Clear Records");
			System.out.println("5. Update Record");
			System.out.println("6. Search Record");
			System.out.println("*. Press any other numeric key to exit");
			
			op = e.takeInput();
			
			
			
			switch(op) {
			case 1:
				try {

				     if (Obj.createNewFile()) {
				        System.out.println("File created: " + Obj.getName());
						try {
							FileWriter writer = new FileWriter(file);
							writer.write("Name\tStudId\tClass\tRollNo\tMarks\tAddress\n");
							writer.close();
						} catch (IOException f) {
							System.out.println(f);
						}
				        
				     } 
				     else {
				        System.out.println("File already exists.");
				     }
				} 
				catch (IOException f) {
				      System.out.println("An error occurred.");
				      f.printStackTrace();
				}
				break;
			
			case 2:
				if (Obj.exists()) {
					addRecords(file);
				}
				else {
					System.out.println("Please create a file first!");
				}
				break;
			
			case 3:
				if (Obj.exists()) {
					displayRecords(file);
				}
				else {
					System.out.println("Please create a file first!");
				}
				break;
			
			case 4:
				Obj.delete();
				System.out.println("Records deleted successfully");
				break;
			
			case 5:
				if (Obj.exists()) {
					System.out.println("Enter the detail of the student whose record you want to update : ");
					key = sc.nextLine();
					
					System.out.println("What do you want to perform : \n1. Delete the student's record\n2. Change the student's record");
					op1 = e.takeInput();
					
					updateRecord(file, key, op1);
				}
				else {
					System.out.println("Please create a file first!");
				}
				break;
			
			case 6:
				System.out.println("Enter the key you want to search for : ");
				key = sc.nextLine();
				
				if (SearchRecord(file, key) == false) {
					System.out.println("No records found for the entered key!");
				}
				break;
			
			default:
				op = 0;
				break;
			
			}
		}
	}

}
