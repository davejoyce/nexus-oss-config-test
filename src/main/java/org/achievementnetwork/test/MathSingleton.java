package org.achievementnetwork.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Pointless use of the Singleton pattern for a basic math utility.
 */
public class MathSingleton {

    /**
     * Static holder class for lazy, thread safe instantiation of the singleton
     * instance of {@code MathSingleton}.
     */
    private static final class SingletonHolder {

        static final MathSingleton INSTANCE = new MathSingleton();

    }

    /**
     * Get the singleton MathSingleton object instance. This factory method is
     * thread safe.
     *
     * @return initialized MathSingleton object
     */
    public static MathSingleton getInstance() {
        return SingletonHolder.INSTANCE;
    }

    private final AtomicInteger operationCounter;
    private final Logger logger;

    private MathSingleton() {
        operationCounter = new AtomicInteger(0);
        logger = LoggerFactory.getLogger(this.getClass());
    }

    public int add(int a, int b) {
        operationCounter.incrementAndGet();
        int c = (a + b);
        logger.debug("{} + {} = {}", a, b, c);
        return c;
    }

    public int subtract(int a, int b) {
        operationCounter.incrementAndGet();
        int c = (a - b);
        logger.debug("{} - {} = {}", a, b, c);
        return c;
    }

    public int multiply(int a, int b) {
        operationCounter.incrementAndGet();
        int c = (a * b);
        logger.debug("{} × {} = {}", a, b, c);
        return c;
    }

    public int divide(int a, int b) {
        operationCounter.incrementAndGet();
        int c = (a / b);
        logger.debug("{} ÷ {} = {}", a, b, c);
        return c;
    }

    public int operationCount() {
        return operationCounter.get();
    }

}
