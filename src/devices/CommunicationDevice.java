package devices;

public abstract class CommunicationDevice {
    protected String manufacturer;
    protected String model;

    CommunicationDevice(String manufacturer, String model) {
        this.manufacturer = manufacturer;
        this.model = model;
    }

    protected void connect() {
        System.out.println("Connecting " + this.manufacturer + this.model);
    }

    protected void displayInfo() {
        System.out.print("I am " + this.manufacturer +  " " + this.model + " ");
    }
}
