package com.bank.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.entity.ApprovalRecord;
import com.bank.repository.ApprovalRecordRepository;

@Service
public class ApprovalRecordService {
	@Autowired
	private ApprovalRecordRepository approvalRecordRepository;

	public List<ApprovalRecord> getAllApprovalRecords() {
		return approvalRecordRepository.findAll();
	}

	public ApprovalRecord getApprovalRecord(Long id) {
		return approvalRecordRepository.findById(id).orElse(null);
	}

	public ApprovalRecord createApprovalRecord(ApprovalRecord approvalRecord) {
		return approvalRecordRepository.save(approvalRecord);
	}

	public ApprovalRecord updateApprovalRecord(Long id, ApprovalRecord approvalRecord) {
		approvalRecord.setId(id);
		return approvalRecordRepository.save(approvalRecord);
	}

	public void deleteApprovalRecord(Long id) {
		approvalRecordRepository.deleteById(id);
	}
}
