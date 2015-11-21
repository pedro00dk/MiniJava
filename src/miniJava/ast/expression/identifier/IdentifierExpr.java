package miniJava.ast.expression.identifier;

import miniJava.ast.expression.Expression;
import miniJava.ast.identifier.Identifier;
import miniJava.visitor.Visitor;

public class IdentifierExpr implements Expression {
    private Identifier id;

    public IdentifierExpr(Identifier id) {
        this.id = id;
    }

    public Identifier getId() {
        return id;
    }

    @Override
    public <R> R accept(Visitor<R> visitor) {
        return visitor.visit(this);
    }
}
