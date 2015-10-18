package miniJava.astree.expression;

import miniJava.astree.Expression;

public class IntegerArrayCreationExpression implements Expression {
    protected Expression size;

    public IntegerArrayCreationExpression(Expression size) {
        this.size = size;
    }
}
