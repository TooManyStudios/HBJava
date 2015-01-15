package ws;

import javax.jws.WebMethod;
import javax.jws.WebParam;

public class BanqueServiceDeBase {
	
	@WebMethod(operationName="convertirEnDirham")
	public double conversion(@WebParam(name="montant")double mt) {
	//public double conversion(double mt) {
		System.out.println("appel de méthode conversion(" + mt + ")");
		return 11 * mt;
	}
}
