package miniJava.ast.expression.array;

import miniJava.ast.expression.Expression;

public class ArrayLengthExpr extends Expression {
    private Expression array;

    public ArrayLengthExpr(Expression array) {
        this.array = array;
    }

    public Expression getArray() {
        return array;
    }
}
