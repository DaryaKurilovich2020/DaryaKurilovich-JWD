package com.epam.jwd.storage;

import com.epam.jwd.model.Figure;
import com.epam.jwd.model.FigureType;
import com.epam.jwd.model.Point;

public class Storage {
    private static Storage storage;
    private final int INIT_SIZE = 16;
    private final int CUT_RATE = 4;
    private Figure[] array = new Figure[INIT_SIZE];
    private int pointer = 0;

    public static Storage getStorage() {
        if (storage == null) return new Storage();
        else return storage;
    }


    private Storage() {
    }

    /*
    Добавляет новый элемент в список. При достижении размера внутреннего
    массива происходит его увеличение в два раза.
    */
    public void add(Figure item) {
        if (pointer == array.length - 1)
            resize(array.length * 2); // увеличу в 2 раза, если достигли границ
        array[pointer++] = item;
    }

    /*
    Возвращает элемент списка по индексу.
    */
    public Figure get(int index) {
        return array[index];
    }

    /*
    Удаляет элемент списка по индексу. Все элементы справа от удаляемого
    перемещаются на шаг налево. Если после удаления элемента количество
    элементов стало в CUT_RATE раз меньше чем размер внутреннего массива,
    то внутренний массив уменьшается в два раза, для экономии занимаемого
    места.
    */
    public void remove(int index) {
        for (int i = index; i < pointer; i++)
            array[i] = array[i + 1];
        array[pointer] = null;
        pointer--;
        if (array.length > INIT_SIZE && pointer < array.length / CUT_RATE)
            resize(array.length / 2); // если элементов в CUT_RATE раз меньше чем
        // длина массива, то уменьшу в два раза
    }

    /*Возвращает количество элементов в списке*/
    public int size() {
        return pointer;
    }

    /*Вспомогательный метод для масштабирования.*/
    private void resize(int newLength) {
        Figure[] newArray = new Figure[newLength];
        System.arraycopy(array, 0, newArray, 0, pointer);
        array = newArray;
    }

    public Figure contains(Point[] points, FigureType figureType) {
        if(array[0]!=null) {
            for (int i = 0; i < array.length; i++) {
                if (array[i].getFigureType() == figureType && checkArraysEquality(points, array[i].getPoints())) {
                    return array[i];
                }
            }
        }
            return null;
    }

    public static boolean checkArraysEquality(Point[] points1, Point[] points2) {
        int count = 0;
        for (int i = 0; i < points1.length; i++) {
            for (int j = 0; j < points1.length; j++) {
                if (points1[i] == points2[j]) {
                    count++;
                    break;
                }
            }
        }
        return count == points1.length ? true : false;
    }
}


