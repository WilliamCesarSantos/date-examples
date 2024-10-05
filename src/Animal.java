public class Animal {

    private String type;
    private Boolean jump;
    private Boolean swim;

    public Animal(String type, Boolean jump, Boolean swim) {
        this.type = type;
        this.jump = jump;
        this.swim = swim;
    }

    public String getType() {
        return type;
    }

    public Boolean getJump() {
        return jump;
    }

    public Boolean getSwim() {
        return swim;
    }
}
