package com.kkskysite.ongloballayout;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {
    boolean pm,con,et,iec;
    String TAG = this.getClass().getName();
    LinearLayout pm_layout,contractor_layout,et_layout,iec_layout;
    RelativeLayout pmSign,contractorSign,etSign,iecSign;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test);
        postDelay();

        pm=con=et=iec = true;

    }
    public void initView(){

        pmSign = (RelativeLayout) findViewById(R.id.pm_sign);
        contractorSign = (RelativeLayout) findViewById(R.id.contractor_sign);
        etSign = (RelativeLayout) findViewById(R.id.et_sign);
        iecSign = (RelativeLayout) findViewById(R.id.iec_sign);
        pm_layout = (LinearLayout) findViewById(R.id.pm_layout);
        contractor_layout = (LinearLayout) findViewById(R.id.contractor_layout);
        et_layout = (LinearLayout) findViewById(R.id.et_layout);
        iec_layout = (LinearLayout) findViewById(R.id.iec_layout);
        pm_layout.setVisibility(View.GONE);
        contractor_layout.setVisibility(View.GONE);
        et_layout.setVisibility(View.GONE);
        iec_layout.setVisibility(View.GONE);
    }

    private void setSignShow_02() {
        if (pm) {
            pm_layout.setVisibility(View.VISIBLE);
            pmSign.setVisibility(View.VISIBLE);
//            pmSign.getViewTreeObserver();
            outputWidthHeight(pmSign);
        }

        if (con) {
            contractor_layout.setVisibility(View.VISIBLE);
            contractorSign.setVisibility(View.VISIBLE);
            outputWidthHeight(contractorSign);
        }
        if (et) {
            et_layout.setVisibility(View.VISIBLE);
            etSign.setVisibility(View.VISIBLE);
            outputWidthHeight(etSign);
        }
        if (true) {
            iec_layout.setVisibility(View.VISIBLE);
            iecSign.setVisibility(View.VISIBLE);
            outputWidthHeight(iecSign);
        }
//        addOnGlobalLayoutListener_02();
    }

    public void addOnGlobalLayoutListener_02(){
        Log.i(TAG, "addOnGlobalLayoutListener_02: ");
        ViewTreeObserver vto1 = pmSign.getViewTreeObserver();
        vto1.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void onGlobalLayout() {
                pmSign.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                Log.i(TAG, "pmSign.getWidth(): " + pmSign.getWidth() + " pmSign.getHeight(): " + pmSign.getHeight());
            }
        });
        ViewTreeObserver vto2 = contractorSign.getViewTreeObserver();
        vto2.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                contractorSign.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                Log.i(TAG, "contractorSign.getWidth(): " + contractorSign.getWidth() + " contractorSign.getHeight(): " + contractorSign.getHeight());
            }
        });
        ViewTreeObserver vto3 = etSign.getViewTreeObserver();
        vto3.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                etSign.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                Log.i(TAG, "etSign.getWidth(): " + etSign.getWidth() + " etSign.getHeight(): " + etSign.getHeight());
            }
        });

        ViewTreeObserver vto4 = iecSign.getViewTreeObserver();
        vto4.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                iecSign.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                Log.i(TAG, "iecSign.getWidth(): " + iecSign.getWidth() + " iecSign.getHeight(): " + iecSign.getHeight());
            }
        });

    }

    public void outputWidthHeight (RelativeLayout relativeLayout){
        Log.i(TAG, "outputWidthHeight: width: "+relativeLayout.getWidth()+" height: "+relativeLayout.getHeight());
    }

    public void postDelay() {
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                initView();
                addOnGlobalLayoutListener_02();
                setSignShow_02();
            }
        },5000);
    }
}
