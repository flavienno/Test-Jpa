/**
 * 
 */
package fr.diginamic.banque;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author fla
 *
 */

@Entity
@Table(name = "CLIENT")

public class Client {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_CLIENT")
	private Integer id;
	@Column(name = "NOM", length = 30, nullable = false, unique = true)
	private String nom;
	@Column(name = "PRENOM", length = 30, nullable = false)
	private String prenom;
	@Column(name = "DATE_NAISSANCE", nullable = true, unique = true)
	private LocalDate dateNaissance;

	@Embedded
	private Adresse adresse;
	@ManyToOne
	@JoinColumn(name = "ID_BANQUE")
	private Banque banque;

	@ManyToMany
	@JoinTable(name = "COMPO", 
	joinColumns = @JoinColumn(name = "ID_COMPO_CLIENT", 
	referencedColumnName = "ID_CLIENT"), 
	inverseJoinColumns = @JoinColumn(name = "ID_COMPO_COMPTE", 
	referencedColumnName = "ID_COMPTE"))
	private Set<Compte> comptes=new HashSet<>();

	/**
	 * 
	 */
	public Client() {

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
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * Setter
	 * 
	 * @param nom
	 *            the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * Getter
	 * 
	 * @return the prenom
	 */
	public String getPrenom() {
		return prenom;
	}

	/**
	 * Setter
	 * 
	 * @param prenom
	 *            the prenom to set
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	/**
	 * Getter
	 * 
	 * @return the dateNaissance
	 */
	public LocalDate getDateNaissance() {
		return dateNaissance;
	}

	/**
	 * Setter
	 * 
	 * @param dateNaissance
	 *            the dateNaissance to set
	 */
	public void setDateNaissance(LocalDate dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Client [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", dateNaissance=" + dateNaissance
				+ ", banque=" + banque + ", comptes=" + comptes + "]";
	}

	/** Getter
	 * @return the adresse
	 */
	public Adresse getAdresse() {
		return adresse;
	}

	/** Setter
	 * @param adresse the adresse to set
	 */
	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	/** Getter
	 * @return the banque
	 */
	public Banque getBanque() {
		return banque;
	}

	/** Setter
	 * @param banque the banque to set
	 */
	public void setBanque(Banque banque) {
		this.banque = banque;
	}

	/** Getter
	 * @return the comptes
	 */
	public Set<Compte> getComptes() {
		return comptes;
	}

	/** Setter
	 * @param comptes the comptes to set
	 */
	public void setComptes(Set<Compte> comptes) {
		this.comptes = comptes;
	}

}
