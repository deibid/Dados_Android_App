package sandbox.dados.gamedev.davidazar.com.dados_uno;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

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

    private TextView tvComp1;
    private TextView tvComp2;
    private TextView tvComp3;
    private TextView tvUser;

    private TextView tvQUno;
    private TextView tvQDos;
    private TextView tvQTres;
    private TextView tvQCuatro;
    private TextView tvQTotal;

    private char[] symbols = {
            '8',
            '9',
            'J',
            'Q',
            'K',
            'A'
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d(TAG,"MainCall");
        this.matchController = new MatchController();


        tvComp1 = (TextView)findViewById(R.id.tvComp1);
        tvComp2 = (TextView)findViewById(R.id.tvComp2);
        tvComp3 = (TextView)findViewById(R.id.tvComp3);
        tvUser = (TextView)findViewById(R.id.tvUser);

        tvQUno = (TextView)findViewById(R.id.tvQUno);
        tvQDos = (TextView)findViewById(R.id.tvQDos);
        tvQTres = (TextView)findViewById(R.id.tvQTres);
        tvQCuatro = (TextView)findViewById(R.id.tvQCuatro);
        tvQTotal = (TextView)findViewById(R.id.tvQTotal);



        tvComp1.setText(matchController.getMatch().getTable().getPlayers()[0].getCubilete().returnContent());
        tvComp2.setText(matchController.getMatch().getTable().getPlayers()[1].getCubilete().returnContent());
        tvComp3.setText(matchController.getMatch().getTable().getPlayers()[2].getCubilete().returnContent());
        tvUser.setText(matchController.getMatch().getTable().getPlayers()[3].getCubilete().returnContent());

        tvQUno.setText(matchController.getMatch().getTable().getPlayers()[0].getQuantities());
        tvQDos.setText(matchController.getMatch().getTable().getPlayers()[1].getQuantities());
        tvQTres.setText(matchController.getMatch().getTable().getPlayers()[2].getQuantities());
        tvQCuatro.setText(matchController.getMatch().getTable().getPlayers()[3].getQuantities());
        tvQTotal.setText(matchController.getMatch().getTable().getTotalQuantites());






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



    public void textViewClick(View v){

        TextView tv = (TextView)v;
        String s = String.valueOf(tv.getText());

        if(v.getId() == R.id.tvQuantity){

            int n = Integer.parseInt(s);
            n++;
            if(n == 10)
                n=1;
            tv.setText(String.valueOf(n));
        }

        else if(v.getId() == R.id.tvSymbol){

            int n=0;
            char c[]= s.toCharArray();
            char c_2 = c[0];
            for(int i=0;i<this.symbols.length;i++){
                if(c_2 == this.symbols[i]){
                    n=i+1;
                }
                if(n==6)
                    n=0;
            }

            tv.setText(String.valueOf(this.symbols[n]));

        }

    }

}
