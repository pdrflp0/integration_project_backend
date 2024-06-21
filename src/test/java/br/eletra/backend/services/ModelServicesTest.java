package br.eletra.backend.services;

import br.eletra.backend.entity.CategoryEntity;
import br.eletra.backend.entity.ModelEntity;
import br.eletra.backend.repositories.ModelRepository;
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
public class ModelServicesTest {

    @InjectMocks
    private ModelServices modelService;

    @Mock
    private ModelRepository modelRepository;

    @Mock
    private CategoryServices categoryService;

    @Test
    public void testSearchModelNameByCategoryName() {
        // Given
        ModelEntity mockModel = new ModelEntity("Cronos 6001‑A", (short) 1);
        CategoryEntity mockCategory = new CategoryEntity("Cronos Old", (short) 0);

        when(categoryService.getCategoryIdByCategoryName(mockCategory.getCategoryName())).thenReturn(mockCategory.getId());
        when(modelRepository.findByCategoryId(mockCategory.getId())).thenReturn(Collections.singletonList(mockModel));

        // When
        List<ModelEntity> result = modelService.getModelNameByCategoryName(mockCategory.getCategoryName());

        // Then
        assertThat(result).containsExactly(mockModel);
        verify(modelRepository).findByCategoryId(mockCategory.getId());
        verifyNoMoreInteractions(modelRepository);
        verify(categoryService).getCategoryIdByCategoryName(mockCategory.getCategoryName());
        verifyNoMoreInteractions(categoryService);
    }
}
