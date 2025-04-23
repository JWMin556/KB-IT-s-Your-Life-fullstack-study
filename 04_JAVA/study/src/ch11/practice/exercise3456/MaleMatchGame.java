package ch11.practice.exercise3456;

import ch11.practice.exercise2.Celebrity;

public class MaleMatchGame extends MatchGame {
    private Celebrity[] inputCelebrities;
    public MaleMatchGame(Celebrity[] celebrityList) {
        this.inputCelebrities = celebrityList;
        initializeCandidates();
    }

    @Override
    public void initializeCandidates() {
        super.candidates = new Celebrity[inputCelebrities.length];
        for (int i = 0; i < inputCelebrities.length; i++) {
            super.candidates[i] = inputCelebrities[i];
        }
    }

    @Override
    public Celebrity playGame() {
        return null;
    }

    @Override
    public void printCandidates() {
        System.out.println("[남자 연예인 월드컵 참가자 명단]");
        super.printCandidates();
    }
}
