package interfaces;

public interface NetworkManageable {

    default void resetConnection() {
        System.out.println("Network settings are reset");
    }

    void changeNetworkType(String newType);
    void adjustSignalStrength(int strength);

}
