package fun.gladkikh.app.popularlibraryjava.lesson1.task2.view;


import moxy.MvpView;
import moxy.viewstate.strategy.AddToEndStrategy;
import moxy.viewstate.strategy.StateStrategyType;

public interface MyView extends MvpView {
    @StateStrategyType(value = AddToEndStrategy.class)
    void showMessage(String message);
}
