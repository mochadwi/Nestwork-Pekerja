package com.sebasku.networks.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.sebasku.networks.R;
import com.sebasku.networks.activity.DetailGajiActivity;
import com.sebasku.networks.model.RiwayatGaji;

import java.util.LinkedList;

/**
 * Created by fadil on 3/19/18.
 */

public class RiwayatGajiAdapter extends RecyclerView.Adapter<RiwayatGajiAdapter.ListGajiViewHolder> {
    private LinkedList<RiwayatGaji> listGaji;
    //deklarasi global variabel
    private Context context;

    //konstruktor untuk menerima data adapter
    public RiwayatGajiAdapter(Context context, LinkedList<RiwayatGaji> listGaji) {
        this.context = context;
        this.listGaji = listGaji;
    }

    //view holder berfungsi untuk setting list item yang digunakan
    @Override
    public ListGajiViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View mItemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_gaji, null, false);

        RecyclerView.LayoutParams layoutParams = new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        mItemView.setLayoutParams(layoutParams);

        return new ListGajiViewHolder(mItemView, this);
    }

    //bind view holder berfungsi untuk set data ke view yang ditampilkan pada list item
    @Override
    public void onBindViewHolder(ListGajiViewHolder holder, int position) {
        final RiwayatGaji mCurrent = listGaji.get(position);
        holder.sesi.setText(mCurrent.getSesi());
        holder.btnDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i =new Intent(context, DetailGajiActivity.class);
                i.putExtra("sesi",mCurrent.getSesi());
                i.putExtra("nama",mCurrent.getNama());
                i.putExtra("posisi",mCurrent.getPosisi());
                i.putExtra("task",mCurrent.getJumlahTask());
                i.putExtra("gaji",mCurrent.getTotalGaji());
                context.startActivity(new Intent(i));
            }
        });
    }

    //untuk menghitung jumlah data yang ada pada list
    @Override
    public int getItemCount() {
        return listGaji.size();
    }

    public class ListGajiViewHolder extends RecyclerView.ViewHolder {
        final RiwayatGajiAdapter mAdapter;
        private TextView sesi;
        private TextView totalGaji;
        private TextView jumlahTask;
        private TextView posisi;
        private CardView cdView;
        private TextView nama;
        private Button btnDetail;

        //untuk casting view yang digunakan pada list item
        public ListGajiViewHolder(View itemView, RiwayatGajiAdapter adapter) {
            super(itemView);
            context = itemView.getContext();
            sesi = itemView.findViewById(R.id.tv_info_sesi);
            totalGaji = itemView.findViewById(R.id.tv_akhir_cuti);
            jumlahTask = itemView.findViewById(R.id.tv_jum_task);
            posisi = itemView.findViewById(R.id.tv_posisi);
            nama = itemView.findViewById(R.id.tv_nama);
            cdView = itemView.findViewById(R.id.cd_view);
            btnDetail = itemView.findViewById(R.id.btn_detail);
            this.mAdapter = adapter;
            //itemView.setOnClickListener(this);
        }
    }
}
