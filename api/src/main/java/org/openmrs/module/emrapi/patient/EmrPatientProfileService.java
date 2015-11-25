package org.openmrs.module.emrapi.patient;

import java.util.List;

public interface EmrPatientProfileService {
    PatientProfile save(PatientProfile patientProfile);
    PatientProfile get(String patientUuid);
    List<PatientProfile> getAllPatients();
}
