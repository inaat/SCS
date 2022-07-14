package com.scs.edu.pk.scs.fragment;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridLayout;

import com.scs.edu.pk.scs.R;
import com.scs.edu.pk.scs.teacher.HomeActivity;
import com.scs.edu.pk.scs.teacher.SubjectActivity;

public class HomeFragment extends Fragment {

     GridLayout grid_menu;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View homeFragment = inflater.inflate(R.layout.fragment_home, container, false);
        grid_menu= (GridLayout) homeFragment.findViewById(R.id.grid_menu);

        setSingleEvent(grid_menu);
        return  homeFragment;
    }

    private void setSingleEvent(GridLayout grid_menu) {

        for(int i=0; i< grid_menu.getChildCount(); i ++){

            CardView cardView = (CardView) grid_menu.getChildAt(i);
            final   int finalI = i;

            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(finalI == 0){
                        Intent intent = new Intent(getActivity(),SubjectActivity.class);
                        startActivity(intent);
                    }
                }
            });


        }
    }
}