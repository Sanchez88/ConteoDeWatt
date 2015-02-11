package adaptadores;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.com.entidades.rfs.clEnergia;
import com.elite.ronald.comluzcontego.R;
import com.elite.ronald.comluzcontego.agregar_conteo;
import com.elite.ronald.comluzcontego.principal;

import java.util.List;

/**
 * Created by Ronald on 04/02/15.
 */
public class clAdaptadorListDias extends RecyclerView.Adapter<clAdaptadorListDias.ViewHolder> {

    private List<clEnergia> lista;
    private Context context;

    public clAdaptadorListDias(Context context, List<clEnergia> lista){
        this.lista = lista;
        this.context = context;
    }

    @Override
    public clAdaptadorListDias.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_dias, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        clEnergia cl = lista.get(position);
        holder.Conteo.setText("" + cl.getENERGY_CONTEO());
        holder.codigo.setText("(" + cl.getCON_ID() + ")");
        holder.Hora.setText(cl.getHORA());
    }

    @Override
    public int getItemCount() {
        return lista.size();
    }

     class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        // each data item is just a string in this case
        public TextView Hora,codigo, Conteo;

        public ViewHolder(View v) {
            super(v);
            Hora = (TextView) v.findViewById(R.id.twLDHora);
            Conteo = (TextView) v.findViewById(R.id.twLDContador);
            codigo = (TextView) v.findViewById(R.id.twLDCod);
            v.setOnClickListener(this);

        }

         @Override
         public void onClick(View v) {
             Intent i = new Intent(context, agregar_conteo.class);
             clEnergia cl =  lista.get(getPosition());

             i.putExtra("codigo",new String[]{"" +cl.getCON_ID(),"" +cl.getENERGY_CONTEO(),cl.getFECHA()});
             context.startActivity(i);
         }
     }
}
