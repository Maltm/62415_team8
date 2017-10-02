package net.initiativet.a62415_team8;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    LinearLayout propContainer;
    Button[] propButton;
    ProposalDAO propDAO = new ProposalDAO();
    List<ProposalDTO> propList = new ArrayList<ProposalDTO>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        propContainer = (LinearLayout) findViewById(R.id.proposalContainer);


        new AsyncTask<Object, Object, Void>() {
            @Override
            protected Void doInBackground(Object... params) {
                try {
                    propList = propDAO.fetchProposal();
                    propButton = new Button[propList.size()];
                }catch (Exception e) {
                    System.out.println(e.toString());
                }
                return null;
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                super.onPostExecute(aVoid);
                setButtons();
            }
        }.execute();
    }


    @Override
    public void onClick(View v) {

    }
    public void setButtons() {
        for(int i = 0; i<propList.size(); i++) {
            propButton[i] = new Button(this);
            propButton[i].setText(propList.get(i).getTitel());
            propButton[i].setTag(propList.get(i).getId());
            propButton[i].setOnClickListener(this);

            propContainer.addView(propButton[i]);
        }

    }
}
