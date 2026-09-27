package com.Safinatun_Najah_F52124058.aplikasi_uts;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listViewConstellation;
    EditText searchConstellation;

    ArrayList<Constellation> constellationList;
    ConstellationAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listViewConstellation = findViewById(R.id.listViewConstellation);
        searchConstellation = findViewById(R.id.searchBar);

        constellationList = new ArrayList<>();

        constellationList.add(new Constellation(
                "Leo",
                "Rasi Singa yang dikenal dari bentuknya yang menyerupai singa.",
                "Diambil : April 2023",
                R.drawable.leo
        ));

        constellationList.add(new Constellation(
                "Orion",
                "Rasi Pemburu yang mudah dikenali dari tiga bintang di bagian tengahnya.",
                "Diambil : 02 January 2025",
                R.drawable.orion
        ));

        constellationList.add(new Constellation(
                "Gemini",
                "Rasi Kembar, dikenal dengan Pollux dan Castor",
                "Diambil : 09 Juni 2024",
                R.drawable.pollux
        ));

        constellationList.add(new Constellation(
                "Scorpius",
                "Rasi Kalajengking dengan bentuk melengkung yang khas di langit malam.",
                "Diambil : 09 July 2023",
                R.drawable.scorpio
        ));

        constellationList.add(new Constellation(
                "Canis Major",
                "Rasi Anjing Besar, rumah bagi Sirius",
                "Diambil : 09 Juni 2024",
                R.drawable.sirius
        ));

        adapter = new ConstellationAdapter(this, constellationList);
        listViewConstellation.setAdapter(adapter);

        searchConstellation.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                String keyword = s.toString().toLowerCase();

                ArrayList<Constellation> filteredList = new ArrayList<>();

                for (Constellation constellation : constellationList) {

                    if (constellation.name.toLowerCase().contains(keyword)
                            || constellation.description.toLowerCase().contains(keyword)) {

                        filteredList.add(constellation);
                    }
                }

                ConstellationAdapter filteredAdapter =
                        new ConstellationAdapter(MainActivity.this, filteredList);

                listViewConstellation.setAdapter(filteredAdapter);
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });
    }
}