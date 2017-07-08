package com.sake.core;

import com.sake.core.algorithms.FirstRepeatingChar;
import junit.framework.TestCase;

/**
 * Created by sakez on 7/8/17
 * This is a test class for FirstNonRepeatingChar class
 */

public class FirstRepeatingCharTest extends TestCase{

    private static String testStr;
    private static String expected = "a";

    public void setUp(){
        testStr = "vacation";
    }

    public void testFirstRepeatingChar(){
        String actual = FirstRepeatingChar.firstRepeatingLetter(testStr);
        assertEquals(expected,actual);

    }

    public void tearDown(){
        testStr = null;
    }

}
