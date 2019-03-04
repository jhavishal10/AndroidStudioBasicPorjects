package com.example.vishaljha.menuapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
PopupMenu popupMenu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       setContentView(R.layout.activity_main);
        //Button button=findViewById(R.id.btn1);
        TextView tv=findViewById(R.id.txtv);
        registerForContextMenu(tv);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater m=getMenuInflater();
        m.inflate(R.menu.mymenu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId()==R.id.item1)
            Toast.makeText(MainActivity.this,item.getTitle()+"clciked",Toast.LENGTH_SHORT).show();
        else if(item.getItemId()==R.id.item2)
            Toast.makeText(MainActivity.this,item.getTitle()+"clciked",Toast.LENGTH_SHORT).show();
        else if(item.getItemId()==R.id.item3)
            Toast.makeText(MainActivity.this,item.getTitle()+"clciked",Toast.LENGTH_SHORT).show();
        return true;
    }
    public void fun(View v){
        popupMenu=new PopupMenu(this,v);
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.mymenu,popupMenu.getMenu());
        popupMenu.show();
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                if(menuItem.getItemId()==R.id.item1)
                    Toast.makeText(MainActivity.this, menuItem.getTitle()+"clicked",Toast.LENGTH_LONG).show();
                else if(menuItem.getItemId()==R.id.item2)
                    Toast.makeText(MainActivity.this, menuItem.getTitle()+"clicked",Toast.LENGTH_LONG).show();
                else if(menuItem.getItemId()==R.id.item3)
                    Toast.makeText(MainActivity.this, menuItem.getTitle()+"clicked",Toast.LENGTH_LONG).show();
                return true;
            }
        });
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        MenuInflater inflater =getMenuInflater();
        inflater.inflate(R.menu.mymenu,menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        if(item.getItemId()==R.id.item1)
            Toast.makeText(MainActivity.this,item.getTitle()+"clciked",Toast.LENGTH_LONG).show();
        else if(item.getItemId()==R.id.item2)
            Toast.makeText(MainActivity.this,item.getTitle()+"clciked",Toast.LENGTH_LONG).show();
        else if(item.getItemId()==R.id.item3)
            Toast.makeText(MainActivity.this,item.getTitle()+"clciked",Toast.LENGTH_LONG).show();

        return true;
    }
}
