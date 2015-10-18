package miniJava.astree.statement;

import miniJava.astree.Expression;
import miniJava.astree.Statement;
import miniJava.astree.StatementList;

public class WhileStatement implements Statement {
    protected Expression cond;
    protected StatementList stmt;

    public WhileStatement(Expression cond, StatementList stmt) {
        this.cond = cond;
        this.stmt = stmt;
    }
}
