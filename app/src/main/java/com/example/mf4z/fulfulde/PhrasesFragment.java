package com.example.mf4z.fulfulde;


import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class PhrasesFragment extends Fragment {

    //Declaring Media Player variable
    private MediaPlayer mMediaPlayer;

    //Delaring Audio Manager for use in the entire class
    private AudioManager mAudioManager;

    private MediaPlayer.OnCompletionListener mCompletionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mediaPlayer) {
            // Now that the sound file has finished playing, release the media player resources.
            releaseMediaPlayer();
        }
    };


    private AudioManager.OnAudioFocusChangeListener mOnAudioFocusChangeListener = new AudioManager.OnAudioFocusChangeListener() {
        @Override
        public void onAudioFocusChange(int focusChange) {
            if (focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT ||
                    focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK) {
                // The AUDIOFOCUS_LOSS_TRANSIENT case means that we've lost audio focus for a
                // short amount of time. The AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK case means that
                // our app is allowed to continue playing sound but at a lower volume. We'll treat
                // both cases the same way because our app is playing short sound files.

                // Pause playback and reset player to the start of the file. That way, we can
                // play the word from the beginning when we resume playback.
                mMediaPlayer.pause();
                mMediaPlayer.seekTo(0);
            } else if (focusChange == AudioManager.AUDIOFOCUS_GAIN) {
                // The AUDIOFOCUS_GAIN case means we have regained focus and can resume playback.
                mMediaPlayer.start();
            } else if (focusChange == AudioManager.AUDIOFOCUS_LOSS) {
                // The AUDIOFOCUS_LOSS case means we've lost audio focus and
                // Stop playback and clean up resources
                releaseMediaPlayer();
            }
        }
    };

    public PhrasesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.word_list, container, false);

        /** TODO: Insert all the code from the PhrasesActivity’s onCreate() method after the setContentView method call */

        //Create and Setup
        mAudioManager = (AudioManager) getActivity().getSystemService(Context.AUDIO_SERVICE);

        final ArrayList<Word> phrases = new ArrayList<>();


        phrases.add(new Word("Jam bandu na?","Good morning",R.raw.phrase_gmorning));
        phrases.add(new Word("Noi chomri?","How are you?",R.raw.phrase_greetinghowareyou));
        phrases.add(new Word("Noi sare?","How is home?",R.raw.phrase_howishome));
        phrases.add(new Word("Noi iyalu ma?","How is your family?",R.raw.phrase_howisthefamily));
        phrases.add(new Word("Jam Alhamdulillah","Good Alhamdulillah",R.raw.phrase_goodwthnks));
        phrases.add(new Word("Mi hofni ma","I greet you",R.raw.phrase_igreetyou));
        phrases.add(new Word("Sai yeso","See you later",R.raw.phrase_later));
        phrases.add(new Word("Sai jango","Till tomorrow",R.raw.phrase_tilltomorrow));
        phrases.add(new Word("Sai fajiri","Good night",R.raw.phrase_gnight));
        phrases.add(new Word("Jam Wala","Sleep well",R.raw.phrase_gnight2));
        phrases.add(new Word("Noi inde ma?","What is your name?",R.raw.phrase_whatsyourname));
        phrases.add(new Word("Inde am [inde]","My name is [name]",R.raw.phrase_mynameis));
        phrases.add(new Word("Hatoi a yahata?","Where are you going?",R.raw.phrase_whereyougoing));
        phrases.add(new Word("Mi do yaha [babal]","I am going to [place]",R.raw.phrase_imgoing));



        WordAdapter adapter = new WordAdapter(getActivity(),phrases,R.color.colorBrown);

        ListView listView = rootView.findViewById(R.id.list);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                // Release the media player if it currently exists because we are about to
                // play a different sound file
                releaseMediaPlayer();

                // Get the {@link Word} object at the given position the user clicked on
                Word word = phrases.get(position);

                //Log.v("NumbersActivity", "Current word: " + word);

// Request audio focus for playback
                int result = mAudioManager.requestAudioFocus(mOnAudioFocusChangeListener,
                        // Use the music stream.
                        AudioManager.STREAM_MUSIC,
                        // Request permanent focus.
                        AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);

                if (result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {

                    // We have audio focus now

                    //Creating a media player with a song
                    mMediaPlayer = MediaPlayer.create(getActivity(),word.getMwordSound());
                    //play sound
                    mMediaPlayer.start();

                    // Setup a listener on the media player, so that we can stop and release the
                    // media player once the sound has finished playing.
                    mMediaPlayer.setOnCompletionListener(mCompletionListener);

                }

            }
        });

        return rootView;
    }

    @Override
    public void onStop() {
        super.onStop();
        releaseMediaPlayer();
    }

    /**
     * Clean up the media player by releasing its resources.
     */
    private void releaseMediaPlayer() {
        // If the media player is not null, then it may be currently playing a sound.
        if (mMediaPlayer != null) {
            // Regardless of the current state of the media player, release its resources
            // because we no longer need it.
            mMediaPlayer.release();

            // Set the media player back to null. For our code, we've decided that
            // setting the media player to null is an easy way to tell that the media player
            // is not configured to play an audio file at the moment.
            mMediaPlayer = null;

            // Regardless of whether or not we were granted audio focus, abandon it. This also
            // unregisters the AudioFocusChangeListener so we don't get anymore callbacks.
            mAudioManager.abandonAudioFocus(mOnAudioFocusChangeListener);
        }
    }
}
