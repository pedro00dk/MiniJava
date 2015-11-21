package miniJava.ast.expression.bool;

import miniJava.ast.expression.Expression;
import miniJava.visitor.Visitor;

public class BooleanLiteralExpr implements Expression {
    private boolean value;

    public BooleanLiteralExpr(boolean value) {
        this.value = value;
    }

    public boolean isValue() {
        return value;
    }

    @Override
    public <R> R accept(Visitor<R> visitor) {
        return visitor.visit(this);
    }
}
