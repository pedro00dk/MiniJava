package miniJava.ast.expression.array;

import miniJava.ast.expression.Expression;
import miniJava.visitor.Visitor;

public class NewArrayExpr implements Expression {
    private Expression expr;

    public NewArrayExpr(Expression expr) {
        this.expr = expr;
    }

    public Expression getExpr() {
        return expr;
    }

    @Override
    public <R> R accept(Visitor<R> visitor) {
        return visitor.visit(this);
    }
}
