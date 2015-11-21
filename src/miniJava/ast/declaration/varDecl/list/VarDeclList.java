package miniJava.ast.declaration.varDecl.list;

import miniJava.ast.Node;
import miniJava.ast.declaration.varDecl.VarDecl;
import miniJava.visitor.Visitor;

import java.util.ArrayList;
import java.util.List;

public class VarDeclList implements Node {
    private List<VarDecl> variables;

    public VarDeclList() {
        variables = new ArrayList<>();
    }

    public void add(VarDecl v) {
        variables.add(v);
    }

    public VarDecl get(int i) {
        return variables.get(i);
    }

    public int size() {
        return variables.size();
    }

    @Override
    public <R> R accept(Visitor<R> visitor) {
        return visitor.visit(this);
    }
}
