/**
 * 
 */
package fr.diginamic.banque;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * @author fla
 *
 */

@Entity 
@DiscriminatorValue("AV")
public class AssuranceVie extends Compte{

	@Column(name = "DATE_FIN", nullable = true, unique = true)
	private LocalDate dateFin;
	@Column(name = "TAUX_AV")
	private Double tauxAv;
	/**
	 * 
	 */
	public AssuranceVie() {
		super();
	}
	/** Getter
	 * @return the dateFin
	 */
	public LocalDate getDateFin() {
		return dateFin;
	}
	/** Setter
	 * @param dateFin the dateFin to set
	 */
	public void setDateFin(LocalDate dateFin) {
		this.dateFin = dateFin;
	}
	/** Getter
	 * @return the tauxAv
	 */
	public Double getTauxAv() {
		return tauxAv;
	}
	/** Setter
	 * @param taux the tauxAv to set
	 */
	public void setTauxAv(Double taux) {
		this.tauxAv = tauxAv;
	}
	
	
}
