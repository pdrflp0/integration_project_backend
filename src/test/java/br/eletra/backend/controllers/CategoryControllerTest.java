package br.eletra.backend.controllers;

import br.eletra.backend.entity.CategoryEntity;
import br.eletra.backend.entity.LineEntity;
import br.eletra.backend.services.CategoryServices;
import br.eletra.backend.repositories.CategoryRepository;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class CategoryControllerTest {

    @InjectMocks
    private CategoryController controller;

    @Mock
    private CategoryRepository repository;

    @Mock
    private CategoryServices service;

    @Test
    void testShouldReturnCategoryEntityList() {
        // Given
        List<CategoryEntity> mockCategoryList = new ArrayList<>();
        mockCategoryList.add(new CategoryEntity("Category0", (short) 0));
        mockCategoryList.add(new CategoryEntity("Category1", (short) 1));

        when(repository.findAll()).thenReturn(mockCategoryList);

        // When
        List<CategoryEntity> result = controller.getCategoryEntityList();

        // Then
        assertThat(result).isEqualTo(mockCategoryList);
        verify(repository).findAll();
        verifyNoMoreInteractions(repository);
    }

    @Test
    void testShouldReturnCategoryEntityListByLineName() {
        // Given
        List<CategoryEntity> mockCategoryList = new ArrayList<>();
        mockCategoryList.add(new CategoryEntity("Category0", (short) 0));
        mockCategoryList.add(new CategoryEntity("Category1", (short) 1));
        LineEntity line = new LineEntity("Line", (short) 0);

        when(service.getCategoriesByLineName("Line")).thenReturn(mockCategoryList);

        // When
        List<CategoryEntity> result = controller.getCategoriesByLine("Line");

        // Then
        assertThat(result).isEqualTo(mockCategoryList);
        verify(service).getCategoriesByLineName("Line");
        verifyNoMoreInteractions(service);
        verifyNoMoreInteractions(repository);
    }

    @Test
    void testShouldSaveAndReturnCategoryEntity() {
        // Given
        CategoryEntity mockCategory = new CategoryEntity("Category0", (short) 0);

        when(repository.save(mockCategory)).thenReturn(mockCategory);

        // When
        CategoryEntity result = controller.postCategoryEntity(mockCategory);

        // Then
        assertThat(result).isEqualTo(mockCategory);
        verify(repository).save(mockCategory);
        verifyNoMoreInteractions(repository);
    }

    @Test
    void testShouldDeleteCategoryEntity() {
        // Given
        CategoryEntity mockCategory = new CategoryEntity("Category0", (short) 0);

        when(repository.findByCategoryName("Category0")).thenReturn(null);

        // When
        ResponseEntity<Boolean> result = controller.deleteCategoryEntity("Category0");

        // Then
        assertEquals(HttpStatus.NOT_FOUND, result.getStatusCode());
        assertEquals(false, result.getBody());

        verify(repository, times(1)).findByCategoryName("Category0");
        verifyNoMoreInteractions(repository);
    }

    @Test
    void testShouldDeleteExistingCategoryEntity() {
        // Given
        CategoryEntity mockCategory = new CategoryEntity("Category0", (short) 0);
        when(repository.findByCategoryName("Category0")).thenReturn(mockCategory);
        doNothing().when(repository).delete(mockCategory);

        // When
        ResponseEntity<Boolean> result = controller.deleteCategoryEntity("Category0");

        // Then
        assertEquals(HttpStatus.OK, result.getStatusCode());
        assertEquals(true, result.getBody());

        verify(repository, times(1)).findByCategoryName("Category0");
        verify(repository, times(1)).delete(mockCategory);
        verifyNoMoreInteractions(repository);
    }

    @Test
    void testShouldUpdateAndReturnCategoryEntity() {
        // Given
        CategoryEntity mockCategory = new CategoryEntity("Category0", (short) 0);

        when(repository.save(mockCategory)).thenReturn(mockCategory);

        // When
        CategoryEntity result = controller.updateCategoryEntity(mockCategory);

        // Then
        assertThat(result).isEqualTo(mockCategory);
        verify(repository).save(mockCategory);
        verifyNoMoreInteractions(repository);
    }
}
