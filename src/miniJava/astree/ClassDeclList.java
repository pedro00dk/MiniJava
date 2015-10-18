package miniJava.astree;

public class ClassDeclList implements Node {
    protected ClassDecl classDecl;
    protected ClassDeclList classList;

    public ClassDeclList(ClassDecl classDecl, ClassDeclList classList) {
        this.classDecl = classDecl;
        this.classList = classList;
    }
}
