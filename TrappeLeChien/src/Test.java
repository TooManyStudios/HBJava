
public class Test {

	public static void main(String[] args) {
		Trappe trappe = new Trappe();
		Telecommande telecommande = new Telecommande(trappe);
		trappe.afficherStatut();
		telecommande.presserBouton();
		trappe.afficherStatut();
		try {
			Thread.sleep(10000);
			trappe.afficherStatut();
		} catch (InterruptedException e) { }
	}
}
