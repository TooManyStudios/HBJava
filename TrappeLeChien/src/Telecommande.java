import com.modeliosoft.modelio.javadesigner.annotations.objid;

@objid ("eb9a54a8-c33b-457e-be89-5fd3b1513f12")
public class Telecommande {
    @objid ("7648ce76-1ddc-4673-b777-622bef7cb431")
    private Trappe trappe;

    public Telecommande(Trappe trappe) {
    	this.trappe = trappe;
    }
    
    @objid ("828645f8-9336-4986-98ab-cbbbfdddea41")
    public void presserBouton() {
    	trappe.commander();
    }

}
