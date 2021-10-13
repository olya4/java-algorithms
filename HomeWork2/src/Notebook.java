import java.util.Random;

public class Notebook {
    public int price;
    private int raw_memory;
    private String manufacturer;

    public Notebook(int price, int raw_memory, String manufacturer) {
        this.price = price;
        this.raw_memory = raw_memory;
        this.manufacturer = manufacturer;
    }

    public static Notebook[] generate(int count) {
        String manufacturer[] = {"Lenuvo", "Asos", "MacNote", "Eser", "Xamiou"};
        Random random = new Random();
        Notebook notebooks[] = new Notebook[count];

        for (int i = 0; i < notebooks.length; i++) {
            notebooks[i] = new Notebook(50 * (random.nextInt(600 - 100) + 1), 4 * (random.nextInt(10 - 4) + 1), manufacturer[random.nextInt(5)]);
        }
        return notebooks;
    }

    public int getPrice() {
        return price;
    }

    public int getRaw_memory() {
        return raw_memory;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setRaw_memory(int raw_memory) {
        this.raw_memory = raw_memory;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

}

