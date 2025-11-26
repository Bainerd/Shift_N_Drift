package ShiftNDrift;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.utils.TimeUtils;
import ShiftNDrift.screens.BaseScreen;
import ShiftNDrift.screens.MenuScreen;
import ShiftNDrift.utils.Assets;
import ShiftNDrift.utils.SoundManager;


public class Main extends ApplicationAdapter {

    public static Main game;
    public static long startTime = 0l;

    public BaseScreen screen;
    public ActionResolver resolver;

    public Main(ActionResolver actionResolver) {
        resolver = actionResolver;
    }

    @Override
    public void create() {
        Assets.load();
        SoundManager.load(resolver.playMusic());
        float progress = 0f;
        do {
            progress = Assets.update();
        } while (progress != 1f);
        screen = new MenuScreen();
        game = this;
        startTime = TimeUtils.millis();

        if (!resolver.showMouseCursor()) {
            int x = 16;
            int y = 16;
            Pixmap pm = new Pixmap(x, y, Pixmap.Format.RGBA8888);
            pm.setBlending(Pixmap.Blending.None);
            pm.setColor(0f, 0f, 0f, 0f);
            pm.fillRectangle(0, 0, x, y);
            Gdx.graphics.setCursor(Gdx.graphics.newCursor(pm, 0, 0));
        }

    }

    @Override
    public void resume() {
        Assets.load();
        SoundManager.load(resolver.playMusic());
        game = this;
    }

    @Override
    public void dispose() {
        Assets.dispose();
        SoundManager.dispose();
    }

    @Override
    public void render() {
        float dt = Math.min(Gdx.graphics.getDeltaTime(), 1f / 30f);
        Assets.tween.update(dt);
        SoundManager.update(dt);
        screen.update(dt);
        screen.render(Assets.batch);
    }

    public void resetGame(){
        Assets.resetGameState();
        screen = new MenuScreen();
    }

}
