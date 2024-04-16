public class OurNumber {

    private final Integer id;
    private final String number;
    private final Integer level;
    private Integer prevState;
    private Integer nextState;
    private Boolean hasNextLevel;
    private Boolean hasPrevLevelAfter;
    private String shiftBefore;
    private String shiftAfter;

    public OurNumber(Integer id, String number, Integer level) {
        this.id = id;
        this.number = number;
        this.level = level;
        this.prevState = 0;
//        this.hasNextLevel = false;
//        this.hasPrevLevelAfter = false;
//        this.shiftBefore = "";
//        this.shiftAfter = "";
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

}
