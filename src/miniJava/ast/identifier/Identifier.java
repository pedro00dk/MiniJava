package miniJava.ast.identifier;

import miniJava.ast.Node;

public class Identifier extends Node {
    private String name;

    public Identifier(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
