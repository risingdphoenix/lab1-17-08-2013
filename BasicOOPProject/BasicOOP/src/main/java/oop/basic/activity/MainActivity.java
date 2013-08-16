package oop.basic.activity;

import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import oop.basic.R;
import oop.basic.model.BaseClass;
import oop.basic.model.Ninja;
import oop.basic.model.Novice;
import oop.basic.model.Player;
import oop.basic.model.Warrior;
import oop.basic.model.Wizard;

public class MainActivity extends Activity implements View.OnClickListener, AdapterView.OnItemSelectedListener {
    private ImageView mAvatar;
    private TextView mNameTxt;
    private TextView mClassTxt;
    private TextView mLevelTxt;
    private TextView mStrTxt;
    private TextView mAgiTxt;
    private TextView mIntTxt;
    private Button mLvlUpBtn;
    private Button mResetBtn;
    private Spinner mChangeClass;

    private Player mPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // set up layout and views
        setContentView(R.layout.activity_main);
        mClassTxt = (TextView) findViewById(R.id.class_name);
        mStrTxt = (TextView) findViewById(R.id.str);
        mLvlUpBtn = (Button) findViewById(R.id.lvlup);
        mResetBtn = (Button) findViewById(R.id.reset);
        mChangeClass = (Spinner) findViewById(R.id.spinner);
        /* TODO: assign more views */
        mAvatar = (ImageView) findViewById(R.id.avatar);
        mNameTxt = (TextView) findViewById(R.id.name);
        mLevelTxt = (TextView) findViewById(R.id.level);
        mAgiTxt = (TextView) findViewById(R.id.agi);
        mIntTxt = (TextView) findViewById(R.id.intel);

        // declare object
        mPlayer = new Player("RisingPhoenix");

        // add event to lvlup button
        mLvlUpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mPlayer.lvlUp();
                updateInfo();
            }
        });

        // add event to reset button
        mResetBtn.setOnClickListener(this);

        // add event to change class spinner
        mChangeClass.setOnItemSelectedListener(this);

        updateInfo();
    }

    private void updateInfo() {
        mClassTxt.setText(mPlayer.getClassName());
        mStrTxt.setText(mPlayer.getStrength() + "");
        /* TODO: update more information */
        mAvatar.setImageResource(mPlayer.getClassPicture());
        mNameTxt.setText(mPlayer.getName());
        mLevelTxt.setText(mPlayer.getLevel() + "");
        mAgiTxt.setText(mPlayer.getAgility() + "");
        mIntTxt.setText(mPlayer.getIntelligent() + "");
    }

    @Override
    public void onClick(View view) {
        // get view's id
        int vid = view.getId();

        // add events to target view by id
        switch (vid) {
            case R.id.reset:
                mPlayer.reset();
                updateInfo();
                break;
        }
    }

    // this is event when select choice on spinner
    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        mPlayer.changeClass(i);
        updateInfo();
        Toast.makeText(getApplicationContext(), mPlayer.getStatistic(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {
    }

    // reset static variables
    @Override
    protected void onDestroy() {
        BaseClass.createdTimes = 0;
        Novice.createdTimes = 0;
        Warrior.createdTimes = 0;
        Ninja.createdTimes = 0;
        Wizard.createdTimes = 0;
        super.onDestroy();
    }
}
