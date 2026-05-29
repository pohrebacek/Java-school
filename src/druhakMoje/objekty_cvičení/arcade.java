package objekty_cvičení;

public class arcade {
    int score;
    int playersJoined;
    final int MAX_PLAYERS = 3;
    int highScore;

    public arcade() {
        score = 0;
        highScore = 0;
        playersJoined = 0;
    }


    void login(){
        if (playersJoined < MAX_PLAYERS){
            playersJoined++;
        }
    }


    void logout(){
        if (playersJoined > 0){
            playersJoined--;
            if (playersJoined == 0){
                score = 0;
            }
        }
    }


    void scoreIncrease(int score){
        if (playersJoined > 0){
            this.score += score;
            if (this.score > highScore){
                highScore = this.score;
            }
        }
    }


    public int getScore() {
        return score;
    }

    public int getHighestScore() {
        return highScore;
    }


    void scoreDecrease(int score){
        if (playersJoined > 0 && score <= this.score){
            this.score -= score;
        }
    }

}
