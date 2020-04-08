package org.step.fourth.creation;

public class ThreadRunner {

    public static void main(String[] args) {
        Talk talk = new Talk();
        Thread walk = new Thread(new Walk());

        /*
        Если сделать подобным образом, наши действия будут запускаться
        в одном потоке, следовательно выполнятся поочередно
         */
//        Walk walkSecond = new Walk();
//        walkSecond.run();

        talk.start();
        walk.start();
    }
}
