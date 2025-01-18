package com.app.myapp.examples;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("TestInfo Demo")
public class TestInfoDemo {

//    //if a constructor or method parameter is of type TestInfo, the
//    //TestInfoParameterResolver will supply an instance of TestInfo corresponding to the current
//    //container or test as the value for the parameter.
//    public TestInfoDemo(TestInfo testInfo) {
//        Assertions.assertEquals("TestInfo Demo", testInfo.getDisplayName());
//    }
//
//    @BeforeEach
//    void init(TestInfo testInfo) {
//        String displayName = testInfo.getDisplayName();
//        assertTrue(displayName.equals("TEST 1") || displayName.equals("TEST 2"));
//    }
//
//    @Test
//    @DisplayName("TEST 1")
//    @Tag("my-tag")
//    void test1(TestInfo testInfo) {
//        Assertions.assertEquals("TEST 1", testInfo.getDisplayName());
//        assertEquals("TEST 1", testInfo.getDisplayName());
//        assertTrue(testInfo.getTags().contains("my-tag"));
//    }
//
//    //true when:
//    //@DisplayName("TEST 2")
//    @Test
//    void test2(){
//
//    }
}
