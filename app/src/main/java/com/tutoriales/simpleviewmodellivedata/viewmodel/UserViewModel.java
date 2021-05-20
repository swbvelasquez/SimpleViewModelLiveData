package com.tutoriales.simpleviewmodellivedata.viewmodel;

import androidx.lifecycle.ViewModel;

import com.tutoriales.simpleviewmodellivedata.core.User;

import java.util.ArrayList;
import java.util.List;

public class UserViewModel extends ViewModel {
    private List<User> userList;

    public UserViewModel() {
        userList=new ArrayList<>();
    }

    public UserViewModel(List<User> userList) {
        this.userList = userList;
    }

    public void add(User user){
        userList.add(user);
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }
}
