package com.OOPs.practice.abstraction;

abstract class Student{
    private String studentName;
    private int[] testScores;
    private String testResult;
    public Student(String studentName) {
        this.studentName=studentName;
        this.testScores=new int[4]; //This is the way to initialize the array with default values...
    }
    abstract void generateResult();
    public String getStudentName() {
        return studentName;
    }
    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }
    public String getTestResult() {
        return testResult;
    }
    public void setTestResult(String testResult) {
        this.testResult = testResult;
    }
    public int[] getTestScores(){
        return testScores;
    }
    public void setTestScore(int testNumber,int testScore) {
        testScores[testNumber]=testScore;
    }
}
class UndergraduateStudent extends Student {
    public UndergraduateStudent(String studentName) {
        super(studentName); //Calling superclass constructor
    }
    @Override
    public void generateResult() {
        int sum=0;
        double avg;
        for(int score:getTestScores())
        {
            sum+=score;
        }
        avg=(double) sum/getTestScores().length;
        if(avg>=60) setTestResult("Pass");
        else setTestResult("Fail");
    }
}
class GraduateStudent extends Student {
    public GraduateStudent(String studentName){
        super(studentName);
    }
    @Override
    public void generateResult() {
        int sum=0;
        double avg;
        for(int score:getTestScores())
        {
            sum+=score;
        }
        avg=(double) sum/getTestScores().length;
        if(avg>=70) setTestResult("Pass");
        else setTestResult("Fail");
    }
}
public class AbstractClassExercise {
    public static void main(String[] args) {
        UndergraduateStudent undergraduateStudent = new UndergraduateStudent("Philip");
        undergraduateStudent.setTestScore(0, 70);
        undergraduateStudent.setTestScore(1, 69);
        undergraduateStudent.setTestScore(2, 71);
        undergraduateStudent.setTestScore(3, 55);

        undergraduateStudent.generateResult();

        System.out.println("Student name: "+undergraduateStudent.getStudentName());
        System.out.println("Result: "+undergraduateStudent.getTestResult());

        System.out.println();

        GraduateStudent graduateStudent = new GraduateStudent("Jerry");
        graduateStudent.setTestScore(0, 70);
        graduateStudent.setTestScore(1, 69);
        graduateStudent.setTestScore(2, 71);
        graduateStudent.setTestScore(3, 55);

        graduateStudent.generateResult();

        System.out.println("Student name: "+graduateStudent.getStudentName());
        System.out.println("Result : "+graduateStudent.getTestResult());
    }
}
