package miniJava.ast.expression.integer;

import miniJava.ast.expression.Expression;

public class UnaryIntegerExpr {
    private Expression expr;
    private UnaryIntegerOperation op;

    public UnaryIntegerExpr(Expression expr, UnaryIntegerOperation op) {
        this.expr = expr;
        this.op = op;
    }

    enum UnaryIntegerOperation {
        NEGATE
    }
}
