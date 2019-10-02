package org.achievementnetwork.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class MathSingletonTest {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Test
    public void testGetInstance() {
        MathSingleton ms1 = MathSingleton.getInstance();
        assertNotNull(ms1);

        MathSingleton ms2 = MathSingleton.getInstance();
        assertSame(ms2, ms1);

        logger.debug("Objects are identical");
    }

    @Test(dataProvider = "additionData")
    public void testAdd(int a, int b, int expected) {
        MathSingleton mathSingleton = MathSingleton.getInstance();
        int actual = mathSingleton.add(a, b);
        assertEquals(actual, expected);
    }

    @Test(dataProvider = "subtractionData")
    public void testSubtract(int a, int b, int expected) {
        MathSingleton mathSingleton = MathSingleton.getInstance();
        int actual = mathSingleton.subtract(a, b);
        assertEquals(actual, expected);
    }

    @Test(dataProvider = "multiplicationData")
    public void testMultiply(int a, int b, int expected) {
        MathSingleton mathSingleton = MathSingleton.getInstance();
        int actual = mathSingleton.multiply(a, b);
        assertEquals(actual, expected);
    }

    @Test(dataProvider = "divisionData")
    public void testDivide(int a, int b, int expected) {
        MathSingleton mathSingleton = MathSingleton.getInstance();
        int actual = mathSingleton.divide(a, b);
        assertEquals(actual, expected);
    }

    @DataProvider
    Object[][] additionData() {
        return new Object[][] {
            new Object[] { 1, 2, 3 },
            new Object[] { 2, 5, 7 },
            new Object[] { 11, 157, 168 }
        };
    }

    @DataProvider
    Object[][] subtractionData() {
        return new Object[][] {
                new Object[] { 4, 2, 2 },
                new Object[] { 5, 4, 1 },
                new Object[] { 100, 23, 77 }
        };
    }

    @DataProvider
    Object[][] multiplicationData() {
        return new Object[][] {
                new Object[] { 2, 2, 4 },
                new Object[] { 5, 4, 20 },
                new Object[] { 100, 23, 2300 }
        };
    }

    @DataProvider
    Object[][] divisionData() {
        return new Object[][] {
                new Object[] { 2, 2, 1 },
                new Object[] { 20, 4, 5 },
                new Object[] { 100, 25, 4 }
        };
    }

}