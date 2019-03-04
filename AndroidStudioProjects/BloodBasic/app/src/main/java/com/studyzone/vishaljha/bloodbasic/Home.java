package com.studyzone.vishaljha.bloodbasic;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.AdaptiveIconDrawable;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;


/**
 * A simple {@link Fragment} subclass.
 */
public class Home extends Fragment {
    Spinner spinner;
    Toolbar toolbar;
    private InterstitialAd mInterstitialAd;
    LayoutInflater inflater;

    Context context=getActivity();
    View RootView;

    public Home() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        RootView = inflater.inflate(R.layout.fragment_home, container, false);
        MobileAds.initialize(getActivity(), "ca-app-pub-5279308997145044~5324320937");



        mInterstitialAd = new InterstitialAd(getActivity());
        mInterstitialAd.setAdUnitId("ca-app-pub-5279308997145044/1472528227");
        mInterstitialAd.loadAd(new AdRequest.Builder().build());
        mInterstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdClosed() {
                // Load the next interstitial.
                mInterstitialAd.loadAd(new AdRequest.Builder().build());
            }

        });

        View RootView = inflater.inflate(R.layout.fragment_home, container, false);
         toolbar = (Toolbar)RootView.findViewById(R.id.toolbar);
        TextView expandedTitle = (TextView)RootView.findViewById(R.id.titleCollapsing);
        CollapsingToolbarLayout collapsingToolbarLayout = (CollapsingToolbarLayout) RootView.findViewById(R.id.toolbar_layout);
        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);
        collapsingToolbarLayout.setTitle("Blood Donation");
        expandedTitle.setText("Blood Donation");
        Button Chart=(Button)RootView.findViewById(R.id.Chart);
        Button Donation=(Button)RootView.findViewById(R.id.Donation);
        Button Request=(Button)RootView.findViewById(R.id.Request);
        Request.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // Toast.makeText(context, "Request button", Toast.LENGTH_SHORT).show();
                Intent in =new Intent(getActivity(),RequestActivity.class);
                startActivity(in);
            }
        });
        Chart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mInterstitialAd.isLoaded()) {
                    mInterstitialAd.show();
                } else {
                    Log.d("TAG", "The interstitial wasn't loaded yet.");
                }
                Intent i =new Intent(getActivity(),BloodChart.class);
                startActivity(i);
            }
        });
        Donation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mInterstitialAd.isLoaded()) {
                    mInterstitialAd.show();
                } else {
                    Log.d("TAG", "The interstitial wasn't loaded yet.");
                }
                Intent i =new Intent(getActivity(),Donation.class);
                startActivity(i);
            }
        });

        spinner=(Spinner) RootView.findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter=ArrayAdapter.createFromResource(getContext(),R.array.BloodGroup, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 1: {
                        if (mInterstitialAd.isLoaded()) {
                            mInterstitialAd.show();
                        } else {
                            Log.d("TAG", "The interstitial wasn't loaded yet.");
                        }
                        Intent intent = new Intent(getActivity(), Donation.class);
                        startActivity(intent);
                        break;
                    }
                    case 2: {
                        if (mInterstitialAd.isLoaded()) {
                            mInterstitialAd.show();
                        } else {
                            Log.d("TAG", "The interstitial wasn't loaded yet.");
                        }
                        Intent intent = new Intent(getActivity(), Donation.class);
                        startActivity(intent);
                        break;
                    }
                    case 3: {
                        if (mInterstitialAd.isLoaded()) {
                            mInterstitialAd.show();
                        } else {
                            Log.d("TAG", "The interstitial wasn't loaded yet.");
                        }
                        Intent intent = new Intent(getActivity(), Donation.class);
                        startActivity(intent);
                        break;
                    }
                    case 4: {
                        if (mInterstitialAd.isLoaded()) {
                            mInterstitialAd.show();
                        } else {
                            Log.d("TAG", "The interstitial wasn't loaded yet.");
                        }
                        Intent intent = new Intent(getActivity(), Donation.class);
                        startActivity(intent);
                        break;
                    }
                    case 5: {
                        if (mInterstitialAd.isLoaded()) {
                            mInterstitialAd.show();
                        } else {
                            Log.d("TAG", "The interstitial wasn't loaded yet.");
                        }
                        Intent intent = new Intent(getActivity(), Donation.class);
                        startActivity(intent);
                        break;
                    }
                    case 6: {
                        if (mInterstitialAd.isLoaded()) {
                            mInterstitialAd.show();
                        } else {
                            Log.d("TAG", "The interstitial wasn't loaded yet.");
                        }
                        Intent intent = new Intent(getActivity(), Donation.class);
                        startActivity(intent);
                        break;
                    }
                    case 7: {
                        if (mInterstitialAd.isLoaded()) {
                            mInterstitialAd.show();
                        } else {
                            Log.d("TAG", "The interstitial wasn't loaded yet.");
                        }
                        Intent intent = new Intent(getActivity(), Donation.class);
                        startActivity(intent);
                        break;
                    }
                    case 8: {
                        if (mInterstitialAd.isLoaded()) {
                            mInterstitialAd.show();
                        } else {
                            Log.d("TAG", "The interstitial wasn't loaded yet.");
                        }
                        Intent intent = new Intent(getActivity(), Donation.class);
                        startActivity(intent);
                        break;
                    }
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        // Inflate the layout for this fragment
        return RootView;
    }
//    public void onCheck (View v){
//        LayoutInflater inflater=getLayoutInflater();
//        ViewGroup container=;
//        v=inflater.inflate(R.layout.fragment_home,container,false);
//        spinner=v.findViewById(R.id.spinner);
//    }

}
