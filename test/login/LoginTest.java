/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package login;


import org.junit.Test;
import static org.junit.Assert.*;

public class LoginTest {

    @Test
    public void testCheckUserName_Valid() {
        assertTrue(Login.checkUserName("Skh__2"));
    }

    @Test
    public void testCheckUserName_Invalid_NoUnderscore() {
        assertFalse(Login.checkUserName("abcde"));
    }

    @Test
    public void testCheckUserName_Invalid_TooLong() {
        assertFalse(Login.checkUserName("long_name"));
    }

    @Test
    public void testCheckPasswordComplexity_Valid() {
        assertTrue(Login.checkPasswordComplexity("Passw0rd!"));
    }

    @Test
    public void testCheckPasswordComplexity_MissingUppercase() {
        assertFalse(Login.checkPasswordComplexity("password1!"));
    }

    @Test
    public void testCheckPasswordComplexity_MissingDigit() {
        assertFalse(Login.checkPasswordComplexity("Password!"));
    }

    @Test
    public void testCheckPasswordComplexity_MissingSpecialChar() {
        assertFalse(Login.checkPasswordComplexity("Password1"));
    }

    @Test
    public void testCheckPhoneNumber_Valid() {
        assertTrue(Login.checkPhoneNumber("+27663551200"));
    }

    @Test
    public void testCheckPhoneNumber_Invalid_NoPlus27() {
        assertFalse(Login.checkPhoneNumber("0663551200"));
    }

    @Test
    public void testReturnLoginStatus_Success() {
        String expected = "Welcome Sandile Khoza, It is great to see you again.";
        String actual = Login.returnLoginStatus(true, "Sandile", "Khoza");
        assertEquals(expected, actual);
    }

    @Test
    public void testReturnLoginStatus_Failure() {
        String expected = "Username and password incorrect, please try again";
        String actual = Login.returnLoginStatus(false, "Sandile", "Khoza");
        assertEquals(expected, actual);
    }
}
