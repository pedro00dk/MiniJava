package miniJava.ast.declaration.varDecl.list;

import miniJava.ast.declaration.varDecl.VarDecl;

import java.util.ArrayList;
import java.util.List;

public class VarDeclList {
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
}
