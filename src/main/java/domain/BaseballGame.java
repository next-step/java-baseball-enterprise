package domain;

import config.BaseballConfig;
import generator.ThreeNumberGenerator;
import generator.ThreeNumberGeneratorImpl;
import view.InputView;
import view.InputViewImpl;
import view.OutputView;
import view.OutputViewImpl;

public abstract class BaseballGame {


    protected final BaseballReferee baseballReferee;
    protected final ThreeNumberGenerator threeNumberGenerator;
    protected final InputView inputView;
    protected final OutputView outputView;


    public BaseballGame(BaseballConfig baseballConfig) {
        this.baseballReferee = baseballConfig.baseballReferee;
        this.threeNumberGenerator = baseballConfig.threeNumberGenerator;
        this.inputView = baseballConfig.inputView;
        this.outputView = baseballConfig.outputView;
    }



    public void play(int option) {
    }

    ;

}
