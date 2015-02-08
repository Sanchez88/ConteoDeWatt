package adaptadores;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.com.entidades.rfs.clEnergia;
import com.elite.ronald.comluzcontego.R;

import java.util.List;

/**
 * Created by Ronald on 04/02/15.
 */
public class clAdaptadorMes extends RecyclerView.Adapter<clAdaptadorMes.ViewHolder> {

    private List<clEnergia> lista;
    private Context context;

    public clAdaptadorMes(Context context,List<clEnergia> lista){

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

        clEnergia cl = lista.get(position);
        holder.Conteo.setText("" + cl.getENERGY_CONTEO());
        holder.Mes.setText("" + cl.getFECHA() + " -- " + cl.getHORA());
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
        }

        @Override
        public void onClick(View v) {
            Toast.makeText(context, "Hora : " + lista.get(getPosition()).getHORA(), Toast.LENGTH_SHORT).show();
        }
    }
}
