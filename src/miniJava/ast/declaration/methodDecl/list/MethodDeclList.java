package miniJava.ast.declaration.methodDecl.list;

import miniJava.ast.Node;
import miniJava.ast.declaration.methodDecl.MethodDecl;

import java.util.ArrayList;
import java.util.List;

public class MethodDeclList extends Node {
    private List<MethodDecl> methods;

    public MethodDeclList() {
        this.methods = new ArrayList<>();
    }

    public void add(MethodDecl m) {
        this.methods.add(m);
    }

    public MethodDecl get(int i) {
        return this.methods.get(i);
    }

    public int size() {
        return this.methods.size();
    }
}
