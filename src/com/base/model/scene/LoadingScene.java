package com.base.model.scene;

import com.base.manager.ResourcesManager;
import com.base.util.ConstantsUtil;
import com.base.util.SceneType;
import org.andengine.entity.scene.background.Background;
import org.andengine.entity.text.Text;
import org.andengine.util.adt.color.Color;

/**
 * User: Breku
 * Date: 21.09.13
 */
public class LoadingScene extends BaseScene {

    @Override
    public void createScene(Object... objects) {
        setBackground(new Background(Color.BLACK));
        attachChild(new Text(ConstantsUtil.SCREEN_WIDTH / 2, ConstantsUtil.SCREEN_HEIGHT / 2, ResourcesManager.getInstance().getWhiteFont(),
                "Loading...", vertexBufferObjectManager));
    }

    @Override
    public void onBackKeyPressed() {
        return;
    }

    @Override
    public SceneType getSceneType() {
        return SceneType.LOADING;
    }

    @Override
    public void disposeScene() {
    }
}
