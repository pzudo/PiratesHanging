package scholten.pirateshanging.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import scholten.pirateshanging.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class GallowsFragment extends Fragment {


    public GallowsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_gallows, container, false);


        return view;
    }

}
