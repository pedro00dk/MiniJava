package miniJava.ast.expression.identifier;

import miniJava.ast.expression.Expression;
import miniJava.ast.identifier.Identifier;

public class IdentifierExpr extends Expression {
    private Identifier id;

    public IdentifierExpr(Identifier id) {
        this.id = id;
    }

    public Identifier getId() {
        return id;
    }
}
