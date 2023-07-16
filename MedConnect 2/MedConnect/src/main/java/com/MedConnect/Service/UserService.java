package com.MedConnect.Service;

import com.MedConnect.Models.Patients.Patient_BasicParameters;
import com.MedConnect.Models.Patients.Patient_Diseases;
import com.MedConnect.Models.Patients.Patient_HealthParameters;
import com.MedConnect.Models.Providers.Provider_Credentials;
import com.MedConnect.Models.User.UserCredentials;
import com.MedConnect.Repositary.Patients.Patient_BasicParameters_DataRepository;
import com.MedConnect.Repositary.Patients.Patient_Diseases_Repository;
import com.MedConnect.Repositary.Patients.Patient_HealthParameters_Repository;
import com.MedConnect.Repositary.Providers.Provider_Credentials_Repository;
import com.MedConnect.Repositary.User.UserCredentials_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class UserService {

    @Autowired
    UserCredentials_Repository userCredentialsRepo;

    @Autowired
    Patient_Diseases_Repository patientDiseasesRepo;

    @Autowired
    Provider_Credentials_Repository providerCredentialsRepo;

    @Autowired
    Patient_HealthParameters_Repository patientHealthParametersRepo;

    @Autowired
    Patient_BasicParameters_DataRepository patientBasicParametersDataRepo;

    public boolean UserAuthentication(UserCredentials userCredentials){
        List<UserCredentials> list= userCredentialsRepo.findAll();
        for (UserCredentials i:list){
            if (i.getUsername().equals(userCredentials.getUsername())
            && i.getPassword().equals(userCredentials.getPassword())){
                return true;
            }
        }
        return false;
    }

    public List<Provider_Credentials> recommandlist(String name){

        List<String> diseases = new ArrayList<>();
        for(Patient_Diseases i:patientDiseasesRepo.findAll()){
            if(name.equals(i.getName())){
                diseases=i.getDiseases();
            }
        }

        List<Provider_Credentials> recomandlist= new ArrayList<>();

        for(Provider_Credentials i:providerCredentialsRepo.findAll()){
            for (String j:diseases){
                if(i.getDomainlist()!=null && i.getDomainlist().contains(j)){
                    if(!recomandlist.contains(i) && i.getRole()!=null){
                        recomandlist.add(i);
                    }
                }
            }
        }

        return recomandlist;
    }

    public List<Provider_Credentials> HospitalList(){
        List<Provider_Credentials> hospitallist= new ArrayList<>();

        for (Provider_Credentials i:providerCredentialsRepo.findAll()){
            if("Hospital".equals(i.getRole()) && !hospitallist.contains(i)){
                hospitallist.add(i);
            }
        }

        for (int i=0;i<hospitallist.size();i++){
            if(hospitallist.get(i).getRole()==null){
                hospitallist.remove(hospitallist.get(i));
            }
        }

        return hospitallist;
    }

    public List<Provider_Credentials> CardioList(){
        List<Provider_Credentials> Cardiolist= new ArrayList<>();

        for (Provider_Credentials i: providerCredentialsRepo.findAll()){
            if (i.getDomainlist().contains("Cardio") && !Cardiolist.contains(i) && i.getRole()!=null){
                Cardiolist.add(i);
            }
        }

        return Cardiolist;
    }

    public List<String> suggestionlist(String name){

        Patient_HealthParameters patientHealthParameters=null;
        for (Patient_HealthParameters i:patientHealthParametersRepo.findAll()){
            if(name.equals(i.getName())){
                patientHealthParameters=i;
                break;
            }
        }

        List<String> sugesstionlist= new ArrayList<>();

        if(patientHealthParameters.getBp()>170
                && patientHealthParameters.getCholestral()>220
                && patientHealthParameters.getSugar()>160
                && patientHealthParameters.getSpo2()>49
                && patientHealthParameters.getHeartrate()>120){
            sugesstionlist.add("Asthma");
        }

        if(patientHealthParameters.getBp()>160
                && patientHealthParameters.getCholestral()>240
                && patientHealthParameters.getSugar()>170
                && patientHealthParameters.getSpo2()>46
                && patientHealthParameters.getHeartrate()>120){
            sugesstionlist.add("Cardio");
        }

        if(patientHealthParameters.getBp()>180
                && patientHealthParameters.getCholestral()>220
                && patientHealthParameters.getSugar()>180
                && patientHealthParameters.getSpo2()>47
                && patientHealthParameters.getHeartrate()>120){
            sugesstionlist.add("Diabeties");
        }

        return sugesstionlist;
    }

    public Patient_HealthParameters suggesshealthParameters(String name){
        for (Patient_HealthParameters i:patientHealthParametersRepo.findAll()){
            if (i.getName().equals(name) && i.getSpo2()!=0){
                return i;
            }
        }
        return null;
    }

    public Patient_BasicParameters suggessBasicParameters(String name){
        for (Patient_BasicParameters i:patientBasicParametersDataRepo.findAll()){
            if (i.getName().equals(name) && i.getGender()!=null){
                return i;
            }
        }
        return null;
    }

}
