package be.technifutur.decouverte.thread.callback;

import java.util.function.Consumer;

public class TestTarte {

    public static void main(String[] args) {
        commandeTarte("fraise",(t)->t.manger());
        System.out.println("je fais quelque chose en attendant la tarte" );
    }

    private static void commandeTarte(String gout, Consumer<Tarte> action) {
        // 1 créer un Runnable avec le code à effecuer par le Thread
        Runnable r = ()->{
            // le code de la méthode run
            Tarte tarte = new ServeurDeTarte().getTarte(gout);
            action.accept(tarte);
        };
        // 2. créer le thread avec le Runnable
        Thread thread = new Thread(r);

        // 3. lancer le Thread
        thread.start();

        new Thread(()->action.accept(new ServeurDeTarte().getTarte(gout))).start();

    }

    public void runnablewithLambda(){
        Runnable r = ()->{
            // le code de la méthode run
        };
    }
}
