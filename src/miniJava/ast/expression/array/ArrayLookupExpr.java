package miniJava.ast.expression.array;

import miniJava.ast.expression.Expression;
import miniJava.visitor.Visitor;

public class ArrayLookupExpr implements Expression {
    private Expression array;
    private Expression index;

    public ArrayLookupExpr(Expression array, Expression index) {
        this.array = array;
        this.index = index;
    }

    public Expression getArray() {
        return array;
    }

    public Expression getIndex() {
        return index;
    }

    @Override
    public <R> R accept(Visitor<R> visitor) {
        return visitor.visit(this);
    }
}
