package com.sebasku.networks.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.sebasku.networks.R;
import com.sebasku.networks.session.sessionManager;

public class MenuActivity extends AppCompatActivity {

    ImageView userFoto,slipGaji,Cuti,infoPerusahaan,presensiHarian;
    TextView logout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        initializedObject();
        actionClicked();
    }

    public void initializedObject(){
        userFoto = findViewById(R.id.user_foto);
        slipGaji = findViewById(R.id.slip_gaji);
        Cuti = findViewById(R.id.ajukan_cuti);
        infoPerusahaan = findViewById(R.id.informasi_perusahaan);
        presensiHarian = findViewById(R.id.presensi_harian);
        logout = findViewById(R.id.tv_logout);

    }

    public void actionClicked(){
        userFoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MenuActivity.this,ProfileActivity.class);
                startActivity(i);
            }
        });

        slipGaji.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MenuActivity.this,SlipGajiActivity.class);
                startActivity(i);
            }
        });

        infoPerusahaan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MenuActivity.this,ProfilPerusahaanActivity.class);
                startActivity(i);
            }
        });

        presensiHarian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MenuActivity.this,PresensiActivity.class);
                startActivity(i);
            }
        });

        Cuti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MenuActivity.this,CutiActivity.class);
                startActivity(i);
            }
        });
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sessionManager sessionlogout = new sessionManager(getApplicationContext());
                sessionlogout.logoutUser();
            }
        });
    }
}
