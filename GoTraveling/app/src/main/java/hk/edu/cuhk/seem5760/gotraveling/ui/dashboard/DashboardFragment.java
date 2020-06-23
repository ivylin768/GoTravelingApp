package hk.edu.cuhk.seem5760.gotraveling.ui.dashboard;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import hk.edu.cuhk.seem5760.gotraveling.R;


public class DashboardFragment extends Fragment {

    private Button gbtn;
    private Button qbtn;
    private ImageView iv;
    private ImageButton mate;
    private RelativeLayout mate_search;

    @NonNull
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_forum, container, false);

        gbtn = (Button)root.findViewById(R.id.guidebtn);
        qbtn = (Button)root.findViewById(R.id.qnabtn);
        iv = (ImageView)root.findViewById(R.id.forum_imgview);
        mate = (ImageButton)root.findViewById(R.id.mate);
        mate_search = (RelativeLayout)root.findViewById(R.id.mate_search);

        gbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iv.getDrawable().setLevel(0);
            }
        });
        qbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iv.getDrawable().setLevel(1);
            }
        });

        mate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mate_search.setVisibility(View.VISIBLE);
            }
        });

        return root;
    }

}