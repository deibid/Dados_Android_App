package sandbox.dados.gamedev.davidazar.com.dados_uno.models;

import android.util.Log;

/**
 * Created by David on 17/12/14.
 */
public class Player {


    private int score;
    private boolean turn;
    private Cubilete cubilete;

    private final static String TAG = "PLAYER";

    public Player(){

        Log.d(TAG, "Call");

        this.score = 0;
        this.turn = false;
        this.cubilete = new Cubilete();
    }

    public Cubilete getCubilete() {
        return cubilete;
    }


    public String getQuantities(){

        return this.cubilete.returnQuantities();
    }


    public int[] getQuantities(int a){

        return cubilete.getQuantities();
    }
    private void playTurn(){

        //Implementado por subclase
    }


}
