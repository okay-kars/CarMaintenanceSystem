package main;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.mm.yyyy");

        System.out.print("Geben Sie die Automarke ein: ");
        String make = scanner.nextLine();

        System.out.print("Geben Sie das Automodell ein: ");
        String model = scanner.nextLine();

        System.out.print("Geben Sie das Baujahr ein: ");
        int year = scanner.nextInt();

        System.out.print("Geben Sie den Kilometerstand ein: ");
        int mileage = scanner.nextInt();
        scanner.nextLine();

        Car car = new Car(make, model, year, mileage);
        MaintenanceHistory maintenanceHistory = new MaintenanceHistory();
        ServiceReminder serviceReminder = new ServiceReminder(car);

        while (true) {
            System.out.println("\n--- Fahrzeugwartungs- und Servicemanagementsystem ---");
            System.out.println("1. Wartung hinzufügen");
            System.out.println("2. Wartungshistorie anzeigen");
            System.out.println("3. Wartungserinnerung planen");
            System.out.println("4. Kilometerstand aktualisieren");
            System.out.println("5. Beenden");
            System.out.print("Wählen Sie eine Option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Puffer leeren

            switch (choice) {
                case 1:
                    System.out.print("Geben Sie die Wartungsbeschreibung ein: ");
                    String description = scanner.nextLine();

                    System.out.print("Geben Sie das Wartungsdatum ein (dd.MM.yyyy): ");
                    String dateString = scanner.nextLine();
                    Date date = null;
                    try {
                        date = dateFormat.parse(dateString);
                    } catch (ParseException e) {
                        System.out.println("Ungültiges Datum.");
                        break;
                    }

                    System.out.print("Geben Sie den Kilometerstand bei der Wartung ein: ");
                    int maintenanceMileage = scanner.nextInt();
                    scanner.nextLine(); // Puffer leeren

                    Maintenance maintenance = new Maintenance(description, date, maintenanceMileage);
                    maintenanceHistory.addMaintenance(maintenance);
                    System.out.println("Wartung hinzugefügt.");
                    break;

                case 2:
                    System.out.println("Wartungshistorie:");
                    System.out.println(maintenanceHistory);
                    break;

                case 3:
                    System.out.print("Geben Sie das Erinnerungsdatum ein (dd.MM.yyyy): ");
                    String reminderDateString = scanner.nextLine();
                    Date reminderDate = null;
                    try {
                        reminderDate = dateFormat.parse(reminderDateString);
                    } catch (ParseException e) {
                        System.out.println("Ungültiges Datum.");
                        break;
                    }

                    System.out.print("Geben Sie die Erinnerungsnachricht ein: ");
                    String reminderMessage = scanner.nextLine();

                    serviceReminder.scheduleReminder(reminderDate, reminderMessage);
                    System.out.println("Erinnerung geplant.");
                    break;

                case 4:
                    System.out.print("Geben Sie den neuen Kilometerstand ein: ");
                    int newMileage = scanner.nextInt();
                    scanner.nextLine(); // Puffer leeren
                    car.setMileage(newMileage);
                    System.out.println("Kilometerstand aktualisiert.");
                    break;

                case 5:
                    System.out.println("Programm wird beendet...");
                    scanner.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Ungültige Option. Bitte versuchen Sie es erneut.");
            }
        }
    }
}
