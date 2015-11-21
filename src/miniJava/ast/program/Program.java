package miniJava.ast.program;

import miniJava.ast.Node;
import miniJava.ast.declaration.classDecl.list.ClassDeclList;
import miniJava.ast.declaration.classDecl.main.MainClassDecl;
import miniJava.visitor.Visitor;

public class Program implements Node {
    private MainClassDecl mainClass;
    private ClassDeclList classes;

    public Program(MainClassDecl mainClass, ClassDeclList classes) {
        this.mainClass = mainClass;
        this.classes = classes;
    }

    public MainClassDecl getMainClass() {
        return mainClass;
    }

    public ClassDeclList getClasses() {
        return classes;
    }

    @Override
    public <R> R accept(Visitor<R> visitor) {
        return visitor.visit(this);
    }
}
