public class Castle implements  Capturable{
    @Override
    public String getImage() {
        return "\uD83C\uDFF0";
    }

    @Override
    public boolean capture(int dificalty, HPController hero) {
        return true;
    }
}
