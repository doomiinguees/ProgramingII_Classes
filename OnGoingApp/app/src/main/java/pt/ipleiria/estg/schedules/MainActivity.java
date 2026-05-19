package pt.ipleiria.estg.schedules;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.LinkedList;

import pt.ipleiria.estg.schedules.Model.Classe;
import pt.ipleiria.estg.schedules.Model.ClassesWeekManager;
import pt.ipleiria.estg.schedules.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        EdgeToEdge.enable(this);
        ViewCompat.setOnApplyWindowInsetsListener(binding.lvClasses, (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        LinkedList<Classe> classes = ClassesWeekManager.INSTANCE.getClasses();
        binding.lvClasses.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, classes));


        binding.lvClasses.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view, int index, long id) {
                Toast.makeText(MainActivity.this, "Item " + (index+1) + " clicked!", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(MainActivity.this, ClasseDetailsActivity.class).putExtra("classeIndex", index);

                startActivity(intent);
            }
        });
    }
}