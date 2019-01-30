package br.com.ufal.iface.systemadmin;

import br.com.ufal.iface.exceptions.InexistingCommunityException;
import br.com.ufal.iface.exceptions.InexistingUserException;
import br.com.ufal.iface.systemdatas.Community;
import br.com.ufal.iface.systemdatas.SystemDatas;
import br.com.ufal.iface.systemdatas.User;
import br.com.ufal.iface.exceptions.IllegalRelationshipStatusException;
import br.com.ufal.iface.menus.LoginMenu;

import java.util.*;

public class UserAdmin {

    private SystemDatas systemDatas;
    private Scanner scanner = new Scanner(System.in);

    public UserAdmin(SystemDatas systemDatas) {
        this.systemDatas = systemDatas;
    }

    public void receiveDatasToAddUserToSystem(){
        String name, email, password;

        System.out.println("Nome do usuário: ");
        name = scanner.nextLine();

        System.out.println("Informe um e-mail: ");
        email = scanner.nextLine();

        System.out.println("Sua senha: ");
        password = scanner.nextLine();

        User user = new User(name, email, password);
        try {
            tryAddUserToSystem(user);
            System.out.println(" - Cadastro realizado com sucesso. Faça login! - \n");
            LoginMenu loginMenu = new LoginMenu(systemDatas);
            loginMenu.loginMenu();
        }catch (IllegalArgumentException e){
            System.out.println(" - Usuário já existente. Tente novamente com outros dados. -\n");
        }
    }

    private void tryAddUserToSystem(User user){
        Utilites utilites = new Utilites(systemDatas);

        if(utilites.checkExistenceUser(user.getName(), user.getEmail())){
            throw new IllegalArgumentException();
        }else{
            systemDatas.getUsersList().add(user);
        }
    }

    public void deleteFriend(User user){
        User friend;

        friend = findFriend(user);

        if(friend == null){
            System.out.println(" - Usuário não é seu amigo - \n");
        }else{
            user.getFriends().remove(friend);
            friend.getFriends().remove(user);

            System.out.println(" - Amizade exlcuída com sucesso - \n");
        }
    }

    public void completeAdditionalUserDatas(User user){
        String relationship, school;
        int age;

        System.out.println("Informe dados adicionais do seu perfil: ");
        age = receiveAgeData();
        user.setAge(age);

        relationship = receiveRelationshipData();
        user.setRelationshipStatus(relationship);

        school = receiveSchoolDatas();
        user.setSchool(school);
    }

    private int receiveAgeData(){
        int age;
        while(true){
            try{
                System.out.println("Sua idade ?");
                age = scanner.nextInt();
                break;
            }catch (InputMismatchException e){
                System.out.println("Por favor, informe apenas números. Tente novamente!\n");
                scanner.nextLine();
            }
        }
        return age;
    }

    private String receiveRelationshipData(){
        String relationship;
        scanner.nextLine();

        while(true){
            System.out.println("Qual seu status de relacionamento ?");
            relationship = scanner.nextLine();
            relationship.toLowerCase();

            try {
                if(!relationship.equals("solteiro") && !relationship.equals("casado") && !relationship.equals("divorciado")){
                    throw new IllegalRelationshipStatusException();
                }else{
                    return relationship;
                }
            }catch (IllegalRelationshipStatusException e){
                System.out.println(e.getMessage());
            }
        }
    }

    private String receiveSchoolDatas(){
        String school;

        System.out.println("Informe sua instituição de ensino: ");
        school = scanner.nextLine();

        return school;
    }

    public void sendMessageToFriend(User user){
        String name, message;
        User friend;

        friend = findUser();

        System.out.println("Sua mensagem: ");
        message = scanner.nextLine();

        friend.getListMessages().put(message, user);
    }

    public void sendFriendshipSolicitation(User user){
        Utilites utilites = new Utilites(systemDatas);

        User friend = utilites.returnUserByName();
        friend.getFriendshipSolicitation().add(user);
        System.out.println(" - Solicitação de amizade enviada com sucesso! - \n");
    }

    public User findFriend(User user){
        String name;
        User friend = findUser();

        for(User i: user.getFriends()){
            if(i.equals(friend))
                return i;
        }
        return null;
    }

    public User findUser(){
        Utilites utilites = new Utilites(systemDatas);
        User friend;

        while(true){
            try{
                friend = utilites.returnUserByName();

                if(friend == null){
                    throw new InexistingUserException();
                }else{
                    return friend;
                }
            }catch (InexistingUserException e){
                System.out.println(e.getMessage());
                scanner.nextLine();
            }
        }
    }

    public void joinComunnity(User user){
        System.out.println("Informe o nome da comunidade: ");
        String name = scanner.nextLine();

        Community community = findCommunity(name);

        if(community != null){
            community.getMembers().add(user);
            user.getUserCommunities().add(community);
        }
    }

    public void sendMessageToCommunity(User user){
        String name, message;
        Community community = null;

        System.out.println("Informe a Comunidade: ");
        name = scanner.nextLine();

        community = findCommunity(name);

        if(community != null){
            System.out.println("Informe a mensagem: ");
            message = scanner.nextLine();

            community.getMessages().put(message, user);
        }
    }

    public Community findCommunity(String name){
        Community community = null;
        Utilites utilites = new Utilites(systemDatas);

        try {
            community = utilites.returnCommunityByName(name);

            if(community == null){
                throw new InexistingCommunityException();
            }
            return community;
        }catch (InexistingCommunityException e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    public void deleteAccount(User user){

        for(User i: systemDatas.getUsersList()){
            user.getListMessages().forEach((key, value) -> {  //Apaga referência das mensagens
                if(value.equals(i)){
                    i.getListMessages().remove(key);
                }
            });

            i.getFriendshipSolicitation().remove(user);

            i.getFriends().remove(user);
        }

        for(Community i: user.getUserCommunities()){
            i.getMembers().remove(user);
        }

        for(Community i: user.getCommunityAdmin()){
            i.setModerator(null);
        }

        systemDatas.getUsersList().remove(user);
        System.out.println(" - Sua conta foi deletada com sucesso! -\n");

        LoginMenu loginMenu = new LoginMenu(systemDatas);
        loginMenu.loginMenu();
    }
}
