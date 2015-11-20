package miniJava.ast.statement;

import miniJava.ast.expression.Expression;

public class PrintStmt extends Statement {
    private Expression expr;

    public PrintStmt(Expression expr) {
        this.expr = expr;
    }
}
