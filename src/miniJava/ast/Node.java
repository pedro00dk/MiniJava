package miniJava.ast;

import miniJava.visitor.Visitor;

public abstract class Node {
    public <R> R accept(Visitor<R> visitor) {
        return visitor.visit(this);
    }
}
