package br.com.ufal.iface.systemdatas;

import java.util.*;

public class User {
    private String name;
    private String email;
    private String password;
    private String school;
    private String relationshipStatus;
    private int age;
    private boolean firstLogin = false;
    private ArrayList<User> friends = new ArrayList<>();
    private ArrayList<Community> userCommunities = new ArrayList<>();
    private ArrayList<Community> communityAdmin = new ArrayList<>();
    private HashMap<String, User> listMessages = new HashMap<>();
    private ArrayList<User> friendshipSolicitation = new ArrayList<>();

    public User(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public ArrayList<User> getFriends() {
        return friends;
    }

    public void setFriends(ArrayList<User> friends) {
        this.friends = friends;
    }

    public ArrayList<Community> getUserCommunities() {
        return userCommunities;
    }

    public void setUserCommunities(ArrayList<Community> userCommunities) {
        this.userCommunities = userCommunities;
    }

    public ArrayList<Community> getCommunityAdmin() {
        return communityAdmin;
    }

    public void setCommunityAdmin(ArrayList<Community> communityAdmin) {
        this.communityAdmin = communityAdmin;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getRelationshipStatus() {
        return relationshipStatus;
    }

    public void setRelationshipStatus(String relationshipStatus) {
        this.relationshipStatus = relationshipStatus;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isFirstLogin() {
        return firstLogin;
    }

    public void setFirstLogin(boolean firstLogin) {
        this.firstLogin = firstLogin;
    }

    public HashMap<String, User> getListMessages() {
        return listMessages;
    }

    public void setListMessages(HashMap<String, User> listMessages) {
        this.listMessages = listMessages;
    }

    public ArrayList<User> getFriendshipSolicitation() {
        return friendshipSolicitation;
    }

    public void setFriendshipSolicitation(ArrayList<User> friendshipSolicitation) {
        this.friendshipSolicitation = friendshipSolicitation;
    }
}
