package petmanagementsystem;

public class Notifications {
    private String title;
    private String message;
    private String reminderType;
    private String time;
    private String date;
    private int petId;
    private int ownedId;

    // Empty constructor
    public Notifications() {}

    // Full constructor
    public Notifications(String title, String message, String reminderType, String time, String date, int petId, int ownedId) {
        if (!reminderType.equals("Feeding") && !reminderType.equals("Appointment") && !reminderType.equals("Vaccination")) {
            throw new IllegalArgumentException("Invalid reminder type");
        }
        this.title = title;
        this.message = message;
        this.reminderType = reminderType;
        this.time = time;
        this.date = date;
        this.petId = petId;
        this.ownedId = ownedId;
    }

    // Setters and Getters
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getReminderType() {
        return reminderType;
    }

    public void setReminderType(String reminderType) {
        if (!reminderType.equals("Feeding") && !reminderType.equals("Appointment") && !reminderType.equals("Vaccination")) {
            throw new IllegalArgumentException("Invalid reminder type");
        }
        this.reminderType = reminderType;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getPetId() {
        return petId;
    }

    public void setPetId(int petId) {
        this.petId = petId;
    }

    public int getOwnedId() {
        return ownedId;
    }

    public void setOwnedId(int ownedId) {
        this.ownedId = ownedId;
    }

    @Override
    public String toString() {
        return "Notifications{" + "title=" + title + ", message=" + message + ", reminderType=" + reminderType + ", time=" + time + ", date=" + date + ", petId=" + petId + ", ownedId=" + ownedId + '}';
    }
    
}

