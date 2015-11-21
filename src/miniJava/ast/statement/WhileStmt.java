package miniJava.ast.statement;

import miniJava.ast.expression.Expression;
import miniJava.visitor.Visitor;

public class WhileStmt implements Statement {
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

    @Override
    public <R> R accept(Visitor<R> visitor) {
        return visitor.visit(this);
    }
}

