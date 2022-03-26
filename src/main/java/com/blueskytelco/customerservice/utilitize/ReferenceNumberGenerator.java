package com.blueskytelco.customerservice.utilitize;

import com.blueskytelco.customerservice.complaint.Complaint;

import java.util.Map;

public class ReferenceNumberGenerator {
    private final Map<Integer, Complaint> compliant;

    public ReferenceNumberGenerator(Map<Integer, Complaint> compliant) {
        this.compliant = compliant;
    }

    public Integer generateReferenceNumber() {
        Object[] key_set = compliant.keySet().toArray();
        return (Integer) key_set[key_set.length - 1] + 1;
    }
}
