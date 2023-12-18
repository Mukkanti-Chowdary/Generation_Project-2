package projects.com;
import java.util.ArrayList;

public class ExploringHRSystemproject {

    // Interface for User
    public interface User {
        String getUsername();
        String getPassword();
        boolean login(String username, String password);
    }

    // Employee class implementing User
    public class Employee implements User {
        private String firstName;
        private String lastName;
        private int registration;
        private int age;
        private int daysWorked;
        private int vacationDaysTaken;
        private double salary;
        private int yearsWorked;

        // Constructor for Employee
        public Employee(String firstName, String lastName, int registration, int age, int daysWorked, int vacationDaysTaken, double salary, int yearsWorked) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.registration = registration;
            this.age = age;
            this.daysWorked = daysWorked;
            this.vacationDaysTaken = vacationDaysTaken;
            this.salary = salary;
            this.yearsWorked = yearsWorked;
        }

        // Method to calculate time to retirement
        public int timeToRetirement() {
            return Math.min(60 - age, 40 - yearsWorked);
        }

        // Method to calculate vacation time left
        public int vacationTimeLeft() {
            return (int) ((daysWorked / 360.0) * (30 - vacationDaysTaken)); // Corrected integer division to double division
        }

        // Method to calculate bonus
        public int calculateBonus() {
            return (int) (2.2 * salary);
        }

        // Interface method: get username
        @Override
        public String getUsername() {
            return firstName + lastName + registration;
        }

        // Interface method: get password (TODO: Implement secure password hashing and storage)
        @Override
        public String getPassword() {
            return "password";
        }

        // Interface method: login
        @Override
        public boolean login(String username, String password) {
            return username.equals(getUsername()) && password.equals(getPassword());
        }
    }

    // SalesRep class extending Employee
    public class SalesRep extends Employee {
        private double salesMade;

        // Constructor for SalesRep
        public SalesRep(String firstName, String lastName, int registration, int age, int daysWorked, int vacationDaysTaken, double salary, int yearsWorked, double salesMade) {
            super(firstName, lastName, registration, age, daysWorked, vacationDaysTaken, salary, yearsWorked);
            this.salesMade = salesMade;
        }

        // Method to calculate commission
        public int calculateCommission() {
            return (int) (0.1 * salesMade);
        }
    }

    // SalesManager class extending Employee
    public class SalesManager extends Employee {
        private ArrayList<SalesRep> team;

        // Constructor for SalesManager
        public SalesManager(String firstName, String lastName, int registration, int age, int daysWorked, int vacationDaysTaken, double salary, int yearsWorked) {
            super(firstName, lastName, registration, age, daysWorked, vacationDaysTaken, salary, yearsWorked);
            this.team = new ArrayList<>();
        }

        // Method to add a SalesRep to the team
        public void addToTeam(SalesRep salesRep) {
            team.add(salesRep);
        }

        // Method to calculate commission for the entire team
        public int calculateCommission() {
            int totalSales = 0;
            for (SalesRep rep : team) {
                totalSales += rep.calculateCommission();
            }
            return (int) (0.03 * totalSales);
        }
    }

    // Main class
    public static class Main {
        public static void main(String[] args) {
            ExploringHRSystemproject projectInstance = new ExploringHRSystemproject();

            // Create a SalesRep and a SalesManager
            SalesRep rep1 = projectInstance.new SalesRep("John's", "Doe", 1234, 30, 180, 10, 50000, 5, 200000);
            SalesManager manager = projectInstance.new SalesManager("Jane", "Smith", 5678, 35, 200, 5, 70000, 10);

            // Add SalesRep to the team
            manager.addToTeam(rep1);

            // Display information for SalesRep (John)
            System.out.println("John's time to retirement: " + rep1.timeToRetirement());
            System.out.println("John's vacation time left: " + rep1.vacationTimeLeft());
            System.out.println("John's bonus: " + rep1.calculateBonus());
            System.out.println("John's commission: " + rep1.calculateCommission());

            // Display information for SalesManager (Jane)
            System.out.println("Jane's time to retirement: " + manager.timeToRetirement());
            System.out.println("Jane's vacation time left: " + manager.vacationTimeLeft());
            System.out.println("Jane's bonus: " + manager.calculateBonus());
            System.out.println("Team commission: " + manager.calculateCommission());
        }
    }
}
