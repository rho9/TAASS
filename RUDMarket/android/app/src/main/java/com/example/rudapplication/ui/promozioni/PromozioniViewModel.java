package com.example.rudapplication.ui.promozioni;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class PromozioniViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public PromozioniViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is promozioni fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}