package fun.gladkikh.app.popularlibraryjava.lesson2.task2;

import java.util.Date;
import java.util.Observable;

class SoursSpam extends Observable {
    private Spam spam;

    public Spam getSpam() {
        return spam;
    }

    /**
     * Без этого не работало :-(
     * @return
     */
    @Override
    public synchronized boolean hasChanged() {
        return true;
    }

    void send() {
        spam = new Spam("This is spam - " + new Date());
        notifyObservers();
    }
}
