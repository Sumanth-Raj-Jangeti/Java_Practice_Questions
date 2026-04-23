package com.OOPs.practice;

public class WrapperClasses {
    public static void main(String[] args) {
        // Comparison of Integer objects
        Integer x = 5;
        Integer y = new Integer(5); // int data converted to Integer object
        System.out.println("x == y: " + (x == y));
        System.out.println("x.equals(y): " + x.equals(y));

        // Wrap the primitive content into wrapper class objects
        int z = 100;
        Integer number = Integer.valueOf(z);
        System.out.println("Wrapping "+z+" to its Integer: " + number);
        System.out.println("Check if number is of type Integer: "
                + (number instanceof Integer));

        // Wrappers can be used to convert numeric strings to numeric datatypes
        String numStr = "123";
        int numInt = Integer.parseInt(numStr);
        System.out.println("String to integer: " + numInt);

        String doubleStr = "123.45";
        double numDouble = Double.parseDouble(doubleStr);
        System.out.println("String to double: " + numDouble);

        // Type casting cannot be used to convert any wrapper type to another,
        // it will give compilation error
        /* Uncomment the below code and observe the output*/
        //Long phoneNoLong = (Long) new Integer(44281234);

        // We can make use of methods like intValue(), byteValue(),
        // floatValue(), etc. for conversion
        Integer phoneNo = 44281234;
        // longValue() converts the Integer value to long data type
        Long phoneNoLong = phoneNo.longValue();
        System.out.println("Integer to Long: " + phoneNoLong);

        // Converts the Integer object to binary value
        System.out.println("Integer 5 as binary string: "
                + Integer.toBinaryString(5));

        /*
            Java caches Integer objects in the range:
            -128 to 127
            This is done for memory optimization.

            First case: 100
            Integer a = 100;
            Integer b = 100;
            100 is within cache range (-128 to 127)
            So both a and b point to same object

            Second case: 200
            Integer c = 200;
            Integer d = 200;
            200 is outside cache range
            So Java creates two different objects
        */
        Integer a=100,b=100;
        System.out.println("(a==b)?"+(a==b)+",(a.equals(b))?"+a.equals(b));
        Integer c=200,d=200;
        System.out.println("(c==d)?"+(c==d)+",(c.equals(d))?"+c.equals(d));
    }
}