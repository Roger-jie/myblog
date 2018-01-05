package com.roger.blog.util;

import java.util.*;

public class CollectionUtil {

    /**
     * 不允许实例化
     */
    private CollectionUtil(){

    }

    /**
     * 获取两个集合的不同项
     * @param collMax
     * @param collMin
     * @return
     */
    public static Collection getDiffCollection(Collection collMax,Collection collMin){
        //使用LinkeList防止差异过大时,元素拷贝
        Collection csReturn = new LinkedList();
        Collection max = collMax;
        Collection min = collMin;
        //比较两个集合大小，减少后续map的if比较次数
        if (collMax.size() < collMin.size()) {
            max = collMin;
            min = collMax;
        }
        Map<Object,Integer> map = new HashMap<Object, Integer>(max.size());
        for (Object object : max) {
            map.put(object, 1);
        }
        for (Object object : min) {
            if (map.get(object) == null) {
                csReturn.add(object);
                continue;
            }
            map.put(object, 2);
        }
        for (Map.Entry<Object,Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                 csReturn.add(entry.getKey());
            }
        }
        return csReturn;
    }


    /**
     * 获取集合的差异，去除重复的
     */
    public static Collection getDiffentNoDuplicate (Collection collmax,Collection collmin){
        return new HashSet(getDiffCollection(collmax, collmin));
    }

    public static void main(String[] args){
            List<String> list1 = new ArrayList<String>();
            List<String> list2 = new ArrayList<String>();

            list1.add("1");
            list1.add("2");
            list1.add("3");
            list1.add("4");


            list2.add("2");
            list2.add("3");
            list2.add("4");
            list2.add("5");
            list2.add("6");

            Collection<String> list3 = getDiffCollection(list1,list2);
            System.out.println(list1.contains("1"));
            System.out.println(list3.toString());
    }
}
