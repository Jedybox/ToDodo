package components;

public class ToDo {
    private String title, description, date, status, cathegory;

    public ToDo(String title, String description, String date, String status, String cathegory) {
        this.title = title;
        this.description = description;
        this.date = date;
        this.status = status;
        this.cathegory = cathegory;
    }

    public String getTitle() {
        return title;
    }
    
    public String getDescription() {
        return description;
    }

    public String getDate() {
        return date;
    }

    public String getStatus() {
        return status;
    }

    public String getCathegory() {
        return cathegory;
    }

}
