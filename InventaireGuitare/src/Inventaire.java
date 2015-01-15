import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;

@objid ("c80086ce-b2a3-4d16-bee3-5f5322bbfd16")
public class Inventaire {
    @objid ("4ea08b51-f64b-4310-bdaf-99cf51005456")
    private List<Guitare> guitares;

    @objid ("b1cfac02-1792-4717-9e51-93adb3553566")
    public Inventaire() {
        guitares = new LinkedList<Guitare>();
    }

    @objid ("66b6d1dc-b39c-4208-b8c8-a71bf92d66bd")
    public void addGuitare(String numSerie, double prix, Fabricant fabricant, String modele, Type type, Bois boisFond, Bois boisTable) {
    	CaracteristiquesGuitare caracteristiques = new CaracteristiquesGuitare(fabricant, type, boisFond, boisTable);
        Guitare guitare = new Guitare(numSerie, prix, modele, caracteristiques);
        guitares.add(guitare);
    }

    @objid ("632353dd-1f3e-4599-853c-3480a4bdcd93")
    public Guitare getGuitare(String numSerie) {
        for (Iterator<Guitare> i = guitares.iterator(); i.hasNext();) {
            Guitare guitare = (Guitare) i.next();
            if (guitare.getNumSerie().equals(numSerie)) {
                return guitare;
            }
        }
        return null;
    }

    @objid ("cce057d7-be01-45d8-926e-779cf3025d39")
    public List<Guitare> chercher(CaracteristiquesGuitare caracteristiques) {
        List<Guitare> guitaresTrouvees = new LinkedList<Guitare>();
        
        for (Iterator<Guitare> i = guitares.iterator(); i.hasNext();) {
            Guitare guitare = (Guitare) i.next();
            if (guitare.correspondAuxCaracteristiques(caracteristiques)) {
                guitaresTrouvees.add(guitare);
            }
        }
        return guitaresTrouvees;
    }

}
