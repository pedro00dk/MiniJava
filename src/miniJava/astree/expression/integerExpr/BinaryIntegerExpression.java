package miniJava.astree.expression.integerExpr;

import miniJava.astree.Expression;
import miniJava.astree.expression.IntegerExpression;

public class BinaryIntegerExpression implements IntegerExpression {
    protected Expression leftExpr;
    protected Operator op;
    protected Expression rightExpr;

    public BinaryIntegerExpression(Expression leftExpr, Operator op, Expression rightExpr) {
        this.leftExpr = leftExpr;
        this.op = op;
        this.rightExpr = rightExpr;
    }

    public enum Operator {
        PLUS, MINUS, TIMES, DIV, MOD
    }
}
