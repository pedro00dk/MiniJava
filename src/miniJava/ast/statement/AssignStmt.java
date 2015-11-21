package miniJava.ast.statement;

import miniJava.ast.expression.Expression;
import miniJava.ast.identifier.Identifier;
import miniJava.visitor.Visitor;

public class AssignStmt implements Statement {
    private Identifier id;
    private Expression assign;

    public AssignStmt(Identifier id, Expression assign) {
        this.id = id;
        this.assign = assign;
    }

    public Identifier getId() {
        return id;
    }

    public Expression getAssign() {
        return assign;
    }

    @Override
    public <R> R accept(Visitor<R> visitor) {
        return visitor.visit(this);
    }
}

