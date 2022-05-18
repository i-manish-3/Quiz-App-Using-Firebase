package com.example.quizzer;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.quizzer.databinding.FragmentLeaderboardsBinding;
import com.example.quizzer.databinding.FragmentProfileBinding;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.firestore.FirebaseFirestore;

import org.w3c.dom.Text;

import java.util.zip.Inflater;


public class ProfileFragment extends Fragment {

    FirebaseAuth auth;
    FragmentProfileBinding binding;
    String  uid;
    FirebaseFirestore database;
    private FirebaseUser user;
    private String userID;
    private DatabaseReference reference;

    public ProfileFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        auth = FirebaseAuth.getInstance();

        database = FirebaseFirestore.getInstance();




    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {



         binding = FragmentProfileBinding.inflate(inflater,container,false);
         binding.logOut.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 auth.signOut();
                 signOutUser();
             }
         });
        // Inflate the layout for this fragment
        return binding.getRoot();
    }

    private void signOutUser() {
        Intent intent = new Intent(ProfileFragment.this.getActivity(), LoginActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }


}