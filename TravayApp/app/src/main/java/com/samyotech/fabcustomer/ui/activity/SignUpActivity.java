package com.samyotech.fabcustomer.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.databinding.DataBindingUtil;
import android.media.Image;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.text.InputType;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Spinner;

import com.samyotech.fabcustomer.DTO.UserDTO;
import com.samyotech.fabcustomer.R;
import com.samyotech.fabcustomer.databinding.ActivitySignUpBinding;
import com.samyotech.fabcustomer.https.HttpsRequest;
import com.samyotech.fabcustomer.interfacess.Consts;
import com.samyotech.fabcustomer.interfacess.Helper;
import com.samyotech.fabcustomer.network.NetworkManager;
import com.samyotech.fabcustomer.preferences.SharedPrefrence;
import com.samyotech.fabcustomer.utils.CustomButton;
import com.samyotech.fabcustomer.utils.CustomEditText;
import com.samyotech.fabcustomer.utils.CustomTextView;
import com.samyotech.fabcustomer.utils.CustomTextViewBold;
import com.samyotech.fabcustomer.utils.ProjectUtils;

import org.json.JSONObject;

import java.util.HashMap;

public class SignUpActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemSelectedListener {

    private Context mContext;
    private String TAG = SignUpActivity.class.getSimpleName();
    private SharedPrefrence prefrence;
    private UserDTO userDTO;
    private SharedPreferences firebase;
    private boolean isHide = false;
    private ActivitySignUpBinding binding;
    private android.widget.Spinner spinner ;
    private String user_type;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ProjectUtils.Fullscreen(SignUpActivity.this);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_sign_up);
        mContext = SignUpActivity.this;
        prefrence = SharedPrefrence.getInstance(mContext);
        firebase = getSharedPreferences("MyPrefs", MODE_PRIVATE);
        Log.e("tokensss", firebase.getString(Consts.DEVICE_TOKEN, ""));
        setUiAction();
        spinner = (Spinner) findViewById(R.id.types_spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.types_of_accounts, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

    }

    public void setUiAction() {
        binding.CBsignup.setOnClickListener(this);
        binding.CTVsignin.setOnClickListener(this);
        binding.tvTerms.setOnClickListener(this);
        binding.tvPrivacy.setOnClickListener(this);
        binding.ivReEnterShow.setOnClickListener(this);
        binding.ivEnterShow.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.CBsignup:
                clickForSubmit();
                break;
            case R.id.CTVsignin:
                startActivity(new Intent(mContext, SignInActivity.class));
                finish();
                break;
            case R.id.tvTerms:
                startActivity(new Intent(mContext, Terms.class));
                break;
            case R.id.tvPrivacy:
                startActivity(new Intent(mContext, Privacy.class));
                break;
            case R.id.ivEnterShow:
                if (isHide) {
                    binding.ivEnterShow.setImageResource(R.drawable.ic_pass_visible);
                    binding.CETenterpassword.setTransformationMethod(null);
                    binding.CETenterpassword.setSelection(binding.CETenterpassword.getText().length());
                    isHide = false;
                } else {
                    binding.ivEnterShow.setImageResource(R.drawable.ic_pass_invisible);
                    binding.CETenterpassword.setTransformationMethod(PasswordTransformationMethod.getInstance());
                    binding.CETenterpassword.setSelection(binding.CETenterpassword.getText().length());
                    isHide = true;
                }
                break;
            case R.id.ivReEnterShow:
                if (isHide) {
                    binding.ivReEnterShow.setImageResource(R.drawable.ic_pass_visible);
                    binding.CETenterpassagain.setTransformationMethod(null);
                    binding.CETenterpassagain.setSelection(binding.CETenterpassagain.getText().length());
                    isHide = false;
                } else {
                    binding.ivReEnterShow.setImageResource(R.drawable.ic_pass_invisible);
                    binding.CETenterpassagain.setTransformationMethod(PasswordTransformationMethod.getInstance());
                    binding.CETenterpassagain.setSelection(binding.CETenterpassagain.getText().length());
                    isHide = true;
                }
                break;

        }

    }

    public void register() {
        ProjectUtils.showProgressDialog(mContext, true, getResources().getString(R.string.please_wait));
        new HttpsRequest(Consts.REGISTER_API, getparm(), mContext).stringPost(TAG, new Helper() {
            @Override
            public void backResponse(boolean flag, String msg, JSONObject response) {
                ProjectUtils.pauseProgressDialog();
                if (flag) {
                    try {
                        ProjectUtils.showToast(mContext, msg);

                        startActivity(new Intent(mContext, SignInActivity.class));
                        finish();
                        overridePendingTransition(R.anim.anim_slide_in_left,
                                R.anim.anim_slide_out_left);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                } else {
                    ProjectUtils.showToast(mContext, msg);
                }


            }
        });
    }

    public void clickForSubmit() {
        if (!validation(binding.CETfirstname, getResources().getString(R.string.val_name))) {
            return;
        } else if (!ProjectUtils.isEmailValid(binding.CETemailadd.getText().toString().trim())) {
            showSickbar(getResources().getString(R.string.val_email));
        } else if (!ProjectUtils.isPasswordValid(binding.CETenterpassword.getText().toString().trim())) {
            showSickbar(getResources().getString(R.string.val_pass));
        } else if (!checkpass()) {
            return;
        } else if (!validateTerms()) {
            return;
        } else {
            if (NetworkManager.isConnectToInternet(mContext)) {
                register();
            } else {
                ProjectUtils.showToast(mContext, getResources().getString(R.string.internet_concation));
            }
        }


    }

    private boolean checkpass() {
        if (binding.CETenterpassword.getText().toString().trim().equals("")) {
            showSickbar(getResources().getString(R.string.val_pass));
            return false;
        } else if (binding.CETenterpassagain.getText().toString().trim().equals("")) {
            showSickbar(getResources().getString(R.string.val_pass1));
            return false;
        } else if (!binding.CETenterpassword.getText().toString().trim().equals(binding.CETenterpassagain.getText().toString().trim())) {
            showSickbar(getResources().getString(R.string.pass_not_match));
            return false;
        }
        return true;
    }

    private boolean validateTerms() {
        if (binding.termsCB.isChecked()) {
            return true;
        } else {
            showSickbar(getResources().getString(R.string.trms_acc));
            return false;
        }
    }

    public HashMap<String, String> getparm() {
        HashMap<String, String> parms = new HashMap<>();
        parms.put(Consts.NAME, ProjectUtils.getEditTextValue(binding.CETfirstname));
        parms.put(Consts.EMAIL_ID, ProjectUtils.getEditTextValue(binding.CETemailadd));
        parms.put(Consts.PASSWORD, ProjectUtils.getEditTextValue(binding.CETenterpassword));
        parms.put(Consts.ROLE, "2");
        parms.put(Consts.DEVICE_TYPE, "ANDROID");
        parms.put(Consts.DEVICE_TOKEN, firebase.getString(Consts.DEVICE_TOKEN, ""));
        parms.put(Consts.DEVICE_ID, "12345");
        parms.put(Consts.REFERRAL_CODE, ProjectUtils.getEditTextValue(binding.etReferal));
        Log.e(TAG, parms.toString());
        return parms;
    }

    public void showSickbar(String msg) {
        Snackbar snackbar = Snackbar.make(binding.RRsncbar, msg, Snackbar.LENGTH_LONG);
        View snackbarView = snackbar.getView();
        snackbarView.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
        snackbar.show();
    }

    public boolean validation(EditText editText, String msg) {
        if (!ProjectUtils.isEditTextFilled(editText)) {
            Snackbar snackbar = Snackbar.make(binding.RRsncbar, msg, Snackbar.LENGTH_LONG);
            View snackbarView = snackbar.getView();
            snackbarView.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
            snackbar.show();
            return false;
        } else {
            return true;
        }
    }

    @Override
    public void onBackPressed() {
        // super.onBackPressed();
        startActivity(new Intent(mContext, SignInActivity.class));
        finish();
    }


    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        System.out.println(adapterView.getItemAtPosition(i).toString());
        if (i > 0) {
            user_type = String.valueOf(i);
        }

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
