package miniJava.ast;

import miniJava.visitor.Visitor;

public interface Node {
    <R> R accept(Visitor<R> visitor);
}
