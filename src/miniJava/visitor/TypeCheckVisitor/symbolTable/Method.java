package miniJava.visitor.TypeCheckVisitor.symbolTable;

import miniJava.ast.type.Type;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Method {

    private String name;
    private Type type;
    private List<Variable> params;
    private Map<String, Variable> vars;

    public Method(String name, Type type) {
        this.name = name;
        this.type = type;
        this.vars = new HashMap<>();
        this.params = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public Type type() {
        return type;
    }

    public List<Variable> getParams() {
        return params;
    }

    public boolean addParam(String name, Type type) {
        if (containsParam(name)) return false;
        this.params.add(new Variable(name, type));
        return true;
    }

    public Variable getParamAt(int i) {
        if (i < params.size()) return params.get(i);
        else return null;
    }

    public boolean containsParam(String id) {
        for (Variable v : this.params) if (v.getName().equals(id)) return true;
        return false;
    }

    public boolean addVar(String id, Type type) {
        if (vars.containsKey(id)) return false;
        vars.put(id, new Variable(id, type));
        return true;
    }

    public boolean containsVar(String id) {
        return vars.containsKey(id);
    }


    public Variable getVar(String id) {
        if (containsVar(id)) return vars.get(id);
        return null;
    }

    public Variable getParam(String id) {
        for (Variable v : this.params) if (v.getName().equals(id)) return v;
        return null;
    }

}