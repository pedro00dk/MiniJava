package miniJava.ast.expression.integer;

import miniJava.ast.expression.Expression;
import miniJava.visitor.Visitor;

public class BinaryIntegerExpr implements Expression {
    private Expression expr1;
    private Expression expr2;
    private BinaryIntegerOperation op;

    public BinaryIntegerExpr(Expression expr1, Expression expr2, BinaryIntegerOperation op) {
        this.expr1 = expr1;
        this.expr2 = expr2;
        this.op = op;
    }

    public enum BinaryIntegerOperation {
        PLUS, MINUS, MUL, DIV, MOD
    }

    public Expression getExpr1() {
        return expr1;
    }

    public Expression getExpr2() {
        return expr2;
    }

    public BinaryIntegerOperation getOp() {
        return op;
    }

    @Override
    public <R> R accept(Visitor<R> visitor) {
        return visitor.visit(this);
    }
}