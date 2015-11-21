package miniJava.ast.declaration.classDecl;

import miniJava.ast.declaration.methodDecl.list.MethodDeclList;
import miniJava.ast.declaration.varDecl.list.VarDeclList;
import miniJava.ast.identifier.Identifier;
import miniJava.visitor.Visitor;

public class ExtendedClassDecl extends SimpleClassDecl {
    private Identifier extendsClassName;

    public ExtendedClassDecl(Identifier className, VarDeclList attributes, MethodDeclList methods, Identifier extendsClassName) {
        super(className, attributes, methods);
        this.extendsClassName = extendsClassName;
    }

    public Identifier getExtendsClassName() {
        return extendsClassName;
    }

    @Override
    public <R> R accept(Visitor<R> visitor) {
        return visitor.visit(this);
    }
}
