package pl.wlodarczyk.kolokwium.GUI;


import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;
import pl.wlodarczyk.kolokwium.models.Retangle;
import pl.wlodarczyk.kolokwium.service.RetangleService;

import java.util.ArrayList;



@Route
public class RetangleGUI extends VerticalLayout {

    private RetangleService retangleService;
    private ArrayList<Retangle> male = new ArrayList<>();
    private ArrayList<Retangle> duze = new ArrayList<>();
    private TextField textFieldHeight;
    private TextField textFieldWidth;
    private Button button1;
    private Button button2;
    private Button button3;
    private Button button4;
    private Grid<Retangle> grid;


    @Autowired
    public RetangleGUI (RetangleService retangleService){
        this.retangleService = retangleService;
        textFieldHeight = new TextField("Wpisz wysokość");
        textFieldWidth = new TextField("Wpisz szerokość");
        button1 = new Button("Dodaj prostokąt");
        button2 = new Button("Pokaż prostokąty");
        button3 = new Button("Pokaż male prostokąty");
        button4 = new Button("Pokaż duze prostokąty");
        grid = new Grid<>(Retangle.class);
        button1.addClickListener(buttonClickEvent -> {addRetangle();});
        button2.addClickListener(buttonClickEvent -> {showRetangle();});
        button3.addClickListener(buttonClickEvent -> {smallCalcCircuit();});
        button4.addClickListener(buttonClickEvent -> {bigCalcCircuit();});
        add(textFieldHeight,textFieldWidth,button1, grid, button2,button3,button4);
    }

    public void addRetangle(){
        Retangle retangle = new Retangle();
        retangle.setHeight(Integer.parseInt(textFieldHeight.getValue()));
        retangle.setWidth(Integer.parseInt(textFieldWidth.getValue()));
        retangleService.add(retangle);
    }

    public void showRetangle() {
        grid.setItems(retangleService.showAll());
    }

    public void smallCalcCircuit(){
        calcCircuit();
        grid.setItems(male);
    }

    public void bigCalcCircuit(){
        calcCircuit();
        grid.setItems(duze);
    }


    public void calcCircuit(){
        ArrayList<Retangle> col = (ArrayList<Retangle>) retangleService.showAll();

        for (int i = 0; i<col.size(); i++){
            int circute = col.get(i).circute(col.get(i).getHeight(), col.get(i).getWidth());
            if (circute<20){
                male.add(col.get(i));
            }
            else {
                duze.add(col.get(i));
            }
        }
    }







}
