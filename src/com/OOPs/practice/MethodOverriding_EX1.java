package com.OOPs.practice;

class Faculty{
    //Implement your code here
    private String name;
    private float basicSalary;
    private float bonusPercentage;
    private float carAllowancePercentage;
    public Faculty(String name,float basicSalary){
        this.name=name;
        this.basicSalary=basicSalary;
        this.bonusPercentage=4;
        this.carAllowancePercentage=2.5f;
    }
    public double calculateSalary(){
        double bonus = (bonusPercentage / 100.0) * basicSalary;
        double carAllowance = (carAllowancePercentage / 100.0) * basicSalary;
        return (basicSalary + bonus + carAllowance);
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name=name;
    }
    public float getBasicSalary(){
        return basicSalary;
    }
    public void setBasicSalary(float basicSalary){
        this.basicSalary=basicSalary;
    }
    public float getBonusPercentage(){
        return bonusPercentage;
    }
    public void setBonusPercentage(float bonusPercentage){
        this.bonusPercentage=bonusPercentage;
    }
    public float getCarAllowancePercentage(){
        return carAllowancePercentage;
    }
    public void setCarAllowancePercentage(float carAllowancePercentage){
        this.carAllowancePercentage=carAllowancePercentage;
    }
}

class OfficeStaff extends Faculty{
    //Implement your code here
    private String designation;
    public OfficeStaff(String name,float basicSalary,String designation){
        super(name,basicSalary);
        this.designation=designation;
    }
    public double calculateSalary(){
        double salary = super.calculateSalary();
        if("Accountant".equals(this.designation))  return salary + 10000.0;
        else if("Clerk".equals(this.designation))  return salary + 7000.0;
        else if("Peon".equals(this.designation))   return salary + 4500.0;
        else return salary;
    }
    public String getDesignation(){
        return designation;
    }
    public void setDesignation(String designation){
        this.designation=designation;
    }
}

class Teacher extends Faculty{
    //Implement your code here
    private String qualification;
    public Teacher(String name,float basicSalary,String qualification){
        super(name,basicSalary);
        this.qualification=qualification;
    }
    public double calculateSalary(){
        double salary = super.calculateSalary();
        if("Doctoral".equals(this.qualification)) return salary + 20000.0;
        else if("Masters".equals(this.qualification)) return salary + 18000.0;
        else if("Bachelors".equals(this.qualification)) return salary + 15500.0;
        else if("Associate".equals(this.qualification)) return salary + 10000.0;
        else return salary;
    }
    public String getQualification(){
        return qualification;
    }
    public void setQualification(String qualification){
        this.qualification=qualification;
    }
}
public class MethodOverriding_EX1 {
    public static void main(String[] args) {

        Teacher teacher = new Teacher("Caroline", 30500f, "Masters");
        OfficeStaff officeStaff = new OfficeStaff("James", 24000f, "Accountant");

        System.out.println("Teacher Details\n***************");
        System.out.println("Name: "+teacher.getName());
        System.out.println("Qualification: "+teacher.getQualification());
        System.out.println("Total salary: $" + Math.round(teacher.calculateSalary()*100)/100.0);
        System.out.println();

        System.out.println("Office Staff Details\n***************");
        System.out.println("Name: "+officeStaff.getName());
        System.out.println("Designation: "+officeStaff.getDesignation());
        System.out.println("Total salary: $" + Math.round(officeStaff.calculateSalary()*100)/100.0);

        //Create more objects for testing your code

    }
}

