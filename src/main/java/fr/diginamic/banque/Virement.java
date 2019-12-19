/**
 * 
 */
package fr.diginamic.banque;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * @author fla
 *
 */
@Entity 
@DiscriminatorValue("V")
public class Virement extends Operation{
	
	@Column(name = "BENEFICIAIRE", length = 30, nullable = true, unique = false)
	private String beneficiaire;

	/**
	 * 
	 */
	public Virement() {
		super();
	}

	/** Getter
	 * @return the beneficiaire
	 */
	public String getBeneficiaire() {
		return beneficiaire;
	}

	/** Setter
	 * @param beneficiaire the beneficiaire to set
	 */
	public void setBeneficiaire(String beneficiaire) {
		this.beneficiaire = beneficiaire;
	}
	

}
