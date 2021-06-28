package ro.ubb.catalog.web.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import ro.ubb.catalog.core.model.Category;
import ro.ubb.catalog.core.model.GunType;
import ro.ubb.catalog.core.service.GunTypeService;
import ro.ubb.catalog.web.converter.GunTypeConverter;
import ro.ubb.catalog.web.dto.GunTypeDto;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.hamcrest.CoreMatchers.anyOf;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class GunTypeControllerTest {

    private MockMvc mockMvc;

    @InjectMocks
    private GunTypeController gunTypeController;

    @Mock
    private GunTypeService gunTypeService;

    @Mock
    private GunTypeConverter gunTypeConverter;

    private GunType gunType1;
    private GunType gunType2;
    private GunTypeDto gunTypeDto1;
    private GunTypeDto gunTypeDto2;

    @Before
    public void setup() throws Exception {
        initMocks(this);
        this.mockMvc = MockMvcBuilders
                .standaloneSetup(gunTypeController)
                .build();
        initData();
    }

    @Test
    public void getGunTypes() throws Exception {
        List<GunType> gunTypes = Arrays.asList(gunType1, gunType2);
        Set<GunTypeDto> gunTypeDtos =
                new HashSet<>(Arrays.asList(gunTypeDto1, gunTypeDto2));
        when(gunTypeService.getAllGunTypes()).thenReturn(gunTypes);
        when(gunTypeConverter.convertModelsToDtos(gunTypes)).thenReturn(gunTypeDtos);

        ResultActions resultActions = mockMvc
                .perform(MockMvcRequestBuilders.get("/gun-types"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].name", anyOf(is("gt1"), is("gt2"))))
                .andExpect(jsonPath("$[1].name", anyOf(is("gt1"), is("gt2"))));

        String result = resultActions.andReturn().getResponse().getContentAsString();
        System.out.println(result);

        verify(gunTypeService, times(1)).getAllGunTypes();
        verify(gunTypeConverter, times(1)).convertModelsToDtos(gunTypes);
        verifyNoMoreInteractions(gunTypeService, gunTypeConverter);
    }

    @Test
    public void delete() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                .delete("/gun-types/{id}", gunType1.getId())
                .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk());
        verify(gunTypeService, times(1)).deleteGunType(gunType1.getId());
    }

    @Test
    public void update() throws Exception {
        when(gunTypeConverter.convertDtoToModel(gunTypeDto1)).thenReturn(gunType1);
        mockMvc.perform(MockMvcRequestBuilders
                .put("/gun-types/{id}", gunType1.getId(), gunTypeDto1)
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(toJsonString(gunTypeDto1)))
                .andExpect(status().isOk());
    }

    private void initData() {
        gunType1 = GunType.builder()
                .name("gt1")
                .category(Category.PISTOL)
                .build();
        gunType1.setId(1L);
        gunType2 = GunType.builder()
                .name("gt2")
                .category(Category.RIFLE)
                .build();
        gunType2.setId(2L);
        System.out.println(gunType1);
        System.out.println(gunType2);

        gunTypeDto1 = createGunTypeDto(gunType1);
        gunTypeDto2 = createGunTypeDto(gunType2);
    }

    private GunTypeDto createGunTypeDto(GunType gunType) {
        GunTypeDto gunTypeDto = GunTypeDto.builder()
                .name(gunType.getName())
                .category(gunType.getCategory())
                .build();
        gunTypeDto.setId(gunType.getId());
        return gunTypeDto;
    }

    private String toJsonString(GunTypeDto gunTypeDto) {
        try {
            return new ObjectMapper().writeValueAsString(gunTypeDto);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
