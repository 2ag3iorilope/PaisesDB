package PaisesDB;

import java.util.Scanner;

public class Mainn {

    public static void main(String[] args) {
        SQLite dbManager = new SQLite(); 
        Scanner scanner = new Scanner(System.in);
        String databaseType;

        while (true) {
         
            System.out.println("Aukeratu datu-base mota (SQLite/Access/SQLServer edo 'irten' irteteko): ");
            databaseType = scanner.next();

            if (databaseType.equalsIgnoreCase("irten")) {
                System.out.println("Programa amaitu da.");
                break;
            }

            switch (databaseType.toLowerCase()) {
                case "sqlite":
                    manageSQLiteMenu(dbManager, scanner);
                    break;

                case "access":
                    manageAccessMenu(dbManager,scanner); 
                    break;

                case "sqlserver":
                    manageSQLServerMenu(dbManager,scanner); 
                    break;

                default:
                    System.out.println("Datu-base mota okerra. Saiatu berriro.");
                    break;
            }
        }

        scanner.close();
    }

    private static void manageSQLiteMenu(SQLite dbManager, Scanner scanner) {
        int choice;
        dbManager.openConnection("sqlite");
        do {
            System.out.println("\n--- SQLite MENU ---");
            System.out.println("1. Taulak bete datuekin");
            System.out.println("2. Taulak garbitu");
            System.out.println("3. Taulak erakutsi");
            System.out.println("4. Atzera");
            System.out.print("Aukeratu aukera: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    dbManager.populateTables();
                    break;
                case 2:
                    dbManager.clearTables();
                    break;
                case 3:
                    dbManager.selectData();
                    break;
                case 4:
                    System.out.println("Atzera menura bueltatzen...");
                    break;
                default:
                    System.out.println("Aukera okerra. Saiatu berriro.");
            }
        } while (choice != 4);
    }

    private static void manageAccessMenu(SQLite dbManager,Scanner scanner) {
    
        int choice;
        dbManager.openConnection("access");
       
        do {
            System.out.println("\n--- Access MENU ---");
            System.out.println("1. Taulak bete datuekin");
            System.out.println("2. Taulak garbitu");
            System.out.println("3. Taulak erakutsi");
            System.out.println("4. Atzera");
            System.out.print("Aukeratu aukera: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                	 dbManager.populateTablesaccess();
                    System.out.println("Access: Taulak datuekin betetzen...");
                   
                    break;
                case 2:
                	 dbManager.clearTables();
                    System.out.println("Access: Taulak garbitzen...");
                  
                    break;
                case 3:
                	 dbManager.selectData();
                    System.out.println("Access: Taulak erakusten...");
                   
                    break;
                case 4:
                	 
                    System.out.println("Atzera menura bueltatzen...");
                    break;
                default:
                    System.out.println("Aukera okerra. Saiatu berriro.");
            }
        } while (choice != 4);
    }

    private static void manageSQLServerMenu(SQLite dbManager,Scanner scanner) {
        int choice;
        do {
            System.out.println("\n--- SQL Server MENU ---");
            System.out.println("1. Taulak bete datuekin");
            System.out.println("2. Taulak garbitu");
            System.out.println("3. Taulak erakutsi");
            System.out.println("4. Atzera");
            System.out.print("Aukeratu aukera: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("SQL Server: Taulak datuekin betetzen...");
                  
                    break;
                case 2:
                    System.out.println("SQL Server: Taulak garbitzen...");
                    
                    break;
                case 3:
                    System.out.println("SQL Server: Taulak erakusten...");
                
                    break;
                case 4:
                    System.out.println("Atzera menura bueltatzen...");
                    break;
                default:
                    System.out.println("Aukera okerra. Saiatu berriro.");
            }
        } while (choice != 4);
    }
}

