//package com.app.myapp.examples;
//
//import org.junit.jupiter.api.Disabled;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.condition.DisabledIfEnvironmentVariable;
//import org.junit.jupiter.api.condition.EnabledForJreRange;
//import org.junit.jupiter.api.condition.JRE;
//
//import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertThrows;
//import static org.junit.jupiter.api.Assertions.assertThrowsExactly;
//
////to disable all tests in a class use:
////@Disabled("Disabled until bug #99 has been fixed")
//// @TestInstance(TestInstance.Lifecycle.PER_CLASS) //when you want to have 1 intances of a clas - members of class
//// will shared between test methods without reseting to initial state
//@EnabledForJreRange(min = JRE.JAVA_8, max = JRE.JAVA_23)
//public class ExamplesTest {
//
//    @Disabled("Disabled until bug #42 has been resolved")
//    @Test
//    void failsDueToUncauhgtException() {
//        // The following throws an ArithmeticException due to division by
//        // zero, which causes a test failure.
//        Math.divideExact(1, 0);
//    }
//
//    @EnabledForJreRange(min = JRE.JAVA_8, max = JRE.JAVA_23)
//    @Test
//    void failsDueToUncaughtAssertionError() {
//        // The following incorrect assertion will cause a test failure.
//        // The expected value should be 2 instead of 99.
//        assertEquals(99, Math.addExact(1, 1));
//    }
//
//
//    // assertThrows example
//    @DisabledIfEnvironmentVariable(named = "ENV", matches = "staging-server")
//    @Test
//    void testExpectedExceptionIsThrown() {
//        // The following assertion succeeds because the code under assertion
//        // throws the expected IllegalArgumentException.
//        // The assertion also returns the thrown exception which can be used for
//        // further assertions like asserting the exception message.
//        IllegalArgumentException exception =
//                assertThrows(IllegalArgumentException.class, () -> {
//                    throw new IllegalArgumentException("expected message");
//                });
//
//        assertEquals("expected message", exception.getMessage());
//
//        // The following assertion also succeeds because the code under assertion
//        // throws IllegalArgumentException which is a subclass of RuntimeException.
//        assertThrows(RuntimeException.class, () -> {
//            throw new IllegalArgumentException("expected message");
//        });
//
//    }
//
//    // assertThrowsExactly() example
//    @Test
//    void testExpectedExceptionIsExactlyThrown() {
//        // The following assertion succeeds because the code under assertion throws
//        // IllegalArgumentException which is exactly equal to the expected type.
//        // The assertion also returns the thrown exception which can be used for
//        // further assertions like asserting the exception message.
//        IllegalArgumentException exception =
//                assertThrowsExactly(IllegalArgumentException.class, () -> {
//                    throw new IllegalArgumentException("expected message");
//                });
//
//        assertEquals("expected message", exception.getMessage());
//
//        // The following assertion fails because the assertion expects exactly
//        // RuntimeException to be thrown, not subclasses of RuntimeException.
//        assertThrowsExactly(RuntimeException.class, () -> {
//            throw new IllegalArgumentException("expected message");
//        });
//    }
//
//    @Test
//    void testExceptionIsNotThrown() {
//        assertDoesNotThrow(this::shouldNotThrowException);
//    }
//
//    void shouldNotThrowException() {
//    }
//}
