package br.com.ufal.iface.systemdatas;

import java.util.ArrayList;

public class SystemDatas {
    private ArrayList<User> usersList = new ArrayList();
    private ArrayList<Community> communitiesList = new ArrayList();

    public SystemDatas() {
        User user = new User("arthur", "@arthur", "123");
        user.setFirstLogin(true);
        usersList.add(user);
    }

    public ArrayList<User> getUsersList() {
        return usersList;
    }

    public void setUsersList(ArrayList<User> usersList) {
        this.usersList = usersList;
    }

    public ArrayList<Community> getCommunitiesList() {
        return communitiesList;
    }

    public void setCommunitiesList(ArrayList<Community> communitiesList) {
        this.communitiesList = communitiesList;
    }
}
