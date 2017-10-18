package net.initiativet.a62415_team8;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.TextureView;
import android.widget.TextView;

public class DetailSreen extends AppCompatActivity {

    int id = 0;
    String title = "pøls";
    String resume = "";
    String nummer = "";
    TextView titleTextView;
    TextView resumeTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_sreen);

        nummer = getIntent().getStringExtra("nummer");
        title = getIntent().getStringExtra("title");
        resume = getIntent().getStringExtra("resume");

        setTitle(nummer);

        titleTextView = (TextView) findViewById(R.id.detail_title);
        resumeTextView = (TextView) findViewById(R.id.detail_resume);

        titleTextView.setText(nummer +  " " + title);
        resumeTextView.setText(resume);
        System.out.print("title");
    }
}
