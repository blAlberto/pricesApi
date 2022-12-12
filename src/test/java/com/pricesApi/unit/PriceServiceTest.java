package com.pricesApi.unit;

import com.pricesApi.entity.Price;
import com.pricesApi.repository.PriceRepository;
import com.pricesApi.response.PriceResponse;
import com.pricesApi.service.PriceService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@RunWith(MockitoJUnitRunner.class)
public class PriceServiceTest {

    @Mock
    private PriceRepository priceRepository;

    @InjectMocks
    private PriceService priceService;

    @Test
    public void getProductPriceByDateOk() {
        Price queryResult = new Price();
        queryResult.setId(1L);
        PriceResponse result = new PriceResponse(queryResult);
        Mockito.when(priceRepository.findAllByProductIdBrandIdAndDate(Mockito.any(), Mockito.any(), Mockito.any())).thenReturn(queryResult);
        assertEquals(result.getId(), priceService.getProductPriceByDate(1L, 1L, LocalDateTime.now()).getId());
        assertEquals(result.getProductId(), priceService.getProductPriceByDate(1L, 1L, LocalDateTime.now()).getProductId());
    }

    @Test
    public void getProductPriceByDateOkEmpty() {
        Mockito.when(priceRepository.findAllByProductIdBrandIdAndDate(Mockito.any(), Mockito.any(), Mockito.any())).thenReturn(null);
        assertNull(priceService.getProductPriceByDate(1L, 1L, LocalDateTime.now()));
    }

    @Test(expected = IllegalArgumentException.class)
    public void getProductPriceByDateKo() {
        priceService.getProductPriceByDate(null, null, null);
    }
}
