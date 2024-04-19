public class OurNumber {

    private final Integer id;
    private final String number;
    private final Integer level;
    private Integer prevState;
    private Integer nextState;
    private String shiftBefore;
    private String shiftAfter;

    public OurNumber(Integer id, String number, Integer level) {
        this.id = id;
        this.number = number;
        this.level = level;
        this.prevState = -1;
        this.nextState = -1;
        this.shiftBefore = "";
        this.shiftAfter = "";
    }

    public Integer getId() {
        return id;
    }

    public String getNumber() {
        return number;
    }

    public Integer getLevel() {
        return level;
    }

    public void setPrevState(Integer prevState) {
        this.prevState = prevState;
    }

    public Integer getPrevState() {
        return prevState;
    }

    public void setNextState(Integer nextState) {
        this.nextState = nextState;
    }

    public Integer getNextState() {
        return nextState;
    }

    public void setShiftBefore(String shiftBefore) {
        this.shiftBefore = shiftBefore;
    }

    public String getShiftBefore() {
        return shiftBefore;
    }

    public void setShiftAfter(String shiftAfter) {
        this.shiftAfter = shiftAfter;
    }

    public String getShiftAfter() {
        return shiftAfter;
    }

}
