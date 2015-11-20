package miniJava.ast.statement.list;

import miniJava.ast.statement.Statement;

import java.util.ArrayList;
import java.util.List;

public class StatementList {
    private List<Statement> statements;

    public StatementList() {
        this.statements = new ArrayList<>();
    }

    public void add(Statement s) {
        this.statements.add(s);
    }

    public Statement get(int i) {
        return this.statements.get(i);
    }

    public int size() {
        return this.statements.size();
    }
}
