package sandbox.dados.gamedev.davidazar.com.dados_uno.models;

import android.util.Log;

/**
 * Created by David on 17/12/14.
 */
public class Match {


    private Table table;

    private final static String TAG ="MATCH";

    public Match(){
        //this.table = new Table();
        this.table = new Table (4,0);
        Log.d(TAG, "Call");

    }

    public Table getTable() {
        return table;
    }

    public int getTotalDices(){

        return table.getTotalDices();
    }

    //pulir implementacion de la clase superior
    //agregar una clase controladpra del Match, puede ser menu o MainActivity
    
}
