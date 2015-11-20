package miniJava.ast.expression.bool;

import miniJava.ast.expression.Expression;

public class UnaryBooleanExpr extends Expression {
    private Expression expr;
    private UnaryBooleanOperation op;

    public UnaryBooleanExpr(Expression expr, UnaryBooleanOperation op) {
        this.expr = expr;
        this.op = op;
    }

    public enum UnaryBooleanOperation {
        OPPOSITE
    }

    public Expression getExpr() {
        return expr;
    }

    public UnaryBooleanOperation getOp() {
        return op;
    }
}
