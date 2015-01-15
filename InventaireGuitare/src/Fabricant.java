import com.modeliosoft.modelio.javadesigner.annotations.objid;

@objid ("22e94dfb-911e-44dd-9ba3-54db9c0cc4f5")
public enum Fabricant {
	_ANY_,
    FENDER,
    GIBSON,
    LAG,
    YAMAHA;

    @objid ("f4f91fdf-0e56-410a-80db-a0da2fa79256")
    public String toString() {
        switch (this) {
        case _ANY_:
            return "N'importe quel fabricant";
        case FENDER:
            return "Fender";
        case GIBSON:
            return "Gibson";
        case LAG:
            return "Lâg";
        case YAMAHA:
            return "Yamaha";
        default:
            return "";
        }
    }

}
