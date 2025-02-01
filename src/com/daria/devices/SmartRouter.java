package com.daria.devices;

import com.daria.interfaces.DataTransferable;
import com.daria.interfaces.NetworkManageable;

public class SmartRouter extends CommunicationDevice implements DataTransferable, NetworkManageable {

    public SmartRouter(String manufacturer, String model) {
        super(manufacturer, model);
    }

    @Override
    public void sendData(byte[] data) {
        System.out.println("Sending data from " + manufacturer + " " + model);

    }

    @Override
    public void receiveData() {
        this.connect();
        System.out.println("Receiving data " + "for " + manufacturer + " " + model);
    }

    @Override
    public void changeNetworkType(String newType) {
        System.out.println("Changing network type to " + newType + " for " + manufacturer + " " + model);
    }

    @Override
    public void adjustSignalStrength(int strength) {
        System.out.println("Adjusting strength to " + strength + " for " + manufacturer + " " + model);
    }
}
