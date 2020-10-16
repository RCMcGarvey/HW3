public class Printer implements Announcer {

    @Override
    public void message(String announcement) {
        System.out.println(announcement);
    }
}
