package net.initiativet.a62415_team8;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import org.w3c.dom.Text;

public class DetailSreen extends AppCompatActivity implements View.OnClickListener {

    int id = 0;
    String title = "";
    String resume = "";
    String nummer = "";
    String url = "";
    TextView titleTextView;
    TextView resumeTextView;
    TextView ftLink;
    ImageButton backButton;
    Button propAsProposed, propAsAdopted, goToVote;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_screen);
        nummer = getIntent().getStringExtra("nummer");
        title = getIntent().getStringExtra("title");
        resume = getIntent().getStringExtra("resume");

        TextView titleTV = (TextView) findViewById(R.id.actionbar_title);
        titleTV.setText(nummer);

        backButton = (ImageButton) findViewById(R.id.actionbar_button_image);
        backButton.setBackgroundResource(R.drawable.arrow_left);
        backButton.setOnClickListener(this);

        propAsProposed = (Button) findViewById(R.id.propAsProposed);
        propAsAdopted = (Button) findViewById(R.id.propAsAdopted);
        goToVote = (Button) findViewById(R.id.goToVote);

        propAsAdopted.setOnClickListener(this);
        propAsProposed.setOnClickListener(this);
        goToVote.setOnClickListener(this);

        titleTextView = (TextView) findViewById(R.id.detail_title);
        resumeTextView = (TextView) findViewById(R.id.detail_resume);
        ftLink = (TextView) findViewById(R.id.ftLink);

        ftLink.setText("For flere detajler se link: ");

        titleTextView.setText(nummer +  " " + title);
        resumeTextView.setText(resume);
        System.out.print("title");

    }

    @Override
    public void onClick(View view) {
        if(view == backButton){
            finish();
        } else if (view == propAsProposed) {
            url = "http://";
        } else if(view == propAsAdopted) {

        } else if(view == goToVote) {

        }
    }
}
