package com.example.vishaljha.contentprovider;

import android.app.LoaderManager;
import android.content.ContentResolver;
import android.content.CursorLoader;
import android.content.Loader;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<Cursor> {
    boolean check=false;
    Uri uri;
    ListView lv;
    String name,contact;
    ArrayList<String> al=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         lv=findViewById(R.id.lv);

        if(!check) getLoaderManager().initLoader(1,null,)

            uri = ContactsContract.CommonDataKinds.Phone.CONTENT_URI;
         name=ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME;
         contact=ContactsContract.CommonDataKinds.Phone.NUMBER;
        String[] projection={name,contact};
        ContentResolver cr=getContentResolver();
        Cursor c=cr.query(uri,projection,null,null,null);
//        if(c!=null){
//            while(c.moveToNext()){
//                String s3=c.getString(c.getColumnIndex(name));
//                String s4=c.getString(c.getColumnIndex(contact));
//                al.add(s3+"\n"+s4);
//                ArrayAdapter<String > adp=new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,al);
//                lv.setAdapter(adp);
//            }
//            c.close();
//        }
    }
    //boolean v=false;
    @Override
    public Loader<Cursor> onCreateLoader(int i, Bundle bundle) {

        String[] projection={name,contact};
        if(i==1) return new CursorLoader(getApplicationContext());
    }
    else{

    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor cursor) {

    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {

    }
}
