package miniJava.ast.statement;

import miniJava.ast.statement.list.StatementList;

public class BlockStmt extends Statement {
    private StatementList stmts;

    public BlockStmt(StatementList stmts) {
        this.stmts = stmts;
    }
}

