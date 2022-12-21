package config;

import domain.BaseballGame;
import domain.BaseballGameImpl;
import domain.BaseballReferee;
import domain.BaseballRefereeImpl;
import generator.ThreeNumberGenerator;
import generator.ThreeNumberGeneratorImpl;
import view.InputView;
import view.InputViewImpl;
import view.OutputView;
import view.OutputViewImpl;

public class BaseballConfig {
    public final BaseballReferee baseballReferee = new BaseballRefereeImpl();
    public final ThreeNumberGenerator threeNumberGenerator = new ThreeNumberGeneratorImpl();
    public final InputView inputView = new InputViewImpl();
    public final OutputView outputView = new OutputViewImpl();
}
