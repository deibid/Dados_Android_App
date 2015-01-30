package sandbox.dados.gamedev.davidazar.com.dados_uno;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import sandbox.dados.gamedev.davidazar.com.dados_uno.Fragments.BoardFragment;
import sandbox.dados.gamedev.davidazar.com.dados_uno.Fragments.PlayerFragment;
import sandbox.dados.gamedev.davidazar.com.dados_uno.controller.MatchController;


/*

Esta clase, o bien, la activity encargada dela pantalla del juego es
 quien se encargara de hacer las llamadas necearias a todos los metodos del juego.

 To.do el modelo de datos y la estructura de la partida esta en el paquete "Models".

 Cada clase sabe que hacer, pero el timing y el control del partido
  va a estar dado por esta clase, haciendo las llamadas necesarias a MatchController
 */

public class MainActivity extends ActionBarActivity {


    private MatchController matchController;
    private final static String TAG = "MAIN_ACTIVITY";


    private BoardFragment board;
    private PlayerFragment playerOne;
    private PlayerFragment playerTwo;
    private PlayerFragment playerThree;
    private PlayerFragment playerFour;

    private boolean initial = true;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d(TAG,"MainCall");
        this.matchController = new MatchController();

        FragmentManager fm = getFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();

        board = new BoardFragment();

        playerOne = new PlayerFragment();
        playerTwo = new PlayerFragment();
        playerThree = new PlayerFragment();
        playerFour = new PlayerFragment();


        ft.add(R.id.containerZero,board);
        ft.add(R.id.containerOne, playerOne);
        ft.add(R.id.containerTwo, playerTwo);
        ft.add(R.id.containerThree, playerThree);
        ft.add(R.id.containerFour, playerFour);



        ft.commit();

    }


    @Override
    protected void onStart() {
        super.onStart();


        if(initial) {
            playerOne.setTextDices(matchController.getMatch().getTable().getPlayers()[0].getCubilete().returnContent());
            playerTwo.setTextDices(matchController.getMatch().getTable().getPlayers()[1].getCubilete().returnContent());
            playerThree.setTextDices(matchController.getMatch().getTable().getPlayers()[2].getCubilete().returnContent());
            playerFour.setTextDices(matchController.getMatch().getTable().getPlayers()[3].getCubilete().returnContent());

            board.setText(matchController.getMatch().getTable().getPlayers()[0].getQuantities(), 1);
            board.setText(matchController.getMatch().getTable().getPlayers()[1].getQuantities(), 2);
            board.setText(matchController.getMatch().getTable().getPlayers()[2].getQuantities(), 3);
            board.setText(matchController.getMatch().getTable().getPlayers()[3].getQuantities(), 4);
            board.setText(matchController.getMatch().getTable().getTotalQuantites(), 5);

            board.setText("PLAY", 0);
            board.setText("STATUS", 6);

            playerOne.turn(true);

            int totalDices = matchController.getTotalDices();

            playerOne.setTotalDices(totalDices);
            playerTwo.setTotalDices(totalDices);
            playerThree.setTotalDices(totalDices);
            playerFour.setTotalDices(totalDices);

            initial=false;



        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }




    public static void notifyBet(){



    }




}
