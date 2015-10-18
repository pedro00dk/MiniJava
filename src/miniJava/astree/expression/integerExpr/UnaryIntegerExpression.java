package miniJava.astree.expression.integerExpr;

import miniJava.astree.Expression;
import miniJava.astree.expression.IntegerExpression;

public class UnaryIntegerExpression implements IntegerExpression {
    protected Operator op;
    protected Expression expr;

    public UnaryIntegerExpression(Operator op, Expression expr) {
        this.op = op;
        this.expr = expr;
    }

    public enum Operator {

    }
}
