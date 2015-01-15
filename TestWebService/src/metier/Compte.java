package metier;

import java.util.Date;
import javax.xml.bind.annotation.*;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Compte extends CompteDeBase {
	private double solde;
	@XmlTransient
	private Date dateCreation;
	
	public Compte() {
		this(0, 0);
	}
	
	public Compte(long code, double solde) {
		super(code);
		this.dateCreation = new Date();
		this.setSolde(solde);
	}

	public double getSolde() {
		return solde;
	}

	public void setSolde(double solde) {
		this.solde = solde;
	}
}
