package Test;
import static org.junit.Assert.assertEquals;
import org.junit.Test;


public class TestDecode {
    @Test //проверка десятичного числа
    public void testValidString() {
        int num = Integer.decode("123");
        assertEquals(123, num);
    }

    @Test //шестнадцатеричное число
    public void testWithHexPrefix() {
        int num = Integer.decode("0x1f");
        assertEquals(31, num);
    }

    @Test //восьмеричное число
    public void testWithOctalPrefix() {
        int num = Integer.decode("037");
        assertEquals(31, num);
    }

    @Test(expected = NumberFormatException.class) //если значение null
    public void testValueNull() {
        Integer.decode("");
    }

    @Test(expected = NumberFormatException.class)
    public void testInvalidString() {
        Integer.decode("abc");
    }

    @Test(expected = NumberFormatException.class) //неправильное положение знака
    public void testWrongPosition() {
        Integer.decode("0x-12");
    }

    @Test
    public void testMaxValue() {
        int num = Integer.decode("2147483647");
        assertEquals(Integer.MAX_VALUE, num);
    }

    @Test
    public void testMinValue() {
        int num = Integer.decode("-2147483648");
        assertEquals(Integer.MIN_VALUE, num);
    }

    @Test(expected = NumberFormatException.class) //выходит за пределы
    public void testExceedingMaxValue() {
        Integer.decode("2147483648");
    }

    @Test(expected = NumberFormatException.class) //выходит за пределы
    public void testExceedingMinValue() {
        Integer.decode("-2147483649");
    }
}
