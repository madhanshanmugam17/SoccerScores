package adapter;

/**
 * Created by user on 27-10-2015.
 */
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.madhan.soccerscores.Models.Fixture;
import com.madhan.soccerscores.R;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SimpleArrayAdapter extends ArrayAdapter<Fixture> {
    private final Context context;
    private final List<Fixture> fixtureList;



    // View lookup cache
    private static class ViewHolder {
        TextView homeTeam,awayTeam,status,result,date,matchDay;

    }
    public SimpleArrayAdapter(Context context, List<Fixture> objects) {
        super(context, R.layout.row_layout, objects);
        this.context = context;
        fixtureList = objects;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
     //   Fixture fixture = null; //= getItem(position);
     //   View rowView = inflater.inflate(R.layout.row_layout, parent, false);
        ViewHolder viewHolder;
        if (convertView == null) {
            viewHolder = new ViewHolder();
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.row_layout, parent, false);
            viewHolder.homeTeam = (TextView) convertView.findViewById(R.id.homeTeam);
           // viewHolder.home = (TextView) convertView.findViewById(R.id.tvHome);
            convertView.setTag(viewHolder);
        }
        else{
            viewHolder = (ViewHolder) convertView.getTag();
        }

        Fixture fixtures = fixtureList.get(position);


        TextView homeView = (TextView) convertView.findViewById(R.id.homeTeam);
        TextView awayTeam = (TextView) convertView.findViewById(R.id.awayTeam);
        TextView status = (TextView) convertView.findViewById(R.id.status);
        TextView date = (TextView) convertView.findViewById(R.id.date);
        TextView result = (TextView) convertView.findViewById(R.id.result);
        viewHolder.homeTeam.setText(fixtures.getHomeTeamName());
        homeView.setText(fixtures.getHomeTeamName());
        awayTeam.setText(fixtures.getAwayTeamName());
        status.setText(fixtures.getStatus());
        date.setText(convertStringtoDate(fixtures.getDate()).toString());
        if(Integer.parseInt(fixtures.getResult().getGoalsHomeTeam().toString())>Integer.parseInt(fixtures.getResult().getGoalsAwayTeam().toString()))
        {
            result.setText(fixtures.getHomeTeamName()+" "+"Won");
        }
        else if(Integer.parseInt(fixtures.getResult().getGoalsHomeTeam().toString())<Integer.parseInt(fixtures.getResult().getGoalsAwayTeam().toString())){

            result.setText(fixtures.getAwayTeamName()+" "+"Won");
        }
        else{
            result.setText("Match Drawn");
        }

        Log.v(">>>result", "" + fixtures.getResult().getGoalsHomeTeam());



        return convertView;
    }
    public static  String  convertStringtoDate(String s)  {

        SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
      //  Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
        Date date = null;
        try {
            date = format.parse(s);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        String datetime = dateformat.format(date);

        return datetime;
    }


}


