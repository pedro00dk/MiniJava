package miniJava.astree.expression.booleanExpr;

import miniJava.astree.expression.BooleanExpression;

public class LiteralBooleanExpression implements BooleanExpression {
    protected Boolean value;

    public LiteralBooleanExpression(Boolean value) {
        this.value = value;
    }
}
