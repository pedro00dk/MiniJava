package miniJava.ast.declaration.varDecl;

import miniJava.ast.Node;
import miniJava.ast.identifier.Identifier;
import miniJava.ast.type.Type;
import miniJava.visitor.Visitor;

public class VarDecl implements Node {
    private Type type;
    private Identifier id;

    public VarDecl(Type type, Identifier id) {
        this.type = type;
        this.id = id;
    }

    public Type getType() {
        return type;
    }

    public Identifier getId() {
        return id;
    }

    @Override
    public <R> R accept(Visitor<R> visitor) {
        return visitor.visit(this);
    }
}
