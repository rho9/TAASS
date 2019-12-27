package com.example.rudapplication.ui.doveSiamo;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class DoveSiamoViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public DoveSiamoViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is dove siamo fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}