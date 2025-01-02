import java.util.ArrayList;
import java.util.Scanner;
import java.util.ArrayList;
public class Personne {
    private String nom;
    private int age;
    private String adresse;
    private String id;
    private Role role;

    // Liste pour stocker les utilisateurs
    private static ArrayList<Personne> utilisateurs = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    // Constructeur
    public Personne(String nom, int age, String adresse, String id, String email, String password, Role role) {
        this.nom = nom;
        this.age = age;
        this.adresse = adresse;
        this.id = id;
        this.role = role;
    }

    public Personne() {
    }

    public Personne(String name, int age, String adresse, String id) {
    }

    // Getters et Setters
    public String getId() {
        return id;
    }

    public void setName(String nom) {
        this.nom = nom;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "Personne{" +
                "nom='" + nom + '\'' +
                ", age=" + age +
                ", adresse='" + adresse + '\'' +
                ", id='" + id + '\'' +
                ", role=" + role +
                '}';
    }

    // Méthodes pour gérer les utilisateurs

    private static Role definirRole() {
        int choisirRole;

        while (true) {
            System.out.println("Choisissez le rôle (1 pour Administrateur, 2 pour Employé, 3 pour Client): ");
            choisirRole = scanner.nextInt();
            scanner.nextLine();

            switch (choisirRole) {
                case 1:
                    return new Role("Administrateur");
                case 2:
                    return new Role("Employé");
                case 3:
                    return new Role("Client");
                default:
                    System.out.println("Rôle invalide, veuillez réessayer.");
                    break;
            }
        }
    }

    public static void ajouterUtilisateur() {
        System.out.print("Nom: ");
        String nom = scanner.nextLine();

        System.out.print("Âge: ");
        int age = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Adresse: ");
        String adresse = scanner.nextLine();

        System.out.print("ID: ");
        String id = scanner.nextLine();

        System.out.print("Email: ");
        String email = scanner.nextLine();

        System.out.print("Mot de passe: ");
        String password = scanner.nextLine();

        Role roleChoisi = definirRole();

        Personne nouvelUtilisateur = new Personne(nom, age, adresse, id, email, password, roleChoisi);
        utilisateurs.add(nouvelUtilisateur);
        System.out.println("Utilisateur ajouté : " + nouvelUtilisateur);
        
    }

    public static void afficherUtilisateurs() {
        for (Personne u : utilisateurs) {
            System.out.println(u);
        }
    }

    public static Personne rechercherUtilisateur(String id) {
        for (Personne util : utilisateurs) {
            if (util.getId().equals(id)) {
                return util;
            }
        }
        return null;
    }

    public static void modifierUtilisateur(String id) {
        Personne utilisateurExist = rechercherUtilisateur(id);

        if (utilisateurExist != null) {
            //  les nouvelles informations :
            System.out.print("Nouveau Nom (laisser vide pour ne pas changer): ");
            String nouveauNom = scanner.nextLine();
            if (!nouveauNom.isEmpty()) utilisateurExist.setName(nouveauNom);

            System.out.print("Nouvel Âge (laisser vide pour ne pas changer): ");
            String ageInput = scanner.nextLine();
            if (!ageInput.isEmpty()) utilisateurExist.setAge(Integer.parseInt(ageInput));

            System.out.print("Nouvelle Adresse (laisser vide pour ne pas changer): ");
            String nouvelleAdresse = scanner.nextLine();
            if (!nouvelleAdresse.isEmpty()) utilisateurExist.setAdresse(nouvelleAdresse);

            // Changer le rôle :
            System.out.print("Voulez-vous changer le rôle ? (oui/non): ");
            if (scanner.nextLine().equalsIgnoreCase("oui")) {
                utilisateurExist.setRole(definirRole());
            }

            System.out.println("Utilisateur modifié : " + utilisateurExist);
        } else {
            System.out.println("Aucun utilisateur trouvé avec cet ID.");
        }
    }

    public static void supprimerUtilisateur(String id) {
        Personne utilisateurExist = rechercherUtilisateur(id);

        if (utilisateurExist != null) {
            utilisateurs.remove(utilisateurExist);
            System.out.println("Utilisateur supprimé : " + utilisateurExist);
        } else {
            System.out.println("Aucun utilisateur trouvé avec cet ID.");
        }
    }


}
