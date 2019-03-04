package com.example.vishaljha.fraga;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import java.util.zip.Inflater;

public class fragA extends ListFragment{
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v= inflater.inflate(R.layout.mylayout,null);
        ArrayAdapter adp=ArrayAdapter.createFromResource(getActivity(),R.array.mydata,android.R.layout.simple_list_item_1);
                setListAdapter(adp);
            return v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        getListView().setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getActivity(),adapterView.getItemAtPosition(i)+"is clicked",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
