package miniJava.ast.statement.list;

import miniJava.ast.Node;
import miniJava.ast.statement.Statement;
import miniJava.visitor.Visitor;

import java.util.ArrayList;
import java.util.List;

public class StatementList implements Node {
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

    @Override
    public <R> R accept(Visitor<R> visitor) {
        return visitor.visit(this);
    }
}
