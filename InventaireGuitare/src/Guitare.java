import com.modeliosoft.modelio.javadesigner.annotations.objid;

@objid ("f26bc6a9-2a17-48ed-a6f3-629abe1e11a8")
public class Guitare {
    @objid ("fbd2b9e7-e157-44f1-be7f-8d29a726a74b")
    private String numSerie;

    @objid ("b9add983-840e-4233-9bb6-f8cc7a24c0c7")
    private String modele;

    @objid ("cda7dd15-775d-408f-9c49-7846451d9529")
    private double prix;

    @objid ("6349dfee-94c5-44f8-a47a-89da344855df")
    private CaracteristiquesGuitare caracteristiquesGuitare;

    @objid ("1d6a83f1-0f06-45a9-bde1-8047256d25d3")
    public Guitare(String numSerie, double prix, String modele, CaracteristiquesGuitare caracteristiques) {
        this.numSerie = numSerie;
        this.prix = prix;
        this.modele = modele;
        this.caracteristiquesGuitare = caracteristiques;
    }

    @objid ("e548be70-cfe8-47f2-b0f9-a10f1435e7b6")
    public String getNumSerie() {
        return numSerie;
    }

    @objid ("da72d351-7554-4e5f-8dee-55861cca8a7d")
    public double getPrix() {
        return prix;
    }

    @objid ("e00d7c48-e334-4b91-bec2-0706d50f3235")
    public void setPrix(float nouveauPrix) {
        this.prix = nouveauPrix;
    }

    @objid ("3ce0eb4c-ef3f-40b8-8ab2-5cf00f1f9127")
    public CaracteristiquesGuitare getCaracteristiques() {
        return caracteristiquesGuitare;
    }

    @objid ("8c4f289b-5a4d-47c7-8d5e-6ae7f34c7454")
    public String getModele() {
        return modele;
    }

    @objid ("05334777-adf4-41ca-989a-a131639c14d6")
    public boolean equals(Guitare guitare) {
        // Ignore le numéro de série puisqu'il est unique
        // Ignore le prix puisqu'il est unique
        
    	CaracteristiquesGuitare caracteristiques = guitare.getCaracteristiques();
    	
    	if (!caracteristiques.equals(this.caracteristiquesGuitare))
    		return false;
    	
        String modele = guitare.getModele();
        
        if (!testString(modele, this.modele))
            return false;
        
        return true;
    }

    @objid ("ef9480ca-b632-4b2e-ace0-92d6e213a281")
    private boolean testString(String s1, String s2) {
        if (s1 == null) return false;
        if (s1.equals("")) return false;
        return s1.equalsIgnoreCase(s2);
    }
    
    public boolean correspondAuxCaracteristiques(CaracteristiquesGuitare caracteristiques) {
       return this.caracteristiquesGuitare.correspondAuxCaracteristiques(caracteristiques);
    }

}
