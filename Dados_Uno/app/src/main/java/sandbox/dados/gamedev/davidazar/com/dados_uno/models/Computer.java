package sandbox.dados.gamedev.davidazar.com.dados_uno.models;

import android.util.Log;

/**
 * Created by David on 17/12/14.
 */
public class Computer extends Player {


    private int type; /*0 human , 1 computer */


    private final static String TAG = "COMPUTER";

    public Computer(){
        super();
        Log.d(TAG, "Call");
        this.type = 1;


    }


    private void playTurn(){

        /*Aqui entra el algoritmo de inteligencua artificial*/

    }
}
