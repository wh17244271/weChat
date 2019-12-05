package com.suypower.venus.utils;

import com.suypower.venus.entity.ChatMessage;

import java.util.ArrayList;
import java.util.List;

public class CloneUtils {
   /* public synchronized static <T>T cloneObj(T t){

        ArrayList<T> oriList =new ArrayList<>();
        oriList.add(t);
        ArrayList<T> tarList = new ArrayList<>();
        tarList.add(oriList.get(0));
        tarList.add(t);

        System.out.println("判断："+oriList.equals(tarList));
        return tarList.get(0);
    }

    public static void main(String[] args) {
        ChatMessage a = new ChatMessage();
        a.setId("2");
        ChatMessage fromMess = CloneUtils.cloneObj(a);
        fromMess.setId("sdf");



        System.out.println("ori:"+a.getId());
        System.out.println("tar:"+fromMess.getId());
    }*/
   public static void main(String[] args) {
       ChatMessage a = new ChatMessage();
       a.setId(null);
       System.out.println(a.getId());
   }
}
