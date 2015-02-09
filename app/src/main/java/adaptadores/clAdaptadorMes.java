package adaptadores;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.com.entidades.rfs.clEnergia;
import com.com.entidades.rfs.clMes;
import com.elite.ronald.comluzcontego.R;
import com.elite.ronald.comluzcontego.principal;

import java.util.List;

/**
 * Created by Ronald on 04/02/15.
 */
public class clAdaptadorMes extends RecyclerView.Adapter<clAdaptadorMes.ViewHolder> {

    private List<clMes> lista;
    private Context context;

    public clAdaptadorMes(Context context,List<clMes> lista){
        this.lista = lista;
        this.context = context;
    }

    @Override
    public clAdaptadorMes.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.lista_inf, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        clMes cl = lista.get(position);
        holder.Conteo.setText("" + cl.getConteo());
        holder.Mes.setText("" + cl.getMes());
    }

    @Override
    public int getItemCount() {
        return lista.size();
    }

     class ViewHolder extends RecyclerView.ViewHolder implements  View.OnClickListener {
        // each data item is just a string in this case
        public TextView Mes, Conteo;

        public ViewHolder(View v) {
            super(v);
            Mes = (TextView) v.findViewById(R.id.twListaMes);
            Conteo = (TextView) v.findViewById(R.id.twListaConteo);
            //Mes.setOnClickListener(this); llamando el evento OnClickListener Por el momento  no lo llamare.
            v.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            Intent i = new Intent(context, principal.class);
            i.putExtra("fecha", lista.get(getPosition()).getMes());
            context.startActivity(i);
        }
    }
}
