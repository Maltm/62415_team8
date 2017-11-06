package net.initiativet.a62415_team8;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by malte on 01-10-2017.
 */

public class ProposalDAO {
    apiRequest apiReq = new apiRequest();
    String predefinedAPIURL = "http://oda.ft.dk/api/Sag?&$filter=typeid eq 3";

    public List<ProposalDTO> fetchProposal() throws IOException, JSONException {
        List<ProposalDTO> allProposals = new ArrayList<ProposalDTO>();


        String tmp = apiReq.request(predefinedAPIURL);
        JSONObject json = new JSONObject(tmp);

        JSONArray value = json.getJSONArray("value");

        for(int i = 0; i < value.length(); i++) {
            JSONObject jsonValue = value.getJSONObject(i);
            int valueID = jsonValue.getInt("id");
            String valueTitel = jsonValue.getString("titel");
            String valueResume = jsonValue.getString("resume");
            String valueNummer = jsonValue.getString("nummer");
            String valueNummerPrefix = jsonValue.getString("nummerprefix");
            String valueNummerPostfix = jsonValue.getString("nummerprofix");
            String valueNummerisk = jsonValue.getString("nummernumerisk");

            ProposalDTO tmpProp = new ProposalDTO();
            tmpProp.setID(valueID);
            tmpProp.setTitel(valueTitel);
            tmpProp.setResume(valueResume);
            tmpProp.setNummer(valueNummer);
            tmpProp.setNummerPrefix(valueNummerPrefix);
            tmpProp.setNummernumerisk(valueNummerisk);
            tmpProp.setNummerpostfix(valueNummerPostfix);

            allProposals.add(tmpProp);
        }
        return allProposals;
    }
}
