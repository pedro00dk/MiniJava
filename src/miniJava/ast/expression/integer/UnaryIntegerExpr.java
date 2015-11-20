package miniJava.ast.expression.integer;

import miniJava.ast.expression.Expression;

public class UnaryIntegerExpr extends Expression {
    private Expression expr;
    private UnaryIntegerOperation op;

    public UnaryIntegerExpr(Expression expr, UnaryIntegerOperation op) {
        this.expr = expr;
        this.op = op;
    }

    public enum UnaryIntegerOperation {
        NEGATE
    }
}
