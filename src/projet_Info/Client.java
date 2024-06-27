package projet_Info;

import java.io.Serializable;

/**
 * Classe Client
 * Cette classe permet de faire une sérialisation des données des clients
 * @version 1.2
 * 
 */
public class Client implements Serializable {

    private static final long serialVersionUID = 1L;

    /** 
     * Nom du client
     */
    private String nom;

    /**
     * Identifiant Fiscal Unique (IFU)
     */
    private String ifu;

    /**
     * Registre du Commerce et du Crédit Mobilier (RCCM)
     */
    private String rccm;

    /**
     * Adresse du client
     */
    private String adresse;

    /**
     * Code APE (Activité Principale Exercée)
     */
    private String codeApe;

    /**
     * Constructeur
     * @param nom Nom du client
     * @param ifu Identifiant Fiscal Unique
     * @param rccm Registre du Commerce et du Crédit Mobilier
     * @param adresse Adresse du client
     * @param codeApe Code APE
     */
    public Client(String nom, String ifu, String rccm, String adresse, String codeApe) {
        this.nom = nom;
        this.ifu = ifu;
        this.rccm = rccm;
        this.adresse = adresse;
        this.codeApe = codeApe;
    }

    /**
     * Getter pour l'attribut nom
     * @return Nom du client
     */
    public String getNom() {
        return nom;
    }

    /**
     * Setter pour l'attribut nom
     * @param nom Nouveau nom du client
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * Getter pour l'attribut ifu
     * @return IFU du client
     */
    public String getIfu() {
        return ifu;
    }

    /**
     * Setter pour l'attribut ifu
     * @param ifu Nouveau IFU du client
     */
    public void setIfu(String ifu) {
        this.ifu = ifu;
    }

    /**
     * Getter pour l'attribut rccm
     * @return RCCM du client
     */
    public String getRccm() {
        return rccm;
    }

    /**
     * Setter pour l'attribut rccm
     * @param rccm Nouveau RCCM du client
     */
    public void setRccm(String rccm) {
        this.rccm = rccm;
    }

    /**
     * Getter pour l'attribut adresse
     * @return Adresse du client
     */
    public String getAdresse() {
        return adresse;
    }

    /**
     * Setter pour l'attribut adresse
     * @param adresse Nouvelle adresse du client
     */
    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    /**
     * Getter pour l'attribut codeApe
     * @return Code APE du client
     */
    public String getCodeApe() {
        return codeApe;
    }

    /**
     * Setter pour l'attribut codeApe
     * @param codeApe Nouveau code APE du client
     */
    public void setCodeApe(String codeApe) {
        this.codeApe = codeApe;
    }

    /**
     * Redéfinition de la méthode toString permettant de définir la traduction de l'objet en String
     * pour l'affichage par exemple
     */
    @Override
    public String toString() {
        return "Client [Nom : " + nom + ", IFU : " + ifu + ", RCCM : " + rccm + ", Adresse : " + adresse + ", Code APE : " + codeApe + "]";
    }
}
