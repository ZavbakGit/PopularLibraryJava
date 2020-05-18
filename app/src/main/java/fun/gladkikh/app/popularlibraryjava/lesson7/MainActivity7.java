package fun.gladkikh.app.popularlibraryjava.lesson7;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import fun.gladkikh.app.popularlibraryjava.R;

public class MainActivity7 extends AppCompatActivity {

    @BindView(R.id.btStart)
    Button btStart;

    @BindView(R.id.tvMessage)
    TextView tvMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main7);
        ButterKnife.bind(this);

        btStart.setOnClickListener(v -> {
            tvMessage.setText("espresso-тест");
        });
    }
}
