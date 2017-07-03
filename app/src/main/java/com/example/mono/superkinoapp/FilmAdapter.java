package com.example.mono.superkinoapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by tfqo on 18.06.2017.
 */
public class FilmAdapter extends BaseAdapter {

    private static ArrayList<FilmDetails> filmDetailsArrayList;
    private LayoutInflater layoutInflater;

    private Integer[] imgId = {
            R.drawable.dudi,
            R.drawable.ghost,
            R.drawable.gwiazdy,
            R.drawable.obcy,
            R.drawable.straznicy,
            R.drawable.szybcy,
            R.drawable.uciekaj
    };

    public FilmAdapter(Context context, ArrayList<FilmDetails> results) {
        filmDetailsArrayList = results;
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return filmDetailsArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return filmDetailsArrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.film_list_template, null);
            holder = new ViewHolder();
            holder.txt_filmTitle = (TextView) convertView.findViewById(R.id.title);
            holder.txt_filmGenre = (TextView) convertView.findViewById(R.id.genre);
            holder.filmImage = (ImageView) convertView.findViewById(R.id.filmImage);

            convertView.setTag(holder);
        }
        else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.txt_filmTitle.setText(filmDetailsArrayList.get(position).getTitle());
        holder.txt_filmGenre.setText(filmDetailsArrayList.get(position).getGenre());
        holder.filmImage.setImageResource(imgId[filmDetailsArrayList.get(position).getImageNumber() - 1]);

        return convertView;
    }

    static class ViewHolder {
        TextView txt_filmTitle;
        TextView txt_filmGenre;
        ImageView filmImage;
    }
}
