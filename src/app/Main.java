package app;

import entity.concrete.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Librarian librarian = new Librarian("cagdas", "12345");

        ArrayList<Book> bookList = new ArrayList<>();
        ArrayList<Reader> readerList = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);

        boolean loginSuccess = false;
        while (!loginSuccess) {

            System.out.print("Kullanıcı adı : ");
            String username = scanner.nextLine();

            System.out.print("Şifre : ");
            String password = scanner.nextLine();

            if (librarian.getName().equals(username) && librarian.getPassword().equals(password)) {
                System.out.println("Giriş Başarılı. Hoşgeldin, " + librarian.getName());
                loginSuccess = true;
            } else {
                System.out.println("Kullanıcı adı veya şifre yanlış!");
            }
        }

        boolean running = true;
        while (running) {
            System.out.println("\n");
            System.out.println("------ KÜTÜPHANE KONSOL UYGULAMASI ------");
            System.out.println("1 - Kitap Ekle");
            System.out.println("2 - Kitapları Listele");
            System.out.println("3 - Okuyucu Ekle");
            System.out.println("4 - Okuyucuları Listele");
            System.out.println("5 - Kitap Ara");
            System.out.println("6 - Kitap Sil");
            System.out.println("7 - Kitap Kirala");
            System.out.println("8 - Kitabı Geri Bırak");
            System.out.println("9 - Kitap Bilgilerini Güncelle");
            System.out.println("10 - Yazara Ait Kitapları Listele");
            System.out.println("0 - Çıkış");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 0:
                    running = false;
                    System.out.println("Program kapatılıyor...");
                    break;

                case 1:
                    System.out.print("Yazar adı : ");
                    String author = scanner.nextLine();
                    System.out.print("Kitap adı : ");
                    String name = scanner.nextLine();
                    System.out.print("Kitap fiyatı : ");
                    double price = scanner.nextDouble();
                    scanner.nextLine();
                    System.out.print("Baskı bilgisi : ");
                    String edition = scanner.nextLine();

                    boolean exists = false;

                    for (Book book : bookList) {
                        if (book.getName().equals(name)) {
                            exists = true;
                            break;
                        }
                    }

                    if (exists) {
                        System.out.println("Bu kitap sistemde zaten kayıtlı.");
                    } else {
                        bookList.add(new Book(new Author(author), name, price, edition, LocalDate.now()));
                        System.out.println("Kitap sisteme eklenmiştir.");
                    }

                    break;

                case 2:
                    if (bookList.isEmpty()) {
                        System.out.println("Kütüphane boş.");
                    } else {
                        System.out.println("Kitap Listesi : ");
                        for (Book book : bookList) {
                            book.display();
                        }
                    }
                    break;

                case 3:
                    System.out.print("Eklenecek Okuyucu Ismi : ");
                    String readerName = scanner.nextLine();

                    System.out.print("Okuyucu Adres Bilgisi : ");
                    String readerAddress = scanner.nextLine();

                    System.out.print("Okuyucu Telefon Numarası : ");
                    String readerPhone = scanner.nextLine();

                    boolean readerExists = false;
                    for (Reader reader : readerList) {
                        if (reader.getName().equals(readerName)) {
                            readerExists = true;
                            break;
                        }
                    }

                    if (readerExists) {
                        System.out.println("Bu okuyucu sistemde zaten kayıtlı.");
                    } else {
                        readerList.add(new Reader(readerName, new MemberRecord("Student", LocalDate.now(), readerName, readerAddress, readerPhone)));
                        System.out.println("Okuyucu kütüphane sistemine eklenmiştir.");
                    }
                    break;

                case 4:
                    if (readerList.isEmpty()) {
                        System.out.println("Liste boş.");
                    } else {
                        System.out.println("Okuyucu Listesi : ");
                        for (Reader reader : readerList) {
                            reader.display();
                        }
                    }
                    break;

                case 5:
                    System.out.print("Kitap ismi : ");
                    String searchBook = scanner.nextLine();

                    boolean srcBook = false;
                    for (Book book : bookList) {
                        if (book.getName().contains(searchBook)) {
                            book.display();
                            srcBook = true;
                            break;
                        }
                    }

                    if (!srcBook) {
                        System.out.println("Kitap bulunamadı.");
                    }

                    break;

                case 6:
                    System.out.print("Silinecek kitap adı : ");
                    String deleteName = scanner.nextLine();

                    Book dltBook = null;

                    for (Book book : bookList) {
                        if (book.getName().contains(deleteName)) {
                            dltBook = book;
                            break;
                        }
                    }

                    if (dltBook != null) {
                        bookList.remove(dltBook);
                        System.out.println("Kitap sistemden silinmiştir.");
                    } else {
                        System.out.println("Kitap bulunamadı.");
                    }

                    break;

                case 7:
                    System.out.print("Okuyucu adı : ");
                    String rentReaderName = scanner.nextLine();

                    System.out.print("Kiralanacak kitap adı : ");
                    String rentBookName = scanner.nextLine();

                    Reader foundReader = null;
                    Book foundBook = null;

                    for (Reader reader : readerList) {
                        if (reader.getName().contains(rentReaderName)) {
                            foundReader = reader;
                            break;
                        }
                    }

                    for (Book book : bookList) {
                        if (book.getName().contains(rentBookName)) {
                            foundBook = book;
                            break;
                        }
                    }

                    if (foundReader == null) {
                        System.out.println("Okuyucu bulunamadı.");
                    } else if (foundBook == null) {
                        System.out.println("Kitap bulunamadı.");
                    } else if (foundBook.getReader() != null) {
                        System.out.println("Bu kitap başka bir okuyucuda olduğu için kiralayamazsınız.");
                    } else {
                        foundReader.borrowBook(foundBook);
                    }

                    break;

                case 8:
                    System.out.print("Okuyucu adı : ");
                    String returnReaderName = scanner.nextLine();

                    System.out.print("Geri bırakılacak kitap adı : ");
                    String returnBookName = scanner.nextLine();

                    Reader returnReader = null;
                    Book returnBook = null;

                    for (Reader reader : readerList) {
                        if (reader.getName().contains(returnReaderName)) {
                            returnReader = reader;
                            break;
                        }
                    }

                    for (Book book : bookList) {
                        if (book.getName().contains(returnBookName)) {
                            returnBook = book;
                            break;
                        }
                    }

                    if (returnReader == null) {
                        System.out.println("Okuyucu bulunamadı.");
                    } else if (returnBook == null) {
                        System.out.println("Kitap bulunamadı.");
                    } else {
                        returnReader.returnBook(returnBook);
                    }

                    break;

                case 9:
                    System.out.print("Güncellenecek kitap adı : ");
                    String updateBookName = scanner.nextLine();

                    Book updateBook = null;

                    for (Book book : bookList) {
                        if (book.getName().contains(updateBookName)) {
                            updateBook = book;
                            break;
                        }
                    }

                    if (updateBook == null) {
                        System.out.println("Kitap bulunamadı.");
                    } else {

                        System.out.print("Yeni kitap adı : ");
                        String newName = scanner.nextLine();

                        System.out.print("Yeni yazar adı : ");
                        String newAuthor = scanner.nextLine();

                        System.out.print("Yeni fiyat : ");
                        double newPrice = scanner.nextDouble();
                        scanner.nextLine();

                        System.out.print("Yeni baskı bilgisi : ");
                        String newEdition = scanner.nextLine();

                        updateBook.setName(newName);
                        updateBook.setAuthor(new Author(newAuthor));
                        updateBook.setPrice(newPrice);
                        updateBook.setEdition(newEdition);

                        System.out.println("Kitap bilgileri güncellenmiştir.");
                    }

                    break;

                case 10:
                    System.out.print("Yazar adı : ");
                    String authorName = scanner.nextLine();

                    boolean authorBookFound = false;

                    System.out.println("Kitap Listesi : ");
                    for (Book book : bookList) {
                        if (book.getAuthor().getName().contains(authorName)) {
                            book.display();
                            authorBookFound = true;
                        }
                    }

                    if (!authorBookFound) {
                        System.out.println("Bu yazara ait kitap bulunamadı.");
                    }

                    break;
            }
        }
    }
}