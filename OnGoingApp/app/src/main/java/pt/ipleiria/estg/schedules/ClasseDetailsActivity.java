package pt.ipleiria.estg.schedules;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import pt.ipleiria.estg.schedules.Model.Classe;
import pt.ipleiria.estg.schedules.Model.ClassesWeekManager;
import pt.ipleiria.estg.schedules.databinding.ActivityClasseDetailsBinding;

public class ClasseDetailsActivity extends AppCompatActivity {

    private ActivityClasseDetailsBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityClasseDetailsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        EdgeToEdge.enable(this);
        ViewCompat.setOnApplyWindowInsetsListener(binding.main, (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        int index = getIntent().getIntExtra("classeIndex", -1);

        if(index == -1) {
            Toast.makeText(this, "Class Inexistent", Toast.LENGTH_SHORT).show();
            finish();
            return;
        }

        Classe classe = ClassesWeekManager.INSTANCE.getClasses().get(index);

        binding.tvClasseName.setText(classe.getName());
        binding.tvNumber.setText("sac");
        binding.tvSchedule.setText(classe.getSchedule().toString());
        binding.tvRoom.setText(classe.getRoom().toString());
        binding.tvTeacherName.setText(classe.getTeacher().getName());


    }
}