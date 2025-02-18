package br.com.fiap.ms_email.core.port.in;

import br.com.fiap.ms_email.core.domain.Scheduling;

public interface EmailPortIn {

    void composeEmail(Scheduling scheduling);
}
