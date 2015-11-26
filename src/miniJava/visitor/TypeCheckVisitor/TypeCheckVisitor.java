package miniJava.visitor.TypeCheckVisitor;

import miniJava.ast.declaration.classDecl.ExtendedClassDecl;
import miniJava.ast.declaration.classDecl.SimpleClassDecl;
import miniJava.ast.declaration.classDecl.list.ClassDeclList;
import miniJava.ast.declaration.classDecl.main.MainClassDecl;
import miniJava.ast.declaration.methodDecl.MethodDecl;
import miniJava.ast.declaration.methodDecl.list.MethodDeclList;
import miniJava.ast.expression.MethodCallExpr;
import miniJava.ast.expression.ThisExpr;
import miniJava.ast.expression.array.ArrayLengthExpr;
import miniJava.ast.expression.array.ArrayLookupExpr;
import miniJava.ast.expression.array.NewArrayExpr;
import miniJava.ast.expression.bool.BinaryBooleanExpr;
import miniJava.ast.expression.bool.BooleanLiteralExpr;
import miniJava.ast.expression.bool.UnaryBooleanExpr;
import miniJava.ast.expression.identifier.IdentifierExpr;
import miniJava.ast.expression.identifier.NewObjectExpr;
import miniJava.ast.expression.integer.BinaryIntegerExpr;
import miniJava.ast.expression.integer.IntegerLiteralExpr;
import miniJava.ast.identifier.Identifier;
import miniJava.ast.program.Program;
import miniJava.ast.statement.*;
import miniJava.ast.statement.list.StatementList;
import miniJava.ast.type.*;
import miniJava.visitor.AbstractVisitor;
import miniJava.visitor.PrettyPrintVisitor;
import miniJava.visitor.TypeCheckVisitor.symbolTable.Class;
import miniJava.visitor.TypeCheckVisitor.symbolTable.Method;
import miniJava.visitor.TypeCheckVisitor.symbolTable.SymbolTable;
import miniJava.visitor.TypeCheckVisitor.symbolTable.Variable;

import java.util.ArrayList;
import java.util.List;

public class TypeCheckVisitor extends AbstractVisitor<Type> {
    private SymbolTable table;
    private List<String> errors;
    private Class lastClass;
    private Method lastMethod;

    public TypeCheckVisitor(SymbolTable table) {
        this.table = table;
        this.errors = new ArrayList<>();
    }

    public List<String> getErrors() {
        return errors;
    }

    @Override
    public Type visit(ClassDeclList cdl) {
        for (int i = 0; i < cdl.size(); i++) cdl.get(i).accept(this);
        return null;
    }

    @Override
    public Type visit(MainClassDecl mcd) {
        mcd.getMain().accept(this);
        return null;
    }

    @Override
    public Type visit(ExtendedClassDecl ecd) {
        this.lastClass = this.table.getClass(ecd.getClassName().getName());
        ecd.getMethods().accept(this);
        this.lastClass = null;
        return null;
    }

    @Override
    public Type visit(SimpleClassDecl scd) {
        this.lastClass = this.table.getClass(scd.getClassName().getName());
        scd.getMethods().accept(this);
        this.lastClass = null;
        return null;
    }

    @Override
    public Type visit(MethodDeclList mdl) {
        for (int i = 0; i < mdl.size(); i++) mdl.get(i).accept(this);
        return null;
    }

    @Override
    public Type visit(MethodDecl md) {
        this.lastMethod = this.lastClass.getMethod(md.getName().getName());
        md.getStatements().accept(this);
        this.lastMethod = null;
        return null;
    }

    @Override
    public Type visit(ArrayLengthExpr ale) {
        if (!(ale.getArray().accept(this) instanceof IntArrayType))
            this.errors.add("Invalid array on length expression");
        return new IntegerType();
    }

    @Override
    public Type visit(ArrayLookupExpr ale) {
        if (!(ale.getArray().accept(this) instanceof IntArrayType))
            this.errors.add("Invalid array on lookup expression");
        return new IntegerType();
    }

    @Override
    public Type visit(NewArrayExpr nae) {
        if (!(nae.getExpr().accept(this) instanceof IntegerType))
            this.errors.add("Invalid type new array length expression");
        return new IntArrayType();
    }

    @Override
    public Type visit(BinaryBooleanExpr bbe) {
        switch (bbe.getOp()) {
            case AND:
            case OR:
                if (!(bbe.getExpr1().accept(this) instanceof BooleanType
                        && bbe.getExpr2().accept(this) instanceof BooleanType))
                    this.errors.add("Illegal types in boolean expression:\n"
                            + bbe.accept(new PrettyPrintVisitor()));
                break;
            case EQUALS:
            case DIFF:
            case LESS:
            case LESS_THAN:
            case GREATER:
            case GREATER_THAN:
                if (!(bbe.getExpr1().accept(this) instanceof IntegerType
                        && bbe.getExpr2().accept(this) instanceof IntegerType))
                    this.errors.add("Illegal types in boolean expression:\n"
                            + bbe.accept(new PrettyPrintVisitor()));
                break;
        }
        return new BooleanType();
    }

    @Override
    public Type visit(BooleanLiteralExpr ble) {
        return new BooleanType();
    }

    @Override
    public Type visit(UnaryBooleanExpr ube) {
        if (!(ube.getExpr().accept(this) instanceof BooleanType)) this.errors.add("Illegal unary expression type:\n"
                + ube.accept(new PrettyPrintVisitor()));
        return new BooleanType();
    }

    @Override
    public Type visit(IdentifierExpr ie) {
        Variable v = lastMethod.getParam(ie.getId().getName());
        if (v == null) v = this.lastMethod.getVar(ie.getId().getName());
        if (v == null) v = this.lastClass.getVar(ie.getId().getName());
        if (v == null) this.errors.add("Identificator is not declared:\n" + ie.getId().getName());
        else return v.getType();
        return null;
    }

    @Override
    public Type visit(NewObjectExpr noe) {
        return new IdentifierType(noe.getId());
    }

    @Override
    public Type visit(BinaryIntegerExpr bie) {
        if (!(bie.getExpr1().accept(this) instanceof IntegerType
                && bie.getExpr2().accept(this) instanceof IntegerType))
            this.errors.add("Illegal types in integer expression:\n"
                    + bie.accept(new PrettyPrintVisitor()));
        return new IntegerType();
    }

    @Override
    public Type visit(IntegerLiteralExpr ile) {
        return new IntegerType();
    }

    @Override
    public Type visit(MethodCallExpr mce) {
        Type t = mce.getObject().accept(this);
        if (!(t instanceof IdentifierType)) this.errors.add("Invalid type of method call expression:\n"
                + mce.accept(new PrettyPrintVisitor()));
        else {
            Method m = this.table.getMethod(mce.getMethod().getName(), ((IdentifierType) t).getId().getName());
            if (m == null) this.errors.add("Method of class " + ((IdentifierType) t).getId().getName()
                    + " is not declared");
            else if (mce.getParams().size() != m.getParams().size()) this.errors.add("Incompatible number of parameters"
                    + "in method call:\n" + mce.accept(new PrettyPrintVisitor()));
            else {
                for (int i = 0; i < m.getParams().size(); i++)
                    if (!this.table.compareTypes(m.getParamAt(i).getType(), mce.getParams().get(i).accept(this))) {
                        this.errors.add("Invalid type of parameter " + m.getParamAt(i).getName() + " at:\n"
                                + mce.accept(new PrettyPrintVisitor()));
                    }
            }
            return m.type();
        }
        return null;
    }

    @Override
    public Type visit(ThisExpr te) {
        return new IdentifierType(new Identifier(this.lastClass.getName()));
    }

    @Override
    public Type visit(Program p) {
        p.getMainClass().accept(this);
        p.getClasses().accept(this);
        return null;
    }

    @Override
    public Type visit(StatementList sl) {
        for (int i = 0; i < sl.size(); i++) sl.get(i).accept(this);
        return null;
    }

    @Override
    public Type visit(ArrayAssignStmt aas) {
        Variable v = this.lastMethod.getParam(aas.getArray().getName());
        if (v == null) v = this.lastMethod.getVar(aas.getArray().getName());
        if (v == null) v = this.lastClass.getVar(aas.getArray().getName());
        if (v == null) this.errors.add("Variable " + aas.getArray().getName() + " is not declared");
        else if (!(v.getType() instanceof IntArrayType && aas.getIndex().accept(this) instanceof IntegerType
                && aas.getAssign().accept(this) instanceof IntegerType))
            this.errors.add("Invalid type of array assign statement:\n"
                    + aas.accept(new PrettyPrintVisitor()));
        return null;
    }

    @Override
    public Type visit(AssignStmt as) {
        Variable v = this.lastMethod.getParam(as.getId().getName());
        if (v == null) v = this.lastMethod.getVar(as.getId().getName());
        if (v == null) v = this.lastClass.getVar(as.getId().getName());
        if (v == null) this.errors.add("Variable " + as.getId().getName() + " is not declared");
        else if (!this.table.compareTypes(v.getType(), as.getAssign().accept(this)))
            this.errors.add("Invalid type of assign statement:\n"
                    + as.accept(new PrettyPrintVisitor()));
        return null;
    }

    @Override
    public Type visit(BlockStmt bs) {
        bs.getStmts().accept(this);
        return null;
    }

    @Override
    public Type visit(IfStmt is) {
        if (!(is.getExpr().accept(this) instanceof BooleanType)) this.errors.add("Invalid expressoin type in if:\n"
                + is.accept(new PrettyPrintVisitor()));
        else {
            is.getIfStmt().accept(this);
            is.getElseStmt().accept(this);
        }
        return null;
    }

    @Override
    public Type visit(PrintStmt ps) {
        if (ps.getExpr().accept(this) instanceof IdentifierType) this.errors.add("Print statements cannot print" +
                "identifier types:\n"
                + ps.accept(new PrettyPrintVisitor()));
        return null;
    }

    @Override
    public Type visit(WhileStmt ws) {
        if (!(ws.getExpr().accept(this) instanceof BooleanType)) this.errors.add("Invalid expressoin type in while:\n"
                + ws.accept(new PrettyPrintVisitor()));
        else ws.getStmt().accept(this);
        return null;
    }
}
