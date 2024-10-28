public class Bowl {
    private int amountFood;

    public Bowl() {
        this.amountFood = 0;
    }

    public void setAmountFood(int amountFood) {
        if (amountFood < 0) {
            System.out.println("Миска не может содержать отрицательное количество еды.");
        } else {
            this.amountFood = amountFood;
        }
    }

    public int getAmountFood() {
        return amountFood;
    }

    public void addAmountFood(int amountFood) {
        if (amountFood < 0) {
            System.out.println("Количество еды не может быть отрицательным.");
        } else {
            this.amountFood += amountFood;
        }
    }
}
