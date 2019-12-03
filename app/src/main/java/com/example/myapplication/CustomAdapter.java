package com.example.myapplication;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;


public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {
    private Context mContext;
    private Activity mActivity;
   private List<String> mFb;
    private AlertDialog alerta;
    private RecyclerView mRv;



    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView title;
        TextView subtitle;
        ImageButton mMainButton;
        ImageButton mSecundaryButton;


        public MyViewHolder(View itemView) {
            super(itemView);
            this.title = (TextView) itemView.findViewById(R.id.title);
           // this.subtitle = (TextView) itemView.findViewById(R.id.subtitle);
           // this.mMainButton = (ImageButton) itemView.findViewById(R.id.deletar);
           // this.mSecundaryButton = (ImageButton) itemView.findViewById(R.id.editar);

        }
    }

    public CustomAdapter(RecyclerView mRv, Context mContext, Activity mActivity, ArrayList<String> fb) {

        this.mContext = mContext;
        this.mFb = fb;
        this.mActivity = mActivity;
        this.mRv = mRv;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.lista_fabricante, parent, false);

        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int i) {


        holder.title.setText(mFb.get(i));
    }
//        holder.subtitle.setText(mFb.get(i).getAnoFundacao().toString());
//        holder.mMainButton.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View v) {
//
//                caixaDialog(mFb.get(i), i);
//            }
//        });
//
//        holder.mSecundaryButton.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View v) {
//                Bundle bundle = new Bundle();
//                bundle.putInt("id", mFb.get(i).getId());
//                bundle.putInt("index", i);
//
//                Navigation.findNavController(mActivity, R.id.nav_host_fragment).navigate(R.id.nav_editar, bundle);
//            }
//        });
//
//
//    }
//
    @Override
   public int getItemCount() {
        return mFb.size();
    }
//
//    public void caixaDialog(final Fabricante fabricante, final Integer index) {
//        AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
//
//
//        builder.setTitle(fabricante.getNome());
//        //define a mensagem
//        builder.setMessage("Deseja apagar este Fabricante ?");
//        //define um botão como positivo
//        builder.setPositiveButton("SIM", new DialogInterface.OnClickListener() {
//            public void onClick(DialogInterface arg0, int arg1) {
//
//                Response<?> response = new ControlFabricante().delete(fabricante.getId());
//                Toast.makeText(mContext, response.getMessage(), Toast.LENGTH_SHORT).show();
//                if (response.getStatus().equals("OK")) {
//                    removeAt(index);
//                }
//                // Toast.makeText(mContext, "Deletado" , Toast.LENGTH_SHORT).show();
//            }
//        });
//        //define um botão como negativo.
//        builder.setNegativeButton("Não", new DialogInterface.OnClickListener() {
//            public void onClick(DialogInterface arg0, int arg1) {
//                Toast.makeText(mContext, "Cancelado", Toast.LENGTH_SHORT).show();
//
//            }
//        });
//
//
//        alerta = builder.create();
//
//        alerta.show();
//    }
//
//    public void removeAt(int position) {
//        mFb.remove(position);
//        notifyItemRemoved(position);
//        notifyItemRangeChanged(position, mFb.size());
//    }
//
//    public void setData(List<Fabricante> lista) {
//        mFb = lista;
//        notifyDataSetChanged();
//    }

}