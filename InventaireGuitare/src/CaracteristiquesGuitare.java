import com.modeliosoft.modelio.javadesigner.annotations.objid;

@objid ("17afb845-2656-4b5a-9449-ac3929b908a4")
public class CaracteristiquesGuitare {
    @objid ("c8e91211-56de-4319-a443-928fe85cc924")
    private Bois boisFond;

    @objid ("86cafc22-4f6f-4da1-9890-f5bc5473ab3f")
    private Bois boisTable;

    @objid ("0f5ac5f9-c7f6-4737-99ab-70386457f199")
    private Fabricant fabricant;

    @objid ("71c126cc-d167-4d43-a53f-ec3d2d870623")
    private Type type;
    
    public CaracteristiquesGuitare(Fabricant fabricant, Type type, Bois boisFond, Bois boisTable) {
    	this.fabricant = fabricant;
    	this.type = type;
    	this.boisFond = boisFond;
    	this.boisTable = boisTable;
    }

    @objid ("456fbe7f-7dae-48b1-aca9-a7c7892ed1dd")
    public Bois getBoisFond() {
    	return boisFond;
    }

    @objid ("6d9654cf-3fdb-4223-b882-3677ded75eb6")
    public Bois getBoisTable() {
    	return boisTable;
    }

    @objid ("32ea1e22-3c35-49a6-bbe0-6bd5c9c9bfb9")
    public Fabricant getFabricant() {
    	return fabricant;
    }

    @objid ("1cba48a3-01b7-4d45-8bd9-b73c88942550")
    public Type getType() {
    	return type;
    }
    
    public boolean equals(CaracteristiquesGuitare caracteristiques) {
    	if (this == caracteristiques) return true;
    	
    	if (this.fabricant != caracteristiques.getFabricant()) return false;
    	if (this.type != caracteristiques.getType()) return false;
    	if (this.boisFond != caracteristiques.getBoisFond()) return false;
    	if (this.boisTable != caracteristiques.getBoisTable()) return false;
    	
    	return true;
    }
    
    public boolean correspondAuxCaracteristiques(CaracteristiquesGuitare caracteristiques) {
    	if (caracteristiques.getFabricant() != Fabricant._ANY_ &&
        		caracteristiques.getFabricant() != this.fabricant)
    		return false;
    	
        if (caracteristiques.getType() != Type._ANY_ &&
        		caracteristiques.getType() != this.type)
    		return false;
        
        if (caracteristiques.getBoisFond() != Bois._ANY_ &&
        		caracteristiques.getBoisFond() != this.boisFond)
    		return false;
        
        if (caracteristiques.getBoisTable() != Bois._ANY_ &&
        		caracteristiques.getBoisTable() != this.boisTable)
    		return false;
        
        return true;
    }

}
