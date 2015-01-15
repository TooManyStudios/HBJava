import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

import com.modeliosoft.modelio.javadesigner.annotations.objid;

@objid ("0b5d88ae-19b2-45ed-84fe-c8ff161da5db")
public class PrefInstrument {
	
	private HashMap<String, Object> map;
	
	public HashMap<String, Object> getMap() {
		return map;
	}

	@objid ("16fc69ab-2737-472b-89f3-35c285d1de80")
    public PrefInstrument() {
    	map = new HashMap<String, Object>();
    }
	
	@objid ("16fc69ab-2737-472b-89f3-35c285d1de80")
    public PrefInstrument(String[] cles, Object[] valeurs) {
    	this();
        if (cles.length != valeurs.length) {
        	// renvoyer une exception ?
        	System.out.println("erreur constructeur PrefInstrument() : pas le même nombre de clés et de valeurs");
        } else {
			for (int i = 0; i < cles.length; ++i) {
				map.put(cles[i], valeurs[i]);
			}
		}
    }
	
    @objid ("ad5ab61f-36f8-43bc-b458-bc3b7105e1cb")
    public Object getValue(String cle) {
        return map.get(cle);
    }

    @objid ("443374b3-d1b2-4228-ba77-88a5fe3c1230")
    public void setValue(String cle, Object valeur) {
        map.put(cle, valeur);
    }

    @objid ("eb0e2896-74a5-460f-803c-64f0fddb1410")
    public boolean equals(PrefInstrument prefInstrument) {
        if (this == prefInstrument) {
            return true;
        }
        
        HashMap<String, Object> otherMap = prefInstrument.getMap();
        Iterator<Entry<String, Object>> it = otherMap.entrySet().iterator();
        while (it.hasNext()) {
        	Entry<String, Object> entry = (Entry<String, Object>) it.next();
        	if (!map.containsKey(entry.getKey())) return false;
        	if (!map.get(entry.getKey()).equals(entry.getValue())) return false;
        }
        
        return true;
    }

    @objid ("72f1c30a-6da1-4cd3-a56c-1fc096f3620d")
    public String toString() {
    	if (!map.containsKey("typeInstrument")) {
    		return "type inconnu";
    	}
        return (String) map.get("typeInstrument");
    }

}
