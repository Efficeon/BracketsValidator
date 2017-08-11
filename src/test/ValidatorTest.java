import com.bracketsvalidator.BracketsValidator;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ValidatorTest {
    private BracketsValidator bracketsValidator = new BracketsValidator();

    private static final String correct = "[({})]";
    private static final String incorrect = "[([)";

    @Test
    public void bracketTestIsEmpty(){
        boolean expected = true;
        boolean actual = bracketsValidator.verify("");
        assertEquals("String is empty", expected, actual);
    }

    @Test
    public void bracketTestIsCorrect(){
        boolean expected = true;
        boolean actual = bracketsValidator.verify(correct);
        assertEquals("String is correct", expected, actual);
    }

    @Test
    public void bracketTestIsInVCorrect(){
        boolean expected = false;
        boolean actual = bracketsValidator.verify(incorrect);
        assertEquals("String is incorrect", expected, actual);
    }

    @Test
    public void bracketTestIsNested(){
        boolean expected = true;
        boolean actual = bracketsValidator.verify("bar{[(abc)]foo[def]}");
        assertEquals("String is correct", expected, actual);
    }

    @Test
    public void bracketTestIsFalse(){
        boolean expected = false;
        boolean actual = bracketsValidator.verify("}[]{");
        assertEquals("String is incorrect", expected, actual);
    }
}
