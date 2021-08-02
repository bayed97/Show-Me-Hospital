package net.farid.ict602project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;

public class About extends AppCompatActivity {

    Button sourcecode, serverside;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        sourcecode = (Button) findViewById(R.id.sourcecode);
        serverside = (Button) findViewById(R.id.serverside);

        this.setTitle("About Us");

        sourcecode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("https://github.com/bayed97/Show-Me-Hospital"));
                startActivity(intent);
            }
        });
        serverside.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("https://github.com/bayed97/Server-Side-Application-for-SMH-APPS"));
                startActivity(intent);
            }
        });
    }

}
