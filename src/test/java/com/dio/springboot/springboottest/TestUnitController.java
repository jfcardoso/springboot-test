package com.dio.springboot.springboottest;

import com.dio.springboot.springboottest.controller.TestController;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class TestUnitController {

    TestController controller = new TestController();
    @Test
    public void testarSaudação(){

        String nome = controller.saudacao("Pedro");
        assertEquals("Bem-vindo, Pedro!", nome );
    }
}
