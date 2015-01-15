import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;

@objid ("6dbd047f-52a2-4375-bf0a-4ef20a4fbeb2")
public class Inventaire {
    @objid ("a424bc63-3d77-4436-83cb-bd0be3774746")
    private List<Instrument> instruments;

    @objid ("970fda68-0494-4bf7-86d8-f3d3565999af")
    public Inventaire() {
        instruments = new ArrayList<Instrument>();
    }

    @objid ("2694b789-f47b-4a27-856c-b98b58ba89e1")
    public Instrument getInstrument(String numSerie) {
        for (Iterator<Instrument> i = instruments.iterator(); i.hasNext();) {
            Instrument instrument = i.next();
        
            if (instrument.getNumSerie().equals(numSerie)) {
                return instrument;
            }
        
        }
        return null;
    }

    @objid ("d21b94fb-c515-4be9-8392-6720b1f7787a")
    public void addInstrument(String numSerie, double prix, PrefInstrument preferences) {
        Instrument instrument = new Instrument(numSerie, prix, preferences);
        instruments.add(instrument);
    }
    
    public List<Instrument> chercher(PrefInstrument preferences) {
    	List<Instrument> resultats = new ArrayList<Instrument>();

    	for (Iterator<Instrument> i = instruments.iterator(); i.hasNext();) {
    		Instrument instrument = i.next();
    		if (instrument.getPreferences().equals(preferences)) {
    			resultats.add(instrument);
    		}
    	}
    	
		return resultats;
    }

}
