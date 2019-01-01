package Text_Adventure.menuDevelopment;

import java.io.Serializable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Sound_methods implements Serializable {

    public static Play_Sound soundFX = new Play_Sound();
    public void kickSound(){
        ExecutorService Thread = Executors.newFixedThreadPool(4);
        Thread.submit(new Runnable() {public void run() { soundFX.playSound("sounds/kick.wav"); }});
    }
    public void missSound(){
        ExecutorService Thread = Executors.newFixedThreadPool(4);
        Thread.submit(new Runnable() {public void run() { soundFX.playSound("sounds/miss.wav"); }});
    }
    public void winSound(){
        ExecutorService Thread = Executors.newFixedThreadPool(4);
        Thread.submit(new Runnable() {public void run() { soundFX.playSound("sounds/gameWon.wav"); }});
    }
    public void loseSound(){
        ExecutorService Thread = Executors.newFixedThreadPool(4);
        Thread.submit(new Runnable() {public void run() { soundFX.playSound("sounds/loseGame.wav"); }});
    }
    public void treasureSound(){
        ExecutorService Thread = Executors.newFixedThreadPool(4);
        Thread.submit(new Runnable() {public void run() { soundFX.playSound("sounds/treasure.wav"); }});
    }
    public void playerDeathSound(){
        ExecutorService Thread = Executors.newFixedThreadPool(4);
        Thread.submit(new Runnable() {public void run() { soundFX.playSound("sounds/playerDeath.wav"); }});
    }
    public void monsterDeathSound(){
        ExecutorService Thread = Executors.newFixedThreadPool(6);
        Thread.submit(new Runnable() {public void run() { soundFX.playSound("sounds/monsterDeath.wav"); }});
    }
    public void laughSound(){
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
    public void pickUp(){
        ExecutorService Thread = Executors.newFixedThreadPool(4);
        Thread.submit(new Runnable() {public void run() { soundFX.playSound("sounds/pickUp.wav"); }});
    }
    public void avoidFight(){
        ExecutorService Thread = Executors.newFixedThreadPool(4);
        Thread.submit(new Runnable() {public void run() { soundFX.playSound("sounds/flee.wav"); }});
    }
    public void doorLocked(){
        ExecutorService Thread = Executors.newFixedThreadPool(4);
        Thread.submit(new Runnable() {public void run() { soundFX.playSound("sounds/locked.wav"); }});
    }
    public void unlockingDoor(){
        ExecutorService Thread = Executors.newFixedThreadPool(4);
        Thread.submit(new Runnable() {public void run() { soundFX.playSound("sounds/unlocking.wav"); }});
    }

}
