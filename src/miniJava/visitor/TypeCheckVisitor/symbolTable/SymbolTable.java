package miniJava.visitor.TypeCheckVisitor.symbolTable;

import miniJava.ast.type.*;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class SymbolTable {

    private Map<String, Class> classses;

    public SymbolTable() {
        classses = new HashMap<>();
    }

    public boolean addClass(String id, String parent) {
        if (containsClass(id)) return false;
        classses.put(id, new Class(id, parent));
        return true;
    }

    public Class getClass(String id) {
        if (containsClass(id)) return (Class) classses.get(id);
        return null;
    }

    public boolean containsClass(String id) {
        return classses.containsKey(id);
    }

    public Type getVarType(Method m, Class c, String id) {
        if (m != null) {
            if (m.getVar(id) != null) {
                return m.getVar(id).getType();
            }
            if (m.getParam(id) != null) {
                return m.getParam(id).getType();
            }
        }

        while (c != null) {
            if (c.getVar(id) != null) {
                return c.getVar(id).getType();
            } else {
                if (c.parent() == null) {
                    c = null;
                } else {
                    c = getClass(c.parent());
                }
            }
        }
        throw new IllegalArgumentException("Variavel " + id + " nao definida no escopo atual");
    }

    public Method getMethod(String id, String classScope) {
        if (getClass(classScope) == null) throw new IllegalArgumentException("Class " + classScope + " nao definida");

        Class c = getClass(classScope);
        while (c != null) {
            if (c.getMethod(id) != null) {
                return c.getMethod(id);
            } else {
                if (c.parent() == null) {
                    c = null;
                } else {
                    c = getClass(c.parent());
                }
            }
        }
        throw new IllegalArgumentException("Metodo " + id + " nao definido na classe " + classScope);
    }

    public Type getMethodType(String id, String classScope) {
        if (getClass(classScope) == null) {
            if (getClass(classScope) == null) throw new IllegalArgumentException("Class " + classScope
                    + " nao definida");
        }

        Class c = getClass(classScope);
        while (c != null) {
            if (c.getMethod(id) != null) {
                return c.getMethod(id).type();
            } else {
                if (c.parent() == null) {
                    c = null;
                } else {
                    c = getClass(c.parent());
                }
            }
        }
        throw new IllegalArgumentException("Metodo " + id + " nao definido na classe " + classScope);
    }

    public boolean compareTypes(Type t1, Type t2) {
        if (t1 == null || t2 == null) return false;
        if (t1 instanceof IntegerType && t2 instanceof IntegerType) return true;
        if (t1 instanceof BooleanType && t2 instanceof BooleanType) return true;
        if (t1 instanceof IntArrayType && t2 instanceof IntArrayType) return true;
        if (t1 instanceof IdentifierType && t2 instanceof IdentifierType) {
            IdentifierType i1 = (IdentifierType) t1;
            IdentifierType i2 = (IdentifierType) t2;

            Class c = getClass(i2.getId().getName());
            while (c != null) {
                if (i1.getId().getName().equals(c.getName())) return true;
                else if (c.parent() == null) return false;
                c = getClass(c.parent());
            }
        }
        return false;
    }
}