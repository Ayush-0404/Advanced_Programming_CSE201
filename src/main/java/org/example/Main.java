package org.example;

import java.util.*;


// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    VisitorDatabase userDB = new VisitorDatabase();
    Admin admin;

    Main() {
        admin = new Admin(userDB);
    }



    void RegisterV() {
        System.out.println("Name: ");
        Scanner s = new Scanner(System.in);
        String name = s.nextLine();

        System.out.println("Age: ");
        int age = s.nextInt();

        System.out.println("Phone number : ");
        int phoneNumber = s.nextInt();

        System.out.println("Balance : ");
        int balance = s.nextInt();

        System.out.println("Email : ");
        s.nextLine(); // Consume the newline character left in the buffer
        String email = s.nextLine();

        System.out.println("Password: ");
        String password = s.nextLine();

//        System.out.println("Initial Balance: ");
//        String IBalance = s.nextLine();
        Visitor v1 = new Visitor(password, name, phoneNumber, email, age, balance, admin,0,0,balance);
        userDB.addVisitor(v1);
        System.out.println("---Registered Successfully---");

    }

    Visitor LoginV() {
        Scanner s1 = new Scanner(System.in);
        System.out.println("Enter Email: \n");
        //s1.nextLine();
        String Email = s1.nextLine();

        System.out.println("Enter Password: ");
        //s1.nextLine();
        String Psw = s1.nextLine();
        return userDB.getVisitor(Email);

    }

    public static void main(String[] args) {
        Main zoo = new Main();
        zoo.start();
    }
    //  Visitor V = new Visitor();
//        Admin AA;

    ///Admin A =new Admin();
    // Press Alt+Enter with your caret at the highlighted text to see how
    // IntelliJ IDEA suggests fixing it.
    void start() {
        boolean a = true;
        while (a) {
            System.out.println("welcome to Zoo");
            System.out.println("1.Enter as Admin\n");
            System.out.println("2.Enter as Visitor\n");
//        System.out.println("3.Enter View Special Deals");
            Scanner scanner = new Scanner(System.in);

            System.out.print("Enter : ");
            int choice = scanner.nextInt();
            scanner.nextLine();  //consume new line character


            if (choice == 1) {
                System.out.println("Enter username:");
                String username = scanner.nextLine();
                System.out.println("Enter Password: ");
                String passw = scanner.nextLine();
                RegisterAdmin(username, passw);

                // RegisterAdmin();
            } else if (choice == 2) {

                System.out.println("1. Login");
                System.out.println("2. Register");
                int cv = scanner.nextInt();

                if (cv == 1) {
                    System.out.println("Enter your email: ");
                    String email = scanner.next();
                    System.out.println("Enter your password: ");
                    String password = scanner.next();

                    Visitor visitor = userDB.getVisitor(email);

                    if (visitor == null) {
                        System.out.println("Invalid email");
                    } else if (visitor.getPassword().equals(password)) {
                        System.out.println("------Welcome ------");
                        visitor.visitorMenu();
                    } else {
                        System.out.println("Invalid password");
                    }
                    //LOgin
                } else if (cv == 2) {
                    RegisterV();
                    //Register
                } else {
                    System.out.println("Invalid Input");
                    break;

                }
            } else {
                System.out.println("Invalid Input");
                break;
            }
        }
    }

    public void RegisterAdmin(String username, String passw) {
        if (username.equals("abc") && passw.equals("abc1")) {
            System.out.println("Logged in as Admin" +
                    "Welcome Admin");
            admin.AdminMenu();

        } else {
            System.out.println("Incorrect Credentials");
        }
    }
}