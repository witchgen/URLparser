package ru.javatest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
Парсер реквестов
Считать с консоли URL-ссылку.
Вывести на экран через пробел список всех параметров (Параметры идут после ? и разделяются &, например, lvl=15).
URL содержит минимум 1 параметр.
Выводить параметры нужно в той же последовательности, в которой они представлены в URL.
Если присутствует параметр obj, то передать его значение в нужный метод alert.
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        //add your code here
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String url = reader.readLine();
        String cleanURL = (url.substring(url.indexOf("?"))).substring(1); //  Отсекаем все, что находится за '?'
        String[] params = cleanURL.split("&");
        List<String> urlList = new LinkedList<>();
        List<Object> paramlist = new LinkedList<>();
        for (String s : params) {
            if(s.split("=")[0].equals("obj"))
                paramlist.add(s.split("=")[1]);
            urlList.add(s.split("=")[0]);
        }
        for(String s:urlList) System.out.print(s+" ");
        System.out.print("\n");
        for(Object o:paramlist)
        {
            try {
                alert(Double.parseDouble((String)o));
            } catch (IllegalArgumentException ia_e) {
                alert((String) o);
            }
        }
    }

    public static void alert(double value) {
        System.out.println("double: " + value);
    }

    public static void alert(String value) {
        System.out.println("String: " + value);
    }
}
