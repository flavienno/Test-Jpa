package fr.diginamic.banque;

import javax.persistence.Embeddable;

@Embeddable
public class Adresse {

	private Integer numero;
	private String rue;
	private String ville;
	private Integer codePostal;
	/**
	 * @param numero
	 * @param rue
	 * @param ville
	 * @param codePostal
	 */
	public Adresse(Integer numero, String rue, String ville, Integer codePostal) {
		super();
		this.numero = numero;
		this.rue = rue;
		this.ville = ville;
		this.codePostal = codePostal;
	}
	/**
	 * 
	 */
	public Adresse() {
		super();
	}
	
	

}
