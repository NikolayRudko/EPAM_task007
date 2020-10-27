package com.epam.task.seven.observer;

import com.epam.task.seven.empty.Ellipse;

public interface Observable {
    void addObserver(Observer observer);

    void removeObserver(Observer observer);

    void notifyObserver();
}
