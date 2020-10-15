import java.util.ArrayList;
import java.util.List;

public class Calender {
    int dayNumber;

    private List<StoreDay> days = new ArrayList<>();

    public void addObserver(StoreDay day) {this.days.add(day);}

    public void removeObserver(StoreDay day) {this.days.remove(day);}

    private void stepDay(){
        for(StoreDay day : this.days) {
            day.incrimentDay();
        }
    }

}
