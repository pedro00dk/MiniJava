package miniJava.ast.statement;

import miniJava.ast.expression.Expression;

public class WhileStmt extends Statement {
    private Expression expr;
    private Statement stmt;

    public WhileStmt(Expression expr, Statement stmt) {
        this.expr = expr;
        this.stmt = stmt;
    }

    public Expression getExpr() {
        return expr;
    }

    public Statement getStmt() {
        return stmt;
    }
}

