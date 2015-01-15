package ws;

import javax.jws.*;
import metier.Compte;
import java.util.*;

@WebService(serviceName="BanqueWS")
public class BanqueService extends BanqueServiceDeBase {
	
	
	public Compte getCompte(long code) {
		System.out.println("appel de méthode getCompte(" + code + ")");
		return new Compte(code, code*5000);
	}
	
	@WebMethod(exclude=true)
	public int nbComptes() {
		System.out.println("appel de méthode nbComptes() - NE DEVRAIT PAS ÊTRE VISIBLE");
		return 2;
	}
	
	@WebMethod
	public List<Compte> getComptes() {
		System.out.println("appel de méthode getComptes()");
		List<Compte> comptes = new ArrayList<Compte>();
		comptes.add(new Compte(1L, 1000));
		comptes.add(new Compte(2L, 2000));
		return comptes;
	}
}
