package miniJava.ast.expression.array;

import miniJava.ast.expression.Expression;

public class NewArrayExpr extends Expression {
    private Expression expr;

    public NewArrayExpr(Expression expr) {
        this.expr = expr;
    }

    public Expression getExpr() {
        return expr;
    }
}
