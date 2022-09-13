package com.example.easygo_travelapp.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

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
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import java.sql.Date;

public class EditProfileActivity extends AppCompatActivity {

    private CTToolbar toolbar;
    private ImageView avatar;
    private ImageButton btnCamera;
    private CTEditText ctUsername, ctEmail, ctPhone, ctGender, ctBirthday;
    private DatabaseReference myRef;

    private void init() {
        toolbar = findViewById(R.id.toolbar);
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
        String idUser = getIntent().getStringExtra("USER_ID");
        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
        myRef = firebaseDatabase.getReference("users/" + idUser);
        getUserProfile();
    }

    private void getUserProfile() {
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                User user = dataSnapshot.getValue(User.class);
                setInforUser(user.getUserName(), user.getEmail(), user.getPhone(), user.getGender(), user.getBirthday());
            }

            @Override
            public void onCancelled(DatabaseError error) {
                FirebaseUser user=FirebaseAuth.getInstance().getCurrentUser();
                String notSet=getString(R.string.not_been_set);
                if (user.getPhotoUrl()==null&&user.getDisplayName()==null){
                    setInforUser(notSet,notSet,user.getPhoneNumber(),notSet,notSet);
                }else {
                    setInforUser(user.getDisplayName(),user.getEmail(),user.getPhoneNumber(),notSet,notSet);
                }
            }
        });
    }

    private void setInforUser(String userName, String email, String phone, String gender, String birthday) {
        ctUsername.setTitle(getString(R.string.username));
        ctEmail.setTitle(getString(R.string.email));
        ctPhone.setTitle(getString(R.string.phone));
        ctGender.setTitle(getString(R.string.gender));
        ctBirthday.setTitle(getString(R.string.date_of_birth));

        ctUsername.setContent(userName);
        ctEmail.setContent(email);
        ctPhone.setContent(phone);
        ctGender.setContent(gender);
        ctBirthday.setContent(birthday);
    }

    private void setToolbar(CTToolbar toolbar) {
        toolbar.setVisibleBack();
        toolbar.setVisibleSave();
        toolbar.setTitleToolbar("edit profile");
    }
}