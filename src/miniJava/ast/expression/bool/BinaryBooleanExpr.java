package miniJava.ast.expression.bool;

import miniJava.ast.expression.Expression;

public class BinaryBooleanExpr {
    private Expression expr1;
    private Expression expr2;
    private BinaryBooleanOperation op;

    public BinaryBooleanExpr(Expression expr1, Expression expr2, BinaryBooleanOperation op) {
        this.expr1 = expr1;
        this.expr2 = expr2;
        this.op = op;
    }

    enum BinaryBooleanOperation {
        EQUALS, DIFF, LESS, LESS_THAN, GREATER, GREATER_THAN
    }
}
