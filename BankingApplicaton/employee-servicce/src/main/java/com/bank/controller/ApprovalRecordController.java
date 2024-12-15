package com.bank.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bank.entity.ApprovalRecord;
import com.bank.service.ApprovalRecordService;

@RestController
@RequestMapping("/api/approvals")
public class ApprovalRecordController {
	@Autowired
	private ApprovalRecordService approvalRecordService;

	@GetMapping
	public List<ApprovalRecord> getAllApprovalRecords() {
		return approvalRecordService.getAllApprovalRecords();
	}

	@GetMapping("/{id}")
	public ResponseEntity<ApprovalRecord> getApprovalRecord(@PathVariable Long id) {
		return ResponseEntity.ok(approvalRecordService.getApprovalRecord(id));
	}

	@PostMapping
	public ResponseEntity<ApprovalRecord> createApprovalRecord(@RequestBody ApprovalRecord approvalRecord) {
		ApprovalRecord createdRecord = approvalRecordService.createApprovalRecord(approvalRecord);
		return ResponseEntity.status(HttpStatus.CREATED).body(createdRecord);
	}

	@PutMapping("/{id}")
	public ResponseEntity<ApprovalRecord> updateApprovalRecord(@PathVariable Long id,
			@RequestBody ApprovalRecord approvalRecord) {
		return ResponseEntity.ok(approvalRecordService.updateApprovalRecord(id, approvalRecord));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteApprovalRecord(@PathVariable Long id) {
		approvalRecordService.deleteApprovalRecord(id);
		return ResponseEntity.noContent().build();
	}

}
