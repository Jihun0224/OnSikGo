package com.ssafy.onsikgo.controller;

import com.ssafy.onsikgo.dto.SaleItemDto;
import com.ssafy.onsikgo.dto.SelectDto;
import com.ssafy.onsikgo.service.SaleService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@CrossOrigin(origins = { "*" }, maxAge = 6000)
@RestController
@Slf4j
@RequestMapping("/api/sale")
@RequiredArgsConstructor
public class SaleController {

    private final SaleService saleService;

    @PostMapping("/{store_id}")
    public ResponseEntity<String> register(@RequestBody SaleItemDto saleItemDto, @PathVariable Long store_id) {
        return saleService.register(saleItemDto, store_id);
    }

    @GetMapping("/list/{store_id}")
    public ResponseEntity<List<SaleItemDto>> getSaleItemList(@PathVariable Long store_id) {
        return saleService.getSaleItemDtoList(saleService.getSaleItemList(store_id));
    }

    @PutMapping("/{sale_item_id}")
    public ResponseEntity<String> updateStock(@RequestBody HashMap<String,Integer> map, @PathVariable Long sale_item_id) {
        return saleService.updateStock(map,sale_item_id);
    }

    @GetMapping("/{item_id}")
    public ResponseEntity<SaleItemDto> getSaleItemInfo(@PathVariable Long item_id) {
        return saleService.getSaleItemInfo(item_id);
    }

    @PostMapping("/keyword")
    public ResponseEntity<List<SaleItemDto>> getSaleItemKeyword(@RequestBody SelectDto selectDto) {
        return saleService.getSaleItemKeyword(selectDto);
    }

}
