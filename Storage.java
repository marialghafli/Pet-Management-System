package petmanagementsystem;

import java.util.ArrayList;
import java.util.Scanner;

public class Storage {
    
    public static ArrayList<PetOwner> petOwners = new ArrayList<>();
    public static ArrayList<PetActivity> petActivities = new ArrayList<>();
    public static ArrayList<Notifications> notifications = new ArrayList<>();
    public static Admin admin;
    private static int petIdCount = 1;
    
    
    public static int getNewPetId(){
        return petIdCount++;
    }
    
    public static void login(Scanner scanner) {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        PetOwner loggedInOwner = null;
        for (PetOwner owner : petOwners) {
            if (owner.getUsername().equals(username) && owner.getPassword().equals(password)) {
                loggedInOwner = owner;
                break;
            }
        }

        if (loggedInOwner != null) {
            System.out.println("Login successful! Welcome, " + username + ".");
            managePetOwner(scanner, loggedInOwner);
        } else if (admin.getUsername().equals(username) && admin.getPassword().equals(password)) {
            System.out.println("Admin login successful! Welcome, " + username + ".");
            manageAdmin(scanner);
        } else {
            System.out.println("Invalid username or password.");
        }
    }

    private static void managePetOwner(Scanner scanner, PetOwner owner) {
        while (true) {
            System.out.println("1- Manage Pets");
            System.out.println("2- View Notifications");
            System.out.println("3- View Activities");
            System.out.println("4- Reset Password");
            System.out.println("0- Logout");
            System.out.print("Your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    managePets(scanner, owner);
                    break;
                case 2:
                    viewNotifications(owner);
                    break;
                case 3:
                    viewActivities(owner);
                    break;
                case 4:
                    resetPassword(scanner, owner);
                    break;
                case 0:
                    System.out.println("Logging out...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void manageAdmin(Scanner scanner) {
        while (true) {
            System.out.println("1- Manage Pet Owners");
            System.out.println("2- Manage Pet Notifications");
            System.out.println("3- Manage Pet Activities");
            System.out.println("0- Exit");
            System.out.print("Your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    managePetOwners(scanner);
                    break;
                case 2:
                    manageNotifications(scanner);
                    break;
                case 3:
                    managePetActivities(scanner);
                    break;
                case 0:
                    System.out.println("Exiting admin management.");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void managePetOwners(Scanner scanner) {
        while (true) {
            System.out.println("1- View All Pet Owners");
            System.out.println("2- Delete Pet Owner");
            System.out.println("3- Show Pet Owner and All His Pets");
            System.out.println("0- Exit");
            System.out.print("Your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    viewAllPetOwners();
                    break;
                case 2:
                    deletePetOwner(scanner);
                    break;
                case 3:
                    showPetOwnerAndPets(scanner);
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void viewAllPetOwners() {
        if (petOwners.isEmpty()) {
            System.out.println("No pet owners found.");
        } else {
            System.out.println("List of Pet Owners:");
            for (PetOwner owner : petOwners) {
                System.out.println("ID: " + owner.getId() + ", Username: " + owner.getUsername());
            }
        }
    }

    private static void deletePetOwner(Scanner scanner) {
        System.out.print("Enter the username of the Pet Owner to delete: ");
        String username = scanner.nextLine();
        PetOwner ownerToRemove = null;
        for (PetOwner owner : petOwners) {
            if (owner.getUsername().equals(username)) {
                ownerToRemove = owner;
                break;
            }
        }
        
        if (ownerToRemove != null) {
            petOwners.remove(ownerToRemove);
            System.out.println("Pet Owner " + username + " has been deleted.");
        } else {
            System.out.println("Pet Owner not found.");
        }
    }

    private static void showPetOwnerAndPets(Scanner scanner) {
        System.out.print("Enter the username of the Pet Owner: ");
        String username = scanner.nextLine();
        PetOwner ownerToShow = null;
        for (PetOwner owner : petOwners) {
            if (owner.getUsername().equals(username)) {
                ownerToShow = owner;
                break;
            }
        }

        if (ownerToShow != null) {
            System.out.println("Pet Owner: " + ownerToShow.getUsername());
            ArrayList<Pet> ownedPets = ownerToShow.viewAllPets();
            if (ownedPets.isEmpty()) {
                System.out.println("No pets found for this owner.");
            } else {
                System.out.println("Owned Pets:");
                for (Pet pet : ownedPets) {
                    //System.out.println("ID: " + pet.getPetId() + ", Name: " + pet.getName() + ", Species: " + pet.getSpecies());
                    System.out.println(pet);
                }
            }
        } else {
            System.out.println("Pet Owner not found.");
        }
    }

    private static void managePets(Scanner scanner, PetOwner owner) {
        while (true) {
            System.out.println("1- Add Pet");
            System.out.println("2- Edit Pet");
            System.out.println("3- Delete Pet");
            System.out.println("4- View All Pets");
            System.out.println("0- Exit");
            System.out.print("Your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    addPet(scanner, owner);
                    break;
                case 2:
                    editPet(scanner, owner);
                    break;
                case 3:
                    removePet(scanner, owner);
                    break;
                case 4:
                    viewAllPets(owner);
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void addPet(Scanner scanner, PetOwner owner) {
        System.out.print("Enter pet name: ");
        String name = scanner.nextLine();
        System.out.print("Enter species: ");
        String species = scanner.nextLine();
        System.out.print("Enter age: ");
        int age = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Enter health status: ");
        String healthStatus = scanner.nextLine();
        System.out.print("Enter weight: ");
        double weight = scanner.nextDouble();
        System.out.print("Enter height: ");
        double height = scanner.nextDouble();
        
        
        Pet newPet = new Pet(getNewPetId(), name, species, age, healthStatus, weight, height);
        owner.addPet(newPet);
        System.out.println("Pet added successfully.");
    }

    private static void editPet(Scanner scanner, PetOwner owner) {
        System.out.print("Enter pet ID to edit: ");
        int petId = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        Pet petToEdit = owner.viewPetDetails(petId);
        
        if (petToEdit != null) {
            System.out.print("Enter new pet name (leave blank to keep current): ");
            String name = scanner.nextLine();
            if (!name.isEmpty()) petToEdit.setName(name);
            
            System.out.print("Enter new species (leave blank to keep current): ");
            String species = scanner.nextLine();
            if (!species.isEmpty()) petToEdit.setSpecies(species);
            
            System.out.print("Enter new age (leave blank to keep current): ");
            String ageInput = scanner.nextLine();
            if (!ageInput.isEmpty()) petToEdit.setAge(Integer.parseInt(ageInput));
            
            System.out.print("Enter new health status (leave blank to keep current): ");
            String healthStatus = scanner.nextLine();
            if (!healthStatus.isEmpty()) petToEdit.setHealthStatus(healthStatus);
            
            System.out.print("Enter new weight (leave blank to keep current): ");
            String weightInput = scanner.nextLine();
            if (!weightInput.isEmpty()) petToEdit.setWeight(Double.parseDouble(weightInput));
            
            System.out.print("Enter new height (leave blank to keep current): ");
            String heightInput = scanner.nextLine();
            if (!heightInput.isEmpty()) petToEdit.setHeight(Double.parseDouble(heightInput));
            
            System.out.println("Pet details updated successfully.");
        } else {
            System.out.println("Pet not found.");
        }
    }

    private static void removePet(Scanner scanner, PetOwner owner) {
        System.out.print("Enter pet ID to remove: ");
        int petId = scanner.nextInt();
        Pet petToRemove = null;
        for (Pet pet : owner.viewAllPets()) {
            if (pet.getPetId() == petId) {
                petToRemove = pet;
                break;
            }
        }
        
        if (petToRemove != null) {
            owner.removePet(petToRemove);
            System.out.println("Pet removed successfully.");
        } else {
            System.out.println("Pet not found.");
        }
    }

    private static void viewAllPets(PetOwner owner) {
        ArrayList<Pet> ownedPets = owner.viewAllPets();
        if (ownedPets.isEmpty()) {
            System.out.println("No pets found for this owner.");
        } else {
            System.out.println("Owned Pets:");
            for (Pet pet : ownedPets) {
                System.out.println(pet);
            }
        }
    }

    private static void viewNotifications(PetOwner owner) {
        ArrayList<Notifications> ownerNotifications = notifications;
        if (ownerNotifications.isEmpty()) {
            System.out.println("No notifications found for this owner.");
        } else {
            System.out.println("Notifications:");
            for (Notifications notification : ownerNotifications) {
                if(notification.getOwnedId() == owner.getId())
                    System.out.println(notification);
            }
        }
    }

    private static void viewActivities(PetOwner owner) {
        ArrayList<PetActivity> ownerActivities = petActivities;
        if (ownerActivities.isEmpty()) {
            System.out.println("No activities found for this owner.");
        } else {
            System.out.println("Activities:");
            for (PetActivity activity : ownerActivities) {
                if(activity.getOwnedId() == owner.getId())
                    System.out.println(activity);
            }
        }
    }

    private static void resetPassword(Scanner scanner, PetOwner owner) {
        System.out.print("Enter new password: ");
        String newPassword = scanner.nextLine();
        owner.ResetPassword(newPassword);
        System.out.println("Password reset successfully.");
    }

    private static void managePetActivities(Scanner scanner) {
        while (true) {
            System.out.println("1- Add Pet Activity");
            System.out.println("2- Edit Pet Activity");
            System.out.println("3- Delete Pet Activity");
            System.out.println("4- View All Pet Activities");
            System.out.println("0- Exit");
            System.out.print("Your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    addPetActivity(scanner);
                    break;
                case 2:
                    editPetActivity(scanner);
                    break;
                case 3:
                    deletePetActivity(scanner);
                    break;
                case 4:
                    viewAllPetActivities();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void addPetActivity(Scanner scanner) {
        try {
            
            System.out.print("Enter Owned ID: ");
            int ownedId = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            System.out.print("Enter pet ID: ");
            int petId = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            System.out.print("Enter activity type (Feeding/Walking): ");
            String activityType = scanner.nextLine();
            System.out.print("Enter activity date (YYYY-MM-DD): ");
            String activityDate = scanner.nextLine();

            PetActivity newActivity = new PetActivity( petActivities.size() +1 ,ownedId,petId, activityType, activityDate);
            petActivities.add(newActivity);
            System.out.println("Pet activity added successfully.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static void editPetActivity(Scanner scanner) {
        try {
            
            System.out.print("Enter ID to edit activity: ");
            int Id = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            PetActivity activityToEdit = null;
            for (PetActivity activity : petActivities) {
                if (activity.getId()== Id) {
                    activityToEdit = activity;
                    break;
                }
            }

            if (activityToEdit != null) {
                System.out.print("Enter new Pet ID (leave blank to keep current): ");
                String petId = scanner.nextLine();
                if (!petId.isEmpty()) activityToEdit.setPetId(Integer.parseInt(petId));

                System.out.print("Enter new Owner ID (leave blank to keep current): ");
                String ownedId = scanner.nextLine();
                if (!ownedId.isEmpty()) activityToEdit.setOwnedId(Integer.parseInt(ownedId));

                System.out.print("Enter new activity type (leave blank to keep current): ");
                String activityType = scanner.nextLine();
                if (!activityType.isEmpty()) activityToEdit.setActivityType(activityType);

                System.out.print("Enter new activity date (leave blank to keep current): ");
                String activityDate = scanner.nextLine();
                if (!activityDate.isEmpty()) activityToEdit.setActivityDate(activityDate);

                System.out.println("Pet activity updated successfully.");
            } else {
                System.out.println("Activity not found.");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static void deletePetActivity(Scanner scanner) {
        System.out.print("Enter ID to delete activity: ");
        int Id = scanner.nextInt();

        PetActivity activityToRemove = null;
        for (PetActivity activity : petActivities) {
            if (activity.getId()== Id) {
                activityToRemove = activity;
                break;
            }
        }

        if (activityToRemove != null) {
            petActivities.remove(activityToRemove);
            System.out.println("Pet activity removed successfully.");
        } else {
            System.out.println("Activity not found.");
        }
    }

    private static void viewAllPetActivities() {
        if (petActivities.isEmpty()) {
            System.out.println("No pet activities found.");
        } else {
            System.out.println("Pet Activities:");
            for (PetActivity activity : petActivities) {
                System.out.println(activity);
            }
        }
    }

    private static void manageNotifications(Scanner scanner) {
        while (true) {
            System.out.println("1- Add Notification");
            System.out.println("2- Edit Notification");
            System.out.println("3- Delete Notification");
            System.out.println("4- View All Notifications");
            System.out.println("0- Exit");
            System.out.print("Your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    addNotification(scanner);
                    break;
                case 2:
                    editNotification(scanner);
                    break;
                case 3:
                    deleteNotification(scanner);
                    break;
                case 4:
                    viewAllNotifications();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void addNotification(Scanner scanner) {
        try{
            System.out.print("Enter title: ");
            String title = scanner.nextLine();

            System.out.print("Enter message: ");
            String message = scanner.nextLine();

            System.out.print("Enter reminder type (Feeding/Appointment/Vaccination): ");
            String reminderType = scanner.nextLine();

            System.out.print("Enter time (HH:MM): ");
            String time = scanner.nextLine();

            System.out.print("Enter date (YYYY-MM-DD): ");
            String date = scanner.nextLine();

            System.out.print("Enter pet ID associated with this notification: ");
            int petId = scanner.nextInt();

            System.out.print("Enter owned ID associated with this notification: ");
            int ownedId = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            // Create a new notification with all properties
            Notifications newNotification = new Notifications(title, message, reminderType, time, date, petId, ownedId);

            notifications.add(newNotification);
            System.out.println("Notification added successfully.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static void editNotification(Scanner scanner) {
        try{
            System.out.print("Enter title of the notification to edit: ");
            String title = scanner.nextLine();

            Notifications notificationToEdit = null;
            for (Notifications notification : notifications) {
                if (notification.getTitle().equals(title)) {
                    notificationToEdit = notification;
                    break;
                }
            }

            if (notificationToEdit != null) {
                System.out.print("Enter new message (leave blank to keep current): ");
                String message = scanner.nextLine();
                if (!message.isEmpty()) notificationToEdit.setMessage(message);
                
            System.out.print("Enter new reminder type (Feeding/Appointment/Vaccination) (leave blank to keep current): ");
            String reminderType = scanner.nextLine();
            if (!reminderType.isEmpty()) notificationToEdit.setReminderType(reminderType);

            System.out.print("Enter new time (HH:MM, leave blank to keep current): ");
            String time = scanner.nextLine();
            if (!time.isEmpty()) notificationToEdit.setTime(time);

            System.out.print("Enter new date (YYYY-MM-DD, leave blank to keep current): ");
            String date = scanner.nextLine();
            if (!date.isEmpty()) notificationToEdit.setDate(date);

            System.out.print("Enter new pet ID (enter 0 to keep current): ");
            int petId = scanner.nextInt();
            if (petId != 0) notificationToEdit.setPetId(petId);
            
            System.out.print("Enter new owned ID (enter 0 to keep current): ");
            int ownedId = scanner.nextInt();
            if (ownedId != 0) notificationToEdit.setOwnedId(ownedId);

                System.out.println("Notification updated successfully.");
            } else {
                System.out.println("Notification not found.");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static void deleteNotification(Scanner scanner) {
        System.out.print("Enter title of the notification to delete: ");
        String title = scanner.nextLine();

        Notifications notificationToRemove = null;
        for (Notifications notification : notifications) {
            if (notification.getTitle().equals(title)) {
                notificationToRemove = notification;
                break;
            }
        }

        if (notificationToRemove != null) {
            notifications.remove(notificationToRemove);
            System.out.println("Notification removed successfully.");
        } else {
            System.out.println("Notification not found.");
        }
    }

    private static void viewAllNotifications() {
        if (notifications.isEmpty()) {
            System.out.println("No notifications found.");
        } else {
            System.out.println("Notifications:");
            for (Notifications notification : notifications) {
                System.out.println(notification);
            }
        }
    }
    
}
