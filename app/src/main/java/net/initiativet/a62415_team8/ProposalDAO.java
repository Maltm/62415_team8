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

    public List<ProposalDTO> fetchProposal(String requestURL) throws IOException, JSONException {
        List<ProposalDTO> allProposals = new ArrayList<ProposalDTO>();
        ProposalDTO tmpProp;

        String tmp = apiReq.request(requestURL);
        JSONObject json;
        String nextURL;
        JSONArray value;
        String valueTitel;
        String valueResume;
        String valueNummer;
        String valueNummerPrefix;
        String valueNummerPostfix;
        String valueNummerisk;

        int valueID;
        while(true) {
            json = new JSONObject(tmp);
            try {
                nextURL = json.getString("odata.nextLink");
            }catch (Exception e) {
                break;
            }

            value = json.getJSONArray("value");

            for(int i = 0; i < value.length(); i++) {
                JSONObject jsonValue = value.getJSONObject(i);
                valueID = jsonValue.getInt("id");
                valueTitel = jsonValue.getString("titel");
                valueResume = jsonValue.getString("resume");
                valueNummer = jsonValue.getString("nummer");
                valueNummerPrefix = jsonValue.getString("nummerprefix");
                valueNummerPostfix = jsonValue.getString("nummerpostfix");
                valueNummerisk = jsonValue.getString("nummernumerisk");

                tmpProp = new ProposalDTO();
                tmpProp.setID(valueID);
                tmpProp.setTitel(valueTitel);
                tmpProp.setResume(valueResume);
                tmpProp.setNummer(valueNummer);
                tmpProp.setNummerPrefix(valueNummerPrefix);
                tmpProp.setNummernumerisk(valueNummerisk);
                tmpProp.setNummerpostfix(valueNummerPostfix);

                allProposals.add(tmpProp);

            }

            tmp = apiReq.request(nextURL);
        }
        return allProposals;
    }
}
