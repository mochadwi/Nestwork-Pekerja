package com.sebasku.networks.fragment;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.sebasku.networks.R;
import com.sebasku.networks.api.UtilsApi;
import com.sebasku.networks.apimodel.RequestCutiForm;
import com.sebasku.networks.apimodel.RequestGajiForm;
import com.sebasku.networks.apimodel.ResponseAjukanCuti;
import com.sebasku.networks.apimodel.ResponseAjukanSlipGaji;
import com.sebasku.networks.session.sessionManager;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RequestGajiFragment extends Fragment {
    View requestGaji;
    Button btnGaji;
    sessionManager session;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        requestGaji = inflater.inflate(R.layout.fragment_request_gaji, container, false);


/*        "email":"tsani@gmail.com",
                "waktu":"08-02-1996",
                "status":"0",
                "gaji":"0"*/
        init();
        btnGaji.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                session = new sessionManager(getContext());
                String email = session.getEmail();
                String waktu ="02-02-1996";
                String status = "0";
                String gaji ="0";
                saveGaji(email,waktu,status,gaji);

            }
        });

        return requestGaji;
    }

    public void init() {
        btnGaji = (Button) requestGaji.findViewById(R.id.btn_request_gaji);
    }

    public void saveGaji(String email,String waktu,String status, String gaji) {
        RequestGajiForm gajihan = new RequestGajiForm(email,waktu,status,gaji);
        // User responsesId = response.body().getUser();
        session = new sessionManager(getContext());
        String token = session.getAccesToken();
        Toast.makeText(getActivity(), "ini token : " + token, Toast.LENGTH_SHORT).show();
        String b = "Bearer ";
        String tokenize = b + token;
        Call<ResponseAjukanSlipGaji> call = UtilsApi.getAPIService().addGaji(tokenize, gajihan);

        call.enqueue(new Callback<ResponseAjukanSlipGaji>() {
            @Override
            public void onResponse(Call<ResponseAjukanSlipGaji> call, Response<ResponseAjukanSlipGaji> response) {
                if (response.isSuccessful()) {
                    Toast.makeText(getActivity(), "Sukses Mengajukan Gaji", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getActivity(), "check Email dan Password", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ResponseAjukanSlipGaji> call, Throwable t) {
                Toast.makeText(getActivity(), "Koneksi internet bermasalah", Toast.LENGTH_SHORT).show();
            }
        });
    }
}