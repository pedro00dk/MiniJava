package miniJava.astree.expression.booleanExpr;

import miniJava.astree.Expression;
import miniJava.astree.expression.BooleanExpression;

public class BinaryBooleanExpression implements BooleanExpression {
    protected Expression leftExpr;
    protected Operator op;
    protected Expression rightExpr;

    public BinaryBooleanExpression(Expression leftExpr, Operator op, Expression rightExpr) {
        this.leftExpr = leftExpr;
        this.op = op;
        this.rightExpr = rightExpr;
    }

    public enum Operator {
        AND, OR, EQUALS, DIFF, LESS, LESS_THAN, GREATER, GREATER_THAN
    }
}
