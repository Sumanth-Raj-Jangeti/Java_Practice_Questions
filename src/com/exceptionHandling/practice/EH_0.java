package com.exceptionHandling.practice;

class Student {
    private String name;
    protected int[] marks;
    protected float avgScore;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int[] getMarks() {
        return marks;
    }
    public void setMarks(int[] marks) {
        this.marks = marks;
    }
    public float getAvgScore() {
        return avgScore;
    }
    public void setAvgScore(float avgScore) {
        this.avgScore = avgScore;
    }
    //Handling multiple exceptions...
    public void calculateAvgScore() {
        int sum = 0, noOfSubjects = 0;
        try {
            for (int i = 0; i <=marks.length; i++) {
                sum += marks[i];
            }
            this.avgScore = (float) sum / noOfSubjects;
            System.out.println("Avg Score:" + this.avgScore);
        } catch (ArithmeticException e) {
            System.out.println("Cannot divide a number with zero!");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("You have exceeded the array range!");
        } catch (Exception e){
            System.out.println("Some error occurred!");
        }finally {
            /*This block will be executed irrespective of
             * whether an exception occurs or not
             */
            System.out.println("Thank you for using the application!");
        }
    }
}
class UnderGraduateStudent extends Student{
    @Override
    public void calculateAvgScore() {
        int sum=0;
        int totalSubjects=0;
        //outer try block
        try {
            //inner try block
            try {
                for (int i = 0; i<marks.length;i++) {
                    sum+=marks[i];
                }
                this.avgScore= (float) sum /totalSubjects;//Exception will be raised as totalSubjects is 0
                System.out.println("Average Marks: "+ this.avgScore);
            }
            //inner catch block
            catch(ArithmeticException e) {
                //This block will only execute if any Arithmetic exception occurs in try block
                System.out.println("Divide by Zero exception occurred!");
            }
            catch(ArrayIndexOutOfBoundsException e) {
                //This block will only execute if any ArrayIndexOutOfBoundsException occurs in try block
                System.out.println("Array index out of range exception occurred!");
            }
        }
        //outer catch block
        catch(Exception e) {
            //This block will handle all types of exceptions that occur in try block
            System.out.println("Some error occurred!");
        }
        finally {
            /*This block will be executed irrespective of
             * whether an exception occurs or not
             */
            System.out.println("Thank you for using the application!");
        }
    }
}
//Creating a custom checked exception...
class NegativeElementException extends Exception{
    public NegativeElementException(String message){
        super(message);
    }
}
class PostGraduateStudent extends Student{
    //Usage of throw keyword.
    @Override
    public void calculateAvgScore() {
        int sum = 0, noOfSubjects = 0;
        try {
            for (int i = 0; i<marks.length; i++) {
                if (marks[i] < 0) {
                    // Throwing exception manually in case of negative marks
                    // value
                    throw new NegativeElementException("Marks cannot be negative!");
                }
                sum += marks[i];
                noOfSubjects++;
            }
            this.avgScore = (float) sum /noOfSubjects;
            System.out.println("Avg Score:" + this.avgScore);
        } catch (ArithmeticException e) {
            System.out.println("Cannot divide a number with zero!");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("You have exceeded the array range!");
        } catch (NegativeElementException e){
            System.out.println(e.getMessage());
        }finally {
            /*This block will be executed irrespective of
             * whether an exception occurs or not
             */
            System.out.println("Thank you for using the application!");
        }
    }
}
public class EH_0 {
    public static void main(String[] args) {
        Student s1 = new Student();
        int[] marks = {67,89,34,56,70,54};
        s1.setMarks(marks);
        s1.calculateAvgScore();
        System.out.println();
        Student ug = new UnderGraduateStudent();
        ug.setMarks(new int[]{67,89,34,56,70,54});
        ug.calculateAvgScore();
        System.out.println();
        PostGraduateStudent pg = new PostGraduateStudent();
        pg.setMarks(new int[]{54,-10,61,45});
        pg.calculateAvgScore();
    }
}
