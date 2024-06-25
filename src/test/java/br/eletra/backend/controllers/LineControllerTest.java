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
        LineEntity lineEntity = new LineEntity("Line0", (short) 0);

        when(repository.save(lineEntity)).thenReturn(lineEntity);

        // When
        LineEntity result = controller.postLineEntity(lineEntity);

        // Then
        assertThat(result).isEqualTo(lineEntity);
        verify(repository).save(lineEntity);
        verifyNoMoreInteractions(repository);
    }

    @Test
    void testDeleteLineEntity() {
        // Given
        LineEntity lineEntity = new LineEntity("Line0", (short) 0);

        when(repository.findByLineName("Line0")).thenReturn(lineEntity).thenReturn(null);
        doNothing().when(repository).delete(lineEntity);

        // When
        ResponseEntity<Boolean> result = controller.deleteLineEntity("Line0");

        // Then
        assertEquals(ResponseEntity.ok(true), result);
        verify(repository, times(2)).findByLineName("Line0");
        verify(repository).delete(lineEntity);
        verifyNoMoreInteractions(repository);
    }

    @Test
    void testDeleteLineEntityNotFound() {
        // Given
        when(repository.findByLineName("Line0")).thenReturn(null);

        // When
        ResponseEntity<Boolean> result = controller.deleteLineEntity("Line0");

        // Then
        assertEquals(404, result.getStatusCodeValue());
        assertEquals(false, result.getBody());
        verify(repository).findByLineName("Line0");
        verifyNoMoreInteractions(repository);
    }

    @Test
    void testPutLineEntity() {
        // Given
        LineEntity lineEntity = new LineEntity("Line0", (short) 0);

        when(repository.save(lineEntity)).thenReturn(lineEntity);

        // When
        LineEntity result = controller.updateLineEntity(lineEntity);

        // Then
        assertThat(result).isEqualTo(lineEntity);
        verify(repository).save(lineEntity);
        verifyNoMoreInteractions(repository);
    }
}
