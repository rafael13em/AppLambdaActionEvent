/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package applambdaactionevent;

import static java.lang.Math.pow;
import java.text.DecimalFormat;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author Rafael
 */
public class AppLambdaActionEvent extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        Label lb1 = new Label("Annual Interest Rate:");
        TextField txt1 = new TextField();
        Label lb2 = new Label("Number of Years:");
        TextField txt2 = new TextField();
        Label lb3 = new Label("Loan Amount:");
        TextField txt3 = new TextField();
        Label lb4 = new Label("Number of Years:");
        TextField txt4 = new TextField();
        Label lb5 = new Label("Total Payment: ");
        TextField txt5 = new TextField();
        Button btn = new Button("Calculate");
        
        btn.setOnAction(e->{
            String cad;
            double h, i, r, m;
            int n;
            boolean bol=true;
            cad=txt1.getText();
            for(int j=0, k=0; j<cad.length() && bol; ++j){
                if(!Character.isDigit(cad.charAt(j)) && cad.charAt(j)!= '.')
                    bol=false;
                else if(k==0 && cad.charAt(j)== '.')
                    k++;
                else if(k!=0 && cad.charAt(j)== '.')
                    bol=false;
            }
            if(!bol)
            {
                txt4.setText("Annual Interest Rate introduced is not a number");
                txt5.setText("Annual Interest Rate introduced is not a number");
                return;
            }
            
            i = Double.parseDouble(cad);
            
            cad=txt2.getText();
            for(int j=0; j<cad.length() && bol; ++j){
                if(!Character.isDigit(cad.charAt(j)))
                    bol=false;
            }
            if(!bol)
            {
                txt4.setText("Number of Years introduced is not a number");
                txt5.setText("Number of Years introduced is not a number");
                return;
            }
            
            n = Integer.parseInt(cad);
            
            cad=txt3.getText();
            for(int j=0, k=0; j<cad.length() && bol; ++j){
                if(!Character.isDigit(cad.charAt(j)) && cad.charAt(j)!= '.')
                    bol=false;
                else if(k==0 && cad.charAt(j)== '.')
                    k++;
                else if(k!=0 && cad.charAt(j)== '.')
                    bol=false;
            }
            if(!bol)
            {
                txt4.setText("Monthly Payment introduced is not a number");
                txt5.setText("Monthly Payment introduced is not a number");
                return;
            }
            
            h = Double.parseDouble(cad);
            
            r=i/(100*12);
            m=(h*r)/(1-Math.pow((1+r), -12*n));
            txt4.setText("$"+new DecimalFormat("#.##").format(m));
            txt5.setText("$"+new DecimalFormat("#.##").format(m*n*12));
        });
        
        GridPane root = new GridPane();
        root.add(lb1, 0, 0);
        root.add(txt1, 1, 0);
        root.add(lb2, 0, 1);
        root.add(txt2, 1, 1);
        root.add(lb3, 0, 2);
        root.add(txt3, 1, 2);
        root.add(lb4, 0, 3);
        root.add(txt4, 1, 3);
        root.add(lb5, 0, 4);
        root.add(txt5, 1, 4);
        root.add(btn, 0, 5);
        
        root.setAlignment(Pos.CENTER);
        root.setVgap(10);
        root.setHgap(10);
        
        Scene scene = new Scene(root, 300, 250);
        
        primaryStage.setTitle("");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
