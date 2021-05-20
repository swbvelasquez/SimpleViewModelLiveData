package com.tutoriales.simpleviewmodellivedata.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.tutoriales.simpleviewmodellivedata.core.User;

import java.util.ArrayList;
import java.util.List;

public class UserLiveDataViewModel extends ViewModel {
    private MutableLiveData<List<User>> userLiveDataList;
    private List<User> userList;

    public MutableLiveData<List<User>> getUserLiveDataList() {

        if(userLiveDataList==null){
            userLiveDataList = new MutableLiveData<>();
            userList = new ArrayList<>();
        }

        return userLiveDataList;
    }

    public void add(User user){
        userList.add(user);
        userLiveDataList.setValue(userList);
    }

    public void setUserLiveDataList(MutableLiveData<List<User>> userLiveDataList) {
        this.userLiveDataList = userLiveDataList;
    }
}
