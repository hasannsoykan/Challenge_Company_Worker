package com.enoca.challenge.api.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.enoca.challenge.business.abstracts.WorkerService;
import com.enoca.challenge.business.requests.CreateWorkerRequest;
import com.enoca.challenge.business.requests.UpdateWorkerRequest;
import com.enoca.challenge.business.responses.GetAllWorkersResponse;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/workers")
@AllArgsConstructor
public class WorkersController {

	private WorkerService workerService;

	@PostMapping("/add")
	public ResponseEntity<CreateWorkerRequest> add(@RequestBody @Valid CreateWorkerRequest createWorkerRequest) {
		workerService.add(createWorkerRequest);
		CreateWorkerRequest response = new CreateWorkerRequest(createWorkerRequest.getFirstName(),
				createWorkerRequest.getLastName(), createWorkerRequest.getCompanyId());
		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}

	@DeleteMapping("/delete/{id}")
	@ResponseStatus(value = HttpStatus.OK)
	public void delete(@PathVariable int id) {
		workerService.delete(id);
	}

	@PutMapping("/update")
	public ResponseEntity<UpdateWorkerRequest> update(@RequestBody @Valid UpdateWorkerRequest updateWorkerRequest) {

		workerService.update(updateWorkerRequest);
		UpdateWorkerRequest response = new UpdateWorkerRequest(updateWorkerRequest.getId(),
				updateWorkerRequest.getFirstName(), updateWorkerRequest.getLastName(),
				updateWorkerRequest.getCompanyId());
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}

	@GetMapping("/getall")
	public ResponseEntity<List<GetAllWorkersResponse>> getAll() {

		List<GetAllWorkersResponse> workers = workerService.getAll();
		return new ResponseEntity<List<GetAllWorkersResponse>>(workers, HttpStatus.OK);
	}
}
