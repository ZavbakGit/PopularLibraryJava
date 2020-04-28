package fun.gladkikh.app.popularlibraryjava.lesson5.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import fun.gladkikh.app.popularlibraryjava.R;
import fun.gladkikh.app.popularlibraryjava.lesson5.presenter.Presenter;

public class MainActivity extends AppCompatActivity
        implements MyView {

    private Presenter presenter;

    @BindView(R.id.tvMessage)
    TextView tvMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_lesson5);
        ButterKnife.bind(this);
        presenter = new Presenter(this);

    }

    @OnClick(R.id.btShowUser)
    public void onClickBtShow(View view){
        presenter.showUsers();
    }

    @OnClick(R.id.btInsert)
    public void onClickInsert(View view){
        presenter.insert();
    }

    @OnClick(R.id.btInsertSeveral)
    public void onClickInsertSeveral(View view){
        presenter.insertSeveral();
    }

    @OnClick(R.id.btDelete)
    public void onClickDelete(View view){
        presenter.delete();
    }

    @OnClick(R.id.btUpdate)
    public void onClickUpdate(View view){
        presenter.update();
    }

    @Override
    public void showMessage(String message) {
        tvMessage.setText(message);
    }
}
