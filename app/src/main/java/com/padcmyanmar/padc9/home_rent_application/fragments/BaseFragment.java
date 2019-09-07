package com.padcmyanmar.padc9.home_rent_application.fragments;

import androidx.fragment.app.Fragment;

import com.google.android.material.snackbar.Snackbar;

public class BaseFragment extends Fragment {

    public void showSnackBar(String message){
        Snackbar snackbar = Snackbar.make(getView(), message, Snackbar.LENGTH_INDEFINITE);
        snackbar.show();
    }
}
