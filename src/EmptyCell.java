public class EmptyCell implements  Capturable {

    @Override
    public String getImage() {
        return "  ";
    }

    @Override
    public boolean capture(int dificalty, HPController hero) {
        return true;
    }
}
