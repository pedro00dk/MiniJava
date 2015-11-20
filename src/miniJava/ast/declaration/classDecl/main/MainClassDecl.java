package miniJava.ast.declaration.classDecl.main;

import miniJava.ast.Node;
import miniJava.ast.identifier.Identifier;
import miniJava.ast.statement.Statement;

public class MainClassDecl extends Node {
    private Identifier mainClassName;
    private Identifier args;
    private Statement main;

    public MainClassDecl(Identifier mainClassName, Identifier args, Statement main) {
        this.mainClassName = mainClassName;
        this.args = args;
        this.main = main;
    }
}

