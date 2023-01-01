package factoryDesignPattern;

public class Hatchback implements Car{
	public void carType() { // For final display
		System.out.println("\n**HatchBack**");
	}
	
	public void gatherParts() {
		System.out.println("Gathering parts for Hatchback.");
	}
	public void assembleParts() {
		System.out.println("Assembling parts for Hatchback.");
	}
	public void ready() {
		System.out.println("Hatchback is ready.");
	}
}
