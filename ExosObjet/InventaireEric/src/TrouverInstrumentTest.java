import java.util.Iterator;
import java.util.List;

import com.modeliosoft.modelio.javadesigner.annotations.objid;

@objid ("763a142d-bb29-4670-a7c5-8e2befb38c4c")
public class TrouverInstrumentTest {
    @objid ("74a444f0-4f77-4ec3-ad9a-1c8dd96f9e71")
    public static void main(String[] args) {
        // Dresse l'inventaire des Guitares d'Éric
        Inventaire inventaire = new Inventaire();
        
        initialiserInventaire(inventaire);
        
        PrefInstrument prefIrene = new PrefInstrument();
        //prefIrene.setValue("fabricant", Fabricant.FENDER);
       // prefIrene.setValue("modele", "Stratocaster");
        //prefIrene.setValue("type", Type.ELECTRIQUE);
       // prefIrene.setValue("boisFond", Bois.AULNE);
       // prefIrene.setValue("boisTable", Bois.AULNE);
       // prefIrene.setValue("nbCordes", new Integer(6));
        
        List<Instrument> resultats = inventaire.chercher(prefIrene);
        
        if (!resultats.isEmpty()) {
            for (Iterator<Instrument> i = resultats.iterator(); i.hasNext();) {
                Instrument instrument = i.next();
                            
                System.out.println("Irène, peut-être aimerez-vous ceci : "+instrument.getPreferences().getValue("typeInstrument")+" : " +
                        instrument.getPreferences().getValue("boisFond") + " pour le corps, " +
                        instrument.getPreferences().getValue("boisTable")
                    + " pour la table.\n Seulement " +
                    instrument.getPrix() + " € !");
            }
        } else {
            System.out.println("Désolé, Irène, nous n'avons rien pour vous.");
        }
    }

    @objid ("774d82cb-5139-472b-9cdf-9e12db6e24ee")
    private static void initialiserInventaire(Inventaire inventaire) {
        // Ajoute des guitares dans l'inventaire...
        inventaire.addInstrument("V95693", 1299.90, new PrefInstrument(
        		new String[]{"typeInstrument", "fabricant", "modele", "type", "boisFond", "boisTable", "nbCordes"},
        		new Object[]{"Guitare", Fabricant.FENDER, "Stratocaster", Type.ELECTRIQUE, Bois.AULNE, Bois.AULNE, 6}));
        inventaire.addInstrument("V95683", 1399.90, new PrefInstrument(
        		new String[]{"typeInstrument", "fabricant", "modele", "type", "boisFond", "boisTable", "style"},
        		new Object[]{"Mandoline", Fabricant.FENDER, "Stratocaster", Type.ACOUSTIQUE, Bois.AULNE, Bois.AULNE, Style.A}));
        inventaire.addInstrument("V91781", 1499.90, new PrefInstrument(
        		new String[]{"typeInstrument", "fabricant", "modele", "type", "boisFond", "boisTable", "boisArchet"},
        		new Object[]{"Violon", Fabricant.FENDER, "Stratocaster", Type.ELECTRIQUE, Bois.AULNE, Bois.AULNE, Bois.OLIVIER}));
    }

}
