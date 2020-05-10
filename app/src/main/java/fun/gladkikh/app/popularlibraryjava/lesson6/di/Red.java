package fun.gladkikh.app.popularlibraryjava.lesson6.di;

public class Red {
    private ShowColor showColor;

    public Red(ShowColor showColor) {
        this.showColor = showColor;
        showColor.show();
    }
}
