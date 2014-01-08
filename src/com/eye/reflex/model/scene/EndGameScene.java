package com.eye.reflex.model.scene;

import com.eye.reflex.manager.ResourcesManager;
import com.eye.reflex.manager.SceneManager;
import com.eye.reflex.util.ConstantsUtil;
import com.eye.reflex.util.SceneType;
import org.andengine.entity.scene.IOnSceneTouchListener;
import org.andengine.entity.scene.Scene;
import org.andengine.entity.sprite.Sprite;
import org.andengine.input.touch.TouchEvent;

/**
 * User: Breku
 * Date: 04.10.13
 */
public class EndGameScene extends BaseScene implements IOnSceneTouchListener {

    @Override
    public void createScene(Object... objects) {
        createBackground();
        setOnSceneTouchListener(this);
    }

    private void createBackground() {
        attachChild(new Sprite(ConstantsUtil.SCREEN_WIDTH / 2, ConstantsUtil.SCREEN_HEIGHT / 2,
                ResourcesManager.getInstance().getEndGameBackgroundTextureRegion(), vertexBufferObjectManager));
    }

    @Override
    public void onBackKeyPressed() {
        SceneManager.getInstance().loadMenuSceneFrom(SceneType.ENDGAME);
    }

    @Override
    public SceneType getSceneType() {
        return SceneType.ENDGAME;
    }

    @Override
    public void disposeScene() {
    }

    @Override
    public boolean onSceneTouchEvent(Scene pScene, TouchEvent pSceneTouchEvent) {
        if (pSceneTouchEvent.isActionUp()) {
            SceneManager.getInstance().loadMenuSceneFrom(SceneType.ENDGAME);
        }
        return false;
    }
}
