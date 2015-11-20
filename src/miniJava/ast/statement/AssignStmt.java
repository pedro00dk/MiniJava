package miniJava.ast.statement;

import miniJava.ast.expression.Expression;
import miniJava.ast.identifier.Identifier;

public class AssignStmt extends Statement {
    private Identifier id;
    private Expression assign;

    public AssignStmt(Identifier id, Expression assign) {
        this.id = id;
        this.assign = assign;
    }
}

