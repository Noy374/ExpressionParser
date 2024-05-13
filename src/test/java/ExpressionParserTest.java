
import org.example.ExpressionParser;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

import static org.example.ExpressionParser.evaluateExpression;
import static org.junit.jupiter.api.Assertions.assertEquals;



public class ExpressionParserTest {

    @Test
    public void testEvaluateSimpleArithmeticExpression() {
        assertEquals(6.0, evaluateExpression("2+2*2"), 0.0001);
    }

    @Test
    public void testEvaluateExpressionWithVariables() {
        System.setIn(new ByteArrayInputStream("2".getBytes()));
        assertEquals(8.0, evaluateExpression("2+x*3"), 0.0001);
        System.setIn(System.in);
    }

    @Test
    public void testEvaluateExpressionWithVariablesAndBrackets() {
        System.setIn(new ByteArrayInputStream("2".getBytes()));
        assertEquals(16.0, evaluateExpression("(2+x)*4"), 0.0001);
        System.setIn(System.in);
    }

    @Test()
    public void testEvaluateDivisionByZero() {
        try {
            ExpressionParser.evaluateExpression("2/0");
        } catch (ArithmeticException e) {
            assertEquals("Деление на ноль!", e.getMessage());
        }
    }

    @Test
    public void testEvaluateInvalidExpression() {
        assertEquals(Double.NaN, evaluateExpression("(2+x*3"), 0.0001);
    }
}
