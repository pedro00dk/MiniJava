package miniJava.astree.expression.integerExpr;

import miniJava.astree.expression.IntegerExpression;

public class LiteralIntegerExpression implements IntegerExpression {
    protected Integer value;

    public LiteralIntegerExpression(Integer value) {
        this.value = value;
    }
}
