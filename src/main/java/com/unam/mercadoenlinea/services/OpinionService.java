package com.unam.mercadoenlinea.services;

import com.unam.mercadoenlinea.dtos.OpinionDto;
import com.unam.mercadoenlinea.entities.Opinion;
import com.unam.mercadoenlinea.entities.Producto;
import com.unam.mercadoenlinea.repository.IOpinionRepository;
import com.unam.mercadoenlinea.repository.IProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.Vector;

@Service
public class OpinionService implements IOpinionService {
	@Autowired
	IOpinionRepository iOpinionRepository;

	@Autowired
	IProductoRepository iProductoRepository;

	@Override
	public boolean saveOpinion(OpinionDto opinionDto) throws IOException {
		iOpinionRepository.save(this.dtoToEntity(opinionDto));
		return true;
	}

	@Override
	public List<OpinionDto> opinionsById(Long fk) {
		List<Opinion> opinions = iOpinionRepository.findByForeignKey(fk);
		List<OpinionDto> opinionDtos = new Vector<>();
		opinions.stream().forEach((opinion) -> { opinionDtos.add(this.entityToDto(opinion)); });

		return opinionDtos;
	}

	private Opinion dtoToEntity(OpinionDto opinionDto){
		//String titulo, String descripcion, Long calificacion, Producto producto
		Optional<Producto> producto = iProductoRepository.findById(opinionDto.getFk());
		Producto p = producto.isPresent()? producto.get() : null;
		return new Opinion(opinionDto.getTitulo(), opinionDto.getDescripcion(), opinionDto.getCalificacion(), p);
	}

	private OpinionDto entityToDto(Opinion opinion){
		return new OpinionDto(opinion.getId(), opinion.getTitulo(), opinion.getDescripcion(), opinion.getCalificacion(), opinion.getProducto().getId());
	}
}
