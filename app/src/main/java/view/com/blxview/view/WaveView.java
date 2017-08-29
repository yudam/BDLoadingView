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
 * Created by Administrator on 2017/8/22.
 */

public class WaveView extends View {

    private Paint mPaint;

    private Path mPath;

    public WaveView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        initView();
    }

    private void initView() {
        mPaint=new Paint();
        mPaint.setStyle(Paint.Style.FILL_AND_STROKE);
        mPaint.setStrokeWidth(3);
        mPaint.setColor(Color.GREEN);

        mPath=new Path();
    }


    @Override
    protected void onDraw(Canvas canvas) {

        canvas.translate(getWidth()/2,getHeight()/2);

        canvas.drawCircle(0,0,100,mPaint);


    }
}
