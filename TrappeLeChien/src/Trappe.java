import com.modeliosoft.modelio.javadesigner.annotations.objid;

import java.util.Timer;
import java.util.TimerTask;

@objid ("1e69f9f9-1dd2-4ec5-8d16-2b63c29c3173")
public class Trappe {
	
    @objid ("349a52f0-21fa-40f5-bc32-3950af08ce42")
    private boolean estOuverte;
    private boolean peutFermerALaFinDuTimer; 
    
    public Trappe() {
    	estOuverte = false;
    	peutFermerALaFinDuTimer = false;
    }

    @objid ("091aba0f-fc5d-4ddd-b3dc-52be63190728")
    public void commander() {
    	if (estOuverte) fermer();
    	else ouvrir();
    }
    
    
	public void afficherStatut() {
    	System.out.println("La trappe est " + (estOuverte ? "ouverte" : "fermée") + ".");
    }
    
	private void ouvrir() {
		System.out.println("ouvrir()");
		estOuverte = true;
		Trappe cetteTrappe = this;
		// on déclare un nouveau timer 
		// (final permet d'accéder à des variables de trappe à l'intérieur de la classe)
		final Timer timer = new Timer();
		timer.schedule(new TimerTask() {
			public void run() {
				timer.cancel();
				if(cetteTrappe.peutFermerALaFinDuTimer) cetteTrappe.fermer();
			}
		}, 5000); // 5000 est en ms = 5 secondes
		peutFermerALaFinDuTimer = true;
	}
    
    private void fermer() {
    	System.out.println("fermer()");
		estOuverte = false;
		peutFermerALaFinDuTimer = false;
	}


}
