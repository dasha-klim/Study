import devices.*;
import interfaces.VoiceCallable;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        MobilePhone mobilePhone = new MobilePhone("Samsung", "S22 Ultra");
        LandlinePhone landlinePhone = new LandlinePhone("Panasonic", "KXTGB310MBB");
        SmartRouter router = new SmartRouter("Asus", "RT-AX52");

        VoiceCallable mobile = new MobilePhone("iPhone", "14");
        VoiceCallable landline = new LandlinePhone("VTech", "CS6719-2");

        mobile.makeCall("123456789");
        mobile.endCall();

        landline.makeCall("987654321");
        landline.endCall();

        router.receiveData();
        router.sendData(new byte[]{});
        router.adjustSignalStrength(100);
        router.changeNetworkType("LAN");


        List<CommunicationDevice> devices = new ArrayList<>();
        devices.add(mobilePhone);
        devices.add(landlinePhone);
    }
}