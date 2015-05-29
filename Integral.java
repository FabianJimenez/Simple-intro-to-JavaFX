package integral;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Integral extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        
        primaryStage.centerOnScreen();
        primaryStage.sizeToScene();
        primaryStage.setTitle("Integrales");
        
        Text number = new Text("Elija una función");
        
        ObservableList<String> items = FXCollections.observableArrayList();
        items.addAll("f(x) = x", "f(x) = x^2", "f(x) = x^3");
        ComboBox<String> comboBox = new ComboBox<>(items);
        
        Text lower = new Text("Límite inferior");
        TextField lowerl = new TextField();
        
        Text upper = new Text("Límite superior");
        TextField upperl = new TextField();
        
        Text sol = new Text("Solución");
        TextField soluc = new TextField();
        
        soluc.setDisable(true);
        
        Button boton = new Button("Solucionar");
        
        GridPane root = new GridPane();
        root.setAlignment(Pos.CENTER);
        root.setHgap(20);
        root.setVgap(20);
        root.setPadding(new Insets(25,25,25,25));
        
        root.add(number,0,0);
        root.add(comboBox,1,0);
        root.add(lower,0,1);
        root.add(lowerl,1,1);
        root.add(upper,0,2);
        root.add(upperl,1,2);
        root.add(sol,0,3);
        root.add(soluc,1,3);
        root.add(boton,1,4);
        
        Scene scene = new Scene(root,Color.CADETBLUE);
        
        boton.setOnAction(new EventHandler<ActionEvent>(){
            
            public void handle(ActionEvent e)
            {
                double a,b;
                
                if(!lowerl.getText().equals("") && !upperl.getText().equals("") && !comboBox.getValue().equals(""))
                {
                    a = Double.parseDouble(lowerl.getText());
                    b = Double.parseDouble(upperl.getText());
                    
                    if(a < b)
                    {
                        Solucionador solucion = new Solucionador(a,b);

                        String funcionElegida = comboBox.getValue();                

                        int funcion;

                        if(funcionElegida.equals("f(x) = x")) funcion = 1;
                        else if(funcionElegida.equals("f(x) = x^2")) funcion = 2;
                        else funcion = 3;

                        double respuesta = solucion.resolverIntegral(funcion);

                        soluc.setText(Double.toString(respuesta));
                    }
                    else soluc.setText("Error");
                }
                else soluc.setText("Error");
            }
        });
        
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    
    public static void main(String[] args) {
        
        launch(args);
    }
    
}
