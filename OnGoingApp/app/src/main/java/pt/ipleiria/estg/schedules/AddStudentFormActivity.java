package pt.ipleiria.estg.schedules;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import pt.ipleiria.estg.schedules.Model.Classe;
import pt.ipleiria.estg.schedules.Model.ClassesWeekManager;
import pt.ipleiria.estg.schedules.Model.Student;
import pt.ipleiria.estg.schedules.databinding.ActivityAddStudentFormBinding;
import pt.ipleiria.estg.schedules.databinding.ActivityClasseDetailsBinding;

public class AddStudentFormActivity extends AppCompatActivity {

    private static final String CLASSE_INDEX = "classeIndex";
    private ActivityAddStudentFormBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityAddStudentFormBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        //EdgeToEdge.enable(this);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        setSupportActionBar(binding.toolbarForm);
        binding.btnAddStudent.setOnClickListener(this::onAddStudentClicked);

       /* binding.btnAddStudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onAddStudentClicked();
            }
        });*/
    }

    private void onAddStudentClicked(View v){
        Student student = new Student(binding.etnStudentNumber.getText().toString(), Long.parseLong(binding.etnStudentNumber.getText().toString()));

        ClassesWeekManager.INSTANCE.adicionar(student);

        int idx = getIntent().getIntExtra(CLASSE_INDEX, -1);
        Classe classe = ClassesWeekManager.INSTANCE.getClasse(idx);

        classe.addStudent(student);

        finish();
    }

    public static Intent createIntent(Context context, int index){
        Intent intent = new Intent(context, AddStudentFormActivity.class);
        intent.putExtra(CLASSE_INDEX, index);
        return intent;
    }
}