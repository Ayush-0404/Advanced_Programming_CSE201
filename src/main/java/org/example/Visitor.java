package org.example;
import java.sql.SQLOutput;
import java.util.*;

public class Visitor {

    Scanner s1 = new Scanner(System.in);
    AnimalImpl A = new AnimalImpl();
    Attraction A1;
    private int InitialBalance;

    private String Name;
    private int Age;
    private double Balance;
    private int PhoneNumber;
    private String Email;
    private String Password;
    private int memStatus;
    private int w;
    private int TicketCounts;
    private int TicketNumbers;
    Admin admin;

    public int getInitialBalance() {
        return memStatus;
    }

    public void SetInitialBalance(int IBalance) {
        this.InitialBalance = IBalance;
    }

    public int getStatus() {
        return memStatus;
    }

    public void SetMemStatus(int memStatus) {
        this.memStatus = memStatus;
    }

    public int getTicketCounts() {
        return TicketCounts;
    }

    public void setTicketCounts(int TicketCounts) {
        this.TicketCounts = getTicketCounts() + TicketCounts;
    }

    public String getUsername() {
        return Name;
    }

    public String getPassword() {
        return Password;
    }

    public double getBalance() {
        return Balance;
    }

    public void setBalance(double Balance) {
        this.Balance = Balance;
    }

    public int getPhoneNumber() {
        return PhoneNumber;
    }

    public int getAge() {
        return Age;
    }

    public String getEmail() {
        return Email;
    }

    private Map<String, String> userFeedbackMap = new HashMap<>();

    public Map<String, String> getUserFeedbackMap() {
        return userFeedbackMap;
    }

    // Add more deals as needed
    HashMap<String, Integer> attractionTicketMap = new HashMap<>();

    public int TicketN(String AN) {  //for getting no. of tickets by attraction Name
        if (attractionTicketMap.containsKey(AN)) {
            int ticketNumber = attractionTicketMap.get(AN);
            System.out.println("Tickets number for " + AN + ": " + ticketNumber);
            return ticketNumber;
        } else {
            System.out.println("Attraction not found.");
            return -1;
        }
    }
//NOTE---
    //If you need to be more precise I have also created following method which is user to creat a map which will store no.
    //against the email id of the visitor (to make authentication more simple during attraction visit),it can be used by uncommenting
    //and passing the required arguments to implement authentication through it.

    //public void associateEmailWithTicket(String email, String attractionName) {
    //        int ticketNumber = getTicketNumber(attractionName);
    //        if (ticketNumber != -1) {
    //            visitorEmailMap.put(email, attractionName);
    //        } else {
    //            System.out.println("Attraction not found.");
    //        }
    //    }

//    public List<String> getEmailsAndTickets() {
//        List<String> emailTicketList = new ArrayList<>();
//        for (Map.Entry<String, String> entry : admin.visitorEmailMap.entrySet()) {
//            String email = entry.getKey();
//            String attractionName = entry.getValue();
//            int ticketNumber = TicketN(attractionName);
//            emailTicketList.add("Email: " + email + ", Tickets: " + ticketNumber);
//        }
//        return emailTicketList;
//    }


    public Visitor(String Password, String Name, int PhoneNumber, String Email, int Age, double Balance, Admin adminM, int Status, int TicketCounts, int InitialBalance) {
        this.Password = Password;
        this.Name = Name;
        this.PhoneNumber = PhoneNumber;
        this.Email = Email;
        this.Age = Age;
        this.Balance = Balance;
        this.admin = adminM;
        this.memStatus = Status;
        this.TicketCounts = TicketCounts;
        this.InitialBalance = InitialBalance;
    }

    //----POLYMORPHISM--
    public Visitor(int TicketNumbers) {
        this.TicketNumbers = TicketNumbers;
    }


    public void visitorMenu() {
        while (true) {
            System.out.println("1. Explore the Zoo\n" +
                    "2. Buy Membership\n" +
                    "3. Buy Tickets\n" +
                    "4. View Discounts\n" +
                    "5. View Special Deals\n" +
                    "6. Visit Animals\n" +
                    "7. Visit Attractions\n" +
                    "8. Leave Feedback\n" +
                    "9. Log Out\n");
            System.out.println("Enter Choice: ");
            int choiceV = s1.nextInt();

            if (choiceV == 1) {
                Explore();
//                System.out.print(admin.trying());
                //for Explore the Zoo
            } else if (choiceV == 2) {
                BuyMembership();
                //for Buy Membership
            } else if (choiceV == 3) {
                BuyTickets();
                //for Buy Tickets
            } else if (choiceV == 4) {
                admin.viewDiscounts();
                //for View Discounts
            } else if (choiceV == 5) {
                admin.displaySpecialDeals();
                //for View Special Deals
            } else if (choiceV == 6) {
                visitAnimal();
                //for  Visit Animals
            } else if (choiceV == 7) {
                visitAttraction();
                // for Visit Attractions
            } else if (choiceV == 8) {
                addfeedback(getUsername()); // Assuming this is correct
                // for Leave Feedback
            } else if (choiceV == 9) {
                break;
                //  for Log Out
            } else {
                System.out.println("Invalid Input");
            }
        }
    }

    public void Explore() {


        System.out.println("Explore the Zoo:\n" +
                "1. View Attractions\n" +
                "2. View Animals\n" +
                "3. Exit\n");
        while (true) {
            System.out.println("Enter Choice: ");
            s1.nextLine();
            int EOption = s1.nextInt();
            if (EOption == 1) {
                System.out.println("Attractions are: ");
                for (Attraction attraction : admin.getmAttractions()) {
                    System.out.println("Attraction Name: " + attraction.getAttractionName());
                }
            } else if (EOption == 2) {
                System.out.println("Animals Are: ");
                for (AnimalImpl animals : AnimalImpl.lAnimals) {
                    //Explore the Zoo;
                    System.out.println(animals.getAnimalName());
                }
            } else if (EOption == 3) {
                System.out.println("Exiting..");
                break;
            }
        }
    }

    public void viewDiscounts() {
        for (String code : admin.DiscountCodeList) {
            System.out.println("Discount Code: " + code);
            System.out.println("OR NONE");
        }
    }

    public void visitAnimal() {
        if (memStatus == 1 || memStatus == 2) {
            System.out.println("You have Membership, go Ahead!");
            System.out.println("Animals in the Zoo:");
            for (Animal animal : A.lAnimals) {
                System.out.println("Name: " + A.getAnimalName());
                System.out.println("Choose Animal to Visit:");
                Scanner s11 = new Scanner(System.in);
                s11.nextLine();
                String AChosen = s11.nextLine();
                boolean found = false;
                for (AnimalImpl a : A.lAnimals) {
                    if (a.getAnimalName().equalsIgnoreCase(AChosen)) {
                        System.out.println("Animal Name: " + a.getAnimalName());

                        System.out.println("1. Feed\n"
                                + "2.Brief Detail");
                        int CO = s11.nextInt();
                        if (CO == 1) {
                            A.getAnimalSound();
                        } else if (CO == 2) {
                            A.getBrief();
                        }
                        found = true;

                        break;
                    }
                }
                if (!found) {
                    System.out.println("Animal not found in the zoo.");
                }

            }
        } else {
            System.out.println("Buy Membership First");
        }
    }

    //    public void displaySpecialDeals() {
//        System.out.println("Current Special Deals:");
//        for (HashMap.Entry<Integer, Double> entry : admin.specialDeals.entrySet()) {
//            int numAttractions = entry.getKey();
//            double discountPercentage = entry.getValue();
//            System.out.println("Buy " + numAttractions + " attractions, get " + (discountPercentage * 100) + "% off.");
//        }
//    }
    public void BuyMembership() {
        Scanner s13 = new Scanner(System.in);
        System.out.println("Buy Membership:\n" +
                "1. Basic Membership for Rs. 20\n" +
                "2. Premium Membership for Rs. 50\n" +
                "3. Exit");

        int C = s13.nextInt();
        s13.nextLine(); // Consume the newline character after reading C

        if (C == 1) {
            System.out.println("Basic Chosen");
            admin.viewDiscounts();
            // Consume the newline character
            s13.nextLine();
            System.out.println("Enter Discount Code to apply (Enter 'NONE' if no discount shown earlier):");
            String ADC = s13.nextLine();

            // Rest of your Basic Membership code remains the same...
        } else if (C == 2) {
            System.out.println("Premium Choosen");

            for (String code : admin.DiscountCodeList) {
                System.out.println("Discount Code: " + code);
                System.out.println("OR NONE");
            }

            // Consume the newline character
            s13.nextLine();

            while (true) {
                System.out.println("Enter Discount Code to apply:");
                String ADC = s13.nextLine();

                // Rest of your Premium Membership code remains the same...
            }
        } else {
            System.out.println("Wrong Input");
        }
    }

    public void addfeedback(String Username) {
        System.out.println("please Give Your Valuable Feedback");
        Scanner S12 = new Scanner(System.in);
        String Feedback = S12.nextLine();
        userFeedbackMap.put(Username, Feedback);
    }

    public void BuyTickets() {
        //checking membership
        if (memStatus == 1 || memStatus == 2) {
            System.out.println("You have Membership, go Ahead!");
            System.out.println("Attractions are: ");
            for (Attraction attraction : admin.getmAttractions()) {
                int Check = attraction.getTicketPrice();
                if (Check >= 0) {
                    System.out.println("Attraction Name: " + attraction.getAttractionName());
                }
            }
            System.out.println("Enter Attraction to visit: ");//Attraction entered by the user is from the provided list only.
            s1.nextLine();
            String Attrac = s1.nextLine();
            int TPP = admin.TicketPrice(Attrac);
            System.out.println("Ticket Price is :" + TPP);
            System.out.println("Enter No. of tickets to buy: ");
            int TN = s1.nextInt();

            if (TN == 1) {
                System.out.println("No Special Deals Available");

                for (String code : admin.DiscountCodeList) {
                    System.out.println("Discount Code: " + code);
                    System.out.println("OR NONE");
                }
                while (true) {
                    System.out.println("Enter Discount Code to apply:");
                    s1.nextLine();
                    String ADC = s1.nextLine();

                    if (admin.CodeValid(ADC)) {
                        double P = admin.getPercentage(ADC);

                        double MinReq = (TPP * TN) - ((TPP * TN) * (P / 100));
                        if (getBalance() > MinReq) {
                            if (attractionTicketMap.containsKey(Attrac)) {
                                System.out.println(Attrac + " is in the attractionNames.");

                            } else {
                                System.out.println(Attrac + " is not in the attractionNames.");
                            }
                            double nBalance = (getBalance() - (TPP * (P / 100)));
                            setBalance(nBalance);
                            setTicketCounts(TN);//no. of tickets for attraction
                            if (attractionTicketMap.isEmpty()) {// for calculating total no. of Tickets (if some already purchased before)
                                // System.out.println("attractionTicketMap is empty.");
                                w = 0;
                            } else {
                                w = TicketN(Attrac);//using TicketN method to get no. of tickets for Attraction chosen(Attrac here)

                                // System.out.println("attractionTicketMap is not empty.");
                            }
                            int NTN = w + TN;    //updating ticket count

                            attractionTicketMap.put(Attrac, NTN);
                            System.out.println("Tickets Purchased successfully....Enjoy!");
                            System.out.println("Remaining Balance: " + getBalance());
                            if (attractionTicketMap.containsKey(Attrac)) {
                                //double ticketPrice = attractionTicketMap.get(Attrac);
                                System.out.println("Visitor with email " + getEmail() + " has purchased a ticket for " + Attrac);
                                admin.visitorEmailMap.put(Attrac, getEmail());
                            }
                        } else {
                            System.out.println("Insufficient Balance");
                            break;
                        }
                    } else if (Objects.equals(ADC, "NONE")) {
                        if (getBalance() > TPP) {
                            double nBalance = (getBalance() - TPP);
                            setBalance(nBalance);
                            if (attractionTicketMap.isEmpty()) {
                                // System.out.println("attractionTicketMap is empty.");
                                w = 0;
                            } else {
                                w = TicketN(Attrac);

                                // System.out.println("attractionTicketMap is not empty.");
                            }
                            int NTN = w + TN;
                            attractionTicketMap.put(Attrac, NTN);//Hashmap updated crated for storing Attraction & their total Tickets purchased
//                            attractionTicketMap.put(Attrac, TN);
                            System.out.println("Tickets Purchased successfully....Enjoy!");
                            System.out.println("Remaining Balance: " + getBalance());
                            if (attractionTicketMap.containsKey(Attrac)) {       //now checked in the hashmap and printed the email of visitor who purchsed ticket
                                //double ticketPrice = attractionTicketMap.get(Attrac);
                                System.out.println("Visitor with email " + getEmail() + " has purchased a ticket for " + Attrac);
                                admin.visitorEmailMap.put(Attrac, getEmail());
                            }
                        } else {
                            System.out.println("Insufficient Balance");
                        }
                    } else {
                        System.out.println("Wrong CODE");
                        break;
                    }
                }
            } else {
                System.out.println("Deals Available");
                double nBalance = admin.applySpecialDeal(TN, getBalance());//used the applyspecialdeal method to apply deal by just passing the no. of tickets (for getting the deal) and balance to update it

                if (getBalance() > nBalance) {
                    System.out.println("sufficient balance: ");     //similar to prvious one
                    setBalance(nBalance);
                    if (attractionTicketMap.isEmpty()) {
                        // System.out.println("attractionTicketMap is empty.");
                        w = 0;
                    } else {
                        w = TicketN(Attrac);
                        // System.out.println("attractionTicketMap is not empty.");
                    }
                    int NTN = w + TN;
                    attractionTicketMap.put(Attrac, NTN);
                    System.out.println("Remaining balance is: " + nBalance);
                    if (attractionTicketMap.containsKey(Attrac)) {
                        //double ticketPrice = attractionTicketMap.get(Attrac);
                        System.out.println("Visitor with email " + getEmail() + " has purchased a ticket for " + Attrac);
                        admin.visitorEmailMap.put(Attrac, getEmail());
                    }

                } else {
                    System.out.println("Insufficient Balance");
                }

            }
        } else {
            System.out.println("Buy Membership First");
        }
        //System.out.println("Wrong Input ");
    }


    //    Visit Attractions/Visit Event: Visitors can access attractions based on their experience level and the ticket bought
//    to enjoy unique experiences. A simple “Welcome to the attraction X” statement is enough to be counted as a visit
//    to the attraction.
    public void visitAttraction() {
        if (memStatus == 1 || memStatus == 2) {
            System.out.println("You have Membership, go Ahead!");
            System.out.println("Attractions are: ");
            for (Attraction attraction : admin.getmAttractions()) {
                System.out.println("Attraction Name: " + attraction.getAttractionName());
            }
            System.out.println("Enter Attraction to Visit :");
            String AT = s1.nextLine();
            //System.out.println("Enter Email Id :");
            //String E = s1.nextLine();
            if (attractionTicketMap.containsKey(AT)) {
                //double ticketPrice = attractionTicketMap.get(AT);
                System.out.println("Visitor with email " + getEmail() + " has purchased a ticket for " + AT);
                if (TicketN(AT) > 0) {
                    attractionTicketMap.put(AT, (TicketN(AT) - 1));
                    System.out.println("Welcome to Attraction " + AT);
                    A1.setVisitorCount(1);
                }
            }
        } else {
            System.out.println("Buy Membership First");
        }
    }
}





//            public Integer getPercentageByCode(String code) {
//                if (DC.containsKey(code)) {
//                    return DC.get(code);
//                } else {
//                    return null; // Code not found



//    public Visitor(String login, String register) {
//        this.login = login;
//        this.register = register;
//    }

//    public void welcome() {
//        System.out.println("1.Login\n");
//        System.out.println("2.Register");
//        Scanner s1 = new Scanner(System.in);
//        int o1 = s1.nextInt();
//        if (o1==1) {
//            Visitor.RegisterV();
//        } else if (o1==2){
//            V.Login



        // Implement the login logic here


