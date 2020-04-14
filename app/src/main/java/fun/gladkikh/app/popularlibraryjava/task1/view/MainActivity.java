package fun.gladkikh.app.popularlibraryjava.task1.view;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import fun.gladkikh.app.popularlibraryjava.R;
import fun.gladkikh.app.popularlibraryjava.task1.presenter.Presenter;

public class MainActivity extends AppCompatActivity implements MyView {

    private TextView tvMessage;
    private Button btGeneral;
    private EditText edMessage;

    Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvMessage = findViewById(R.id.tvMessage);
        btGeneral = findViewById(R.id.btGeneral);
        edMessage = findViewById(R.id.edMessage);

        presenter = new Presenter(this);

        btGeneral.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.setMessage(edMessage.getText().toString());
            }
        });

    }

    @Override
    public void showMessage(String message) {
        tvMessage.setText(message);
    }
}
