package miniJava.visitor.TypeCheckVisitor.symbolTable;


import miniJava.ast.identifier.Identifier;
import miniJava.ast.type.IdentifierType;
import miniJava.ast.type.Type;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Class {

    private String name;
    private Map<String, Method> methods;
    private Map<String, Variable> globals;
    private String parent;
    private Type type;

    public Class(String name, String parent) {
        this.name = name;
        this.methods = new HashMap<>();
        this.globals = new HashMap<>();
        this.parent = parent;
        this.type = new IdentifierType(new Identifier(this.name));
    }

    public String getName() {
        return name;
    }

    public Type getType() {
        return type;
    }

    public boolean addMethod(String name, Type type) {
        if (containsMethod(name)) return false;
        methods.put(name, new Method(name, type));
        return true;
    }

    public Set<String> getMethods() {
        return methods.keySet();
    }

    public Method getMethod(String name) {
        if (containsMethod(name)) return methods.get(name);
        return null;
    }

    public boolean addVar(String name, Type type) {
        if (globals.containsKey(name)) return false;
        globals.put(name, new Variable(name, type));
        return true;
    }

    public Variable getVar(String name) {
        if (containsVar(name))
            return (Variable) globals.get(name);
        else
            return null;
    }

    public boolean containsVar(String name) {
        return globals.containsKey(name);
    }

    public boolean containsMethod(String name) {
        return methods.containsKey(name);
    }

    public String parent() {
        return parent;
    }
}