package br.eletra.backend.controllers;

import br.eletra.backend.entity.CategoryEntity;
import br.eletra.backend.entity.ModelEntity;
import br.eletra.backend.repositories.ModelRepository;
import br.eletra.backend.services.ModelServices;
import org.springframework.http.ResponseEntity;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ModelControllerTest {

    @InjectMocks
    ModelController controller;

    @Mock
    private ModelRepository repository;

    @Mock
    private ModelServices service;

    private CategoryEntity category;

    @Test
    void testGetModelEntityList() {
        // Given
        List<ModelEntity> mockModelList = new ArrayList<>();
        mockModelList.add(new ModelEntity("Model0", (short) 0));
        mockModelList.add(new ModelEntity("Model1", (short) 1));
        mockModelList.add(new ModelEntity("Model2", (short) 2));

        when(repository.findAll()).thenReturn(mockModelList);

        // When
        List<ModelEntity> result = controller.getModelEntityList();

        // Then
        assertThat(result).isEqualTo(mockModelList);
        verify(repository).findAll();
        verifyNoMoreInteractions(repository);
    }

    @Test
    void testGetModelEntityListByLineName() {
        // Given
        List<ModelEntity> mockModelList = new ArrayList<>();
        mockModelList.add(new ModelEntity("Model0", (short) 0));
        mockModelList.add(new ModelEntity("Model1", (short) 1));
        mockModelList.add(new ModelEntity("Model2", (short) 2));
        CategoryEntity category = new CategoryEntity("Category0", (short) 0);

        when(service.getModelNameByCategoryName("Category0")).thenReturn(mockModelList);

        // When
        List<ModelEntity> result = controller.getModelEntity("Category0");

        // Then
        assertThat(result).isEqualTo(mockModelList);
        verify(service).getModelNameByCategoryName("Category0");
        verifyNoMoreInteractions(service);
        verifyNoMoreInteractions(repository);
    }

    @Test
    void testPostModelEntity() {
        // Given
        ModelEntity mockModel = new ModelEntity("Model0", (short) 0);

        when(repository.save(mockModel)).thenReturn(mockModel);

        // When
        ModelEntity result = controller.postModelEntity(mockModel);

        // Then
        assertThat(result).isEqualTo(mockModel);
        verify(repository).save(mockModel);
        verifyNoMoreInteractions(repository);
    }

    @Test
    void testDeleteCategoryEntity() {
        // Given
        ModelEntity mockModel = new ModelEntity(category, "Model0", (short) 0);

        when(repository.findByModelName("Model0")).thenReturn(mockModel);

        // When
        ResponseEntity<Boolean> result = controller.deleteModelEntity("Model0");

        // Then
        assertEquals(ResponseEntity.ok(true), result);
        verify(repository).findByModelName("Model0");
        verify(repository).delete(mockModel);
        verifyNoMoreInteractions(repository);
    }

    @Test
    void testUpdateModelEntity() {
        // Given
        ModelEntity mockModel = new ModelEntity("Model0", (short) 0);

        when(repository.save(mockModel)).thenReturn(mockModel);

        // When
        ModelEntity result = controller.updateModelEntity(mockModel);

        // Then
        assertThat(result).isEqualTo(mockModel);
        verify(repository).save(mockModel);
        verifyNoMoreInteractions(repository);
    }
}
