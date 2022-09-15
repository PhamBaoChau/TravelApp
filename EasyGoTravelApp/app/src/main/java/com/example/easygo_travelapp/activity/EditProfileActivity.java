package com.example.easygo_travelapp.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.easygo_travelapp.R;
import com.example.easygo_travelapp.customView.CTEditText;
import com.example.easygo_travelapp.customView.CTToolbar;
import com.example.easygo_travelapp.model.DetailScenic;
import com.example.easygo_travelapp.model.User;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import java.sql.Date;

public class EditProfileActivity extends BaseActivity implements View.OnClickListener {

    private CTToolbar toolbar;
    private ImageView avatar;
    private ImageButton btnCamera;
    private CTEditText ctUsername, ctEmail, ctPhone, ctGender, ctBirthday;
    private TextView tvSave;
    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference myRef;
    private User user;

    private void init() {
        toolbar = findViewById(R.id.toolbar);
        tvSave=findViewById(R.id.tvSave);
        avatar = findViewById(R.id.imgAvatar);
        btnCamera = findViewById(R.id.btnCamera);
        ctUsername = findViewById(R.id.ctEdtUserName);
        ctEmail = findViewById(R.id.ctEdtEmail);
        ctPhone = findViewById(R.id.ctEdtPhone);
        ctGender = findViewById(R.id.ctEdtGender);
        ctBirthday = findViewById(R.id.ctEdtBirthday);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);
        init();
        setToolbar(toolbar);
        user =(User) getIntent().getBundleExtra(GET_USER).getSerializable(GET_USER);
        firebaseDatabase = FirebaseDatabase.getInstance();
        myRef = firebaseDatabase.getReference("users");
        setInforUser(user.getUrlAvatar(),user.getUserName(),user.getEmail(), user.getPhone(),user.getGender(),user.getBirthday());
        initAction();
    }

    private void initAction(){
        tvSave.setOnClickListener(this);
    }

    private void setInforUser(String urlAvatar,String userName, String email, String phone, String gender, String birthday) {
        ctUsername.setTitle(getString(R.string.username));
        ctEmail.setTitle(getString(R.string.email));
        ctPhone.setTitle(getString(R.string.phone));
        ctGender.setTitle(getString(R.string.gender));
        ctBirthday.setTitle(getString(R.string.date_of_birth));

        urlAvatar=urlAvatar.isEmpty()?"https://www.i-music.com.hk/assets/images/no-avatar.png":urlAvatar;
        userName=userName.isEmpty()?getString(R.string.not_been_set):userName;
        email=email.isEmpty()?getString(R.string.not_been_set):email;
        phone=phone.isEmpty()?getString(R.string.not_been_set):phone;
        gender=gender.isEmpty()?getString(R.string.not_been_set):gender;
        birthday=birthday.isEmpty()?getString(R.string.not_been_set):birthday;

        ctUsername.setContent(userName);
        ctEmail.setContent(email);
        ctPhone.setContent(phone);
        ctGender.setContent(gender);
        ctBirthday.setContent(birthday);
        Picasso.get().load(urlAvatar).into(avatar);
    }

    private void setToolbar(CTToolbar toolbar) {
        toolbar.setVisibleBack();
        toolbar.setTitleToolbar("edit profile");
    }

    @Override
    public void onClick(View view) {
        String sUserName = user.getUserName();
        String sEmail = user.getEmail();
        String sPhone=user.getPhone();
        String sGender=user.getGender();
        String sBirthday=user.getBirthday();
        if (getCurrentFocus()!=null){
            getCurrentFocus().clearFocus();
        }

        if (!ctUsername.getContent().equals(getString(R.string.not_been_set))
                &&!ctUsername.getContent().equals(user.getUserName())){
            sUserName=ctUsername.getContent();
        }
        if (!ctEmail.getContent().equals(getString(R.string.not_been_set))
                &&!ctEmail.getContent().equals(user.getEmail())){
            sEmail=ctEmail.getContent();
        }
        if (!ctPhone.getContent().equals(getString(R.string.not_been_set))
                &&!ctPhone.getContent().equals(user.getPhone())){
            sPhone=ctPhone.getContent();
        }
        if (!ctGender.getContent().equals(getString(R.string.not_been_set))
                &&!ctGender.getContent().equals(user.getGender())){
            sGender=ctGender.getContent();
        }
        if (!ctBirthday.getContent().equals(getString(R.string.not_been_set))
                &&!ctBirthday.getContent().equals(user.getBirthday())){
            sBirthday=ctBirthday.getContent();
        }
        User newUser=new User(user.getIdUser(),user.getUrlAvatar(),sUserName,sEmail,sPhone,sGender,sBirthday);
        myRef.child(user.getIdUser()).setValue(newUser);

        onBackPressed();
    }
}