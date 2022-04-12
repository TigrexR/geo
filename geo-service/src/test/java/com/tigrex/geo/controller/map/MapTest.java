package com.tigrex.geo.controller.map;

import java.util.*;

import com.tigrex.geo.entity.po.User;
import org.junit.jupiter.api.Test;
import org.springframework.util.StringUtils;

public class MapTest {

    @Test
    public void testOne(){
        User user = new User(1, "123", "123", 3, "123");
        Map<Integer, User> map = new HashMap(2);
        map.put(1, user);
        map.put(2, user);

        /**
        System.out.println(map.toString());
        System.out.println(map);
        System.out.println(map.containsKey(1));
        System.out.println(map.containsKey(user));
        System.out.println(map.containsValue(user));
         */

        /**
        Set set = map.keySet();
        for(Object key : set){
            System.out.println(key.toString());
        }
        */

        /**
        Collection collection = map.values();
        Iterator iterator = collection.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
         */

        Set entrySet = map.entrySet();
        Iterator entry = entrySet.iterator();
        while (entry.hasNext()){
            Map.Entry me = (Map.Entry)entry.next();
            System.out.println(me.getKey());
            System.out.println(me.getValue());
        }

        Map linkedHashMap = new LinkedHashMap();

        Map hashTable = new Hashtable();
//        hashTable.put(null, 123);
//        hashTable.put("123", null);
        hashTable.put(1, 1);
        Set tableSet = hashTable.entrySet();
        Iterator tableEntry = tableSet.iterator();
        while (tableEntry.hasNext()){
            Map.Entry tableEntryTemp = (Map.Entry)tableEntry.next();
            System.out.println(tableEntryTemp.getKey());
            System.out.println(tableEntryTemp.getValue());
        }


    }

    @Test
    public void CollectionsTest(){
        List list = new ArrayList();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("5");
        System.out.println(list.toString());
        //反转
        Collections.reverse(list);
        System.out.println(list.toString());
        Collections.shuffle(list);
        System.out.println(list.toString());
        Collections.sort(list);
        Collections.swap(list, 1, 4);
        System.out.println(list.toString());

        List listCopy = Arrays.asList(new Object[list.size()]);
        Collections.copy(listCopy, list);
        System.out.println(listCopy.toString());

        //线程安全
        Collections.synchronizedList(list);
    }

    @Test
    public void StringTest(){
        String str = "草泥马222戈壁123";
        char[] list = str.toCharArray();
        System.out.println(str.charAt(3));
        System.out.println(str.charAt(4));
        System.out.println(str.charAt(5));
        System.out.println(list[2]);
        System.out.println(list.length);
    }

    @Test
    public void GenericTest(){
        List<Integer> list = new ArrayList<Integer>();
        list.add(123);
        Map<String, Integer> hell = new HashMap<String, Integer>();

        List<?> listTemp1 = new LinkedList<>();
        List<String> listTemp2 = new LinkedList();

        listTemp1 = listTemp2;
        listTemp2.add("s123");
        listTemp2.add("kkk");
        System.out.println(listTemp1);
        System.out.println(listTemp2);

        Map<String, Integer> hashMapTemp = new HashMap();
        hashMapTemp.put("k1", 1);
        hashMapTemp.put("k2", 2);
        hashMapTemp.put("k3", 3);
        hashMapTemp.put("k4", 4);
        hashMapTemp.put("k5", 5);
        hashMapTemp.put("k6", null);

        System.out.println(StringUtils.hasLength(hashMapTemp.get("k6").toString()));

    }

}
