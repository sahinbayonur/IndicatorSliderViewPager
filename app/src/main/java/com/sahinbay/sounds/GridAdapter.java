package com.sahinbay.sounds;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.graphics.BitmapFactory;
import android.media.MediaPlayer;
import android.os.Build;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.Toast;

import androidx.core.app.NotificationCompat;
import androidx.recyclerview.widget.RecyclerView;

import java.io.IOException;
import java.util.List;

public class GridAdapter extends RecyclerView.Adapter<GridAdapter.ViewHolder> {

    Context context;
    List<Item> mDataset;
    MediaPlayer[] mediaPlayers;
    MediaPlayer hey;
    private int mSelectedItemPosition = -1;
    int soundNumber = 0;

    public GridAdapter(Context context, List<Item> models) {
        this.context = context;
        this.mDataset = models;
        this.mediaPlayers = new MediaPlayer[mDataset.size()];
    }

    public boolean stopAllMedia() {
        for (int i = 0; i < mediaPlayers.length; i++) {
            if (mediaPlayers[i] != null) {
                if (mediaPlayers[i].isPlaying()) {
                    Log.e("GridAdapter", "stopAllMedia already playing stoping = " + i);

                    mediaPlayers[i].stop();
                    mediaPlayers[i].release();
                    mediaPlayers[i] = null;
                    Log.e("GridAdapter", "stopAllMedia stop ");
                    /*bar.setAlpha(0.3f);
                    imView.setAlpha(0.3f);
                    bar.setProgress(0);*/

                }
            }
        }

        return true;
    }

    public MediaPlayer[] getMediaPlayers() {
        return this.mediaPlayers;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public ImageView imIcon;
        public SeekBar seekBar;

        public ViewHolder(final View view) {
            super(view);

            Log.e("ViewHolder", "on gridadapter viewHolder " + getAdapterPosition());
            imIcon = view.findViewById(R.id.icon_med);
            seekBar = view.findViewById(R.id.volume_seek);

            int width = Config.getScreenDimensions("width", (MainActivity) context);
            width = width - 100;
            Log.e("TAG", "width of the screen is  = " + width);
            int singleItemWidth = width / 2;

            imIcon.setLayoutParams(new LinearLayout.LayoutParams(singleItemWidth / 3, singleItemWidth / 3));
            seekBar.setLayoutParams(new LinearLayout.LayoutParams(singleItemWidth - (singleItemWidth * 1 / 4), 100));

            imIcon.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    try {
                        playStart(getAdapterPosition(), seekBar, imIcon);

                        if (soundNumber == 0) {
                            stopNotification();
                        }

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });


            seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                @Override
                public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                    volumeChange(getAdapterPosition(), (float) i / 10);
                }

                @Override
                public void onStartTrackingTouch(SeekBar seekBar) {

                }

                @Override
                public void onStopTrackingTouch(SeekBar seekBar) {

                }
            });
            //getAdapterPosition();
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.player_item, parent, false);
        Log.e("ViewHolder", "onCreateViewHolder " + viewType);

        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Item item = mDataset.get(position);
        //Picasso.with(c).load(item.getImage()).into(holder.imIcon);
        holder.imIcon.setImageBitmap(BitmapFactory.decodeResource(context.getResources(), item.getImage()));
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }

    public void showNotification() {

        int notificationId = 5;

        soundNumber++;

        //init notification
        NotificationCompat.Builder builder = new NotificationCompat.Builder(context)
                .setSmallIcon(R.drawable.bird)

                .setContentTitle("Natural Sounds")
                .setStyle(new NotificationCompat.BigTextStyle().bigText("Click view to visit Google."))
                .setAutoCancel(true)
                .setOngoing(true)
                .setDefaults(NotificationCompat.DEFAULT_ALL);

        /* Uri path = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        builder.setSound(path); */

        NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            String channelId = "YOUR_CHANNEL_ID";
            NotificationChannel channel = new NotificationChannel(channelId,
                    "Channel human readable title",
                    NotificationManager.IMPORTANCE_HIGH);
            notificationManager.createNotificationChannel(channel);
            builder.setChannelId(channelId);
        }

        notificationManager.notify(notificationId, builder.build());
    }

    public void stopNotification() {

        try {
            // we don't need to be foreground anymore
            NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
            // notificationManager.cancelAll();
            notificationManager.cancelAll();

        } catch (Exception e) {
            //
        }
    }

    public void playStart(int item, SeekBar seekBar, ImageView imView) throws IOException {

        Log.e("preset", "start play item = " + item);
        if (mediaPlayers[item] != null) {
            Toast.makeText(imView.getContext(), "NULL", Toast.LENGTH_SHORT).show();
            if (mediaPlayers[item].isPlaying()) {
                Log.e("preset", "already playing stoping = " + item);
                Toast.makeText(imView.getContext(), "isPlaying", Toast.LENGTH_SHORT).show();

                mediaPlayers[item].stop();
                mediaPlayers[item].release();
                mediaPlayers[item] = null;
                Log.e("TAG", "stop ");
                seekBar.setAlpha(0.3f);
                imView.setAlpha(0.3f);
                seekBar.setProgress(0);

                if (soundNumber != 0) {
                    soundNumber--;
                }

                // stopNotification();
            }
        } else {
            mediaPlayers[item] = MediaPlayer.create(context, mDataset.get(item).getPlay());
            mediaPlayers[item].setLooping(true);
            mediaPlayers[item].start();
            mediaPlayers[item].setVolume(0.5f, 0.5f);
            seekBar.setAlpha(1f);
            seekBar.setProgress(5);
            imView.setAlpha(1f);

            showNotification();

            Log.e("TAG", "first play ");
            Toast.makeText(imView.getContext(), "first play", Toast.LENGTH_SHORT).show();
        }
    }

    public void volumeChange(int position, float volume) {

        if (mediaPlayers[position] != null) {
            if (mediaPlayers[position].isPlaying()) {
                Log.e("TAG", "volume came " + volume);
                // Log.e("TAG","current volume before "+mediaPlayers[position].)
                mediaPlayers[position].setVolume(volume, volume);
            }
        }
    }
}
