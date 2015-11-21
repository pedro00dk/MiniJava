package miniJava.ast.expression.integer;

import miniJava.ast.expression.Expression;
import miniJava.visitor.Visitor;

public class UnaryIntegerExpr implements Expression {
    private Expression expr;
    private UnaryIntegerOperation op;

    public UnaryIntegerExpr(Expression expr, UnaryIntegerOperation op) {
        this.expr = expr;
        this.op = op;
    }

    public enum UnaryIntegerOperation {
        NEGATE
    }

    @Override
    public <R> R accept(Visitor<R> visitor) {
        return visitor.visit(this);
    }
}
