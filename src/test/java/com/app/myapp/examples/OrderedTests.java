package com.app.myapp.examples;


import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

//sorts test methods alphanumerically based on their display names
//@TestMethodOrder(MethodOrderer.DisplayName.class)

//sorts test methods alphanumerically based on their names and formal
//parameter lists
//@TestMethodOrder(MethodOrderer.MethodName:.class)

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class OrderedTests {

    @Test
    @Order(1)
    void nullValues() {
        // perform assertions against null values
    }

    @Test
    @Order(2)
    void emptyValues() {
        // perform assertions against empty values
    }

    @Test
    @Order(3)
    void validValues() {
        // perform assertions against valid values
    }
}
