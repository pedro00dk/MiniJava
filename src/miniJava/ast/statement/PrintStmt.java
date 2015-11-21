package miniJava.ast.statement;

import miniJava.ast.expression.Expression;
import miniJava.visitor.Visitor;

public class PrintStmt implements Statement {
    private Expression expr;

    public PrintStmt(Expression expr) {
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
