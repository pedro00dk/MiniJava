package miniJava.ast.expression.integer;

import miniJava.ast.expression.Expression;

public class BinaryIntegerExpr {
    private Expression expr1;
    private Expression expr2;
    private BinaryIntegerOperation op;

    public BinaryIntegerExpr(Expression expr1, Expression expr2, BinaryIntegerOperation op) {
        this.expr1 = expr1;
        this.expr2 = expr2;
        this.op = op;
    }

    enum BinaryIntegerOperation {
        PLUS, MINUS, MUL, DIV, MOD
    }

}