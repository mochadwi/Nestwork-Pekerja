package com.sebasku.networks.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.sebasku.networks.R;
import com.sebasku.networks.api.UtilsApi;
import com.sebasku.networks.apimodel.ResponseRiwayatCuti;
import com.sebasku.networks.model.RiwayatCuti;

import java.util.LinkedList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RiwayatCutiFragment extends Fragment {
    private final LinkedList<RiwayatCuti> listRiwayatCuti = new LinkedList<>();
/*
    private RecyclerView mRecyclerView;
    private RiwayatCutiAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;*/
    View viewRiwayatCuti;
    ResponseRiwayatCuti responRiwayat;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        viewRiwayatCuti  = inflater.inflate(R.layout.fragment_riwayat_cuti, container, false);
//        listRiwayatCuti.addLast(new RiwayatCuti("15 januari 2018", "20 februari 2018","Umroh"));
//        listRiwayatCuti.addLast(new RiwayatCuti("28 januari 2018", "13 februari 2018","Nikah"));
//        listRiwayatCuti.addLast(new RiwayatCuti("13 januari 2018", "17 februari 2018","Berobat"));
//        listRiwayatCuti.addLast(new RiwayatCuti("2 januari 2018", "1 februari 2018","Change Study"));
//        listRiwayatCuti.addLast(new RiwayatCuti("25 januari 2018", "12 februari 2018","UAS"));
//        mRecyclerView = viewRiwayatCuti.findViewById(R.id.rv_riwayat_cuti);
//        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
//        mAdapter = new RiwayatCutiAdapter(getActivity(),listRiwayatCuti);
//        mRecyclerView.setAdapter(mAdapter);
        String emailCuti = "luthfi@gmail.com";
        String auth = "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJleHAiOjE1MjM4NDQwMzMsImlhdCI6MTUyMzI0NDAzMywic3ViIjoiNWFjOGI3M2JhMzY2OTQxMTk2YjE1ZDRkIn0.knqD-vUF6LGHbcBtVzc3AVCwepG9YU3WvSNE6Tq3F90";
        getOneCuti(auth,emailCuti);
        return viewRiwayatCuti;
    }

    private void getOneCuti(String auth,String emailCuti) {

        Call<ResponseRiwayatCuti> call = UtilsApi.getAPIService().getOneCuti(auth, emailCuti);

        call.enqueue(new Callback<ResponseRiwayatCuti>() {
            @Override
            public void onResponse(Call<ResponseRiwayatCuti> call, Response<ResponseRiwayatCuti> response) {
                if (response.isSuccessful()) {
                    Toast.makeText(getContext(), "", Toast.LENGTH_LONG).show();

                } else {
                    Toast.makeText(getContext(), "check your Email or Password", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ResponseRiwayatCuti> call, Throwable t) {
                Toast.makeText(getContext(), "Koneksi internet bermasalah", Toast.LENGTH_SHORT).show();
            }
        });
    }
}

