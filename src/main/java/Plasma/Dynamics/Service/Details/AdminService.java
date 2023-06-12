package Plasma.Dynamics.Service.Details;


import Plasma.Dynamics.Dto.AdminField;
import Plasma.Dynamics.Dto.AdminFieldDto;
import Plasma.Dynamics.repos.AdminRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AdminService {

    private final AdminRepo adminRepo;

    @Transactional
    public void updateField(AdminFieldDto adminFieldDto){
        if(!adminFieldDto.getOne().equals("")){
            adminRepo.updateInfoOne(Integer.parseInt(adminFieldDto.getOne()));
        }
        if(!adminFieldDto.getTwo().equals("")){
            adminRepo.updateInfoTwo(Integer.parseInt(adminFieldDto.getTwo()));
        }
    }

    public void createNewField(AdminFieldDto adminFieldDto){
        AdminField adminField = new AdminField();
        adminField.setOne(Integer.parseInt(adminFieldDto.getOne()));
        adminField.setTwo(Integer.parseInt(adminFieldDto.getTwo()));
        adminRepo.save(adminField);
    }
}
