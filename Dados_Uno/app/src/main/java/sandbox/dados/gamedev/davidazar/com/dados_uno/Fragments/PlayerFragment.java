package sandbox.dados.gamedev.davidazar.com.dados_uno.Fragments;

import android.app.Fragment;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import sandbox.dados.gamedev.davidazar.com.dados_uno.MainActivity;
import sandbox.dados.gamedev.davidazar.com.dados_uno.R;

/**
 * Created by David on 02/01/15.
 */
public class PlayerFragment extends Fragment implements View.OnClickListener {


    TextView dicesTV;
    View generalView;
    LinearLayout turnIndicator;
    boolean myTurn = false;

    private int[] play = new int[2];

    private char[] symbols = {
            '8',
            '9',
            'J',
            'Q',
            'K',
            'A'
    };


    private TextView tvSymbol;
    private TextView tvQuantity;

    private int totalDices;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.player_fragment,
                container, false);


        tvQuantity = (TextView) view.findViewById(R.id.tvQuantity);
        tvQuantity.setOnClickListener(this);

        tvSymbol = (TextView) view.findViewById(R.id.tvSymbol);
        tvSymbol.setOnClickListener(this);

        generalView = view;
        return view;


    }


    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        dicesTV = (TextView) view.findViewById(R.id.tvDices);

        turnIndicator = (LinearLayout) view.findViewById(R.id.turnIndicator);

        if (dicesTV == null)
            Log.e("onViewCreated", "dicesTV es null");
        else
            Log.e("onViewCreated", "dicesTV NO es null");

    }


    @Override
    public void onClick(View v) {

        TextView tv = (TextView) v;
        String s = String.valueOf(tv.getText());

        int n = 0;

        switch (v.getId()) {


            case R.id.tvQuantity:

                n = Integer.parseInt(s);
                n++;
                if (n == totalDices + 1)
                    n = 1;
                tv.setText(String.valueOf(n));
                break;

            case R.id.tvSymbol:

                n = 0;
                char c[] = s.toCharArray();
                char c_2 = c[0];
                for (int i = 0; i < this.symbols.length; i++) {
                    if (c_2 == this.symbols[i]) {
                        n = i + 1;
                    }
                    if (n == 6)
                        n = 0;
                }
                tv.setText(String.valueOf(this.symbols[n]));
                break;

            case R.id.btBet:

                setBet();
                MainActivity.notifyBet();
                break;

            case R.id.btLie:

                break;


        }


    }

    public void setTotalDices(int a) {

        totalDices = a;
    }

    public void setTextDices(String s) {

        dicesTV.setText(s);

    }

    public void turn(boolean b) {

        myTurn = b;

        if (myTurn == true)
            turnIndicator.setBackgroundColor(Color.WHITE);
        else
            turnIndicator.setBackgroundColor(getResources().getColor(R.color.color_player_background_enabled));


    }


    private void setBet() {


        String s = String.valueOf(tvSymbol.getText());
        char c[] = s.toCharArray();
        char c_2 = c[0];
        int n = 0;
        for (int i = 0; i < this.symbols.length; i++) {
            if (c_2 == this.symbols[i]) {
                n = i;
            }

        }

        int quantity = Integer.valueOf(String.valueOf(tvQuantity.getText()));

        play[0]=quantity;
        play[1]=n;


    }

    public int[] getPlay(){

        return play;

    }

    public String getPlayString(){

        String s = "";
        s = s + String.valueOf(play[0]);
        s = s + String.valueOf(play[1]);

        return s;

    }




}
