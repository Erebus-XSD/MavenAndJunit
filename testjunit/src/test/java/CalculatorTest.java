import com.yc.biz.Calculator;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CalculatorTest {

    private Calculator cal;

    @Before
    public void setUp() throws Exception {
        System.out.println("Before===");
        cal=new Calculator();

    }

    @After
    public void tearDown() throws Exception {
        System.out.println("After===");
    }

    @Test
    public void add() {
        System.out.println("add=====");
        Assert.assertEquals(3,cal.add(1,2));

    }

    @Test
    public void sub() {
        System.out.println("sub=====");
        Assert.assertEquals(1,cal.sub(2,1));

    }
}