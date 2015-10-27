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
            new List_Tourism[]{
                    new List_Tourism("", R.drawable.panaca, "", ""),
                    new List_Tourism("", R.drawable.parque_del_cafe_logo_verde_armenia_quindio_01, "", ""),
                    new List_Tourism("", R.drawable.logobosquesp, "", ""),
                    new List_Tourism("", R.drawable.museoguaduaybambu, "", ""),
                    new List_Tourism("", R.drawable.museoquimbaya, "", "")
            };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tourism);

        String[] Tour_var =getResources().getStringArray(R.array.List_Tour_name);
        Tour[0].setNameItem(Tour_var[0]);
        Tour[1].setNameItem(Tour_var[1]);
        Tour[2].setNameItem(Tour_var[2]);
        Tour[3].setNameItem(Tour_var[3]);
        Tour[4].setNameItem(Tour_var[4]);

        String[] Tour_var2 =getResources().getStringArray(R.array.List_Tour_Desc1);
        Tour[0].setDesc1Item(Tour_var2[0]);
        Tour[1].setDesc1Item(Tour_var2[1]);
        Tour[2].setDesc1Item(Tour_var2[2]);
        Tour[3].setDesc1Item(Tour_var2[3]);
        Tour[4].setDesc1Item(Tour_var2[4]);

        String[] Tour_var3 =getResources().getStringArray(R.array.List_Tour_Desc2);
        Tour[0].setDesc2Item(Tour_var3[0]);
        Tour[1].setDesc2Item(Tour_var3[1]);
        Tour[2].setDesc2Item(Tour_var3[2]);
        Tour[3].setDesc2Item(Tour_var3[3]);
        Tour[4].setDesc2Item(Tour_var3[4]);

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
    }
        @Override
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
                Toast.makeText(TourismActivity.this, "Menu", Toast.LENGTH_LONG).show();
                Intent i =new Intent(getBaseContext(),MainActivity.class);
                startActivity(i);
                return true;

            }

            return super.onOptionsItemSelected(item);
        }
    }

