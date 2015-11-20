package miniJava.ast.identifier;

import miniJava.ast.Node;

public class Identifier extends Node {
    public String name;

    public Identifier(String name) {
        this.name = name;
    }
}
