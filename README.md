# Generation_Project-2
# Exploring HR System Project

## Overview
This project explores a Human Resources Management System with Java classes for employees, sales representatives, and sales managers.

## Classes

### 1. User Interface
- **User Interface:** `User`
  - Methods:
    - `getUsername()`: Returns the username.
    - `getPassword()`: Returns the password (Note: This needs to be enhanced for secure password storage).
    - `login(String username, String password)`: Checks if the provided username and password match.

### 2. Employee Classes
- **Employee Class:** `Employee` (Implements `User`)
  - Fields:
    - `firstName`, `lastName`, `registration`, `age`, `daysWorked`, `vacationDaysTaken`, `salary`, `yearsWorked`
  - Methods:
    - `timeToRetirement()`
    - `vacationTimeLeft()`
    - `calculateBonus()`

- **SalesRep Class:** `SalesRep` (Extends `Employee`)
  - Additional Field:
    - `salesMade`
  - Additional Method:
    - `calculateCommission()`

- **SalesManager Class:** `SalesManager` (Extends `Employee`)
  - Additional Field:
    - `team` (List of `SalesRep` objects)
  - Additional Methods:
    - `addToTeam(SalesRep salesRep)`: Adds a `SalesRep` to the team.
    - `calculateCommission()`: Calculates the commission for the entire team.

### 3. Main Class
- **Main Class:** `Main`
  - Creates instances of `SalesRep` and `SalesManager`.
  - Demonstrates the functionality of the classes.

## How to Run
1. Ensure you have Java installed on your system.
2. Compile and run the `Main` class.

```bash
javac ExploringHRSystemproject.java
java ExploringHRSystemproject$Main
