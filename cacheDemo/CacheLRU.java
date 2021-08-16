
package com.org.cacheDemo;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.Collectors;

public class CacheLRU {
	int capacity = 4;
	LinkedHashMap<Integer, Date> cacheMap = new LinkedHashMap<>(capacity);

	
	private static final long MILLIS_IN_A_DAY = 1000 * 60 * 60 * 24;
	private static final long MILLIS_IN_A_DAY_1 = 1000 * 60 * 60 * 24 * 2;

	public boolean get(int key) {
		if (!cacheMap.containsKey(key))
			return false;
		cacheMap.remove(key);
		cacheMap.put(key, new Date());
		return true;
	}

	public void get_Value(int key) {
		if (get(key) == false)
			put(key);
	}

	@SuppressWarnings("unlikely-arg-type")
	public void put(int key) {

		if (cacheMap.size() == capacity) {
			@SuppressWarnings("unchecked")
			HashMap<Integer, Date> collect = (HashMap<Integer, Date>) cacheMap.entrySet().stream()
					.filter(x -> compareDate(x.getValue(), findPrevDay(new Date())) == 0)
					.collect(Collectors.toMap(x -> x.getKey(), x -> x.getValue()));

			if (collect.size() != 0) {
				Set<Entry<Integer, Date>> firstKey = collect.entrySet();
				cacheMap.remove(firstKey.iterator().next().getKey());
				cacheMap.put(key, new Date());

			} else {
				HashMap<Integer, Date> collect1 = (HashMap<Integer, Date>) cacheMap.entrySet().stream()
						.filter(x -> compareDate(x.getValue(), findDayPrevDay(new Date())) == 0)
						.collect(Collectors.toMap(x -> x.getKey(), x -> x.getValue()));
				if (collect1.size() != 0) {
					Set<Entry<Integer, Date>> firstKey1 = collect1.entrySet();
					cacheMap.remove(firstKey1.iterator().next().getKey());
					cacheMap.put(key, new Date());
				}
			}

		} else {
			cacheMap.put(key, new Date());
		}

		
	}

	@SuppressWarnings("deprecation")
	public static int compareDate(Date date1, Date date2) {
		if (date1.getYear() == date2.getYear() && date1.getMonth() == date2.getMonth()
				&& date1.getDate() == date2.getDate()) {
			return 0;
		} else if (date1.getYear() < date1.getYear()
				|| (date1.getYear() == date2.getYear() && date1.getMonth() < date2.getMonth())
				|| (date1.getYear() == date2.getYear() && date1.getMonth() == date2.getMonth()
						&& date1.getDate() < date2.getDate())) {
			return -1;
		} else {
			return 1;
		}
	}

	public void display() {
		for (Entry<Integer, Date> entry : cacheMap.entrySet()) {
			System.out.println(entry.getKey() + " " + entry.getValue());
		}

	}

	private static Date findPrevDay(Date date) {
		return new Date(date.getTime() - MILLIS_IN_A_DAY);
	}

	private static Date findDayPrevDay(Date date) {
		return new Date(date.getTime() - MILLIS_IN_A_DAY_1);
	}

	public static void main(String[] args) {
		CacheLRU obj = new CacheLRU();
		obj.cacheMap.put(11, new Date(new Date().getTime() - MILLIS_IN_A_DAY_1));
		obj.cacheMap.put(12, new Date(new Date().getTime() - MILLIS_IN_A_DAY));
		obj.cacheMap.put(13, new Date(new Date().getTime() - MILLIS_IN_A_DAY));

		obj.get_Value(4);
		obj.get_Value(5);
		obj.get_Value(6);
		obj.get_Value(4);
		obj.get_Value(7);
		obj.get_Value(5);
		obj.display();
	}
}
