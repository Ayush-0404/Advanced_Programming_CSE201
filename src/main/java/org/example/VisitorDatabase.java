package org.example;

import java.util.ArrayList;
import java.util.List;

public class VisitorDatabase {
    private List<Visitor> visitors;

    public VisitorDatabase() {
        visitors = new ArrayList<>();
    }

    public List <Visitor> getVisitor(){
        return visitors;
    }

    public void addVisitor(Visitor visitor) {
        visitors.add(visitor);
    }

    public Visitor getVisitor(String email) {
        for (Visitor visitor : visitors) {
            if (visitor.getEmail().equals(email)) {
                return visitor;
            }
        }
        return null; // Visitor not found
    }

    public Visitor getPsw(String password) {
        for (Visitor visitor : visitors) {
            if (visitor.getPassword().equals(password)) {
                System.out.println("------Welcome------");
                return visitor;
            } else {
                System.out.println("Invalid password");
            }
        }
        return null;
    }
}
