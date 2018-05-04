package com.sebasku.networks.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.sebasku.networks.R;
import com.sebasku.networks.api.UtilsApi;
import com.sebasku.networks.apimodel.RequestCutiForm;
import com.sebasku.networks.apimodel.ResponseAjukanCuti;
import com.sebasku.networks.session.sessionManager;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RequestCutiFragment extends Fragment {
    View viewRequestCuti;
    Button requestCuti;
    EditText awalCuti, akhirCuti, keterangan, email;
    String mAwalCuti, mAkhirCuti, mKeterangan, mEmail;
    sessionManager session ;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        viewRequestCuti = inflater.inflate(R.layout.fragment_request_cuti, container, false);
        init();
        requestCuti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mAwalCuti = awalCuti.getText().toString();
                mAkhirCuti = akhirCuti.getText().toString();
                mKeterangan = keterangan.getText().toString();
                String respons = "0";
                String status = "0";
                session = new sessionManager(getContext());
                String nama = session.getNama();
                String mEmail = session.getEmail();
                saveCuti(mEmail,nama, mAwalCuti, mAkhirCuti, mKeterangan,respons,status);

            }
        });

        return viewRequestCuti;
    }

    public void init() {
        awalCuti = (EditText) viewRequestCuti.findViewById(R.id.et_awal_cuti);
        akhirCuti = (EditText) viewRequestCuti.findViewById(R.id.et_akhir_cuti);
        keterangan = (EditText) viewRequestCuti.findViewById(R.id.et_keterangan_cuti);
        requestCuti = (Button) viewRequestCuti.findViewById(R.id.btn_request_cuti);
    }

    public void saveCuti(String email,String nama, String awalCuti, String akhirCuti, String keterangan,String respons,String status) {
        RequestCutiForm cuti = new RequestCutiForm(email,nama, awalCuti, akhirCuti, keterangan,respons,status);
       // User responsesId = response.body().getUser();
        session = new sessionManager(getContext());
        String token = session.getAccesToken();
        Toast.makeText(getActivity(), "ini token : "+token, Toast.LENGTH_SHORT).show();
        String b = "Bearer ";
        String tokenize = b+token;
        Call<ResponseAjukanCuti> call = UtilsApi.getAPIService().addCuti(tokenize, cuti);

        call.enqueue(new Callback<ResponseAjukanCuti>() {
            @Override
            public void onResponse(Call<ResponseAjukanCuti> call, Response<ResponseAjukanCuti> response) {
                if (response.isSuccessful()) {
                    Toast.makeText(getActivity(), "Suksesssssssssss post", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getActivity(), "check your Email or Password nyaaa", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ResponseAjukanCuti> call, Throwable t) {
                Toast.makeText(getActivity(), "Koneksi internet bermasalah", Toast.LENGTH_SHORT).show();
            }
        });
    }
}