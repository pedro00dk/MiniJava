package miniJava.astree.statement;

import miniJava.astree.Expression;
import miniJava.astree.Statement;
import miniJava.astree.StatementList;

public class IfElseStatement implements Statement {
    protected Expression cond;
    protected StatementList ifStmt;
    protected StatementList elseStmt;

    public IfElseStatement(Expression cond, StatementList ifStmt, StatementList elseStmt) {
        this.cond = cond;
        this.ifStmt = ifStmt;
        this.elseStmt = elseStmt;
    }
}
