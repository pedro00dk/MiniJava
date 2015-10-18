package miniJava.astree.expression;

import miniJava.astree.Expression;

public class IdentifierExpression implements Expression {
    protected String id;

    public IdentifierExpression(String id) {
        this.id = id;
    }
}
