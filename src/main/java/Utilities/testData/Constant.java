package Utilities.testData;

import org.apache.commons.lang3.RandomStringUtils;

public class Constant {


    public static String randomEmail = "test" + RandomStringUtils.randomAlphabetic(5) + "@gmail.com";
    public static String randomPassword = RandomStringUtils.randomAlphanumeric(8);
    public static String RegisterValidUserName = "test89";
    public static String RegisterValidFirstName = "tester";
    public static String RegisterValidLastName = "tester";
    public static String RegisterValidEmail = "proftester253@gmail.com";
    public static String RegisterValidCountry = "Egypt";
    public static String RegisterValidPassword = "Tester@123";

    public static String RegisterInvalidFirstNameNumeric = "123";
    public static String RegisterInvalidLastNameNumeric = "123";
    public static String RegisterInvalidWeakPassword = "123";
    public static String RegisteredEmail = "proftester25@gmail.com";


    public static String loginValidEmail = "proftester25@gmail.com";
    public static String loginValidPassword = "Tester@123";

    public static String loginInvalidEmail = "ui@gmail.com";
    public static String loginInvalidPassword = "123";

    public static String loginCaseSensitiveEmail ="PROFTESTER25@gmail.com";
    public static String  loginCaseSensitivePassword = "TESTER@123";
}



