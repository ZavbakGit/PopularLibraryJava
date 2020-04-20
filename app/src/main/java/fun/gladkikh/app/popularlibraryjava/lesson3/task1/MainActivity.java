package fun.gladkikh.app.popularlibraryjava.lesson3.task1;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.concurrent.TimeUnit;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import fun.gladkikh.app.popularlibraryjava.R;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    private Disposable disposable;

    @BindView(R.id.tvMessage)
    TextView tvMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_lesson2_1);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.btSubscribe})
    public void onClickButtonSubscribe(View view){
        if (disposable != null && !disposable.isDisposed()){
            return;
        }

        disposable = Observable.interval(1, TimeUnit.SECONDS)
                .map(it-> "Message: " + it)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(it-> tvMessage.setText(it));
    }

    @OnClick({R.id.btUnsubscribe})
    public void onClickButtonUnSubscribe(View view){
        disposable.dispose();
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (disposable != null){
            disposable.dispose();
        }
    }
}
