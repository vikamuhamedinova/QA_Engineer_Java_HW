import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FactorialTest {
    Factorial f;

    @BeforeMethod
    public void setUp() {
        f = new Factorial();
    }

    @Test
    public void testCalculate() {
        Factorial f = new Factorial();
        Assert.assertEquals(f.calculate(5), 120);
    }

    @Test
    public void testCalculateZero() {
        Factorial f = new Factorial();
        Assert.assertEquals(f.calculate(0), 1);
    }

    @Test
    public void testCalculateOne() {
        Factorial f = new Factorial();
        Assert.assertEquals(f.calculate(1), 1);
    }

    @Test
    public void testCalculateTwo() {
        Factorial f = new Factorial();
        Assert.assertEquals(f.calculate(2), 2);
    }

    @Test
    public void testCalculateNegativeNumber() {
        Assert.assertEquals(f.calculate(-2), 0);
    }
}
