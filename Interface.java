import java.util.*;

interface vehicleFunctions{
	void speedIncrease(int x);
	void applyBrakes(int x);
	void gearUp();
	void gearDown();
}

class Car implements vehicleFunctions{
	int maxSpeed, currSpeed, maxGear, currGear;
	
	Car(){
		maxSpeed = 200;
		currSpeed = 0;
		maxGear = 5;
		currGear = 0; // Neutral
	}
	public void speedIncrease(int x) { 
		currSpeed += x;
		if (currSpeed > maxSpeed) {
			System.out.println("Cannot increase the speed beyond max. The max speed is " + maxSpeed + "!!!");
			currSpeed = maxSpeed;
		}
		if (currSpeed > 0 && currSpeed <= 40) {
			currGear = 1;
		}
		else if (currSpeed > 40 && currSpeed <= 80) {
			currGear = 2;
		}
		else if (currSpeed > 80 && currSpeed <= 120) {
			currGear = 3;
		}
		else if (currSpeed > 120 && currSpeed <= 160) {
			currGear = 4;
		}
		else if (currSpeed > 160 && currSpeed <= 200) {
			currGear = 5;
		}
	}
	public void applyBrakes(int x) {
		currSpeed -= x;
		if (currSpeed <= 0) {
			System.out.println("The car is at rest");
			currSpeed = 0;
			currGear = 0;
		}
		if (currSpeed > 0 && currSpeed <= 40) {
			currGear = 1;
		}
		else if (currSpeed > 40 && currSpeed <= 80) {
			currGear = 2;
		}
		else if (currSpeed > 80 && currSpeed <= 120) {
			currGear = 3;
		}
		else if (currSpeed > 120 && currSpeed <= 160) {
			currGear = 4;
		}
		else if (currSpeed > 160 && currSpeed <= 200) {
			currGear = 5;
		}
	}
	public void gearUp() {
		currGear += 1;
		if (currGear > maxGear) {
			System.out.println("The car is at max gear");
			currGear = maxGear;
		}
		if (currGear == 1) {
			currSpeed = 40;
		}
		else if (currGear == 2) {
			currSpeed = 80;
		}
		else if (currGear == 3) {
			currSpeed = 120;
		}
		else if (currGear == 4) {
			currSpeed = 160;
		}
		else if (currGear == 5) {
			currSpeed = 200;
		}
	}
	public void gearDown() {
		currGear -= 1;
		if (currGear < 0) {
			System.out.println("The car is at neutral");
			currGear = 0;
		}
		if (currGear == 0) {
			currSpeed = 0;
		}
		else if (currGear == 1) {
			currSpeed = 40;
		}
		else if (currGear == 2) {
			currSpeed = 80;
		}
		else if (currGear == 3) {
			currSpeed = 120;
		}
		else if (currGear == 4) {
			currSpeed = 160;
		}
	}	
}

class Bike implements vehicleFunctions{
	int maxSpeed, currSpeed, maxGear, currGear;
	
	Bike(){
		maxSpeed = 150;
		currSpeed = 0;
		maxGear = 5;
		currGear = 0; // Neutral
	}
	
	public void speedIncrease(int x) { 
		currSpeed += x;
		if (currSpeed > maxSpeed) {
			System.out.println("Cannot increase the speed beyond max. The max speed is " + maxSpeed + "!!!");
			currSpeed = maxSpeed;
		}
		if (currSpeed > 0 && currSpeed <= 30) {
			currGear = 1;
		}
		else if (currSpeed > 30 && currSpeed <= 60) {
			currGear = 2;
		}
		else if (currSpeed > 60 && currSpeed <= 90) {
			currGear = 3;
		}
		else if (currSpeed > 90 && currSpeed <= 120) {
			currGear = 4;
		}
		else if (currSpeed > 120 && currSpeed <= 150) {
			currGear = 5;
		}
	}
	public void applyBrakes(int x) {
		currSpeed -= x;
		if (currSpeed <= 0) {
			System.out.println("The bike is at rest");
			currSpeed = 0;
			currGear = 0;
		}
		if (currSpeed > 0 && currSpeed <= 30) {
			currGear = 1;
		}
		else if (currSpeed > 30 && currSpeed <= 60) {
			currGear = 2;
		}
		else if (currSpeed > 60 && currSpeed <= 90) {
			currGear = 3;
		}
		else if (currSpeed > 90 && currSpeed <= 120) {
			currGear = 4;
		}
		else if (currSpeed > 120 && currSpeed <= 150) {
			currGear = 5;
		}
	}
	public void gearUp() {
		currGear += 1;
		if (currGear > maxGear) {
			System.out.println("The bike is at max gear");
			currGear = maxGear;
		}
		if (currGear == 1) {
			currSpeed = 30;
		}
		else if (currGear == 2) {
			currSpeed = 60;
		}
		else if (currGear == 3) {
			currSpeed = 90;
		}
		else if (currGear == 4) {
			currSpeed = 120;
		}
		else if (currGear == 5) {
			currSpeed = 150;
		}
	}
	public void gearDown() {
		currGear -= 1;
		if (currGear < 0) {
			System.out.println("The bike is at neutral");
			currGear = 0;
		}
		if (currGear == 0) {
			currSpeed = 0;
		}
		else if (currGear == 1) {
			currSpeed = 30;
		}
		else if (currGear == 2) {
			currSpeed = 60;
		}
		else if (currGear == 3) {
			currSpeed = 90;
		}
		else if (currGear == 4) {
			currSpeed = 120;
		}
	}
}

class Bicycle implements vehicleFunctions{
	int maxSpeed, currSpeed, maxGear, currGear;
	
	Bicycle(){
		maxSpeed = 50;
		currSpeed = 0;
		maxGear = 5;
		currGear = 0; // Neutral
	}
	
	public void speedIncrease(int x) { 
		currSpeed += x;
		if (currSpeed > maxSpeed) {
			System.out.println("Cannot increase the speed beyond max. The max speed is " + maxSpeed + "!!!");
			currSpeed = maxSpeed;
		}
		if (currSpeed > 0 && currSpeed <= 10) {
			currGear = 1;
		}
		else if (currSpeed > 10 && currSpeed <= 20) {
			currGear = 2;
		}
		else if (currSpeed > 20 && currSpeed <= 30) {
			currGear = 3;
		}
		else if (currSpeed > 30 && currSpeed <= 40) {
			currGear = 4;
		}
		else if (currSpeed > 40 && currSpeed <= 50) {
			currGear = 5;
		}
	}
	public void applyBrakes(int x) {
		currSpeed -= x;
		if (currSpeed <= 0) {
			System.out.println("The bicycle is at rest");
			currSpeed = 0;
			currGear = 0;
		}
		if (currSpeed > 0 && currSpeed <= 10) {
			currGear = 1;
		}
		else if (currSpeed > 10 && currSpeed <= 20) {
			currGear = 2;
		}
		else if (currSpeed > 20 && currSpeed <= 30) {
			currGear = 3;
		}
		else if (currSpeed > 30 && currSpeed <= 40) {
			currGear = 4;
		}
		else if (currSpeed > 40 && currSpeed <= 50) {
			currGear = 5;
		}
	}
	public void gearUp() {
		currGear += 1;
		if (currGear > maxGear) {
			System.out.println("The bicycle is at max gear");
			currGear = maxGear;
		}
		if (currGear == 1) {
			currSpeed = 10;
		}
		else if (currGear == 2) {
			currSpeed = 20;
		}
		else if (currGear == 3) {
			currSpeed = 30;
		}
		else if (currGear == 4) {
			currSpeed = 40;
		}
		else if (currGear == 5) {
			currSpeed = 50;
		}
	}
	public void gearDown() {
		currGear -= 1;
		if (currGear <= 0) {
			System.out.println("The bicycle is at neutral");
			currGear = 0;
		}
		if (currGear == 0) {
			currSpeed = 0;
		}
		else if (currGear == 1) {
			currSpeed = 10;
		}
		else if (currGear == 2) {
			currSpeed = 20;
		}
		else if (currGear == 3) {
			currSpeed = 30;
		}
		else if (currGear == 4) {
			currSpeed = 40;
		}
		else if (currGear == 5) {
			currSpeed = 50;
		}
	}
}


public class Interface {
	
	public static void main(String[] args) {
		
		Car c = new Car();
		Bike mb = new Bike();
		Bicycle b = new Bicycle();
		
		Scanner sc = new Scanner(System.in);
		int op = 0, op1 = 0, x = 0;
		do {
			System.out.println("*************************************************");
			System.out.println("Select the desired vehicle : ");
			System.out.println("1. Car");
			System.out.println("2. Bike");
			System.out.println("3. Bicycle");
			System.out.println("*. Press any other numeric key to exit.");
			System.out.println("-->");
			
			op = sc.nextInt();		
			
			switch(op) {
			case 1:
				do {
					System.out.println("Car");
					System.out.println("Enter the operation you want to perform : ");
					System.out.println("1. Increase Speed");
					System.out.println("2. Apply Brakes");
					System.out.println("3. Gear Up");
					System.out.println("4. Gear Down");
					System.out.println("*. Press any other numeric key to go to the main menu.");
					
					op1 = sc.nextInt();
					switch(op1) {
					
					case 1:
						System.out.println("By how much do you want to increase the speed : ");
						x = sc.nextInt();
						c.speedIncrease(x);
						System.out.println("Speed : " + c.currSpeed);
						System.out.println("Gear : " + c.currGear);
						break;
					case 2:
						if (c.currSpeed == 0) {
							System.out.println("The car is already at rest");
							continue;
						}
						System.out.println("By how much do you want to decrease the speed : ");
						x = sc.nextInt();
						c.applyBrakes(x);
						System.out.println("Speed : " + c.currSpeed);
						System.out.println("Gear : " + c.currGear);
						break;
					case 3:
						c.gearUp();
						System.out.println("Speed : " + c.currSpeed);
						System.out.println("Gear : " + c.currGear);
						break;
					case 4:
						c.gearDown();
						System.out.println("Speed : " + c.currSpeed);
						System.out.println("Gear : " + c.currGear);
						break;
					default:
						op1 = 0;
					}
					
				}while(op1!=0);
				break;
				
			case 2:
				do {
					System.out.println("Bike");
					System.out.println("Enter the operation you want to perform : ");
					System.out.println("1. Increase Speed");
					System.out.println("2. Apply Brakes");
					System.out.println("3. Gear Up");
					System.out.println("4. Gear Down");
					System.out.println("*. Press any other numeric key to go to the main menu.");
					
					op1 = sc.nextInt();
					switch(op1) {
					case 1:
						System.out.println("By how much do you want to increase the speed : ");
						x = sc.nextInt();
						mb.speedIncrease(x);
						System.out.println("Speed : " + mb.currSpeed);
						System.out.println("Gear : " + mb.currGear);
						break;
					case 2:
						if (mb.currSpeed == 0) {
							System.out.println("The bike is already at rest");
							continue;
						}
						System.out.println("By how much do you want to decrease the speed : ");
						x = sc.nextInt();
						mb.applyBrakes(x);
						System.out.println("Speed : " + mb.currSpeed);
						System.out.println("Gear : " + mb.currGear);
						break;
					case 3:
						mb.gearUp();
						System.out.println("Speed : " + mb.currSpeed);
						System.out.println("Gear : " + mb.currGear);
						break;
					case 4:
						mb.gearDown();
						System.out.println("Speed : " + mb.currSpeed);
						System.out.println("Gear : " + mb.currGear);
						break;
					default:
						op1 = 0;
					}
				}while(op1!=0);
				break;
				
			case 3:
				do {					
					System.out.println("*. Bicycle");
					System.out.println("Enter the operation you want to perform : ");
					System.out.println("1. Increase Speed");
					System.out.println("2. Apply Brakes");
					System.out.println("3. Gear Up");
					System.out.println("4. Gear Down");
					System.out.println("*. Press any other numeric key to go to the main menu.");
					
					op1 = sc.nextInt();
					switch(op1) {
					case 1:
						System.out.println("By how much do you want to increase the speed : ");
						x = sc.nextInt();
						b.speedIncrease(x);
						System.out.println("Speed : " + b.currSpeed);
						System.out.println("Gear : " + b.currGear);
						break;
					case 2:
						if (b.currSpeed == 0) {
							System.out.println("The bicycle is already at rest");
							continue;
						}
						System.out.println("By how much do you want to decrease the speed : ");
						x = sc.nextInt();
						b.applyBrakes(x);
						System.out.println("Speed : " + b.currSpeed);
						System.out.println("Gear : " + b.currGear);
						break;
					case 3:
						b.gearUp();
						System.out.println("Speed : " + b.currSpeed);
						System.out.println("Gear : " + b.currGear);
						break;
					case 4:
						b.gearDown();
						System.out.println("Speed : " + b.currSpeed);
						System.out.println("Gear : " + b.currGear);
						break;
					default:
						op1 = 0;
						break;
					}
				}while(op1!=0);
				break;
				
			default:
				op = 0;
				break;
			}			
		}while(op!=0);
		
		sc.close();		
	}

}
