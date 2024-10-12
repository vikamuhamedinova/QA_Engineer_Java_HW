public class Park {
    private  String name;
    public Attraction[] attraction;

    public class Attraction {
        private String nameAttraction;
        private int time;
        private int price;

        public Attraction(String nameAttraction, int time, int price) {
            this.nameAttraction = nameAttraction;
            this.time = time;
            this.price = price;
        }
    }

    public Park(String name) {
        this.name = name;
        this.attraction = new Attraction[3];
        this.attraction[0] = new Attraction("Electric cars", 5, 200);
        this.attraction[1] = new Attraction("Velomobiles", 15, 300);
        this.attraction[2] = new Attraction("Vortex", 3, 250);
    }
}
