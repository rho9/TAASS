package com.example.rudapplication.ui.myrud;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MyRudViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public MyRudViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is MyRUD fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}