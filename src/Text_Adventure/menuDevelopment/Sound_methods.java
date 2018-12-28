package Text_Adventure.menuDevelopment;

import java.io.Serializable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Sound_methods implements Serializable {
    public static Play_Sound soundFX = new Play_Sound();
    public static void kickSound(){
        ExecutorService Thread = Executors.newFixedThreadPool(4);
        Thread.submit(new Runnable() {public void run() { soundFX.playSound("sounds/kick.wav"); }});
    }
    public static void missSound(){
        ExecutorService Thread = Executors.newFixedThreadPool(4);
        Thread.submit(new Runnable() {public void run() { soundFX.playSound("sounds/miss.wav"); }});
    }
    public static void winSound(){
        ExecutorService Thread = Executors.newFixedThreadPool(4);
        Thread.submit(new Runnable() {public void run() { soundFX.playSound("sounds/gameWon.wav"); }});
    }
    public static void loseSound(){
        ExecutorService Thread = Executors.newFixedThreadPool(4);
        Thread.submit(new Runnable() {public void run() { soundFX.playSound("sounds/loseGame.wav"); }});
    }
    public static void treasureSound(){
        ExecutorService Thread = Executors.newFixedThreadPool(4);
        Thread.submit(new Runnable() {public void run() { soundFX.playSound("sounds/treasure.wav"); }});
    }

    public static void playerDeathSound(){
        ExecutorService Thread = Executors.newFixedThreadPool(4);
        Thread.submit(new Runnable() {public void run() { soundFX.playSound("sounds/playerDeath.wav"); }});
    }
    public static void monsterDeathSound(){
        ExecutorService Thread = Executors.newFixedThreadPool(4);
        Thread.submit(new Runnable() {public void run() { soundFX.playSound("sounds/monsterDeath.wav"); }});
    }
    public static void laughSound(){
        ExecutorService Thread = Executors.newFixedThreadPool(4);
        Thread.submit(new Runnable() {public void run() { soundFX.playSound("sounds/laugh.wav"); }});
    }
    public void backpackSound(){
        ExecutorService Thread = Executors.newFixedThreadPool(4);
        Thread.submit(new Runnable() {public void run() { soundFX.playSound("sounds/openBackPack.wav"); }});
    }
    public void drinkPotionSound(){
        ExecutorService Thread = Executors.newFixedThreadPool(4);
        Thread.submit(new Runnable() {public void run() { soundFX.playSound("sounds/drinkPotion.wav"); }});
    }
    public void dropPotionSound(){
        ExecutorService Thread = Executors.newFixedThreadPool(4);
        Thread.submit(new Runnable() {public void run() { soundFX.playSound("sounds/dropItem.wav"); }});
    }
    public void walkSound(){
        ExecutorService Thread = Executors.newFixedThreadPool(4);
        Thread.submit(new Runnable() {public void run() { soundFX.playSound("sounds/walking.wav"); }});
    }
    public void menuSound(){
        ExecutorService Thread = Executors.newFixedThreadPool(4);
        Thread.submit(new Runnable() {public void run() { soundFX.playSound("sounds/click.wav"); }});
    }
}
