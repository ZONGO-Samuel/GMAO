package projet_Info;

import java.io.Serializable;

/**
 * Classe Connect
 * Cette classe représente les informations de connexion d'un utilisateur
 * @version 1.0
 */
public class connect implements Serializable {

    private static final long serialVersionUID = 1L;

    /** 
     * Login de l'utilisateur
     */
    private String login;

    /**
     * Mot de passe de l'utilisateur
     */
    private String password;

    /**
     * Constructeur
     * @param login Login de l'utilisateur
     * @param password Mot de passe de l'utilisateur
     */
    public connect(String login, String password) {
        this.login = login;
        this.password = password;
    }

    /**
     * Getter pour l'attribut login
     * @return Login de l'utilisateur
     */
    public String getLogin() {
        return login;
    }

    /**
     * Setter pour l'attribut login
     * @param login Nouveau login de l'utilisateur
     */
    public void setLogin(String login) {
        this.login = login;
    }

    /**
     * Getter pour l'attribut password
     * @return Mot de passe de l'utilisateur
     */
    public String getPassword() {
        return password;
    }

    /**
     * Setter pour l'attribut password
     * @param password Nouveau mot de passe de l'utilisateur
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Redéfinition de la méthode toString permettant de définir la traduction de l'objet en String
     * pour l'affichage par exemple
     */
    @Override
    public String toString() {
        return "Connect [Login : " + login + ", Password : " + password + "]";
    }
}
