package adaptadores;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.elite.ronald.comluzcontego.R;

import java.util.List;

import entidades.clLista;

/**
 * Created by Ronald on 04/02/15.
 */
public class clAdaptadorMes extends RecyclerView.Adapter<clAdaptadorMes.ViewHolder> {

    public List<clLista> lista;

    public clAdaptadorMes(List<clLista> lista){
        this.lista = lista;
    }

    @Override
    public clAdaptadorMes.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.lista_inf, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        clLista cl = lista.get(position);
        holder.Conteo.setText("" + cl.getCantidad());
        holder.Mes.setText(cl.getMes());
    }

    @Override
    public int getItemCount() {
        return lista.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView Mes, Conteo;

        public ViewHolder(View v) {
            super(v);
            Mes = (TextView) v.findViewById(R.id.twListaMes);
            Conteo = (TextView) v.findViewById(R.id.twListaConteo);
        }
    }
}
