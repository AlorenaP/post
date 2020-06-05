package com.example.poster.vista;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.poster.R;

public class DetailPost extends AppCompatActivity {

    TextView id;
    TextView idUser;
    TextView body;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_post);

        id=findViewById(R.id.tv_id);
        idUser=findViewById(R.id.tv_idUsuario);
        body = findViewById(R.id.text_detail);

        Bundle bundle= getIntent().getExtras();
        Integer nId= bundle.getInt("id");
        Integer nIdUser= bundle.getInt("idUser");
        String nBody = bundle.getString("body");

        id.setText(nId.toString());
        idUser.setText(nIdUser.toString());
        body.setText(nBody);

    }
}
