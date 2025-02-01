package com.daria.devices;

import com.daria.interfaces.VoiceCallable;

public class LandlinePhone extends CommunicationDevice implements VoiceCallable {

    public LandlinePhone(String manufacturer, String model) {
        super(manufacturer, model);
    }

    @Override
    public void makeCall(String number) {
        this.displayInfo();
        System.out.println("Calling from landline " + number);
    }

    @Override
    public void endCall() {
        this.displayInfo();
        System.out.println("Finished call on landline ");
    }
}
