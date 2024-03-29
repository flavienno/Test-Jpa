/**
 * 
 */
package fr.diginamic.banque;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author fla
 *
 */

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "TYPE",discriminatorType=DiscriminatorType.STRING)
@DiscriminatorValue("O")
@Table(name = "OPERATION")

public class Operation {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_OPERATION")
	private Integer id;
	@Column(name = "DATE", nullable = false, unique = true)
	private LocalDate date;
	@Column(name = "MONTANT")
	private Double montant;
	@Column(name = "MOTIF", length = 30, nullable = false, unique = true)
	private String motif;

	@ManyToOne
	@JoinColumn(name = "ID_COMPTE")
	private Compte compte;

	/**
	 * 
	 */
	public Operation() {

	}

	/**
	 * Getter
	 * 
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * Setter
	 * 
	 * @param id
	 *            the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * Getter
	 * 
	 * @return the date
	 */
	public LocalDate getDate() {
		return date;
	}

	/**
	 * Setter
	 * 
	 * @param date
	 *            the date to set
	 */
	public void setDate(LocalDate date) {
		this.date = date;
	}

	/**
	 * Getter
	 * 
	 * @return the montant
	 */
	public Double getMontant() {
		return montant;
	}

	/**
	 * Setter
	 * 
	 * @param montant
	 *            the montant to set
	 */
	public void setMontant(Double montant) {
		this.montant = montant;
	}

	/**
	 * Getter
	 * 
	 * @return the motif
	 */
	public String getMotif() {
		return motif;
	}

	/**
	 * Setter
	 * 
	 * @param motif
	 *            the motif to set
	 */
	public void setMotif(String motif) {
		this.motif = motif;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Operation [id=" + id + ", date=" + date + ", montant=" + montant + ", motif=" + motif + ", compte="
				+ compte + "]";
	}

	/** Getter
	 * @return the compte
	 */
	public Compte getCompte() {
		return compte;
	}

	/** Setter
	 * @param compte the compte to set
	 */
	public void setCompte(Compte compte) {
		this.compte = compte;
	}

}
