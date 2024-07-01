package br.eletra.backend.services;

import br.eletra.backend.entity.CategoryEntity;
import br.eletra.backend.entity.LineEntity;
import br.eletra.backend.repositories.CategoryRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class CategoryServicesTest {

    @InjectMocks
    private CategoryServices categoryService;

    @Mock
    private CategoryRepository categoryRepository;

    @Mock
    private LineServices lineService;

    @Test
    void testFindCategoriesByLineName() {
        // Given
        LineEntity mockLine = new LineEntity("Line0", (short) 0);
        CategoryEntity mockCategory = new CategoryEntity("Cronos L", (short) 0);
        when(lineService.getLineIdByLineName(mockLine.getLineName())).thenReturn(mockLine.getId());
        when(categoryRepository.findByLineId(mockLine.getId())).thenReturn(Collections.singletonList(mockCategory));

        // When
        List<CategoryEntity> result = categoryService.getCategoriesByLineName(mockLine.getLineName());

        // Then
        assertThat(result).containsExactly(mockCategory);
        verify(lineService).getLineIdByLineName(mockLine.getLineName());
        verify(categoryRepository).findByLineId(mockLine.getId());
        verifyNoMoreInteractions(lineService, categoryRepository);
    }

    @Test
    void testFindCategoryIdByCategoryName() {
        // Given
        CategoryEntity mockCategory = new CategoryEntity("Cronos NG", (short) 0);
        when(categoryRepository.findByCategoryName(mockCategory.getCategoryName())).thenReturn(mockCategory);

        // When
        Short result = categoryService.getCategoryIdByCategoryName(mockCategory.getCategoryName());

        // Then
        assertThat(result).isEqualTo(mockCategory.getId());
        verify(categoryRepository).findByCategoryName(mockCategory.getCategoryName());
        verifyNoMoreInteractions(categoryRepository);
    }
}
