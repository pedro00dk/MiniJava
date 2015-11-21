package miniJava.ast.declaration.classDecl;

import miniJava.ast.declaration.methodDecl.list.MethodDeclList;
import miniJava.ast.declaration.varDecl.list.VarDeclList;
import miniJava.ast.identifier.Identifier;
import miniJava.visitor.Visitor;

public class SimpleClassDecl implements ClassDecl {
    private Identifier className;
    private VarDeclList attributes;
    private MethodDeclList methods;

    public SimpleClassDecl(Identifier className, VarDeclList attributes, MethodDeclList methods) {
        this.className = className;
        this.attributes = attributes;
        this.methods = methods;
    }

    public Identifier getClassName() {
        return className;
    }

    public VarDeclList getAttributes() {
        return attributes;
    }

    public MethodDeclList getMethods() {
        return methods;
    }

    @Override
    public <R> R accept(Visitor<R> visitor) {
        return visitor.visit(this);
    }
}
