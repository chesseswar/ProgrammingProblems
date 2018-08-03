package Centennial_Minicontest_2016;

import java.util.*;
import java.io.*;

public class CraftMaster {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(new File("input.txt"));
        //Scanner in = new Scanner(System.in);
        int numRecipe = in.nextInt();
        HashMap<String,Ingredient> ingredients = new HashMap<>();
        Ingredient[] recipes = new Ingredient[numRecipe];
        for (int i = 0; i < numRecipe; i++){
            String name = in.next();
            Ingredient ingredient = new Ingredient(name);
            if (!ingredients.containsKey(name)) {
                ingredients.put(name,ingredient);
            }
            recipes[i] = ingredient;
            int numIngredients = in.nextInt();
            for (int j = 0; j < numIngredients; j++){
                int amt = in.nextInt();
                String title = in.next();
                Ingredient ingredient1 = new Ingredient(title);
                if (!ingredients.containsKey(title)){
                    ingredients.put(title,ingredient1);
                }
                ingredients.get(name).ingredients.put(ingredient1,amt);
            }
        }

        String input = in.next();
        while (!input.equals("GO")){
            HashMap<Ingredient,Integer> amts = recurse(ingredients,input,new HashMap<>(),1);
            ArrayList<String> output = new ArrayList<>();
            for (Ingredient i : amts.keySet()){
                output.add(i.name);
            }

            System.out.println("[" + input + "]");
            Collections.sort(output);
            for (String s : output){
                System.out.println(s + " " + amts.get(ingredients.get(s)));
            }
            input = in.next();
        }
    }

    public static HashMap<Ingredient,Integer> recurse(HashMap<String,Ingredient> ingredients, String start, HashMap<Ingredient,Integer> output, int multiple){
        if (ingredients.get(start).ingredients.size() == 0){
            if (output.containsKey(ingredients.get(start))){
                output.put(ingredients.get(start),multiple + output.get(ingredients.get(start)));
            } else {
                output.put(ingredients.get(start),multiple);
            }
        } else {
            for (Ingredient i : ingredients.get(start).ingredients.keySet()){
                recurse(ingredients,i.name,output,ingredients.get(start).ingredients.get(i) * multiple);
            }
        }


        return output;
    }
}

class Ingredient {
    String name;
    HashMap<Ingredient,Integer> ingredients;
    int amt;
    public Ingredient(String input){
        name = input;
        ingredients = new HashMap<>();
        amt = 0;
    }

    public String toString(){
        return name;
    }
}
