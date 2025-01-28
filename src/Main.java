import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static List<Superbowl> superbowlList = new ArrayList<>();

    public static void main(String[] args) {
        loadSuperbowlData();
        showMenu();
    } //In this section the main class is defined, a static list is declared to store superbowl objects in a array, superbowl data loaded from file into superbowlist and showMenu displays the user menu

    private static void loadSuperbowlData() {
        try (BufferedReader br = new BufferedReader(new FileReader("src/superbowls.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split("\\|"); 
                int year = Integer.parseInt(data[0].split("\\(")[0].trim()); 
                String superbowlNumber = data[1].trim();
                String winningTeam = data[2].trim();
                int winningScore = Integer.parseInt(data[3].trim());
                String losingTeam = data[4].trim();
                int losingScore = Integer.parseInt(data[5].trim());
                String mvp = data[6].trim();
                String stadium = data[7].trim();
                String city = data[8].trim();
                String state = data[9].trim();

                Superbowl superbowl = new Superbowl(year, superbowlNumber, winningTeam, winningScore,
                        losingTeam, losingScore, mvp, stadium, city, state);
                superbowlList.add(superbowl);
            }
        } catch (IOException | NumberFormatException e) {
            System.err.println("Error loading data: " + e.getMessage());
        }
    } //In this section the superbowls.txt file is read and each line is put into superbowl object and added into superbowllist

    private static void showMenu() {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("-----------------------");
            System.out.println(" NFL Superbowls menu");
            System.out.println("-----------------------");
            System.out.println("List .................1");
            System.out.println("Select ...............2");
            System.out.println("Search................3");
            System.out.println("Exit..................0");
            System.out.println("-----------------------");
            System.out.print("Enter choice:> ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    listSuperbowls(scanner);
                    break;
                case 2:
                    selectSuperbowl(scanner);
                    break;
                case 3:
                    searchSuperbowls(scanner);
                    break;
                case 0:
                    System.out.println("Exiting program...");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 0);

        scanner.close();
    } //In this section a menu is displayed and it takes the users input, it loops until the user exits the menu

    private static void listSuperbowls(Scanner scanner) {
        System.out.print("Enter start year > ");
        int startYear = scanner.nextInt();
        System.out.print("Enter end year > ");
        int endYear = scanner.nextInt();

        System.out.println("----------------------------------------------------------");
        System.out.println("| Year | Superbowl No. | Champions          | Runners-up   |");
        System.out.println("----------------------------------------------------------");
        for (Superbowl sb : superbowlList) {
            if (sb.getYear() >= startYear && sb.getYear() <= endYear) {
                System.out.printf("| %-4d | %-12s | %-18s | %-14s |\n",
                        sb.getYear(), sb.getSuperbowlNumber(), sb.getWinningTeam(), sb.getLosingTeam());
            }
        }
        System.out.println("----------------------------------------------------------");
    } //In this section the user will end the start and end year and then it will display the data within those years

    private static void selectSuperbowl(Scanner scanner) {
        System.out.print("Enter championship year > ");
        int year = scanner.nextInt();

        for (Superbowl sb : superbowlList) {
            if (sb.getYear() == year) {
                System.out.println(sb);
                return;
            }
        }
        System.out.println("No Superbowl found for the year " + year + ".");
    } //In this section the user will enter a specific year and then will display the data in that year if nothing is found then a message will be shown

    private static void searchSuperbowls(Scanner scanner) {
        System.out.println("Search superbowls by:");
        System.out.println("Team .................1");
        System.out.println("State.................2");
        System.out.println("Main menu.............0");
        System.out.print("Enter choice:> ");
        int choice = scanner.nextInt();
        scanner.nextLine(); //In this section a sub-menu is displayed for the user

        if (choice == 1) {
            System.out.print("Enter team name > ");
            String team = scanner.nextLine().toLowerCase();
            boolean found = false;

            System.out.println("----------------------------------------------------------");
            System.out.println("| Year | Superbowl No. | Winner             | Runner-up          |");
            System.out.println("----------------------------------------------------------");
            for (Superbowl sb : superbowlList) {
                if (sb.getWinningTeam().toLowerCase().contains(team) || sb.getLosingTeam().toLowerCase().contains(team)) {
                    found = true;
                    System.out.printf("| %-4d | %-12s | %-18s | %-18s |\n",
                            sb.getYear(), sb.getSuperbowlNumber(), sb.getWinningTeam(), sb.getLosingTeam());
                }
            }
            if (!found) {
                System.out.println("No results found for the team: " + team);
            } // In this section it allows the user to search by team
            System.out.println("----------------------------------------------------------");
        } else if (choice == 2) {
            System.out.print("Enter state name > ");
            String state = scanner.nextLine().toLowerCase();
            boolean found = false;

            System.out.println("----------------------------------------------------------");
            System.out.println("| Year | Superbowl No. | City               | Stadium           |");
            System.out.println("----------------------------------------------------------");
            for (Superbowl sb : superbowlList) {
                if (sb.getState().toLowerCase().contains(state)) {
                    found = true;
                    System.out.printf("| %-4d | %-12s | %-18s | %-18s |\n",
                            sb.getYear(), sb.getSuperbowlNumber(), sb.getCity(), sb.getStadium());
                }
            }
            if (!found) {
                System.out.println("No results found for the state: " + state);
            }
            System.out.println("----------------------------------------------------------");
        } else if (choice == 0) {
            System.out.println("Returning to the main menu...");
        } else {
            System.out.println("Invalid choice. Try again.");
        }
    }
} //In this section it allows the user to seach by state
