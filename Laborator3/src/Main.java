class Vehicle {
    private String name;
    public Vehicle(String name) {
        this.name = name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    @Override
    public String toString() {
        return "Vehicle[name = " + name + "]";
    }
}

class VehicleProcessor {
    public void process(Vehicle vehicle) {
        System.out.println("Entered method (vehicle = " + vehicle + ")");
        vehicle.setName("A changed name");
        System.out.println("Changed vehicle within method (vehicle = " + vehicle + ")");
        System.out.println("Leaving method (vehicle = " + vehicle + ")");
    }
    public void processWithReferenceChange(Vehicle vehicle) {
        System.out.println("Entered method (vehicle = " + vehicle + ")");
        vehicle = new Vehicle("A new name");
        System.out.println("New vehicle within method (vehicle = " + vehicle + ")");
        System.out.println("Leaving method (vehicle = " + vehicle + ")");
    }
}

class Main {
    public static void main(String args[]) {
        VehicleProcessor processor = new VehicleProcessor();
        Vehicle vehicle = new Vehicle("Some name");
        System.out.println("Before calling method (vehicle = " + vehicle + ")");
        processor.process(vehicle);
        System.out.println("After calling method (vehicle = " + vehicle + ")");
        processor.processWithReferenceChange(vehicle);
        System.out.println("After calling reference-change method (vehicle = " + vehicle + ")");
    }
}