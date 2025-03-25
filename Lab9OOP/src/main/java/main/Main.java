package main;
import controlPackage.ControlClass;


public class Main {
    public static void main(String[] args) {
        new Main().run();
    }
    private void run(){
        ControlClass controlClass = new ControlClass();
        controlClass.startMethod();
    }
}

