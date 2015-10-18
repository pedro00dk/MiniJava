package miniJava.astree.expression.integerExpr;

import miniJava.astree.Expression;
import miniJava.astree.expression.IntegerExpression;

public class LengthExpression implements IntegerExpression {
    protected Expression array;

    public LengthExpression(Expression array) {
        this.array = array;
    }
}
