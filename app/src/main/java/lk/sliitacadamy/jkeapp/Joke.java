package lk.sliitacadamy.jkeapp;

public class Joke {
int id;
String Type;
String Setup;
String PunchLine;

    public Joke(int id, String type, String setup, String punchLine) {
        this.id = id;
        Type = type;
        Setup = setup;
        PunchLine = punchLine;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public String getSetup() {
        return Setup;
    }

    public void setSetup(String setup) {
        Setup = setup;
    }

    public String getPunchLine() {
        return PunchLine;
    }

    public void setPunchLine(String punchLine) {
        PunchLine = punchLine;
    }
}
