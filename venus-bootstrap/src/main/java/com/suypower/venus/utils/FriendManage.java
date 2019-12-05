package com.suypower.venus.utils;

import com.suypower.venus.controller.UserController;
import com.suypower.venus.entity.Friend;
import com.suypower.venus.entity.User;

import java.util.*;

public class FriendManage {
    public static Map<String, Set<Friend>> friendMap = new LinkedHashMap<>();


    static {
        List<User> users = UserController.users;
        for(User userss:users){
            String userId = userss.getUserId();
            List<User> friendUser = UserUtils.getUserListExcUserId(userId);
            if(friendUser!=null){
                for(User user:friendUser){
                    FriendManage.creatFriend(userId,user.getUserId());
                }
            }
        }

    }



    /**
     * 获取朋友列表
     * @param userId
     * @return
     */
    public static Set<Friend> getFriendList(String userId){

        Set<Friend> friendList = FriendManage.friendMap.get(userId);
        return friendList;
    }
    /**
     * 获取指定好友
     * @param userId
     * @param friendUserid
     * @return
     */
    public static Friend getFriend(String userId,String friendUserid){
        Set<Friend> friendList = FriendManage.getFriendList(userId);
        for(Friend friend:friendList){
            User user = friend.getUser();
            if(null==user)continue;
            if(user.getUserId().equals(friendUserid)){
                return friend;
            }
        }
        return null;
    }




    /**
     * 添加朋友
     * @param userId
     * @param friendUserid
     */
    public static boolean addFriend(String userId,String friendUserid){
        boolean friend = FriendManage.isFriend(userId, friendUserid);
        if(friend)return true;

        Set<Friend> friendList = FriendManage.getFriendList(userId);
        boolean add = friendList.add(new Friend(UserUtils.getUserByUserId(friendUserid), ""));
        return add;
    }


    /**
     * 设置好友备注
     * @param userId
     * @param friendUserId
     * @param friendRemark
     * @return
     */
    public static boolean editFriendRemark(String userId,String friendUserId,String friendRemark){
        Friend myFriend = FriendManage.getFriend(userId, friendUserId);
        if(myFriend==null){
            return false;
        }
        myFriend.setFriendRemark(friendRemark);
        return true;
    }

    /**
     * 判断两人是否是朋友
     * @param userId
     * @param friendUserid
     * @return
     */
    public static boolean isFriend(String userId,String friendUserid){
        if(StringUtils.isEmpty(userId)||StringUtils.isEmpty(friendUserid) || userId.equals(friendUserid)){
            throw new RuntimeException("判断两人是否为好友异常:原因可能是自己不能加自己");
        }
        Friend friend = FriendManage.getFriend(userId, friendUserid);
        if(null==friend){
            return false;
        }else {
            return true;
        }

    }


    public static void creatFriend(String userId,String friendUserId){
        User findUser = UserUtils.getUserByUserId(friendUserId);
        if (null == findUser) {
            System.err.println(userId + "该用户不存在，无法获取聊天室信息");
            throw new RuntimeException(userId + "该用户不存在，无法获取聊天室信息");
        }

        Set<Friend> friendList = friendMap.get(userId);
        if(null == friendList ){
            friendList = new HashSet<>();
            friendList.add(new Friend(findUser,""));
            friendMap.put(userId,friendList);

        }
        boolean flag=false;
        Iterator<Friend> iterator = friendList.iterator();
        while (iterator.hasNext()){
            Friend next = iterator.next();
            User user = next.getUser();
            if(user.getUserId().equals(friendUserId)){
                flag = true;
                break;
            }
        }
        if(!flag){
            friendList.add(new Friend(findUser,""));
        }

    }

}
