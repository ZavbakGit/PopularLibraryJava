package fun.gladkikh.app.popularlibraryjava.lesson1.task2.presenter;



import fun.gladkikh.app.popularlibraryjava.lesson1.common.model.Model;
import fun.gladkikh.app.popularlibraryjava.lesson1.task2.view.MyView;
import moxy.InjectViewState;
import moxy.MvpPresenter;

@InjectViewState
public class Presenter extends MvpPresenter<MyView> {
    private Model model;

    @Override
    protected void onFirstViewAttach() {
        super.onFirstViewAttach();
        model = new Model();
        getViewState().showMessage(model.getMessage());
    }


    public void setMessage(String message){
        model.setMessage(message);
        getViewState().showMessage(model.getMessage());
    }
}
