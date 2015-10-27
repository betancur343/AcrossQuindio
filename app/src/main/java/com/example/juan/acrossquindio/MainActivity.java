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
                    new List_Start(R.drawable.hotel,"name","desc"),
                    new List_Start(R.drawable.drink_bar_cocktails,"",""),
                    new List_Start(R.drawable.tourism1,"",""),
                    new List_Start(R.drawable.info,"",""),
                    new List_Start(R.drawable.question,"","")};

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String[] Main_var =getResources().getStringArray(R.array.List_main_name);
        menu[0].setNameItem(Main_var[0]);
        menu[1].setNameItem(Main_var[1]);
        menu[2].setNameItem(Main_var[2]);
        menu[3].setNameItem(Main_var[3]);
        menu[4].setNameItem(Main_var[4]);

        String[] Main_var2 =getResources().getStringArray(R.array.List_main_Desc);
        menu[0].setDescItem(Main_var2[0]);
        menu[1].setDescItem(Main_var2[1]);
        menu[2].setDescItem(Main_var2[2]);
        menu[3].setDescItem(Main_var2[3]);
        menu[4].setDescItem(Main_var2[4]);

        Adapter adapter1 = new Adapter(this, menu);
        listMenu = (ListView) findViewById(R.id.id_ListStart);
        listMenu.setAdapter(adapter1);

        listMenu.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String seleccion = ((List_Start) parent.getItemAtPosition(position)).getNameItem();
                Toast.makeText(MainActivity.this, seleccion, Toast.LENGTH_LONG).show();
                if(seleccion.equals("Accommodation") || seleccion.equals("Alojamiento") ) {
                    //Toast.makeText(MainActivity.this, "Igual", Toast.LENGTH_LONG).show();
                    Intent i =new Intent(getBaseContext(), AccommodationActivity.class);
                    startActivity(i);
                }
                if(seleccion.equals("Bar´s") || seleccion.equals("Bares") ) {
                    //Toast.makeText(MainActivity.this, "Igual", Toast.LENGTH_LONG).show();
                    Intent i =new Intent(getBaseContext(),BarsActivity.class);
                    startActivity(i);
                }

                if(seleccion.equals("Tourism") || seleccion.equals("Turismo")) {
                    //Toast.makeText(MainActivity.this, "Igual", Toast.LENGTH_LONG).show();
                    Intent i =new Intent(getBaseContext(),TourismActivity.class);
                    startActivity(i);
                }
                if(seleccion.equals("About Quindío") || seleccion.equals("Acerca de Quindío")) {
                    //Toast.makeText(MainActivity.this, "Igual", Toast.LENGTH_LONG).show();
                    Intent i =new Intent(getBaseContext(),AboutQuindioActivity.class);
                    startActivity(i);
                }
                if(seleccion.equals("About us") || seleccion.equals("Acerca de nosotros")) {
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
