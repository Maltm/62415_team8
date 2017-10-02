package net.initiativet.a62415_team8;

/**
 * Created by malte on 01-10-2017.
 */

public class ProposalDTO {

    int id;
    String titel;
    String resume;

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

    public void setResume(String resume) {
        this.resume = resume;
    }

    public String getResume() {
        return resume;
    }
}
