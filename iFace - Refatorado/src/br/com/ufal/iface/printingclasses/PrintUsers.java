package br.com.ufal.iface.printingclasses;

import br.com.ufal.iface.systemdatas.SystemDatas;
import br.com.ufal.iface.systemdatas.User;

public class PrintUsers {
    private SystemDatas systemDatas;

    public PrintUsers(SystemDatas systemDatas) {
        this.systemDatas = systemDatas;
    }

    public void printUserDetails(User user){
        System.out.println("-------------");
        System.out.println("Nome: " + user.getName());
        System.out.println("E-mail " + user.getEmail());
        System.out.println("-------------");
    }

    public void printAllUsers(){
        for(User i: systemDatas.getUsersList()){
            printUserDetails(i);
        }
    }
}
