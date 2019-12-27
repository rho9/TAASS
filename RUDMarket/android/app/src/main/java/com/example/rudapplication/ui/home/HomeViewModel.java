package com.example.rudapplication.ui.home;

import android.widget.ImageView;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class HomeViewModel extends ViewModel {

    private MutableLiveData<String> mText;
    private ImageView images;

    public HomeViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Benvenuto in RUDMarket!");
    }

    public LiveData<String> getText() {
        return mText;
    }

    public ImageView getImages() {
        return images;
    }
}