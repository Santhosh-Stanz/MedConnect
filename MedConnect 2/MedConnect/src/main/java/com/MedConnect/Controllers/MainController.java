package com.MedConnect.Controllers;
import com.MedConnect.Entity.HomeEntity;
import com.MedConnect.Entity.SuggestionEntity;
import com.MedConnect.Models.Patients.Patient_Credentials;
import com.MedConnect.Models.Patients.Patient_Logs;
import com.MedConnect.Models.Providers.Provider_Credentials;
import com.MedConnect.Models.Providers.Provider_Logs;
import com.MedConnect.Models.User.UserCredentials;
import com.MedConnect.Repositary.Patients.Patient_BasicParameters_DataRepository;
import com.MedConnect.Repositary.Patients.Patient_Credentials_DataRepository;
import com.MedConnect.Repositary.Patients.Patient_Logs_Repository;
import com.MedConnect.Repositary.Providers.Provider_Credentials_Repository;
import com.MedConnect.Repositary.Providers.Provider_Logs_Repository;
import com.MedConnect.Repositary.User.UserCredentials_Repository;
import com.MedConnect.Service.Input;
import com.MedConnect.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/MedConnect/")
public class MainController {

    @Autowired
    UserCredentials_Repository  userCredentialsRepo;

    @Autowired
    Patient_Credentials_DataRepository patientCredentialsDataRepo;

    @Autowired
    Patient_BasicParameters_DataRepository patientBasicParametersDataRepo;

    @Autowired
    Provider_Credentials_Repository providerCredentialsRepo;

    @Autowired
    Patient_Logs_Repository patientLogsRepo;

    @Autowired
    Provider_Logs_Repository providerLogsRepo;

    @Autowired
    UserService userService;

    HomeEntity homeEntity;
    SuggestionEntity suggestionEntity;

    String currentuser;

    @CrossOrigin
    @PostMapping ("/login")
    public String loginpage(@RequestBody UserCredentials userCredentials)
    {
        homeEntity=new HomeEntity();
        if(userService.UserAuthentication(userCredentials)){
            this.currentuser=userCredentials.getUsername();
            homeEntity.setRecommandedproviders(userService.recommandlist(userCredentials.getUsername()));
            homeEntity.setHosptials(userService.HospitalList());
            homeEntity.setCardiolagist(userService.CardioList());
            System.out.println(homeEntity.getCardiolagist());
            return "Success";
        }
        return "Not-Success";

    }

    @CrossOrigin
    @PostMapping("/home")
    public HomeEntity homepage(){
        return homeEntity;
    }

    @CrossOrigin
    @PostMapping("/suggesstion")
    public SuggestionEntity suggesstionpage(){
        suggestionEntity.setSuggesstionlist(userService.suggestionlist(currentuser));
        suggestionEntity.setPatientBasicParameters(userService.suggessBasicParameters(currentuser));
        suggestionEntity.setPatientHealthParameters(userService.suggesshealthParameters(currentuser));
        return suggestionEntity;
    }

    @CrossOrigin
    @PostMapping("/provider")
    public Provider_Credentials providerpage(@RequestBody Input input){
        String name=input.getName();
        Provider_Credentials providerCredentials = null;
        for (Provider_Credentials i:providerCredentialsRepo.findAll()){
            if(i.getName().equals(name) && i.getRole()!=null){
                providerCredentials=i;
            }
        }
        return providerCredentials;
    }

    @CrossOrigin
    @PostMapping("/appointment")
    public String appoinmentpage(@RequestBody Input input){
        String name=input.getName();
        Patient_Logs patient_logs = new Patient_Logs();
        patient_logs.setName(currentuser);
        patient_logs.setStatus(true);
        for (Provider_Credentials i:providerCredentialsRepo.findAll()){
            if(i.getName().equals(name) && i.getRole()!=null){
                patient_logs.setProviderCredentials(i);
            }
        }
        patientLogsRepo.insert(patient_logs);
        Provider_Logs providerLogs= new Provider_Logs();
        providerLogs.setName(name);
        providerLogs.setStatus(true);
        for (Patient_Credentials i:patientCredentialsDataRepo.findAll()){
            if(i.getName().equals(currentuser) && i.getLocation()!=null){
                providerLogs.setPatient_credentials(i);
            }
        }
        providerLogsRepo.insert(providerLogs);
        return "success";
    }
}
