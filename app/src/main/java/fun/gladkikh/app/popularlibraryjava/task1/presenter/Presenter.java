package fun.gladkikh.app.popularlibraryjava.task1.presenter;
import fun.gladkikh.app.popularlibraryjava.common.model.Model;
import fun.gladkikh.app.popularlibraryjava.task1.view.MyView;


public class Presenter {
    private MyView view;
    private Model model = new Model();

    public Presenter(MyView view) {
        this.view = view;
    }


    public void setMessage(String message){
        model.setMessage(message);
        view.showMessage(model.getMessage());
    }
}
