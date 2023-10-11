package sew9.worttrainer.swewalka.tgm.model;

import sew9.worttrainer.swewalka.tgm.controller.Controller;

public class Game {
    Session session;
    Data data;

    Controller controller;

    public Game(Session session, Data data) {
        this.session = session;
        this.data = data;
    }

    public String getCurrentImage(){
        return data.getBildLink(session.getCurrent());
    }

    public void play(String guess){
        if (guess.equals(data.getWord(session.getCurrent()))){
            won();
        } else {
            lost();
        }
    }

    private void won(){
        session.won();
        //TODO Message to Controller
    }

    private void lost(){
        session.lost();
        //TODO Message to Controller
    }
}
