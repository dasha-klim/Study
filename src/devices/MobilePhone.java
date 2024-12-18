package devices;

import interfaces.VoiceCallable;

public class MobilePhone extends CommunicationDevice implements VoiceCallable {

    public MobilePhone(String manufacturer, String model) {
        super(manufacturer, model);
    }

    @Override
    public void makeCall(String number) {
        this.displayInfo();
        System.out.println("Calling " + number);
    }

    @Override
    public void endCall() {
        this.displayInfo();
        System.out.println("Call is over on mobile");
    }
}
