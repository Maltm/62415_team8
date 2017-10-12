package net.initiativet.a62415_team8;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    ProposalDAO propDAO = new ProposalDAO();
    ListView listView;
    List<ProposalDTO> propList = new ArrayList<ProposalDTO>();
    List<String> testList = new ArrayList<String>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView) findViewById(R.id.listView_lov);

        new AsyncTask<Object, Object, Void>() {
            @Override
            protected Void doInBackground(Object... params) {
                try {
                    propList = propDAO.fetchProposal();
                }catch (Exception e) {
                    System.out.println(e.toString());
                }
                return null;
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                super.onPostExecute(aVoid);
                for(int i = 0; i < propList.size(); i++) {
                    testList.add(propList.get(i).getNummer() + " : " + propList.get(i).getTitel());
                }

                ArrayAdapter adapter = new ArrayAdapter(MainActivity.this, R.layout.list_cell, R.id.cell_textView, testList); //<- insert array list
                listView.setAdapter(adapter);
            }
        }.execute();


        //42bfb4 <----- COLOR
    }


    @Override
    public void onClick(View v) {

    }

}
