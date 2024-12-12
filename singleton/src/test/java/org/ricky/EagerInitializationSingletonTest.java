package org.ricky;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Ricky
 * @version 1.0
 * @date 2024/12/12
 * @className EagerInitializationSingletonTest
 * @desc
 */
class EagerInitializationSingletonTest {

    @Test
    void should_create_single_instance() {
        // Given
        EagerInitializationSingleton i1 = EagerInitializationSingleton.getInstance();
        EagerInitializationSingleton i2 = EagerInitializationSingleton.getInstance();

        // When
        i1.method();
        i2.method();

        // Then
        assertEquals(i1, i2);
    }

    @Test
    void should_thread_safety() throws InterruptedException {
        int n = 10;
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < n; ++i) {
                EagerInitializationSingleton.getInstance().method();
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < n; ++i) {
                EagerInitializationSingleton.getInstance().method();
            }
        });

        t1.join();
        t2.join();

        t1.start();
        t2.start();
    }

}