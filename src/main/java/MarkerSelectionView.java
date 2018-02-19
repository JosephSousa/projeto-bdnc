
import com.texugos.botecando.entidades.Estabelecimento;
import com.texugos.botecando.interfaces.EstabelecimentoDAO;
import com.texugos.botecando.persistencia.EstabelecimentoDAOImpl;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.map.OverlaySelectEvent;
import org.primefaces.model.map.DefaultMapModel;
import org.primefaces.model.map.LatLng;
import org.primefaces.model.map.MapModel;
import org.primefaces.model.map.Marker;

@ManagedBean
@ViewScoped
public class MarkerSelectionView implements Serializable {

    private EstabelecimentoDAO estabelecimentoDAO = new EstabelecimentoDAOImpl();

    List<Estabelecimento> estabelecimentos;

    private MapModel simpleModel;

    private Marker marker;

    @PostConstruct
    public void init() {
        estabelecimentos = estabelecimentoDAO.listarTodos();
        
        simpleModel = new DefaultMapModel();
        
         for (Estabelecimento estabelecimento : estabelecimentos) {
            LatLng coord1 = new LatLng(estabelecimento.getLatitude(),estabelecimento.getLongitude());
            simpleModel.addOverlay(new Marker(coord1,estabelecimento.getNome()));
        }
    }

    public MapModel getSimpleModel() {
        return simpleModel;
    }

    public void onMarkerSelect(OverlaySelectEvent event) {
        marker = (Marker) event.getOverlay();

        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Marker Selected", marker.getTitle()));
    }

    public Marker getMarker() {
        return marker;
    }
}
