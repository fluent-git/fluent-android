package com.fluent.fragment;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.view.Window;

import com.fluent.R;

public class LoadingDialogFragment extends Dialog {

    public Activity myActivity;

    public LoadingDialogFragment(Activity context) {
        super(context);
        myActivity = context;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.dialog_loading);

    }
}
