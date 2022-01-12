package com.accenture.lkm.service;
import org.springframework.stereotype.Service;

import com.accenture.lkm.business.bean.ItemBean;
import com.accenture.lkm.entity.Price;

@Service
public interface PriceService {


    List<String> getdetails(long id);



}

