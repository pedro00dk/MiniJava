package miniJava.visitor.TypeCheckVisitor;

import miniJava.ast.declaration.classDecl.ExtendedClassDecl;
import miniJava.ast.declaration.classDecl.SimpleClassDecl;
import miniJava.ast.declaration.classDecl.list.ClassDeclList;
import miniJava.ast.declaration.methodDecl.Argument;
import miniJava.ast.declaration.methodDecl.MethodDecl;
import miniJava.ast.declaration.methodDecl.list.ArgumentList;
import miniJava.ast.declaration.methodDecl.list.MethodDeclList;
import miniJava.ast.declaration.varDecl.VarDecl;
import miniJava.ast.declaration.varDecl.list.VarDeclList;
import miniJava.ast.program.Program;
import miniJava.visitor.AbstractVisitor;
import miniJava.visitor.TypeCheckVisitor.symbolTable.Class;
import miniJava.visitor.TypeCheckVisitor.symbolTable.Method;
import miniJava.visitor.TypeCheckVisitor.symbolTable.SymbolTable;

public class BuildSymbolTableVisitor extends AbstractVisitor<Void> {
    private SymbolTable table;
    private Class lastClass;
    private Method lastMethod;

    public BuildSymbolTableVisitor() {
        this.table = new SymbolTable();
    }

    public SymbolTable getTable() {
        return table;
    }

    @Override
    public Void visit(ClassDeclList cdl) {
        for (int i = 0; i < cdl.size(); i++) cdl.get(i).accept(this);
        return null;
    }

    @Override
    public Void visit(ExtendedClassDecl ecd) {
        if (!this.table.addClass(ecd.getClassName().getName(), ecd.getExtendsClassName().getName()))
            throw new IllegalArgumentException("Class " + ecd.getClassName().getName() + " already exists");
        this.lastClass = this.table.getClass(ecd.getClassName().getName());
        ecd.getAttributes().accept(this);
        ecd.getMethods().accept(this);
        this.lastClass = null;
        return null;
    }

    @Override
    public Void visit(SimpleClassDecl scd) {
        if (!this.table.addClass(scd.getClassName().getName(), null)) throw new IllegalArgumentException("Class "
                + scd.getClassName().getName() + " already exists");
        this.lastClass = this.table.getClass(scd.getClassName().getName());
        scd.getAttributes().accept(this);
        scd.getMethods().accept(this);
        this.lastClass = null;
        return null;
    }

    @Override
    public Void visit(ArgumentList al) {
        for (int i = 0; i < al.size(); i++) al.get(i).accept(this);
        return null;
    }

    @Override
    public Void visit(MethodDeclList mdl) {
        for (int i = 0; i < mdl.size(); i++) mdl.get(i).accept(this);
        return null;
    }

    @Override
    public Void visit(Argument a) {
        this.lastMethod.addParam(a.getName().getName(), a.getType());
        return null;
    }

    @Override
    public Void visit(MethodDecl md) {
        this.lastClass.addMethod(md.getName().getName(), md.getReturnType());
        this.lastMethod = this.lastClass.getMethod(md.getName().getName());
        md.getArguments().accept(this);
        md.getVariables().accept(this);
        this.lastMethod = null;
        return null;
    }

    @Override
    public Void visit(VarDeclList vdl) {
        for (int i = 0; i < vdl.size(); i++) vdl.get(i).accept(this);
        return null;
    }

    @Override
    public Void visit(VarDecl vd) {
        if (lastMethod == null) this.lastClass.addVar(vd.getId().getName(), vd.getType());
        else this.lastMethod.addVar(vd.getId().getName(), vd.getType());
        return null;
    }

    @Override
    public Void visit(Program p) {
        p.getClasses().accept(this);
        return null;
    }
}
