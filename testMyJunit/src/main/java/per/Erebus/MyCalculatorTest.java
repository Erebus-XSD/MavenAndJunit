package per.Erebus;

import com.yc.biz.Calculator;
import per.Erebus.junit.*;

public class MyCalculatorTest {

    private Calculator cal;

    @MyBeforeClass
    public static void bc(){
        System.out.println("beforeClass");
    }
    @MyAfterClass
    public static void af(){
        System.out.println("afterClass");
    }

    @MyBefore
    public void setUp() throws Exception {
        System.out.println("Before===");
        cal=new Calculator();

    }

    @MyAfter
    public void tearDown() throws Exception {
        System.out.println("After===");
    }

    @MyTest
    public void add() {
        System.out.println("add=====");

    }

    @MyTest
    public void sub() {
        System.out.println("sub=====");

    }
}