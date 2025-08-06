package med.voll.api.domain.appointment.validators;

import med.voll.api.domain.appointment.ScheduleAppointmentData;

public interface ScheduleAppointmentValidator {
    
    void validate(ScheduleAppointmentData data);
    
}
