import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;

public class BookInventoryApp {
    private JFrame frame;
    private JTextField titleField, authorField, genreField, yearField;
    private JTextArea bookListArea;
    private BookDAO bookDAO;

    public BookInventoryApp() {
        bookDAO = new BookDAO();
        initComponents();
    }

    private void initComponents() {
        frame = new JFrame("Book Inventory System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 500);

        JPanel panel = new JPanel(new GridLayout(6, 2));

        panel.add(new JLabel("Title:"));
        titleField = new JTextField();
        panel.add(titleField);

        panel.add(new JLabel("Author:"));
        authorField = new JTextField();
        panel.add(authorField);

        panel.add(new JLabel("Genre:"));
        genreField = new JTextField();
        panel.add(genreField);

        panel.add(new JLabel("Publication Year:"));
        yearField = new JTextField();
        panel.add(yearField);

        JButton addButton = new JButton("Add Book");
        addButton.addActionListener(new AddBookListener());
        panel.add(addButton);

        JButton viewButton = new JButton("View All Books");
        viewButton.addActionListener(new ViewBooksListener());
        panel.add(viewButton);

        bookListArea = new JTextArea();
        bookListArea.setEditable(false);

        frame.getContentPane().add(BorderLayout.NORTH, panel);
        frame.getContentPane().add(BorderLayout.CENTER, new JScrollPane(bookListArea));

        frame.setVisible(true);
    }

    private class AddBookListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String title = titleField.getText();
            String author = authorField.getText();
            String genre = genreField.getText();
            int year = Integer.parseInt(yearField.getText());
            Book book = new Book(title, author, genre, year);

            try {
                bookDAO.addBook(book);
                JOptionPane.showMessageDialog(frame, "Book added successfully!");
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    private class ViewBooksListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try {
                List<Book> books = bookDAO.getAllBooks();
                bookListArea.setText("");
                for (Book book : books) {
                    bookListArea.append(book.getTitle() + " by " + book.getAuthor() + "\n");
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new BookInventoryApp();
    }
}
