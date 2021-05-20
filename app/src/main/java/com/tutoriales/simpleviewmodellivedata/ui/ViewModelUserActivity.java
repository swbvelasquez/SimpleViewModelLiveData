package com.tutoriales.simpleviewmodellivedata.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.tutoriales.simpleviewmodellivedata.R;
import com.tutoriales.simpleviewmodellivedata.core.User;
import com.tutoriales.simpleviewmodellivedata.viewmodel.UserViewModel;

import java.util.ArrayList;
import java.util.List;

public class ViewModelUserActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText etId, etName, etAge;
    private Button btnSave, btnShow;
    private TextView tvUser,tvUserViewModel;
    private List<User> userList;
    private UserViewModel userViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_model_user);
        setView();
    }

    private void setView(){
        etId=findViewById(R.id.etId);
        etName =findViewById(R.id.etName);
        etAge =findViewById(R.id.etAge);
        btnSave =findViewById(R.id.btnSave);
        btnShow =findViewById(R.id.btnShow);
        tvUser=findViewById(R.id.tvUser);
        tvUserViewModel=findViewById(R.id.tvUserViewModel);

        btnSave.setOnClickListener(this);
        btnShow.setOnClickListener(this);

        userViewModel = new ViewModelProvider(this).get(UserViewModel.class);
        userList = new ArrayList<>();
    }

    @Override
    public void onClick(View v) {
        try {
            if (v.getId() == R.id.btnSave) {
                User user = new User();
                user.setId(Integer.parseInt(etId.getText().toString()));
                user.setName(etName.getText().toString());
                user.setAge(Integer.parseInt(etAge.getText().toString()));
                userList.add(user);
                userViewModel.add(user);
            } else {
                tvUser.setText(userList.toString());
                tvUserViewModel.setText(userViewModel.getUserList().toString());
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
}