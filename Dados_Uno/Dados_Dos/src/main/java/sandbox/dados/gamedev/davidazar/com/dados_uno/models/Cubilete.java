package sandbox.dados.gamedev.davidazar.com.dados_uno.models;

import android.util.Log;

/**
 * Created by David on 17/12/14.
 */
public class Cubilete {


    private Dice[] dices;
    private int size;
    private int quantities[] = {0,0,0,0,0,0};

    private final static String TAG = "CUBILETE";


    public Cubilete(){
        Log.d(TAG, "Call");
        this.dices = new Dice[5];
        for(int i =0;i<5;i++) {
            this.dices[i] = new Dice();

            this.quantities[dices[i].getValue()]++;

        }

        this.size = 5;


    }

    public void eliminateDice(){

        dices[size] = null;

    }

    //pendiente* ver como poner dado en la mesa


    public String returnContent(){

        String s = "";

        for(Dice d:this.dices) s = s + " | " + d.getSymbol();

        s = s + " |";

        return s;
    }

    public String returnQuantities(){

        String s = "";

        for(int i =0;i<this.quantities.length;i++){

            s= s+" "+String.valueOf(this.quantities[i]);
        }

        return s;
    }

    public int[] getQuantities() {
        return quantities;
    }

//crear
    //modificar
    //extraer


}
