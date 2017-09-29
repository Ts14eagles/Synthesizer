package org.pltw.examples.synthesizer;

import android.media.MediaPlayer;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Half;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.NumberPicker;

import java.util.ArrayList;

public class SynthesizerActivity extends AppCompatActivity {

    private final int WHOLE_NOTE = 1000;
    private final int HALF_NOTE = 500;
    private Button fButton;
    private Button eButton;
    private Button sButton;
    private Button cButton;
    private NumberPicker notePicker;
    private NumberPicker amountPicker;
    private static final String TAG = SynthesizerActivity.class.getName();
    MediaPlayer mpE;
    MediaPlayer mpFs;
    MediaPlayer mpG;
    MediaPlayer mpA;
    MediaPlayer mpB;
    MediaPlayer mpCs;
    MediaPlayer mpD;
    MediaPlayer mpHighE;
    MediaPlayer mpC;
    MediaPlayer mpBb;
    MediaPlayer mpDs;
    MediaPlayer mpF;
    MediaPlayer mpGs;
    MediaPlayer mpHighF;
    MediaPlayer mpHighFs;
    MediaPlayer mpHighG;
    String [] notes = {"mpE", "mpFs", "mpG", "mpA", "mpB", "mpCs", "mpD", "mpHighE", "mpC", "mpBb", "mpDs", "mpF", "mpGs", "mpHighF", "mpHighFs", "mpHighG"};
    ArrayList<MediaPlayer> mediaplayers;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_synthesizer);

        fButton = (Button) findViewById(R.id.button1);
        eButton = (Button) findViewById(R.id.button2);
        sButton = (Button) findViewById(R.id.button3);
        cButton = (Button) findViewById(R.id.button4);
        notePicker = (NumberPicker) findViewById(R.id.numberPicker);
        amountPicker = (NumberPicker) findViewById(R.id.numberPicker3);

        notePicker.setMaxValue(15);
        notePicker.setMinValue(0);
        notePicker.setDisplayedValues(notes);
        amountPicker.setMaxValue(20);
        amountPicker.setMinValue(0);

        mpE = MediaPlayer.create(this, R.raw.scalee);
        mpFs = MediaPlayer.create(this, R.raw.scalef);
        mpG = MediaPlayer.create(this, R.raw.scaleg);
        mpA = MediaPlayer.create(this, R.raw.scalea);
        mpB = MediaPlayer.create(this, R.raw.scaleb);
        mpCs = MediaPlayer.create(this, R.raw.scalecs);
        mpD = MediaPlayer.create(this, R.raw.scaled);
        mpHighE = MediaPlayer.create(this, R.raw.scalehighe);
        mpC = MediaPlayer.create(this, R.raw.scalec);
        mpBb = MediaPlayer.create(this, R.raw.scalebb);
        mpDs = MediaPlayer.create(this, R.raw.scaleds);
        mpF = MediaPlayer.create(this, R.raw.scalef);
        mpGs = MediaPlayer.create(this, R.raw.scalegs);
        mpHighF = MediaPlayer.create(this, R.raw.scalehighf);
        mpHighFs = MediaPlayer.create(this, R.raw.scalehighfs);
        mpHighG = MediaPlayer.create(this, R.raw.scalehighg);

        mediaplayers = new ArrayList<>();
        mediaplayers.add(mpE);
        mediaplayers.add(mpFs);
        mediaplayers.add(mpG);
        mediaplayers.add(mpA);
        mediaplayers.add(mpB);
        mediaplayers.add(mpCs);
        mediaplayers.add(mpD);
        mediaplayers.add(mpHighE);
        mediaplayers.add(mpC);
        mediaplayers.add(mpBb);
        mediaplayers.add(mpDs);
        mediaplayers.add(mpF);
        mediaplayers.add(mpGs);
        mediaplayers.add(mpHighF);
        mediaplayers.add(mpHighFs);
        mediaplayers.add(mpHighG);








        fButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i(TAG, "This worked! Button 1 pressed.");
                mpFs.start();
            }
        });
        eButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mpE.start();
                delayPlaying(WHOLE_NOTE);
                mpE.stop();
            }
        });
        sButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for (int i =0; )
                mediaplayers.get().seekTo(0);
                mediaplayers.get().start();
                delayPlaying(WHOLE_NOTE);

            }
        });


        cButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int times = amountPicker.getValue();
                for (int i = 0; i<times; i++){
                    mediaplayers.get(notePicker.getValue()).seekTo(0);
                    mediaplayers.get(notePicker.getValue()).start();
                    delayPlaying(WHOLE_NOTE);
                }


            }
        });
    }

    private void delayPlaying(int delay) {
        try {
            Thread.sleep(delay);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
