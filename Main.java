package petmanagementsystem;
import java.util.ArrayList;
import java.util.Scanner;


public class Main {


    public static void main(String[] args) {
        Storage.admin = new Admin(1, "admin", "admin");
        
        PetOwner a = new PetOwner(1, "a", "a");
        a.addPet(new Pet(Storage.getNewPetId(), "cat","Black Hair", 2, "Good", 200, 30));
        a.addPet(new Pet(Storage.getNewPetId(), "dog","White Hair", 8, "Very Good", 700, 50));
        PetOwner b = new PetOwner(2, "b", "b");
        b.addPet(new Pet(Storage.getNewPetId(), "Monky","Black Hair", 12, "Bad", 1300, 70));
        b.addPet(new Pet(Storage.getNewPetId(), "cat","Broun Hair", 14, "Very Bad", 400, 25));
        
        Storage.petOwners.add(a);
        Storage.petOwners.add(b);
        
        Storage.notifications.add(new Notifications("fed1", "You Must Feed Your Pet", "Feeding", "06:30", "2024-12-06", 2, 1));
        Storage.notifications.add(new Notifications("fed2", "You Must Feed Your Pet", "Feeding", "18:30", "2024-12-09", 3, 2));
        Storage.notifications.add(new Notifications("vac1", "You Must Vaccin Your Pet", "Vaccination", "06:30", "2024-12-06", 3, 2));
        
        Storage.petActivities.add(new PetActivity(Storage.petActivities.size() +1 ,1, 2, "Feeding", "2024-12-06"));
        Storage.petActivities.add(new PetActivity(Storage.petActivities.size() +1 ,2, 3, "Feeding", "2024-12-07"));
        Storage.petActivities.add(new PetActivity(Storage.petActivities.size() +1 ,2, 3, "Walking", "2024-12-07"));

        
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Welcome To Pet Management System");
            System.out.println("1- Login");
            System.out.println("2- Create New Pet Owner Account");
            System.out.println("0- Exit");
            System.out.print("Your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    Storage.login(scanner);
                    break;
                case 2:
                    PetOwner.createNewAccount(scanner);
                    break;
                case 0:
                    System.out.println("Exiting the system. Goodbye!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
