package view;

import controller.DataController;
import model.Book;

import java.util.ArrayList;
import java.util.Scanner;

public class View {
    public static void main(String[] args) {
        int choice = 0;
        Scanner scanner = new Scanner(System.in);
        String booksFileName = "BOOK.DAT";
        DataController controller = new DataController();

        ArrayList<Book> books;

        do {
            System.out.println(".......MENU.......");
            System.out.println("1. Thêm một đầu sách vào file.");
            System.out.println("2. Hiển thị danh sách các sách có trong file.");
            System.out.println("0. Thoát khỏi ứng dụng.");
            System.out.println("Bạn chọn");

            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 0:
                    System.out.println("--------------------------------------------------");
                    System.out.println("Cảm Ơn quý khách đã sử dụng dịch vụ của chúng tôi");
                    break;
                case 1:
                    String[] specs = {"Science", "Art", "Economic", "IT"};
                    System.out.println("Nhập tên sách: ");
                    String bookName, author, spec;
                    int year, quan, sp;
                    bookName = scanner.nextLine();

                    System.out.println("Nhập tên tác giả");
                    author = scanner.nextLine();

                    do {
                        System.out.println("Nhập thể loại sách");
                        System.out.println("1.Science \n2.Art \n3.Economic \n4.IT");
                        sp = scanner.nextInt();
                    } while (sp < 1 || sp > 4);
                    spec = specs[sp-1];

                    System.out.println("Nhập năm xuất bản: ");
                    year = scanner.nextInt();

                    System.out.println("Nhập số lượng: ");
                    quan = scanner.nextInt();

                    Book book = new Book(0,bookName, author, spec, year, quan);
                    controller.writeBookToFile(book, booksFileName);
                    break;
                    
                case 2:
                    books = controller.readBooksFromFile(booksFileName);
                    showBookInfo(books);
                    break;
            }
        }
        while (choice != 0);
    }

    private static void showBookInfo(ArrayList<Book> books) {
        System.out.println("---------Thông tin sách trong file---------");
        for (Book b: books) {
            System.out.println(b);
        }
    }
}
