
/**
 * @brief Classe GeocodeView
 * @author Joseph Sousa
 * @mail jsantos.te@gmail.com
 * @date 18/02/2018
 */
import com.texugos.botecando.entidades.Estabelecimento;
import com.texugos.botecando.interfaces.EstabelecimentoDAO;
import com.texugos.botecando.persistencia.EstabelecimentoDAOImpl;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import org.primefaces.event.map.GeocodeEvent;
import org.primefaces.model.map.DefaultMapModel;
import org.primefaces.model.map.GeocodeResult;
import org.primefaces.model.map.LatLng;
import org.primefaces.model.map.MapModel;
import org.primefaces.model.map.Marker;

@ManagedBean
public class GeocodeView {

    private EstabelecimentoDAO estabelecimentoDAO = new EstabelecimentoDAOImpl();
    private MapModel geoModel;
    private MapModel revGeoModel;
    private String centerGeoMap = "41.850033, -87.6500523";
    private double lat;
    private double lng;
    private Estabelecimento estabelecimento;

    public GeocodeView() {
        estabelecimento = new Estabelecimento();
    }
    
    @PostConstruct
    public void init() {
        geoModel = new DefaultMapModel();
        revGeoModel = new DefaultMapModel();
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLng() {
        return lng;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }

    public Estabelecimento getEstabelecimento() {
        return estabelecimento;
    }

    public void setEstabelecimento(Estabelecimento estabelecimento) {
        this.estabelecimento = estabelecimento;
    }

    public void onGeocode(GeocodeEvent event) {
        List<GeocodeResult> results = event.getResults();
        
        if (results != null && !results.isEmpty()) {
            LatLng center = results.get(0).getLatLng();
            centerGeoMap = center.getLat() + "," + center.getLng();
            estabelecimento.setLatitude(center.getLat());
            estabelecimento.setLongitude(center.getLng());
            
            for (int i = 0; i < results.size(); i++) {
                GeocodeResult result = results.get(i);
                geoModel.addOverlay(new Marker(result.getLatLng(), result.getAddress()));
                estabelecimento.setNome(result.getAddress());
            }
            estabelecimentoDAO.adicionar(estabelecimento);
        }
    }

    public MapModel getGeoModel() {
        return geoModel;
    }

    public MapModel getRevGeoModel() {
        return revGeoModel;
    }

    public String getCenterGeoMap() {
        return centerGeoMap;
    }

    public boolean adicionar() {
        return estabelecimentoDAO.adicionar(estabelecimento);
    }
}
