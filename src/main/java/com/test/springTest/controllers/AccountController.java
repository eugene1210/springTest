package com.test.springTest.controllers;

import com.test.springTest.dto.AcccountRequestDTO;
import com.test.springTest.dto.AccountRequestListDTO;
import com.test.springTest.dto.AccountResponsDTO;
import com.test.springTest.dto.AccountResposeListDTO;
import com.test.springTest.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class AccountController {

    private final AccountService accountService;

    @Autowired
    private RestTemplate restTemplate;

    @Value("${url}")
    private String url;

    @Autowired
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }


    @PostMapping("/create")
    public Long createAccount(@RequestBody AcccountRequestDTO acccountRequestDTO) {
        return accountService.createAccount(acccountRequestDTO.getId(),
                                            acccountRequestDTO.getNameRu(),
                                            acccountRequestDTO.getNameKz(),
                                            acccountRequestDTO.getStateId());
    }

    @GetMapping("/accounts")
    public List<AccountResponsDTO> getAccount(@RequestParam(value = "stateId", required = false, defaultValue = "") String stateId) {
        AccountRequestListDTO responseEntity = restTemplate.getForObject(url, AccountRequestListDTO.class);
        List<AccountResponsDTO> collect;
        if (!stateId.isEmpty()) {
            collect = responseEntity.getAccountRequestListDTOS()
                    .stream()
                    .map((accout) -> new AccountResponsDTO(accout.getId(), accout.getNameRu(),
                                                           accout.getNameKz(),
                                                           accout.getStateId()))
                    .filter(o -> o.getStateId() == Integer.parseInt(stateId))
                    .collect(Collectors.toList());
        } else {
            collect = responseEntity.getAccountRequestListDTOS()
                    .stream()
                    .map((accout) -> new AccountResponsDTO(accout.getId(), accout.getNameRu(),
                                                           accout.getNameKz(),
                                                           accout.getStateId()))
                    .collect(Collectors.toList());
        }
        return new AccountResposeListDTO(collect).getAccountResponsDTOS();
    }

    @ExceptionHandler(NumberFormatException.class)
    public String stateIdFormatException(Exception e) {
        return e.getMessage();
    }
}
