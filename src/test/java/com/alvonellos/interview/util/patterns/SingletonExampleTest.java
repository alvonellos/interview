package com.alvonellos.interview.util.patterns;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SingletonExampleTest {
    @Test
    void getInstance() {
        SingletonExample instance = SingletonExample.getInstance();
        assertNotNull(instance);
        assertEquals(instance, SingletonExample.getInstance());
    }
}