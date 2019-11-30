package frame_excercise;

import java.applet.Applet;
import java.awt.*;

public class MenuDemo extends Applet {
    public static void main(String args[]){

        MenuBar demoMenu = new MenuBar();

        //file menu
        Menu file = new Menu("File");

        MenuItem itemFile1 = new MenuItem("New");
        file.add(itemFile1);

        MenuItem itemFile2 = new MenuItem("Open");
        file.add(itemFile2);

        MenuItem b4 = new MenuItem("Exit");
        file.add(b4);
        demoMenu.add(file);

        //edit menu
        Menu edit = new Menu("Edit");

        MenuItem itemEdit1 = new MenuItem("Copy");
        edit.add(itemEdit1);

        MenuItem itemEdit2 = new MenuItem("Cut");
        edit.add(itemEdit2);

        Menu options = new Menu("Options");
        MenuItem itemOption1 = new MenuItem("First");
        options.add(itemOption1);

        MenuItem itemOption2 = new MenuItem("Second");
        options.add(itemOption2);

        MenuItem itemOption3 = new MenuItem("Third");
        options.add(itemOption3);

        edit.add(options);
        demoMenu.add(edit);

        Frame frame = new Frame("Demo Menu");
        frame.setMenuBar(demoMenu);
        frame.pack();
        frame.setSize(400, 300);
        frame.setVisible(true);

    }
}
