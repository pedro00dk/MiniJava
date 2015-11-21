package miniJava.ast.statement;

import miniJava.ast.statement.list.StatementList;
import miniJava.visitor.Visitor;

public class BlockStmt implements Statement {
    private StatementList stmts;

    public BlockStmt(StatementList stmts) {
        this.stmts = stmts;
    }

    public StatementList getStmts() {
        return stmts;
    }

    @Override
    public <R> R accept(Visitor<R> visitor) {
        return visitor.visit(this);
    }
}

