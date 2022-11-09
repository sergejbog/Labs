package mk.ukim.finki.wp.lab.dataholders;

import mk.ukim.finki.wp.lab.model.Balloon;
import mk.ukim.finki.wp.lab.model.Manufacturer;
import mk.ukim.finki.wp.lab.model.Order;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
public class DataHolder {

    public static List<Balloon> balloons = new ArrayList<>();
    public static List<Balloon> sizes = new ArrayList<>();
    public static List<Order> orders = new ArrayList<>();
    public static List<Manufacturer> manufacturerList = new ArrayList<>();

    @PostConstruct
    public void init() {
        manufacturerList.add(new Manufacturer("Manufacturer 1", "MKD", "Kiro Pajmakoski, 9"));
        manufacturerList.add(new Manufacturer("Manufacturer 2", "SRB", "Left Street Up, 81A"));
        manufacturerList.add(new Manufacturer("Manufacturer 3", "GER", "Razlovecko Vostanie, 5"));
        manufacturerList.add(new Manufacturer("Manufacturer 4", "CRO", "Non-Fake Street, 436"));
        manufacturerList.add(new Manufacturer("Manufacturer 5", "BUG", "Fun Street, 1"));

        balloons.add(new Balloon("Red", "Red Balloon", manufacturerList.get(0)));
        balloons.add(new Balloon("Blue", "Blue Balloon", manufacturerList.get(1)));
        balloons.add(new Balloon("Green", "Green Balloon", manufacturerList.get(2)));
        balloons.add(new Balloon("Yellow", "Yellow Balloon", manufacturerList.get(3)));
        balloons.add(new Balloon("Black", "Black Balloon", manufacturerList.get(4)));

        sizes.add(new Balloon("Big", "Big Balloon", manufacturerList.get(0)));
        sizes.add(new Balloon("Small", "Small Balloon", manufacturerList.get(1)));
        sizes.add(new Balloon("Tall", "Tall Balloon", manufacturerList.get(2)));
        sizes.add(new Balloon("Short", "Short Balloon", manufacturerList.get(3)));
        sizes.add(new Balloon("Wide", "Wide Balloon", manufacturerList.get(4)));
    }


}