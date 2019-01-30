package br.com.ufal.iface.systemadmin;

import br.com.ufal.iface.systemdatas.Community;
import br.com.ufal.iface.systemdatas.SystemDatas;
import br.com.ufal.iface.systemdatas.User;

import java.util.Scanner;

public class Utilites {
    private SystemDatas systemDatas;
    private Scanner scanner = new Scanner(System.in);

    public Utilites(SystemDatas systemDatas) {
        this.systemDatas = systemDatas;
    }

    public boolean isFriend(User user, User friend){
        for(User i: user.getFriends()){
            if(i.equals(friend)){
                return true;
            }
        }
        return false;
    }

    public boolean checkExistenceUser(String name, String email){
        for(User i: systemDatas.getUsersList()){
            if(i.getName().equals(name) && i.getEmail().equals(email)){
                return true;
            }
        }
        return false;
    }

    public boolean checkExistenceUserByName(String name){
        for(User i: systemDatas.getUsersList()){
            if(i.getName().equals(name)){
                return true;
            }
        }
        return false;
    }

    public User checkUserToValidateLogin(String email, String password){
        for(User i: systemDatas.getUsersList()){
            if(i.getEmail().equals(email) && i.getPassword().equals(password)){
                return i;
            }
        }
        return null;
    }

    public User returnUserByName(){
        String name;
        System.out.println("Nome do usuário: ");

        name = scanner.nextLine();

        for(User i: systemDatas.getUsersList()){
            if(i.getName().equals(name))
                return i;
        }
        return null;
    }

    public boolean checkExistingCommunity(String name){
        for(Community i: systemDatas.getCommunitiesList()){
            if(i.getName().equals(name))
                return true;
        }
        return false;
    }

    public Community returnCommunityByName(String name){
        for(Community i: systemDatas.getCommunitiesList()){
            if(i.getName().equals(name));
                return i;
        }
        return null;
    }
}
