package miniJava.astree.expression;

import miniJava.astree.Expression;

public class AssocExpression implements Expression {
    protected Expression expr;

    public AssocExpression(Expression expr) {
        this.expr = expr;
    }
}
