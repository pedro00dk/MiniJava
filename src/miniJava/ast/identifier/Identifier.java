package miniJava.ast.identifier;

import miniJava.ast.Node;
import miniJava.visitor.Visitor;

public class Identifier implements Node {
    private String name;

    public Identifier(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public <R> R accept(Visitor<R> visitor) {
        return visitor.visit(this);
    }
}
