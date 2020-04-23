package fun.gladkikh.app.popularlibraryjava.lesson4.task2.view;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import fun.gladkikh.app.popularlibraryjava.R;
import fun.gladkikh.app.popularlibraryjava.lesson4.task2.presenter.Presenter;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.imageView)
    ImageView imageView;

    @BindView(R.id.edNickname)
    EditText edNickname;

    @BindView(R.id.tvNickname)
    TextView tvNickname;


    private Disposable disposable;
    private Presenter presenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_lesson4_2);
        ButterKnife.bind(this);
        presenter = new Presenter();
    }


    @OnClick(R.id.btShow)
    public void onClickBtShow(View view){

        if (disposable != null && !disposable.isDisposed()) {
            return;
        }

        disposable = presenter.getUser(edNickname.getText().toString())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(it -> {
                    tvNickname.setText(it.getLogin());

                    Picasso
                            .get()
                            .load(it.getAvatarUrl())
                            .into(imageView);
                });
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (disposable != null){
            disposable.dispose();
        }
    }
}
