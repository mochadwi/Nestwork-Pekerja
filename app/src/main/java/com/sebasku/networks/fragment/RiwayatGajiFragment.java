package com.sebasku.networks.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.sebasku.networks.R;
import com.sebasku.networks.adapter.RiwayatGajiAdapter;
import com.sebasku.networks.model.RiwayatGaji;

import java.util.LinkedList;

public class RiwayatGajiFragment extends Fragment {
    View viewRiwayatGaji;
    Button btnDetail;
    private final LinkedList<RiwayatGaji> listRiwayatGaji = new LinkedList<>();
    private RecyclerView mRecyclerView;
    private RiwayatGajiAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        viewRiwayatGaji = inflater.inflate(R.layout.fragment_riwayat_gaji, container, false);
        btnDetail = viewRiwayatGaji.findViewById(R.id.btn_detail);
        listRiwayatGaji.addLast(new RiwayatGaji("M Farid Padilah", "Android Developer", "8","Rp. 1.600.000","JAN SESI 1"));
        listRiwayatGaji.addLast(new RiwayatGaji("M Adam Dzulqarnain", "Android Developer", "8","Rp. 1.600.000","JAN SESI 1"));
        mRecyclerView = viewRiwayatGaji.findViewById(R.id.rv_riwayat_gaji);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mAdapter = new RiwayatGajiAdapter(getActivity(),listRiwayatGaji);
        mRecyclerView.setAdapter(mAdapter);
        return viewRiwayatGaji;
    }
}