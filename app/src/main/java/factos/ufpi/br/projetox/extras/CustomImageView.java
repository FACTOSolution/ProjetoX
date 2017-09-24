package factos.ufpi.br.projetox.extras;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;

/**
 * Created by lucas_brito on 24/09/17.
 */


public class CustomImageView extends AppCompatImageView {

    private float radius = 16.0f;
    private Path path;
    private RectF rect;

    public CustomImageView(Context context){
        super(context);
        init();
    }

    public CustomImageView(Context context, AttributeSet attrs){
        super(context,attrs);
        init();
    }

    public CustomImageView(Context context, AttributeSet attrs, int defStyle){
        super(context, attrs, defStyle);
        init();
    }

    private void init() {
        path = new Path();
    }

    @Override
    protected void onDraw(Canvas canvas){
        rect = new RectF(0, 0, this.getWidth(), this.getHeight());
        path.addRoundRect(rect, radius, radius, Path.Direction.CW);
        canvas.clipPath(path);
        super.onDraw(canvas);
    }

}
