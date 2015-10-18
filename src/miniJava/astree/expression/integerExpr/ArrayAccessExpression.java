package miniJava.astree.expression.integerExpr;

import miniJava.astree.Expression;
import miniJava.astree.expression.IntegerExpression;

public class ArrayAccessExpression implements IntegerExpression {
    protected Expression array;
    protected Expression index;

    public ArrayAccessExpression(Expression array, Expression index) {
        this.array = array;
        this.index = index;
    }
}
