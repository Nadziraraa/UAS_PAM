package com.example.belanjaanku.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupMenu;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.belanjaanku.BarangActivity;
import com.example.belanjaanku.Database.Barang;
import com.example.belanjaanku.Database.DBController;
import com.example.belanjaanku.EditDataActivity;
import com.example.belanjaanku.R;

import java.util.ArrayList;

//class BarangAdapter yang merupakan tururnan ddari RecycylerView dari layout activity_barang
public class BarangAdapter extends RecyclerView.Adapter<BarangAdapter.BarangViewHolder> {
    private ArrayList<Barang> listData;
    private Context C;

    public BarangAdapter(ArrayList<Barang> listData) {
        this.listData = listData;}


    @Override
    public BarangViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        C = parent.getContext();
        LayoutInflater layoutInf = LayoutInflater.from(parent.getContext());
        View view = layoutInf.inflate(R.layout.row_data_barang,parent, false);
        return new BarangViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BarangViewHolder holder, int position) {
        String nm,jml,hrg;


        nm = listData.get(position).getNama();
        jml = listData.get(position).getJumlah();
        hrg = listData.get(position).getHarga();

        DBController db = new DBController(C);

        holder.namaTxt.setText(nm);
        holder.jumlahTxt.setText(jml);
        holder.cardku.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // munculin popup

                showpopupmenu(v, nm, jml, hrg, position);
            }
        });
    }


    private void showpopupmenu(View view, String nm, String jml, String hrg, int position) {
        PopupMenu popup = new PopupMenu(view.getContext().getApplicationContext(), view);
        MenuInflater inflater = popup.getMenuInflater();

        //inflate menu items to popup menu
        inflater.inflate(R.menu.popup_menu, popup.getMenu());

        popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {


                int itemId = item.getItemId();
                if (itemId == R.id.mnview) {
                    // tampilkan menu view
                    Intent intent = new Intent(view.getContext(), BarangActivity.class);
                    intent.putExtra("nama", nm);
                    intent.putExtra("jumlah", jml);
                    intent.putExtra("harga", hrg);
                    view.getContext().startActivity(intent);

                } else if (itemId == R.id.mnedit) {

                    // tampilkan menu edit
                    Intent intent = new Intent(view.getContext(), EditDataActivity.class);
                    intent.putExtra("nama", nm);
                    intent.putExtra("jumlah", jml);
                    intent.putExtra("harga", hrg);
                    view.getContext().startActivity(intent);

                }

                return false;
            }
        });
        popup.show();
    }

    //membuaut method untuk mengambil harga yang sudah terjumlah ketika user memasuki jumlah dan harga
    @Override
    public int getItemCount() {
        return (listData != null)?listData.size() : 0;
    }


    public class BarangViewHolder extends RecyclerView.ViewHolder {
        private CardView cardku;
        private TextView namaTxt,jumlahTxt;
        public BarangViewHolder(View view) {
            super(view);
            cardku = (CardView) view.findViewById(R.id.kartuku);
            namaTxt = (TextView) view.findViewById(R.id.textNama);
            jumlahTxt = (TextView) view.findViewById(R.id.textHarga);
        }
    }
}

