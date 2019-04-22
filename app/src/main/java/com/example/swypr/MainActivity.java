package com.example.swypr;

import android.graphics.Color;
import android.graphics.*;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.MotionEventCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.View;
import android.view.*;
import android.view.MotionEvent;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements GestureDetector.OnGestureListener,GestureDetector.OnDoubleTapListener {

    Block<Integer> piano1 = new Block<Integer>(R.id.Piano);
    Block<Integer> pic = new Block<Integer>(R.id.profilepic);
    Block<Integer> Friend = new Block<Integer>(R.id.Friendpic);
    Block<Integer> Name1 = new Block<Integer>(R.id.Name);
    Block<Integer> Post1 = new Block<Integer>(R.id.Post);
    Block<Integer> like_1 = new Block<Integer>(R.id.like1);
    Block<Integer> Friend2 = new Block<Integer>(R.id.Friendpic2);
    Block<Integer> Name_2 = new Block<Integer>(R.id.Name2);
    Block<Integer> Post_2 = new Block<Integer>(R.id.Post2);
    Block<Integer> like_2 = new Block<Integer>(R.id.like2);

    Block<Integer> currentBlock = piano1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        piano1.down=pic;
        pic.up=piano1;
        pic.down=Friend;
        Friend.down=Name1;
        Name1.up=Friend;
        Name1.down=Post1;
        Post1.up=Name1;
        Post1.down=like_1;
        like_1.up=Post1;
        like_1.down=Friend2;
        Friend2.up=Post1;
        Friend2.down=Name_2;
        Name_2.down=Post_2;
        Name_2.up=Friend2;
        Post_2.up=Name_2;
        Post_2.down=like_2;





        final View v = findViewById(currentBlock.componentID);
        v.setBackgroundResource(R.drawable.select);

        View myView = findViewById(R.id.Layout);
        myView.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View v, MotionEvent event) {

                int action = MotionEventCompat.getActionMasked(event);

                switch(action) {
                    case (MotionEvent.ACTION_DOWN) :
                        if (currentBlock.down != null){
                            v = findViewById(currentBlock.componentID);
                            v.setBackgroundResource(0);
                            currentBlock = currentBlock.down;
                            v = findViewById(currentBlock.componentID);
                            v.setBackgroundResource(R.drawable.select);
                        }
                        return true;
                    case (MotionEvent.ACTION_UP) :
                        if (currentBlock.up != null){
                            v = findViewById(currentBlock.componentID);
                            v.setBackgroundResource(0);
                            currentBlock = currentBlock.up;
                            v = findViewById(currentBlock.componentID);
                            v.setBackgroundResource(R.drawable.select);
                        }
                        return true;
                    default :
                        return false;
                }
            }
        });
    }


    @Override
    public boolean onSingleTapConfirmed(MotionEvent e) {
        return false;
    }

    @Override
    public boolean onDoubleTap(MotionEvent e) {
        onSingleTapConfirmed(e);

        return false;
    }

    @Override
    public boolean onDoubleTapEvent(MotionEvent e) {
        return false;
    }

    @Override
    public boolean onDown(MotionEvent e) {
        return false;
    }

    @Override
    public void onShowPress(MotionEvent e) {

    }

    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        return false;
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        return false;
    }

    @Override
    public void onLongPress(MotionEvent e) {

    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        return false;
    }
}
