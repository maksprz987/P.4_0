/*
Kod bazowy programu Commit4_0: 
• Program dodaje do prostej bazy danych (pliku db.txt) dane odnośnie Studentów.
• Studenci dodawani są w klasie Main.
• Wszyscy studenci są wypisywani na końcu klasy Main.
• Klasa Service obsługuje odczyt i zapis do pliku bazy danych.
• Klasa Student reprezentuje pojedynczego studenta (Imię, Wiek).
*/

import java.io.IOException;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            Service s = new Service();


            while (true) {
                System.out.println("\nWybierz opcję:");
                System.out.println("1 - Dodaj studenta");
                System.out.println("2 - Wyświetl wszystkich studentów");
                System.out.println("3 - Zakończ program");

                System.out.print("Twój wybór: ");
                int choice = scanner.nextInt();
                scanner.nextLine(); // Konsumowanie znaku nowej linii

                switch (choice) {
                    case 1:
                        System.out.print("Podaj imię studenta: ");
                        String name = scanner.nextLine();
                        
                        System.out.print("Podaj nazwisko studenta: ");
                        String surname = scanner.nextLine();

                        System.out.print("Podaj wiek studenta: ");
                        int age = scanner.nextInt();
                        scanner.nextLine(); // Konsumowanie znaku nowej linii

                        s.addStudent(new Student(name,surname , age));
                        System.out.println("Dodano studenta: " + name +" " +surname+ ", wiek: " + age);
                        
                        break;

                    case 2:
                        System.out.println("\nLista studentów:");
                        var students = s.getStudents();
                        for (Student current : students) {
                            System.out.println(current.ToString());
                        }
                        break;

                    case 3:
                        System.out.println("Zakończono program.");
                        scanner.close();
                        return;

                    default:
                        System.out.println("Niepoprawny wybór. Spróbuj ponownie.");
                }
            }
        } catch (IOException e) {
            System.out.println("Wystąpił błąd: " + e.getMessage());
        }
    }
}