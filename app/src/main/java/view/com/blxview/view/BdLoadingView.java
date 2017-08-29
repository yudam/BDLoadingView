package view.com.blxview.view;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;

import view.com.blxview.R;

/**
 * 百度加载动画
 */

public class BdLoadingView extends View {

    private int[] colors={getResources().getColor(R.color.colorAccent),getResources().getColor(R.color.colorPrimary),
    getResources().getColor(R.color.color_32bf82)};

    private Paint mPaint;

    private float maxFetch=200f;

    private float radius=15f;

    private float currentX=0;

    private  ValueAnimator va;


    public BdLoadingView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        init();
    }

    private void init() {

        mPaint=new Paint();

        mPaint.setAntiAlias(true);

        startAnimas();
    }

    public void startAnimas(){

        va=ValueAnimator.ofFloat(0f,maxFetch,0f);
        va.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {

                currentX= (float) animation.getAnimatedValue();
                invalidate();
            }
        });

        va.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {

            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {
                sweep();

            }
        });

        va.setDuration(2000);
        va.setRepeatMode(ValueAnimator.REVERSE);
        va.setRepeatCount(-1);
        va.setInterpolator(new LinearInterpolator());
        va.start();
    }

    public void sweep(){

        /**
         * 第一圈结束第二个变为第一个，第三个变为第二个。第一个变为第三个
         *
         * 以此类推
         */

        int temp=colors[0];
        colors[0]=colors[1];
        colors[1]=colors[2];
        colors[2]=temp;
    }


    @Override
    protected void onDraw(Canvas canvas) {

        int centerX= getWidth()/2;

        int centerY=getHeight()/2;

        //中间的圆
        mPaint.setColor(colors[1]);
        canvas.drawCircle(centerX,centerY,radius,mPaint);

        //左边的圆
        mPaint.setColor(colors[0]);
        canvas.drawCircle(centerX-currentX,centerY,radius,mPaint);

        //右边的圆
        mPaint.setColor(colors[2]);
        canvas.drawCircle(centerX+currentX,centerY,radius,mPaint);

    }

    @Override
    protected void onDetachedFromWindow() {

        if(va!=null){

            va.cancel();
        }
        super.onDetachedFromWindow();


    }
}
