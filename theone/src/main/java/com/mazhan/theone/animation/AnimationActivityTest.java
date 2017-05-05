package com.mazhan.theone.animation;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.LayoutAnimationController;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.mazhan.theone.R;
import com.mazhan.theone.view.WrapperView;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by dragonfly on 2017/5/2.
 */

public class AnimationActivityTest extends AppCompatActivity {
    @InjectView(R.id.img_1)
    ImageView img_1;
    @InjectView(R.id.tv_1)
    TextView tv_1;
    @InjectView(R.id.ln_1)
    LinearLayout ln_1;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation);
        ButterKnife.inject(this);
        RotateAnimation ra = new RotateAnimation(0, 360, 100, 100);//定点转
//        RotateAnimation ra=new RotateAnimation(0,360,RotateAnimation.RELATIVE_TO_SELF,0.5f,RotateAnimation.RELATIVE_TO_SELF,0.5f);//自身转

        TranslateAnimation ta = new TranslateAnimation(0, 200, 0, 300);

        ScaleAnimation sa = new ScaleAnimation(0, 1, 0, 1);//缩放
//        ScaleAnimation sa=new ScaleAnimation(0,1,0,1,ScaleAnimation.RELATIVE_TO_SELF,0.5f,ScaleAnimation.RELATIVE_TO_SELF,0.5f);

        AnimationSet as = new AnimationSet(true);
//        as.addAnimation(ra);
//        as.addAnimation(ta);
//        as.addAnimation(sa);

        sa.setDuration(3000);
//        img_1.setAnimation(as);

/**
 * 使用animation控制objectanimation
 */
        ObjectAnimator oa1 = ObjectAnimator.ofFloat(img_1, "translationX", 300);
        ObjectAnimator oa2 = ObjectAnimator.ofFloat(img_1, "translationY", 300);
        ObjectAnimator oa3 = ObjectAnimator.ofFloat(img_1, "translationX", 700);
        AnimatorSet aset = new AnimatorSet();
        aset.setDuration(1000);
//        aset.playTogether(oa1,oa2);
        aset.play(oa3).after(oa1).with(oa2);//顺序跳帧
//        aset.start();

//        oa2.setDuration(3000);
//        oa2.start();
        /**
         * 自定义动画
         */
        WrapperView wv = new WrapperView(img_1);
        ObjectAnimator oa = ObjectAnimator.ofInt(wv, "height", 500);
        oa.setDuration(3000);
//        oa.start();
/**
 * 动画计数
 */
        ValueAnimator valueAnimator = ValueAnimator.ofFloat(0f, 1000f);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                tv_1.setText("计数" + animation.getAnimatedValue() + "");
            }
        });
        valueAnimator.setDuration(1000);
//        valueAnimator.start();


        PropertyValuesHolder pvh1 = PropertyValuesHolder.ofFloat("translationX", 300f);
        PropertyValuesHolder pvh2 = PropertyValuesHolder.ofFloat("scaleX", 1f, 0, 1f);
        PropertyValuesHolder pvh3 = PropertyValuesHolder.ofFloat("scaleY", 1f, 0, 1f);
//        ObjectAnimator.ofPropertyValuesHolder(img_1,pvh1,pvh2,pvh3).setDuration(3000).start();


        /**
         * 通过xml设置
         */
        Animator animation = AnimatorInflater.loadAnimator(this, R.animator.scalex);
        animation.setTarget(img_1);
        animation.start();

/**
 * 布局内部控件动画显示显示 LayoutAnimationController
 */
        ScaleAnimation sa1=new ScaleAnimation(0,1,0,1);
        sa1.setDuration(2000);
        LayoutAnimationController lac=new LayoutAnimationController(sa1,0.5f);
        lac.setOrder(LayoutAnimationController.ORDER_NORMAL);//order_normal //顺序 order_Radom //随机  order_reverse反序
//        ln_1.setLayoutAnimation(lac);



        /**
         * 手势监听
         */
        sa.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }

        });
        oa.addListener(new Animator.AnimatorListener() {
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

            }
        });


    }
}
