package factoryDesignPattern;

public class SUV implements Car{
	public void carType() { // For final display
		System.out.println("\n**SUV**");
	}
	
	public void gatherParts() {
		System.out.println("Gathering parts for SUV.");
	}
	public void assembleParts() {
		System.out.println("Assembling parts for SUV.");
	}
	public void ready() {
		System.out.println("SUV is ready.");
	}
}
