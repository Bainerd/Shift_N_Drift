package ShiftNDrift.gameobjects;

import com.badlogic.gdx.math.Rectangle;

public abstract class TriggerableEntity extends ObjectBase {

    public TriggerableEntity(Rectangle bounds, float rotation, boolean flipX) {
        super(bounds, rotation, flipX);
    }

    public abstract void onTrigger();

}
