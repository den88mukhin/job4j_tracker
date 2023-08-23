package ru.job4j.pojo;

public class Library {
    public static void main(String[] args) {
        Book potter = new Book("Harry Potter", 500);
        Book cleanCode = new Book("Clean code", 400);
        Book investing = new Book("Investing", 1100);
        Book math = new Book("Math", 200);
        Book[] books = new Book[4];
        books[0] = potter;
        books[1] = cleanCode;
        books[2] = investing;
        books[3] = math;
        for (int index = 0; index < books.length; index++) {
            Book book = books[index];
            System.out.println(book.getName() + " - " + book.getNumberOfPages() + " pages");
        }
        System.out.println("Change book places 0 to 3 and 3 to 0.");
        Book temp = books[0];
        books[0] = books[3];
        books[3] = temp;
        for (int index = 0; index < books.length; index++) {
            Book book = books[index];
            System.out.println(book.getName() + " - " + book.getNumberOfPages() + " pages");
        }
        System.out.println("Show only books.name == \"Clean code\"");
        for (int index = 0; index < books.length; index++) {
            Book book = books[index];
            if ("Clean code".equals(book.getName())) {
                System.out.println(book.getName() + " - " + book.getNumberOfPages() + " pages");
            }
        }
    }
}
