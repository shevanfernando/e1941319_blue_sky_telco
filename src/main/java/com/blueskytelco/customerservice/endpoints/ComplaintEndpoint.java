package com.blueskytelco.customerservice.endpoints;

import com.blueskytelco.customerservice.complaint.*;
import com.blueskytelco.customerservice.services.ComplaintService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class ComplaintEndpoint {

    private final ComplaintService complaintService;

    @Autowired
    public ComplaintEndpoint(ComplaintService complaintService) {
        this.complaintService = complaintService;
    }

    @PayloadRoot(namespace = "http://blueskytelco.com/customerservice/complaint", localPart = "GetComplainByIdRequest")
    @ResponsePayload
    public GetComplainByIdResponse getCompliantById(@RequestPayload GetComplainByIdRequest requestDTO) {
        GetComplainByIdResponse complainByIdResponse = new GetComplainByIdResponse();
        complainByIdResponse.setComplaint(complaintService.getComplaintById(requestDTO.getReferenceNumber()));
        return complainByIdResponse;
    }

    @PayloadRoot(namespace = "http://blueskytelco.com/customerservice/complaint", localPart = "NewComplaintRequest")
    @ResponsePayload
    public NewComplaintResponse addComplaintByE1941319(@RequestPayload NewComplaintRequest createDTO) {
        NewComplaintResponse newComplaintResponse = new NewComplaintResponse();
        newComplaintResponse.setMessage(complaintService.addComplaintByE1941319(createDTO.getComplaint()));
        return newComplaintResponse;
    }

    @PayloadRoot(namespace = "http://blueskytelco.com/customerservice/complaint", localPart = "GetStatusRequest")
    @ResponsePayload
    public GetStatusResponse getStatus(@RequestPayload GetStatusRequest requestDTO) {
        GetStatusResponse statusViewDTO = new GetStatusResponse();
        statusViewDTO.setStatus(complaintService.getStatus(requestDTO.getReferenceNumber()));
        return statusViewDTO;
    }

    @PayloadRoot(namespace = "http://blueskytelco.com/customerservice/complaint", localPart = "UpdateStatusRequest")
    @ResponsePayload
    public UpdateStatusResponse setStatus(@RequestPayload UpdateStatusRequest updateStatusRequest) {
        UpdateStatusResponse updateStatusResponse = new UpdateStatusResponse();
        updateStatusResponse.setMessage(complaintService.setStatus(updateStatusRequest.getReferenceNumber(), updateStatusRequest.isStatus()));
        return updateStatusResponse;
    }
}
