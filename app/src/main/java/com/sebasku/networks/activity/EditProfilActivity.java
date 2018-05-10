package com.sebasku.networks.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.sebasku.networks.R;
import com.sebasku.networks.api.UtilsApi;
import com.sebasku.networks.apimodel.ProfileUpdateForm;
import com.sebasku.networks.apimodel.RequestCutiForm;
import com.sebasku.networks.apimodel.ResponseAjukanCuti;
import com.sebasku.networks.apimodel.ResponseUpdateProfil;
import com.sebasku.networks.session.SessionManager;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EditProfilActivity extends AppCompatActivity {

    SessionManager session;
    EditText nama, email, noHp, bidang, pswdBaru, retypePswd,tanggal;
    String mNama, mEmail, mNoHp, mBidang, mPswdBaru, mRetypePswd,mTanggal;
    String getNama, getEmail, getNoHp, getBidang;
    Button submit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profil);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Edit Profil");
        session = new SessionManager(getApplicationContext());
        init();
        setProfil();
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mBidang = bidang.getText().toString();
                mEmail = email.getText().toString();
                mNama = nama.getText().toString();
                mNoHp = noHp.getText().toString();
                mTanggal = tanggal.getText().toString();
                mPswdBaru = pswdBaru.getText().toString();
                mRetypePswd = retypePswd.getText().toString();
                updateProfil(mNama,mEmail,mBidang,mNoHp,mTanggal,mPswdBaru);
            }
        });
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
    public void updateProfil(String mNama,String mEmail,String mBidang,String mNoHp,String mTanggal,String mPswdBaru) {
        ProfileUpdateForm update = new ProfileUpdateForm(mNama,mEmail,mBidang,mNoHp,mTanggal,mPswdBaru);
        // User responsesId = response.body().getUser();
        session = new SessionManager(getApplicationContext());
        String token = session.getAccesToken();
        String id = session.getId();
        Toast.makeText(EditProfilActivity.this, "ini token : "+token, Toast.LENGTH_SHORT).show();
        String b = "Bearer ";
        String tokenize = b+token;
        Call<ResponseUpdateProfil> call = UtilsApi.getAPIService().updateProfil(tokenize,id, update);

        call.enqueue(new Callback<ResponseUpdateProfil>() {
            @Override
            public void onResponse(Call<ResponseUpdateProfil> call, Response<ResponseUpdateProfil> response) {
                if (response.isSuccessful()) {
                    Toast.makeText(getApplicationContext(), "Suksesssssssssss Update", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getApplicationContext(), "check your Email or Password nyaaa", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ResponseUpdateProfil> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "Koneksi internet bermasalah", Toast.LENGTH_SHORT).show();
            }
        });
    }
    public void init(){
        bidang = findViewById(R.id.et_bidang_update_profil);
        nama = findViewById(R.id.et_nama_update_profil);
        email = findViewById(R.id.et_email_update_profil);
        noHp = findViewById(R.id.et_nohp_update_profil);
        pswdBaru = findViewById(R.id.et_pswdbaru_update_profil);
        retypePswd = findViewById(R.id.et_retypepswd_update_profil);
        tanggal = findViewById(R.id.et_tanggal_update_profil);
        submit = findViewById(R.id.btn_submit_edit_profil);
    }

    public void setProfil(){
        getBidang=session.getPosisi();
        getEmail=session.getEmail();
        getNama=session.getNama();
        getNoHp=session.getNoHp();

        bidang.setText(getBidang);
        email.setText(getEmail);
        nama.setText(getNama);
        noHp.setText(getNoHp);
    }
}
