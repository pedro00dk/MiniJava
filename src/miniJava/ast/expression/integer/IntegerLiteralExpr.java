package miniJava.ast.expression.integer;

import miniJava.ast.expression.Expression;
import miniJava.visitor.Visitor;

public class IntegerLiteralExpr implements Expression {
    private int value;

    public IntegerLiteralExpr(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    @Override
    public <R> R accept(Visitor<R> visitor) {
        return visitor.visit(this);
    }
}
