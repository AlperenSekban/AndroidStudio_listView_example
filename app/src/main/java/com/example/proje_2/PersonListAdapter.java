package com.example.proje_2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;


public class PersonListAdapter extends BaseAdapter {

    List<KisiModel> list;
    Context context;

    public PersonListAdapter(List<KisiModel> list, Context context) {
        this.list = list;
        this.context = context;
    }


    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(final int i, View view, ViewGroup viewGroup) {
        final View layout= LayoutInflater.from(context).inflate(R.layout.layout,viewGroup,false);
        final ImageView gender= layout.findViewById(R.id.listView_person_gender_imageView);
        final TextView person= layout.findViewById(R.id.listView_person_information_textView);
        final ImageView workingStatus= layout.findViewById(R.id.listView_person_workingStatus_imageView);

        gender.setImageResource(list.get(i).getGender());
        person.setText(list.get(i).getPerson());
        workingStatus.setImageResource(list.get(i).getWorkingstatus());

        workingStatus.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                ImageView workingStatus= layout.findViewById(R.id.listView_person_workingStatus_imageView);
                if(workingStatus.getDrawable().getConstantState().equals(layout.getResources().getDrawable(R.drawable.ic_action_calisiyor).getConstantState())){
                    workingStatus.setImageResource(R.drawable.ic_action_calismiyor);
                    list.get(i).setWorkingstatus(R.drawable.ic_action_calismiyor);
                }
                else if(workingStatus.getDrawable().getConstantState().equals(layout.getResources().getDrawable(R.drawable.ic_action_calismiyor).getConstantState())) {
                    workingStatus.setImageResource(R.drawable.ic_action_calisiyor);
                    list.get(i).setWorkingstatus(R.drawable.ic_action_calisiyor);

                }
            }

        });





        return layout;
    }

}
