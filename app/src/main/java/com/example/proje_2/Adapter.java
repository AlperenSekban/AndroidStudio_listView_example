package com.example.proje_2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.tanimla> {

    Context context;
    List<KisiModel> list;

    public Adapter(Context context, List<KisiModel> list) {
        this.context = context;
        this.list = list;
    }


    @NonNull
    @Override
    public tanimla onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.layout, parent, false);
        return new tanimla(view);
    }

    @Override
    public void onBindViewHolder(@NonNull tanimla holder, int position) {

        holder.gender.setImageResource(list.get(position).getGender());
        holder.person.setText(list.get(position).getPerson());
        holder.workingStatus.setImageResource(list.get(position).getWorkingstatus());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class tanimla extends RecyclerView.ViewHolder {
        final ImageView gender;
        final TextView person;
        final ImageView workingStatus;


        public tanimla(@NonNull View itemView) {
            super(itemView);
            gender = itemView.findViewById(R.id.listView_person_gender_imageView);
            person = itemView.findViewById(R.id.listView_person_information_textView);
            workingStatus = itemView.findViewById(R.id.listView_person_workingStatus_imageView);
        }
    }
}
