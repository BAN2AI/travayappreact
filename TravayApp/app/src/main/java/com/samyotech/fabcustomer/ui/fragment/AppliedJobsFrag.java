package com.samyotech.fabcustomer.ui.fragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.samyotech.fabcustomer.DTO.AppliedJobDTO;
import com.samyotech.fabcustomer.DTO.UserDTO;
import com.samyotech.fabcustomer.R;
import com.samyotech.fabcustomer.https.HttpsRequest;
import com.samyotech.fabcustomer.interfacess.Consts;
import com.samyotech.fabcustomer.interfacess.Helper;
import com.samyotech.fabcustomer.network.NetworkManager;
import com.samyotech.fabcustomer.preferences.SharedPrefrence;
import com.samyotech.fabcustomer.ui.activity.BaseActivity;
import com.samyotech.fabcustomer.ui.adapter.AppliedJobAdapter;
import com.samyotech.fabcustomer.ui.adapter.AppliedJobAdapterPro;
import com.samyotech.fabcustomer.utils.CustomEditText;
import com.samyotech.fabcustomer.utils.CustomTextViewBold;
import com.samyotech.fabcustomer.utils.ProjectUtils;

import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class AppliedJobsFrag extends Fragment implements SwipeRefreshLayout.OnRefreshListener, TextWatcher {
    private View view;
    private String TAG = AppliedJobsFrag.class.getSimpleName();
    private RecyclerView RVhistorylist;
    private AppliedJobAdapterPro appliedJobAdapter;
    private ArrayList<AppliedJobDTO> appliedJobDTOSList;
    private ArrayList<AppliedJobDTO> appliedJobDTOSListSection;
    private ArrayList<AppliedJobDTO> appliedJobDTOSListSection1;
    private LinearLayoutManager mLayoutManager;
    private SharedPrefrence prefrence;
    private UserDTO userDTO;
    private CustomTextViewBold tvNo;
    private LayoutInflater myInflater;
//    private SearchView svSearch;
    private CustomEditText et_Search;
    private RelativeLayout rlSearch, rlMain;
    private SwipeRefreshLayout swipeRefreshLayout;
    private BaseActivity baseActivity;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_applied_jobs, container, false);
        prefrence = SharedPrefrence.getInstance(getActivity());
        userDTO = prefrence.getParentUser(Consts.USER_DTO);
        myInflater = LayoutInflater.from(getActivity());
        setUiAction(view);
        return view;
    }

    public void setUiAction(View v) {

        rlMain = v.findViewById(R.id.rlMain);
        swipeRefreshLayout = (SwipeRefreshLayout) v.findViewById(R.id.swipe_refresh_layout);
        rlSearch = v.findViewById(R.id.rlSearch);
//        svSearch = v.findViewById(R.id.svSearch);
        et_Search = v.findViewById(R.id.svSearch);
        tvNo = v.findViewById(R.id.tvNo);
        RVhistorylist = v.findViewById(R.id.RVhistorylist);

        if (rlSearch.getVisibility() == View.VISIBLE) {
//            baseActivity.ivSearch.setImageResource(R.drawable.ic_close_circle);
        } else {
//            baseActivity.ivSearch.setImageResource(R.drawable.ic_search_white);
        }

        mLayoutManager = new LinearLayoutManager(getActivity().getApplicationContext());
        RVhistorylist.setLayoutManager(mLayoutManager);

        et_Search.addTextChangedListener(this);
        /*svSearch.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
//                Log.e("TAG", "---------> submit");
                if (query.length() > 0) {
                    appliedJobAdapter.getFilter().filter(query.toString());

                } else {
                    Log.e("TAG", "---------> else");

                }
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {

                if (newText.length() > 0) {
                    appliedJobAdapter.getFilter().filter(newText.toString());

                } else {
                    Log.e("TAG", "---------> else");

                }
                return false;
            }
        });*/

        swipeRefreshLayout.setOnRefreshListener(this);
        swipeRefreshLayout.post(new Runnable() {
                                    @Override
                                    public void run() {
                                        Log.e("Runnable", "FIRST");
                                        if (NetworkManager.isConnectToInternet(getActivity())) {
                                            swipeRefreshLayout.setRefreshing(true);
                                            getjobs();

                                        } else {
                                            ProjectUtils.showToast(getActivity(), getResources().getString(R.string.internet_concation));
                                        }
                                    }
                                }
        );


//        baseActivity.ivSearch.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                if (NetworkManager.isConnectToInternet(getActivity())) {
//                    if (rlSearch.getVisibility() == View.VISIBLE) {
//                        ProjectUtils.hideKeyboard(getActivity());
//                        baseActivity.ivSearch.setImageResource(R.drawable.ic_search_white);
//                        rlSearch.setVisibility(View.GONE);
//                    } else {
//                        baseActivity.ivSearch.setImageResource(R.drawable.ic_close_circle);
//                        rlSearch.setVisibility(View.VISIBLE);
//
//                    }
//
//                } else {
//                    ProjectUtils.showToast(getActivity(), getString(R.string.internet_concation));
//                }
//
//
//            }
//        });

    }

    public void getjobs() {
//        ProjectUtils.showProgressDialog(getActivity(), true, getResources().getString(R.string.please_wait));
        new HttpsRequest(Consts.GET_APPLIED_JOB_ARTIST_API, getparm(), getActivity()).stringPost(TAG, new Helper() {
            @Override
            public void backResponse(boolean flag, String msg, JSONObject response) {
//                ProjectUtils.pauseProgressDialog();
                swipeRefreshLayout.setRefreshing(false);
                if (flag) {
                    tvNo.setVisibility(View.GONE);
                    RVhistorylist.setVisibility(View.VISIBLE);
                    baseActivity.ivSearch.setVisibility(View.VISIBLE);
                    try {
                        appliedJobDTOSList = new ArrayList<>();
                        Type getpetDTO = new TypeToken<List<AppliedJobDTO>>() {
                        }.getType();
                        appliedJobDTOSList = (ArrayList<AppliedJobDTO>) new Gson().fromJson(response.getJSONArray("data").toString(), getpetDTO);
                        showData();

                    } catch (Exception e) {
                        e.printStackTrace();
                    }


                } else {
                    tvNo.setVisibility(View.VISIBLE);
                    RVhistorylist.setVisibility(View.GONE);
//                    baseActivity.ivSearch.setVisibility(View.GONE);
                }
            }
        });
    }

    public HashMap<String, String> getparm() {
        HashMap<String, String> parms = new HashMap<>();
        parms.put(Consts.ARTIST_ID, userDTO.getUser_id());
        return parms;
    }

    public void showData() {
        appliedJobAdapter = new AppliedJobAdapterPro(AppliedJobsFrag.this, appliedJobDTOSList, userDTO, myInflater);
        RVhistorylist.setAdapter(appliedJobAdapter);
    }

    @Override
    public void onRefresh() {
        Log.e("ONREFREST_Firls", "FIRS");
        getjobs();
        rlSearch.setVisibility(View.GONE);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        baseActivity = (BaseActivity) activity;
    }


    public void gotos() {
        Intent in = new Intent(getActivity(), BaseActivity.class);
        in.putExtra(Consts.SCREEN_TAG, Consts.START_BOOKING_ARTIST_NOTIFICATION);
        startActivity(in);
        baseActivity.finish();

    }

    public void setSection() {
        HashMap<String, ArrayList<AppliedJobDTO>> has = new HashMap<>();
        appliedJobDTOSListSection = new ArrayList<>();
        for (int i = 0; i < appliedJobDTOSList.size(); i++) {


            if (has.containsKey(ProjectUtils.changeDateFormate1(appliedJobDTOSList.get(i).getJob_date()))) {
                appliedJobDTOSListSection1 = new ArrayList<>();
                appliedJobDTOSListSection1 = has.get(ProjectUtils.changeDateFormate1(appliedJobDTOSList.get(i).getJob_date()));
                appliedJobDTOSListSection1.add(appliedJobDTOSList.get(i));
                has.put(ProjectUtils.changeDateFormate1(appliedJobDTOSList.get(i).getJob_date()), appliedJobDTOSListSection1);


            } else {
                appliedJobDTOSListSection1 = new ArrayList<>();
                appliedJobDTOSListSection1.add(appliedJobDTOSList.get(i));
                has.put(ProjectUtils.changeDateFormate1(appliedJobDTOSList.get(i).getJob_date()), appliedJobDTOSListSection1);
            }
        }

        for (String key : has.keySet()) {
            AppliedJobDTO appliedJobDTO = new AppliedJobDTO();
            appliedJobDTO.setSection(true);
            appliedJobDTO.setSection_name(key);
            appliedJobDTOSListSection.add(appliedJobDTO);
            appliedJobDTOSListSection.addAll(has.get(key));

        }


        showData();

    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        if (s.length() > 0) {
            appliedJobAdapter.getFilter().filter(s.toString());
        } else {
            showData();
        }
    }

    @Override
    public void afterTextChanged(Editable s) {

    }
}
