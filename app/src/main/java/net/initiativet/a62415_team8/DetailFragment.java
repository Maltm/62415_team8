package net.initiativet.a62415_team8;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;


public class DetailFragment extends Fragment implements View.OnClickListener {

    String title = "";
    String resume = "";
    String nummer = "";
    String nummerPrefix = "";
    String nummerPostFix = "";
    String nummernumerisk = "";

    String url = "";
    TextView resumeTextView;
    TextView ftLink;
    ImageButton backButton;
    Button propAsProposed, propAsAdopted, goToVote;
    public DetailFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_detail, container, false);
        nummer = getArguments().getString("nummer");
        title = getArguments().getString("title");
        resume = getArguments().getString("resume");
        nummerPrefix = getArguments().getString("nummerPrefix");
        nummerPostFix = getArguments().getString("nummerPostfix");
        nummernumerisk = getArguments().getString("nummernumerisk");

        TextView titleTextView = (TextView) v.findViewById(R.id.detail_title);
        titleTextView.setText(title);

        propAsProposed = (Button) v.findViewById(R.id.propAsProposed);
        propAsAdopted = (Button) v.findViewById(R.id.propAsAdopted);
        goToVote = (Button) v.findViewById(R.id.goToVote);

        propAsAdopted.setOnClickListener(this);
        propAsProposed.setOnClickListener(this);
        goToVote.setOnClickListener(this);


        resumeTextView = (TextView) v.findViewById(R.id.detail_resume);
        ftLink = (TextView) v.findViewById(R.id.ftLink);

        String ftLinkURL = "http://www.ft.dk/samling/20171/Lovforslag/" + nummerPrefix  + nummernumerisk + nummerPostFix + "/index.htm";
        ftLink.setText("For flere detajler se link: " + ftLinkURL);
        titleTextView.setText(nummer +  " " + title);
        resumeTextView.setText(resume);
        return v;
    }


    @Override
    public void onClick(View view) {
        if(view == backButton){

        } else if (view == propAsProposed) {
            url = "http://";
        } else if(view == propAsAdopted) {

        } else if(view == goToVote) {

        }
    }

    public interface OnDetailFragmentInteractionListener {
        // TODO: Update argument type and name
        void onDetailFragmentInteraction(Uri uri);
    }
}
