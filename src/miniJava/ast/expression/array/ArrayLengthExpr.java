package miniJava.ast.expression.array;

import miniJava.ast.expression.Expression;
import miniJava.visitor.Visitor;

public class ArrayLengthExpr implements Expression {
    private Expression array;

    public ArrayLengthExpr(Expression array) {
        this.array = array;
    }

    public Expression getArray() {
        return array;
    }

    @Override
    public <R> R accept(Visitor<R> visitor) {
        return visitor.visit(this);
    }
}
