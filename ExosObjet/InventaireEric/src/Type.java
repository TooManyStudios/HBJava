import com.modeliosoft.modelio.javadesigner.annotations.objid;

@objid ("fc0d57fc-780e-4982-a301-8a3dea829a85")
public enum Type {
    ACOUSTIQUE,
    ELECTRIQUE;

    @objid ("10417aea-dbcb-467e-898e-e81cef7080a2")
    public String toString() {
        switch (this) {
        case ACOUSTIQUE:
            return "Acoustique";
        case ELECTRIQUE:
            return "Electrique";
        default: return "";
        }
    }

}
