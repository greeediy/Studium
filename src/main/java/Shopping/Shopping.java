package Shopping;

public class Shopping {
    private String geschaeft;
    private String kategorie;
    private double betrag;

    public Shopping(String geschaeft, String kategorie, double betrag) {
        this.geschaeft = geschaeft;
        this.kategorie = kategorie;
        this.betrag = betrag;
    }

    public String getGeschaeft() {
        return geschaeft;
    }

    public String getKategorie() {
        return kategorie;
    }

    public double getBetrag() {
        return betrag;
    }
}

