package factoryDesignPattern;

public class CarFactory {
	
	public Car makeCar(String carType) {
		
		if (carType.equalsIgnoreCase("HatchBack")) {
			Hatchback hb = new Hatchback();
			hb.gatherParts();
			hb.assembleParts();
			hb.ready();
			return hb; // Object returned to client
		}
		else if (carType.equalsIgnoreCase("Sedan")) {
			Sedan sd = new Sedan();
			sd.gatherParts();
			sd.assembleParts();
			sd.ready();
			return sd; // Object returned to client
		}
		else if (carType.equalsIgnoreCase("SUV")) {
			SUV sv = new SUV();
			sv.gatherParts();
			sv.assembleParts();
			sv.ready();
			return sv; // Object returned to client
		}
		else {
			return null;
		}
	}
}
