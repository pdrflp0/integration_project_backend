package br.eletra.backend.controllers;

import br.eletra.backend.entity.LineEntity;
import br.eletra.backend.repositories.LineRepository;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class LineControllerTest {

    @InjectMocks
    LineController controller;

    @Mock
    private LineRepository repository;

    @Test
    void testGetLineEntityList() {
        // Given
        List<LineEntity> mockLineList = new ArrayList<>();
        mockLineList.add(new LineEntity("Line0", (short) 0));
        mockLineList.add(new LineEntity("Line1", (short) 1));

        when(repository.findAll()).thenReturn(mockLineList);

        // When
        List<LineEntity> result = controller.getLineEntityList();

        // Then
        assertThat(result).isEqualTo(mockLineList);
        verify(repository).findAll();
        verifyNoMoreInteractions(repository);
    }

    @Test
    void testGetLineEntity() {
        // Given
        LineEntity mockLine = new LineEntity("Line0", (short) 0);

        when(repository.findByLineName("Line0")).thenReturn(mockLine);

        // When
        LineEntity result = controller.getLineEntity("Line0");

        // Then
        assertThat(result).isEqualTo(mockLine);
        verify(repository).findByLineName("Line0");
        verifyNoMoreInteractions(repository);
    }

    @Test
    void testPostLineEntity() {
        // Given
        LineEntity mockLine = new LineEntity("Line0", (short) 0);

        when(repository.save(mockLine)).thenReturn(mockLine);

        // When
        LineEntity result = controller.postLineEntity(mockLine);

        // Then
        assertThat(result).isEqualTo(mockLine);
        verify(repository).save(mockLine);
        verifyNoMoreInteractions(repository);
    }

    @Test
    void testDeleteLineEntity() {
        // Given
        LineEntity mockLine = new LineEntity("Line0", (short) 0);

        when(repository.findByLineName("Line0")).thenReturn(mockLine).thenReturn(null);
        doNothing().when(repository).delete(mockLine);

        // When
        ResponseEntity<Boolean> result = controller.deleteLineEntity("Line0");

        // Then
        assertEquals(ResponseEntity.ok(true), result);
        verify(repository, times(2)).findByLineName("Line0");
        verify(repository).delete(mockLine);
        verifyNoMoreInteractions(repository);
    }

    @Test
    void testPutLineEntity() {
        // Given
        LineEntity mockLine = new LineEntity("Line0", (short) 0);

        when(repository.save(mockLine)).thenReturn(mockLine);

        // When
        LineEntity result = controller.updateLineEntity(mockLine);

        // Then
        assertThat(result).isEqualTo(mockLine);
        verify(repository).save(mockLine);
        verifyNoMoreInteractions(repository);
    }
}
