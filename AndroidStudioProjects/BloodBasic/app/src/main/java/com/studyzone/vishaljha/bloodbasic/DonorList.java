package com.studyzone.vishaljha.bloodbasic;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import java.util.List;

public class DonorList extends ArrayAdapter<Request> {
    private Activity context;
    private List<Request> donorList;
    public DonorList(Activity context ,List<Request> donorList){
        super(context, R.layout.list_donors,donorList);
        this.context=context;
        this.donorList=donorList;
    }
    @NonNull
    @Override
    public View getView(int position , View convertView , ViewGroup parent){
        LayoutInflater inflater=context.getLayoutInflater();
        View listViewItem=inflater.inflate(R.layout.list_donors,null,true);
        TextView textViewName=(TextView) listViewItem.findViewById(R.id.textViewName);
        TextView textViewBG=(TextView) listViewItem.findViewById(R.id.textViewBG);
        Request request=donorList.get(position);
        textViewName.setText(request.getRequestName());
        textViewBG.setText(request.getRequestBloodGroup());
        return listViewItem;
    }

}
