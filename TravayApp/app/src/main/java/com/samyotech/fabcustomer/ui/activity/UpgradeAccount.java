package com.samyotech.fabcustomer.ui.activity;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.location.Address;
import android.location.Geocoder;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v4.content.FileProvider;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.cocosw.bottomsheet.BottomSheet;
import com.github.florent37.singledateandtimepicker.dialog.SingleDateAndTimePickerDialog;
import com.google.android.gms.location.places.Place;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.samyotech.fabcustomer.DTO.CategoryDTO;
import com.samyotech.fabcustomer.DTO.UserDTO;
import com.samyotech.fabcustomer.R;
import com.samyotech.fabcustomer.https.HttpsRequest;
import com.samyotech.fabcustomer.interfacess.Consts;
import com.samyotech.fabcustomer.interfacess.Helper;
import com.samyotech.fabcustomer.interfacess.OnSpinerItemClick;
import com.samyotech.fabcustomer.network.NetworkManager;
import com.samyotech.fabcustomer.preferences.SharedPrefrence;
import com.samyotech.fabcustomer.utils.CustomEditText;
import com.samyotech.fabcustomer.utils.CustomTextView;
import com.samyotech.fabcustomer.utils.ImageCompression;
import com.samyotech.fabcustomer.utils.MainFragment;
import com.samyotech.fabcustomer.utils.ProjectUtils;
import com.samyotech.fabcustomer.utils.SpinnerDialog;
import com.schibstedspain.leku.LocationPickerActivity;

import org.json.JSONObject;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Type;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

import static com.schibstedspain.leku.LocationPickerActivityKt.LATITUDE;
import static com.schibstedspain.leku.LocationPickerActivityKt.LONGITUDE;

public class UpgradeAccount extends AppCompatActivity implements View.OnClickListener , AdapterView.OnItemSelectedListener{
        private String TAG = UpgradeAccount.class.getSimpleName();
        private Context mContext;
        private SharedPrefrence prefrence;
        private UserDTO userDTO;
        private ArrayList<CategoryDTO> categoryDTOS = new ArrayList<>();
        private HashMap<String, String> parmsadd = new HashMap<>();
        private HashMap<String, String> parmsCategory = new HashMap<>();
        private ImageView ivImg, ivBack;
        private CustomEditText etCommet, etTitle, etAddress, etPrice, etDate;
        private LinearLayout llPicture, llPost;
        private CustomTextView tvCategory;
        Uri picUri;
        int PICK_FROM_CAMERA = 1, PICK_FROM_GALLERY = 2;
        int CROP_CAMERA_IMAGE = 3, CROP_GALLERY_IMAGE = 4;
        BottomSheet.Builder builder;
        String pathOfImage = "";
        Bitmap bm;
        ImageCompression imageCompression;
        private File image;
        private CardView cardview1;
        public static final int MEDIA_TYPE_VIDEO = 6;
        HashMap<String, File> parmsFile = new HashMap<>();
        private Place place;
        private SpinnerDialog spinnerDialogCate;
        SimpleDateFormat sdf1, timeZone;
        private android.widget.Spinner spinner_categorie, spinner_time_lap ;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_upgrade_account);
                mContext = UpgradeAccount.this;
                sdf1 = new SimpleDateFormat(Consts.DATE_FORMATE_SERVER, Locale.ENGLISH);
                timeZone = new SimpleDateFormat(Consts.DATE_FORMATE_TIMEZONE, Locale.ENGLISH);

                prefrence = SharedPrefrence.getInstance(mContext);
                userDTO = prefrence.getParentUser(Consts.USER_DTO);
                parmsadd.put(Consts.USER_ID, userDTO.getUser_id());
                parmsCategory.put(Consts.USER_ID, userDTO.getUser_id());

                spinner_categorie = (Spinner) findViewById(R.id.types_account);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.types_of_accounts, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner_categorie.setAdapter(adapter);
                spinner_categorie.setOnItemSelectedListener(this);

                spinner_categorie = (Spinner) findViewById(R.id.types_spinner);
                ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(this,
                        R.array.types_of_time_laps, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner_categorie.setAdapter(adapter1);
                spinner_categorie.setOnItemSelectedListener(this);

                setUiAction();
        }


        public void setUiAction() {



        }

        @Override
        public void onClick(View v) {

        }

        public void submitForm() {


                                if (NetworkManager.isConnectToInternet(mContext)) {
                                        Intent in = new Intent(mContext, PaymentProActivity.class);
//                                        in.putExtra(Consts.HISTORY_DTO, historyDTO);
                                        mContext.startActivity(in);
                                } else {
                                        ProjectUtils.showToast(mContext, getResources().getString(R.string.internet_concation));
                                }



        }


        @Override
        public void onBackPressed() {
                //super.onBackPressed();
                finish();
        }


        @Override
        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

        }

        @Override
        public void onNothingSelected(AdapterView<?> adapterView) {

        }
}
