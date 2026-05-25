package org.example.stack;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ValidParenthesesTest {

    ValidParentheses validParentheses = new ValidParentheses();

    @Test
    public void testIsValid() {
        Assert.assertTrue(validParentheses.isValid("()"));
    }

    @Test
    public void testIsValid_2() {
        Assert.assertTrue(validParentheses.isValid("()[]{}"));
    }

    @Test
    public void testIsValid_3() {
        Assert.assertFalse(validParentheses.isValid("(]"));
    }

    @Test
    public void testIsValid_4() {
        Assert.assertTrue(validParentheses.isValid("([])"));
    }

    @Test
    public void testIsValid_5() {
        Assert.assertFalse(validParentheses.isValid("([)]"));
    }
}
