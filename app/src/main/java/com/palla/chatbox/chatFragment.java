package com.palla.chatbox;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.squareup.picasso.Picasso;

public class chatFragment extends Fragment {

    private FirebaseFirestore firebaseFirestore;
    LinearLayoutManager linearLayoutManager;

    FirebaseAuth firebaseAuth;
    ImageView mimageviewofuser;

    FirestoreRecyclerAdapter<firebasemodel, NoteViewHolder> chatAdapter;

    RecyclerView mrecyclerview;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.chatfragment, container, false);

        firebaseAuth = FirebaseAuth.getInstance();
        firebaseFirestore = FirebaseFirestore.getInstance();
        mrecyclerview = v.findViewById(R.id.recyclerview);

        Query query = firebaseFirestore.collection("Users");
        FirestoreRecyclerOptions<firebasemodel> allusername = new FirestoreRecyclerOptions.Builder<firebasemodel>().setQuery(query, firebasemodel.class).build();

        chatAdapter = new FirestoreRecyclerAdapter<firebasemodel, NoteViewHolder>(allusername) {
            @Override
            protected void onBindViewHolder(@NonNull NoteViewHolder holder, int position, @NonNull firebasemodel model) {

//                holder.particularusername.setText(firebasemodel.getName());
//                String uri =firebasemodel.getImage();
//
//                Picasso.get().load(uri).into(mimageviewofuser);
//                if(firebasemodel.getStatus().equals("Online"))
//                {
//                    holder.statusofuser.setText(firebasemodel.getStatus());
//                    holder.statusofuser.setLinkTextColor(Color.GREEN);
//                }
//                else {
//                    holder.statusofuser.setText(firebasemodel.getStatus());
//                }
//
                holder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                   public void onClick(View v) {
                        Toast.makeText(getActivity(), "item is clicked", Toast.LENGTH_SHORT).show();
                    }
                });
            }

            @NonNull
            @Override
            public NoteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                 View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.chatviewlayout,parent,false);
                 return new NoteViewHolder(view);
            }
        };
        mrecyclerview.setHasFixedSize(true);
        linearLayoutManager= new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
        mrecyclerview.setLayoutManager(linearLayoutManager);
        mrecyclerview.setAdapter(chatAdapter);

        return v;
    }

    public class NoteViewHolder extends RecyclerView.ViewHolder{
        private TextView particularusername;
        private TextView statusofuser;


        public NoteViewHolder(@NonNull View itemView) {
            super(itemView);

            particularusername = itemView.findViewById(R.id.nameofuser);
            statusofuser=itemView.findViewById(R.id.statusofuser);
            mimageviewofuser=itemView.findViewById(R.id.userimageview);
        }

    }

    @Override
    public void onStart() {
        super.onStart();
        chatAdapter.startListening();
    }

    @Override
    public void onStop() {
        super.onStop();
        if (chatAdapter!=null)
        {
            chatAdapter.stopListening();
        }

    }
}
