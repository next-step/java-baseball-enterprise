package num3baseball.main;

import num3baseball.manager.ProcessManager;
import num3baseball.ui.GameUserInterfaceKorean;
import num3baseball.ui.GameUserInterfaceTestStub;

public class Main {
    public static void main(String[] args){
        ProcessManager processManager = new ProcessManager(new GameUserInterfaceKorean());
        processManager.execute();
    }
}
