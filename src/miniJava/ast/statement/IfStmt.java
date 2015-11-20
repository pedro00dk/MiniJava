package miniJava.ast.statement;

import miniJava.ast.expression.Expression;

public class IfStmt extends Statement {
    private Expression expr;
    private Statement ifStmt;
    private Statement elseStmt;

    public IfStmt(Expression expr, Statement ifStmt, Statement elseStmt) {
        this.expr = expr;
        this.ifStmt = ifStmt;
        this.elseStmt = elseStmt;
    }

    public Expression getExpr() {
        return expr;
    }

    public Statement getIfStmt() {
        return ifStmt;
    }

    public Statement getElseStmt() {
        return elseStmt;
    }
}

