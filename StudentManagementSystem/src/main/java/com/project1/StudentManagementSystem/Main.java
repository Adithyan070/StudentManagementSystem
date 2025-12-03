package com.project1.StudentManagementSystem;


import java.util.List;
import java.util.Scanner;

public class Main {
    private static final Scanner sc = new Scanner(System.in);
    private static final StudentService service = new StudentService();

    public static void main(String[] args) 
    {
        System.out.println("Welcome to Student Management System (Console)");
        while (true) 
        {
            printMenu();
            int choice = readInt("Enter option: ");
            try {
                switch (choice) {
                    case 1 -> addStudent();
                    case 2 -> viewAll();
                    case 3 -> searchStudent();
                    case 4 -> updateStudent();
                    case 5 -> deleteStudent();
                    case 6 -> 
                    {
                        System.out.println("Exiting. Goodbye!"); sc.close(); System.exit(0);
                    }
                    default -> System.out.println("Invalid option. Try again.");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
                e.printStackTrace();
            }
        }
    }

    private static void printMenu() {
        System.out.println("\n--- MENU ---");
        System.out.println("1. Add Student");
        System.out.println("2. View All Students");
        System.out.println("3. Search Student by ID");
        System.out.println("4. Update Student");
        System.out.println("5. Delete Student");
        System.out.println("6. Exit");
    }

    private static void addStudent() throws Exception {
        System.out.println("-- Add Student --");
        String name = readLine("Name: ");
        String grade = readLine("Grade: ");
        Student s = new Student(name, grade);
        service.addStudent(s);
        System.out.println("Added. Assigned ID: " + s.getId());
    }

    private static void viewAll() throws Exception {
        System.out.println("-- All Students --");
        List<Student> list = service.getAllStudents();
        if (list.isEmpty()) {
            System.out.println("No students found.");
            return;
        }
        System.out.println("ID | Name | Grade");
        for (Student s : list) {
            System.out.println(s);
        }
    }

    private static void searchStudent() throws Exception {
        System.out.println("-- Search Student --");
        int id = readInt("Enter ID: ");
        Student s = service.getStudentById(id);
        if (s == null) System.out.println("Student not found."); else System.out.println(s);
    }

    private static void updateStudent() throws Exception {
        System.out.println("-- Update Student --");
        int id = readInt("Enter ID to update: ");
        Student existing = service.getStudentById(id);
        if (existing == null) {
            System.out.println("Student not found."); return;
        }
        System.out.println("Current: " + existing);
        String name = readLine(String.format("New name (leave empty to keep '%s'): ", existing.getName()));
        String grade = readLine(String.format("New grade (leave empty to keep '%s'): ", existing.getGrade()));
        if (!name.isBlank()) existing.setName(name);
        if (!grade.isBlank()) existing.setGrade(grade);
        boolean ok = service.updateStudent(existing);
        System.out.println(ok ? "Updated successfully." : "Update failed.");
    }

    private static void deleteStudent() throws Exception {
        System.out.println("-- Delete Student --");
        int id = readInt("Enter ID to delete: ");
        boolean ok = service.deleteStudent(id);
        System.out.println(ok ? "Deleted." : "No record deleted (check ID).");
    }

    // helpers
    private static int readInt(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                String line = sc.nextLine();
                return Integer.parseInt(line.trim());
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid integer.");
            }
        }
    }

    private static String readLine(String prompt) {
        System.out.print(prompt);
        return sc.nextLine().trim();
    }
}

