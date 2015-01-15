import com.modeliosoft.modelio.javadesigner.annotations.objid;

@objid ("a08c4ca4-dbad-4001-9775-fbd5d0b333c3")
public enum Type {
	_ANY_,
    ACOUSTIQUE,
    ELECTRIQUE;

    @objid ("b66b6599-bbd0-4db7-9c46-386524feab41")
    public String toString() {
        switch (this) {
        case _ANY_:
            return "N'importe quel type";
        case ACOUSTIQUE:
            return "Acoustique";
        case ELECTRIQUE:
            return "Électrique";
        default:
            return "";
        }
    }

}
