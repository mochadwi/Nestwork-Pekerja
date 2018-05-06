package com.sebasku.networks.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.sebasku.networks.R;
import com.sebasku.networks.adapter.RiwayatCutiAdapter;
import com.sebasku.networks.adapter.RiwayatGajiAdapter;
import com.sebasku.networks.api.UtilsApi;
import com.sebasku.networks.apimodel.ResponseRiwayatCuti;
import com.sebasku.networks.apimodel.ResponseRiwayatGaji;
import com.sebasku.networks.session.SessionManager;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RiwayatGajiFragment extends Fragment {
    View v;
    private List<ResponseRiwayatGaji> listRiwayatGaji;
    private RecyclerView mRecyclerView;
    private RiwayatGajiAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_riwayat_gaji, container, false);
        listRiwayatGaji = new ArrayList<>();


        final SessionManager userPref = new SessionManager(getContext());
        String accesToken = userPref.getAccesToken();
        final String mEmail = userPref.getEmail();
        Call<List<ResponseRiwayatGaji>> call = UtilsApi.getAPIService().getAllGaji("Bearer " + accesToken);
        call.enqueue(new Callback<List<ResponseRiwayatGaji>>() {
            @Override
            public void onResponse(Call<List<ResponseRiwayatGaji>> call, Response<List<ResponseRiwayatGaji>> response) {
                Toast.makeText(getActivity(), "Sedang Get Riwayat", Toast.LENGTH_SHORT).show();
                if (response.code() == 200) {
                    List<ResponseRiwayatGaji> responsGaji = response.body();
                    for (int i = 0; i < responsGaji.size(); i++) {
                        String email = responsGaji.get(i).getEmail();
                        if (mEmail.equals(email)) {
                            String status = responsGaji.get(i).getStatus();
                            String id = responsGaji.get(i).getId();
                            String waktu = responsGaji.get(i).getWaktu();
                            String gaji = responsGaji.get(i).getGaji();
                            String createdAt = responsGaji.get(i).getCreatedAt();
                            String updatedAt = responsGaji.get(i).getUpdatedAt();
                            int v = responsGaji.get(i).getV();
                            listRiwayatGaji.add(new ResponseRiwayatGaji(status, id, email, waktu, gaji, createdAt, updatedAt, v));
                            mAdapter.notifyDataSetChanged();
                        }
                    }
                } else {
                    Toast.makeText(getActivity(), "not correct", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<ResponseRiwayatGaji>> call, Throwable t) {
                Toast.makeText(getActivity(), "Error", Toast.LENGTH_SHORT).show();
            }
        });


        mRecyclerView = v.findViewById(R.id.rv_riwayat_gaji);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mAdapter = new RiwayatGajiAdapter(getActivity(), listRiwayatGaji);
        mRecyclerView.setAdapter(mAdapter);
        return v;
    }

}