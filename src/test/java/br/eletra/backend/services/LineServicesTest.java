package br.eletra.backend.services;

import br.eletra.backend.entity.LineEntity;
import br.eletra.backend.repositories.LineRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class LineServicesTest {

    @InjectMocks
    private LineServices service;

    @Mock
    private LineRepository lineRepository;

    @Test
    void testFindLineByLineName() {
        // Given
        LineEntity mockLine = new LineEntity("Cronos", (short) 0);
        when(lineRepository.findByLineName(mockLine.getLineName())).thenReturn(mockLine);

        // When
        Short result = service.getLineIdByLineName(mockLine.getLineName());

        // Then
        assertThat(result).isEqualTo(mockLine.getId());
        verify(lineRepository).findByLineName(mockLine.getLineName());
        verifyNoMoreInteractions(lineRepository);
    }
}
