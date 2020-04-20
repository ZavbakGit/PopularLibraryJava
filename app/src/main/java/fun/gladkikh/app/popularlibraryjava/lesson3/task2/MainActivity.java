package fun.gladkikh.app.popularlibraryjava.lesson3.task2;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import fun.gladkikh.app.popularlibraryjava.R;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    private Disposable disposable;

    @BindView(R.id.tvMessage)
    TextView tvMessage;

    @BindView(R.id.progressBar)
    ProgressBar progressBar;

    private Single<String> getSingleRequest() {
        return Single.just("Message: " + new Date())
                .delay(3, TimeUnit.SECONDS);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_lesson3_2);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.btStart})
    public void onClickButtonStart(View view) {
        if (disposable != null && !disposable.isDisposed()) {
            return;
        }

        disposable = getSingleRequest()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe(disposable1 -> {
                    tvMessage.setText("");
                    progressBar.setVisibility(View.VISIBLE);
                })
                .doFinally(() -> {
                    progressBar.setVisibility(View.GONE);
                })
                .subscribe(it -> tvMessage.setText(it));
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (disposable != null){
            disposable.dispose();
        }
    }
}
