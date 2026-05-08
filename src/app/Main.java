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
        ArrayList<Library> library = new ArrayList<>();
        ArrayList<Author> authors = new ArrayList<>();
        ArrayList<MemberRecord> memberRecords = new ArrayList<>();

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
            }
        }
    }
}