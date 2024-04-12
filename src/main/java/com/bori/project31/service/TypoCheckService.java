package com.bori.project31.service;

import com.bori.project31.model.CheckRequest;
import org.springframework.stereotype.Service;


@Service
public class TypoCheckService {

	public boolean typoCheck(CheckRequest checkReq) {
//		sentence.equalsIgnoreCase(inputText);
		return checkReq.getInputText().equalsIgnoreCase(checkReq.getQuest());		
	}
}
