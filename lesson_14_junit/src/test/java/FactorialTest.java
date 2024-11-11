import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class FactorialTest {
    Factorial f;

    @BeforeEach
    void setUp() {
        f = new Factorial();
    }

    @Test
    public void testCalculate() {
        Assertions.assertEquals(f.calculate(5), 120);
    }

    @Test
    public void testCalculateZero() {
        Assertions.assertEquals(f.calculate(0), 1);
    }

    @Test
    public void testCalculateOne() {
        Assertions.assertEquals(f.calculate(1), 1);
    }

    @Test
    public void testCalculateTwo() {
        Assertions.assertEquals(f.calculate(2), 2);
    }

    @Test
    public void testCalculateNegativeNumber() {
        Assertions.assertEquals(f.calculate(-2), 0);
    }
}
