package miniJava.ast.expression.array;

import miniJava.ast.expression.Expression;

public class ArrayLookupExpr extends Expression {
    private Expression array;
    private Expression index;

    public ArrayLookupExpr(Expression array, Expression index) {
        this.array = array;
        this.index = index;
    }
}
