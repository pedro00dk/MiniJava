package miniJava.ast.declaration.classDecl.main;

import miniJava.ast.Node;
import miniJava.ast.identifier.Identifier;
import miniJava.ast.statement.list.StatementList;

public class MainClassDecl extends Node {
    private Identifier mainClassName;
    private Identifier args;
    private StatementList main;

    public MainClassDecl(Identifier mainClassName, Identifier args, StatementList main) {
        this.mainClassName = mainClassName;
        this.args = args;
        this.main = main;
    }

    public Identifier getMainClassName() {
        return mainClassName;
    }

    public Identifier getArgs() {
        return args;
    }

    public StatementList getMain() {
        return main;
    }
}

