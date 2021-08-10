package com.unam.mercadoenlinea.services;


import com.unam.mercadoenlinea.dtos.OpinionDto;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

public interface IOpinionService {
	boolean saveOpinion(OpinionDto opinionDto) throws IOException;
	List<OpinionDto> opinionsById(Long fk);
}
