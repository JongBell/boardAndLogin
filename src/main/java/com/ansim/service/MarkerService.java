package com.ansim.service;

import com.ansim.dto.CctvDTO;
import com.ansim.dto.DeliboxDTO;
import com.ansim.dto.EmergbellDTO;


import java.util.List;


public interface MarkerService {

    //cctv 좌표
    public List<CctvDTO> cctv()throws Exception;

    //emergbell 좌표
    public List<EmergbellDTO> emergbell()throws Exception;

    //delibox 좌표
    public List<DeliboxDTO> delibox()throws Exception;

}
