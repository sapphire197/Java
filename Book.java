public class Book {
    private int id;
    private String title;
    private String author;
    private String genre;
    private int publicationYear;
    private boolean isBorrowed;

    // Constructor, getters, and setters
    public Book(String title, String author, String genre, int publicationYear) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.publicationYear = publicationYear;
        this.isBorrowed = false;
    }

    // Getters and Setters
}
