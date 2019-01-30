package br.com.ufal.iface.systemdatas;

import java.util.ArrayList;
import java.util.HashMap;

public class Community {
    private String name;
    private String description;
    private User moderator;
    private ArrayList<User> members = new ArrayList<>();
    private HashMap<String, User> messages = new HashMap<>();

    public Community(String name, String description, User moderator) {
        this.name = name;
        this.description = description;
        this.moderator = moderator;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getModerator() {
        return moderator;
    }

    public void setModerator(User moderator) {
        this.moderator = moderator;
    }

    public ArrayList<User> getMembers() {
        return members;
    }

    public void setMembers(ArrayList<User> members) {
        this.members = members;
    }

    public HashMap<String, User> getMessages() {
        return messages;
    }

    public void setMessages(HashMap<String, User> messages) {
        this.messages = messages;
    }
}
