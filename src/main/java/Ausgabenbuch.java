import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

public class Ausgabenbuch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashMap<String, HashMap<String, Double>> buchEintrag = new HashMap<>();

        System.out.println("Ausgabenbuch ist bereit für die Eingaben");

        while (true) {
            String input = scanner.nextLine();
            String[] comment = input.split(" ");

            if (comment[0].equals("exit")) {
                break;
            }

            regulator(comment, buchEintrag);
        }
        System.out.println("Bye");
    }

    private static void regulator(String[] comment, HashMap<String, HashMap<String, Double>> buchEintrag) {
        try {
            if (comment[0].equals("add") && comment.length == 4) {
                add(comment, buchEintrag);
            }
            /*
            if (comment[0].equals("report") && comment.length == 2 && comment[1].equals("shop")) {
                reportShop(comment, buchEintrag);
            }
            */
            /*
            if (comment[0].equals("report") && comment.length == 2 && comment[1].equals("category")) {
                reportCategory(comment, buchEintrag);
            }

             */
            if (!comment[0].equals("add") && !comment[0].equals("report") && !comment[0].equals("exit")) {
                System.out.println("Ungültiger Befehl oder fehlende Parameter");
            }
        } catch (Exception e) {
            System.out.println("Fehler: " + e.getMessage());
        }
    }

    private static void add(String[] comment, HashMap<String, HashMap<String, Double>> buchEintrag) {
        String shop = comment[1];
        String category = comment[2];
        double amount = Double.parseDouble(comment[3]);

        buchEintrag.putIfAbsent(shop, new HashMap<>());
        buchEintrag.get(shop).put(category, buchEintrag.get(shop).getOrDefault(category, 0.0) + amount);

        System.out.println("Hinzugefügt zum Shop " + shop + " in der Kategorie " + category + ": " + amount);
    }

    /**
    private static void reportShop(String[] comment, HashMap<String, HashMap<String, Double>> buchEintrag) {
        String shop = comment[2];
        if (buchEintrag.containsKey(shop)) {
            HashMap<String, Double> innerMap = buchEintrag.get(shop);
            double total = 0;
            System.out.println("Report for shop: " + shop);
            for (Map.Entry<String, Double> entry : innerMap.entrySet()) {
                System.out.println(entry.getKey() + ": " + entry.getValue());
                total += entry.getValue();
            }
            System.out.println("Total: " + total);
        } else {
            System.out.println("Shop " + shop + " not found.");
        }
    }
    */
    /**
    private static void reportCategory(String[] comment, HashMap<String, HashMap<String, Double>> buchEintrag) {
        String category = comment[2];
        double total = 0;
        System.out.println("Report for category: " + category);
        for (Map.Entry<String, HashMap<String, Double>> outerEntry : buchEintrag.entrySet()) {
            HashMap<String, Double> innerMap = outerEntry.getValue();
            if (innerMap.containsKey(category)) {
                double value = innerMap.get(category);
                System.out.println(outerEntry.getKey() + ": " + value);
                total += value;
            }
        }
        System.out.println("Total: " + total);
    }
     */
}


/**
 * ? wie die Ausgebe der Konsolle aussehen kann
 *
 * Ausgabenbuch ist bereit für die Eingaben
 * > add Aldi Lebensmittel 29.30
 * Hinzugefügt zum Shop Aldi in der Kategorie Lebensmittel: 29,30
 * > add Durstbunker Lebensmittel 37.30
 * Hinzugefügt zum Shop Durstbunker in der Kategorie Lebensmittel: 37,30
 * > add Edeka Lebensmittel 48.33
 * Hinzugefügt zum Shop Edeka in der Kategorie Lebensmittel: 48,33
 * > add Steam Computerspiele 29.99
 * Hinzugefügt zum Shop Steam in der Kategorie Computerspiele: 29,99
 * > add Amazon Haushaltsartikel 6.67
 * Hinzugefügt zum Shop Amazon in der Kategorie Haushaltsartikel: 6,67
 * > add Amazon Computerspiele 38.99
 * Hinzugefügt zum Shop Amazon in der Kategorie Computerspiele: 38,99
 * > report category
 * Computerspiele: 68,98
 * Haushaltsartikel: 6,67
 * Lebensmittel: 114,93
 * > report shop
 * Aldi: 29,30
 * Amazon: 45,66
 * Durstbunker: 37,30
 * Edeka: 48,33
 * Steam: 29,99
 * > exit
 * Bye.
 */