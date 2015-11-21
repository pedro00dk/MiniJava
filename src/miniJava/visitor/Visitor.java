package miniJava.visitor;

import miniJava.ast.Node;
import miniJava.ast.declaration.classDecl.ClassDecl;
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
import miniJava.ast.expression.Expression;
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
import miniJava.ast.type.*;

public interface Visitor<R> {

    // Interfaces
    default R visit(Node n) {
        return null;
    }

    default R visit(ClassDecl n) {
        return null;
    }

    default R visit(Expression n) {
        return null;
    }

    default R visit(Statement n) {
        return null;
    }

    default R visit(Type n) {
        return null;
    }

    // Tipos concretos
    R visit(ClassDeclList cdl);

    R visit(MainClassDecl mcd);

    R visit(ExtendedClassDecl ecd);

    R visit(SimpleClassDecl scd);

    R visit(ArgumentList al);

    R visit(MethodDeclList mdl);

    R visit(Argument a);

    R visit(MethodDecl md);

    R visit(VarDeclList vdl);

    R visit(VarDecl vd);

    R visit(ArrayLengthExpr ale);

    R visit(ArrayLookupExpr ale);

    R visit(NewArrayExpr nae);

    R visit(BinaryBooleanExpr bbe);

    R visit(BooleanLiteralExpr ble);

    R visit(UnaryBooleanExpr ube);

    R visit(IdentifierExpr ie);

    R visit(NewObjectExpr noe);

    R visit(BinaryIntegerExpr bie);

    R visit(IntegerLiteralExpr ile);

    R visit(UnaryIntegerExpr uie);

    R visit(ExpressionList e);

    R visit(MethodCallExpr mce);

    R visit(ThisExpr te);

    R visit(Identifier id);

    R visit(Program p);

    R visit(StatementList sl);

    R visit(ArrayAssignStmt aas);

    R visit(AssignStmt as);

    R visit(BlockStmt bs);

    R visit(IfStmt is);

    R visit(PrintStmt ps);

    R visit(WhileStmt ws);

    R visit(BooleanType bt);

    R visit(IdentifierType it);

    R visit(IntArrayType iat);

    R visit(IntegerType it);
}