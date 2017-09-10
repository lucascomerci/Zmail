package com.example.vicentico.zmail;

import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by vicentico on 9/6/17.
 */

public class MensajeAdapter extends BaseAdapter {

  private List<Mensaje> mensajes;

    public MensajeAdapter(List<Mensaje> mensajes){
        this.mensajes = mensajes;
    }



    @Override
    public int getCount() {
        return mensajes.size();
    }

    @Override
    public Object getItem(int position) {
        return mensajes.get(position);
    }

    @Override
    public long getItemId(int position) {
        return mensajes.get(position).getId();

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view;
        String recorta_cadena;
        //optimizacion de reutilizacion de recursos
        if(convertView == null){
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_mensaje,parent,false);
        }else{
            view = convertView;
        }

        Mensaje mensaje = (Mensaje) getItem(position);

       // TextView idRemitente = (TextView) view.findViewById(R.id.idRemitente);
        TextView idAsunto = (TextView) view.findViewById(R.id.idAsunto);
        TextView idMsg    = (TextView) view.findViewById(R.id.idMsg);
        TextView idAvatar = (TextView) view.findViewById(R.id.idAvatar);


        recorta_cadena = mensaje.getAsunto().toString();
        if (recorta_cadena.length()> 40)  {
            recorta_cadena = recorta_cadena.substring(0,40);
            recorta_cadena = recorta_cadena+"...";
        }
        idAsunto.setText(recorta_cadena);

        recorta_cadena = mensaje.getMensaje().toString();
        if (recorta_cadena.length()> 50)  {
            recorta_cadena = recorta_cadena.substring(0,50);
            recorta_cadena = recorta_cadena+"...";
        }
        idMsg.setText(recorta_cadena);


        recorta_cadena = mensaje.getRemitente().toString().substring(0,1);
        idAvatar.setText(recorta_cadena);


       //idAvatar.setBackground(23);
      //  idAvatar.setBackgroundColor(Color.parseColor("#D48393"));
        GradientDrawable bgShape = (GradientDrawable)idAvatar.getBackground();
        bgShape.setColor(Color.parseColor(mensaje.getColor()));

        return view;
    }
}
