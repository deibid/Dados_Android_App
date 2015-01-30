package sandbox.dados.gamedev.davidazar.com.dados_uno.Fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import sandbox.dados.gamedev.davidazar.com.dados_uno.R;

/**
 * Created by David on 03/01/15.
 */
public class BoardFragment extends Fragment {


    TextView []tvs;




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.board_fragment,
                container, false);

        return view;
    }


    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        tvs = new TextView[7];

         tvs[0] = (TextView)view.findViewById(R.id.tvLastPlay);
         tvs[1] = (TextView)view.findViewById(R.id.tvQUno);
         tvs[2] = (TextView)view.findViewById(R.id.tvQDos);
         tvs[3] = (TextView)view.findViewById(R.id.tvQTres);
         tvs[4] = (TextView)view.findViewById(R.id.tvQCuatro);
         tvs[5] = (TextView)view.findViewById(R.id.tvQTotal);
         tvs[6] = (TextView)view.findViewById(R.id.tvStatus);







    }


    public void setText(String s, int index){

        tvs[index].setText(s);

    }
}
