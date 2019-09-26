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

    @Test
    public void testSubtract() {
    }

    @DataProvider
    Object[][] additionData() {
        return new Object[][] {
            new Object[] { 1, 2, 3 },
            new Object[] { 2, 5, 7 },
            new Object[] { 11, 157, 168 }
        };
    }

}