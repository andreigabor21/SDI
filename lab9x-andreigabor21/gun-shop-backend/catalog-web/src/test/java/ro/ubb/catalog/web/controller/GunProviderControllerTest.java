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
import ro.ubb.catalog.core.model.GunProvider;
import ro.ubb.catalog.core.model.GunType;
import ro.ubb.catalog.core.service.GunProviderService;
import ro.ubb.catalog.web.converter.GunProviderConverter;
import ro.ubb.catalog.web.dto.GunProviderDto;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.hamcrest.CoreMatchers.anyOf;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.MockitoAnnotations.initMocks;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

public class GunProviderControllerTest {

    private MockMvc mockMvc;

    @InjectMocks
    private GunProviderController gunProviderController;

    @Mock
    private GunProviderService gunProviderService;

    @Mock
    private GunProviderConverter gunProviderConverter;

    private GunProvider gunProvider1;
    private GunProvider gunProvider2;
    private GunProviderDto gunProviderDto1;
    private GunProviderDto gunProviderDto2;

    @Before
    public void setup() throws Exception {
        initMocks(this);
        this.mockMvc = MockMvcBuilders
                .standaloneSetup(gunProviderController)
                .build();
        initData();
    }

    @Test
    public void getGunProviders() throws Exception {
        List<GunProvider> gunProviders = Arrays.asList(gunProvider1, gunProvider2);
        Set<GunProviderDto> gunProviderDtos =
                new HashSet<>(Arrays.asList(gunProviderDto1, gunProviderDto2));
        when(gunProviderService.getAllGunProviders()).thenReturn(gunProviders);
        when(gunProviderConverter.convertModelsToDtos(gunProviders)).thenReturn(gunProviderDtos);

        ResultActions resultActions = mockMvc
                .perform(MockMvcRequestBuilders.get("/gun-providers"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].name", anyOf(is("gp1"), is("gp2"))))
                .andExpect(jsonPath("$[1].name", anyOf(is("gp1"), is("gp2"))));

        String result = resultActions.andReturn().getResponse().getContentAsString();
        System.out.println(result);

        verify(gunProviderService, times(1)).getAllGunProviders();
        verify(gunProviderConverter, times(1)).convertModelsToDtos(gunProviders);
        verifyNoMoreInteractions(gunProviderService, gunProviderConverter);
    }

    @Test
    public void add() throws Exception {
        GunProvider newGunProvider = GunProvider.builder()
                                                .name("gp1")
                                                .speciality("spec1")
                                                .reputation(3)
                                                .build();
        newGunProvider.setId(5L);
        GunProviderDto gunProviderDto = createGunProviderDto(newGunProvider);

        when(gunProviderConverter.convertDtoToModel(gunProviderDto)).thenReturn(newGunProvider);
        mockMvc.perform(MockMvcRequestBuilders
                .post("/gun-providers", gunProviderDto)
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(toJsonString(gunProviderDto)))
                .andExpect(status().isOk());
    }

    @Test
    public void delete() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                .delete("/gun-providers/{id}", gunProvider1.getId())
                .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk());
        verify(gunProviderService, times(1)).deleteGunProvider(gunProvider1.getId());
    }

    @Test
    public void update() throws Exception {
        when(gunProviderConverter.convertDtoToModel(gunProviderDto1)).thenReturn(gunProvider1);
        mockMvc.perform(MockMvcRequestBuilders
                .put("/gun-providers/{id}", gunProvider1.getId(), gunProviderDto1)
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(toJsonString(gunProviderDto1)))
                .andExpect(status().isOk());
    }

    private void initData() {
        gunProvider1 = GunProvider.builder()
                .name("gp1")
                .speciality("spec1")
                .reputation(3)
                .build();
        gunProvider1.setId(1L);
        gunProvider2 = GunProvider.builder()
                .name("gp2")
                .speciality("spec2")
                .reputation(4)
                .build();
        gunProvider2.setId(2L);
        System.out.println(gunProvider1);
        System.out.println(gunProvider2);

        gunProviderDto1 = createGunProviderDto(gunProvider1);
        gunProviderDto2 = createGunProviderDto(gunProvider2);
    }

    private GunProviderDto createGunProviderDto(GunProvider gunProvider) {
        GunProviderDto gunProviderDto = GunProviderDto.builder()
                .name(gunProvider.getName())
                .speciality(gunProvider.getSpeciality())
                .reputation(gunProvider.getReputation())
                .build();
        gunProviderDto.setId(gunProvider.getId());
        return gunProviderDto;
    }

    private String toJsonString(GunProviderDto gunProviderDto) {
        try {
            return new ObjectMapper().writeValueAsString(gunProviderDto);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
