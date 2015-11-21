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
import miniJava.ast.expression.list.ExpressionList;
import miniJava.ast.identifier.Identifier;
import miniJava.ast.program.Program;
import miniJava.ast.statement.*;
import miniJava.ast.statement.list.StatementList;
import miniJava.ast.type.BooleanType;
import miniJava.ast.type.IdentifierType;
import miniJava.ast.type.IntArrayType;
import miniJava.ast.type.IntegerType;

public class PrettyPrintVisitor extends AbstractVisitor<StringBuilder> {

    private int ident;

    public PrettyPrintVisitor() {
        this.ident = 0;
    }

    @Override
    public StringBuilder visit(ClassDeclList cdl) {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < cdl.size(); i++) {
            str.append(cdl.get(i).accept(this));
            str.append("\n\n");
            ident(str);
        }
        return str;
    }

    @Override
    public StringBuilder visit(MainClassDecl mcd) {
        StringBuilder str = new StringBuilder();
        str.append("public class ");
        str.append(mcd.getMainClassName().accept(this));
        str.append("{\n\n");
        this.ident++;
        ident(str);
        str.append("public static void main (String[] ");
        str.append(mcd.getArgs().accept(this));
        str.append(") {\n");
        this.ident++;
        ident(str);
        str.append(mcd.getMain().accept(this));
        this.ident--;
        str.setLength(str.length() - 1);
        str.append("}");
        str.append("\n");
        ident(str);
        this.ident--;
        str.setLength(str.length() - 1);
        str.append("}");
        str.append("\n");
        ident(str);
        return str;
    }

    @Override
    public StringBuilder visit(ExtendedClassDecl ecd) {
        StringBuilder str = new StringBuilder();
        str.append("public class ");
        str.append(ecd.getClassName().accept(this));
        str.append(" extends ");
        str.append(ecd.getExtendsClassName().accept(this));
        str.append("{\n");
        this.ident++;
        ident(str);
        str.append(ecd.getAttributes().accept(this));
        str.append(ecd.getMethods().accept(this));
        str.setLength(str.length() - 1);
        str.append("}\n");
        this.ident--;
        ident(str);
        return str;
    }

    @Override
    public StringBuilder visit(SimpleClassDecl scd) {
        StringBuilder str = new StringBuilder();
        str.append("public class ");
        str.append(scd.getClassName().accept(this));
        str.append("{\n");
        this.ident++;
        ident(str);
        str.append(scd.getAttributes().accept(this));
        str.append(scd.getMethods().accept(this));
        str.setLength(str.length() - 1);
        str.append("}\n");
        this.ident--;
        ident(str);
        return str;
    }

    @Override
    public StringBuilder visit(ArgumentList al) {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < al.size(); i++) {
            str.append(al.get(i).accept(this));
        }
        return str;
    }

    @Override
    public StringBuilder visit(MethodDeclList mdl) {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < mdl.size(); i++) {
            str.append(mdl.get(i).accept(this));
        }
        return str;
    }

    @Override
    public StringBuilder visit(Argument a) {
        StringBuilder str = new StringBuilder();
        str.append(a.getType().accept(this));
        str.append(a.getName().accept(this));
        return str;
    }

    @Override
    public StringBuilder visit(MethodDecl md) {
        StringBuilder str = new StringBuilder();
        str.append("public ");
        str.append(md.getReturnType().accept(this));
        str.append(md.getName().accept(this));
        str.append("(");
        str.append(md.getArguments().accept(this));
        str.append("){\n");
        this.ident++;
        ident(str);
        str.append(md.getVariables().accept(this));
        str.append(md.getArguments().accept(this));
        str.append(md.getStatements().accept(this));
        str.append("return ");
        str.append(md.getReturnExpr().accept(this));
        str.append(";\n");
        this.ident--;
        ident(str);
        str.append("}\n");
        ident(str);
        return str;
    }

    @Override
    public StringBuilder visit(VarDeclList vdl) {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < vdl.size(); i++) {
            str.append(vdl.get(i).accept(this));
        }
        return str;
    }

    @Override
    public StringBuilder visit(VarDecl vd) {
        StringBuilder str = new StringBuilder();
        str.append(vd.getType().accept(this));
        str.append(" ");
        str.append(vd.getId().accept(this));
        str.append(";\n");
        ident(str);
        return str;
    }

    @Override
    public StringBuilder visit(ArrayLengthExpr ale) {
        StringBuilder str = new StringBuilder();
        str.append(ale.getArray().accept(this));
        str.append(".length");
        return str;
    }

    @Override
    public StringBuilder visit(ArrayLookupExpr ale) {
        StringBuilder str = new StringBuilder();
        str.append(ale.getArray().accept(this));
        str.append("[");
        str.append(ale.getIndex().accept(this));
        str.append("]");
        return str;
    }

    @Override
    public StringBuilder visit(NewArrayExpr nae) {
        StringBuilder str = new StringBuilder();
        str.append("new int[");
        str.append(nae.getExpr().accept(this));
        str.append("]");
        return str;
    }

    @Override
    public StringBuilder visit(BinaryBooleanExpr bbe) {
        StringBuilder str = new StringBuilder();
        str.append(bbe.getExpr1().accept(this));
        switch (bbe.getOp()) {
            case AND:
                str.append(" && ");
                break;
            case OR:
                str.append(" || ");
                break;
            case EQUALS:
                str.append(" == ");
                break;
            case DIFF:
                str.append(" != ");
                break;
            case LESS:
                str.append(" < ");
                break;
            case LESS_THAN:
                str.append(" <= ");
                break;
            case GREATER:
                str.append(" > ");
                break;
            case GREATER_THAN:
                str.append(" >= ");
                break;
        }
        str.append(bbe.getExpr2().accept(this));
        return str;
    }

    @Override
    public StringBuilder visit(BooleanLiteralExpr ble) {
        return new StringBuilder(Boolean.toString(ble.isValue()));
    }

    @Override
    public StringBuilder visit(UnaryBooleanExpr ube) {
        StringBuilder str = new StringBuilder();
        str.append("!");
        str.append(ube.getExpr().accept(this));
        return str;
    }

    @Override
    public StringBuilder visit(IdentifierExpr ie) {
        return new StringBuilder(ie.getId().accept(this));
    }

    @Override
    public StringBuilder visit(NewObjectExpr noe) {
        StringBuilder str = new StringBuilder();
        str.append("new ");
        str.append(noe.getId().accept(this));
        return str;
    }

    @Override
    public StringBuilder visit(BinaryIntegerExpr bie) {
        StringBuilder str = new StringBuilder();
        str.append(bie.getExpr1().accept(this));
        switch (bie.getOp()) {
            case PLUS:
                str.append(" + ");
                break;
            case MINUS:
                str.append(" - ");
                break;
            case MUL:
                str.append(" * ");
                break;
            case DIV:
                str.append(" / ");
                break;
            case MOD:
                str.append(" % ");
                break;
        }
        str.append(bie.getExpr2().accept(this));
        return str;
    }

    @Override
    public StringBuilder visit(IntegerLiteralExpr ile) {
        return new StringBuilder(Integer.toString(ile.getValue()));
    }

    @Override
    public StringBuilder visit(ExpressionList e) {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < e.size(); i++) {
            str.append(e.get(i).accept(this));
        }
        return str;
    }

    @Override
    public StringBuilder visit(MethodCallExpr mce) {
        StringBuilder str = new StringBuilder();
        str.append(mce.getObject().accept(this));
        str.append(".");
        str.append(mce.getMethod().accept(this));
        str.append("(");
        str.append(mce.getParams().accept(this));
        str.append(")");
        return str;
    }

    @Override
    public StringBuilder visit(ThisExpr te) {
        return new StringBuilder("this");
    }

    @Override
    public StringBuilder visit(Identifier id) {
        return new StringBuilder(id.getName());
    }

    @Override
    public StringBuilder visit(Program p) {
        StringBuilder str = new StringBuilder();
        str.append(p.getMainClass().accept(this));
        str.append(p.getClasses().accept(this));
        return str;
    }

    @Override
    public StringBuilder visit(StatementList sl) {
        StringBuilder str = new StringBuilder();
        for (int i = sl.size() - 1; i >= 0; i--) {
            str.append(sl.get(i).accept(this));
        }
        return str;
    }

    @Override
    public StringBuilder visit(ArrayAssignStmt aas) {
        StringBuilder str = new StringBuilder();
        str.append(aas.getArray().accept(this));
        str.append("[");
        str.append(aas.getIndex().accept(this));
        str.append("] = ");
        str.append(aas.getAssign().accept(this));
        return str;
    }

    @Override
    public StringBuilder visit(AssignStmt as) {
        StringBuilder str = new StringBuilder();
        str.append(as.getId().accept(this));
        str.append(" = ");
        str.append(as.getAssign().accept(this));
        str.append(";\n");
        ident(str);
        return str;
    }

    @Override
    public StringBuilder visit(BlockStmt bs) {
        StringBuilder str = new StringBuilder();
        str.append("{\n");
        this.ident++;
        ident(str);
        str.append(bs.getStmts().accept(this));
        str.setLength(str.length() - 1);
        str.append("}\n");
        this.ident--;
        ident(str);
        return str;
    }

    @Override
    public StringBuilder visit(IfStmt is) {
        StringBuilder str = new StringBuilder();
        str.append("if(");
        str.append(is.getExpr().accept(this));
        str.append("){\n");
        this.ident++;
        ident(str);
        str.append(is.getIfStmt().accept(this));
        str.append("\n");
        ident(str);
        str.setLength(str.length() - 1);
        str.append("} else {\n");
        ident(str);
        str.append(is.getElseStmt().accept(this));
        str.append("\n");
        this.ident--;
        ident(str);
        str.append("}\n");
        ident(str);
        return str;
    }

    @Override
    public StringBuilder visit(PrintStmt ps) {
        StringBuilder str = new StringBuilder();
        str.append("System.out.println(");
        str.append(ps.getExpr().accept(this));
        str.append(");\n");
        ident(str);
        return str;
    }

    @Override
    public StringBuilder visit(WhileStmt ws) {
        StringBuilder str = new StringBuilder();
        str.append("while(");
        str.append(ws.getExpr().accept(this));
        str.append("){\n");
        this.ident++;
        ident(str);
        str.append(ws.getStmt().accept(this));
        str.append("\n");
        this.ident--;
        ident(str);
        str.append("}");
        ident(str);
        str.append("\n");
        ident(str);
        return str;
    }

    @Override
    public StringBuilder visit(BooleanType bt) {
        return new StringBuilder("boolean ");
    }

    @Override
    public StringBuilder visit(IdentifierType it) {
        return new StringBuilder(it.getId().accept(this));
    }

    @Override
    public StringBuilder visit(IntArrayType iat) {
        return new StringBuilder("int[] ");
    }

    @Override
    public StringBuilder visit(IntegerType it) {
        return new StringBuilder("int ");
    }

    private void ident(StringBuilder str) {
        for (int i = 0; i < this.ident; i++) {
            str.append("\t");
        }
    }
}
