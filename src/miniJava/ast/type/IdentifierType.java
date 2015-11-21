package miniJava.ast.type;

import miniJava.ast.identifier.Identifier;
import miniJava.visitor.Visitor;

public class IdentifierType implements Type {
    private Identifier id;

    public IdentifierType(Identifier id) {
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
