package factoryDesignPattern;

public interface Car {
	abstract void carType(); // For final display
	
	abstract void gatherParts();
	abstract void assembleParts();
	abstract void ready();
}
