import com.modeliosoft.modelio.javadesigner.annotations.objid;

@objid ("af5f0e9c-b851-4548-952c-109b20bb0dbe")
public class Instrument {
    @objid ("dc69d9e5-43d3-460d-9cc5-09012052a169")
    private String numSerie;

    @objid ("5a171202-8e87-4159-bbad-c8c1a6f95389")
    private double prix;

    @objid ("ef83319f-862e-44af-a6a1-27039724e059")
    private PrefInstrument preferences;

    @objid ("fb1ddf06-324c-4ddd-b481-e78a36d639cc")
    public void setPreferences(PrefInstrument preferences) {
        this.preferences = preferences;
    }

    @objid ("bb9515c0-7795-4b28-87d5-b95a59e879a8")
    public PrefInstrument getPreferences() {
        return this.preferences;
    }

    @objid ("ff661b3b-a9bf-47a1-99bb-c13d73dad04b")
    public String getNumSerie() {
        return numSerie;
    }

    @objid ("fbb06ea2-334c-4e26-85f3-d8c2634e6347")
    public void setNumSerie(String numSerie) {
        this.numSerie = numSerie;
    }

    @objid ("9f031e76-ea4f-422f-9a70-158bd5a44c41")
    public double getPrix() {
        return prix;
    }

    @objid ("b15d067c-1ef8-4ec0-b727-f0f8124f73cf")
    public void setPrix(double prix) {
        this.prix = prix;
    }

    @objid ("ef92c020-4520-4766-8d6a-97b6ceefb201")
    public Instrument(String numSerie, double prix, PrefInstrument pref) {
        this.numSerie = numSerie;
        this.prix = prix;
        this.preferences = pref;
    }

    @objid ("44a859ed-9e11-4c1f-bf65-c6b8c40d2dd2")
    public String toString() {
        return "Instrument de type "+this.getClass().getName()+" \n"
                +"Prix : "+this.prix+" / numSerie : "+this.numSerie+"\n"
                +this.getPreferences().toString();
    }

}
