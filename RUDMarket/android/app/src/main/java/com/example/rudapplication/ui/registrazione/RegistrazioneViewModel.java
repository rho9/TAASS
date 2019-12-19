package com.example.rudapplication.ui.registrazione;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class RegistrazioneViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public RegistrazioneViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is registrazione fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}