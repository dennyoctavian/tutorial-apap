package apap.tutorial.kebunsafari.service;

import apap.tutorial.kebunsafari.model.KebunSafariModel;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;

@Service
public class KebunSafariInMemoryService implements KebunSafariService {
    private List<KebunSafariModel> listKebunSafari;

    public KebunSafariInMemoryService(){
        listKebunSafari = new ArrayList<>();
    }

    @Override 
    public void addKebunSafari(KebunSafariModel kebunSafari) {
        kebunSafari.setAlamat("-");
        listKebunSafari.add(kebunSafari);
    }

    @Override 
    public List<KebunSafariModel> getKebunSafariList() {
        return listKebunSafari;
    }

    @Override
    public KebunSafariModel getKebunSafariByIdKebunSafari(String idKebunSafari) {
        for(KebunSafariModel o : listKebunSafari){
            if (o.getIdKebunSafari().equals(idKebunSafari)){
                return o;
            }
        }
        return null;
    }
}
