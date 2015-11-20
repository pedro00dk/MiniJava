package miniJava.ast.type;

import miniJava.ast.identifier.Identifier;

public class IdentifierType extends Type {
    private Identifier id;

    public IdentifierType(Identifier id) {
        this.id = id;
    }
}
