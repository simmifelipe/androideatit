package androideatit.dev.fb.com.androideatit;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.rengwuxian.materialedittext.MaterialEditText;

import androideatit.dev.fb.com.androideatit.Model.User;
import info.hoang8f.widget.FButton;

public class SignUp extends AppCompatActivity {

    MaterialEditText edtPhone, edtName, edtPassword;
    FButton btnSignUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        edtPhone = findViewById(R.id.edtPhone);
        edtName = findViewById(R.id.edtName);
        edtPassword = findViewById(R.id.edtPassword);
        btnSignUp = findViewById(R.id.btnSignUp);

        //Init Firebase
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference table_user = database.getReference("User");

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final ProgressDialog mDiadlog = new ProgressDialog(SignUp.this);
                mDiadlog.setMessage("Please waiting...");
                mDiadlog.show();

                table_user.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {

                        // Check if alredy user phone
                        if(dataSnapshot.child(edtPhone.getText().toString()).exists())
                        {
                            mDiadlog.dismiss();
                            Toast.makeText(getBaseContext(), "Phone number already register !", Toast.LENGTH_SHORT).show();
                        }
                        else
                        {
                            mDiadlog.dismiss();
                            User user = new User(edtName.getText().toString(),edtPassword.getText().toString(), "");
                            table_user.child(edtPhone.getText().toString()).setValue(user);
                            Toast.makeText(getBaseContext(), "Sign up successfully !", Toast.LENGTH_SHORT).show();
                            finish();
                        }

                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });
            }
        });

    }
}
