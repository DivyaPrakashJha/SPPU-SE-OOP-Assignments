package factoryDesignPattern;

public class Sedan implements Car{
	public void carType() { // For final display
		System.out.println("\n**Sedan**");
	}
	
	public void gatherParts() {
		System.out.println("Gathering parts for Sedan.");
	}
	public void assembleParts() {
		System.out.println("Assembling parts for Sedan.");
	}
	public void ready() {
		System.out.println("Sedan is ready.");
	}
}
