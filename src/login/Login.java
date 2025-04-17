/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package login;


import java.util.Scanner;
public class Login {
    
//Method to ensure username contains underscore and less or equal to 5
public static boolean checkUserName(String username){
    return username.contains("_") && username.length() <=5;
}  
//method to ensure that passowrd format is correct
//has uppercase,a number, and a special character
public static boolean checkPasswordComplexity(String password){
    boolean hasUppercase = false;
    boolean hasDigit = false;
    boolean hasSpecialChar = false;
    
  // password must be at least 8 characters long  
if (password.length() <8) {
    return false;
}

for (char c : password.toCharArray()) {
    if (Character.isUpperCase(c)){
        hasUppercase = true;
  } else if (Character.isDigit(c)) {
        hasDigit = true;
  } else if (!Character.isLetterOrDigit(c)) {
        hasSpecialChar = true;      
    }
}
return hasUppercase && hasDigit && hasSpecialChar;
}

//Method that checks cellphone number
public static boolean checkPhoneNumber(String phoneNumber) {
    return phoneNumber.startsWith("+27") && phoneNumber.length() == 12;
    
}   
// a Method that registers user and returns a message
public static String registerUser(String firstName, String lastName, String password, String username, String phoneNumber) {
    
boolean validUsername = checkUserName(username);
boolean validPassword = checkPasswordComplexity (password);
boolean validPhone = checkPhoneNumber(phoneNumber);

if (validUsername && validPassword && validPhone) {
    return "Welcome " + firstName + " " + lastName + ", It is great to see you again.";
  } else {
    return "Username and password incorrect, please try again " ;
}
}

// method to enable the user to login
public static boolean loginUser(String registeredUsername, String registeredPassword) {
Scanner scanner = new Scanner (System.in);
System.out.print("Login - enter your username: ");
String inputUsername = scanner.nextLine();

System.out.print("Login - enter your password: ");
String inputPassword = scanner.nextLine();

boolean success = inputUsername.equals(registeredUsername) && inputPassword.equals(registeredPassword);

if (success) {
    System.out.println("Login successful!");
} else {
    System.out.println("Login failed.");
}
return success;
}

//method that returns login status
public static String returnLoginStatus(boolean isLoggedIn) {
    if (isLoggedIn) {
        System.out.println(true);
        return "login was successful";
        
    } else {
        System.out.println(true);
        return "login failed.";
    }
}

    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        
        //Variables
       
        String username;
        String password;
        String phoneNumber;
        String firstName;
        String lastName;
     
        
        System.out.print("Enter Your name: ");
        firstName = scanner. nextLine();
        
        System.out.print("Enter Your LastName: ");
        lastName = scanner. nextLine();
        
    //ask for a valid username    
    while (true) {      
        System.out.print("Enter your username: ");
        username = scanner. nextLine();
        
    if (checkUserName(username)) {
        System.out.println("Username successfully created. ");
        break; //Exit loop when format of username is correct
  
    
    } else {
        System.out.println("Username is not correctly formatted, please ensure that your username contains an underscore and is no more than five characters in length. ");
    }
        }
    //ask user for a valid password    
    while(true){
        System.out.print("Enter your password: ");
       password = scanner.nextLine();
        
    //ask user for a valid passoword  
    if (checkPasswordComplexity(password)){
        System.out.println("Password successfully captured.");
        break;
    } else {
        System.out.println("Password is not correctly formatted, please ensure that the password contains at least eight characters, a capital letter,a number, and a special character");
    }
    }
    //ask for a valid phone number
    while(true){
        System.out.print("Enter your South African phone Number with country code (+27: ");
        phoneNumber = scanner.nextLine();

   if (checkPhoneNumber(phoneNumber)) {
       System.out.println("Cellphone number successfully added. ");
       break;
   } else {
       System.out.println("Cellphone number incorrectly formatted, or does not contain international code.");
   } 
   
    }  
    //registration message
   String result = registerUser(firstName, lastName, username, password, phoneNumber);
    System.out.println(result);
    
    boolean isLoggedIn = loginUser(username, password);
    String loginStatus = returnLoginStatus(isLoggedIn);
    System.out.println(loginStatus);
    
              
    
       scanner.close();
        
       
    }
    
    }


