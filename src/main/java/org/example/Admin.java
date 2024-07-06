package org.example;

import java.util.*;

class Attraction {
    private String username;
    private String Password;
    private int Id;
    private String AttractionName;
    private String Description;
    private int TicketPrice;
    private int TicketCount;
    private int visitorCount;

    public String getAttractionName() {
        return AttractionName;
    }
    public int getVisitorCount(){
        return visitorCount;
    }
    public void setVisitorCount(int visitorCount){

        this.visitorCount += visitorCount;
    }

    public void setAttractionName(String attractionName) {
        this.AttractionName = attractionName;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        this.Description = description;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        this.Id = id;
    }

    public int getTicketPrice() {
        return TicketPrice;
    }


    public void setTicketPrice(int ticketPrice) {
        this.TicketPrice = ticketPrice;
    }

    public int getTicketCount() {
        return TicketCount;
    }

    public void setTicketCount(int ticketCount) {
        this.TicketCount = ticketCount;
    }





    //               Admin.addAttraction(AttractionName,ID,Description,TicketPrice,TicketCount);
    Attraction(String AttractionName, int id, String Description, int TicketPrice, int TicketCount, int visitorCount) {
        this.Id = id;
        this.AttractionName = AttractionName;
        this.Description = Description;
        this.TicketPrice = TicketPrice;
        this.TicketCount = TicketCount;
        this.visitorCount = visitorCount;
    }
}

public class Admin {
    private VisitorDatabase userDB;

    Admin(VisitorDatabase userDB) {
        this.userDB = userDB;
    }

    HashMap<Integer, Double> specialDeals = new HashMap<>();//for storing special deals
    HashMap<String, String> visitorEmailMap = new HashMap<>();
//    public String getFeedback(String username) {
//       // return userDB.userFeedbackMap.get(username);
//    }

    private ArrayList<Attraction> mAttractions = new ArrayList<Attraction>();//for Attraction data

    public ArrayList<Attraction> getmAttractions() {
        return mAttractions;
    }

    private HashMap<String, Integer> DC = new HashMap<>();

    public List<String> getDiscountCodeList() {
        return new ArrayList<>(DC.keySet());
    }

    public boolean CodeValid(String code) {
        //List<String> DiscountCodeList = new ArrayList<>(DC.keySet()); // Assuming you have this list

        return getDiscountCodeList().contains(code);
    }

    public int getPercentage(String code) {
        return DC.get(code);
    }

    AnimalImpl A1 = new AnimalImpl();

    public void addAttractions(String AttractionName, int Id, String Description, int TicketPrice, int TicketCount) {
        Attraction mn = new Attraction(AttractionName, Id, Description, -1, TicketCount, 0);
        mAttractions.add(mn);
    }

    public int TicketPrice(String attractionName) {
        for (Attraction attraction : mAttractions) {
            if (attraction.getAttractionName().equals(attractionName)) {
                return attraction.getTicketPrice();
            }
        }
        return -1; // Return -1 to indicate that the attraction was not found
    }

    public void AdminMenu() {
        while (true) {
            System.out.println("Admin Menu:\n" +
                    "1. Manage Attractions\n" +
                    "2. Manage Animals\n" +
                    "3. Schedule Events\n" +
                    "4. Set Discounts\n" +
                    "5. Set Special Deal\n" +
                    "6. View Visitor Stats\n" +
                    "7. View Feedback\n" +
                    "8. Exit\n");

            System.out.println("Enter choice: ");
            Scanner s3 = new Scanner(System.in);
            //s3.nextLine();
            int choiceA = s3.nextInt();
            if (choiceA == 1) {
                Manage();
                //Manage attraction;
            } else if (choiceA == 2) {
                A1.ManageAnimal();
                //manage animals
            } else if (choiceA == 3) {
                schedule();
                //schd events
            } else if (choiceA == 4) {
                discount();
                //set discount
            } else if (choiceA == 5) {
                SpecialDeals();
                //set special deal
            } else if (choiceA == 6) {
                visitorStats();
                //view visitor stats
            } else if (choiceA == 7) {
                GetFeedbacks();
                //view feedback
            } else if (choiceA == 8) {
                System.out.println("Logging You Out......");
                break;
                //Exit
            } else {
                System.out.println("Invalid Input");
            }
        }
    }

    private ArrayList<Attraction> AttractionN = new ArrayList<Attraction>();

    public void Manage() {
        while (true) {
            System.out.println("Manage Attractions:\n" +
                    "1. Add Attraction\n" +
                    "2. View Attractions\n" +
                    "3. Modify Attraction\n" +
                    "4. Remove Attraction\n" +
                    "5. Exit\n");
            System.out.println("Enter: ");
            Scanner s4 = new Scanner(System.in);
            int choiceA1 = s4.nextInt();
//            while (true) {
            if (choiceA1 == 1) {
                //
                System.out.println("Add Attraction");
                Scanner s5 = new Scanner(System.in);
                System.out.println("Enter Attraction Name :");
//                    s5.nextLine();
                String AttractionName = s5.nextLine();
                System.out.println("Enter Attraction Id: ");
                int ID = s5.nextInt();
                System.out.println("Enter Description: ");
                s5.nextLine();
                String Description = s5.nextLine();
                // ticket price check
//                System.out.println("Ticket Price");
//                int TicketPrice = s5.nextInt();
//                    System.out.println("Ticket Count");
//                    int TicketCount = s5.nextInt();

                addAttractions(AttractionName, ID, Description, -1, 0);
                System.out.println("Attraction Added Successfully");

                //                    System.out.println("Enter Attraction Name: ");

            } else if (choiceA1 == 2) {
                System.out.println("View Attractions ");
                viewAttractions();
                //
            } else if (choiceA1 == 3) {
                System.out.println("Modify Attraction");
                ModifyAttraction();
                //
            } else if (choiceA1 == 4) {
                removeAttraction();
                //System.out.println("Remove Attraction");
            } else if (choiceA1 == 5) {
                //
                System.out.println("Exit");
                break;
            } else {
                System.out.println("Invalid Input");
            }
//            }
        }
    }

//    public int trying(){
//        return 5;
//    }

    public void viewAttractions() {
        if (mAttractions.isEmpty()) {
            System.out.println("No attractions available.");
        } else {
            for (Attraction attraction : mAttractions) {
                System.out.println("Attraction Name: " + attraction.getAttractionName());
                System.out.println("ID: " + attraction.getId());
                System.out.println("Description: " + attraction.getDescription());
//                System.out.println("Ticket Price: " + attraction.getTicketPrice());
//                System.out.println("Ticket Count: " + attraction.getTicketCount());
                System.out.println();
            }
        }
    }
    public void schedule() {
        Scanner s10 = new Scanner(System.in);

        for (Attraction attraction : mAttractions) {
            String Atr = attraction.getAttractionName();
            System.out.print(Atr + " Events Open? (Yes/No): ");

            String schedule = s10.nextLine().trim().toLowerCase();

            if (schedule.equals("yes")) {
                System.out.print("Set Price for " + Atr + ": ");


                try {
                    int price = s10.nextInt();
                    attraction.setTicketPrice(price);
                    System.out.println("Price set");
                    System.out.println(Atr +"Scheduled");

                    // Increment ticket count if needed
                    // int N = attraction.getTicketCount();
                    // N = N + 1;
                    // attraction.setTicketCount(N);

                    s10.nextLine(); // Consume the newline character
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input for price. Please enter a valid number.");
                    s10.nextLine(); // Consume the newline character
                }
            } else if (schedule.equals("no")) {
                System.out.println("Tickets not available now.");
            } else {
                System.out.println("Invalid input. Please enter 'Yes' or 'No'.");
            }
        }
    }

    public void removeAttraction() {
        Scanner s6 = new Scanner(System.in);
        System.out.print("Enter Attraction to Remove: ");
        String attractionName = s6.nextLine();

        Iterator<Attraction> iterator = mAttractions.iterator();
        boolean found = false;

        while (iterator.hasNext()) {
            Attraction attraction = iterator.next();

            if (attraction.getAttractionName().equals(attractionName)) {
                iterator.remove();
                found = true;
                System.out.println("Attraction removed.");
            }
        }

        if (!found) {
            System.out.println("Attraction not found.");
        }
    }

    public void ModifyAttraction() {
        Scanner s6 = new Scanner(System.in);
        boolean found = false; // Flag to track if the attraction was found

        while (true) {
            System.out.println("Enter Id to Edit (or any other non integer key to exit): ");
            if (!s6.hasNextInt()) {
                break; // Exit the loop if a non-integer key is entered
            }
            int mid = s6.nextInt();

            for (Attraction attraction : mAttractions) {
                if (mid == attraction.getId()) {
                    System.out.println("1. Modify Name\n" +
                            "2. Modify Description\n" +
                            "3. Modify Ticket Price\n" +
                            "4. Exit\n");
                    int option = s6.nextInt();

                    if (option == 1) {
                        System.out.println("Enter New Name");
                        s6.nextLine();
                        String newName = s6.nextLine();
                        attraction.setAttractionName(newName);
                    } else if (option == 2) {
                        System.out.println("Enter new description: ");
                        s6.nextLine();
                        String newDescription = s6.nextLine();
                        attraction.setDescription(newDescription);
                    } else if (option == 3) {
                        System.out.println("Enter Ticket Price: ");
                        int newTicketPrice = s6.nextInt();
                        attraction.setTicketPrice(newTicketPrice);
                    } else {
                        break;
                    }

                    found = true; // Set the flag to indicate the attraction was found(to ensure proper working of loop)
                }
            }

            if (!found) {
                System.out.println("Attraction with ID " + mid + " not found.");
            }
        }
    }


    public void GetFeedbacks() {
        while(true) {
            //for (Map.Entry<String, String> entry : (userDB.getVisitor().userFeedbackMap.entrySet()) {
            //String username = entry.getKey();
            //String feedback = entry.getValue();
            System.out.println("Username: " + "username" + ", Feedback: " + "feedback: ");
            break;
        }
    }
    public void discount() {
        while (true) {
            Scanner s11 = new Scanner(System.in);
            System.out.println("Set Discounts:\n" +
                    "1. Add Discount\n" +
                    "2. Modify Discount\n" +
                    "3. Remove Discount\n" +
                    "4. View Discounts\n" +
                    "5. Exit\n");
            System.out.println("Enter: ");
            int DOption = s11.nextInt();

            if (DOption == 1) {
                AddDiscount();
                //add
            } else if (DOption == 2) {
                //modify
                ModifyDiscount();
            } else if (DOption == 3) {
                RemoveDiscount();
                //remove discount
            } else if (DOption==4) {
                viewDiscounts();

            } else if (DOption == 5) {
                break;
            } else {
                System.out.println("Invalid Input");
                break;
            }

        }
    }
//                View Discounts:
//                        1. Minor (10% discount) - MINOR10
//2. Senior Citizen (20% discount) - SENIOR20

//    HashMap<String, Integer> DC = new HashMap<>();

    public void AddDiscount() {
        Scanner s12 = new Scanner(System.in);
        System.out.println("Category like SENIOR,CHILD,...etc");
        System.out.println("Discount Category");
        String Category = s12.nextLine();
        System.out.println("Discount Code");
        String Code = s12.nextLine();
        System.out.println("Enter Discount Percentage");
        int DiscountPercentage = s12.nextInt();

        DC.put(Code, DiscountPercentage);
//
        System.out.println("Discount Added");
    }
    public void viewDiscounts() {
        System.out.println("Discounts:");
        for (Map.Entry<String, Integer> entry : DC.entrySet()) {
            String code = entry.getKey();
            int percentage = entry.getValue();
            System.out.println("Discount Code: " + code + ", Percentage: " + percentage + "%");
        }
    }

    List<String> DiscountCodeList = new ArrayList<>(DC.keySet());
    List<Integer> percentageList = new ArrayList<>(DC.values());
//    public List<String> getDiscountCodeList() {
//        return new ArrayList<>(DC.keySet());
//    }

    public Void ModifyDiscount() {
        Scanner s13 = new Scanner(System.in);
        System.out.println("1. Modify Discount Code\n"+
                        "2. Modify Discount %");
        System.out.println("Enter 1 or 2: ");
        int M = s13.nextInt();

        if (M == 1) {
            System.out.println("Enter Discount Code to Modify: ");
            s13.nextLine();
            String MDC = s13.nextLine();

            if (DC.containsKey(MDC)) {
                System.out.println(MDC + " is in the Discount code list.");
                System.out.println("Enter new Code: ");
                String NDC = s13.nextLine();
                int Modified = DC.get(MDC);
                DC.remove(MDC);
                DC.put(NDC, Modified);
                System.out.println("Modified");
            } else {
                System.out.println(MDC + " is not in the Discount code list.");
            }
        } else if (M == 2) {
            System.out.println("Enter Discount Code to Modify %age: ");
            s13.nextLine();
            String MDC = s13.nextLine();

            if (DC.containsKey(MDC)) {
                System.out.println(MDC + " is in the Discount code list.");
                System.out.println("Enter new %age: ");
                int NP = s13.nextInt();
                DC.put(MDC, NP);
                System.out.println("Modified");
            } else {
                System.out.println(MDC + " is not in the Discount code list.");
            }
        } else {
            System.out.println("Invalid Input");
        }
        return null;
    }



    public void RemoveDiscount() {
        Scanner s14 = new Scanner(System.in);
        System.out.println("Enter Discount Code to Remove: ");
        String MDC = s14.nextLine();

        if (DC.containsKey(MDC)) {
            System.out.println(MDC + " is in the Discount code list.");
            DC.remove(MDC);
            System.out.println("Removed");
        } else {
            System.out.println(MDC + " is not in the Discount code list.");
        }
    }

    public double applySpecialDeal(int numAttractions, double totalAmount) {
        if (specialDeals.containsKey(numAttractions)) {
            double discountPercentage = specialDeals.get(numAttractions);
            double discountAmount = totalAmount * discountPercentage;
            return totalAmount - discountAmount;

        } else {
            return totalAmount; // No special deal
        }
    }
    public void AddSpecialDeals(int numAttractions, double discountPercentage) {
        specialDeals.put(numAttractions, discountPercentage);
    }
    public void displaySpecialDeals() {
        System.out.println("Current Special Deals:");
        for (HashMap.Entry<Integer, Double> entry : specialDeals.entrySet()) {
            int numAttractions = entry.getKey();
            double discountPercentage = entry.getValue();
            System.out.println("Buy " + numAttractions + " attractions, get " + (discountPercentage * 100) + "% off.");
        }
    }
    public void visitorStats() {
        Scanner ss = new Scanner(System.in);
        while (true) {
            System.out.println("1.No. of Visitors :\n" +
                    "2.Revenue\n" +
                    "3.Popular Attraction");
            ss.nextLine();
            int Option = ss.nextInt();
            if (Option == 1) {
                System.out.println(userDB.getVisitor().size());
            } else if (Option == 2) {
                System.out.println("Total Revenue : ");
                System.out.println(userDB.getVisitor());
                //System.out.println((visitor.InitialBalance)-(visitor.Balance));
            } else if (Option == 3) {
                System.out.println("popular Attraction is ");
                break;
                //System.out.println(greatestOfTicketCount());
            } else {
                System.out.println("Invalid Input");
                break;
            }
        }
    }
    public void SpecialDeals() {//clearly defined method
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Special Deals Menu:");
            System.out.println("1. Add Special Deal");
            System.out.println("2. Display Special Deals");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int ch = scanner.nextInt();

            switch (ch) {
                case 1:
                    System.out.print("Enter the number of attractions tickets to be purchased for the special deal: ");
                    int numAttractions = scanner.nextInt();
                    System.out.print("Enter the discount percentage (e.g., 0.15 for 15%): ");
                    double discountPercentage = scanner.nextDouble();
                    AddSpecialDeals(numAttractions, discountPercentage);
                    System.out.println("Special deal added successfully.");
                    break;
                case 2:
                    displaySpecialDeals();
                    break;
                case 3:
                    System.out.println("Exiting the Special Deals Menu.");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}

//        public class MAttractions {
//
//
//
//                        }
//                    }
//                }
//            }
//        }
//


//        interface Mammals {
//            public void Fur();
//        }
//
//    interface Animal {
//        void walk();
//    }
//interface Mammals {
//    public void Fur();
//}
interface Animal {
    public void walk();

}
class AnimalImpl implements Animal {
    private String Animal;
    private String Type;
    private String Sound;
    private String Brief;

    public String getAnimalName() {
        return Animal;
    }

    public String getSound() {
        return Sound;
    }

    public String getBrief() {
        return Brief;
    }

    public void setSound(String V) {
        this.Sound = V;
    }

    public void setBrief(String B) {
        this.Type = B;
    }

    public String getType() {
        return Type;
    }

    public void setType(String newA) {
        this.Type = newA;
    }

    public void setName(String Name) {
        this.Animal = Name;
    }

    public String getAnimalSound() {
        return Sound;
    }

    public AnimalImpl(String AnimalName, String AnimalType, String Voice, String brief) {
        this.Animal = AnimalName;
        this.Type = AnimalType;
        this.Sound = Voice;
        this.Brief = brief;
    }

    //     POLYMORPHISM
    public AnimalImpl() {

    }


    public void walk() {
        System.out.println("Animal walks");
    }

    public static ArrayList<AnimalImpl> lAnimals = new ArrayList<>();
    private HashMap<String, String> animalSounds = new HashMap<>();

    public void ManageAnimal() {
        while (true) {
            System.out.println("1. Add Animal\n" +
                    "2. Update Animal Details\n" +
                    "3. Remove Animal\n" +
                    "4. Exit\n");
            Scanner s7 = new Scanner(System.in);
            int Input = s7.nextInt();
            if (Input == 1) {
                addAnimal();
                // Add animal
            } else if (Input == 2) {
                modifyAnimals();
                // Update Animal Details
            } else if (Input == 3) {
                RemoveAnimals();
                // Remove
            } else if (Input == 4) {
                break;
            } else {
                System.out.println("Invalid Input");
                break;
            }
        }
    }


    public void addAnimal() {
        Scanner s8 = new Scanner(System.in);
        System.out.println("Enter Animal Name ");
//        s8.nextLine();
        String AnimalName = s8.nextLine();
        System.out.println("Enter Animal Type: ");
//        s8.nextLine();
        String Type = s8.nextLine();
        System.out.println("Sound");
//        s8.nextLine();
        String Voice = s8.nextLine();
        System.out.println("Give Brief detail: ");
//        s8.nextLine();
        String brief = s8.nextLine();
        AnimalImpl ma = new AnimalImpl(AnimalName, Type, Voice, brief);
        animalSounds.put(AnimalName, Voice);
        lAnimals.add(ma);
        System.out.println("----Animal added to Zoo----");
    }

    public void modifyAnimals() {
        Scanner s9 = new Scanner(System.in);
        System.out.print("Enter Animal Name: ");
        String animalName = s9.nextLine().trim().toLowerCase(); // Convert to lowercase and trim

        boolean found = false;

        for (AnimalImpl A : lAnimals) {
            if (animalName.equals(A.getAnimalName().trim().toLowerCase())) { // Compare after converting to lowercase and trimming
                System.out.println("1. Modify Name");
                System.out.println("2. Modify Type");
                System.out.println("3. Modify Sound");
                System.out.println("4. Modify Brief");
                System.out.println("5. Cancel");

                int option = s9.nextInt();
                s9.nextLine(); // Consume the newline character

                if (option == 1) {
                    System.out.print("Enter New Name: ");
                    String newName = s9.nextLine();
                    A.setName(newName);
                    System.out.println("Name updated.");
                    found = true;
                } else if (option == 2) {
                    System.out.print("Enter New Type: ");
                    String newType = s9.nextLine();
                    A.setType(newType);
                    System.out.println("Type updated.");
                    found = true;
                } else if (option == 3) {
                    System.out.print("Enter New Sound: ");
                    String newSound = s9.nextLine();
                    A.setSound(newSound);
                    System.out.println("Sound updated.");
                    found = true;
                } else if (option == 4) {
                    System.out.print("Enter New Brief: ");
                    String newBrief = s9.nextLine();
                    A.setBrief(newBrief);
                    System.out.println("Brief updated.");
                    found = true;
                } else if (option == 5) {
                    break; // User canceled the modification
                }
            }
        }

        if (!found) {
            System.out.println("Animal not found in the list.");
        }
    }



    public void RemoveAnimals() {
        Scanner s10 = new Scanner(System.in);
        System.out.println("Enter Animal Name to remove: ");
        String rName = s10.nextLine();
        AnimalImpl toRemove = null;
        for (AnimalImpl A : lAnimals) {
            if (Objects.equals(rName, A.getAnimalName())) {
                toRemove = A;
                break;
            }
        }
        if (toRemove != null) {
            lAnimals.remove(toRemove);
            System.out.println("Animal removed from Zoo.");
        } else {
            System.out.println("Animal not found in Zoo.");
        }
    }
}


//        class animal {
//            String Animal;
//            String Type;
//
//            public String getAnimalName() {
//                return Animal;
//            }
//
//            public String getType() {
//                return Type;
//            }
//
//            public void setType(String newA) {
//                this.Type = newA;
//            }
//
//            public void setName(String Name) {
//                this.Animal = Name;
//            }
//
//
//            public static ArrayList<animal> lAnimals = new ArrayList<>();
//
//
//            public void ManageAnimal() {
//                System.out.println("1. Add Animal\n" +
//                        "2. Update Animal Details\n" +
//                        "3. Remove Animal\n" +
//                        "4. Exit\n");
//                while (true) {
//                    Scanner s7 = new Scanner(System.in);
//                    int Input = s7.nextInt();
//                    if (Input == 1) {
//                        addAnimal();
//                        //Add animal
//                    } else if (Input == 2) {
//                        ModifyAnimals();
//                        //Update Animal Details
//                    } else if (Input == 3) {
//                        RemoveAnimals();
//                        //remove
//                    } else if (Input == 4) {
//                        break;
//                    } else {
//                        System.out.println("Invalid Input");
//                        break;
//                    }
//
//                }
//            }
//
//            public animal(String AnimalName, String AnimalType) {
//                this.Animal = AnimalName;
//                this.Type = AnimalType;
//            }
//
//            public void addAnimal() {
//                Scanner s8 = new Scanner(System.in);
//                System.out.println("Enter Animal Name ");
//                String AnimalName = s8.nextLine();
//                System.out.println("Enter Animal Type: ");
//                String Type = s8.nextLine();
//                animal ma = new animal(AnimalName, Type);
//                lAnimals.add(ma);
//            }
//
//            public void ModifyAnimals() {
//                Scanner s9 = new Scanner(System.in);
//                while (true) {
//                    System.out.println("Enter Animal: ");
//                    String mType = s9.nextLine();
//                    for (animal A : lAnimals) {
//                        if (Objects.equals(mType, A.getType())) {
//                            System.out.println("1. Modify Name\n" +
//                                    "2. Modify Description\n"
//                            );
//                            int option = s9.nextInt();
//                            if (option == 1) {
//                                System.out.println("Enter Name");
//                                String newName = s9.nextLine();
//                                A.setName(newName);
//                            } else if (option == 2) {
//                                System.out.println("Enter new Type: ");
//                                String newType = s9.nextLine();
//                                A.setType(newType);
////                            } else if (option == 3) {
////                                System.out.println("Enter Ticket Price: ");
////                                int newticketPrice = s9.nextInt();
////                                attraction.setTicketPrice(newticketPrice);
//                            } else {
//                                break;
//                            }
//                        }
//                    }
//                }
//            }
//
//        }
//        public static void RemoveAnimals() {
//                Scanner s6 = new Scanner(System.in);
//                System.out.println("Enter Name to Remove: ");
//                int AName = s6.nextInt();
//                for (lAnimals attraction : lAnimals) {
//                    if (AName == attraction.getId()) {
//                        lAnimals attractionToremove=attraction;
//                        animal attractionToRemove = /* get the MAttractions object you want to remove */;
//                        lAnimals.remove(attractionToRemove);
////
//           Schedule Events: Admins can select when the attractions are open or closed and also
//            select the price of entry ticket necessary for the attractions. The attraction should also maintain the count of ticketed visitors.


//            Set Discounts: Admins can set discount codes on ticket prices for different visitor categories and attractions, such as minors or seniors.
//            Every minor visitor to the zoo (<18) should get a 10% discount on their tickets and membership amount.
//            Every senior citizen (>60) should get a 20% discount on their tickets and membership amount
//            Admin should be able to add or remove any of these discounts as required.

//    class Discount {
//
//    }


//            public class Deals{
//                Scanner s12 = new Scanner(System.in);
//
//           }










//                public class AttractionDatabase {
//                    private List<String> attractions;
//
//                    public AttractionDatabase() {
//                        attractions = new ArrayList<>();
//                    }
//
//                    public void addAttraction(String attraction) {
//                        attractions.add(attraction);
//                    }
//                    public Attractions

                    // You might want additional methods for managing attractions, such as retrieving, updating, or deleting them
