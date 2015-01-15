import java.util.Iterator;
import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;

@objid ("5d1f1525-0366-4ec0-9f5c-3dce960a6266")
public class TrouverGuitareTest {
    @objid ("5fa87610-478a-4973-81e4-ee60e3fb908a")
    public static void main(String[] args) {
        // Dresse l'inventaire des guitares d'Éric
        Inventaire inventaire = new Inventaire();
        
        initialiserInventaire(inventaire);
        
        CaracteristiquesGuitare prefIrene =
        		new CaracteristiquesGuitare(Fabricant._ANY_, Type.ELECTRIQUE, Bois.ACAJOU, Bois.PALISSANDRE);
        
        List<Guitare> guitares = inventaire.chercher(prefIrene);
        
        if (guitares.size() > 0) {
        	System.out.println("Irène, peut-être aimerez-vous :");
            for (Iterator<Guitare> i = guitares.iterator(); i.hasNext();) {
                Guitare guitare = (Guitare) i.next();
                CaracteristiquesGuitare caracteristiques = guitare.getCaracteristiques();
                System.out.println("\tguitare " +
                		caracteristiques.getFabricant() + " " +
                		guitare.getModele() + " " +
                        "en " + caracteristiques.getBoisFond() + " " +
                        "/ " + caracteristiques.getBoisTable() + " " +
                        "à " + guitare.getPrix());
            }
        } else {
            System.out.println("Désolé, Irène, nous n'avons rien pour vous.");
        }
    }

    @objid ("d6340139-d285-4d09-9285-d7c45359d1ab")
    private static void initialiserInventaire(Inventaire inventaire) {
        // Ajoute des guitares dans l'inventaire...//palissandre
        inventaire.addGuitare("V95693", 1499, Fabricant.FENDER, "Stratocaster", Type.ELECTRIQUE, Bois.AULNE, Bois.AULNE);
        inventaire.addGuitare("V95694", 899, Fabricant.FENDER, "Telecaster", Type.ELECTRIQUE, Bois.AULNE, Bois.AULNE);
        inventaire.addGuitare("V91690", 1299, Fabricant.GIBSON, "SG", Type.ELECTRIQUE, Bois.AULNE, Bois.AULNE);
        inventaire.addGuitare("V91691", 1799, Fabricant.GIBSON, "LP", Type.ELECTRIQUE, Bois.AULNE, Bois.AULNE);
        inventaire.addGuitare("V95694", 1499, Fabricant.FENDER, "Stratocaster", Type.ELECTRIQUE, Bois.ACAJOU, Bois.PALISSANDRE);
        inventaire.addGuitare("V95695", 899, Fabricant.FENDER, "Telecaster", Type.ELECTRIQUE, Bois.ACAJOU, Bois.PALISSANDRE);
        inventaire.addGuitare("V91692", 1299, Fabricant.GIBSON, "SG", Type.ELECTRIQUE, Bois.ACAJOU, Bois.PALISSANDRE);
        inventaire.addGuitare("V91693", 1799, Fabricant.GIBSON, "LP", Type.ELECTRIQUE, Bois.ACAJOU, Bois.PALISSANDRE);
    }

}
