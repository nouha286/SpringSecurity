package com.youcode.visionarycrofting.config;



import com.youcode.visionarycrofting.entity.*;
import com.youcode.visionarycrofting.repository.RoleRepository;
import com.youcode.visionarycrofting.repository.UserRepository;
import com.youcode.visionarycrofting.service.ClientService;
import com.youcode.visionarycrofting.service.ProviderService;
import com.youcode.visionarycrofting.service.StockService;
import com.youcode.visionarycrofting.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class UserConfig {
    @Autowired
    UserRepository userRepository;
    @Autowired
    RoleRepository roleRepository;
    @Autowired
    ClientService clientService;
    @Autowired
    ProviderService providerService;
    @Autowired
    StockService stockService;
    @Bean
    CommandLineRunner commandLineRunner1 (UserService userService){
        return args -> {

            Role role=new Role("CLIENT");
            Role role1=new Role("STOCK_MANAGER");
            Role role2=new Role("FOURNISSEUR");
            roleRepository.saveAll(List.of(role1,role2,role));

            Client client=new Client("nouhaila","nouhaila@gmail.com","123456",new ArrayList<>(),"0612345678","hey iziki 5");
            Provider provider=new Provider("hiba","hiba@gmail.com","123456",new ArrayList<>(),"0611223344","marrakech");
            Stock stock=new Stock("ismail","ismail@gmail.com","123456",new ArrayList<>(),"0067779772","iziki");
            clientService.addClient(client);
            providerService.addProvider(provider);
            userService.saveUser(stock);

            userService.addRoleToUser("hiba@gmail.com","FOURNISSEUR");
            userService.addRoleToUser("ismail@gmail.com","STOCK_MANAGER");
            userService.addRoleToUser("nouhaila@gmail.com","CLIENT");


        };
    }
}
