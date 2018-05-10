package com.sebasku.networks.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.sebasku.networks.R;
import com.sebasku.networks.api.UtilsApi;
import com.sebasku.networks.apimodel.RequestCutiForm;
import com.sebasku.networks.apimodel.RequestPresentForm;
import com.sebasku.networks.apimodel.ResponseAjukanCuti;
import com.sebasku.networks.apimodel.ResponsePresent;
import com.sebasku.networks.session.SessionManager;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PresensiActivity extends AppCompatActivity {
    RadioGroup rg;
    EditText backlog, task, note;
    Button submit;
    int selectedId;
    String mBacklog, mTask, mNote, nama, email;
    String mRb;
    SessionManager session;
    String mStatus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_presensi);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Presensi");
        init();
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                session = new SessionManager(getApplicationContext());
                selectedId = rg.getCheckedRadioButtonId();
                RadioButton radioButton = (RadioButton) findViewById(selectedId);
                mRb = radioButton.getText().toString();
                if (mRb.equals("Will Do")) {
                    mStatus = "0";
                } else if (mRb.equals("Did/Done")) {
                    mStatus = "1";
                } else if (mRb.equals("Obstacle")) {
                    mStatus = "2";
                }
                Toast.makeText(PresensiActivity.this, mStatus, Toast.LENGTH_SHORT).show();
                mBacklog = backlog.getText().toString();
                mTask = task.getText().toString();
                mNote = note.getText().toString();
                nama = session.getNama();
                email = session.getEmail();
                savePresent(email, nama, mBacklog, mStatus, mTask, mNote);
            }
        });
    }

    public void savePresent(String email, String nama, String backlog, String mRb, String task, String note) {
        RequestPresentForm present = new RequestPresentForm(email, nama, backlog, mRb, task, note);
        // User responsesId = response.body().getUser();
        session = new SessionManager(getApplicationContext());
        String token = session.getAccesToken();
        Toast.makeText(PresensiActivity.this, "ini token : " + token, Toast.LENGTH_SHORT).show();
        String b = "Bearer ";
        String tokenize = b + token;
        Call<ResponsePresent> call = UtilsApi.getAPIService().addPresent(tokenize, present);

        call.enqueue(new Callback<ResponsePresent>() {
            @Override
            public void onResponse(Call<ResponsePresent> call, Response<ResponsePresent> response) {
                if (response.isSuccessful()) {
                    Toast.makeText(PresensiActivity.this, "Suksesssssssssss post", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(PresensiActivity.this, "check your Email or Password nyaaa", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ResponsePresent> call, Throwable t) {
                Toast.makeText(PresensiActivity.this, "Koneksi internet bermasalah", Toast.LENGTH_SHORT).show();
            }
        });
    }

    //Tombol Aksi Kembali
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    public void init() {
        rg = findViewById(R.id.rg_status);
        backlog = findViewById(R.id.et_backlog_presensi);
        task = findViewById(R.id.et_task_presensi);
        note = findViewById(R.id.et_note_presensi);
        submit = findViewById(R.id.btn_submit_presensi);
    }
}
