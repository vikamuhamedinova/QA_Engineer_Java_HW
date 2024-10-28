public abstract class Figure {
    protected String backgroundColor;
    protected String borderColor;


    public void setBackgroundColor(String backgroundColor) {
        this.backgroundColor = backgroundColor;
    }

    public void setBorderColor(String borderColor) {
        this.borderColor = borderColor;
    }

    public abstract void displayInfo();
}
