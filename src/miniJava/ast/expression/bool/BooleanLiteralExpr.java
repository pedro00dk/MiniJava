package miniJava.ast.expression.bool;

import miniJava.ast.expression.Expression;

public class BooleanLiteralExpr extends Expression {
    private boolean value;

    public BooleanLiteralExpr(boolean value) {
        this.value = value;
    }
}
