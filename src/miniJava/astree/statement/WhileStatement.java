package miniJava.astree.statement;

import miniJava.astree.Expression;
import miniJava.astree.Statement;
import miniJava.astree.StatementList;

public class WhileStatement implements Statement {
    protected Expression cond;
    protected Statement stmt;

    public WhileStatement(Expression cond, Statement stmt) {
        this.cond = cond;
        this.stmt = stmt;
    }
}
