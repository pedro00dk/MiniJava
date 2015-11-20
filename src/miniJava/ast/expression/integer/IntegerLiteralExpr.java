package miniJava.ast.expression.integer;

import miniJava.ast.expression.Expression;

public class IntegerLiteralExpr extends Expression {
    private int value;

    public IntegerLiteralExpr(int value) {
        this.value = value;
    }
}
