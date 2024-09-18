import java.util.HashMap;
import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.Scanner;
public class Main{
    private static int caloriesConsumed;
    private static int caloriesGoal;
    private static HashMap<String, Integer> userDataMap;
//MAIN
    public static void main(String[] args){
        getCalorieGoal();
        caloriesConsumed= 500;
        setUpInterface(700, 700);
    }


    private static void getCalorieGoal(){
        caloriesGoal=getNumericalInput("Calorie goal: ");
    }
    private static int getNumericalInput(String prompt){
        Scanner sc= new Scanner(System.in);
        try{
            System.out.println(prompt);
            return sc.nextInt();
        }catch(Exception exc){
            return getNumericalInput(prompt);
        }
    }
    private static void setUpInterface(int width, int height){
        JFrame frame= new JFrame();
        frame.setSize(width, height);
        frame.setLayout(new GridLayout(3,1));

    //JELEMENT
        JLabel lblCalConsumed= new JLabel(setCalConsumedLabel(caloriesConsumed, caloriesGoal));
        frame.add(lblCalConsumed);
        frame.add(setMealsPanel());
        frame.add(new JLabel("current weight: ; goal weight: "));
        frame.setVisible(true);
    }
    private static String setCalConsumedLabel(int consumed, int goal){
        int numTicks= 100;
        String strCalConsumed= "Today: "+consumed+"/"+goal+" " ;
        int dashes=(int)((float)consumed/(float)goal*numTicks);
        for(int i=0; i< dashes; i++){
            strCalConsumed+="-";
        }
        for(int i=0; i<numTicks-dashes; i++){
            strCalConsumed+="/";
        }
        return strCalConsumed;
    }
    private static JPanel setMealsPanel(){
        JPanel mealsPanel= new JPanel();
        mealsPanel.setLayout(new GridLayout(3,2));
                mealsPanel.add(new JButton("button"));

        mealsPanel.add(new JButton("button"));

        return mealsPanel;
    }



}
