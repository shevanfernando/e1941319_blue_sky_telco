package com.blueskytelco.customerservice.services;

import com.blueskytelco.customerservice.complaint.Complaint;
import com.blueskytelco.customerservice.utilitize.ReferenceNumberGenerator;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Service
public class ComplaintService {

    private static final Map<Integer, Complaint> complaint_map = new LinkedHashMap<>();

    @PostConstruct
    public void initialize() {
        Complaint complaint_one = new Complaint();
        complaint_one.setReferenceNumber(1941319);
        complaint_one.setComplaint("Hotline numbers do not work on weekdays. It sometimes works, but it takes a long while to respond.");
        complaint_one.setStatus(true);
        complaint_map.put(complaint_one.getReferenceNumber(), complaint_one);

        Complaint complaint_second = new Complaint();
        complaint_second.setReferenceNumber(1941320);
        complaint_second.setComplaint("4G connection is not stable at all days.");
        complaint_second.setStatus(true);
        complaint_map.put(complaint_second.getReferenceNumber(), complaint_second);

        Complaint complaint_third = new Complaint();
        complaint_third.setReferenceNumber(1941321);
        complaint_third.setComplaint("Internet speed is too low when using the video stream services.");
        complaint_third.setStatus(false);
        complaint_map.put(complaint_third.getReferenceNumber(), complaint_third);

        Complaint complaint_fourth = new Complaint();
        complaint_fourth.setReferenceNumber(1941322);
        complaint_fourth.setComplaint("How do I deactivate the roaming service?");
        complaint_fourth.setStatus(false);
        complaint_map.put(complaint_fourth.getReferenceNumber(), complaint_fourth);
    }

    public Complaint getComplaintById(Integer reference_number) {
        return complaint_map.get(reference_number);
    }

    public List<Complaint> getAllComplaint() {
        return (List<Complaint>) complaint_map.values();
    }

    public String addComplaintByE1941319(String complaint) {
        ReferenceNumberGenerator generator = new ReferenceNumberGenerator(complaint_map);

        Complaint newComplaint = new Complaint();
        newComplaint.setReferenceNumber(generator.generateReferenceNumber());
        newComplaint.setComplaint(complaint);

        complaint_map.put(newComplaint.getReferenceNumber(), newComplaint);
        return String.format("Your complaint has been lodged. Reference number is %s", newComplaint.getReferenceNumber());
    }

    public Boolean getStatus(Integer referenceNumber) {
        return complaint_map.get(referenceNumber).isStatus();
    }

    public String setStatus(Integer referenceNumber, Boolean status) {
        Complaint complaint = complaint_map.get(referenceNumber);
        complaint.setStatus(status);
        return String.format("%s complaint, status update successfully.", complaint.getReferenceNumber());
    }
}
