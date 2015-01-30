package sandbox.dados.gamedev.davidazar.com.dados_uno.controller;

import android.util.Log;

import sandbox.dados.gamedev.davidazar.com.dados_uno.models.Cubilete;
import sandbox.dados.gamedev.davidazar.com.dados_uno.models.Match;
import sandbox.dados.gamedev.davidazar.com.dados_uno.models.Player;
import sandbox.dados.gamedev.davidazar.com.dados_uno.models.Table;

/**
 * Created by David on 17/12/14.
 */
public class MatchController {


    /*Esta clase se encargara de manejar el juego, logica reglas llamadas etc

     */
    private Match match;
    private Table table;
    private Player[] players;
    //private Cubilete[] cubiletes;



    private final static String TAG = "MatchController";



    public MatchController(){

        this.match = new Match();
        Log.d(TAG, "Call");

    }


    public Match getMatch() {
        return match;
    }

    public Table getTable() {
        return table;
    }

    public Player[] getPlayers() {
        return players;
    }

    public int getTotalDices(){

       return match.getTotalDices();
    }
}
