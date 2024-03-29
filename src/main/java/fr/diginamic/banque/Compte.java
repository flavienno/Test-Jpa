/**
 * 
 */
package fr.diginamic.banque;

import java.util.HashSet;
import java.util.Set;

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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author fla
 *
 */

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "TYPE",discriminatorType=DiscriminatorType.STRING)
@DiscriminatorValue("C")
@Table(name = "COMPTE")

public class Compte {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_COMPTE")
	private Integer id;

	@Column(name = "NUMERO", length = 30, nullable = false, unique = true)
	private String numero;

	@Column(name = "SOLDE")
	private Double solde;

	@ManyToMany
	@JoinTable(name = "COMPO", 
	joinColumns = @JoinColumn(name = "ID_COMPO_COMPTE", 
	referencedColumnName = "ID_COMPTE"), 
	inverseJoinColumns = @JoinColumn(name = "ID_COMPO_CLIENT", 
	referencedColumnName = "ID_CLIENT"))
	private Set<Client> clients;

	@OneToMany(mappedBy = "compte")
	private Set<Operation> operations;

	/**
	 * 
	 */
	public Compte() {
		operations = new HashSet<Operation>();
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
	 * @return the numero
	 */
	public String getNumero() {
		return numero;
	}

	/**
	 * Setter
	 * 
	 * @param numero
	 *            the numero to set
	 */
	public void setNumero(String numero) {
		this.numero = numero;
	}

	/**
	 * Getter
	 * 
	 * @return the solde
	 */
	public Double getSolde() {
		return solde;
	}

	/**
	 * Setter
	 * 
	 * @param solde
	 *            the solde to set
	 */
	public void setSolde(Double solde) {
		this.solde = solde;
	}

	/**
	 * Getter
	 * 
	 * @return the clients
	 */
	public Set<Client> getClients() {
		return clients;
	}

	/**
	 * Setter
	 * 
	 * @param clients
	 *            the clients to set
	 */
	public void setClients(Set<Client> clients) {
		this.clients = clients;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Compte [id=" + id + ", numero=" + numero + ", solde=" + solde + ", clients=" + clients + "]";
	}

}
