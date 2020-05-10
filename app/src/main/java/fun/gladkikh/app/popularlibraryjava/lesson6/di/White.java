package fun.gladkikh.app.popularlibraryjava.lesson6.di;

public class White {
    private ShowColor showColor;

    public White(ShowColor showColor) {
        this.showColor = showColor;
        showColor.show();
    }
}
