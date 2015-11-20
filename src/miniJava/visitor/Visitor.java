package miniJava.visitor;

import miniJava.ast.Node;

public interface Visitor<R> {
    R visit(Node n);
}
