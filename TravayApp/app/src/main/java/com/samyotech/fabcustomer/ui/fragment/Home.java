package com.samyotech.fabcustomer.ui.fragment;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.samyotech.fabcustomer.R;
import com.samyotech.fabcustomer.ui.activity.BaseActivity;
import com.samyotech.fabcustomer.ui.activity.BaseActivity1;
import com.samyotech.fabcustomer.utils.CustomTextView;


public class Home extends Fragment implements View.OnClickListener{
    private View view;
    private BaseActivity baseActivity;
    private FragmentManager fragmentManager;
    private DiscoverFragment discoverFragment = new DiscoverFragment();
    private AllJobsFrag allJobsFrag = new AllJobsFrag();
    private CustomTextView CTVdiscover, CTVnearby;
    private BaseActivity1 baseActivity1;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_home, container, false);
//        baseActivity.headerNameTV.setText(getResources().getString(R.string.fabartist));
        fragmentManager = getChildFragmentManager();
        CTVnearby = (CustomTextView) view.findViewById(R.id.CTVnearby);
        CTVdiscover = (CustomTextView) view.findViewById(R.id.CTVdiscover);

        CTVdiscover.setOnClickListener(this);
        CTVnearby.setOnClickListener(this);

        fragmentManager.beginTransaction().add(R.id.frame, discoverFragment).commit();

        return view;
    }
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

//        baseActivity = (BaseActivity) activity;


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.CTVdiscover:
                setSelected(true, false);
                fragmentManager.beginTransaction().replace(R.id.frame, discoverFragment).commit();
                break;
            case R.id.CTVnearby:
                setSelected(false, true);
                fragmentManager.beginTransaction().replace(R.id.frame, allJobsFrag).commit();
                break;
        }

    }

    public void setSelected(boolean firstBTN, boolean secondBTN) {
        if (firstBTN) {
            CTVdiscover.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
            CTVdiscover.setTextColor(getResources().getColor(R.color.white));
            CTVnearby.setBackgroundColor(getResources().getColor(R.color.white));
            CTVnearby.setTextColor(getResources().getColor(R.color.gray));
        }
        if (secondBTN) {
            CTVdiscover.setBackgroundColor(getResources().getColor(R.color.white));
            CTVdiscover.setTextColor(getResources().getColor(R.color.gray));
            CTVnearby.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
            CTVnearby.setTextColor(getResources().getColor(R.color.white));


        }
        CTVdiscover.setSelected(firstBTN);
        CTVnearby.setSelected(secondBTN);
    }
}
