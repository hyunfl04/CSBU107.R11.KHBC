import java.util.ArrayList;
class Author{
    private String name;
    private String email;
    private char gender;
    public Author (String name, String email, char gender){
        this.name = name;
        this.email = email;
        this.gender = gender;
    }
    public String getName(){
        return name;
    }
    public void displayInfo(){
        System.out.println("Author Name: " + name);
        System.out.println("Author Email: " + email);
        System.out.println("Author Gender: " + gender);
    }
}
class Book{
    private String title;
    private ArrayList<Author> authors;
    private double price;
    private int qty;
    public Book(String title, double price){
        this(title, price, 0);
    }
    public Book(String title, double price, int qty){
        this.title = title;
        this.price = price;
        this.qty = qty;
        this.authors = new ArrayList<>();
    }
    public void addAuthor (Author author){
        this.authors.add(author);
    }
    public void displayInfo(){
        System.out.println("Book Title: " + title);
        System.out.println("Book Price: " + price);
        System.out.println("Book Quantity: " + qty);
        System.out.println("Authors:");
        if(authors.isEmpty()){
            System.out.println("No authors available.");
        } else {
        for(Author author : authors){
            author.displayInfo();
        }
    }

}
}
public class Exercise8{
    public static void main(String[] args){
        Author author1 = new Author("J.K. Rowling", "jk.rowling@example.com", 'F');
        Book book1 = new Book("Harry Potter", 19.99, 5);
        book1.addAuthor(author1);
        book1.displayInfo();
    }
}