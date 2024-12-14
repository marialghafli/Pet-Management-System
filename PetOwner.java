package petmanagementsystem;

import java.util.ArrayList;
import java.util.Scanner;

class PetOwner extends UserAccount {
    private ArrayList<Pet> ownedPets;

    // Full constructor
    public PetOwner(int id, String username, String password) {
        super(id, username, password);
        ownedPets = new ArrayList<>();
    }

    // Methods to manage pets
    public void addPet(Pet pet) {
        ownedPets.add(pet);
    }

    public void removePet(Pet pet) {
        ownedPets.remove(pet);
    }

    public Pet viewPetDetails(int petId) {
        for (Pet pet : ownedPets) {
            if (pet.getPetId() == petId) {
                return pet;
            }
        }
        return null; // Pet not found
    }

    public void editPet(Pet updatedPet) {
        for (int i = 0; i < ownedPets.size(); i++) {
            if (ownedPets.get(i).getPetId() == updatedPet.getPetId()) {
                ownedPets.set(i, updatedPet);
                return;
            }
        }
    }

    public ArrayList<Pet> viewAllPets() {
        return ownedPets;
    }
    
    public static void createNewAccount(Scanner scanner) {
        System.out.print("Enter new username: ");
        String username = scanner.nextLine();
        System.out.print("Enter new password: ");
        String password = scanner.nextLine();
        
        PetOwner newOwner = new PetOwner(Storage.petOwners.size() + 1, username, password);
        Storage.petOwners.add(newOwner);
        System.out.println("Account created successfully for " + username + ".");
    }
}