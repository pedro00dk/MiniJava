package miniJava.ast.declaration.varDecl;

import miniJava.ast.Node;
import miniJava.ast.identifier.Identifier;
import miniJava.ast.type.Type;

public class VarDecl extends Node {
    private Type type;
    private Identifier id;

    public VarDecl(Type type, Identifier id) {
        this.type = type;
        this.id = id;
    }
}
