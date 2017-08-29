package view.com.blxview.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Administrator on 2017/8/21.
 */

public class LView extends View {

    private int mWidth;
    private int mHeight;

    private Paint mPaint;
    private Paint wPaint;

    private Path abovePath;
    private Path belowPath;

    private float  Φ;

    public LView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        mPaint=new Paint();
        mPaint.setColor(Color.BLACK);
        mPaint.setStrokeWidth(3);
        mPaint.setAntiAlias(true);
        mPaint.setStyle(Paint.Style.FILL);

        wPaint=new Paint();
        wPaint.setColor(Color.GREEN);
        wPaint.setStrokeWidth(3);
        wPaint.setAntiAlias(true);
        wPaint.setStyle(Paint.Style.FILL);

        abovePath=new Path();
        belowPath=new Path();
    }



    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);

        mWidth=w;
        mHeight=h;


    }

    @Override
    protected void onDraw(Canvas canvas) {

        canvas.translate(0,mHeight/2);

        abovePath.reset();
        belowPath.reset();

        Φ-=0.1f;

        double W=2*Math.PI/getWidth();

        float  y,y2;

        //y=Asin(WX+Φ)+K

        abovePath.moveTo(getLeft(),getBottom());
        belowPath.moveTo(getLeft(),getBottom());

        for(float i=0;i<=getWidth();i+=20){

            y= (float) (8*(Math.cos(W*i+Φ))+4);

            y2=(float) (8*(Math.sin(W*i+Φ)));

            abovePath.lineTo(i,y);
            belowPath.lineTo(i,y2);
        }

        abovePath.lineTo(getRight(),getBottom());
        belowPath.lineTo(getRight(),getBottom());

        canvas.drawPath(abovePath,mPaint);
        canvas.drawPath(belowPath,wPaint);

        postInvalidateDelayed(20);
    }


    
}
