import java.util.Scanner;


public class Main {
    private static Scanner scanner;

    public static void main(String[] args) {
        while (true) {
            // Afficher le menu
            System.out.println("\nMenu:");
            System.out.println("1. Ajouter un utilisateur");
            System.out.println("2. Afficher les utilisateurs");
            System.out.println("3. Rechercher un utilisateur");
            System.out.println("4. Modifier un utilisateur");
            System.out.println("5. Supprimer un utilisateur");
            System.out.println("6. Quitter");

            System.out.print("Choisissez une option: ");

            int choix = scanner.nextInt();
            scanner.nextLine();

            switch (choix) {
                case 1:
                    Personne.ajouterUtilisateur();
                    break;
                case 2:
                    Personne.afficherUtilisateurs();
                    break;
                case 3:
                    System.out.print("Entrez l'ID de l'utilisateur à rechercher: ");
                    String rechercheId = scanner.nextLine();
                    Personne utilisateurTrouve = Personne.rechercherUtilisateur(rechercheId);

                    if (utilisateurTrouve != null) {
                        System.out.println("Utilisateur trouvé : " + utilisateurTrouve);
                    } else {
                        System.out.println("Aucun utilisateur trouvé avec cet ID.");
                    }
                    break;
                case 4:
                    System.out.print("Entrez l'ID de l'utilisateur à modifier: ");
                    String modifierId = scanner.nextLine();
                    Personne.modifierUtilisateur(modifierId);
                    break;
                case 5:
                    System.out.print("Entrez l'ID de l'utilisateur à supprimer: ");
                    String supprimerId = scanner.nextLine();
                    Personne.supprimerUtilisateur(supprimerId);
                    break;
                case 6:
                    System.out.println("Au revoir !");
                    scanner.close();
                    return;
                default:
                    System.out.println("Option invalide. Veuillez réessayer.");
            }
        }
    }
}

