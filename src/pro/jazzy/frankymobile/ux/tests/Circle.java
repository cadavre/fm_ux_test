
package pro.jazzy.frankymobile.ux.tests;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;

public class Circle {

    private int radius;

    private int placement;

    private int split;

    private Paint paintCircle = null;

    private Paint paintLine = null;

    public Circle(int radius, int color, int placement, int split) {

        this.radius = radius;
        this.placement = placement;
        this.split = split;

        paintCircle = new Paint();
        paintCircle.setColor(color);
        paintCircle.setAntiAlias(true);
        paintCircle.setDither(true);

        paintLine = new Paint();
        paintLine.setColor(Color.argb(255, 0, 0, 0));
        paintLine.setAntiAlias(true);
        paintLine.setDither(true);
    }

    public void draw(Canvas canvas) {

        RectF rect = new RectF(0, 0, radius * 2, radius * 2);
        if (placement == CircleView.PLACEMENT_LEFT) {
            canvas.translate(-radius, 0);
            canvas.drawArc(rect, -90, 90, true, paintCircle);
        } else if (placement == CircleView.PLACEMENT_RIGHT) {
            canvas.translate(0, 0);
            canvas.drawArc(rect, 180, 90, true, paintCircle);
        }

        if (split > 1) {
            int lineLen = (int) (radius * Math.cos(Math.toRadians(71)));
            if (placement == CircleView.PLACEMENT_LEFT) {
                canvas.drawLine(radius, radius, radius * 2 - lineLen, lineLen, paintLine);
            } else if (placement == CircleView.PLACEMENT_RIGHT) {
                canvas.drawLine(radius, radius, lineLen, lineLen, paintLine);
            }

        }
    }
}
