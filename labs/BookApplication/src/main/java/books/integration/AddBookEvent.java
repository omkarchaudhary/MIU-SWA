package books.integration;

public class AddBookEvent {
    private String message;

    public AddBookEvent(String message) {
        this.message = message;
    }

    public String getMessage(){
        return message;
    }
}
