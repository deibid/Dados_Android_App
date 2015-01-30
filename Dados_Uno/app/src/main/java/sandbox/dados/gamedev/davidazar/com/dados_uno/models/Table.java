package sandbox.dados.gamedev.davidazar.com.dados_uno.models;

import android.util.Log;

/**
 * Created by David on 17/12/14.
 */
public class Table {

    private Player[] players;
    private int size;
    int[] qs = {0,0,0,0,0,0};

    private final static String TAG = "TABLE";

    public Table(){  }

    public Table (int humans , int comps){


        Log.d(TAG, "Call");

        this.size = humans+comps;
        this.players = new Player[this.size];
        for(int i = 0;i<humans;i++) {
            players[i] = new Human();

        }

        for (int i = humans; i<this.size;i++){
            players[i] = new Computer();
        }

    }

    public Player[] getPlayers() {
        return players;
    }

    /*implementar todos los metodos encargados de controlar los turnos*/
    public void nextTurn(){

    }

    public String getTotalQuantites(){

        String s = "";
        int[] temp_qs = new int[6];
        for(Player p: this.players){
           temp_qs =  p.getQuantities(0); /*Mejorar implementacion de la sobrecarga*/
           for(int i=0;i<this.qs.length;i++){
               this.qs[i]= this.qs[i]+temp_qs[i];
           }
        }


       for(int i =0;i<this.qs.length;i++){

           s = s+" "+String.valueOf(this.qs[i]);
       }

        return s;
    }


    public int getTotalDices(){

        int totalDices=0;

        for(Player p:players){

            totalDices +=p.getCubileteSize();

        }

        return totalDices;
    }

}
