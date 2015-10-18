package miniJava.astree.objectType;

import miniJava.astree.DataType;

public class IdentifierType implements DataType {
    protected String type;

    public IdentifierType(String type) {
        this.type = type;
    }
}
