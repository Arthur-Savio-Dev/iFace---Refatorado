import br.com.ufal.iface.menus.LoginMenu;
import br.com.ufal.iface.systemdatas.SystemDatas;

public class Main {
    public static void main(String[] args){
        SystemDatas systemDatas = new SystemDatas();
        LoginMenu loginMenu = new LoginMenu(systemDatas);
        loginMenu.loginMenu();
    }
}
