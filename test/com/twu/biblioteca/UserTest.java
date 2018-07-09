package com.twu.biblioteca;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

/**
 * Created by Kai on 7/8/2018.
 */
public class UserTest {

    User testUser = new User("123-1234");
    private final ByteArrayOutputStream printValue = new ByteArrayOutputStream();

    @Before
    public void setUp() {
        System.setOut(new PrintStream(printValue));
    }

    @After
    public void cleanUpStreams() {
        System.setOut(null);
    }

    @Test
    public void passwordTest(){
        String password1 = "booksRock";
        String password2 = "password123";

        testUser.setPassword(password1);
        assertEquals(true, testUser.checkPassword(password1));
        assertEquals(false, testUser.checkPassword(password2));

        testUser.setPassword(password2);
        assertEquals(true, testUser.checkPassword(password2));
        assertEquals(false, testUser.checkPassword(password1));



    }

    @Test
    public void infoTest(){
        testUser.setName("Jackie Willams");
        testUser.setEmail("washer12@gmail.com");
        testUser.setPhone("678-234-1234");
        assertEquals("Jackie Willams", testUser.getName());
        assertEquals("washer12@gmail.com", testUser.getEmail());
        assertEquals("678-234-1234", testUser.getPhone());

        assertEquals(false, testUser.setEmail("washer12@.com"));
        assertEquals(false, testUser.setPhone("68-234-1234"));

    }

    @Test
    public void numTest(){
        assertEquals("123-1234", testUser.getLibNum());
    }

    @Test
    public void printUserInfo(){
        testUser.printUserInfo();
        String test = "Name: " + testUser.getName() + "(Library Number: " + testUser.getLibNum() + ")\n" + "Info:\n" +
                "\temail: " + testUser.getEmail() + "\n\tphone: " + testUser.getPhone() + "\n";
        assertEquals(printValue.toString(), test);
    }

}
