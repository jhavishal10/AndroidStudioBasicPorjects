package com.example.vishaljha.adpaters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    int imagedata[]={R.drawable.binary (1),R.drawable.img2,R.drawable.img3};
    String name[]={"alpha","beta","gamma"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
            ListView listView=findViewById(R.id.lst);
        MyAdapter adp=new MyAdapter(this, R.layout.mylayout,name,imagedata);
listView.setAdapter(adp);
    }
    class MyAdapter extends  ArrayAdapter{
        int imagedata[];
        String name[];
        Context context;

        public MyAdapter(@NonNull Context context, int resource, @NonNull Object, int[] imagedata) {
            super(context,resource,Object);
            this.imagedata=imagedata;
            this.name=(String[])Object;
            this.context=context;
        }
    @Nullable
        @Override
        public View getView(int position, @Nullable View ConvertView, @Nullable ViewGroup)
        LayoutInflater l=(LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        convertView=l.inflate(R.id.MyLayout)
        ImageView imageView=convertView.
    }
}
