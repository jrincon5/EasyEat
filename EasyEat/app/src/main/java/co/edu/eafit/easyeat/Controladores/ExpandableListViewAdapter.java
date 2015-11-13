package co.edu.eafit.easyeat.Controladores;

import android.app.Activity;
import android.content.Context;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.CheckedTextView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import app.jdavid.com.Controladores.R;

/**
 * Created by Julian on 06/10/2015.
 */

public class ExpandableListViewAdapter extends BaseExpandableListAdapter{
    private final SparseArray<GrupoItems> grupos;
    Context context;
    public LayoutInflater inflater;
    public Activity activity;

    // Constructor
    public ExpandableListViewAdapter(Activity act, SparseArray<GrupoItems> grupos) {
        activity = act;
        this.grupos = grupos;
        inflater = act.getLayoutInflater();
    }

    // Nos devuelve los datos asociados a un subitem en base
    // a la posición
    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return grupos.get(groupPosition).subItem.get(childPosition);
    }

    // Devuelve el id de un item o subitem en base a la
    // posición de item y subitem
    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return 0;
    }

    // En base a la posición del item y de subitem nos 33devuelve
    // el objeto view correspondiente y el layout para los subitems
    @Override
    public View getChildView(int groupPosition, final int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        final String children = (String) getChild(groupPosition, childPosition);
        ImageView imgImg = null; // cambio
        TextView textvw = null;
        if (convertView == null){
            convertView = inflater.inflate(R.layout.list_adapter, null); // cambio
        }
        textvw = (TextView) convertView.findViewById(R.id.list_row_title); // cambio
        imgImg = (ImageView) convertView.findViewById(R.id.list_row_image); // cambio
        textvw.setText(children);  // cambio
        imgImg.setImageResource(grupos.get(0).getFoto().get(0));  // Esta linea hay que arreglarla
        convertView.setOnClickListener(new View.OnClickListener() {
            //@Override
            public void onClick(View v) {
                Toast.makeText(activity, "Se ha añadido: " + children, Toast.LENGTH_SHORT).show();
                ((subMenuActivity)activity).pedidos.add(children);
            }
        });
        return convertView;
    }
    //Obtenemos el layout para los ítems
    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.items_menu, null);
        }
        GrupoItems grupo = (GrupoItems) getGroup(groupPosition);
        ((CheckedTextView) convertView).setText(grupo.Item);
        ((CheckedTextView) convertView).setChecked(isExpanded);
        return convertView;
    }
    // Nos devuelve la cantidad de subitems que tiene un ítem
    @Override
    public int getChildrenCount(int groupPosition) {
        return grupos.get(groupPosition).subItem.size();
    }

    //Los datos de un ítem especificado por groupPosition
    @Override
    public Object getGroup(int groupPosition) {
        return grupos.get(groupPosition);
    }

    //La cantidad de ítem que tenemos definidos
    @Override
    public int getGroupCount() {
        return grupos.size();
    }

    //Método que se invoca al contraer un ítem
    @Override
    public void onGroupCollapsed(int groupPosition) {
        super.onGroupCollapsed(groupPosition);
    }

    //Método que se invoca al expandir un ítem
    @Override
    public void onGroupExpanded(int groupPosition) {
        super.onGroupExpanded(groupPosition);
    }

    //Devuelve el id de un ítem
    @Override
    public long getGroupId(int groupPosition) {
        return 0;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    //Nos informa si es seleccionable o no un ítem o subitem
    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return false;
    }
}