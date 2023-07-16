package com.MedConnect.Entity;

import com.MedConnect.Models.Providers.Provider_Credentials;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class HomeEntity {

    private List<Provider_Credentials> recommandedproviders;
    private List<Provider_Credentials> hosptials;
    private List<Provider_Credentials> Cardiolagist;

    public List<Provider_Credentials> getRecommandedproviders() {
        return recommandedproviders;
    }

    public void setRecommandedproviders(List<Provider_Credentials> recommandedproviders) {
        this.recommandedproviders = recommandedproviders;
    }

    public List<Provider_Credentials> getHosptials() {
        return hosptials;
    }

    public void setHosptials(List<Provider_Credentials> hosptials) {
        this.hosptials = hosptials;
    }

    public List<Provider_Credentials> getCardiolagist() {
        return Cardiolagist;
    }

    public void setCardiolagist(List<Provider_Credentials> cardiolagist) {
        Cardiolagist = cardiolagist;
    }
}
