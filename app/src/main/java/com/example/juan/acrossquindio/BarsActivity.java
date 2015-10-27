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

public class BarsActivity extends AppCompatActivity {
    ListView listBars;

    private List_Bars[] Bars =
            new List_Bars[] {
                    new List_Bars("",R.drawable.mariajuana,""),
                    new List_Bars("",R.drawable.guitarrayrumba,""),
                    new List_Bars("",R.drawable.shangodisco,"")};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bars);

        String[] Bars_var =getResources().getStringArray(R.array.List_Bars_name);
        Bars[0].setNameItem(Bars_var[0]);
        Bars[1].setNameItem(Bars_var[1]);
        Bars[2].setNameItem(Bars_var[2]);

        String[] Bars_var2 =getResources().getStringArray(R.array.List_Bars_Desc);
        Bars[0].setDescItem(Bars_var2[0]);
        Bars[1].setDescItem(Bars_var2[1]);
        Bars[2].setDescItem(Bars_var2[2]);


        Adapter adapter3 = new Adapter(this, Bars);
        listBars = (ListView) findViewById(R.id.id_ListBars);
        listBars.setAdapter(adapter3);
        listBars.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String seleccion = ((List_Bars) parent.getItemAtPosition(position)).getNameItem();
                Toast.makeText(BarsActivity.this, seleccion, Toast.LENGTH_SHORT).show();

            }
        });
    }

    public class Adapter extends ArrayAdapter<List_Bars> {

        public Adapter(Context context, List_Bars[] Bars) {
            super(context, R.layout.layout_bars, Bars);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            LayoutInflater inflater = LayoutInflater.from(getContext());
            View item = inflater.inflate(R.layout.layout_bars, null);

            TextView nameB = (TextView) item.findViewById(R.id.id_nameBar);
            nameB.setText(Bars[position].getNameItem());

            TextView desH = (TextView) item.findViewById(R.id.id_DescBar);
            desH.setText(Bars[position].getDescItem());

            ImageView imagenB = (ImageView) item.findViewById(R.id.id_imgBar);
            imagenB.setImageResource(Bars[position].getIdImage());

            return (item);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_bars, menu);
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
            Toast.makeText(BarsActivity.this, "Menu", Toast.LENGTH_LONG).show();
            Intent i =new Intent(getBaseContext(),MainActivity.class);
            startActivity(i);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
