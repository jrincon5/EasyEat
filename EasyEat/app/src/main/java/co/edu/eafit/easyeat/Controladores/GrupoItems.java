package co.edu.eafit.easyeat.Controladores;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Julian on 06/10/2015.
 */
public class GrupoItems {
    public String Item;
    public final List<String> subItem = new ArrayList<String>();
    public final List<Integer> subFoto=new ArrayList<Integer>();
    public GrupoItems(String Item) {
        this.Item = Item;
    }

    public List<Integer> getFoto() {
        return subFoto;
    }

    public String getItem() {
        return Item;
    }
}
