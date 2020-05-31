/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package notepad;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Separator;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.BorderPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author Marina
 */
public class NotePad extends Application {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Application.launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        //To change body of generated methods, choose Tools | Templates.
        MenuBar bar = new MenuBar(); //keda 3malt object men menu bar

        Menu file = new Menu("File"); //3mlt feh menu
        Menu edit = new Menu("Edit");
        Menu help = new Menu("Help");

        MenuItem MenuItem01 = new MenuItem("New"); //w 3malt menu item
        MenuItem01.setAccelerator(KeyCombination.keyCombination("Ctrl+n")); // w adeto accelerator

        MenuItem MenuItem02 = new MenuItem("Open..."); //w 3malt menu item
        MenuItem02.setAccelerator(KeyCombination.keyCombination("Ctrl+o")); // w adeto accelerator

        MenuItem MenuItem03 = new MenuItem("Save"); //w 3malt menu item
        MenuItem03.setAccelerator(KeyCombination.keyCombination("Ctrl+s")); // w adeto accelerator

        MenuItem MenuItem04 = new MenuItem("Exit");

        SeparatorMenuItem sep1 = new SeparatorMenuItem();
        SeparatorMenuItem sep2 = new SeparatorMenuItem();
        SeparatorMenuItem sep3 = new SeparatorMenuItem();

        MenuItem MenuItem10 = new MenuItem("Undo"); //w 3malt menu item
        MenuItem MenuItem11 = new MenuItem("Cut"); //w 3malt menu item
        MenuItem MenuItem12 = new MenuItem("Copy"); //w 3malt menu item
        MenuItem MenuItem13 = new MenuItem("Paset"); //w 3malt menu item
        MenuItem MenuItem14 = new MenuItem("Delete"); //w 3malt menu item
        MenuItem MenuItem15 = new MenuItem("Select All");

        MenuItem MenuItem21 = new MenuItem("About");

        TextArea area = new TextArea();

        file.getItems().addAll(MenuItem01, MenuItem02, MenuItem03, sep1, MenuItem04); //defna 3la el menu el menu item
        edit.getItems().addAll(MenuItem10, sep2, MenuItem11, MenuItem12, MenuItem13, MenuItem14, sep3, MenuItem15);
        help.getItems().addAll(MenuItem21);

        bar.getMenus().addAll(file, edit, help); //w 7atena fel bar el menus bta3etna
        BorderPane pane = new BorderPane(); //3amlna el pane
        pane.setTop(bar); //7oteli el bar fel top
        pane.setCenter(area);
        Scene scene = new Scene(pane, 300, 400); //a3mlei el scene
        stage.setTitle("Note Pad");
        stage.initStyle(StageStyle.DECORATED);
        stage.setScene(scene);
        stage.show();

        //new
        MenuItem01.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                area.clear(); //To change body of generated methods, choose Tools | Templates.
            }
        });

        //open
        MenuItem02.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                //To change body of generated methods, choose Tools | Templates.
                FileChooser FileCh = new FileChooser();
                File file = FileCh.showOpenDialog(stage);
                if (file != null) {
                    try {
                        FileInputStream finput = new FileInputStream(file);
                        int size = finput.available();
                        byte[] b = new byte[size];
                        finput.read(b);
                        area.setText(new String(b));
                        finput.close();

                    } catch (FileNotFoundException ex) {
                        Logger.getLogger(NotePad.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (IOException ex) {
                        Logger.getLogger(NotePad.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

            }
        });

        //save
        MenuItem03.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                
                Alert alertDialog=new Alert(AlertType.CONFIRMATION);
                alertDialog.setTitle("Confirmation Dialog");
                alertDialog.setHeaderText("Look, an Confirmation Dialog :D");
                alertDialog.setContentText("Are you sure to save?");
                
                Optional<ButtonType> result=alertDialog.showAndWait();
                if(result.get()==ButtonType.OK)
                {

                
                
                FileChooser FileCh = new FileChooser(); //3mlna file chooser
                FileChooser.ExtensionFilter filter = new FileChooser.ExtensionFilter("TXT files (*.txt)", "*.txt"); //adenalo el extension
                FileCh.getExtensionFilters().add(filter);

                File file = FileCh.showSaveDialog(stage);

                if (file != null) {
                    try {
                        FileOutputStream foutput = new FileOutputStream(file);
                        foutput.write(area.getText().getBytes());
                        foutput.close();
                        foutput.flush();
                    } catch (FileNotFoundException ex) {
                        Logger.getLogger(NotePad.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (IOException ex) {
                        Logger.getLogger(NotePad.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

            }
            }
            
        });

        //exit
        MenuItem04.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                System.exit(0);//To change body of generated methods, choose Tools | Templates.
            }
        });

        //undo
        MenuItem10.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                //To change body of generated methods, choose Tools | Templates.
                area.undo();
            }
        });

        //cut
        MenuItem11.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                //To change body of generated methods, choose Tools | Templates.
                area.cut();
            }
        });

        //copy
        MenuItem12.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                //To change body of generated methods, choose Tools | Templates.
                area.copy();
            }
        });

        //paste
        MenuItem13.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                //To change body of generated methods, choose Tools | Templates.
                area.paste();
            }
        });

        //delete
        MenuItem14.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                //To change body of generated methods, choose Tools | Templates.
                area.deletePreviousChar();
            }
        });

        //select all
        MenuItem15.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                //To change body of generated methods, choose Tools | Templates.
                area.selectAll();
            }
        });

        MenuItem21.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                //To change body of generated methods, choose Tools | Templates.
                Alert alertDialog=new Alert(AlertType.INFORMATION);
                alertDialog.setTitle("Information Dialog");
                alertDialog.setHeaderText("Look, an Information Dialog :D");
                Date d=new Date();
                
                alertDialog.setContentText("user name : Marina Medhat "+ "\n"+"Date : "+d);
                alertDialog.showAndWait();
            }
        });
    }

}
