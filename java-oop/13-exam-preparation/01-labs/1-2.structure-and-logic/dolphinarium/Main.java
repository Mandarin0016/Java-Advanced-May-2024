package dolphinarium;

import dolphinarium.core.Engine;
import dolphinarium.core.EngineImpl;
import dolphinarium.entities.pools.Pool;

public class Main {
    public static void main(String[] args) {
        Engine engine = new EngineImpl();
        engine.run();

    }
}
