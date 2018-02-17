
/**
 * @brief Classe InfoWindowView
 * @author Joseph Sousa
 * @mail jsantos.te@gmail.com
 * @date 29/01/2018
 */
import com.texugos.botecando.entidades.Estabelecimento;
import com.texugos.botecando.interfaces.EstabelecimentoDAO;
import com.texugos.botecando.persistencia.EstabelecimentoDAOImpl;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.event.map.OverlaySelectEvent;
import org.primefaces.model.map.DefaultMapModel;
import org.primefaces.model.map.LatLng;
import org.primefaces.model.map.MapModel;
import org.primefaces.model.map.Marker;

@ManagedBean
@ViewScoped
public class InfoWindowView implements Serializable {

    private EstabelecimentoDAO estabelecimentoDAO = new EstabelecimentoDAOImpl();

    List<Estabelecimento> estabelecimentos;

    private MapModel advancedModel;

    private Marker marker;

    @PostConstruct
    public void init() {
        estabelecimentos = estabelecimentoDAO.listarTodos();

        advancedModel = new DefaultMapModel();

        for (Estabelecimento estabelecimento : estabelecimentos) {

            LatLng coord1 = new LatLng(Double.parseDouble(estabelecimento.getLatitude()), Double.parseDouble(estabelecimento.getLongitude()));
            advancedModel.addOverlay(new Marker(coord1,estabelecimento.getNome(),"konyaalti.png","http://maps.google.com/mapfiles/ms/micons/blue-dot.png"));
        }
    }

    public MapModel getAdvancedModel() {
        return advancedModel;
    }

    public void onMarkerSelect(OverlaySelectEvent event) {
        marker = (Marker) event.getOverlay();
    }

    public Marker getMarker() {
        return marker;
    }
}
