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

public class AccommodationActivity extends AppCompatActivity {
    ArrayAdapter<String> adapter2;
    ListView listAccom;

    private List_Accommodation[] Accom =
            new List_Accommodation[] {
                    new List_Accommodation("Bolivar Plaza Hotel\n",R.drawable.hotel_bolivarplaza,"The hotel with the best location in the downtown of Armenia. 19 modern" +
                            "                                room with private bathroom, WiFi and cable Tv.\n","Couple room from + Breakfast:\nCOP$206.000"),
                    new List_Accommodation("Decameron Panaca\n",R.drawable.hotel_decameronpanaca,"The real all inclusive, now in the Eje Cafetero. Spectacular hotel with" +
                            "                                rustic architecture inside the Panaca thematic park.\n","Couple room from + All inclusive plan:\nCOP$389.000"),
                    new List_Accommodation("Las Camelias Country Hotel\n",R.drawable.hotel_lascamelias_index,"Spectacular hotel build using typical elements of the region " +
                            "                                and with the highest quality standars in the Eje Cafetero.\n","Couple room from + Breakfast:\nCOP$275.000")};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accommodation);

        Adapter adapter2 = new Adapter(this, Accom);
        listAccom = (ListView) findViewById(R.id.id_ListAccom);
        listAccom.setAdapter(adapter2);
        listAccom.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String seleccion = ((List_Accommodation) parent.getItemAtPosition(position)).getNameItem();
                Toast.makeText(AccommodationActivity.this, seleccion, Toast.LENGTH_SHORT).show();

            }
        });
    }

    public class Adapter extends ArrayAdapter<List_Accommodation> {

        public Adapter(Context context, List_Accommodation[] Accom) {
            super(context, R.layout.layout_accommodation, Accom);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            LayoutInflater inflater = LayoutInflater.from(getContext());
            View item = inflater.inflate(R.layout.layout_accommodation, null);

            TextView nameH = (TextView) item.findViewById(R.id.id_nameHotel);
            nameH.setText(Accom[position].getNameItem());

            TextView desH = (TextView) item.findViewById(R.id.id_DescHotel);
            desH.setText(Accom[position].getDescItem());

            TextView priceH = (TextView) item.findViewById(R.id.id_priceHotel);
            priceH.setText(Accom[position].getPriceItem());

            ImageView imagenH = (ImageView) item.findViewById(R.id.id_imgHotel);
            imagenH.setImageResource(Accom[position].getIdImage());

            return (item);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_accommodation, menu);
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
            Toast.makeText(AccommodationActivity.this, "Menu", Toast.LENGTH_LONG).show();
            Intent i =new Intent(getBaseContext(),MainActivity.class);
            startActivity(i);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
