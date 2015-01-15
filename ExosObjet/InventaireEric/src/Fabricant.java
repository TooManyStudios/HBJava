import com.modeliosoft.modelio.javadesigner.annotations.objid;

@objid ("69272d7e-22cf-4dd0-8dc0-9c6a9f0788d8")
public enum Fabricant {
    FENDER,
    GIBSON;

    @objid ("3dc666ac-ca7b-484c-bff3-0474b6b172cf")
    public String toString() {
        switch (this) {
        case FENDER:
            return "Fender";
        case GIBSON:
            return "Gibson";
        default: return "";
        }
    }

}
