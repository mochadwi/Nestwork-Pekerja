package com.sebasku.networks.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.sebasku.networks.R;
import com.sebasku.networks.api.UtilsApi;
import com.sebasku.networks.apimodel.Profile;
import com.sebasku.networks.apimodel.ResponseProfile;
import com.sebasku.networks.session.SessionManager;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProfileActivity extends AppCompatActivity {
    Button edit;
    TextView mNama,mPosisi,mEmail,mHp;
    SessionManager session;
    String token;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        initialized();
        onClickAction();

        getProfile();
    }

    public void initialized(){
        edit = findViewById(R.id.btn_edit);
        mNama = findViewById(R.id.tv_nama1);
        mHp= findViewById(R.id.tv_no_hp1);
        mPosisi = findViewById(R.id.tv_bidang_developer1);
        mEmail = findViewById(R.id.tv_email1);

    }
    public void onClickAction(){
        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(ProfileActivity.this,EditProfilActivity.class);
                startActivity(i);
            }
        });
    }

    private void getProfile() {
        session = new SessionManager(getApplicationContext());
        token = session.getAccesToken();
        String tokenize = "Bearer "+token;
        Toast.makeText(ProfileActivity.this,"INI TOKENNN :"+token,Toast.LENGTH_SHORT).show();
        Call<ResponseProfile> call = UtilsApi.getAPIService().getProfile(tokenize);

        call.enqueue(new Callback<ResponseProfile>() {
            @Override
            public void onResponse(Call<ResponseProfile> call, Response<ResponseProfile> response) {
                if (response.isSuccessful()) {

                    ResponseProfile responsesProfile = response.body();
                    String nama = responsesProfile.getNama();
                    String posisi = responsesProfile.getPosisi();
                    String email = responsesProfile.getEmail();
                    String no = responsesProfile.getNoHp();

                    mNama.setText(nama);
                    mPosisi.setText(posisi);
                    mEmail.setText(email);
                    mHp.setText(no);

                }
                else {
                    Toast.makeText(ProfileActivity.this, "check your Email or Password", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ResponseProfile> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "Koneksi internet bermasalah", Toast.LENGTH_SHORT).show();
            }
        });
    }

}
