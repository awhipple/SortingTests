package net.awhipple.sortingtests.sorts;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 *
 * @author Aaron
 */
public class WhippleSort implements Sort{
    @Override
    public void sort(Comparable[] arr) {
        Map<Comparable, Integer> myMap = new HashMap<>();
        for(int i = 0; i < arr.length; i++) {
            Integer cur = myMap.remove(arr[i]);
            if(cur != null) myMap.put(arr[i], cur+1);
            else myMap.put(arr[i], new Integer(1));
        }
        Set<Entry<Comparable,Integer>> mySet = myMap.entrySet();
        List<Entry<Comparable,Integer>> myList = new ArrayList<>();
        Iterator<Entry<Comparable, Integer>> it = mySet.iterator();
        while(it.hasNext()) {
            myList.add(it.next());
        }
        Collections.sort(myList, new EntryComp());
        int index = 0;
        for(Entry<Comparable, Integer> myEntry : myList) {
            for(int i = 0; i < myEntry.getValue(); i++) {
                arr[index] = myEntry.getKey();
                index++;
            }
        }
    }
    
    public class EntryComp implements Comparator<Entry<Comparable, Integer>> {
        @Override
        public int compare(Entry<Comparable, Integer> t1, Entry<Comparable, Integer> t2) {
            return (t1.getKey().compareTo(t2.getKey()));
        }
    }    
}


