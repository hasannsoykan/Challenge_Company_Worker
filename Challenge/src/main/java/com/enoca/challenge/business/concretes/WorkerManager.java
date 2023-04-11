package com.enoca.challenge.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.enoca.challenge.business.abstracts.WorkerService;
import com.enoca.challenge.business.requests.CreateWorkerRequest;
import com.enoca.challenge.business.requests.UpdateWorkerRequest;
import com.enoca.challenge.business.responses.GetAllWorkersResponse;
import com.enoca.challenge.core.utilities.mappers.ModelMapperService;
import com.enoca.challenge.dataAccess.abstracts.WorkerRepository;
import com.enoca.challenge.entities.concretes.Worker;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class WorkerManager implements WorkerService {

	private WorkerRepository workerRepository;
	private ModelMapperService modelMapperService;

	@Override
	public void add(CreateWorkerRequest createWorkerRequest) {
		Worker worker = modelMapperService.forRequest().map(createWorkerRequest, Worker.class);
		workerRepository.save(worker);
	}

	@Override
	public void delete(int id) {
		workerRepository.deleteById(id);
	}

	@Override
	public void update(UpdateWorkerRequest updateWorkerRequest) {
		Worker worker = modelMapperService.forRequest().map(updateWorkerRequest, Worker.class);
		workerRepository.save(worker);

	}

	@Override
	public List<GetAllWorkersResponse> getAll() {

		List<Worker> workers = workerRepository.findAll();
		List<GetAllWorkersResponse> workersResponse = workers.stream()
				.map(worker -> modelMapperService.forResponse().map(worker, GetAllWorkersResponse.class))
				.collect(Collectors.toList());

		return workersResponse;
	}

}
