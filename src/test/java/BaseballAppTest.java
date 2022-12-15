import domain.BaseballGameImpl;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BaseballAppTest {

    BaseballAppImpl baseballApp = new BaseballAppImpl(new BaseballGameImpl());

    @Test
    @DisplayName("baseball_app_run")
    public void baseballAppRunTest(){
        baseballApp.run();
    }

}