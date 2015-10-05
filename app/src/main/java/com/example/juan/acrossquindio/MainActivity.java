package com.example.juan.acrossquindio;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    ListView listMenu;

    private List_Start[] menu =
            new List_Start[] {
                    new List_Start(R.drawable.hotel,"Accommodation","¿Are you looking for some place to spend the night?"),
                    new List_Start(R.drawable.drink_bar_cocktails,"Bar´s","Find a good place to drink something, meet people and listen music."),
                    new List_Start(R.drawable.tourism1,"Tourism","¿Are you looking for some interesting places to visit?"),
                    new List_Start(R.drawable.info,"About Quindío","Info about Armenia."),
                    new List_Start(R.drawable.question,"About us","Info about who the hell create this app.")};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Adapter adapter1 = new Adapter(this, menu);
        listMenu = (ListView) findViewById(R.id.id_ListStart);
        listMenu.setAdapter(adapter1);

        listMenu.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String seleccion = ((List_Start) parent.getItemAtPosition(position)).getNameItem();
                Toast.makeText(MainActivity.this, seleccion, Toast.LENGTH_LONG).show();
                if(seleccion.equals("Accommodation")) {
                    //Toast.makeText(MainActivity.this, "Igual", Toast.LENGTH_LONG).show();
                    Intent i =new Intent(getBaseContext(), AccommodationActivity.class);
                    startActivity(i);
                }
                if(seleccion.equals("Bar´s")) {
                    //Toast.makeText(MainActivity.this, "Igual", Toast.LENGTH_LONG).show();
                    Intent i =new Intent(getBaseContext(),BarsActivity.class);
                    startActivity(i);
                }

                if(seleccion.equals("Tourism")) {
                    //Toast.makeText(MainActivity.this, "Igual", Toast.LENGTH_LONG).show();
                    Intent i =new Intent(getBaseContext(),TourismActivity.class);
                    startActivity(i);
                }
                if(seleccion.equals("About Quindío")) {
                    //Toast.makeText(MainActivity.this, "Igual", Toast.LENGTH_LONG).show();
                    Intent i =new Intent(getBaseContext(),AboutQuindioActivity.class);
                    startActivity(i);
                }
                if(seleccion.equals("About us")) {
                    //Toast.makeText(MainActivity.this, "Igual", Toast.LENGTH_LONG).show();
                    Intent i =new Intent(getBaseContext(),AboutusActivity.class);
                    startActivity(i);
                }
            }
        });
    }

    public class Adapter extends ArrayAdapter<List_Start> {

        public Adapter(Context context, List_Start[] menu) {
            super(context, R.layout.layout_item, menu);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            LayoutInflater inflater = LayoutInflater.from(getContext());
            View item = inflater.inflate(R.layout.layout_item, null);

            TextView act = (TextView) item.findViewById(R.id.id_lvactivity);
            act.setText(menu[position].getNameItem());

            TextView desAct = (TextView) item.findViewById(R.id.id_lvDescAct);
            desAct.setText(menu[position].getDescItem());

            ImageView imagen = (ImageView) item.findViewById(R.id.id_imgAct);
            imagen.setImageResource(menu[position].getIdImage());

            return (item);
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
        if (id == R.id.id_actAccom) {
            //Toast.makeText(this, "Accommodation", Toast.LENGTH_SHORT).show();
            Intent i =new Intent(this, AccommodationActivity.class);
            startActivity(i);
            return true;
        }
        if (id == R.id.id_actBar) {
            //Toast.makeText(this, "Bar´s", Toast.LENGTH_SHORT).show();
            Intent i =new Intent(this, BarsActivity.class);
            startActivity(i);
            return true;
        }
        if (id == R.id.id_actAboutQ) {
            //Toast.makeText(MainActivity.this, "About Quindío", Toast.LENGTH_LONG).show();
            Intent i = new Intent(getBaseContext(), AboutQuindioActivity.class);
            startActivity(i);
        }
        if (id == R.id.id_actTourism) {
            //Toast.makeText(MainActivity.this, "Turism", Toast.LENGTH_LONG).show();
            Intent i = new Intent(getBaseContext(), TourismActivity.class);
            startActivity(i);
        }
        return super.onOptionsItemSelected(item);
    }
}
