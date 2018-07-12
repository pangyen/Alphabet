package com.example.fatinnabila.alphabet;

import android.view.View;
import android.widget.AdapterView;
import java.util.ArrayList;

        import android.content.Intent;
        import android.os.Bundle;
        import android.support.v7.app.AppCompatActivity;
        import android.view.View;
        import android.widget.AdapterView;
        import android.widget.AdapterView.OnItemClickListener;
        import android.widget.GridView;

        import com.example.fatinnabila.alphabet.adapter.CustomGridViewAdapter;
        import com.example.fatinnabila.alphabet.model.Items;

public class MainActivity extends AppCompatActivity {
    GridView grid;

    // String array for image titles
    private static final String title[] = { "Ants", "Bear", "Cat",
            "Duck", "Elephant", "fish","Goat","Hippo"};

    // Integer array for drawable images
    private static final Integer Images[] = { R.drawable.a,
            R.drawable.b, R.drawable.c, R.drawable.d,
            R.drawable.e, R.drawable.f, R.drawable.g,R.drawable.h};

    ArrayList<Items> arrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        grid = (GridView) findViewById(R.id.gridView1);

        // Array list for storing data in Items class
        arrayList = new ArrayList<Items>();

        // For loop to add data in array list
        for (int i = 0; i < Images.length; i++) {
            arrayList.add(new Items(title[i], Images[i]));
        }

        // Setting data in custom adapter
        CustomGridViewAdapter adapter = new CustomGridViewAdapter(
                MainActivity.this, arrayList);

        grid.setAdapter(adapter);

        adapter.notifyDataSetChanged();

        grid.setOnItemClickListener(new OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int pos,
                                    long id) {

                // Starting a new activity and passing image id
                Intent in = new Intent(MainActivity.this,
                        SingleImageActivity.class);
                in.putExtra("image", arrayList.get(pos).getImages());
                in.putExtra("text", arrayList.get(pos).getTitle());
                startActivity(in);

            }
        });
    }

}
