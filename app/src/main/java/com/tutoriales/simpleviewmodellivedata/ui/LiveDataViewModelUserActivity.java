package com.tutoriales.simpleviewmodellivedata.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.tutoriales.simpleviewmodellivedata.R;
import com.tutoriales.simpleviewmodellivedata.core.User;
import com.tutoriales.simpleviewmodellivedata.viewmodel.UserLiveDataViewModel;
import com.tutoriales.simpleviewmodellivedata.viewmodel.UserViewModel;

import java.util.ArrayList;
import java.util.List;

public class LiveDataViewModelUserActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText etId, etName, etAge;
    private Button btnSave;
    private TextView tvUserLiveDataViewModel;
    private UserLiveDataViewModel userLiveDataViewModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_live_data_view_model_user);
        setView();
    }

    private void setView(){
        etId=findViewById(R.id.etId);
        etName =findViewById(R.id.etName);
        etAge =findViewById(R.id.etAge);
        btnSave =findViewById(R.id.btnSave);
        tvUserLiveDataViewModel=findViewById(R.id.tvUserLiveDataViewModel);

        btnSave.setOnClickListener(this);

        //instancia la clase de viewmodel live data
        userLiveDataViewModel = new ViewModelProvider(this).get(UserLiveDataViewModel.class);
        //el observador que actualiza la informacion
        final Observer<List<User>> listObserver = new Observer<List<User>>() {
            @Override
            public void onChanged(List<User> users) {
                tvUserLiveDataViewModel.setText(users.toString());
            }
        };
        //configurar el live data con el observador
        userLiveDataViewModel.getUserLiveDataList().observe(this,listObserver);
    }

    @Override
    public void onClick(View v) {
        try {
            if (v.getId() == R.id.btnSave) {
                User user = new User();
                user.setId(Integer.parseInt(etId.getText().toString()));
                user.setName(etName.getText().toString());
                user.setAge(Integer.parseInt(etAge.getText().toString()));
                userLiveDataViewModel.add(user);
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
}