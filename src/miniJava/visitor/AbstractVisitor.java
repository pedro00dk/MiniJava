package miniJava.visitor;

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

public abstract class AbstractVisitor<R> implements Visitor<R> {

    @Override
    public R visit(ClassDeclList cdl) {
        return null;
    }

    @Override
    public R visit(MainClassDecl mcd) {
        return null;
    }

    @Override
    public R visit(ExtendedClassDecl ecd) {
        return null;
    }

    @Override
    public R visit(SimpleClassDecl scd) {
        return null;
    }

    @Override
    public R visit(ArgumentList al) {
        return null;
    }

    @Override
    public R visit(MethodDeclList mdl) {
        return null;
    }

    @Override
    public R visit(Argument a) {
        return null;
    }

    @Override
    public R visit(MethodDecl md) {
        return null;
    }

    @Override
    public R visit(VarDeclList vdl) {
        return null;
    }

    @Override
    public R visit(VarDecl vd) {
        return null;
    }

    @Override
    public R visit(ArrayLengthExpr ale) {
        return null;
    }

    @Override
    public R visit(ArrayLookupExpr ale) {
        return null;
    }

    @Override
    public R visit(NewArrayExpr nae) {
        return null;
    }

    @Override
    public R visit(BinaryBooleanExpr bbe) {
        return null;
    }

    @Override
    public R visit(BooleanLiteralExpr ble) {
        return null;
    }

    @Override
    public R visit(UnaryBooleanExpr ube) {
        return null;
    }

    @Override
    public R visit(IdentifierExpr ie) {
        return null;
    }

    @Override
    public R visit(NewObjectExpr noe) {
        return null;
    }

    @Override
    public R visit(BinaryIntegerExpr bie) {
        return null;
    }

    @Override
    public R visit(IntegerLiteralExpr ile) {
        return null;
    }

    @Override
    public R visit(UnaryIntegerExpr uie) {
        return null;
    }

    @Override
    public R visit(ExpressionList e) {
        return null;
    }

    @Override
    public R visit(MethodCallExpr mce) {
        return null;
    }

    @Override
    public R visit(ThisExpr te) {
        return null;
    }

    @Override
    public R visit(Identifier id) {
        return null;
    }

    @Override
    public R visit(Program p) {
        return null;
    }

    @Override
    public R visit(StatementList sl) {
        return null;
    }

    @Override
    public R visit(ArrayAssignStmt aas) {
        return null;
    }

    @Override
    public R visit(AssignStmt as) {
        return null;
    }

    @Override
    public R visit(BlockStmt bs) {
        return null;
    }

    @Override
    public R visit(IfStmt is) {
        return null;
    }

    @Override
    public R visit(PrintStmt ps) {
        return null;
    }

    @Override
    public R visit(WhileStmt ws) {
        return null;
    }

    @Override
    public R visit(BooleanType bt) {
        return null;
    }

    @Override
    public R visit(IdentifierType it) {
        return null;
    }

    @Override
    public R visit(IntArrayType iat) {
        return null;
    }

    @Override
    public R visit(IntegerType it) {
        return null;
    }
}
