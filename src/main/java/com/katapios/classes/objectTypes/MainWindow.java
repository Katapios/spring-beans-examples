package com.katapios.classes.objectTypes;

public class MainWindow {

    private MainWindow() {
    }

    //lazy load thread safe singleton
    private static class MainWindowHolder {
        static MainWindow instance = new MainWindow();
    }

    //fabric method
    public static MainWindow getInstance() {
        return MainWindowHolder.instance;
    }

    public void showMainWindow() {
        System.out.println("Show main window");
    }

    public void openConnection(){
        System.out.println("MainWindow opens connection");
    }

    public void closeConnection(){
        System.out.println("MainWindow closes connection");
    }
}
