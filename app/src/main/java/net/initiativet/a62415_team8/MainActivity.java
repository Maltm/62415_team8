package net.initiativet.a62415_team8;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    ProposalDAO propDAO = new ProposalDAO();
    ListView listView;
    List<ProposalDTO> propList = new ArrayList<ProposalDTO>();
    List<String> titleList = new ArrayList<String>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView titleTV = (TextView) findViewById(R.id.actionbar_title);
        titleTV.setText("Udvalgte forslag");


        setTitle("Udvalgte forslag");
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
                    titleList.add(propList.get(i).getNummer() + " : " + propList.get(i).getTitel());
                }

                ArrayAdapter adapter = new ArrayAdapter(MainActivity.this, R.layout.list_cell, R.id.cell_textView, titleList); //<- insert array list
                listView.setAdapter(adapter);
                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                        Intent i = new Intent(view.getContext(), DetailSreen.class);
                        i.putExtra("title", propList.get(position).getTitel());
                        i.putExtra("nummer", propList.get(position).getNummer());
                        i.putExtra("resume", propList.get(position).getResume());
                        i.putExtra("nummerPrefix", propList.get(position).getNummerPrefix());
                        i.putExtra("nummerPostfix", propList.get(position).getNummerpostfix());
                        i.putExtra("nummerisk", propList.get(position).getNummernumerisk());
                        startActivity(i);
                    }
                });
            }
        }.execute();
    }


    @Override
    public void onClick(View v) {

    }

}
