import static org.junit.Assert.*;
import org.junit.Test;
import java.util.LinkedList;

public class Stock {


    public Stock() {}

        LinkedList<LinkedList<StoreItem>> findExpiredItems(LinkedList<StoreItem> items, int todaysDate) {
        LinkedList<LinkedList<StoreItem>> expItemsByDept = new LinkedList<LinkedList<StoreItem>>();

        LinkedList<StoreItem> expiredItems = new LinkedList<StoreItem>();


        for(int i = 0; i < items.size(); i = i + 1) {
            StoreItem thisItem = items.get(i);
            if(thisItem.numDaysOnShelf > 7 || thisItem.expDate < todaysDate) {
                expiredItems.add(thisItem);
            }
        }

        LinkedList<StoreItem> fruitItems = new LinkedList<StoreItem>();
        LinkedList<StoreItem> dairyItems = new LinkedList<StoreItem>();
        LinkedList<StoreItem> otherItems = new LinkedList<StoreItem>();

        for(int k = 0; k < expiredItems.size(); k = k + 1) {
            StoreItem anExpiredItem = expiredItems.get(k);

            if(anExpiredItem.dept.equals("fruit")) {
                fruitItems.add(anExpiredItem);
            }else if(anExpiredItem.dept.equals("dairy")) {
                dairyItems.add(anExpiredItem);
            }else {
                otherItems.add(anExpiredItem);
            }
        }

        expItemsByDept.add(fruitItems);
        expItemsByDept.add(dairyItems);
        expItemsByDept.add(otherItems);

        return expItemsByDept;
    }
}








