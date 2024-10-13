package components;

public class ToDo {
    private String title, description, status, cathegory;

    public ToDo(String title, String description, String cathegory, String status) {
        this.title = title;
        this.description = description;
        this.status = status;
        this.cathegory = cathegory;
    }

    public String getTitle() {
        return title;
    }
    
    public String getDescription() {
        return description;
    }

    public String getStatus() {
        return status;
    }

    public String getCategory() {
        return cathegory;
    }

}
