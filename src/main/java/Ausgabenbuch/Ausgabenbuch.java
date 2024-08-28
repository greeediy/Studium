

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Ausgabenbuch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Shopping> shoppings = new ArrayList<>();

        System.out.println("Ausgabenbuch ist bereit für die Eingaben");
        while (true) {
            String comment = scanner.nextLine();
            String[] commentSplit = comment.split(" ");

            if (comment.equals("exit")) {
                break;
            }

            if (wrongInputLength(commentSplit)) {
                printErrorMessage();
            } else {
                processCommand(commentSplit, shoppings);
            }
        }
        System.out.println("Bye");
    }

    public static boolean wrongInputLength(String[] commentSplit) {
        return !(commentSplit.length == 2 || commentSplit.length == 1 || commentSplit.length == 4);
    }

    public static void printErrorMessage() {
        System.out.println("Fehler beim Eingeben, Ihre Eingabe ist nicht korrekt");
        System.out.println("Bitte geben Sie:");
        System.out.println("'exit' um das Programm zu beenden");
        System.out.println("'add <geschaeft> <kategorie> <betrag>' um etwas hinzuzufügen");
        System.out.println("'report <geschaeft>' um einen Report von den Geschäften zu geben");
        System.out.println("'report <kategorie>' um einen Report nach den Kategorien durchzuführen");
    }

    public static void processCommand(String[] commentSplit, List<Shopping> shoppings) {
        switch (commentSplit[0]) {
            case "report":
                if (commentSplit[1].equals("shop")) {
                    reportShop(shoppings);
                } else if (commentSplit[1].equals("category")) {
                    reportCategory(shoppings);
                }
                break;
            case "add":
                add(commentSplit, shoppings);
                break;
            default:
                printErrorMessage();
                break;
        }
    }

    public static void add(String[] commentSplit, List<Shopping> shoppings) {
        try {
            double betrag = Double.parseDouble(commentSplit[3]);
            shoppings.add(new Shopping(commentSplit[1], commentSplit[2], betrag));
            System.out.println("Hinzugefügt zum Shop " + commentSplit[1] + " in der Kategorie " + commentSplit[2] + ": " + betrag);
        } catch (NumberFormatException e) {
            System.out.println("Fehler: Der Betrag muss eine Zahl sein.");
        }
    }

    public static void reportShop(List<Shopping> shoppings) {
        System.out.println("Report nach Shop:");
        shoppings.stream()
                .collect(Collectors.groupingBy(Shopping::getGeschaeft, Collectors.summingDouble(Shopping::getBetrag)))
                .forEach((shop, total) -> System.out.println(shop + ": " + total));
    }

    public static void reportCategory(List<Shopping> shoppings) {
        System.out.println("Report nach Kategorie:");
        shoppings.stream()
                .collect(Collectors.groupingBy(Shopping::getKategorie, Collectors.summingDouble(Shopping::getBetrag)))
                .forEach((category, total) -> System.out.println(category + ": " + total));
    }
}
