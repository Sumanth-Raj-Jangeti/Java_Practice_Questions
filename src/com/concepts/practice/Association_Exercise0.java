package com.concepts.practice;

class CabServiceProvider{
    private String cabServiceName;
    private int totalCabs;
    public CabServiceProvider(String cabServiceName,int totalCabs) {
        this.cabServiceName=cabServiceName;
        this.totalCabs=totalCabs;
    }
    public String getCabServiceName() {
        return cabServiceName;
    }
    public void setCabServiceName(String cabServiceName) {
        this.cabServiceName = cabServiceName;
    }
    public int getTotalCabs() {
        return totalCabs;
    }
    public void setTotalCabs(int totalCabs) {
        this.totalCabs = totalCabs;
    }
    public double calculateRewardPrice(Driver driver) {
        float rating = driver.getAverageRating();
        double bonus=0;
        if(rating<4) return 0;
        if(cabServiceName.equals("OLA"))
        {
            if(rating>=4.5 && rating<=5){
                bonus=10*rating;
            }else if(rating>=4 && rating<4.5){
                bonus=5*rating;
            }
        }else if(cabServiceName.equals("UBER"))
        {
            if(rating>=4.5 && rating<=5){
                bonus=8*rating;
            }else if(rating>=4 && rating<4.5){
                bonus=3*rating;
            }
        }
        return Math.round(bonus * 100.00)/100.00;
    }
}

class Driver {
    private String driverName;
    private float averageRating;

    public Driver(String driverName, float averageRating) {
        this.driverName = driverName;
        this.averageRating = averageRating;
    }

    public String getDriverName() {
        return this.driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public float getAverageRating() {
        return this.averageRating;
    }

    public void setAverageRating(float averageRating) {
        this.averageRating = averageRating;
    }

    /*public String toString() {
        return "Driver\ndriverName: " + this.driverName + "\naverageRating: " + this.averageRating;
    }*/
}

public class Association_Exercise0 {
    public static void main(String[] args){
        CabServiceProvider csp = new CabServiceProvider("OLA", 50);
        Driver driver1 = new Driver("Luke", 4.8f);
        Driver driver2 = new Driver("Mark", 4.2f);
        Driver driver3 = new Driver("David", 3.9f);
        //System.out.println("DETAILS:"+driver1);
        Driver[] drivers = { driver1, driver2, driver3 };
        for (Driver driver : drivers) {
            System.out.println("Driver Name: "+driver.getDriverName());
            double bonus = csp.calculateRewardPrice(driver);
            if (bonus>0)
                System.out.println("Bonus: $"+bonus+"\n");
            else
                System.out.println("Sorry, bonus is not available!");
        }
    }
}

