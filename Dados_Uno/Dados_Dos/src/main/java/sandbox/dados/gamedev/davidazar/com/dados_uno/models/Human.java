package sandbox.dados.gamedev.davidazar.com.dados_uno.models;

import android.util.Log;

/**
 * Created by David on 17/12/14.
 */
public class Human extends Player {


    private int type; /*0 human , 1 computer */
    //private Cubilete cubilete;

    private final static String TAG = "HUMAN";


    public Human(){

        super();
        Log.d(TAG, "Call");
        this.type = 0;


    }



    private void playTurn(){

    }




}
