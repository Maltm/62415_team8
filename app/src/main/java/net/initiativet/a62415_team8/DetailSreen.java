package net.initiativet.a62415_team8;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class DetailSreen extends AppCompatActivity implements View.OnClickListener {

    int id = 0;
    String title = "";
    String resume = "";
    String nummer = "";
    TextView titleTextView;
    TextView resumeTextView;
    ImageButton backButton;
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

        titleTextView = (TextView) findViewById(R.id.detail_title);
        resumeTextView = (TextView) findViewById(R.id.detail_resume);

        titleTextView.setText(nummer +  " " + title);
        resumeTextView.setText(resume);
        System.out.print("title");

    }

    @Override
    public void onClick(View view) {
        if(view == backButton){
            finish();
        }
    }
}
