package sandbox.dados.gamedev.davidazar.com.dados_uno.models;

import android.util.Log;

/**
 * Created by David on 17/12/14.
 */
public class Dice {

    /*********************ATTRIBUTES*********************/

    private int value;
    private char symbol;
    private char[] symbols = {
            '8',
            '9',
            'J',
            'Q',
            'K',
            'A'
    };


    private final static String TAG = "DICE";


    /*********************ATTRIBUTES*********************/


    /*********************METHODS*********************/


    public Dice (){
        Log.d(TAG, "Call");
        this.value = generateValue();
        this.symbol = generateSymbol();

    }


    private int generateValue(){


        //aqui se genera un rand del 1 al 6 y se asinga a value

    int n = (int)(Math.random()*6);

        //Log.d(TAG,"Value---> "+n);

       return n;
    }


    private char generateSymbol(){

        //aqui se toma value y se cuadra el symbols equivalente y se guarda en symbol


        char s =  symbols[this.value];

        //Log.d(TAG, "Symbol---> "+ String.valueOf(this.symbol));
        //System.out.println("Value es: "+this.symbol);

        return s;
    }

    public int getValue() {
        return value;
    }


    public char getSymbol() {
        return symbol;
    }

    /*********************METHODS*********************/


}




