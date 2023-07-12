package be.technifutur.decouverte.junit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;

public class HelloTest {

    private int cpt = 0;

    HelloTest(){
        cpt++;
    }
    @BeforeEach
    void beforeEach(){
        System.out.println("HelloTest.beforeEach");
    }

    @BeforeAll
    static void beforAll(){
        System.out.println("HelloTest.beforAll");
    }

    @AfterEach
    void afterEach(){
        System.out.println("HelloTest.afterEach");
    }

    @AfterAll
    static void afterAll(){
        System.out.println("HelloTest.afterAll");
    }
    @Test
    void testHello(){
        System.out.println(cpt++);
        assertTrue(1+1==2,"1+1 = 2");
    }
    @Test
    void testHello1(){
        System.out.println(cpt++);
        assertTrue(1+1==2,"1+1 = 2");
    }
    @Test
    void testHello2(){
        System.out.println(cpt++);
        assertTrue(1+1==2,"1+1 = 2");
    }
}
