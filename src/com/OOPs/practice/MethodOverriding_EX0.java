package com.OOPs.practice;

class User{
    private int id;
    private String userName;
    private String emailId;
    private double walletBalance;
    public User(int id,String userName,String emailId,double walletBalance){
        this.id=id;
        this.userName=userName;
        this.emailId=emailId;
        this.walletBalance=walletBalance;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getEmailId() {
        return emailId;
    }
    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }
    public double getWalletBalance() {
        return walletBalance;
    }
    public void setWalletBalance(double walletBalance) {
        this.walletBalance = walletBalance;
    }
    public boolean makePayment(double billAmount){
        if(billAmount<=getWalletBalance()){
            setWalletBalance(getWalletBalance() - billAmount);
            return true;
        }
        return false;
    }
}
class PremiumUser extends User{
    private int rewardPoints;
    public PremiumUser(int id,String userName,String emailId,double walletBalance){
        super(id,userName,emailId,walletBalance);
    }
    public int getRewardPoints() {
        return rewardPoints;
    }
    public void setRewardPoints(int rewardPoints) {
        this.rewardPoints = rewardPoints;
    }
    /*
        @Override method description:
        Override the parent method to make payment as well as to credit reward points to the user.
        If the payment is successful, add 10% of the billAmount as rewardPoints
        Return true if the payment is successful, else return false
    */
    @Override
    public boolean makePayment(double billAmount) {
        if(billAmount <= getWalletBalance()){
            setRewardPoints(getRewardPoints()+(int)(billAmount*0.1));
        }
        return super.makePayment(billAmount);
    }
}

class MethodOverriding_EX0 {
    public static void main(String[] args) {
        User u = new User(101, "Joe", "joe@abc.com", 100);
        PremiumUser pu = new PremiumUser(201, "Jill", "jill@abc.com", 300);
        processPayment(u, 70);
        processPayment(pu, 150);
        processPayment(pu, 80);
        processPayment(pu, 120);
    }
    public static void processPayment(User user, double billAmount) {
        if (user.makePayment(billAmount)) {
            System.out.println("Congratulations " + user.getUserName() + ", payment of $" + billAmount + " was successful!");
        } else {
            System.out.println("Sorry " + user.getUserName() + ", you do not have enough balance to pay the bill!");
        }
        System.out.println("Your wallet balance is $" + user.getWalletBalance());
        if (user instanceof PremiumUser) {
            PremiumUser premiumUser = (PremiumUser) user; //downcasting
            System.out.println("You have " + premiumUser.getRewardPoints() + " points!");
        }
        System.out.println();
    }
}

