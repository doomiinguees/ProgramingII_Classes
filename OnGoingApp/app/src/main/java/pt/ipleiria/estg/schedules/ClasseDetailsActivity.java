package pt.ipleiria.estg.schedules;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import pt.ipleiria.estg.schedules.Model.Classe;
import pt.ipleiria.estg.schedules.Model.ClassesWeekManager;
import pt.ipleiria.estg.schedules.Model.Student;
import pt.ipleiria.estg.schedules.databinding.ActivityClasseDetailsBinding;

public class ClasseDetailsActivity extends AppCompatActivity {

    private static final String CLASS_INDEX = "classIndex";
    private ActivityClasseDetailsBinding binding;
    int index;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityClasseDetailsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

//        EdgeToEdge.enable(this);
        ViewCompat.setOnApplyWindowInsetsListener(binding.main, (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        setSupportActionBar(binding.toolbar);


        index = getIntent().getIntExtra(CLASS_INDEX, -1);

        if(index == -1) {
            Toast.makeText(this, "Class Inexistent", Toast.LENGTH_SHORT).show();
            finish();
            return;
        }

        Classe classe = ClassesWeekManager.INSTANCE.getClasses().get(index);

        binding.tvClasseName.setText(classe.getName());
        binding.tvNumber.setText(String.valueOf(classe.getNumber()));
        binding.tvSchedule.setText(classe.getSchedule().toString());
        binding.tvRoom.setText(classe.getRoom().getName());
        binding.tvTeacherName.setText(classe.getTeacher().getName());

        //ArrayAdapter<Student> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, classe.getStudents());

        binding.lvStudents.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, classe.getStudents()));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.detailsmenu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.menuAddStudent) {
            Toast.makeText(this, "Adddddd", Toast.LENGTH_SHORT).show();

            startActivity(AddStudentFormActivity.createIntent(
                    this,
                    index
            ));

            return true;
        }
        return false;
    }

    public static Intent createIntent(Context context, int index) {
        Intent intent = new Intent(context, ClasseDetailsActivity.class);
        intent.putExtra(CLASS_INDEX, index);

        return intent;
    }
}