package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Kai on 7/8/2018.
 */
public class UserTest {

    User testUser = new User("123-1234");

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

    


}
