package miniJava.ast.declaration.methodDecl.list;

import miniJava.ast.Node;
import miniJava.ast.declaration.methodDecl.Argument;
import miniJava.visitor.Visitor;

import java.util.ArrayList;
import java.util.List;

public class ArgumentList implements Node {
    private List<Argument> arguments;

    public ArgumentList() {
        this.arguments = new ArrayList<>();
    }

    public void add(Argument a) {
        this.arguments.add(a);
    }

    public Argument get(int i) {
        return this.arguments.get(i);
    }

    public int size() {
        return this.arguments.size();
    }

    @Override
    public <R> R accept(Visitor<R> visitor) {
        return visitor.visit(this);
    }
}
