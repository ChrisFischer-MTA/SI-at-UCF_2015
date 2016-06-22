/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cat;

/**
 *
 * @author Chris
 */
public class CatRunner {

    public static void main(String args[]) {
        Cat c = new Cat("Johnny");
        c.setBreed("Tabby");
        c.eat(5000);
        c.meow();
        c.poop();
        System.out.println(c.getWeight());
        c.walk();
        walkAllCats(new Cat[]{c});
    }
    
    public static void walkAllCats(Cat[] cats){
        for(int i = 0; i < cats.length; i++)
            cats[i].walk();
    }

}
