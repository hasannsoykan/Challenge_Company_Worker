package com.enoca.challenge.business.abstracts;

import java.util.List;

import com.enoca.challenge.business.requests.CreateWorkerRequest;
import com.enoca.challenge.business.requests.UpdateWorkerRequest;
import com.enoca.challenge.business.responses.GetAllWorkersResponse;

public interface WorkerService {

	void add(CreateWorkerRequest createWorkerRequest);
	void delete(int id);
	void update(UpdateWorkerRequest updateWorkerRequest);
	List<GetAllWorkersResponse> getAll();
}
