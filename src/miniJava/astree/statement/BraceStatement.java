package miniJava.astree.statement;

import miniJava.astree.Statement;
import miniJava.astree.StatementList;

public class BraceStatement implements Statement {
    protected StatementList stmt;

    public BraceStatement(StatementList stmt) {
        this.stmt = stmt;
    }
}
