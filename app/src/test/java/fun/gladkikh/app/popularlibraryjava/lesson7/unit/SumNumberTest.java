package fun.gladkikh.app.popularlibraryjava.lesson7.unit;

import junit.framework.TestCase;

import org.junit.Test;

public class SumNumberTest extends TestCase {

    @Test
    public void testPlus() {
        SumNumber sumNumber = new SumNumber();
        int result = sumNumber.plus(2, 2);
        assertEquals(4, result);
    }
}