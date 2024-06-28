package projet_Info;

public class Operateur {
    private String nom;
    private String login;
    private String email;
    private String password;

    public Operateur(String nom, String login, String email, String password) {
        this.nom = nom;
        this.login = login;
        this.email = email;
        this.password = password;
    }

    public Operateur(int id, String nom2, String login2, String email2, String password2) {
		// TODO Auto-generated constructor stub
	}

	// Getters et Setters (si nécessaire)
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

	public int getIdOperateur() {
		// TODO Auto-generated method stub
		return 0;
	}
}
