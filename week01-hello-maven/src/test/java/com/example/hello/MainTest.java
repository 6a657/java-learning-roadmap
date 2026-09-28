package com.example.hello;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    void testGreet() {
        Main main = new Main();
        assertEquals("Hello, Maven!", main.greet("Maven"));
    }
}