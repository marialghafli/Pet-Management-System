package petmanagementsystem;

public class PetActivity {
    private int id;
    private int ownedId;
    private int petId;
    private String activityType;
    private String activityDate;

    // Empty constructor
    public PetActivity() {}

    // Full constructor
    public PetActivity(int id, int ownedId, int petId, String activityType, String activityDate) {
        if (!activityType.equals("Feeding") && !activityType.equals("Walking")) {
            throw new IllegalArgumentException("Invalid activity type");
        }
        this.id = id;
        this.ownedId = ownedId;
        this.petId = petId;
        this.activityType = activityType;
        this.activityDate = activityDate;
    }

    // Setters and Getters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public int getOwnedId() {
        return ownedId;
    }

    public void setOwnedId(int ownedId) {
        this.ownedId = ownedId;
    }
    public int getPetId() {
        return petId;
    }

    public void setPetId(int petId) {
        this.petId = petId;
    }

    public String getActivityType() {
        return activityType;
    }

    public void setActivityType(String activityType) {
        if (!activityType.equals("Feeding") && !activityType.equals("Walking")) {
            throw new IllegalArgumentException("Invalid activity type");
        }
        this.activityType = activityType;
    }

    public String getActivityDate() {
        return activityDate;
    }

    public void setActivityDate(String activityDate) {
        this.activityDate = activityDate;
    }

    @Override
    public String toString() {
        return "PetActivity{" + "id=" + id + ", ownedId=" + ownedId + ", petId=" + petId + ", activityType=" + activityType + ", activityDate=" + activityDate + '}';
    }
    
    
}
