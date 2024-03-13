package com.example;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class TestA6 {
    private A6 a6_tester;

    @Before
    public void setup(){
        a6_tester = new A6();
    }

    @Test
    public void test_length_check(){
        String test_str_0 = "abcd";
        String test_str_1 = "abcdefg";

        assertTrue("str shorter than 5", a6_tester.length_check(test_str_0));
        assertFalse("str longer than 5", a6_tester.length_check(test_str_1));
    }
}
