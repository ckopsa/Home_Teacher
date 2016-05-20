package coljamkop.home_teacher.dummy;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Helper class for providing sample date for user interfaces created by
 * Android template wizards.
 * <p/>
 * TODO: Replace all uses of this class before publishing your app.
 */
public class AppointmentContent {

    /**
     * An array of sample (dummy) items.
     */
    public static final List<Appointment> ITEMS = new ArrayList<Appointment>();

    /**
     * A map of sample (dummy) items, by ID.
     */
    public static final Map<String, Appointment> ITEM_MAP = new HashMap<String, Appointment>();

//    private static final int COUNT = 25;
//
//    static {
//        // Add some sample items.
//        for (int i = 1; i <= COUNT; i++) {
//            addItem(createDummyItem(i));
//        }
//    }

    public static void addItem(Appointment item) {
        ITEMS.add(item);
        ITEM_MAP.put(item.family, item);
    }

    private static Appointment createDummyItem(int position) {
        return new Appointment(String.valueOf(position), "Family " + position, makeDetails(position));
    }

    private static String makeDetails(int position) {
        return new Date().toString();
//        return String.valueOf(new Date().getTime());
    }

    /**
     * A dummy item representing a piece of date.
     */
    public static class Appointment {
        public final String family;
        public final String date;
        public final String time;

        public Appointment(String id, String date, String details) {
            this.family = id;
            this.date = date;
            this.time = details;
        }

        @Override
        public String toString() {
            return date;
        }
    }
}
