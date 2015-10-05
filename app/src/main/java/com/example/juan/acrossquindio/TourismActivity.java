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
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class TourismActivity extends AppCompatActivity {
    ListView listTour;

    private List_Tourism[] Tour =
            new List_Tourism[] {
                    new List_Tourism("PANACA - Parque Nacional de la Cultura Agropecuaria\n",R.drawable.panaca,"It is a big theme park where you can enjoy the full beauty of life in the countryside. Among other attractions enjoy the amazing world of livestock, fascinating world of the  poultry farming, sensational world of the pig, the friendly dog world, the curious world of sericulture, the new world of biorganics, the spectacular world of horses and the interesting world of agronomy.","Dirección: Kilómetro 7 vía vereda Kerman, Quimbaya – Quindío – Colombia\nPhone: (6) 758 2830\nCellphone: 313 721 9211\n Free line: 01 8000 123 999"),

                    new List_Tourism("Parque Nacional del Café\n",R.drawable.parquedelcafe2,"Located in the town of Montenegro, let us to know the traditions and coffee culture. Among its attractions are: the monument to coffee, ecological tour, Krater roller coaster, horses, garden fables, heliport, paisa people and train ride, among others.","E-mail: servicioalcliente@parquedelcafe.co\nPhone: PBX (6) – 7417417\n Sunday to sunday from 8am – 6pm\nWeb: http://www.parquedelcafe.co/\nAddress: Km 6 vía Montenegro Pueblo Tapao Quindío – Colombia"),
                new List_Tourism("Salento - Valle de Cocora\n",R.drawable.logobosquesp,"Offers the most diverse variety of flora and fauna typical of the cloud forest, in the valley of Cocora find large concentrations of Quindío wax palm, plant his majesty was named national tree. In this region there are also the natural reserves of Acaime and Herencia Verde.","Phone: (096) 7463515\nCellphone: (321) 8317913 - (310) 2275091\nE-mail: bosquesdecocora@live.com \nor reservasbosquesdecocora@gmail.c\nWeb: http://www.valledelcocora.com.co\n")
            };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tourism);

        Adapter adapter4 = new Adapter(this, Tour);
        listTour = (ListView) findViewById(R.id.id_ListTourism);
        listTour.setAdapter(adapter4);
        listTour.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String seleccion = ((List_Tourism) parent.getItemAtPosition(position)).getNameItem();
                //Toast.makeText(TourismActivity.this, seleccion, Toast.LENGTH_SHORT).show();
            }
        });
    }

    public class Adapter extends ArrayAdapter<List_Tourism> {

        public Adapter(Context context, List_Tourism[] Tour) {
            super(context, R.layout.layout_tourism, Tour);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            LayoutInflater inflater = LayoutInflater.from(getContext());
            View item = inflater.inflate(R.layout.layout_tourism, null);

            TextView nameT = (TextView) item.findViewById(R.id.id_nameTour);
            nameT.setText(Tour[position].getNameItem());

            TextView des1T = (TextView) item.findViewById(R.id.id_Desc1Tour);
            des1T.setText(Tour[position].getDesc1Item());

            TextView des2T = (TextView) item.findViewById(R.id.id_Desc2Tour);
            des2T.setText(Tour[position].getDesc2Item());

            ImageView imagenT = (ImageView) item.findViewById(R.id.id_ImgTour);
            imagenT.setImageResource(Tour[position].getIdImage());

            return (item);
        }

    }@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_tourism, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.id_menu) {
            //Toast.makeText(TourismActivity.this, "Menu", Toast.LENGTH_LONG).show();
            Intent i =new Intent(getBaseContext(),MainActivity.class);
            startActivity(i);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
