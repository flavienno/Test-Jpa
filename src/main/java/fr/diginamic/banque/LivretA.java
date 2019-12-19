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
@DiscriminatorValue("LA")
public class LivretA extends Compte{
	
	@Column(name = "TAUX_LA")
	private Double tauxLa;

	/**
	 * 
	 */
	public LivretA() {
		super();
	}

	/** Getter
	 * @return the taux
	 */
	public Double getTauxLa() {
		return tauxLa;
	}

	/** Setter
	 * @param taux the taux to set
	 */
	public void setTauxLa(Double tauxLa) {
		this.tauxLa = tauxLa;
	}
	
	

}
