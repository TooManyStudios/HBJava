import com.modeliosoft.modelio.javadesigner.annotations.objid;

@objid ("95940fab-6098-442a-8395-f628702f98cc")
public enum Bois {
	_ANY_,
    AULNE,
    ACAJOU,
    PALISSANDRE;

    @objid ("d4c1244d-d0ce-425f-89b9-64d689815c5d")
    public String toString() {
        switch (this) {
        case _ANY_:
            return "n'importe quel bois";
        case AULNE:
            return "aulne";
        case ACAJOU:
            return "acajou";
        case PALISSANDRE:
            return "palissandre";
        default:
            return "";
        }
    }

}
