package br.com.ufal.iface.systemadmin;

import br.com.ufal.iface.exceptions.ExistingCommunityException;
import br.com.ufal.iface.exceptions.InexistingCommunityException;
import br.com.ufal.iface.systemdatas.Community;
import br.com.ufal.iface.systemdatas.SystemDatas;
import br.com.ufal.iface.systemdatas.User;

import java.util.Scanner;

public class CommunityAdmin {
    private SystemDatas systemDatas;
    private Scanner scanner = new Scanner(System.in);
    private Utilites utilites;

    public CommunityAdmin(SystemDatas systemDatas) {
        this.systemDatas = systemDatas;
        this.utilites = new Utilites(systemDatas);
    }

    public void addCommunityToSystem(User user){
        String name, description;

        name = receiveCommunityNameToAddSystem();

        System.out.println("Informe uma descrição: ");
        description = scanner.nextLine();

        Community community = new Community(name, description, user);

        systemDatas.getCommunitiesList().add(community);
        user.getUserCommunities().add(community);
        user.getCommunityAdmin().add(community);
        community.getMembers().add(user);
    }

    public String receiveCommunityNameToAddSystem(){
        String name;
        while(true){
            try{
                System.out.println("Informe um nome para a comunidade: ");
                name = scanner.nextLine();

                if(utilites.checkExistingCommunity(name))
                    throw new ExistingCommunityException();
                else
                    return name;
            }catch (ExistingCommunityException e){
                System.out.println(e.getMessage());
            }
        }
    }
}
