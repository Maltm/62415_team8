package net.initiativet.a62415_team8;

/**
 * Created by malte on 01-10-2017.
 */

public class ProposalDTO {

    int id;
    String titel;
    String titelKort;
    String resume;
    String nummer;
    String nummerPrefix;
    String nummernumerisk;
    String nummerpostfix;

    public void setID(int id) {
        this.id = id;
    }

    public int getId () {
        return id;
    }

    public void setTitel(String titel) {
        this.titel = titel;
    }

    public String getTitel() {
        return titel;
    }

    public void setTitelKort(String titelKort) {this.titelKort = titelKort;}

    public String getTitelKort() {return titelKort;}

    public void setResume(String resume) {
        this.resume = resume;
    }

    public String getResume() {
        return resume;
    }

    public String getNummer() {return  nummer;}

    public void setNummer(String nummer) {this.nummer = nummer;}

    public String getNummerPrefix() {return nummerPrefix;}

    public void setNummerPrefix(String nummerPrefix) {this.nummerPrefix = nummerPrefix;}

    public String getNummernumerisk() {return nummernumerisk;}

    public void setNummernumerisk(String nummernumerisk) {this.nummernumerisk = nummernumerisk;}

    public String getNummerpostfix() {return nummerpostfix;}

    public void setNummerpostfix(String nummerpostfix) {this.nummerpostfix = nummerpostfix;}
}
