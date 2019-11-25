package it.rud.rudmarket.service;

import it.rud.rudmarket.model.Sezione;
import it.rud.rudmarket.repository.SezioneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SezioneServiceImpl implements SezioneService {

	@Autowired
	SezioneRepository sezioneRepository;

	@Override
	public List<Sezione> getSezioni() {
		return sezioneRepository.findAll();
	}
}
