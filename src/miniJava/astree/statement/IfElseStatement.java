package miniJava.astree.statement;

import miniJava.astree.Expression;
import miniJava.astree.Statement;
import miniJava.astree.StatementList;

public class IfElseStatement implements Statement {
    protected Expression cond;
    protected Statement ifStmt;
    protected Statement elseStmt;

    public IfElseStatement(Expression cond, Statement ifStmt, Statement elseStmt) {
        this.cond = cond;
        this.ifStmt = ifStmt;
        this.elseStmt = elseStmt;
    }
}
