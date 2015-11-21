package miniJava.ast.declaration.classDecl.list;

import miniJava.ast.Node;
import miniJava.ast.declaration.classDecl.ClassDecl;
import miniJava.visitor.Visitor;

import java.util.ArrayList;
import java.util.List;

public class ClassDeclList implements Node {
    private List<ClassDecl> classes;

    public ClassDeclList() {
        this.classes = new ArrayList<>();
    }

    public void add(ClassDecl c) {
        this.classes.add(c);
    }

    public ClassDecl get(int i) {
        return this.classes.get(i);
    }

    public int size() {
        return this.classes.size();
    }

    @Override
    public <R> R accept(Visitor<R> visitor) {
        return visitor.visit(this);
    }
}
