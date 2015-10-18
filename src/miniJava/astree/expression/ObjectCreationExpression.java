package miniJava.astree.expression;

import miniJava.astree.Expression;

public class ObjectCreationExpression implements Expression {
    protected String name;

    public ObjectCreationExpression(String name) {
        this.name = name;
    }
}
