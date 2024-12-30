public class Utilisateur extends Personne {
    private String email;
    private String password;
    private Role role;
    public Utilisateur(String name, int age, String adresse, String id, String email, String password, Role role) {
        super(name, age, adresse, id);
        this.email = email;
        this.password = password;
        this.role = role;
    }

    public Utilisateur() {
        super();
    }



    public String getEmail() {
        return email;
    }
    public Role getRole(Role client) {
        return role;
    }
    public String getPassword() {
        return password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return super.toString() + ", Email: " + email + ", Role: " + role.getNomRole();
    }
}


