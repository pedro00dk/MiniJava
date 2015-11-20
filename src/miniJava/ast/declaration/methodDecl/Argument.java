package miniJava.ast.declaration.methodDecl;

import miniJava.ast.Node;
import miniJava.ast.identifier.Identifier;
import miniJava.ast.type.Type;

public class Argument extends Node {
    private Type type;
    private Identifier name;

    public Argument(Type type, Identifier name) {
        this.type = type;
        this.name = name;
    }

    public Type getType() {
        return type;
    }

    public Identifier getName() {
        return name;
    }
}
