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

    public StringBuilder visit(ClassDeclList cdl) {
        StringBuilder str = new StringBuilder();
        for(int i = 0; i < cdl.size(); i++){
            str.append(visit(cdl.get(i)));
            str.append("\n\n");
        }

        return str;
    }

    public StringBuilder visit(MainClassDecl mcd) {
        StringBuilder str = new StringBuilder();

        str.append("public class ");
        str.append(visit(mcd.getMainClassName()));
        str.append("{\n\n" + "public static void main (String[] ");
        str.append( visit(mcd.getArgs()) );
        str.append(") {\n");
        str.append(visit(mcd.getMain()));
        str.append("\n}\n}" );

        return str;
    }

    public StringBuilder visit(ExtendedClassDecl ecd) {

        StringBuilder str = new StringBuilder();
        str.append("public class ");
        str.append(visit(ecd.getClassName()));
        str.append(" extends ");
        str.append(visit(ecd.getExtendsClassName()));
        str.append("{\n");
        str.append(visit(ecd.getAttributes()));
        str.append(visit(ecd.getMethods()));
        return str;
    }

    public StringBuilder visit(SimpleClassDecl scd) {
        StringBuilder str = new StringBuilder();
        str.append("public class ");
        str.append(visit(scd.getClassName()));
        str.append("{\n");
        str.append(visit(scd.getAttributes()));
        str.append(visit(scd.getMethods()));
        return str;
    }

    public StringBuilder visit(ArgumentList al) {
        StringBuilder str = new StringBuilder();
        for(int i = 0; i < al.size(); i++){
            str.append(visit(al.get(i)));
        }
        return str;
    }

    public StringBuilder visit(MethodDeclList mdl) {
        StringBuilder str = new StringBuilder();
        for(int i = 0; i < mdl.size(); i++){
            str.append(visit(mdl.get(i)));
        }
        return str;
    }

    public StringBuilder visit(Argument a) {
        StringBuilder str = new StringBuilder();
        str.append(visit(a.getType()));
        str.append(visit(a.getName()));
        return str;
    }

    public StringBuilder visit(MethodDecl md) {
        StringBuilder str = new StringBuilder();
        str.append("public ");
        str.append(visit(md.getReturnType()));
        str.append(visit(md.getName()));
        str.append("(");
        str.append(visit(md.getArguments()));
        str.append("){\n");
        str.append(visit(md.getVariables()));
        str.append(visit(md.getArguments()));
        str.append(visit(md.getStatements()));
        str.append(visit(md.getReturnExpr()));
        str.append("\n}\n");
        return str;
    }

    public StringBuilder visit(VarDeclList vdl) {
        StringBuilder str = new StringBuilder();
        for(int i = 0; i< vdl.size(); i++){
            str.append(visit(vdl.get(i)));
            if(vdl.size()-1 != i){
                str.append(", ");
            }
        }
        return str;
    }

    public StringBuilder visit(VarDecl vd) {
        StringBuilder str = new StringBuilder();
        str.append(visit(vd.getType()));
        str.append(" ");
        str.append(visit(vd.getId()));
        return str;
    }

    public StringBuilder visit(ArrayLengthExpr ale) {
        StringBuilder str = new StringBuilder();
        str.append(visit(ale.getArray()));
        str.append(".length");
        return str;
    }

    public StringBuilder visit(ArrayLookupExpr ale) {
        StringBuilder str = new StringBuilder();
        str.append(visit(ale.getArray()));
        str.append("[");
        str.append(visit(ale.getIndex()));
        str.append("]");
        return str;
    }

    public StringBuilder visit(NewArrayExpr nae) {
        StringBuilder str = new StringBuilder();
        str.append("new int[");
        str.append(visit(nae.getExpr()));
        str.append("]");
        return str;
    }

    public StringBuilder visit(BinaryBooleanExpr bbe) {
        StringBuilder str = new StringBuilder();
        str.append(visit(bbe.getExpr1()));
        switch (bbe.getOp()){

            case AND: str.append(" && ");
                break;
            case OR: str.append(" || ");
                break;
            case EQUALS: str.append(" == ");
                break;
            case DIFF: str.append(" != ");
                break;
            case LESS: str.append(" < ");
                break;
            case LESS_THAN: str.append(" <= ");
                break;
            case GREATER: str.append(" > ");
                break;
            case GREATER_THAN: str.append(" >= ");
                break;
        }
        str.append(visit(bbe.getExpr2()));
        return str;
    }

    public StringBuilder visit(BooleanLiteralExpr ble) {
        return new StringBuilder(Boolean.toString(ble.isValue()));
    }

    public StringBuilder visit(UnaryBooleanExpr ube) {
        StringBuilder str = new StringBuilder();
        str.append("!");
        str.append(visit(ube.getExpr()));
        return str;
    }

    public StringBuilder visit(IdentifierExpr ie) {
        return new StringBuilder(visit(ie.getId()));
    }

    public StringBuilder visit(NewObjectExpr noe) {
        StringBuilder str = new StringBuilder();
        str.append("new ");
        str.append(visit(noe.getId()));
        return str;
    }

    public StringBuilder visit(BinaryIntegerExpr bie) {
        StringBuilder str = new StringBuilder();
        str.append(visit(bie.getExpr1()));
        switch (bie.getOp()){
            case PLUS: str.append(" + ");
                break;

            case MINUS: str.append(" - ");
                break;
            case MUL: str.append(" * ");
                break;
            case DIV: str.append(" / ");
                break;
            case MOD: str.append(" % ");
                break;
        }
        str.append(visit(bie.getExpr2()));
        return str;
    }

    public StringBuilder visit(IntegerLiteralExpr ile) {
        return new StringBuilder(ile.getValue());
    }

    public StringBuilder visit(ExpressionList e) {
        StringBuilder str = new StringBuilder();
        for(int i = 0; i < e.size(); i++){
            str.append(visit(e.get(i)));
        }
        return str;
    }

    public StringBuilder visit(MethodCallExpr mce) {
        StringBuilder str = new StringBuilder();
        str.append(visit(mce.getObject()));
        str.append(".");
        str.append(visit(mce.getMethod()));
        str.append("(");
        str.append(visit(mce.getParams()));
        str.append(")");
        return str;
    }

    public StringBuilder visit(ThisExpr te) {
        return new StringBuilder("this");
    }

    public StringBuilder visit(Identifier id) {
        return new StringBuilder(id.getName());
    }

    public StringBuilder visit(Program p) {
        StringBuilder str = new StringBuilder();
        str.append(visit(p.getMainClass()));
        str.append(visit(p.getClasses()));
        return str;
    }

    public StringBuilder visit(StatementList sl) {
        StringBuilder str = new StringBuilder();
        for(int i = 0; i < sl.size(); i++){
            str.append(visit(sl.get(i)));
        }
        return str;
    }

    public StringBuilder visit(ArrayAssignStmt aas) {
        StringBuilder str = new StringBuilder();
        str.append(visit(aas.getArray()));
        str.append("[");
        str.append(visit(aas.getIndex()));
        str.append("] = ");
        str.append(visit(aas.getAssign()));
        return str;
    }

    public StringBuilder visit(AssignStmt as) {
        StringBuilder str = new StringBuilder();
        str.append(visit(as.getId()));
        str.append(" = ");
        str.append(visit(as.getAssign()));
        return str;
    }

    public StringBuilder visit(BlockStmt bs) {
        StringBuilder str = new StringBuilder();
        str.append("{\n");
        str.append(visit(bs.getStmts()));
        str.append("\n}\n");
        return str;
    }

    public StringBuilder visit(IfStmt is) {
        StringBuilder str = new StringBuilder();
        str.append("if(");
        str.append(visit(is.getExpr()));
        str.append("){\n");
        str.append(visit(is.getIfStmt()));
        str.append("\n} else {\n");
        str.append(visit(is.getElseStmt()));
        str.append("\n}\n");
        return str;
    }

    public StringBuilder visit(PrintStmt ps) {
        StringBuilder str = new StringBuilder();
        str.append("System.out.println(");
        str.append(visit(ps.getExpr()));
        str.append(");\n");
        return str;
    }

    public StringBuilder visit(WhileStmt ws) {
        StringBuilder str = new StringBuilder();
        str.append("while(");
        str.append(visit(ws.getExpr()));
        str.append("){\n");
        str.append(visit(ws.getStmt()));
        str.append("\n}\n");
        return str;
    }

    public StringBuilder visit(BooleanType bt) {
        return new StringBuilder("boolean ");
    }

    public StringBuilder visit(IdentifierType it) {
        return new StringBuilder(visit(it.getId()));
    }

    public StringBuilder visit(IntArrayType iat) {
        return new StringBuilder("int[] ");
    }

    public StringBuilder visit(IntegerType it) {
        return new StringBuilder("int ");
    }

}
