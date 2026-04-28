package com.regex.practice;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex_Validation_0 {
    public static boolean checkNameValidity(String name) {
        /*Rules:
        * The length of the name shd be b/w 2 and 30 chars (both inclusive)
        * The name can contain only alphabets and spaces
        * The 1st char of each word of the name shd be an UC
        * Each word shd be separated by a space
        * The name shd not start or end with a space
        * special chars shd not be allowed */

        if(name.length()<2 || name.length()>30) return false;
        return name.matches("[A-Z][A-Za-z]*( [A-Z][A-Za-z]*)*");
    }
    public static boolean checkPasswordValidity(String password) {
        // Regex explanation:
        // ^                         -> start of string
        // (?=.*[a-z])               -> at least one lowercase letter
        // (?=.*[A-Z])               -> at least one uppercase letter
        // (?=.*[0-9])               -> at least one digit
        // (?=.*[!@#$%&*_])          -> at least one special character
        // [A-Za-z\\d!@#$%&*_]{8,20} -> allowed characters & length (8–20)
        // $                         -> end of string
        // or use -> ^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%&*_])(?=\S+$).{8,20}$
        String regex = "^(?=.*[0-9])"+"(?=.*[a-z])(?=.*[A-Z])"+"(?=.*[!@#$%&*_])"+"(?=\\S+$).{8,20}$";
        return password.matches(regex);
    }
    public static boolean checkWebAddressValidity(String webAddress) {
        /*The web address should start with http or https
        http or https should be followed by ://
        The web address may have 'www.'
        The web address can be alphanumeric
        After . (except the . after www), the web address should contain either "com" or "org" or "net"
        */
        // we can use \\. or [.]
        String regex = "^(http|https)(://)(www.)?[a-zA-Z0-9]{2,8}[.](com|org|net)$";
        return webAddress.matches(regex);
    }
    public static boolean checkMobileNumberValidity(String mobileNo){
        Pattern pattern = Pattern.compile("^(0|91)?[6789][0-9]{9}$");
        Matcher matcher = pattern.matcher(mobileNo);

        return matcher.find() && matcher.group().equals(mobileNo);
    }
    public static boolean checkEmailValidity(String email){
        Pattern pattern = Pattern.compile("^[a-zA-Z0-9]+([._%+-]?[a-zA-Z0-9]+)*@[a-zA-Z0-9]+(\\.[a-zA-Z]{2,})+$");
        Matcher matcher = pattern.matcher(email);
        return matcher.find() && matcher.group().equals(email);
    }
    public static void main(String[] args) {
        String name = "SirAlexander Fleming SirAlexand";
        System.out.println("The name is "+ (checkNameValidity(name) ? "valid!" : "invalid!"));
        String password = "P@$sW0rd";
        System.out.println("The password is "+ (checkPasswordValidity(password) ? "valid!" : "invalid!"));
        String webAddress = "http://www.google.com";
        System.out.println("The web address is "+ (checkWebAddressValidity(webAddress) ? "valid!" : "invalid!"));
        String mobileNumber="919912017943";
        System.out.println("The mobile number is "+(checkMobileNumberValidity(mobileNumber)?"VALID":"INVALID"));
        String email = "sumanthraj529@gmail.com";
        System.out.println("The email is:"+(checkEmailValidity(email)?"VALID":"INVALID"));
    }
}

