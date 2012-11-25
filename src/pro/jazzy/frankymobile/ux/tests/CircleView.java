
package pro.jazzy.frankymobile.ux.tests;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;

public class CircleView extends View {

    public static final int PLACEMENT_LEFT = 0;

    public static final int PLACEMENT_RIGHT = 1;

    private Circle circle = null;

    TypedArray a = null;

    public CircleView(Context context, AttributeSet attrs) {

        super(context, attrs);
        a = context.obtainStyledAttributes(attrs, R.styleable.CircleView);
        circle = new Circle(a.getDimensionPixelSize(R.styleable.CircleView_radius, 0), a.getColor(
                R.styleable.CircleView_fill, Color.DKGRAY), a.getInt(
                R.styleable.CircleView_placement, PLACEMENT_LEFT), a.getInt(
                R.styleable.CircleView_split, 0));
    }

    public void onDraw(Canvas canvas) {

        canvas.drawColor(Color.TRANSPARENT);
        circle.draw(canvas);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {

        int size = a.getDimensionPixelSize(R.styleable.CircleView_radius, 0);
        setMeasuredDimension(size, size);
    }
    
}
