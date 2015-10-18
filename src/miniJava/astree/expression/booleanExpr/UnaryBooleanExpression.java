package miniJava.astree.expression.booleanExpr;

import miniJava.astree.Expression;
import miniJava.astree.expression.BooleanExpression;

public class UnaryBooleanExpression implements BooleanExpression {
    protected Operator op;
    protected Expression expr;

    public UnaryBooleanExpression(Operator op, Expression expr) {
        this.op = op;
        this.expr = expr;
    }

    public enum Operator {
        OPPOSITE
    }
}
