package fr.android.androidexercises;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class Step1Fragment extends Fragment {

    // TODO Override onCreateViewMethod


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_step1, container, false);
        int viewId = getArguments().getInt("viewId");
        TextView textView = view.findViewById(R.id.step1TextView);

        textView.setText("Id de la view : " + viewId);
        return view;
    }

}
