package com.eye.reflex.model.scene;

import com.eye.reflex.manager.ResourcesManager;
import com.eye.reflex.manager.SceneManager;
import com.eye.reflex.matcher.ClassTouchAreaMacher;
import com.eye.reflex.util.ConstantsUtil;
import com.eye.reflex.util.SceneType;
import org.andengine.engine.camera.hud.HUD;
import org.andengine.entity.sprite.Sprite;

/**
 * User: Breku
 * Date: 21.09.13
 */
public class GameScene extends BaseScene {

    private HUD gameHUD;

    /**
     * @param objects objects[0] - GameType
     */
    public GameScene(Object... objects) {
        super(objects);
    }


    @Override
    public void createScene(Object... objects) {
        init(objects);
        createBackground();
        createHUD();
    }

    @Override
    public void onBackKeyPressed() {
        SceneManager.getInstance().loadMenuSceneFrom(SceneType.GAME);
    }

    private void init(Object... objects) {
        clearUpdateHandlers();
        clearTouchAreas();
    }


    private void createHUD() {
        gameHUD = new HUD();
        camera.setHUD(gameHUD);
    }

    private void createBackground() {
        unregisterTouchAreas(new ClassTouchAreaMacher(Sprite.class));
        attachChild(new Sprite(ConstantsUtil.SCREEN_WIDTH / 2, ConstantsUtil.SCREEN_HEIGHT / 2,
                ResourcesManager.getInstance().getBackgroundGameTextureRegion(), vertexBufferObjectManager));
    }

    @Override
    protected void onManagedUpdate(float pSecondsElapsed) {
        super.onManagedUpdate(pSecondsElapsed);
    }

    @Override
    public SceneType getSceneType() {
        return SceneType.GAME;
    }

    @Override
    public void disposeScene() {
        gameHUD.clearChildScene();
        camera.setHUD(null);
        camera.setCenter(ConstantsUtil.SCREEN_WIDTH / 2, ConstantsUtil.SCREEN_HEIGHT / 2);
        camera.setChaseEntity(null);
    }
}
