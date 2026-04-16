package com.OOPs.practice.abstraction;

interface Testable{
    //Implement your code here
    boolean testCompatibility();
}
class Mobile {
    //Implement your code here
    private String name;
    private String brand;
    private String operatingSystemName;
    private String operatingSystemVersion;
    public Mobile(String name, String brand, String operatingSystemName, String operatingSystemVersion) {
        this.name = name;
        this.brand = brand;
        this.operatingSystemName = operatingSystemName;
        this.operatingSystemVersion = operatingSystemVersion;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getBrand() {
        return brand;
    }
    public void setBrand(String brand) {
        this.brand = brand;
    }
    public String getOperatingSystemName() {
        return operatingSystemName;
    }
    public void setOperatingSystemName(String operatingSystemName) {
        this.operatingSystemName = operatingSystemName;
    }
    public String getOperatingSystemVersion() {
        return operatingSystemVersion;
    }
    public void setOperatingSystemVersion(String operatingSystemVersion) {this.operatingSystemVersion = operatingSystemVersion;}
}
class SmartPhone extends Mobile implements Testable{
    //Implement your code here
    private String networkGeneration;
    public SmartPhone(String name, String brand, String operatingSystemName, String operatingSystemVersion, String networkGeneration) {
        super(name, brand, operatingSystemName, operatingSystemVersion);
        this.networkGeneration = networkGeneration;
    }
    public String getNetworkGeneration() {
        return networkGeneration;
    }
    public void setNetworkGeneration(String networkGeneration) {
        this.networkGeneration = networkGeneration;
    }
    public boolean testCompatibility() {
        String osName = getOperatingSystemName();
        String osVersion = getOperatingSystemVersion();
        if (osName.equals("Saturn")) {
            if (networkGeneration.equals("3G") &&
                    (osVersion.equals("1.1") || osVersion.equals("1.2") || osVersion.equals("1.3")))
                return true;
            if (networkGeneration.equals("4G") &&
                    (osVersion.equals("1.2") || osVersion.equals("1.3")))
                return true;
            if (networkGeneration.equals("5G") &&
                    osVersion.equals("1.3"))
                return true;
        }
        else if (osName.equals("Gara")) {
            if (networkGeneration.equals("3G") &&
                    (osVersion.equals("EXRT.1") || osVersion.equals("EXRT.2") || osVersion.equals("EXRU.1")))
                return true;
            if (networkGeneration.equals("4G") &&
                    (osVersion.equals("EXRT.2") || osVersion.equals("EXRU.1")))
                return true;
            if (networkGeneration.equals("5G") &&
                    osVersion.equals("EXRU.1"))
                return true;
        }
        return false;
    }
}
public class InterfaceAssignment1 {
    public static void main(String[] args){
        SmartPhone smartPhone = new SmartPhone("KrillinM20", "Nebula", "Saturn", "1.3", "5G");
        if(smartPhone.testCompatibility())
            System.out.println("The mobile OS is compatible with the network generation!");
        else
            System.out.println("The mobile OS is not compatible with the network generation!");
    }
}
