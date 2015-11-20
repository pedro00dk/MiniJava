package miniJava.ast.expression.bool;

import miniJava.ast.expression.Expression;

public class UnaryBooleanExpr {
    private Expression expr;
    private UnaryBooleanOperation op;

    public UnaryBooleanExpr(Expression expr, UnaryBooleanOperation op) {
        this.expr = expr;
        this.op = op;
    }

    enum UnaryBooleanOperation {
        OPPOSITE
    }
}
