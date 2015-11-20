package miniJava.visitor;

import miniJava.ast.Node;
import miniJava.ast.declaration.classDecl.ExtendedClassDecl;
import miniJava.ast.declaration.classDecl.SimpleClassDecl;
import miniJava.ast.declaration.classDecl.list.ClassDeclList;
import miniJava.ast.declaration.classDecl.main.MainClassDecl;
import miniJava.ast.declaration.methodDecl.Argument;
import miniJava.ast.declaration.methodDecl.MethodDecl;
import miniJava.ast.declaration.methodDecl.list.ArgumentList;
import miniJava.ast.declaration.methodDecl.list.MethodDeclList;
import miniJava.ast.declaration.varDecl.VarDecl;
import miniJava.ast.declaration.varDecl.list.VarDeclList;
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
import miniJava.ast.expression.integer.UnaryIntegerExpr;
import miniJava.ast.expression.list.ExpressionList;
import miniJava.ast.identifier.Identifier;
import miniJava.ast.program.Program;
import miniJava.ast.statement.*;
import miniJava.ast.statement.list.StatementList;
import miniJava.ast.type.BooleanType;
import miniJava.ast.type.IdentifierType;
import miniJava.ast.type.IntArrayType;
import miniJava.ast.type.IntegerType;

public class AbstractVisitor<R> implements Visitor<R> {

    @Override
    public final R visit(Node n) {

        // Declarações de classes
        if (n instanceof ClassDeclList) return this.visit((ClassDeclList) n);
        else if (n instanceof MainClassDecl) return this.visit((MainClassDecl) n);
        else if (n instanceof ExtendedClassDecl) return this.visit((ExtendedClassDecl) n);
        else if (n instanceof SimpleClassDecl) return this.visit((SimpleClassDecl) n);

            // Declarações de metodos
        else if (n instanceof ArgumentList) return this.visit((ArgumentList) n);
        else if (n instanceof MethodDeclList) return this.visit((MethodDeclList) n);
        else if (n instanceof Argument) return this.visit((Argument) n);
        else if (n instanceof MethodDecl) return this.visit((MethodDecl) n);

            // Declarações de variavies
        else if (n instanceof VarDeclList) return this.visit((VarDeclList) n);
        else if (n instanceof VarDecl) return this.visit((VarDecl) n);

            // Expressões
        else if (n instanceof ArrayLengthExpr) return this.visit((ArrayLengthExpr) n);
        else if (n instanceof ArrayLookupExpr) return this.visit((ArrayLookupExpr) n);
        else if (n instanceof NewArrayExpr) return this.visit((NewArrayExpr) n);
        else if (n instanceof BinaryBooleanExpr) return this.visit((BinaryBooleanExpr) n);
        else if (n instanceof BooleanLiteralExpr) return this.visit((BooleanLiteralExpr) n);
        else if (n instanceof UnaryBooleanExpr) return this.visit((UnaryBooleanExpr) n);
        else if (n instanceof IdentifierExpr) return this.visit((IdentifierExpr) n);
        else if (n instanceof NewObjectExpr) return this.visit((NewObjectExpr) n);
        else if (n instanceof BinaryIntegerExpr) return this.visit((BinaryIntegerExpr) n);
        else if (n instanceof IntegerLiteralExpr) return this.visit((IntegerLiteralExpr) n);
        else if (n instanceof UnaryIntegerExpr) return this.visit((UnaryIntegerExpr) n);
        else if (n instanceof ExpressionList) return this.visit((ExpressionList) n);
        else if (n instanceof MethodCallExpr) return this.visit((MethodCallExpr) n);
        else if (n instanceof ThisExpr) return this.visit((ThisExpr) n);

            // Identificador
        else if (n instanceof Identifier) return this.visit((Identifier) n);

            // Programa
        else if (n instanceof Program) return this.visit((Program) n);

            // Afirmações
        else if (n instanceof StatementList) return this.visit((StatementList) n);
        else if (n instanceof ArrayAssignStmt) return this.visit((ArrayAssignStmt) n);
        else if (n instanceof AssignStmt) return this.visit((AssignStmt) n);
        else if (n instanceof BlockStmt) return this.visit((BlockStmt) n);
        else if (n instanceof IfStmt) return this.visit((IfStmt) n);
        else if (n instanceof PrintStmt) return this.visit((PrintStmt) n);
        else if (n instanceof WhileStmt) return this.visit((WhileStmt) n);

            // Tipos de dados
        else if (n instanceof BooleanType) return this.visit((BooleanType) n);
        else if (n instanceof IdentifierType) return this.visit((IdentifierType) n);
        else if (n instanceof IntArrayType) return this.visit((IntArrayType) n);
        else if (n instanceof IntegerType) return this.visit((IntegerType) n);
        else return null;
    }

    public R visit(ClassDeclList cdl) {
        return null;
    }

    public R visit(MainClassDecl mcd) {
        return null;
    }

    public R visit(ExtendedClassDecl ecd) {
        return null;
    }

    public R visit(SimpleClassDecl scd) {
        return null;
    }

    public R visit(ArgumentList al) {
        return null;
    }

    public R visit(MethodDeclList mdl) {
        return null;
    }

    public R visit(Argument a) {
        return null;
    }

    public R visit(MethodDecl md) {
        return null;
    }

    public R visit(VarDeclList vdl) {
        return null;
    }

    public R visit(VarDecl vd) {
        return null;
    }

    public R visit(ArrayLengthExpr ale) {
        return null;
    }

    public R visit(ArrayLookupExpr ale) {
        return null;
    }

    public R visit(NewArrayExpr nae) {
        return null;
    }

    public R visit(BinaryBooleanExpr bbe) {
        return null;
    }

    public R visit(BooleanLiteralExpr ble) {
        return null;
    }

    public R visit(UnaryBooleanExpr ube) {
        return null;
    }

    public R visit(IdentifierExpr ie) {
        return null;
    }

    public R visit(NewObjectExpr noe) {
        return null;
    }

    public R visit(BinaryIntegerExpr bie) {
        return null;
    }

    public R visit(IntegerLiteralExpr ile) {
        return null;
    }

    public R visit(UnaryIntegerExpr uie) {
        return null;
    }

    public R visit(ExpressionList e) {
        return null;
    }

    public R visit(MethodCallExpr mce) {
        return null;
    }

    public R visit(ThisExpr te) {
        return null;
    }

    public R visit(Identifier id) {
        return null;
    }

    public R visit(Program p) {
        return null;
    }

    public R visit(StatementList sl) {
        return null;
    }

    public R visit(ArrayAssignStmt aas) {
        return null;
    }

    public R visit(AssignStmt as) {
        return null;
    }

    public R visit(BlockStmt bs) {
        return null;
    }

    public R visit(IfStmt is) {
        return null;
    }

    public R visit(PrintStmt ps) {
        return null;
    }

    public R visit(WhileStmt ws) {
        return null;
    }

    public R visit(BooleanType bt) {
        return null;
    }

    public R visit(IdentifierType it) {
        return null;
    }

    public R visit(IntArrayType iat) {
        return null;
    }

    public R visit(IntegerType it) {
        return null;
    }
}
