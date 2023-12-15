package com.ansim.service;

import com.ansim.dto.CctvDTO;
import com.ansim.dto.DeliboxDTO;
import com.ansim.dto.EmergbellDTO;
import com.ansim.mapper.MarkerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MarkerServiceImpl implements MarkerService{
    @Autowired
    MarkerMapper mapper;

    @Override
    public List<CctvDTO> cctv() throws Exception {
        return mapper.cctv();
    }

    @Override
    public List<EmergbellDTO> emergbell() throws Exception {
        return mapper.emergbell();
    }

    @Override
    public List<DeliboxDTO> delibox() throws Exception {
        return mapper.delibox();
    }
}
