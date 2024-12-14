package petmanagementsystem;

public class Pet {
    private int petId;
    private String name;
    private String species;
    private int age;
    private String healthStatus;
    private double weight;
    private double height;

    // Empty constructor
    public Pet() {}

    // Full constructor
    public Pet(int petId, String name, String species, int age, String healthStatus, double weight, double height) {
        this.petId = petId;
        this.name = name;
        this.species = species;
        this.age = age;
        this.healthStatus = healthStatus;
        this.weight = weight;
        this.height = height;
    }

    // Setters and Getters
    public int getPetId() {
        return petId;
    }

    public void setPetId(int petId) {
        this.petId = petId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getHealthStatus() {
        return healthStatus;
    }

    public void setHealthStatus(String healthStatus) {
        this.healthStatus = healthStatus;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    @Override
    public String toString() {
        return "Pet{" + "petId=" + petId + ", name=" + name + ", species=" + species + ", age=" + age + ", healthStatus=" + healthStatus + ", weight=" + weight + ", height=" + height + '}';
    }
    
}
