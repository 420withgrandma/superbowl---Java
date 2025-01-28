public class Superbowl {
    private int year;
    private String superbowlNumber;
    private String winningTeam;
    private int winningScore;
    private String losingTeam;
    private int losingScore;
    private String mvp;
    private String stadium;
    private String city;
    private String state; //In this section a class is defined as superbowl with multiple variables

    public Superbowl(int year, String superbowlNumber, String winningTeam, int winningScore,
                     String losingTeam, int losingScore, String mvp, String stadium, String city, String state) {
        this.year = year;
        this.superbowlNumber = superbowlNumber;
        this.winningTeam = winningTeam;
        this.winningScore = winningScore;
        this.losingTeam = losingTeam;
        this.losingScore = losingScore;
        this.mvp = mvp;
        this.stadium = stadium;
        this.city = city;
        this.state = state; 
    } //In this section a contructor is defined for superbowl which assigns values to its fields

    public int getYear() {
        return year;
    }

    public String getSuperbowlNumber() {
        return superbowlNumber;
    }

    public String getWinningTeam() {
        return winningTeam;
    }

    public String getLosingTeam() {
        return losingTeam;
    }

    public String getState() {
        return state;
    }

    public String getCity() {
        return city;
    }

    public String getStadium() {
        return stadium;
    } //In this section it allows access to the private fields from outside the class

    @Override
    public String toString() {
        return new StringBuilder()
                .append("Superbowl ").append(superbowlNumber).append("\n")
                .append("Year: ").append(year).append("\n")
                .append("Winner: ").append(winningTeam).append(" (").append(winningScore).append(" points)\n")
                .append("Loser: ").append(losingTeam).append(" (").append(losingScore).append(" points)\n")
                .append("MVP: ").append(mvp).append("\n")
                .append("Venue: ").append(stadium).append(", ").append(city).append(", ").append(state).append("\n")
                .toString();
    }
} //In this section the code overides the superbowl class

