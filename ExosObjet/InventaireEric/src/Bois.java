import com.modeliosoft.modelio.javadesigner.annotations.objid;

@objid ("3533d208-2179-4522-b62e-e7069f633fd7")
public enum Bois {
    AULNE,
    FRENE,
    OLIVIER,
    CHENE;

    @objid ("70c551c0-9a83-4080-a77e-2ea65c6b7e77")
    public String toString() {
        switch (this) {
        case AULNE:
            return "Aulne";
        case FRENE:
            return "Fr�ne";
        case OLIVIER:
            return "Olivier";
        case CHENE:
            return "Ch�ne";
        default: return "";
        }
    }

}
